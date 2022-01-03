package SeleniumTest.SeleniumProject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;  


public class SeleniumMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anu98\\Downloads\\chromedriver_win32\\chromedriver.exe");  
        
        // Instantiate a ChromeDriver class.     
   WebDriver driver=new ChromeDriver();  
   /*DesiredCapabilities caps;    
   caps = DesiredCapabilities.chrome();

   ChromeOptions options = new ChromeOptions();
   options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
   caps.setCapability(ChromeOptions.CAPABILITY, options); */
      // Launch Website  
    driver.manage().window().maximize();

   driver.navigate().to("http://www.hyrtutorials.com/");  
   
	Thread.sleep(2000);
	
	WebElement SeleniumPractice= driver.findElement(By.xpath("//a[text()='Selenium Practice']"));
	//SeleniumPractice.click();
	Actions action=new Actions(driver);
	action.moveToElement(SeleniumPractice).perform();
	
	WebElement BrokenLinks=driver.findElement(By.xpath("//a[text()='Broken Links']"));
	action.moveToElement(BrokenLinks).perform();
	
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"ad_iframe\"]")));       
	driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]/div/span")).click(); //Close Ad
	driver.switchTo().defaultContent(); // Return to main window
	
	WebElement Link1=driver.findElement(By.xpath("//a[text()='Link1']"));
	//action.moveToElement(Link1).perform();
	Link1.click();

	//WebElement DismissButton=driver.findElement(By.id("dismiss-button"));
	//DismissButton.click();

	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"ad_iframe\"]")));       
	driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]/div/span")).click(); //Close Ad
	driver.switchTo().defaultContent(); // Return to main window
	
	WebElement sel = driver.findElement(By.id(""));
	
	Select sel1=new Select(sel);
	sel1.selectByVisibleText("Hello");
	
	List<WebElement> listSelect=sel1.getOptions();
	for (WebElement webElement: listSelect)
		System.out.println("Options"+webElement.getText());
	
	
			
	
	
	
   
   
   
	}

}
