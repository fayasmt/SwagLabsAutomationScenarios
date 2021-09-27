/*
 * This class contains the generic methods which shall be re-used
 * Designer: Fayas MT
 * Date: 27-Sep-2021
 */

package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	
	String propertyFileValue;
	
	//This method is used to access property files, it accepts the property file's path and key as inputs and returns the actual value of the key given 
	public String readPropFile(String directoryPath, String propertyKey) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(directoryPath);
		prop.load(fis);
		propertyFileValue = prop.getProperty(propertyKey);
		
		return propertyFileValue;
		
	}

}
