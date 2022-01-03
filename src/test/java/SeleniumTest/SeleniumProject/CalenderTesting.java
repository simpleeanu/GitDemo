package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.testng.Assert;

public class CalenderTesting {
	public static void main(String args[]) {
		BrowserUtils utils = new BrowserUtils();
		
		WebDriver driver = utils.getBrowser("chrome");
		driver.get("http://spicejet.com");
		
		

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

		{

		System.out.println("enabled");

		Assert.assertTrue(true);

		}

		else

		{

		Assert.assertTrue(false);

		}
	}
}
