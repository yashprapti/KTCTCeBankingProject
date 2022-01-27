/**
 * 
 */
package ktctc.ebanking;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ktctc.ebanking.base.BaseClass;
import ktctc.ebanking.pageobject.DepositPage;
import ktctc.ebanking.pageobject.HomePage;
import ktctc.ebanking.pageobject.LoginPage;
import ktctc.ebanking.utility.Log;

/**
 * @author KTCTC D3 Shreyas
 *
 */
public class DepositPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	DepositPage depositpage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups="Sanity")
	public void validateDeposit() {
		Log.startTestCase("validateDeposit");
		loginpage = new LoginPage();
		Log.info("user is trying to enter username and password");
		homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("user entered username and password sucssesfully");
		depositpage = homepage.clickOnDeposit();
		Log.info("user entered on Deposit page sucssesfully");
		String acmsg = depositpage.verifyDeposit("5");
		String exmsg = "Thanks! Deposit Successfull";
		Log.info("Validating Deposit request");
		Assert.assertEquals(acmsg, exmsg);
		Log.info("Deposit request validation Successfull");
		Log.endTestCase("validateDeposit");
	}

}
