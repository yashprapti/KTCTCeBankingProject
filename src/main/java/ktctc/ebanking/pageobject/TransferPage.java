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
public class TransferPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(name="account_no")
	WebElement enteraccno;
	
	@FindBy(name="amount")
	WebElement enteramount;
	
	@FindBy(xpath="//*[@class='d-block w-100']")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@class='basicbtn btn btn-primary my-4 w-100']")
	WebElement submitBtn2;
	
	@FindBy(xpath="//*[text()='OTP Confirm']")
	WebElement otpcnf;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[3]/a")
	WebElement lowcosttransferBtn;
	
	@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[2]/form/div[1]/select")
	WebElement selectcurrency;
	
	@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[2]/form/div[2]/input")
	WebElement selectamount;
	
	@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[2]/form/div[3]/div/button")
	WebElement withdrawsubmitbtn;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[2]/div/div[2]/div/div/form/div[2]/button")
	WebElement cnfsubmitbtn;
	
	public TransferPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String varifyBanktransfer(String accno,String amount) {
		action.type(enteraccno, accno);
		action.type(enteramount, amount);
		action.click(getDriver(), submitbtn);
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), submitBtn2);
		action.fluentWait(getDriver(), otpcnf, 10);
		String acttext = otpcnf.getText();
		return acttext;
		
	}
	
	public String verifyWithdraw(String currency,String amount) {
		action.click(getDriver(), lowcosttransferBtn);
		action.implicitWait(getDriver(), 10);
		action.selectByVisibleText(currency, selectcurrency);
		action.type(selectamount, amount);
		action.click(getDriver(), withdrawsubmitbtn);
		action.fluentWait(getDriver(), cnfsubmitbtn, 10);
		action.click(getDriver(), cnfsubmitbtn);
		action.fluentWait(getDriver(), otpcnf, 10);
		String acttext = otpcnf.getText();
		return acttext;
	}

}
