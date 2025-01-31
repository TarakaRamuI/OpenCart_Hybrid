package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.Homepage;
import pageObjcts.Search_Page;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass
{
	
	@Test(groups= {"Master"})
	public void verify_pruductSearch() throws InterruptedException {
		
		
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			Homepage hm=new Homepage(driver);
			
			//hm.enterProductName("iPhone");
			hm.enterProductName("mac");
			
			hm.clickSearch();
			
			Search_Page sp=new Search_Page(driver);
			
			sp.isProductExist("MacBook");

			Assert.assertEquals(sp.isProductExist("MacBook"),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}



