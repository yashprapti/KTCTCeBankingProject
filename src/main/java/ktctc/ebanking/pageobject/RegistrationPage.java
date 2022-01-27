/**
 * 
 */
package ktctc.ebanking.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ktctc.ebanking.actiondriver.Action;
import ktctc.ebanking.base.BaseClass;

/**
 * @author LENOVO
 *
 */
public class RegistrationPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id="name")
	WebElement EnterName;
	
	@FindBy(xpath="//*[@placeholder='Enter Email Address']")
	WebElement EnterEmail;
	
	@FindBy(xpath="//*[@name='phone_code']")
	WebElement CountryCode;
	
	@FindBy(id="phone")
	WebElement EnterPhone;
	
	@FindBy(id="password")
	WebElement EnterPassword;
	
	@FindBy(id="password-confirm")
	WebElement ReEnterPassword;
	
	@FindBy(id="term_condition")
	WebElement termscheckbox;
	
	@FindBy(xpath="/html/body/section/div/div/div/div/div/form/div/div[7]/div/div/button")
	WebElement RegisterBtn;
	
	@FindBy(xpath="//*[contains(text(),'Your account is not active please contact administartor for activating your accout!')]")
	WebElement cnfmsg;
	
	public RegistrationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String newRegistration(
			String name,
			String email,
			String code,
			String phone,
			String pwd,
			String cnfpwd
			) {
		action.implicitWait(getDriver(), 10);
		action.type(EnterName, name);
		action.type(EnterEmail, email);
		action.selectByVisibleText(code, CountryCode);
		action.type(EnterPhone, phone);
		action.type(EnterPassword, pwd);
		action.type(ReEnterPassword, cnfpwd);
		action.click(getDriver(),termscheckbox);
		//action.scrollByVisibilityOfElement(getDriver(), RegisterBtn);
		action.click(getDriver(), RegisterBtn);
		action.explicitWait(getDriver(), cnfmsg, 10);
		String acmsg = action.getCurrentURL(getDriver());
		return acmsg;
	}

}
