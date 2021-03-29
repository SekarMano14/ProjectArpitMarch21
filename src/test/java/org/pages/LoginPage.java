package org.pages;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBys({@FindBy(id = "email"),
	          @FindBy(xpath="//input[@name='email']")})
	private List<WebElement> txtUsername;

	@FindAll({@FindBy(id = "pass"),
        @FindBy(xpath="//input[@name='password']")})
	private WebElement txtPassword;

	@FindBy(name = "login")
	private WebElement btnLogin;

	public  List<WebElement> getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

}
