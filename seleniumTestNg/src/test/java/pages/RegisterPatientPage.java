package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
	WebDriver driver;

	By RegisterPbtn = By.id(
			"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
	// Name Fields
	By Fname = By.name("givenName");
	By Lname = By.name("familyName");
	// Gender Fields
	By Gender = By.id("gender-field");
	// Birthdate Fields
	By Day = By.id("birthdateDay-field");
	By Month = By.id("birthdateMonth-field");
	By Year = By.id("birthdateYear-field");
	// Address Fields
	By Address1 = By.id("address1");
	By Address2 = By.id("address2");
	By City = By.id("cityVillage");
	By State = By.id("stateProvince");
	By Country = By.id("country");
	By PostalCode = By.id("postalCode");
	// Phone Number Fields
	By Number = By.name("phoneNumber");
	// Relatives Fields
	By RelType = By.id("relationship_type");
	By RelName = By.xpath("//input[@placeholder='Person Name']");

	By ClickNext = By.id("next-button");
	By Confirm = By.id("submit");

	public RegisterPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickRegister() {
		driver.findElement(RegisterPbtn).click();
	}
	
	public void ClickConfirm() {
		driver.findElement(Confirm).click();
	}
	public void EnterName(String fname, String lname) {
		driver.findElement(Fname).sendKeys(fname);
		driver.findElement(Lname).sendKeys(lname);
	}

	public void ClickNext() {
		driver.findElement(ClickNext).click();
	}

	public void SelectGender(String gender) {
		Select P_Gender = new Select(driver.findElement(Gender));
		P_Gender.selectByValue(gender);
	}
	
	public void EnterDob(String date,String month,String year) {
		//driver.findElement(Day).click();
		driver.findElement(Day).sendKeys(date);
		driver.findElement(Month).click();
		Select P_month = new Select(driver.findElement(Month));
		P_month.selectByContainsVisibleText(month);
		//driver.findElement(Year).click();
		driver.findElement(Year).sendKeys(year);
	}
	

	public void EnterAddress(String Add1) {
		driver.findElement(Address1).sendKeys(Add1);
	}

	public void EnterPhone(String number) {
		driver.findElement(Number).sendKeys(number);
	}
}
