package base_utility_Module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base_class {
	
	public static Properties properties;
	
	public static String getpropertyvalue(String key) throws IOException {
		
		properties = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\user\\git\\Amazon_Framewor\\src\\test\\resources\\Property_File_Only\\Property_Amazon.properties");
		
		properties.load(file);
		
		return properties.getProperty(key);
	}
}
