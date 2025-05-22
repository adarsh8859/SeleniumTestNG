package adarshgowda.SeleniumTestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
  
  
  public String takeScreenShot(String testCaseName,WebDriver driver) throws IOException {
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
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
