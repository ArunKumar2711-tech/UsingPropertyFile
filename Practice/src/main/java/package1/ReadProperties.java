package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	private static Properties proper = new Properties();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	}

	
	
	public static void read() throws IOException {
		 //Properties proper = new Properties();
		String Filepath = System.getProperty("user.dir")+"\\Config\\config.properties";
		FileInputStream file = new FileInputStream(Filepath);
		proper.load(file);
		
		//String USERNAME = proper.getProperty("username");
		
		}
	
	public String getUsername() {
        return proper.getProperty("username");
    }

    public String getPassword() {
        return proper.getProperty("password");
    }
}
