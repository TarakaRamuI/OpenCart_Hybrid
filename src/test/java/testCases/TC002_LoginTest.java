package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.Homepage;
import pageObjcts.LoginPage;
import pageObjcts.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity", "Master"})
	public void verfyLogin()
	{
		logger.info("**** Strating TC_002LoginTest *****");

		try
		{


			//Home Page
			Homepage hp = new Homepage(driver);

			hp.clickMyAccount();
			hp.clickLogin();

			//Login Page
			LoginPage lp = new LoginPage(driver);

			lp.setLogin(p.getProperty("Email"));
			lp.setPassword(p.getProperty("Password"));
			lp.clickLogin();

			//MyAccount Page

			MyAccountPage macc = new MyAccountPage(driver);

			boolean targetPage = macc.isAccountExists();

			//Assert.assertEquals(targetPAge, true);
			//or 

			Assert.assertTrue(targetPage);
		}
		catch (Exception e) {

			Assert.fail();
		}

		logger.info("**** Finishing TC_002LoginTest *****");

	}

}
