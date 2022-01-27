/**
 * 
 */
package ktctc.ebanking.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import ktctc.ebanking.actiondriver.Action;
import ktctc.ebanking.base.BaseClass;

/**
 * @author  KTCTC D3 Shreyas
 *
 */
public class HomePage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//*[text()='Account Number:']")
	WebElement accnotext;
	
	@FindBy(xpath="//*[text()=' 58393462390']")
	WebElement accnum;
	
	@FindBy(xpath="//*[@id='balance']")
	WebElement Balance;
	
	@FindBy(xpath="//*[contains(text(),'Transfer')]")
	WebElement banktransfer;
	
	@FindBy(xpath = "/html/body/section/div/div/div/div[1]/div/div[2]/nav/ul/li[2]/a")
	WebElement transfer;
	
	@FindBy(xpath="//*[text()='Direct Withdraw']")
	WebElement withdraw;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[1]/div/div[2]/nav/ul/li[3]/a")
	WebElement Depositbtn;
	
	@FindBy(xpath="//*[contains(text(),'Fixed Deposit package')]")
	WebElement fixedsepositpackagebtn;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[1]/div/div[2]/nav/ul/li[4]/a")
	WebElement loanBtn;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[1]/div/div[2]/nav/ul/li[4]/ul/li[1]/a")
	WebElement loanPackageBtn;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyHomePage() {
		return action.isDisplayed(getDriver(), accnotext);
	}
	
	public String verifyAccountNo() {
		String accnumber = accnum.getText();
		return accnumber;
	}
	
	public double verifyBalance() {
		action.fluentWait(getDriver(), Balance, 20);
		String bal = Balance.getText();
		String newbal = bal.replace("$","");
		double acbal = Double.parseDouble(newbal);
		return acbal;
	}
	
	public boolean verifyBalance1() {
		action.fluentWait(getDriver(), Balance, 20);
		return action.isDisplayed(getDriver(), Balance);
	}
	
	public TransferPage clickOnTransfer() {
		action.click(getDriver(), transfer);
		action.click(getDriver(), banktransfer);
		action.implicitWait(getDriver(), 10);
		return new TransferPage();
	}
	
	public TransferPage clickOnWithdraw() {
		action.click(getDriver(), transfer);
		action.click(getDriver(), withdraw);
		action.implicitWait(getDriver(), 10);
		return new TransferPage();
	}
	
	public DepositPage clickOnDeposit() {
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), Depositbtn);
		action.click(getDriver(), fixedsepositpackagebtn);
		action.implicitWait(getDriver(), 10);
		return new DepositPage();
	}
	
	public LoanPage clickOnLoanBtn() {
		action.implicitWait(getDriver(), 10);
		action.click(getDriver(), loanBtn);
		action.click(getDriver(), loanPackageBtn);
		return new LoanPage();
	}


}
