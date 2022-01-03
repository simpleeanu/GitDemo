package SeleniumTest.SeleniumProject;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandle1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserUtils utils = new BrowserUtils();
		String[] Vegetables = { "Brocolli", "Cucumber", "Tomato" };
		WebDriver driver = utils.getBrowser("chrome");

		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://rahulshettyacademy.com/loginpagePractise");

		utils.doMaximize();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		By FreeAccessLink = By.cssSelector("a[href='https://rahulshettyacademy.com/#/documents-request']");
		elUltils.doClick(FreeAccessLink);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		By EmailId = By.cssSelector("a[href='mailto:mentor@rahulshettyacademy.com']");
		String EmailIdValue = elUltils.doGetText(EmailId);

		driver.switchTo().window(parentId);
		By UserName = By.cssSelector("#username");
		elUltils.doSendKeys(UserName, EmailIdValue);

	}

}
