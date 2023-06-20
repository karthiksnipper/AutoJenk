package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/** 
 * @author rajpr
 * @see used to maintain cancel booking page locators
 * @date 14/02/2023
 */
public class CancelBookingPage extends BaseClass{
	
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement lnkBookedItinerary;
	
	@FindBy(id="order_id_text")
	private WebElement txtSearchBox;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnSearch;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCanvelOrderId;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	private WebElement rdoBtnSelect;
	
	@FindBy(xpath="//label[contains(text(),'cancelled')]")
	private WebElement cancelCheckingSuccessMsg;
	
	
	


	public WebElement getBtnCanvelOrderId() {
		return btnCanvelOrderId;
	}

	public WebElement getRdoBtnSelect() {
		return rdoBtnSelect;
	}

	public WebElement getCancelCheckingSuccessMsg() {
		return cancelCheckingSuccessMsg;
	}

	public WebElement getlnkBookedItinerary() {
		return lnkBookedItinerary;
	}

	public WebElement gettxtSearchBox() {
		return txtSearchBox;
	}

	public WebElement getbtnSearch() {
		return btnSearch;
	}


	/**
	 * @see used to cancel booking order id
	 * @param OrderId
	 */
	public void cancelOrderId(String orderId) {
		elementClick(getlnkBookedItinerary());
		elementInsertValue(gettxtSearchBox(), orderId);
		elementClick(getbtnSearch());
		elementClick(getRdoBtnSelect());
		elementClick(getBtnCanvelOrderId());
		clickAlertOk();
		

	}
	
	
	
	

}
