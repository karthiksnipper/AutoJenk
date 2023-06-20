package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
/**
 * @author rajpr
 * @see used to maintain common step snippets
 * @date 15/02/2023
 */
public class CommonStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	
	/**
	 * @see used to verify after login success message
	 * @param expSelectHotelSuccessMsg
	 */
	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String expSelectHotelSuccessMsg) {
		WebElement txtUserNameSuccessMsg = pom.getSearchHotelPage().getTxtUserNameSuccessMsg();
		String actLoginSuccessMsg = elementGetAttribute(txtUserNameSuccessMsg, "value");
		Assert.assertEquals(expSelectHotelSuccessMsg, actLoginSuccessMsg);
	   
	}


}
