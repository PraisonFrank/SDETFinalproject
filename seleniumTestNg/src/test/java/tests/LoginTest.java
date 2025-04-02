package tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginPage login;

	@BeforeClass
	public void setup() {
		BasePage.InitializeDirver();
		driver = BasePage.driver;
		driver.get("https://o2.openmrs.org/openmrs/login.htm");
		login = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void InvalidLogin() {
		login.EnterUsername("Praison");
		login.EnterPassword("Frank");
		login.SelectLocation();
		login.ClickLogin();
		String ActualMsg = login.GetErrorMsg();
		String ExpectedMsg = "Invalid username/password. Please try again.";
		assertEquals(ExpectedMsg, ActualMsg, "Invalid Login Assertion Failed");
	}

	@Test(priority = 2)
	public void BlankLogin() {
		login.EnterUsername("");
		login.EnterPassword("");
		login.SelectLocation();
		login.ClickLogin();
		String ActualMsg = login.GetErrorMsg();
		String ExpectedMsg = "Invalid username/password. Please try again.";
		assertEquals(ExpectedMsg, ActualMsg, "Blank Login Assertion Failed");
	}

	@Test(priority = 3)
	public void ValidLogin() {
		login.EnterUsername("admin");
		login.EnterPassword("Admin123");
		login.SelectLocation();
		login.ClickLogin();
		String ActualMsg = login.SuccessfulLogin();
		// System.out.println(ActualMsg);
		String ExpectedMsg = "Logged in as Super User (admin) at Inpatient Ward.";
		assertEquals(ExpectedMsg, ActualMsg, "Successful Login Assertion Failed");
	}
}
