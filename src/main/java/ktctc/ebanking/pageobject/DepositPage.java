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
 * @author KTCTC D3 Shreyas
 *
 */
public class DepositPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//*[@data-bs-target='#exampleModal10']")
	WebElement dayDepositBtn;
	
	@FindBy(xpath="//*[@id=\"exampleModal10\"]/div/div/div[2]/form/div[1]/input")
	WebElement enteramount;
	
	@FindBy(xpath="//*[@id=\"exampleModal10\"]/div/div/div[2]/form/div[2]/div/button")
	WebElement submitBtn;
	
	@FindBy(xpath="//*[@id=\"swal2-title\"]")
	WebElement sucssesmasg;
	
	public DepositPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String verifyDeposit(String amount) {
		action.click(getDriver(), dayDepositBtn);
		action.type(enteramount, amount);
		action.click(getDriver(), submitBtn);
		action.implicitWait(getDriver(), 10);
		String acmsg = sucssesmasg.getText();
		return acmsg;
	}

}
