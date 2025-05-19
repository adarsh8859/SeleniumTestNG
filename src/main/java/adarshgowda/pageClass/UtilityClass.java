package adarshgowda.pageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	
	WebDriver driver;

	public UtilityClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@routerlink=\"/dashboard/cart\"]")
	WebElement cart;
	
	@FindBy(xpath="(//*[@routerlink=\"/dashboard/myorders\"])[1]")
	WebElement ordersList;
	
	public void waitForVisible(WebElement locator)
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOf(locator));
	    
	}
	
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public CartPage goToCart()
	
	{
		waitForVisible(cart);
		cart.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
    public OrdersPage goToOrders()
	{
		waitForVisible(ordersList);
		ordersList.click();
		OrdersPage orderspage = new OrdersPage(driver);
		return orderspage;
	}
}
