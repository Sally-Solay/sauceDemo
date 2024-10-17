package utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties property;

    public void initializePropertyFile() throws IOException {
        property = new Properties();
        InputStream is = this.getClass().getClassLoader()
                .getResourceAsStream("application.properties");
        property.load(is);
    }



    public  String getProperty(String propertyName) {
        return this.property.getProperty(propertyName);
    }

    public String setProperty(String propertyName, String value) {
        return (String) this.property.setProperty(propertyName, value);
    }
}
