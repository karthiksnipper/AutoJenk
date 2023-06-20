package com.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author rajpr
 * @see used to maintain login page locators
 * @date 14/02/2023
 */
public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassWord;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	
	@FindBy(xpath="//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement txtErrorLogin;
	

	public WebElement getTxtErrorLogin() {
		return txtErrorLogin;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassWord() {
		return txtPassWord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @see used to login with valid and invalid credentials
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) {
		elementInsertValue(getTxtUserName(), userName);
		elementInsertValue(getTxtPassWord(), password);
		elementClick(getBtnLogin());
		
		

	}
	/**
	 * @see used to login using Enter key
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	public void loginWithEntryKey(String userName, String password) throws AWTException {
		elementInsertValue(getTxtUserName(), userName);
		elementInsertValue(getTxtPassWord(), password);
		keyPress(KeyEvent.VK_TAB);
		keyRelease(KeyEvent.VK_TAB);
		keyPress(KeyEvent.VK_TAB);
		keyRelease(KeyEvent.VK_TAB);
		keyPress(KeyEvent.VK_ENTER);
		keyRelease(KeyEvent.VK_ENTER);
		
		
		}

}
