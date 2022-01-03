package SeleniumTest.SeleniumProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment7Webtables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://rahulshettyacademy.com/AutomationPractice/");
		utils.doMaximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		// Count number of rows
		System.out
				.println(driver.findElements(By.xpath("//table[@id='product' and @class='table-display']//tr")).size());

		// Count Number of columns
		System.out.println(
				driver.findElements(By.xpath("//table[@id='product' and @class='table-display']//tr[1]//th")).size());

		By ThirdRow = By.xpath("//table[@id='product' and @class='table-display']//tr[3]//td");

		List<WebElement> ThirdRow1 = driver.findElements(ThirdRow);
		// System.out.println(ThirdRow1);

		for (int i = 0; i < ThirdRow1.size(); i++)

			System.out.println(ThirdRow1.get(i).getText());

		// Auto Suggestive Dropdown
		js.executeScript("window.scrollBy(0,-600)");

		By AutosuggestiveDropDown = By.id("autocomplete");
		elUltils.doSendKeys(AutosuggestiveDropDown, "United");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		By Options = By.xpath("//li[@class='ui-menu-item']//div");
		List<WebElement> OptionList = driver.findElements(Options);
		for (int i = 0; i < OptionList.size(); i++) {
			if (OptionList.get(i).getText().equals("United States (USA)")) {
				OptionList.get(i).click();
				break;
			}
		}

		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

		// driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	}

}
