package adarshgowda.SeleniumTestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import adarshgowda.pageClass.CartPage;
import adarshgowda.pageClass.CheckoutPage;
import adarshgowda.pageClass.ConfirmationPage;
import adarshgowda.pageClass.OrdersPage;
import adarshgowda.pageClass.ProductCatalogue;



public class LoginTest extends BaseClass{
	
	
  @Test
  public void login() throws InterruptedException {
	  
	  ProductCatalogue productCatalogue = landingPage.login("adarshkm@gmail.com", "Adarsh@123");
	  String title = productCatalogue.getTitle();
	  System.out.println(title);
	  AssertJUnit.assertEquals("Let's Shop", title); 
	  productCatalogue.addProductToCart("ZARA COAT 3");
	  Thread.sleep(2000);
	  CartPage cartpage = productCatalogue.goToCart();
	  Thread.sleep(2000);
	  boolean value = cartpage.checkCart("ZARA COAT 3");
	  AssertJUnit.assertTrue(value);
	  CheckoutPage checkoutpage = cartpage.checkOut();
	  checkoutpage.selectCountry("Ind");
	  ConfirmationPage confirmationpage = checkoutpage.submitOrder();
	  String message = confirmationpage.confirmationOrder();
	  AssertJUnit.assertEquals(" Thankyou for the order. ", message);
	  OrdersPage orderspage =confirmationpage.goToOrders();
	  Thread.sleep(2000);
	  boolean confromorder = orderspage.orderList("ZARA COAT 3");
	  AssertJUnit.assertTrue(confromorder);    	    
  }
  
}
