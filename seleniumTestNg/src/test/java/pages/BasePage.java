package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	public static WebDriver driver;

	public static void InitializeDirver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void CloseDriver() {
		driver.quit();
	}
}
