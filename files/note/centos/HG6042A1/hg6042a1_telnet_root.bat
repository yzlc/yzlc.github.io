@echo off
setlocal
powershell -NoProfile -ExecutionPolicy Bypass -Command "$p='%~f0'; $m='### POWERSHELL ###'; $s=Get-Content -Raw -LiteralPath $p; $i=$s.LastIndexOf($m); if($i -lt 0){throw 'PowerShell payload marker not found'}; Invoke-Expression $s.Substring($i + $m.Length)"
exit /b %ERRORLEVEL%

### POWERSHELL ###
$ErrorActionPreference = "Stop"

$HostName = "192.168.1.1"
$Port = 23
$Mac = "REPLACE_WITH_ONU_MAC_NO_COLON"
$MacLast6 = $Mac.Substring($Mac.Length - 6)
$EnableTelnetFirst = $true
$TelnetEnableUrl = "http://192.168.1.1/cgi-bin/telnetenable.cgi?telnetenable=1&key=$Mac"
$Username = "admin"
$Password = "Fh@$MacLast6"
$SuPassword = "hg2x0$MacLast6"

$Encoding = [System.Text.Encoding]::ASCII

if ($EnableTelnetFirst) {
    try {
        Write-Host "Enabling telnet ..."
        Invoke-WebRequest -UseBasicParsing -Uri $TelnetEnableUrl -TimeoutSec 4 | Out-Null
        Start-Sleep -Seconds 1
    }
    catch {
        Write-Host "Telnet enable URL failed, trying direct telnet anyway."
    }
}

$client = [System.Net.Sockets.TcpClient]::new()
$client.NoDelay = $true
$client.Connect($HostName, $Port)
$stream = $client.GetStream()

function Send-Bytes([byte[]]$Bytes) {
    if ($Bytes.Length -gt 0) {
        $stream.Write($Bytes, 0, $Bytes.Length)
        $stream.Flush()
    }
}

function Send-Text([string]$Text) {
    Send-Bytes $Encoding.GetBytes($Text)
}

function Send-Line([string]$Text) {
    Send-Text ($Text + "`r`n")
    Start-Sleep -Milliseconds 250
}

function Read-TelnetByte {
    $b = $stream.ReadByte()
    if ($b -lt 0) { return $null }

    # TELNET IAC negotiation.
    if ($b -eq 255) {
        $cmd = $stream.ReadByte()
        if ($cmd -lt 0) { return $null }

        if ($cmd -eq 250) {
            $prev = 0
            while ($true) {
                $x = $stream.ReadByte()
                if ($x -lt 0) { break }
                if ($prev -eq 255 -and $x -eq 240) { break }
                $prev = $x
            }
            return $null
        }

        $opt = $stream.ReadByte()
        if ($opt -lt 0) { return $null }

        # DO -> WONT, WILL -> DONT. Keep the session simple/raw.
        if ($cmd -eq 253) { Send-Bytes ([byte[]](255, 252, $opt)) }
        elseif ($cmd -eq 251) { Send-Bytes ([byte[]](255, 254, $opt)) }
        return $null
    }

    return [byte]$b
}

function Read-Remote([int]$TimeoutMs = 1000) {
    $deadline = [DateTime]::UtcNow.AddMilliseconds($TimeoutMs)
    $buffer = New-Object System.Collections.Generic.List[byte]

    while ([DateTime]::UtcNow -lt $deadline) {
        while ($stream.DataAvailable) {
            $b = Read-TelnetByte
            if ($null -ne $b) {
                $buffer.Add($b) | Out-Null
            }
        }
        Start-Sleep -Milliseconds 40
    }

    if ($buffer.Count -gt 0) {
        $text = $Encoding.GetString($buffer.ToArray())
        [Console]::Write($text)
        return $text
    }
    return ""
}

function Send-Key($Key) {
    if (($Key.Modifiers -band [ConsoleModifiers]::Control) -and $Key.Key -eq "C") {
        Send-Bytes ([byte[]](3))
        return
    }

    if (($Key.Modifiers -band [ConsoleModifiers]::Control) -and ([int][char]$Key.KeyChar -eq 29)) {
        throw "UserExit"
    }

    switch ($Key.Key) {
        "Enter"      { Send-Text "`r`n"; return }
        "Backspace"  { Send-Bytes ([byte[]](127)); return }
        "Tab"        { Send-Bytes ([byte[]](9)); return }
        "Escape"     { Send-Bytes ([byte[]](27)); return }
        "UpArrow"    { Send-Text "$([char]27)[A"; return }
        "DownArrow"  { Send-Text "$([char]27)[B"; return }
        "RightArrow" { Send-Text "$([char]27)[C"; return }
        "LeftArrow"  { Send-Text "$([char]27)[D"; return }
        "Delete"     { Send-Text "$([char]27)[3~"; return }
        "Home"       { Send-Text "$([char]27)[H"; return }
        "End"        { Send-Text "$([char]27)[F"; return }
    }

    if ([int][char]$Key.KeyChar -ne 0) {
        Send-Text ([string]$Key.KeyChar)
    }
}

try {
    Write-Host "Connecting to ${HostName}:$Port ..."
    [void](Read-Remote 1500)
    Send-Line $Username
    [void](Read-Remote 900)
    Send-Line $Password
    [void](Read-Remote 1400)
    Send-Line "su"
    [void](Read-Remote 900)
    Send-Line $SuPassword
    [void](Read-Remote 1500)

    Write-Host ""
    Write-Host "Logged in. Press Ctrl+] to close this telnet window."

    while ($client.Connected) {
        while ($stream.DataAvailable) {
            $b = Read-TelnetByte
            if ($null -ne $b) {
                [Console]::Write([char]$b)
            }
        }

        if ([Console]::KeyAvailable) {
            $key = [Console]::ReadKey($true)
            Send-Key $key
        }

        Start-Sleep -Milliseconds 20
    }
}
catch {
    if ($_.Exception.Message -ne "UserExit") {
        Write-Host ""
        Write-Host "Session ended: $($_.Exception.Message)"
    }
}
finally {
    if ($stream) { $stream.Dispose() }
    if ($client) { $client.Close() }
}




