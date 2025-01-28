package pageObjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage
{
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath= "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath ="//input[@id='input-telephone']")
	WebElement txtPhoneNum;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPwd;

	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement txtCnfPwd;

	@FindBy(xpath = "//input[@value='0']")
	WebElement chkNewsletter;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath ="//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfMSG;


	//Methods

	public void setFirstName(String FirstName)
	{
		txtFirstName.sendKeys(FirstName);
	}

	public void setLastName(String LastName)
	{
		txtLastName.sendKeys(LastName);
	}

	public void setEmail(String Email)
	{
		txtEmail.sendKeys(Email);
	}

	public void setPhoneNum(String P_num)
	{
		txtPhoneNum.sendKeys(P_num);
	}

	public void setPassword(String PWD)
	{
		txtPwd.sendKeys(PWD);
	}

	public void setCnfPwd(String PWD)
	{
		txtCnfPwd.sendKeys(PWD);
	}

	public void clickNewsletter()
	{
		chkNewsletter.click();
	}

	public void clickPolicy()
	{
		chkPolicy.click();
	}

	public void clickContinue()
	{
		btnContinue.click();

		// Scrolling page
		//sol2 
		//btnContinue.submit();

		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();

		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);

		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);

		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}


	public String getConformationMessage()
	{
		try {
			
			return(cnfMSG.getText());

		} catch (Exception e) {

			return(e.getMessage());

		}

	}
}
