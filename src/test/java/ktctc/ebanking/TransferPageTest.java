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
import ktctc.ebanking.pageobject.HomePage;
import ktctc.ebanking.pageobject.LoginPage;
import ktctc.ebanking.pageobject.TransferPage;
import ktctc.ebanking.utility.Log;

/**
 * @author KTCTC D3 Shreyas
 *
 */
public class TransferPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	TransferPage transferpage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void validateBankTransfer() {
		Log.startTestCase("validateBankTransfer");
		loginpage = new LoginPage();
		Log.info("user is trying to enter username and password");
		homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("user entered username and password sucssesfully");
		transferpage = homepage.clickOnTransfer();
		Log.info("user entered on Transfer page sucssesfully");
		String acttext = transferpage.varifyBanktransfer("16578621229", "100");
		String extext = "OTP Confirm";
		Log.info("Validating Transfer request");
		Assert.assertEquals(acttext, extext);
		Log.info("Transfer request validation Successfull");
		Log.endTestCase("validateBankTransfer");
	}
	
	@Test(groups="Smoke")
	public void validateWithdraw() {
		Log.startTestCase("validateWithdraw");
		loginpage = new LoginPage();
		Log.info("user is trying to enter username and password");
		homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("user entered username and password sucssesfully");
		transferpage = homepage.clickOnWithdraw();
		Log.info("user entered on Withdraw page sucssesfully");
		String acttext = transferpage.verifyWithdraw("CAD", "100");
		String extext = "OTP Confirm";
		Log.info("Validating Withdraw request");
		Assert.assertEquals(acttext, extext);
		Log.info("Wthdraw request validation Successfull");
		Log.endTestCase("validateWithdraw");
	}

}
