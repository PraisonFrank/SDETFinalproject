package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FindPatientPage {
	WebDriver driver;
	
	By HomeBtn = By.xpath("//img[@src='/openmrs/ms/uiframework/resource/uicommons/images/logo/openmrs-with-title-small.png']");
	By FindP = By.xpath("//i[@class='icon-search']");
	By search = By.id("patient-search");
	By firstrec = By.xpath("//td[1]");
	By ConditionBtn = By.xpath("//div[@class='info-section conditions ng-scope']//i[@title='Edit']");
	By Add = By.id("conditionui-addNewCondition");
	By Condition = By.id("conceptId-input");
	By Submit = By.id("addConditionBtn");
	
	public FindPatientPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Home() {
		driver.findElement(HomeBtn).click();
		driver.findElement(FindP).click();
	}
	
	public void Search(String name) {
		driver.findElement(search).sendKeys(name);
		driver.findElement(firstrec).click();
	}
	
	public void ClickEdit() {
		driver.findElement(ConditionBtn).click();
	}
	
	public void ClickAdd() {
		driver.findElement(Add).click();
	}
	
	public void FillDetails(String Conditionname) {
		driver.findElement(Condition).sendKeys("Conditionname");
		Select P_month = new Select(driver.findElement(Condition));
		P_month.selectByContainsVisibleText(Conditionname);
		driver.findElement(Submit).click();
	}
}
