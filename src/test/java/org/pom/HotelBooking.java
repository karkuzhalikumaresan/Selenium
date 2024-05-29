package org.pom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import test.BaseClass;

public class HotelBooking extends BaseClass{

	public void createOrderId() throws IOException {
		browserLaunch();
		enterApplnUrl("https://www.omrbranch.com/");
		maximizeWindow();
		implictWait();
		WebElement txtEmail = findLocatorById("email");
		elementSendKeys(txtEmail, getCellData("hotel", 1, 0));

		WebElement txtPass = findLocatorById("pass");
		elementSendKeys(txtPass, getCellData("hotel", 1, 1));
		
		WebElement btnLogin = findLocatorByXpath("//button[text()='Login']");
		elementClick(btnLogin);

		WebElement userName = findLocatorBycssSelector(".icoTwitter.mr-2.dropdown-toggle");
		String name = elementGetText(userName);
		System.out.println(name);
		
		WebElement selectState = findLocatorById("state");
		selectOptionByText(selectState, "Tamil Nadu");
		
		WebElement selectCity = findLocatorByXpath("//select[@id='city']");
		selectOptionByText(selectCity, "Tiruchirappalli");
		
		WebElement selectRoomType = findLocatorByXpath("//select[@id='room_type']");
		selectOptionByText(selectRoomType, "Suite");
		
		WebElement checkIndate = findLocatorByXpath("//input[@placeholder='Check-In --/--/-- *']");
		elementSendKeysJs(checkIndate, getCellData("hotel", 1, 2));
		
		WebElement checkOutDate = findLocatorByXpath("//input[@placeholder='Check-Out --/--/-- *']");
		elementSendKeysJs(checkOutDate, getCellData("hotel", 1,3));
		
		WebElement selectRoom = findLocatorById("no_rooms");
		selectOptionByText(selectRoom, "2-Two");
		
		WebElement adultCount = findLocatorById("no_adults");
		selectOptionByText(adultCount, "2-Two");
		
		WebElement childCount = findLocatorById("no_child");
		elementSendKeys(childCount, getCellData("hotel",1, 4));
		
		WebElement outerFrame = findLocatorByXpath("//iframe[@id='hotelsearch_iframe']");
		swithFrameByWebElement(outerFrame);
		
		WebElement btnSearch = findLocatorByXpath("//button[@id='searchBtn']");
		elementJavaScriptClick(btnSearch);
		
		WebElement printProduct = findLocatorByXpath("//h5[text()='Park Hyatt Suite']");
		String PP = printProduct.getText();
		System.out.println(PP);
		
		WebElement txtPrice = findLocatorByXpath("//strong[text()='$ 3,776']");
		String printPrice = txtPrice.getText();
		System.out.println("Price:"+printPrice);
		
		WebElement btnCon = findLocatorByXpath("(//a[text()='Continue'])[1]");
		elementJavaScriptClick(btnCon);
		clickOkInAlert();
		
		WebElement selectGuest = findLocatorByXpath("//label[text()='Myself']");
		elementJavaScriptClick(selectGuest);
		
		WebElement selectSal = findLocatorById("user_title");
		elementJavaScriptScrolIntoView(selectSal);
		selectOptionByText(selectSal, "Ms.");
		
		WebElement fristName = findLocatorByXpath("//input[@placeholder='First Name *']");
		elementSendKeysJs(fristName, getCellData("hotel", 1,5));
		
		WebElement lastName = findLocatorByXpath("//input[@placeholder='Last Name *']");
		elementSendKeysJs(lastName, getCellData("hotel", 1, 6));
		
		WebElement txtMobileNum = findLocatorById("user_phone");
		elementSendKeysJs(txtMobileNum, getCellData("hotel", 1, 7));
		
		WebElement txtEmailId = findLocatorById("user_email");
		elementSendKeysJs(txtEmailId, getCellData("hotel", 1, 8));
	
		WebElement checkBoxgst = findLocatorByXpath("//input[@id='gst']");
		elementJavaScriptClick(checkBoxgst);
		
		WebElement txtGst = findLocatorById("gst_registration");
		elementSendKeysJs(txtGst, getCellData("hotel", 1, 9));
		
		WebElement txtComName = findLocatorByXpath("//input[@placeholder='Enter Company Name *']");
		elementSendKeysJs(txtComName, getCellData("hotel", 1, 10));
		
		WebElement txtAddress = findLocatorByXpath("//input[@placeholder='Enter Company Address *']");
		elementSendKeys(txtAddress, getCellData("hotel",1, 11));
		
		WebElement btnClick = findLocatorById("step1next");
		elementJavaScriptClick(btnClick);
		
		WebElement specialReq = findLocatorByXpath("//label[text()='Early Check-in']");
		elementJavaScriptScrolIntoView(specialReq);
		elementJavaScriptClick(specialReq);
		
		WebElement reason = findLocatorById("other_request");
		elementSendKeysJs(reason, getCellData("hotel", 1, 12));
		
		WebElement btnClick2 = findLocatorById("step2next");
		elementJavaScriptClick(btnClick2);
		
		WebElement clickPaymenyt = findLocatorByXpath("//div[@class='credit-card pm']");
		elementJavaScriptClick(clickPaymenyt);
		
		WebElement paymentType = findLocatorBycssSelector("select.form-control.selectpiker[id=payment_type]");
		selectOptionByText(paymentType, "Debit Card");
		
		WebElement cardType = findLocatorBycssSelector("select.form-control.selectpiker[id=card_type]");
		selectOptionByText(cardType, "Visa");
		
		WebElement cardNo = findLocatorByXpath("//input[@placeholder='Enter Card Number *']");
		elementSendKeysJs(cardNo, getCellData("hotel", 1, 13));
		
		WebElement cardName = findLocatorByXpath("//input[@placeholder='Enter Your Name On Card *']");
		elementSendKeysJs(cardName, getCellData("hotel",1, 14));
		
		WebElement selectMonth = findLocatorBycssSelector("select[id=card_month]");
		selectOptionByText(selectMonth, "May");
		
		WebElement selectYear = findLocatorBycssSelector("select[id=card_year]");
		selectOptionByText(selectYear, "2028");
		
		WebElement txtCVV = findLocatorByXpath("//input[@placeholder='Enter Card CVV *']");
		elementSendKeysJs(txtCVV, getCellData("hotel", 1, 15));
		
		WebElement btnSubmit = findLocatorById("submitBtn");
		elementClick(btnSubmit);
		
		WebElement bookingId = findLocatorByXpath("//h2[@class='couppon-code']//child::strong");
		String bookId = elementGetText(bookingId);
		System.out.println(bookId);
		
		WebElement txtCom = findLocatorByXpath("//h2[contains(text(),'Booking is Confirmed')]");
		String ComfirmStats = elementGetText(txtCom);
		System.out.println(ComfirmStats);
		
		WebElement hoteltxt = findLocatorByXpath("//strong[text()='Park Hyatt']");
		String hotelName = elementGetText(hoteltxt);
		System.out.println(hotelName);
		
		WebElement btnBook = findLocatorByXpath("//button[text()='My Booking']");
		elementJavaScriptClick(btnBook);
		
		WebElement btnEdit = findLocatorByXpath("(//button[text()='Edit'])[1]");
		elementJavaScriptClick(btnEdit);
		
		WebElement modifyCheckin = findLocatorByXpath("//input[@placeholder='Check-In --/--/--']");
		elementSendKeysJs(modifyCheckin, getCellData("hotel",1, 16));
		
		WebElement btnConfirm = findLocatorByXpath("//button[@class='edit btn filter_btn']");
		elementClick(btnConfirm);
		
		WebElement popupConfirm = findLocatorByXpath("//li[text()='Booking updated successfully']");
		String successTxt = elementGetText(popupConfirm);
		System.out.println(successTxt);
		
		WebElement printBooking = findLocatorByXpath("//h4[contains(text(),'Bookings')]");
		String Pbook = elementGetText(printBooking);
		System.out.println(Pbook);
		
		WebElement btnCancel = findLocatorByXpath("(//a[text()='Cancel'])[1]");
		elementJavaScriptClick(btnCancel);
		clickOkInAlert();
		
		WebElement cancelMsg = findLocatorByXpath("//li[text()='Your booking cancelled successfully']");
		String cancel = elementGetText(cancelMsg);
		System.out.println(cancel);
		
		
		
		

		
		
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException  {
		HotelBooking book=new HotelBooking();
		book.createOrderId();
	}

}
