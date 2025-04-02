package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By Username = By.id("username");
	By Password = By.id("password");
	By Location = By.id("Inpatient Ward");
	By LoginBtn = By.id("loginButton");
	By ErrorMsg = By.id("error-message");
	By HomePage = By.tagName("h4");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void EnterUsername(String username) {
		driver.findElement(Username).sendKeys(username);
	}

	public void EnterPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}

	public void SelectLocation() {
		driver.findElement(Location).click();
		;
	}

	public void ClickLogin() {
		driver.findElement(LoginBtn).click();
		;
	}

	public String GetErrorMsg() {
		return driver.findElement(ErrorMsg).getText();
		// String Message = driver.findElement(ErrorMsg).getText();
		// return Message;
	}

	public String SuccessfulLogin() {
		return driver.findElement(HomePage).getText();
		// String Message = driver.findElement(ErrorMsg).getText();
		// return Message;
	}
}
