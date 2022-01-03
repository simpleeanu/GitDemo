package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumDynamicSelect {

	
	public static void main(String args[]) throws InterruptedException {
		BrowserUtils utils = new BrowserUtils();
		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("http://spicejet.com");
		Thread.sleep(2000);

		By OriginDropdown = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
		By OriginPlace = By.xpath("//a[@value='BLR']");
		By DestPlace = By.xpath("(//a[@value='MAA'])[2]");
		elUltils.doClick(OriginDropdown);
		elUltils.doClick(OriginPlace);
		Thread.sleep(2000);
		elUltils.doClick(DestPlace);

		
		}
}
