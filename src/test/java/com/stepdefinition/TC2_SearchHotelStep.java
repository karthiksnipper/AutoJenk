package com.stepdefinition;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.manager.PageObjectManager;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import junit.framework.Assert;
/**
 * @author rajpr
 * @see used to maintain search hotel snippets
 * @date 15/02/2023
 */
public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();
	

	/**
	 * @see used to search hotel with valid details
	 * @param ddnLocation
	 * @param ddnHotel
	 * @param ddnRoomType
	 * @param ddnRoomNos
	 * @param picDateIn
	 * @param picDateOut
	 * @param ddnAdultRoom
	 * @param ddnChildRoom
	 */
	@When("User search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_hotel_and(String ddnLocation, String ddnHotel, String ddnRoomType, String ddnRoomNos, String picDateIn,
			String picDateOut, String ddnAdultRoom, String ddnChildRoom) {
		pom.getSearchHotelPage().searchHotels(ddnLocation, ddnHotel, ddnRoomType, ddnRoomNos, picDateIn, picDateOut, ddnAdultRoom, ddnChildRoom);
	    
	}
	/**
	 * @see used to verify after search hotel success message
	 * @param expselectHotelSuccessMsg
	 */
	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String expselectHotelSuccessMsg) {
		WebElement txtSelectHotelSuccessMsg = pom.getSelectHotelPage().getTxtSelectHotelSuccessMsg();
		String actSelectHotelSuccessMsg = elementGetText(txtSelectHotelSuccessMsg);
		Assert.assertEquals("verify after search hotel success message", expselectHotelSuccessMsg, actSelectHotelSuccessMsg);
	    
	}
	/**
	 * @see used to search only mandatory fields
	 * @param ddnLocation
	 * @param ddnRoomNos
	 * @param picDateIn
	 * @param picDateOut
	 * @param ddnAdultRoom
	 */
	@When("User search only mandatory fields {string},{string},{string},{string} and {string}")
	public void user_search_only_mandatory_fields_and(String ddnLocation, String ddnRoomNos, String picDateIn, String picDateOut, String ddnAdultRoom) {
	    pom.getSearchHotelPage().searchHotels(ddnLocation, ddnRoomNos, picDateIn, picDateOut, ddnAdultRoom);
	}
	/**
	 * @see used to search invalid checkin and checkout date
	 * @param ddnLocation
	 * @param ddnHotel
	 * @param ddnRoomType
	 * @param ddnRoomNos
	 * @param picDateIn
	 * @param picDateOut
	 * @param ddnAdultRoom
	 * @param ddnChildRoom
	 */
	@When("User search invalid checkin date and checkout date {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_search_invalid_checkin_date_and_checkout_date_and(String ddnLocation, String ddnHotel, String ddnRoomType, String ddnRoomNos, String picDateIn,
			String picDateOut, String ddnAdultRoom, String ddnChildRoom) {
		pom.getSearchHotelPage().searchHotels(ddnLocation, ddnHotel, ddnRoomType, ddnRoomNos, picDateIn, picDateOut, ddnAdultRoom, ddnChildRoom);
		
	    
	}
	/**
	 * @see used to verify after search hotel error message
	 * @param expInvalidDateInErrorMsg
	 * @param expInvalidDateOutErrorMsg
	 */
	@Then("User should verify after search hotel error message contains {string} and {string}")
	public void user_should_verify_after_search_hotel_error_message_contains(String expInvalidDateInErrorMsg, String expInvalidDateOutErrorMsg) {
	   WebElement txtCheckinErrorMsg = pom.getSearchHotelPage().getTxtCheckinErrorMsg();
	   String actCheckInErrorMsg  = elementGetText(txtCheckinErrorMsg);
	   //boolean dateInerror = actCheckInErrorMsg.contains(expInvalidDateInErrorMsg);
	   Assert.assertEquals("verifying after search hotel checkin error message contains", expInvalidDateInErrorMsg, actCheckInErrorMsg);
	   WebElement txtCheckOutErrorMsg = pom.getSearchHotelPage().getTxtCheckOutErrorMsg();
	   String actCheckOutErrorMsg = elementGetText(txtCheckOutErrorMsg);
	   //boolean dateOutError = actCheckOutErrorMsg.contains(expInvalidDateOutErrorMsg);
	   Assert.assertEquals("verifying after search hotel checkout error message contains", expInvalidDateOutErrorMsg, actCheckOutErrorMsg);
	   
	}
	/**
	 * @see used to search without enter any fields
	 */
	@When("User search without enter any fields")
	public void user_search_without_enter_any_fields() {
		pom.getSearchHotelPage().searchHotel();
		
	    	}
	/**
	 * @see used to verify after search with error message
	 * @param expectedpleaseSelectALocationErrorMsg
	 */
	@Then("User should verify after search with error message contains {string}")
	public void user_should_verify_after_search_with_error_message_contains(String expectedpleaseSelectALocationErrorMsg) {
		WebElement txtSelectHotelErrorMsg = pom.getSearchHotelPage().getTxtSelectHotelErrorMsg();
		String actSelectHotelErrorMsg = elementGetText(txtSelectHotelErrorMsg);
		//boolean b2 = actSelectHotelErrorMsg.contains(expectedpleaseSelectALocationErrorMsg);
		Assert.assertEquals("verify after search without enter any fields error message contains", expectedpleaseSelectALocationErrorMsg, actSelectHotelErrorMsg);
	    	}

  








	
	

	






	
	
	}






	
	






	










