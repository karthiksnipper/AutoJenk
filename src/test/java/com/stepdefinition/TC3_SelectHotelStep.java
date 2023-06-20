package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
/**
 * @author rajpr
 * @see used to maintain select hotel snippets
 * @date 15/02/2023
 */
public class TC3_SelectHotelStep extends BaseClass{
	PageObjectManager pom=new PageObjectManager();
	/**
	 * @see used to continue with select hotel
	 */
	@When("User continue with select hotel")
	public void user_continue_with_select_hotel() {
		pom.getSelectHotelPage().selectHotelName();
	    
	}
	/**
	 * @see used to verify after continue success message
	 * @param expBookAHotelSuccesMsg
	 */
	@Then("User should verify after continue success message {string}")
	public void user_should_verify_after_continue_success_message(String expBookAHotelSuccesMsg) {
		WebElement txtBookHotelSuccessMsg = pom.getSelectHotelPage().getTxtBookHotelSuccessMsg();
		String actBookHotelSuccessMsg = elementGetText(txtBookHotelSuccessMsg);
		Assert.assertEquals("verify after continue book hotel success message", expBookAHotelSuccesMsg, actBookHotelSuccessMsg);
	    
	}
	/**
	 * @see used to continue without select hotel
	 */
	@When("User continue without select hotel")
	public void user_continue_without_select_hotel() {
		pom.getSelectHotelPage().clickContinue();
	   
	}
	/**
	 * @see used to verify after continue error message contains
	 * @param expPleaseSelectAHotelErrorMsg
	 */
	@Then("User should verify after continue error message contains {string}")
	public void user_should_verify_after_continue_error_message_contains(String expPleaseSelectAHotelErrorMsg) {
		WebElement txtSelectHotelErrorMsg = pom.getSelectHotelPage().getTxtSelectHotelErrorMsg();
		String actSelectHotelErrorMsg = elementGetText(txtSelectHotelErrorMsg);
		Assert.assertEquals("verify after continue select hotel error message contains", expPleaseSelectAHotelErrorMsg, actSelectHotelErrorMsg);
	    	}







}
