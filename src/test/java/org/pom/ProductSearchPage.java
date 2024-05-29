package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import test.BaseClass;
import test.BaseClass1;

public class ProductSearchPage extends BaseClass1{
	
	
	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart']")
	private WebElement cart1;
	
	@FindBy(xpath="//i[@class='fa fa-close']")
	private List<WebElement> findelements;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart']")
	private WebElement cart2;
	
	@FindBy(xpath="//a[@class='cart_btn_remove']")
	private WebElement closecart;
	
	@FindBy(id="search")
	private WebElement txtSearchBox;
	
	
	@FindBy(xpath="//a[@data-testid='username']")
	private WebElement txtLoginSuccessMsg;
	
	public WebElement getTxtLoginSuccessMsg() {
		return txtLoginSuccessMsg;
	}
	
	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}
	
	public WebElement getCart1() {
		return cart1;
	}

	public List<WebElement> getFindelements() {
		return findelements;
	}

	public WebElement getCart2() {
		return cart2;
	}

	public WebElement getClosecart() {
		return closecart;
	}

	public void searchProduct(String productName) {
		elementSendKeysEnter(txtSearchBox, productName);
	}
	
	public void closeBtnCart() throws InterruptedException {
		elementClick(closecart);
		for (WebElement webElement : findelements) {
			elementJavaScriptClick(webElement);
			elementJavaScriptClick(cart2);
			Thread.sleep(3000);
				}
	}

	public String getLoginSuccessMsgText() {
		String elementGetText= elementGetText(txtLoginSuccessMsg);
		return elementGetText;
	
	}
	
	
	

}
