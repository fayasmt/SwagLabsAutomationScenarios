/*
 * This class contains the methods written for Login Page of the Swag Labs application
 * Designer: Fayas MT
 * Date: 27-Sep-2021
 */

package pages.SwagLabs_LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.ReadPropertyFile;
import utilities.BrowserConnection;

public class UserLogin_Scenarios extends BrowserConnection{
	
	ReadPropertyFile objrpf = new ReadPropertyFile();
	
	String projectDirectory = System.getProperty("user.dir");
	String locatorsPropertyFilePath = projectDirectory+"\\src\\test\\java\\pages\\SwagLabs_LoginPage\\locators.properties";
	String testDataPropertyFilePath = projectDirectory+"\\src\\test\\java\\pages\\SwagLabs_LoginPage\\testData.properties";
	
	//This method is written for the test case where the Login with valid user is validated 
	public void tc01_ValidateValidUser() throws IOException {
		
		WebElement login_Username_Input;
		WebElement login_Password_Input;
		WebElement login_Button;
		
		String actualAppTitle;
		String expectedAppTitle;
			
		browserDriverConnect();
					
		login_Username_Input= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Username_Input")));	
		login_Username_Input.sendKeys(objrpf.readPropFile(testDataPropertyFilePath, "login_ValidUsername_Value"));
		login_Password_Input= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Password_Input")));
		login_Password_Input.sendKeys(objrpf.readPropFile(testDataPropertyFilePath, "login_ValidPassword_Value"));
		login_Button= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Button")));
		login_Button.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		actualAppTitle = driver.getTitle().toString();
		expectedAppTitle = objrpf.readPropFile(testDataPropertyFilePath, "expectedAppTitle");
		Assert.assertEquals(actualAppTitle, expectedAppTitle);
		
		driver.close();
	}
	
	//This method is written for the test case where the Login with valid username and invalid password is validated 
	public void tc02_ValidateValidUserWithInvalidPassword() throws IOException {
		
		WebElement login_Username_Input;
		WebElement login_Password_Input;
		WebElement login_Button;
		WebElement login_InvalidPassword_Label;
		
		String actualInvalidPasswordLogin_Text;
		String expectedInvalidPasswordLogin_Text;
			
		browserDriverConnect();
					
		login_Username_Input= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Username_Input")));	
		login_Username_Input.sendKeys(objrpf.readPropFile(testDataPropertyFilePath, "login_ValidUsername_Value"));
		login_Password_Input= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Password_Input")));
		login_Password_Input.sendKeys(objrpf.readPropFile(testDataPropertyFilePath, "login_InvalidPassword_Value"));
		login_Button= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Button")));
		login_Button.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login_InvalidPassword_Label = driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_InvalidPassword_Label")));
		
		actualInvalidPasswordLogin_Text = login_InvalidPassword_Label.getText();
		expectedInvalidPasswordLogin_Text = objrpf.readPropFile(testDataPropertyFilePath, "expectedInvalidPasswordLogin_Text");
		Assert.assertEquals(actualInvalidPasswordLogin_Text, expectedInvalidPasswordLogin_Text);	
		
		driver.close();
	}
	
	//This method is written for the test case where locked out user login is validated 
	public void tc03_ValidateLockedOutUserLogin() throws IOException {
				
		WebElement login_Username_Input;
		WebElement login_Password_Input;
		WebElement login_Button;
		WebElement login_InvalidPassword_Label;
		
		String actuallockedOutLoginUserLogin_Text;
		String expectedlockedOutLoginUserLogin_Text;
			
		browserDriverConnect();
					
		login_Username_Input= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Username_Input")));	
		login_Username_Input.sendKeys(objrpf.readPropFile(testDataPropertyFilePath, "login_LockedOutUsername_Value"));
		login_Password_Input= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Password_Input")));
		login_Password_Input.sendKeys(objrpf.readPropFile(testDataPropertyFilePath, "login_ValidPassword_Value"));
		login_Button= driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_Button")));
		login_Button.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login_InvalidPassword_Label = driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "login_InvalidPassword_Label")));
		
		actuallockedOutLoginUserLogin_Text = login_InvalidPassword_Label.getText();
		expectedlockedOutLoginUserLogin_Text = objrpf.readPropFile(testDataPropertyFilePath, "expectedlockedOutLoginUserLogin_Text");
		Assert.assertEquals(actuallockedOutLoginUserLogin_Text, expectedlockedOutLoginUserLogin_Text);
		
		driver.close();
	}
}
