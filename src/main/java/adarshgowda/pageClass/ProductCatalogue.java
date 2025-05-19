package adarshgowda.pageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductCatalogue extends UtilityClass {
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
 
	@FindBy(xpath="//title")
	WebElement title;


	@FindBy(xpath="//*[text()=\"Don't have an account? \"]")
	WebElement incorrectCred;
	
	
	public String getTitle() {
		
	return title.getText();
	}
	
	public String errorMessage() {
		return incorrectCred.getText();
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		System.out.println(getProductByName(productName));
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
	}

    
  
	
}

