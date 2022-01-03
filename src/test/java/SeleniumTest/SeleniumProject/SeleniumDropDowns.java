package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDropDowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		WebElement DropDown= driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]"));
		DropDown.click();
		
		WebElement SimpleForm=driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[@href='./basic-select-dropdown-demo.html'][contains(text(),'Select Dropdown List')]"));
		SimpleForm.click();
		
		WebElement SelectDay=driver.findElement(By.id("select-demo"));
				
		Select Sel1=new Select(SelectDay);
		Sel1.selectByVisibleText("Sunday");
		
		WebElement MultiSelect=driver.findElement(By.xpath("//select[@id='multi-select']"));
		Select Sel2=new Select(MultiSelect);
		Sel2.selectByVisibleText("Florida");
		
		Sel2.selectByValue("Texas");
		

	}

}
