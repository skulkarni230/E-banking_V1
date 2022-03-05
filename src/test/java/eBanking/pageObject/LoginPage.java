package eBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	/*
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}*/
	

	@FindBy(name = "uid")
	@CacheLookup // keeps the webelement in cache instead of looking every time from page
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup // keeps the webelement in cache instead of looking every time from page
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup // keeps the webelement in cache instead of looking every time from page
	WebElement btnLogin;

	@FindBy(name = "btnReset")
	@CacheLookup // keeps the webelement in cache instead of looking every time from page
	WebElement btnReset;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement btnLogout;

	
	
	

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickReset() {
		btnReset.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}

}
