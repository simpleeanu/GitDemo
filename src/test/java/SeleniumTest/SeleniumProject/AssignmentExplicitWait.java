package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentExplicitWait {

	public static void main(String args[]) {
		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("http://www.itgeared.com/demo/1506-ajax-loading.html");
		utils.doMaximize();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		By DemoAjax = By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]");
		elUltils.doClick(DemoAjax);

		By ResultsText = By.cssSelector("#results");
		String VisibleText = wait.until(ExpectedConditions.visibilityOfElementLocated(ResultsText)).getText();
		System.out.println(VisibleText);

	}
}
