package org.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.BaseClass;
import test.BaseClass1;

public class MyCartPage extends BaseClass1{
	
	public MyCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=' Go To Cart ']")
	private WebElement goToCartBtn;
	
	@FindBy(css=".font35.font-weight-bold.color11.text-center.pageTitle")
	private WebElement myCart;
	
	@FindBy(css=".font18.fontSemiBold.color20.mb-4")
	private WebElement printAddress;
	
	@FindBy(xpath="//div[@class='diffAddres addAddress d-flex justify-content-center align-items-center mb-md-0 mb-2']")
	private WebElement addressImg;

	@FindBy(name="address_type")
	private WebElement addressType;
	
	@FindBy(xpath="//input[@placeholder='First name*']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@placeholder='Last name*']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@placeholder='Contact No*']")
	private WebElement txtcontactNo;
	
	@FindBy(xpath="//input[@placeholder='House No*']")
	private WebElement txtHouseno;
	
	@FindBy(xpath="//input[@placeholder='Address*']")
	private WebElement txtAddress;
	
	@FindBy(xpath="//select[@name='state']")
	private WebElement selectState;
	
	@FindBy(xpath="//select[@name='city']")
	private WebElement selectCity;
	
	@FindBy(name="zipcode")
	private WebElement txtZipCode;

	@FindBy(css=".saveAddress.font18.fontSemiBold.colorWhite.bgTheme.radius50.borderNone.px-5.py-2.hover1")
	private WebElement btnSave;
	
	
	@FindBy(xpath="(//div[contains(@class,'font20 fontSemiBold color20 mb-4')])[1]")
	private WebElement printPayment;
	
	
	public WebElement getPrintPayment() {
		return printPayment;
	}

	@FindBy(xpath="//select[@id='payment_type']")
	private WebElement paymenttype;
	
	@FindBy(xpath="//label[text()=' Visa ']")
	private WebElement cardType;
	
	@FindBy(xpath="//input[@placeholder='Card Number']")
	private WebElement txtCardNumber;
	
	@FindBy(id="month")
	private WebElement selectMonth;
	
	@FindBy(id="year")
	private WebElement selectYear;
	
	@FindBy(xpath="//input[@placeholder='CVV']")
	private WebElement txtCVV;
	
	@FindBy(css="button#placeOrder")
	private WebElement btnPlace;
	
	
	@FindBy(xpath="(//p[@class='font18 color20 fontSemiBold mb-0'])[1]")
	private WebElement orderNo;
	
	public WebElement getMyCart() {
		return myCart;
	}

	public WebElement getGoToCartBtn() {
		return goToCartBtn;
	}

	public WebElement getPrintAddress() {
		return printAddress;
	}
	
	public WebElement getAddressImg() {
		return addressImg;
	}

	public WebElement getAddressType() {
		return addressType;
	}
	

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtcontactNo() {
		return txtcontactNo;
	}

	public WebElement getTxtHouseno() {
		return txtHouseno;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}
	
	public WebElement getTxtZipCode() {
		return txtZipCode;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getPaymenttype() {
		return paymenttype;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getSelectMonth() {
		return selectMonth;
	}

	public WebElement getSelectYear() {
		return selectYear;
	}

	public WebElement getTxtCVV() {
		return txtCVV;
	}

	public WebElement getBtnPlace() {
		return btnPlace;
	}
	
	
	
	public WebElement getOrderNo() {
		return orderNo;
	}

	public void addDeliveryAddress(int n1,String firstName,String lastName,String contactNo,String houseNo,String address,int n2,String city,String pincode) throws InterruptedException {
	elementClick(addressImg);
	elementClick(addressType);
	selectOptionByIndex(addressType, n1);
	elementSendKeys(txtFirstName, firstName);
	elementSendKeys(txtLastName, lastName);
	elementSendKeys(txtcontactNo, contactNo);
	elementSendKeys(txtHouseno, houseNo);
	elementSendKeys(txtAddress, address);
	selectOptionByIndex(selectState, n2);
	selectOptionByValue(selectCity, city);
	Thread.sleep(3000);
	elementSendKeys(txtZipCode, pincode);
	Thread.sleep(3000);
	elementClick(btnSave);
	}
	
	public void addPayment(int type,String cardNo,int month,int year,String cvv) throws InterruptedException, IOException {
		 elementClick(paymenttype);
		 selectOptionByIndex(paymenttype,type);
		 elementClick(cardType);
		 elementSendKeys(txtCardNumber, cardNo);
		 selectOptionByIndex(selectMonth, month);
		 selectOptionByIndex(selectYear, year);
		 elementSendKeys(txtCVV,cvv);
		 elementClick(btnPlace);
		 String elementGetText = elementGetText(orderNo);
		 System.out.println(elementGetText);
		 createCellAndSetData("pom", 1, 14, elementGetText);
		
	}
	
	public void getGoToCartBtnBox() {
		elementJavaScriptClick(goToCartBtn);
	}
	
	public String getMyCartBox() {
		String elementGetText= elementGetText(myCart);
		return elementGetText;
	}
	
	public String getPrintAddressBox() {
		String elementGetText= elementGetText(printAddress);
		return elementGetText;
	}
	
	public void addressImgBtn() {
		elementJavaScriptClick(addressImg);
	}
	
	public void getBtnSaveBox() throws InterruptedException {
		elementClick(btnSave);
		
	}
	
	public String getPrintPaymentText() {
		String elementGetText= elementGetText(printPayment);
		elementJavaScriptScrolIntoView(printPayment);
		return elementGetText;
	}
	
	public void getbtnPlaceBox() {
		elementJavaScriptClick(btnPlace);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
