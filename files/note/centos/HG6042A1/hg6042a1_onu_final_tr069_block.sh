#!/bin/sh

# Run this on the HG6042A1 after telnet login and `su`.
# It disables the TR-069 ACS endpoint without touching read-only firmware files.

export PATH=/fhrom/fhshell:/usr/bin:/usr/sbin:/bin:/sbin:/fhrom/bin:$PATH
export LD_LIBRARY_PATH=/lib:/usr/lib:/fhrom/lib:/usr/lib/glib-2.0:$LD_LIBRARY_PATH

BACKUP_FILE="/fhconf/tr069_url_backup_manual"
DISABLED_URL="http://127.0.0.1/disabled"

echo "== backup current ACS URL =="
if [ ! -f "$BACKUP_FILE" ]; then
    cfg_cmd get InternetGatewayDevice.ManagementServer.URL | sed -n 's/^get success!value=//p' > "$BACKUP_FILE"
fi
cat "$BACKUP_FILE" 2>/dev/null

echo
echo "== disable TR-069 ACS and periodic inform =="
cfg_cmd set InternetGatewayDevice.ManagementServer.URL "$DISABLED_URL"
cfg_cmd set InternetGatewayDevice.ManagementServer.PeriodicInformEnable 0

echo
echo "== restart tr069 process so it reloads config =="
pidof tr069 | xargs kill -9 2>/dev/null
sleep 15

echo
echo "== verify config =="
cfg_cmd get InternetGatewayDevice.ManagementServer.URL
cfg_cmd get InternetGatewayDevice.ManagementServer.PeriodicInformEnable

echo
echo "== verify process and outbound connections =="
ps | grep tr069 | grep -v grep
netstat -anp 2>/dev/null | grep 8088
netstat -anp 2>/dev/null | grep 7547

echo
echo "== PON quick status =="
cfg_cmd get InternetGatewayDevice.WANDevice.1.WANCommonInterfaceConfig.WANAccessType
cfg_cmd get InternetGatewayDevice.WANDevice.1.WANCommonInterfaceConfig.PhysicalLinkStatus
cat /proc/pon_phy/LOS 2>/dev/null

echo
echo "Done."
echo "Restore ACS URL with:"
echo "cfg_cmd set InternetGatewayDevice.ManagementServer.URL \"\$(cat $BACKUP_FILE)\""
