package adarshgowda.pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends UtilityClass {

		// TODO Auto-generated constructor stub
		public ConfirmationPage (WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(css=".hero-primary")
		WebElement confirmationMessage;
		
		public String confirmationOrder()
		
		{
			waitForVisible(confirmationMessage);
			System.out.println(confirmationMessage.getText());
			return confirmationMessage.getText();
			
		}
	}


