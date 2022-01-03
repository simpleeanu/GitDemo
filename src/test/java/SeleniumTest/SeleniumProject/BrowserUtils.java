package SeleniumTest.SeleniumProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	WebDriver driver;

	public WebDriver BrowserUtils() {
		return driver;

	}

	public WebDriver getBrowser(String BrowserName) {
		switch (BrowserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			return driver;

		default:
			return null;

		}
	}

	public void doCloseBrowser() {
		driver.close();
	}

	public void getUrl(String url) {

		driver.get(url);
	}

	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}

	public void clickBack() {
		driver.navigate().back();
	}

	public void clickForward() {
		driver.navigate().forward();
	}

	public void doMaximize() {
		driver.manage().window().maximize();
	}

	public void clearAllCookies(WebDriver driver) {
		Set<Cookie> CookieNames = driver.manage().getCookies();
		Iterator<Cookie> it = CookieNames.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		driver.manage().deleteAllCookies();
		System.out.println("All cookies deleted");
	}

	public void clearCookie(WebDriver driver, String CookieName) {
		System.out.println(driver.manage().getCookieNamed(CookieName).toString());
		driver.manage().deleteCookieNamed(CookieName);
		System.out.println("Cookie deleted" + CookieName);
	}

}
