package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author rajpr
 * @see used to maintain booking confirmation page locator
 * @date 14/02/2023
 */
public class BookingConfirmationPage extends BaseClass{
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement orderNo;
	
	
	public WebElement getOrderNo() {
		return orderNo;
	}
	/**
	 * @see used to get booking order id
	 * @return
	 */
	public String getOrderId() {
		String attribute = elementGetAttribute(getOrderNo(), "value");
		return attribute;
		
		}

}
