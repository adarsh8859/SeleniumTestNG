package adarshgowda.SeleniumTestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import adarshgowda.pageClass.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	WebDriver driver;
	public LandingPage landingPage;
	
  public WebDriver initalize () {
	  WebDriverManager.safaridriver().setup();
	  driver = new SafariDriver();	  
	  driver.get("https://rahulshettyacademy.com/client");
	  return driver;
	  
  }
  
  
  @BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException, InterruptedException
	{
		
		driver = initalize();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		landingPage = new LandingPage(driver);
		return landingPage;
		
	}
  
  @AfterMethod(alwaysRun=true)
  public void quite () {
    driver.close();
  
}  
}
