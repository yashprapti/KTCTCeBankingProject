/**
 * 
 */
package ktctc.ebanking;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ktctc.ebanking.base.BaseClass;
import ktctc.ebanking.pageobject.HomePage;
import ktctc.ebanking.pageobject.LoginPage;
import ktctc.ebanking.utility.Log;

/**
 * @author KTCTC D3 Shreyas
 *
 */
public class HomePageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void validateAccNo() {
		Log.startTestCase("validateAccNo");
		loginpage = new LoginPage();
		Log.info("user is trying to enter username and password");
		homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("user entered username and password sucssesfully");
		String actaccno = homepage.verifyAccountNo();
		String exaccno = "Account Number: 58393462390";
		Log.info("verifying actaul and expexted strings");
		Assert.assertEquals(actaccno, exaccno);
		Log.info("actaul and expexted strings are validated sussessfully");
		Log.endTestCase("validateAccNo");
	}
	
	@Test(groups= {"Sanity","Smoke"})
	public void validateBalance() {
		Log.startTestCase("validateBalance");
		loginpage = new LoginPage();
		Log.info("user is trying to enter username and password");
		homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("user entered username and password sucssesfully");
		boolean  result = homepage.verifyBalance1();
		Log.info("verifying balance");
		Assert.assertTrue(result);
		Log.info("balance validated sussessfully");
		Log.endTestCase("validateBalance");
	}
	
}
