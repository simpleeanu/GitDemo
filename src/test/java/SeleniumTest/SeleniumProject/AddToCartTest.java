package SeleniumTest.SeleniumProject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserUtils utils = new BrowserUtils();
		String[] Vegetables = { "Brocolli", "Cucumber", "Tomato" };
		WebDriver driver = utils.getBrowser("chrome");

		ElementUtils elUltils = new ElementUtils(driver);
		utils.navigateUrl("https://rahulshettyacademy.com/seleniumPractise/");

		utils.doMaximize();

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		addCartItem(elUltils, driver, Vegetables);

		By AddCartIcon = By.cssSelector(".cart-icon");
		elUltils.doClick(AddCartIcon);

		By ProceedToCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
		elUltils.doClick(ProceedToCheckout);

		By PromoCode = By.className("promoCode");
		elUltils.doSendKeys(PromoCode, "rahulshettyacademy");

		By ApplyButton = By.className("promoBtn");
		elUltils.doClick(ApplyButton);

		WebDriverWait wr = new WebDriverWait(driver, 5);

		By CodeApplied = By.cssSelector(".promoInfo");
		wr.until(ExpectedConditions.visibilityOfElementLocated(CodeApplied));
		System.out.println(elUltils.doGetText(CodeApplied));

		By PlaceOrder = By.xpath(".//button[text()='Place Order']");
		elUltils.doClick(PlaceOrder);

		By ChooseCountry = By.cssSelector("div[class='wrapperTwo'] select");
		elUltils.doSelectByText(ChooseCountry, "Angola");
		// button[contains(text(),'ADD TO CART')]

		By ClickAgree = By.cssSelector(".chkAgree");
		elUltils.doClick(ClickAgree);

		By ClickProceed = By.xpath("//button[text()='Proceed']");
		elUltils.doClick(ClickProceed);

		By ConfirmationMessage = By.cssSelector(".wrapperTwo");
		System.out.println(elUltils.doGetText(ConfirmationMessage));

	}

	public static void addCartItem(ElementUtils elUltils, WebDriver driver, String[] Vegetables) {
		By AddItem = By.xpath("//button[text()='ADD TO CART']");
		By productName = By.cssSelector("h4.product-name");
		List<WebElement> productNameList = elUltils.getElements(productName);

		List<String> VegetableList = Arrays.asList(Vegetables);

		Iterator<WebElement> iterator = productNameList.iterator();
		while (iterator.hasNext()) {
			WebElement nameList = iterator.next();
			String name[] = nameList.getText().split("-");
			String formattedName = name[0].trim();
			System.out.println("Verfied:" + formattedName);
			if (VegetableList.contains(formattedName)) {

				elUltils.doClick(AddItem);
				System.out.println("Item has added");

			}

		}
	}
}