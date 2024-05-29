package test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AssertEmployee extends BaseClass1 {
	
	@BeforeClass
	public static void beforeClass() {
		browserLaunch();
		enterApplnUrl("https://omrbranch.com/");
		maximizeWindow();
		implictWait();
	}
	@Test
	public void createOrderId() throws IOException, InterruptedException {
		WebElement txtEmail = findLocatorById("email");
		elementSendKeys(txtEmail, getCellData("kk", 1, 0));

		WebElement txtPass = findLocatorById("pass");
		elementSendKeys(txtPass, getCellData("kk", 1, 1));

		WebElement btnLogin = findLocatorByXpath("//button[text()='Login']");
		elementClick(btnLogin);

		WebElement userName = findLocatorBycssSelector(".icoTwitter.mr-2.dropdown-toggle");
		String name = elementGetText(userName);
		Assert.assertEquals("verify userName after login", "Welcome Karkuzhali",name);
		System.out.println(name);

		WebElement cart1 = findLocatorByXpath("//i[@class='fa fa-shopping-cart']");
		elementClick(cart1);

		
		List<WebElement> findelements = findelements("//i[@class='fa fa-close']");
		for (WebElement webElement : findelements) {
			elementJavaScriptClick(webElement);
			WebElement cart2 = findLocatorByXpath("//i[@class='fa fa-shopping-cart']");
			elementJavaScriptClick(cart2);
				}
		
		WebElement closeCart = findLocatorByXpath("//a[@class='cart_btn_remove']");
		elementJavaScriptClick(closeCart);
		Thread.sleep(3000);
		
		WebElement txtSearch = findLocatorById("search");
		elementSendKeysEnter(txtSearch, getCellData("kk", 1, 2));
		
		WebElement txtSearchResult = findLocatorBycssSelector(".sectionTitle.font35.font-weight-bold.color11");
		String printSearchResult = elementGetText(txtSearchResult);
		Assert.assertEquals("Verify search result", "Search Result - nuts", printSearchResult);
		System.out.println(printSearchResult);
			
		WebElement addClick = findLocatorBycssSelector(
				".hover1.font16.fontsemibold.colorWhite.bgTheme.px-4.py-1.radius50.dyna_btn.addBtn-17");
		elementClick(addClick);

		WebElement btnAdd = findLocatorByXpath("//button[@id='cart-22']");
		elementClick(btnAdd);

		WebElement goToCartBtn = findLocatorByXpath("//a[text()=' Go To Cart ']");
		elementJavaScriptClick(goToCartBtn);

		WebElement addressImg = findLocatorByXpath("//div[@data-toggle='modal']");
		elementJavaScriptClick(addressImg);
		
		
		WebElement myCart = findLocatorByXpath("//h5[text()='My Cart']");
		String printMyCart = elementGetText(myCart);
		Assert.assertEquals("print my cart", "My Cart", printMyCart);
		System.out.println(printMyCart);
		

		
		WebElement address = findLocatorByXpath("//div[text()='Delivery Address']");
		String printMyAddress = elementGetText(address);
		Assert.assertEquals("print my address", "Delivery Address", printMyAddress);
		System.out.println(printMyAddress);
		

		WebElement dropdown = findLocatorByXpath("//select[@name='address_type']");
		selectOptionByText(dropdown, getCellData("kk", 1, 3));

		WebElement txtFirstName = findLocatorByXpath("//input[@placeholder='First name*']");
		elementSendKeys(txtFirstName, getCellData("kk", 1, 4));

		WebElement txtLastName = findLocatorByXpath("//input[@placeholder='Last name*']");
		elementSendKeys(txtLastName, getCellData("kk", 1, 5));

		WebElement txtcontactNo = findLocatorByXpath("//input[@placeholder='Contact No*']");
		elementSendKeys(txtcontactNo, getCellData("kk", 1, 6));

		WebElement txtHouseno = findLocatorByXpath("//input[@placeholder='House No*']");
		elementSendKeys(txtHouseno, getCellData("kk", 1, 7));

		WebElement txtAddress = findLocatorByXpath("//input[@placeholder='Address*']");
		elementSendKeys(txtAddress, getCellData("kk", 1, 8));

		WebElement selectState = findLocatorByXpath("//select[@name='state']");
		selectOptionByText(selectState, "Tamil Nadu");

		WebElement selectCity = findLocatorByXpath("//select[@name='city']");
		selectOptionByText(selectCity, "Lalgudi");

		WebElement pincode = findLocatorByXpath("//input[@placeholder='Zip Code*']");
		elementSendKeys(pincode, getCellData("kk", 1, 10));

		WebElement btnSave = findLocatorBycssSelector(
				".saveAddress.font18.fontSemiBold.colorWhite.bgTheme.radius50.borderNone.px-5.py-2.hover1");
		elementClick(btnSave);
		Thread.sleep(3000);
		
		WebElement paymentMethod = findLocatorByXpath("(//div[contains(@class,'font20 fontSemiBold color20 mb-4')])[1]");
		String printPaymentMethod = elementGetText(paymentMethod);
		Assert.assertEquals("Print payment method", "Payment Method", printPaymentMethod);
		System.out.println(printPaymentMethod);
		
		Thread.sleep((3000));
		WebElement paymentmethod = findLocatorByXpath("//div[text()='  Payment Method ']");
		elementJavaScriptScrolIntoView(paymentmethod);

		WebElement paymenttype = findLocatorByXpath("//select[@id='payment_type']");
		selectOptionByValue(paymenttype, "debit_card");

		WebElement cardType = findLocatorByXpath("//label[text()=' Visa ']");
		elementClick(cardType);

		WebElement txtCardNumber = findLocatorByXpath("//input[@placeholder='Card Number']");
		elementSendKeys(txtCardNumber, getCellData("kk", 1, 11));

		WebElement selectMonth = findLocatorById("month");
		selectOptionByText(selectMonth, "January");

		WebElement selectYear = findLocatorById("year");
		selectOptionByText(selectYear, "2028");

		WebElement txtCVV = findLocatorByXpath("//input[@placeholder='CVV']");
		elementSendKeys(txtCVV, getCellData("kk", 1, 12));

		WebElement btnPlace = findLocatorBycssSelector("button#placeOrder");
		elementClick(btnPlace);

		createCellAndSetData("kk", 0, 13, "Order No");

		WebElement orderNo = findLocatorByXpath("(//p[@class='font18 color20 fontSemiBold mb-0'])[1]");
		String orderId = elementGetText(orderNo);
		createCellAndSetData("kk", 1, 13, orderId);
		boolean b = orderId.contains("Order No:");
		Assert.assertTrue("Store order Id in excel:",b);
		System.out.println(orderId);

	}



}
