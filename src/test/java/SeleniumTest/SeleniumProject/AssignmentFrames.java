package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);

		utils.navigateUrl("http://the-internet.herokuapp.com/");

		utils.doMaximize();

		By NestedFrames = By.xpath("//a[contains(text(),'Nested Frames')]");
		elUltils.doClick(NestedFrames);

		System.out.println(driver.findElements(By.tagName("frame")).size());

		By FrameTop = By.name("frame-top");
		driver.switchTo().frame(elUltils.doFindElement(FrameTop));
		System.out.println(driver.findElements(By.tagName("frame")).size());

		By FrameMiddle = By.name("frame-middle");
		driver.switchTo().frame(elUltils.doFindElement(FrameMiddle));

		By MiddleText = By.xpath("//div[text()='MIDDLE']");
		System.out.println(elUltils.doGetText(MiddleText));

		driver.switchTo().defaultContent();

	}

}
