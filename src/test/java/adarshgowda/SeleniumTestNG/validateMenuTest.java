package adarshgowda.SeleniumTestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import adarshgowda.pageClass.ProductCatalogue;

public class validateMenuTest extends BaseClass{

@Test
public void validateMenu() {
	 ProductCatalogue productCatalogue = landingPage.login("adarshkm@gmail.com", "Adadrsh@123");
	 AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());	  
}

}
