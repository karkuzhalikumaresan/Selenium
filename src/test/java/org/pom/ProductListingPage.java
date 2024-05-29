package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.BaseClass;
import test.BaseClass1;

public class ProductListingPage extends BaseClass1{
	
	public ProductListingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".sectionTitle.font35.font-weight-bold.color11")
	private WebElement txtSearchResult;
	
	@FindBy(css=".hover1.font16.fontsemibold.colorWhite.bgTheme.px-4.py-1.radius50.dyna_btn.addBtn-17")
	private WebElement addClick;
	
	@FindBy(xpath="//button[@id='cart-22']")
	private WebElement btnAdd;
	
	
	public WebElement getTxtSearchResult() {
		return txtSearchResult;
	}

	public WebElement getAddClick() {
		return addClick;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}
	
	
	 
	public void addProductIntoCart() {
		elementClick(addClick);
		elementClick(btnAdd);
	
	}
	
	public String getTxtSearchResultText() {
		String elementGetText= elementGetText(txtSearchResult);
		return elementGetText;
	}
	
	

}
