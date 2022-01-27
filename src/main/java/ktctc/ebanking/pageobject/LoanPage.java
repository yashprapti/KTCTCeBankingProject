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
public class LoanPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//*[@id=\"swal2-title\"]")
	WebElement successmsg;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[3]/a")
	WebElement carRequestLoanBtn;
	
	@FindBy(xpath="//*[@id=\"exampleModal4\"]/div/div/div[2]/form/div[1]/input")
	WebElement enteramount;
	
	@FindBy(xpath="//*[@id=\"exampleModal4\"]/div/div/div[2]/form/div[2]/div/button")
	WebElement submitBtn;
	
	public LoanPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateCarLoan(String amount) {
		action.click(getDriver(), carRequestLoanBtn);
		action.implicitWait(getDriver(), 10);
		action.type(enteramount, amount);
		action.click(getDriver(), submitBtn);
		String sucmsg = successmsg.getText();
		return sucmsg;
	}

}
