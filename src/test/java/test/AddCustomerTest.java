package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	// TestData
	String userName = "demo@techfios.com";
	String password = "abc123";
	String dashboardValidationText = "Dashboard";
	String addCustomerValidationText = "Add Contact";
	String fullName = "Selenium Feb2023";
	String company = "Techfios";
	String email = "demoFeb23@techfios.com";
	String phone = "12345678";
	String country = "Antarctica";

	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {
		
	driver = BrowserFactory.init();
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	loginPage.performLogin(userName, password);
	
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	dashboardPage.validateDashboardPage(dashboardValidationText);
	dashboardPage.clickCustomerButton();
	dashboardPage.clickAddCustomerButton();
	
	AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
	addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
	addCustomerPage.insertFullName(fullName);
	addCustomerPage.selectCompanyName(company);
	addCustomerPage.insertEmail(email);
	
	}

}
