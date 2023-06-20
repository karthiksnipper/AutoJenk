package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
/**
 * @author rajpr
 * @see used to maintain cancel booking snippets
 * @date 15/02/2023
 */
public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	
	/**
	 * @see used to cancel the booking order id
	 */
	@When("User cancel the booking order id")
	public void user_cancel_the_booking_order_id() {
		String norderId = pom.getBookingConfirmationPage().getOrderId();
		pom.getCancelBookingPage().cancelOrderId(norderId);
		
		
		
	    
	}
	/**
	 * @see used to verify after cancel order id success message
	 * @param expBookingConfirmSuccessMsg
	 */
	@Then("User should verify after cancel order id success message {string}")
	public void user_should_verify_after_cancel_order_id_success_message(String expBookingConfirmSuccessMsg) {
		WebElement cancelBookingSuccessMsg = pom.getCancelBookingPage().getCancelCheckingSuccessMsg();
		String actCancelBookingSuccessMsg = elementGetText(cancelBookingSuccessMsg);
		Assert.assertEquals("verify after cancel order id success message", expBookingConfirmSuccessMsg, actCancelBookingSuccessMsg);
	    
	}
	/**
	 * @see used to cancel existing order id
	 * @param orderId
	 */
	@When("User cancel existing order id {string}")
	public void user_cancel_existing_order_id(String orderId) {
		
		pom.getCancelBookingPage().cancelOrderId(orderId);
	    
	}
	






}
