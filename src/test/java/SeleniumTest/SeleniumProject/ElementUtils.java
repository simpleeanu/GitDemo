package SeleniumTest.SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement doFindElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public void doClick(By locator) {

		doFindElement(locator).click();

	}

	public List<WebElement> getElements(By locator) {

		List<WebElement> element = driver.findElements(locator);

		return element;

	}

	public void doWait(By locator) {

	}

	public Select doGetSelect(By locator) {
		Select select1 = new Select(doFindElement(locator));
		return select1;

	}

	public void doSendKeys(By Locator, String text) {
		doFindElement(Locator).sendKeys(text);
	}

	public String doGetText(By Locator) {
		return doFindElement(Locator).getText();
	}

	public void doSelectByText(By locator, String text) {
		doGetSelect(locator).selectByVisibleText(text);
	}

	public void doSelectByValue(By locator, String value) {
		doGetSelect(locator).selectByValue(value);
	}

	public void doSelectByIndex(By locator, int index) {
		doGetSelect(locator).selectByIndex(index);
	}

}
