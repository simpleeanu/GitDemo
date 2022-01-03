package SeleniumTest.SeleniumProject;

import org.openqa.selenium.*;
import org.testng.*;

public class AssertTesting {
public static void main(String args[]) {
	BrowserUtils utils = new BrowserUtils();
	
	WebDriver driver = utils.getBrowser("chrome");

	driver.get("http://spicejet.com"); //URL in the browser

	Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

	//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();

	System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());

	Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
}
}
