package SeleniumTest.SeleniumProject;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;

//import java.net.MalformedURLException;

//import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, IOException {

		String links;

		SoftAssert a = new SoftAssert();

		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");

		ElementUtils elUltils = new ElementUtils(driver);

		utils.navigateUrl("https://www.rahulshettyacademy.com/AutomationPractice/");

		utils.doMaximize();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C:\\Users\\anu98\\screenshot.png"));

		WebElement Footer = driver.findElement(By.cssSelector("div.footer_top_agile_w3ls.gffoot.footer_style"));

		List<WebElement> FooterLinks = Footer.findElements(By.tagName("a"));

		for (int i = 0; i < FooterLinks.size(); i++)

		{

			links = FooterLinks.get(i).getAttribute("href");

			System.out.println(links);

			HttpURLConnection conn = (HttpURLConnection) new URL(links).openConnection();

			conn.setRequestMethod("HEAD");

			conn.connect();

			int respCode = conn.getResponseCode();

			System.out.println(respCode);

			/*
			 * if(respCode>400)
			 * 
			 * {
			 * 
			 * System.out.println("The link is broken"+links);
			 * 
			 * }
			 */

			a.assertTrue(respCode < 400, "The link :" + links + "is broken");

		}

		a.assertAll();

		utils.doCloseBrowser();

	}

}