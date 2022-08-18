package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropFile {

    static Properties prop = new Properties();

    public static String ReadConfig(String value) throws IOException {
        String OSConfiguration = getOSProp();
        InputStream osProperties = new FileInputStream((System.getProperty("user.dir") + "/src/test/resources/" + OSConfiguration));
        Properties prop = ReadPropFile.loadPropertiesFile("config.properties");

        // Prints out configuration properties for the environment [ uncomment only for debugging]
        // prop.forEach((k, v) -> System.out.println(k + ":" + v));

        // Loads OS properties of either mac, windows, linux
        prop.load(osProperties);
        value = prop.getProperty(value);
        return value;
    }

    public static String getOSProp() {
        switch (OSConfiguration.getOS()) {
            case WINDOWS:
                return "config.windows.properties";
            case LINUX:
                return "config.linux.properties";
            case MAC:
                return "config.mac.properties";
            default:
               return "config.local.properties";
        }
    }

    public static Properties loadPropertiesFile(String filePath) {

        try (InputStream resourceAsStream = ReadPropFile.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}
