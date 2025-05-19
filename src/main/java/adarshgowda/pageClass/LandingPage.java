package adarshgowda.pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LandingPage {
	

	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy (id="login")
	WebElement login;
	
	By home = By.xpath("//*[@routerlink=\"/dashboard/\"]");

  public ProductCatalogue login(String name, String password) {
	  userEmail.sendKeys(name);
	  userPassword.sendKeys(password);
	  login.click();
	  ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	  return productCatalogue;
	  
  }
  
  
}
