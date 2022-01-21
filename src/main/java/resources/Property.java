package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Fetches the value for the specified key from the globalproperties file
public class Property {

	public String getProperty(String key) throws IOException {

		Properties instance = new Properties();
		FileInputStream input = new FileInputStream("D:\\Rest Assured\\APIAutomation\\globalproperties.properties");
		instance.load(input);
		return instance.getProperty(key);
	}
}
