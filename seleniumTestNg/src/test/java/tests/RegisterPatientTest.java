package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPatientPage;

public class RegisterPatientTest extends BasePage {
    RegisterPatientPage Register;
    @BeforeClass
	public void setup() {
		Register = new RegisterPatientPage(driver);
	}
    
	@Test(priority=1,dependsOnMethods = "tests.LoginTest.ValidLogin")
	public void NavigateToRegister() {
		Register.ClickRegister();
	}
	
	@Test(priority=2)
	public void EnterName() {
		Register.EnterName("Praison", "Frank");
		Register.ClickNext();
	}
	@Test(priority=3)
	public void SelectGender() {
		Register.SelectGender("M");
		Register.ClickNext();
	}
	@Test(priority=4)
	public void EnterDob() {
		Register.EnterDob("2", "January", "2001");
		Register.ClickNext();
	}
	@Test(priority=5)
	public void EnterAddress() {
		Register.EnterAddress("Address");
		Register.ClickNext();
	}
	@Test(priority=6)
	public void EnterNumber() {
		Register.EnterPhone("9981187766");
		Register.ClickNext();
		Register.ClickNext();
		Register.ClickConfirm();
	}
	
	@Test(priority=7)
	public void ValidateSuccess() {
		String PageTitle = driver.getTitle();
		String ExpectedTitle = "OpenMRS Electronic Medical Record";
		assertEquals(PageTitle,ExpectedTitle,"Registration Failed");
	}
	
	
}
