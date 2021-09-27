/*
 * This class contains the methods written for Products page of the Swag Labs application
 * Designer: Fayas MT
 * Date: 27-Sep-2021
 */


package pages.SwagLabs_ProductsPage;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages.SwagLabs_LoginPage.UserLogin_Scenarios;
import utilities.ReadPropertyFile;
import utilities.BrowserConnection;

public class SortProducts_Scenarios extends BrowserConnection{
	
	ReadPropertyFile objrpf = new ReadPropertyFile();
	UserLogin_Scenarios objUserLogin_Scenarios = new UserLogin_Scenarios();
	
	String projectDirectory = System.getProperty("user.dir");
	String locatorsPropertyFilePath = projectDirectory+"\\src\\test\\java\\pages\\SwagLabs_ProductsPage\\locators.properties";
	String testDataPropertyFilePath = projectDirectory+"\\src\\test\\java\\pages\\SwagLabs_ProductsPage\\testData.properties";
	
	//This method is written for the test case where the Sort option from Low to High is validated
	public void tc01_VerifySortPriceLowToHigh() throws IOException {
		
		List<WebElement> itemPriceLabel;	
		String itemPriceValue_Xpath_Final;
		String itemPriceValue_Xpath_Temp;
		String itemPriceValue_Xpath;
		String itemPriceValue;
		String itemPrice_Split;
		double itemPrice_SplitValue;
		String itemPriceValueTemp;
		String itemPrice_SplitTemp;
		double itemPrice_SplitValueTemp;
		int j;
		
		generalLogin();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select prodDropdown = new Select(driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "productsSort_dropdown"))));
		prodDropdown.selectByVisibleText(objrpf.readPropFile(testDataPropertyFilePath, "productsSort_dropdown_Value_PriceLowToHigh"));
		itemPriceLabel = driver.findElements(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "itemPriceLabel")));
		itemPriceValue_Xpath=objrpf.readPropFile(locatorsPropertyFilePath, "itemPriceLabel");
		
		for (int i=1;i<=itemPriceLabel.size();i++) {
			itemPriceValue_Xpath_Final = "("+itemPriceValue_Xpath+")["+i+"]";
			itemPriceValue = driver.findElement(By.xpath(itemPriceValue_Xpath_Final)).getText();
			itemPrice_Split = itemPriceValue.substring(1);
			itemPrice_SplitValue = Double.parseDouble(itemPrice_Split);
			
			if(i>1) {
			
			j=i-1;
			
			itemPriceValue_Xpath_Temp = "("+itemPriceValue_Xpath+")["+j+"]";
			itemPriceValueTemp = driver.findElement(By.xpath(itemPriceValue_Xpath_Temp)).getText();
			itemPrice_SplitTemp = itemPriceValueTemp.substring(1);
			itemPrice_SplitValueTemp = Double.parseDouble(itemPrice_SplitTemp);
			
			if (itemPrice_SplitValue>=itemPrice_SplitValueTemp) {

			Assert.assertTrue(true);
			}
			
			else {
				Assert.assertTrue(false);
			}
			
			}
			}	
		
			driver.close();
		}
	
	//This method is written for the test case where the Sort option from High to Low is validated
	public void tc02_VerifySortPriceHighToLow() throws IOException {
		
		List<WebElement> itemPriceLabel;	
		String itemPriceValue_Xpath_Final;
		String itemPriceValue_Xpath_Temp;
		String itemPriceValue_Xpath;
		String itemPriceValue;
		String itemPrice_Split;
		double itemPrice_SplitValue;
		String itemPriceValueTemp;
		String itemPrice_SplitTemp;
		double itemPrice_SplitValueTemp;
		int j;
		
		generalLogin();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select prodDropdown = new Select(driver.findElement(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "productsSort_dropdown"))));
		prodDropdown.selectByVisibleText(objrpf.readPropFile(testDataPropertyFilePath, "productsSort_dropdown_Value_PriceHighToLow"));
		itemPriceLabel = driver.findElements(By.xpath(objrpf.readPropFile(locatorsPropertyFilePath, "itemPriceLabel")));
		itemPriceValue_Xpath=objrpf.readPropFile(locatorsPropertyFilePath, "itemPriceLabel");
		
		for (int i=1;i<=itemPriceLabel.size();i++) {
			itemPriceValue_Xpath_Final = "("+itemPriceValue_Xpath+")["+i+"]";
			itemPriceValue = driver.findElement(By.xpath(itemPriceValue_Xpath_Final)).getText();
			itemPrice_Split = itemPriceValue.substring(1);
			itemPrice_SplitValue = Double.parseDouble(itemPrice_Split);
			
			if(i>1) {
			
			j=i-1;
			
			itemPriceValue_Xpath_Temp = "("+itemPriceValue_Xpath+")["+j+"]";
			itemPriceValueTemp = driver.findElement(By.xpath(itemPriceValue_Xpath_Temp)).getText();
			itemPrice_SplitTemp = itemPriceValueTemp.substring(1);
			itemPrice_SplitValueTemp = Double.parseDouble(itemPrice_SplitTemp);
			
			if (itemPrice_SplitValue<=itemPrice_SplitValueTemp) {

			Assert.assertTrue(true);
			}
			
			else {
				Assert.assertTrue(false);
			}
			
			}
			}	
		driver.close();
		}
	
	public void generalLogin() throws IOException {
		
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
	}
	
}
