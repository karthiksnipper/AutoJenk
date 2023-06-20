package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author rajpr
 * @see used to maintain book hotel page locators
 * @date 14/02/2023
 */
public class BookHotelPage extends BaseClass{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCardNo;

	@FindBy(id = "cc_type")
	private WebElement ddnCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement ddnExpMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement ddnExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvv;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtBookingConfirmationSuccessMsg;
	
	@FindBy(id="first_name_span")
	private WebElement txtFirstNameErrorMsg;
	
	@FindBy(id="last_name_span")
	private WebElement txtLastNameErrorMsg;
	
	@FindBy(id="address_span")
	private WebElement txtAddressErrorMsg;
	
	@FindBy(id="cc_num_span")
	private WebElement txtCcNumErrorMsg;
	
	@FindBy(id="cc_type_span")
	private WebElement txtCcTypeErrorMsg;
	
	@FindBy(id="cc_expiry_span")
	private WebElement txtCcExpiryErrorMsg;
	
	@FindBy(id="cc_cvv_span")
	private WebElement txtCvvErrorMsg;
	
	public WebElement getTxtBookingConfirmationSuccessMsg() {
		return txtBookingConfirmationSuccessMsg;
	}

	public WebElement getTxtFirstNameErrorMsg() {
		return txtFirstNameErrorMsg;
	}

	public WebElement getTxtLastNameErrorMsg() {
		return txtLastNameErrorMsg;
	}

	public WebElement getTxtAddressErrorMsg() {
		return txtAddressErrorMsg;
	}

	public WebElement getTxtCcNumErrorMsg() {
		return txtCcNumErrorMsg;
	}

	public WebElement getTxtCcTypeErrorMsg() {
		return txtCcTypeErrorMsg;
	}

	public WebElement getTxtCcExpiryErrorMsg() {
		return txtCcExpiryErrorMsg;
	}

	public WebElement getTxtCvvErrorMsg() {
		return txtCvvErrorMsg;
	}

	public WebElement gettxtFirstName() {
		return txtFirstName;
	}

	public WebElement gettxtLastName() {
		return txtLastName;
	}

	public WebElement gettxtAddress() {
		return txtAddress;
	}

	public WebElement gettxtCardNo() {
		return txtCardNo;
	}

	public WebElement getddnCardType() {
		return ddnCardType;
	}

	public WebElement getddnExpMonth() {
		return ddnExpMonth;
	}

	public WebElement getddnExpYear() {
		return ddnExpYear;
	}

	public WebElement gettxtCvv() {
		return txtCvv;
	}

	public WebElement getbtnBookNow() {
		return btnBookNow;
	}

	/**
	 * @see used to book hotel with all mandatory fields
	 * @param txtFirstName
	 * @param txtLastName
	 * @param txtAddress
	 * @param txtCardNo
	 * @param ddnCardType
	 * @param ddnExpMonth
	 * @param ddnExpYear
	 * @param txtCvv
	 */
	public void bookHotel(String txtFirstName,String txtLastName,String txtAddress,String txtCardNo,String ddnCardType,String ddnExpMonth,String ddnExpYear,String txtCvv) {
		
		elementInsertValue(gettxtFirstName(), txtFirstName);
		elementInsertValue(gettxtLastName(), txtLastName);
		elementInsertValue(gettxtAddress(), txtAddress);
		elementInsertValue(gettxtCardNo(), txtCardNo);
		elementInsertValue(getddnCardType(), ddnCardType);
		elementInsertValue(getddnExpMonth(), ddnExpMonth);
		elementInsertValue(getddnExpYear(), ddnExpYear);
		elementInsertValue(gettxtCvv(), txtCvv);
		elementClick(getbtnBookNow());
		
		
		}
	/**
	 * @see used to book hotel without enter any details
	 */
	public void bookHotel() {
		elementClick(getbtnBookNow());

	}
	
}
