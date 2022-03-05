package eBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addNewCutomerLink;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement name;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement gender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement dob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement address;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement city;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement state;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement pinCode;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement phone;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement mail;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement submit;

	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement reset;

	public void clickAddNewCustomer() {
		addNewCutomerLink.click();
	}

	public void custname(String cname) {
		name.sendKeys(cname);
	}

	public void custdgender(String cgender) {
		gender.sendKeys(cgender);
	}

	public void custdob(String mm, String dd, String yyyy) {
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}

	public void custdaddress(String caddress) {
		address.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		city.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		state.sendKeys(cstate);
	}

	public void custpin(String cpin) {
		pinCode.sendKeys(String.valueOf(cpin));
	}

	public void custmobile(String cmobile) {
		phone.sendKeys(cmobile);
	}

	public void custmail(String cmail) {
		mail.sendKeys(cmail);
	}

	public void custpassword(String cpassword) {
		password.sendKeys(cpassword);
	}

	public void clickSubmit() {
		submit.click();
	}

	public void clickReset() {
		reset.click();
	}
}
