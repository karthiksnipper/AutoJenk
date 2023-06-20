package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author rajpr
 * @see used to maintain search hotel page locators
 * @date 14/02/2023
 */
public class SearchHotelPage extends BaseClass{
	
	public SearchHotelPage(){
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="username_show")
	private WebElement txtUserNameSuccessMsg;
	
	@FindBy(name="location")
	private WebElement ddnLocation;

	@FindBy(name="hotels")
	private WebElement ddnHotel;

	@FindBy(name="room_type")
	private WebElement ddnRoomType;

	@FindBy(name="room_nos")
	private WebElement ddnRoomNos;

	@FindBy(id="datepick_in")
	private WebElement picDateIn;

	@FindBy(id="datepick_out")
	private WebElement picDateOut;

	@FindBy(name="adult_room")
	private WebElement ddnAdultRoom;

	@FindBy(name="child_room")
	private WebElement ddnChildRoom;

	@FindBy(name="Submit")
	private WebElement btnLogin;
	
	@FindBy(id="checkin_span")
	private WebElement txtCheckinErrorMsg;
	
	@FindBy(id="checkout_span")
	private WebElement txtCheckOutErrorMsg;
	
	@FindBy(id="location_span")
	private WebElement txtSelectHotelErrorMsg;

	public WebElement getTxtSelectHotelErrorMsg() {
		return txtSelectHotelErrorMsg;
	}

	public WebElement getTxtUserNameSuccessMsg() {
		return txtUserNameSuccessMsg;
	}

	public WebElement getTxtCheckinErrorMsg() {
		return txtCheckinErrorMsg;
	}

	public WebElement getTxtCheckOutErrorMsg() {
		return txtCheckOutErrorMsg;
	}

	public WebElement getddnLocation() {
		return ddnLocation;
	}

	public WebElement getddnHotel() {
		return ddnHotel;
	}

	public WebElement getddnRoomType() {
		return ddnRoomType;
	}

	public WebElement getddnRoomNos() {
		return ddnRoomNos;
	}

	public WebElement getPicDateIn() {
		return picDateIn;
	}

	public WebElement getPicDateOut() {
		return picDateOut;
	}

	public WebElement getddnAdultRoom() {
		return ddnAdultRoom;
	}

	public WebElement getddnChildRoom() {
		return ddnChildRoom;
	}

	public WebElement getbtnLogin() {
		return btnLogin;
	}

	/**
	 * @see used to search by selecting all fields and mandatory fields with valid details
	 * @param ddnLocation
	 * @param ddnHotel
	 * @param ddnRoomType
	 * @param ddnRoomNos
	 * @param picDateIn
	 * @param picDateOut
	 * @param ddnAdultRoom
	 * @param ddnChildRoom
	 */
	public void searchHotels(String ddnLocation, String ddnHotel, String ddnRoomType, String ddnRoomNos, String picDateIn,
			String picDateOut, String ddnAdultRoom, String ddnChildRoom) {
		dropDownByText(getddnLocation(), ddnLocation);
		dropDownByText(getddnHotel(), ddnHotel);
		dropDownByText(getddnRoomType(), ddnRoomType);
		dropDownByText(getddnRoomNos(), ddnRoomNos);
		clearTextBox(getPicDateIn());
		elementInsertValue(getPicDateIn(), picDateIn);
		clearTextBox(getPicDateOut());
		elementInsertValue(getPicDateOut(), picDateOut);
		dropDownByText(getddnAdultRoom(), ddnAdultRoom);
		dropDownByText(getddnChildRoom(), ddnChildRoom);
		elementClick(getbtnLogin());

}
	/**
	 * @see used to checking invalid date details
	 * @param ddnLocation
	 * @param ddnRoomNos
	 * @param picDateIn
	 * @param picDateOut
	 * @param ddnAdultRoom
	 */
	public void searchHotels(String ddnLocation, String ddnRoomNos, String picDateIn,
			String picDateOut, String ddnAdultRoom ) {
		dropDownByText(getddnLocation(), ddnLocation);
		dropDownByText(getddnRoomNos(), ddnRoomNos);
		clearTextBox(getPicDateIn());
		elementInsertValue(getPicDateIn(), picDateIn);
		clearTextBox(getPicDateOut());
		elementInsertValue(getPicDateOut(), picDateOut);
		dropDownByText(getddnAdultRoom(), ddnAdultRoom);
		elementClick(getbtnLogin());
		

	}
	/**
	 * @see used to search without enter any fields
	 */
	public void searchHotel() {
		elementClick(getbtnLogin());

	}
	
	}
