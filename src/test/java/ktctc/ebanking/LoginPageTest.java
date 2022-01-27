/**
 * 
 */
package ktctc.ebanking;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ktctc.ebanking.base.BaseClass;
import ktctc.ebanking.dataprovider.DataProviders;
import ktctc.ebanking.pageobject.HomePage;
import ktctc.ebanking.pageobject.LoginPage;
import ktctc.ebanking.utility.Log;

/**
 * @author KTCTC D3 Shreyas
 *
 */
public class LoginPageTest extends BaseClass {
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
	
	@Test(dataProvider="credentials",dataProviderClass = DataProviders.class,groups= {"Smoke","Sanity","Regression"})
	public void loginToHomePageTest(String uname,String pwd) {
		Log.startTestCase("loginToHomePageTest");
		loginpage = new LoginPage();
		Log.info("User Is Going to Enter Username and Password");
		//homepage = loginpage.loginToHomePage(prop.getProperty("username"), prop.getProperty("password"));
		homepage = loginpage.loginToHomePage(uname, pwd);
		Log.info("Username and Password is Entered Successfully");
		boolean result = homepage.verifyHomePage();
		Log.info("Verifying user is able to login to home page");
		Assert.assertTrue(result);
	}
	
}
