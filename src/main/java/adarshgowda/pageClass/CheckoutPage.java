package adarshgowda.pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends UtilityClass{
	
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	WebElement selectCountry;
	
	
	@FindBy(xpath="//*[@class=\"ta-results list-group ng-star-inserted\"]//button[2]")
	WebElement india;
	
	@FindBy(xpath="//*[text()=\"Place Order \"]")
	WebElement placeorder;
	
	
	
	public void selectCountry(String country) {
		
		waitForVisible(selectCountry);
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, country).build().perform();
		waitForVisible(india);
		a.click(india).build().perform();;
		}
	
	public ConfirmationPage submitOrder() {
		
	    placeorder.click();
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
	}

}
