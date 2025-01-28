package pageObjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Basepage{

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgAccount;
	
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    
    WebElement linkLogout;

	public boolean isAccountExists()
	{
		try {


			return (msgAccount.isDisplayed());
		}
		catch(Exception e)
		{

			return false;
		}

	}
	
	public void Logout()
	{
		
		linkLogout.click();
		
	}

}
