package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
/**
 * @author rajpr
 * @see used to maintain select hotel page locators
 * @date 14/02/2023
 */
public class SelectHotelPage extends BaseClass{
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "radiobutton_0")
	private WebElement rdoButton;

	@FindBy(id = "continue")
	private WebElement btnContinue;
	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSelectHotelSuccessMsg;
	
	@FindBy(id="radiobutton_span")
	private WebElement txtSelectHotelErrorMsg;
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotelSuccessMsg;

	public WebElement getTxtBookHotelSuccessMsg() {
		return txtBookHotelSuccessMsg;
	}
	public WebElement getTxtSelectHotelSuccessMsg() {
		return txtSelectHotelSuccessMsg;
	}

	public WebElement getTxtSelectHotelErrorMsg() {
		return txtSelectHotelErrorMsg;
	}

	public WebElement getrdoButton() {
		return rdoButton;
	}

	public WebElement getbtnContinue() {
		return btnContinue;
	}

	/**
	 * @see used to select hotel and continue
	 */
	public void selectHotelName() {
		elementClick(getrdoButton());
		elementClick(getbtnContinue());

	}
	/**
	 * @see used to continue without select hotel
	 */
	public void clickContinue() {
		elementClick(getbtnContinue());

	}

}
