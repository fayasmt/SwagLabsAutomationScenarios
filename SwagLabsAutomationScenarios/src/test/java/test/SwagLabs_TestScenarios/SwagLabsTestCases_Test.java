/*
 * This class contains the methods which runs the Swag Labs application test cases
 * Designer: Fayas MT
 * Date: 27-Sep-2021
 */


package test.SwagLabs_TestScenarios;

import java.io.IOException;
import org.testng.annotations.Test;
import pages.SwagLabs_LoginPage.UserLogin_Scenarios;
import pages.SwagLabs_ProductsPage.SortProducts_Scenarios;

public class SwagLabsTestCases_Test{
	
	UserLogin_Scenarios objUserLogin_Scenarios = new UserLogin_Scenarios();
	SortProducts_Scenarios objSortProducts_Scenarios = new SortProducts_Scenarios();
	
	//This test case belongs to the Login Page Scenario; Scenario#1
	@Test
	public void TC01_ValidateValidUser() throws IOException {
		objUserLogin_Scenarios.tc01_ValidateValidUser();
	}
	
	//This test case belongs to the Login Page Scenario; Scenario#1
	@Test
	public void TC02_ValidateValidUserWithInvalidPassword() throws IOException {
		objUserLogin_Scenarios.tc02_ValidateValidUserWithInvalidPassword();
	}
	
	//This test case belongs to the Login Page Scenario; Scenario#1
	@Test
	public void TC03_ValidateLockedOutUserLogin() throws IOException {
		objUserLogin_Scenarios.tc03_ValidateLockedOutUserLogin();
	}

	//This test case belongs to the Products Page Scenario; Scenario#2
	@Test
	public void TC01_VerifySortPriceLowToHigh() throws IOException {
		objSortProducts_Scenarios.tc01_VerifySortPriceLowToHigh();
	}
	
	//This test case belongs to the Products Page Scenario; Scenario#2
	@Test
	public void TC02_VerifySortPriceHighToLow() throws IOException {
		objSortProducts_Scenarios.tc02_VerifySortPriceHighToLow();
	}
}
