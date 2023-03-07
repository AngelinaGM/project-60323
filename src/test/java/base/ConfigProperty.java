package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;


public class ConfigProperty {
    public static Properties properties = new Properties();

    public static void initProperties() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String configPath = rootPath + "config.properties";
        try {
            FileInputStream inputStream = new FileInputStream(configPath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
