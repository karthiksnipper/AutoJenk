package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * @author rajpr
 * @see used to maintain login snippets
 * @date 15/02/2023
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	/**
     * @throws IOException 
	 * @throws FileNotFoundException 
	 * @see used to launch url
     */
	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() {
		
	}
	/**
	 * @see used to perform login with valid credentials
	 * @param userName
	 * @param password
	 */
	@When("User perform login {string},{string}")
	public void user_perform_login(String userName, String password) {
		pom.getLoginPage().login(userName, password);
		
	    
	}
	/**
	 * @see used to perform login with entry key
	 * @param userName
	 * @param password
	 * @throws AWTException 
	 */
	@When("User perform login {string},{string} with Entry Key")
	public void user_perform_login_with_entry_key(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEntryKey(userName, password);
	    
	}
	/**
	 * @see used to login with invalid credentials and verify error message
	 * @param expextedInvalidLoginErroeMsg
	 */
	@Then("User should verify after login with invalid credentials error message contains {string}")
	public void user_should_verify_after_login_with_invalid_credentials_error_message_contains(String expextedInvalidLoginErrorMsg) {
	    WebElement txtErrorLogin = pom.getLoginPage().getTxtErrorLogin();
	    String actLoginErrorMsg = elementGetText(txtErrorLogin);
	    boolean b = actLoginErrorMsg.contains(expextedInvalidLoginErrorMsg);
	    Assert.assertTrue("verify after login with Invalid credentials error Msg contains",b);
	}










}
