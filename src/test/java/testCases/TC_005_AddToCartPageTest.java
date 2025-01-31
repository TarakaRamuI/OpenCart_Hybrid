package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.Homepage;
import pageObjcts.Search_Page;
import testBase.BaseClass;

public class TC_005_AddToCartPageTest extends BaseClass {


	@Test(groups= {"Master"})
	public void verify_addToCart() throws InterruptedException {
		logger.info(" Starting TC_005_AddToCartPageTest ");

		try {

			Homepage hp=new Homepage(driver);

			hp.enterProductName("iPhone");
			hp.clickSearch();


			Search_Page sp=new Search_Page(driver);

			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				sp.setQuantity("2");
				sp.addToCart();

			}

			Assert.assertEquals(sp.checkConfMsg(),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}



