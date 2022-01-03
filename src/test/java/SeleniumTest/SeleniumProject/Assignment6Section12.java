package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Assignment6Section12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://rahulshettyacademy.com/AutomationPractice/");
		utils.doMaximize();

		// To select the checkbox option without hardcoding the text Option1
		By CheckOption1 = By.id("checkBoxOption1");
		// To get the text present near option1 checkbox without passing the text
		// attribute ie. Option1

		By Option1Text = By.xpath("//div[@class='right-align']//label[1]");
		elUltils.doClick(CheckOption1);
		// Saving the text in a variable
		String OptionValue = elUltils.doGetText(Option1Text);

		By SelectId = By.id("dropdown-class-example");
		elUltils.doSelectByText(SelectId, OptionValue);

		By NameTextArea = By.name("enter-name");
		elUltils.doSendKeys(NameTextArea, OptionValue);

		By AlertBtn = By.id("alertbtn");
		elUltils.doClick(AlertBtn);

		String AlertText = driver.switchTo().alert().getText();
		System.out.println(AlertText);

		Assert.assertTrue(AlertText.contains(OptionValue), "Failed the test");
	}

}
