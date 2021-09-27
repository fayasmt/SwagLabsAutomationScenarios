/*
 * This class contains the generic methods which shall be re-used//
 * Designer: Fayas MT
 * Date: 27-Sep-2021
 */
package utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ReadPropertyFile;

public class BrowserConnection { 
	
	ReadPropertyFile objrpf = new ReadPropertyFile();

	String projectDirectory = System.getProperty("user.dir");
	String propertyFilePath = projectDirectory+"\\src\\test\\java\\utilities\\browserAndLoginDetails.properties";	
	
	public WebDriver driver;
		
	//This method is used to launch the application 
	public void browserDriverConnect() throws IOException {
		System.setProperty("webdriver.chrome.driver",projectDirectory+"\\src\\chromedriver.exe");
		String swagLabsUrl = objrpf.readPropFile(propertyFilePath,"swagLabsUrl");
		driver = new ChromeDriver();
		driver.get(swagLabsUrl);
		driver.manage().window().maximize();
	} 
}
