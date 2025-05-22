package adarshgowda.pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LandingPage extends UtilityClass {
	

	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy (id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	By home = By.xpath("//*[@routerlink=\"/dashboard/\"]");

  public ProductCatalogue login(String name, String password) {
	  userEmail.sendKeys(name);
	  userPassword.sendKeys(password);
	  login.click();
	  ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	  return productCatalogue;
	  
  }
  
  public String getErrorMessage()
	{
	   waitForVisible(errorMessage);
		return errorMessage.getText();
	}
  
  
}
