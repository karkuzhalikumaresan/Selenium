package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.BaseClass;
import test.BaseClass1;

public class LoginPage extends BaseClass1{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	private WebElement txtEmail;

	@FindBy(id="pass")
	private WebElement txtPass;

	@FindBy(xpath="//button[text()='Login']")
	private WebElement btnLogin;

	public WebElement getTxtEmail() {
		return txtEmail;
	}


	public WebElement getTxtPass() {
		return txtPass;
	}


	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String emailId,String password) {
		elementSendKeys(txtEmail, emailId);
		elementSendKeys(txtPass, password);
		elementClick(btnLogin);
	}



}
