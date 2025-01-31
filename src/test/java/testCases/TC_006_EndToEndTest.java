package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjcts.AccountRegistrationPage;
import pageObjcts.CheckoutPage;
import pageObjcts.Homepage;
import pageObjcts.LoginPage;
import pageObjcts.MyAccountPage;
import pageObjcts.Search_Page;
import pageObjcts.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_EndToEndTest extends BaseClass
{


	@Test(groups = {"master"})
	public void endToEndTest() throws Throwable
	{
		//Soft Assertion

		SoftAssert myassert = new SoftAssert();

		System.out.println("Account Registration......");

		Homepage hp = new Homepage(driver);

		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());

		//This email will randomly generated after that using this same email id will capture and login
		String email = randomString()+"@gmail.com";
		regpage.setEmail(email);

		regpage.setPhoneNum(randomAlphaNumaric());

		//Here password and random password is must same that's why we generated a random password 
		//And this password store in a string variable this variable is used in password and conform pwd
		String password = randomString()+"#$@";

		regpage.setPassword(password);

		regpage.setCnfPwd(password);

		regpage.clickNewsletter();

		regpage.clickPolicy();

		regpage.clickContinue();
		Thread.sleep(3000);

		//Getting the confirmation message and saved in a variable
		String getCnfMsg = regpage.getConformationMessage();

		//print the confirmation message into console
		System.out.println(getCnfMsg);

		//Comparing actual message to expected message
		myassert.assertEquals(getCnfMsg,"Your Account Has Been Created!");

		//After successfully completed the registration process logout the account 
		MyAccountPage macp = new MyAccountPage(driver);

		macp.Logout();
		Thread.sleep(3000);

		//After logout now click on my account and the click on login 
		System.out.println("Login to Application......");
		hp.clickMyAccount();
		hp.clickLogin();

		//Go to login page and login with recently registered email and password

		//Login...
		LoginPage lp = new LoginPage(driver);

		lp.setLogin(email);
		lp.setPassword(password);
		lp.clickLogin();

		System.out.println("Going to My Account Page?"+ macp.isAccountExists());

		myassert.assertEquals(macp.isAccountExists(), true);

		//Search and add product to cart
		System.out.println("Search and add produc to the cart");

		hp.enterProductName(p.getProperty("searchProductName"));
		hp.clickSearch();

		Search_Page sp = new Search_Page(driver);

		if(sp.isProductExist(p.getProperty("searchProductName")));
		{
			sp.selectProduct(p.getProperty("searchProductName"));
			sp.setQuantity("2");
			sp.addToCart();
		}

		Thread.sleep(3000);
		System.out.println("add product to cart?"+sp.checkConfMsg());

		myassert.assertEquals(sp.checkConfMsg(), true);

		//Shopping Cart
		System.out.println("Shopping cart......");

		ShoppingCartPage scp = new ShoppingCartPage(driver);

		scp.clickItemsToNavigateToCart();
		scp.clickViewCart();
		Thread.sleep(30000);
		
		String totprice=scp.getTotalPrice();
		System.out.println("total price is shopping cart: "+totprice);
		myassert.assertEquals(totprice, "$246.40");   //validation
		scp.clickOnCheckout(); //navigate to checkout page
		Thread.sleep(3000);


		//Checkout Product
		System.out.println("Checkout Product...............");
		CheckoutPage ch=new CheckoutPage(driver);

		ch.setfirstName(randomString().toUpperCase());
		Thread.sleep(1000);
		ch.setlastName(randomString().toUpperCase());
		Thread.sleep(1000);
		ch.setaddress1("address1");
		Thread.sleep(1000);
		ch.setaddress2("address2");
		Thread.sleep(1000);
		ch.setcity("Delhi");
		Thread.sleep(1000);
		ch.setpin("500070");
		Thread.sleep(1000);
		ch.setCountry("India");
		Thread.sleep(1000);
		ch.setState("Delhi");
		Thread.sleep(1000);
		ch.clickOnContinueAfterBillingAddress();
		Thread.sleep(1000);
		ch.clickOnContinueAfterDeliveryAddress();
		Thread.sleep(1000);
		ch.setDeliveryMethodComment("testing...");
		Thread.sleep(1000);
		ch.clickOnContinueAfterDeliveryMethod();
		Thread.sleep(1000);
		ch.selectTermsAndConditions();
		Thread.sleep(1000);
		ch.clickOnContinueAfterPaymentMethod();
		Thread.sleep(2000);

		String total_price_inOrderPage=ch.getTotalPriceBeforeConfOrder();
		System.out.println("total price in confirmed order page:"+total_price_inOrderPage);
		myassert.assertEquals(total_price_inOrderPage, "$207.00"); //validation

		//Below code works only if you configure SMTP for email's 
		/*ch.clickOnConfirmOrder();
		Thread.sleep(3000);

		boolean order conform=ch.isOrderPlaced();
		System.out.println("Is Order Placed? "+order conform);
		myassert.assertEquals(ch.isOrderPlaced(),true);*/

		myassert.assertAll(); //conclusion
	}



}

