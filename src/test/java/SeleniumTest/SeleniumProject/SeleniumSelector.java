package SeleniumTest.SeleniumProject;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SeleniumSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtils utils = new BrowserUtils();
		
		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://www.spicejet.com/");
		
		utils.doMaximize();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		//By FlightStatus = By.cssSelector("div[class='book-a-flight hide-desktop visible-sm'] > a[href='FlightStatus.aspx']");
		By FlightStatus = By.cssSelector("li[class='flight_status'] > a[title='Flight Status']");
		elUltils.doClick(FlightStatus);
		
		By Origin = By.cssSelector("select[id='FlifoSearchInputSearchView_originStation']");
		elUltils.doSelectByText(Origin,"Chennai (MAA)");
		
		By Destination = By.cssSelector("select[name='destinationStation']");
		elUltils.doSelectByValue(Destination, "BLR");
		
		By TravelDate = By.cssSelector("select#FlifoSearchInputSearchView_DropDownListFlightDate");
		elUltils.doSelectByIndex(TravelDate,1);

		By ClickSearch = By.cssSelector("input[value='Search'][name='FlifoSearchInputSearchView$ButtonSubmit']");
		elUltils.doClick(ClickSearch);
		
		//By FlghtErrorMessage = By.cssSelector("div.flight-status-error");
		//System.out.println(elUltils.doGetText(FlghtErrorMessage));
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,250)");
		
		By Flight = By.cssSelector("a#flightAction_1_1");
		String FlightNo = elUltils.doGetText(Flight);
		elUltils.doClick(Flight);


		By FlightNumber = By.xpath("//th[contains(text(),'Flight Number:')]//following::td");


		Assert.assertEquals(FlightNo, elUltils.doGetText(FlightNumber),"Passed.");
		System.out.println("Pass");
		
		By CloseButton = By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable']//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']");
		elUltils.doClick(CloseButton);
		
		//utils.doCloseBrowser();
	}

}
