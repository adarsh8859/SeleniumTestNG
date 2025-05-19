package adarshgowda.pageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends UtilityClass{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> products;
	
	@FindBy(css=".subtotal button")
	WebElement checkout;
	
	By ProductsBy = By.cssSelector(".cartSection h3");
	
	
	public boolean checkCart (String productName)
	{
		waitForElementToAppear(ProductsBy);
		for(WebElement webelement : products)
		{
			String value= webelement.getText();
			if(productName.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public CheckoutPage checkOut() {
		checkout.click();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
		
	}
	
}
