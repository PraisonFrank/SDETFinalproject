package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.FindPatientPage;
import pages.RegisterPatientPage;

public class FindPatientTest extends BasePage{
	FindPatientPage Find;
	
	@BeforeClass
	public void setup() {
    	Find = new FindPatientPage(driver);
	}
    
	@Test(priority=1,dependsOnMethods = "tests.RegisterPatientTest.ValidateSuccess")
	public void Navigatetosearch() {
		Find.Home();
		Find.Search("Praison");
	}
	
	public void Edit() {
		Find.ClickEdit();
		Find.ClickAdd();
		Find.FillDetails("Fever");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
