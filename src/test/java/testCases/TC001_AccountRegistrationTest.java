package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.AccountRegistrationPage;
import pageObjcts.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{


	@Test(groups = {"Regression", "Master"})
	public void verify_Account_RegPage()
	{

		logger.info("**** Starting TC_001_AccountRagistrationTest ***** ");		

		try
		{

			Homepage hp = new Homepage(driver);

			hp.clickMyAccount();

			logger.info("Clicked on MyAccount button");

			hp.clickRegister();

			logger.info("Clicked on Register button");

			AccountRegistrationPage verify_reg = new AccountRegistrationPage(driver);

			logger.info("Providing customer details");

			verify_reg.setFirstName(randomString().toUpperCase());

			verify_reg.setLastName(randomString().toUpperCase());

			verify_reg.setEmail(randomString()+"@gmail.com");

			verify_reg.setPhoneNum(randomeNumber());

			//Here password and CNF password are same thats why we need to create one string variable 
			//that variable stores random password and that variable Passed to Password and CNF_Password

			String password = randomAlphaNumaric();

			verify_reg.setPassword(password);

			verify_reg.setCnfPwd(password);

			verify_reg.clickNewsletter();

			verify_reg.clickPolicy();

			verify_reg.clickContinue();

			logger.info("Validating expected message");

			
			String cnf_msg = verify_reg.getConformationMessage();
			
			if(cnf_msg.equals("Your Account Has Been Created!"))
			{
			
				Assert.assertTrue(true);
				
			}
			
			else
			{
				logger.error("Test Failed...");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
	
			//Assert.assertEquals(cnf_msg,"Your Account Has Been Created!!!");

			//System.out.println(cnf_msg);
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("**** Finished TC_001_AccountRagistrationTest ****");
		
		

	}

}