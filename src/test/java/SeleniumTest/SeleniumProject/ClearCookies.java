package SeleniumTest.SeleniumProject;

import org.openqa.selenium.WebDriver;

public class ClearCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://rahulshettyacademy.com/AutomationPractice/");
		utils.doMaximize();
		utils.clearAllCookies(driver);
	}

}
