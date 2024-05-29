package org.pom;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.BaseClass1;


public class AssertEmployee extends BaseClass1{
	@BeforeClass
	public static void beforeClass() {
		browserLaunch();
		enterApplnUrl("https://omrbranch.com/");
		maximizeWindow();
		implictWait();
	}
	@Test
	public void createOrderId() throws IOException, InterruptedException {
		
		LoginPage loginpage=new LoginPage();
		loginpage.login(getCellData("pom", 1, 0),getCellData("pom", 1, 1));
		
		ProductSearchPage productsearchpage=new ProductSearchPage();
		
		String loginSuccessMsgText = productsearchpage.getLoginSuccessMsgText();
		Assert.assertEquals("verify userName after login", "Welcome Karkuzhali",loginSuccessMsgText);
		System.out.println(loginSuccessMsgText);
		
		
		productsearchpage.searchProduct(getCellData("pom",1, 2));

		
		ProductListingPage productlisting=new ProductListingPage(); 
		
		String txtSearchResultText = productlisting.getTxtSearchResultText();
		Assert.assertEquals("Verify search result", "Search Result - nuts",txtSearchResultText);
		System.out.println("txtSearchResultText");
		
		
		productlisting.addProductIntoCart();
		
		MyCartPage mycartpage=new MyCartPage();
		
		mycartpage.getGoToCartBtnBox();

		String myCartBox = mycartpage.getMyCartBox();
		Assert.assertEquals("print my cart", "My Cart",myCartBox);
		System.out.println(myCartBox);
		
		String printAddressBox = mycartpage.getPrintAddressBox();
		Assert.assertEquals("print my address", "Delivery Address",printAddressBox );
		System.out.println(printAddressBox);
		
		mycartpage.getAddressImg();
		
		mycartpage.addDeliveryAddress(3, getCellData("pom",1,4),getCellData("pom", 1, 5),getCellData("pom",1, 6),getCellData("pom",1,7),getCellData("pom",1,8),35,"3902"
				,getCellData("pom",1,11));
		
		//mycartpage.getBtnSave();

		String printPaymentText = mycartpage.getPrintPaymentText();
		Assert.assertEquals("Print payment method", "Payment Method", printPaymentText);
		System.out.println(printPaymentText);
		
		mycartpage.addPayment(1,getCellData("pom", 1,12 ), 4, 8,getCellData("pom", 1, 13));

		mycartpage.getBtnPlace();
		

	}


}
