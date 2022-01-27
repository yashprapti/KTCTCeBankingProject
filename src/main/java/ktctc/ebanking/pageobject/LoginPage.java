package ktctc.ebanking.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ktctc.ebanking.actiondriver.Action;
import ktctc.ebanking.base.BaseClass;

/**
 * @author KTCTC D3 Shreyas
 *
 */
public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//*[@placeholder='Enter Email Address']")
	WebElement enteremail;
	
	@FindBy(xpath="//*[@placeholder='Password']")
	WebElement enterpassword;
	
	@FindBy(xpath="/html/body/section/div/div/div/div/div/form/div/div[4]/div/div/button")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@src=\"https://ktctc.in/assets/img/KTCTC%20LOGO.png\"]")
	WebElement Logo;
	
	@FindBy(xpath="/html/body/section/div/div/div/div/div/form/div/div[5]/div/div/p/a")
	WebElement registerBtn;
	
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage loginToHomePage(String email,String pwd) {
		action.fluentWait(getDriver(), enteremail, 10);
		action.type(enteremail, email);
		action.type(enterpassword, pwd);
		action.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	public boolean verifyLogo() {
		action.fluentWait(getDriver(), Logo, 10);
		return action.findElement(getDriver(), Logo);
	}
	
	public RegistrationPage navigateToRegistrationPage() {
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), registerBtn);
		return new RegistrationPage();
	}
	}


