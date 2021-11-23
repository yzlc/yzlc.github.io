package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static String readValue(String filePath, String key) {
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getResourceAsStream(filePath);
            if (in != null) {
                prop.load(in);
            }
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
