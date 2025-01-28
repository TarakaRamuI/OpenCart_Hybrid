package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.Homepage;
import pageObjcts.LoginPage;
import pageObjcts.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
 */

public class TC_003_LoginDDT extends BaseClass{



	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verifyLoginDDT(String email, String pwd, String exp)
	{
		logger.info("******* Starting TC_003_DDT *********");

		try
		{

			//Home Page
			Homepage hp = new Homepage(driver);

			hp.clickMyAccount();
			hp.clickLogin();

			//Login Page
			LoginPage lp = new LoginPage(driver);

			lp.setLogin(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			//MyAccount Page

			MyAccountPage macc = new MyAccountPage(driver);

			boolean targetPage = macc.isAccountExists();


			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.Logout();

					Assert.assertTrue(true);
				}

				else {

					Assert.assertTrue(false);
				}
				if(exp.equalsIgnoreCase("Invalid"))
				{

					if(targetPage==true)
					{
						macc.Logout();

						Assert.assertTrue(false);
					}

					else {

						Assert.assertTrue(true);
					}
				}
			}
		}

		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("******* Finished TC_003_DDT *********");
	}
}



