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
import ktctc.ebanking.pageobject.LoginPage;
import ktctc.ebanking.pageobject.RegistrationPage;
import ktctc.ebanking.utility.Log;

/**
 * @author KTCTC D3 Shreyas
 *
 */
public class RegistrationPageTest extends BaseClass{
	
	LoginPage loginpage;
	RegistrationPage regpage;
	
	@Parameters("browser")
	
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void validateRegistrationTest() {
		Log.startTestCase("validateRegistrationTest");
		loginpage = new LoginPage();
		Log.info("User is navigating to Registraion Page");
		regpage = loginpage.navigateToRegistrationPage();
		Log.info("User is on Registraion Page");
		Log.info("User is Entering Details in Registraion Form");
		String actext = regpage.newRegistration("pqrs", "pqrs@mailinator.com", "IN +91", "9898989898", "pqrs@123", "pqrs@123");
		Log.info("Successfully filled Registraion Form");
		String extext = "Your account is not active please contact administartor for activating your accout!";
		Log.info("Verifying Registraion confirmation");
		Assert.assertEquals(actext, extext);
		Log.info("New Registraion successfull and waiting for activation");
		Log.endTestCase("validateRegistrationTest");
	}

}
