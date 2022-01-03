package SeleniumTest.SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Assignment2 {

	public static void main(String args[]) throws InterruptedException {

		BrowserUtils utils = new BrowserUtils();

		WebDriver driver = utils.getBrowser("chrome");
		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://cleartrip.com");
		utils.doMaximize();
		Thread.sleep(2000);
		By adult = By.xpath("//div[@class='mb-4']//select[@class='bc-neutral-100 bg-transparent']");
		elUltils.doSelectByText(adult, "2");

		By child = By.xpath("(//div//h4[@class='fs-3 fw-400 c-neutral-900 mb-2']/following-sibling::select)[1]");
		elUltils.doSelectByText(child, "3");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		By DepartOn = By.xpath(
				"//button[@class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']");
		elUltils.doClick(DepartOn);
		Thread.sleep(2000);
		By CurrentDate = By.xpath("//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today' and @aria-selected='true']//div//div");
		//By CurrentDate = By.xpath("//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today' and @aria-selected='true']//div)[1]");
		elUltils.doClick(CurrentDate);
		Thread.sleep(1000);
		By MorOptions = By.partialLinkText("More options:");
		elUltils.doClick(MorOptions);
		
		By PreferredAirline = By.xpath("//input[@class='field bw-1 bs-solid w-100p p-2 box-border br-4 fs-2 c-neutral-900 h-8 bc-neutral-100 c-neutral-900 focus:bc-secondary-500 flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 pr-2 pl-3 pt-2 pb-2 ba br-4 h-8']");
		elUltils.doSendKeys(PreferredAirline, "Indigo");
		
		By SubmitButton = By.xpath("//button[@class='px-7 bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-2 px-5 h-10 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']");
		elUltils.doClick(SubmitButton);
		
		By ErrorMessage = By.xpath("//span[@class='to-ellipsis o-hidden ws-nowrap fs-3 c-white']");
		System.out.println(elUltils.doGetText(ErrorMessage));
	}

}
