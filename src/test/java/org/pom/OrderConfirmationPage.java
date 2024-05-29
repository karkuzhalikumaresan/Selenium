package org.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//p[@class='font18 color20 fontSemiBold mb-0'])[1]")
	private WebElement orderNo;
	

	public WebElement getOrderNo() {
		return orderNo;
	}
	
//	public String getOrderId(String orderId) throws IOException {
//		elementSendKeys(orderNo, orderId);
//		String text = orderNo.getText();
//		createCellAndSetData("kk", 1, 13, text);
//		boolean b = orderId.contains("Order No:");
//	}
//

}
