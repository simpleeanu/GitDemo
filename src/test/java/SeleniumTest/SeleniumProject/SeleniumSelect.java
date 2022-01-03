package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumSelect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BrowserUtils utils = new BrowserUtils();
		
		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://www.seleniumeasy.com/test/");
		By CloseButton = By.xpath("//*[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']");
		Thread.sleep(2000);
		elUltils.doClick(CloseButton);
		
	}

}
