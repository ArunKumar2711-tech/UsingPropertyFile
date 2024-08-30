package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config_Reader {
    private Properties properties;
	public  Properties getPropertyObject() throws IOException {
		FileInputStream fis =new FileInputStream("Config\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}

	
    public String getProperty(String key) {
        return properties.getProperty(key);
        }
	
	
}
	
	




