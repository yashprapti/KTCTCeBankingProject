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
import ktctc.ebanking.pageobject.LoanPage;
import ktctc.ebanking.pageobject.LoginPage;
import ktctc.ebanking.utility.Log;

/**
 * @author KTCTC D3 Shreyas
 */
public class LoanPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	LoanPage loanpage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyCarLoanRequestTest() {
		Log.startTestCase("verifyCarLoanRequestTest");
		loginpage = new LoginPage();
		Log.info("user is trying to enter username and password");
		homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("user entered username and password sucssesfully");
		loanpage = homepage.clickOnLoanBtn();
		Log.info("user entered on loan page sucssesfully");
		String acmsg = loanpage.validateCarLoan("100");
		String exmsg = "Loan Request Send Successfully";
		Log.info("Validating Carloan request");
		Assert.assertEquals(acmsg, exmsg);
		Log.info("Carloan request validation Successfull");
		Log.endTestCase("verifyCarLoanRequestTest");
	}

}
