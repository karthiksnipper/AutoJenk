package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
/**
 * @author rajpr
 * @see used to maintain booking hotel snippets 
 * @date 15/02/2023
 */
public class TC4_BookingHotelStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	
	/**
	 * @see used to enter booking with valid details
	 * @param txtFirstName
	 * @param txtLastName
	 * @param txtAddress
	 * @param dataTable
	 */
	@When("User enter booking details {string},{string} and {string}")
	public void user_enter_booking_details(String txtFirstName,String txtLastName,String txtAddress, io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String,String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String txtCardNo = map.get("ccNum");
		String ddnCardType = map.get("ccType");
		String ddnExpMonth = map.get("ccExpMonth");
		String ddnExpYear = map.get("ccExpYear");
		String txtCvv = map.get("ccCvv");
		
		pom.getBookHotelPage().bookHotel(txtFirstName, txtLastName, txtAddress, txtCardNo, ddnCardType, ddnExpMonth, ddnExpYear, txtCvv);
	    
	}
	/**
	 * @see used to verify after enter book now success message
	 * @param expBookingConfirmationSuccessMsg
	 */
	@Then("User should verify after enter book now success message {string} and save the orderId")
	public void user_should_verify_after_enter_book_now_success_message_and_save_the_orderId(String expBookingConfirmationSuccessMsg) {
		implicitWait(20);
		WebElement txtBookingConfirmationSuccessMsg = pom.getBookHotelPage().getTxtBookingConfirmationSuccessMsg();
		String actBookConfirmationSuccessMsg = elementGetText(txtBookingConfirmationSuccessMsg);
		Assert.assertEquals("verify after enter book now success message", expBookingConfirmationSuccessMsg, actBookConfirmationSuccessMsg);
		pom.getBookingConfirmationPage().getOrderId();
	    
	}
	/**
	 * @see used to click book now button without enter booking details
	 */
	@When("User click book now button without enter booking details")
	public void user_click_book_now_button_without_enter_booking_details() {
		pom.getBookHotelPage().bookHotel();
	    
	}
	/**
	 * @see used to verify after click book now button error message
	 * @param expFirstNameErrorMsg
	 * @param expLastNameErrorMsg
	 * @param expAddressErrorMsg
	 * @param expCcNumberErrorMsg
	 * @param expCcTypeErrorMsg
	 * @param expCcExpiryMonthErrorMsg
	 * @param expCcCvvNumberErrorMsg
	 */
	@Then("User should verify after click book now button error message contains {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_click_book_now_button_error_message_contains(String expFirstNameErrorMsg, String expLastNameErrorMsg, 
String expAddressErrorMsg, String expCcNumberErrorMsg, String expCcTypeErrorMsg, String expCcExpiryMonthErrorMsg, String expCcCvvNumberErrorMsg)
	{
		WebElement txtFirstNameErrorMsg = pom.getBookHotelPage().getTxtFirstNameErrorMsg();
		String actFirstNameErrorMsg = elementGetText(txtFirstNameErrorMsg);
		Assert.assertEquals("verify after click book now button first name error message contains", expFirstNameErrorMsg, actFirstNameErrorMsg);
		
		WebElement txtLastNameErrorMsg = pom.getBookHotelPage().getTxtLastNameErrorMsg();
		String actLastNameErrorMsg = elementGetText(txtLastNameErrorMsg);
		Assert.assertEquals("verify after click book now button last name error message contains", expLastNameErrorMsg, actLastNameErrorMsg);
		
		WebElement txtAddressErrorMsg = pom.getBookHotelPage().getTxtAddressErrorMsg();
		String actAddressErrorMsg = elementGetText(txtAddressErrorMsg);
		Assert.assertEquals("verify after click book now button address error message contains", expAddressErrorMsg, actAddressErrorMsg);
		
		WebElement txtCcNumErrorMsg = pom.getBookHotelPage().getTxtCcNumErrorMsg();
		String actCcNumErrorMsg = elementGetText(txtCcNumErrorMsg);
		Assert.assertEquals("verify after click book now button credit card number error message contains", expCcNumberErrorMsg, actCcNumErrorMsg);
		
		WebElement txtCcTypeErrorMsg = pom.getBookHotelPage().getTxtCcTypeErrorMsg();
		String actCcTypeErrorMsg = elementGetText(txtCcTypeErrorMsg);
		Assert.assertEquals("verify after click book now button CcType error message contains", expCcTypeErrorMsg, actCcTypeErrorMsg);
		
		WebElement txtCcExpiryErrorMsg = pom.getBookHotelPage().getTxtCcExpiryErrorMsg();
		String actCcExpiryMonthErrorMsg = elementGetText(txtCcExpiryErrorMsg);
		Assert.assertEquals("verify after click book now button expiry month error message contains", expCcExpiryMonthErrorMsg, actCcExpiryMonthErrorMsg);
		
		WebElement txtCvvErrorMsg = pom.getBookHotelPage().getTxtCvvErrorMsg();
		String actCvvErrorMsg = elementGetText(txtCvvErrorMsg);
		Assert.assertEquals("verify after click book now button cvv error message contains", expCcCvvNumberErrorMsg, actCvvErrorMsg);
		
	    
	}








}
