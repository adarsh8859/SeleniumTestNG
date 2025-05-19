package adarshgowda.pageClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends UtilityClass{
    WebDriver driver;


	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//tbody//td[2]")
	List<WebElement> orders;
	

	
	public boolean orderList(String name) {
		System.out.println(orders.size());
		for(WebElement webelements : orders)
			
		{
			String productname = webelements.getText();
			if(productname.equals(name))
			{
				
				System.out.println(productname);
				return true;
			}
		}
		return false;
		
	}
}
