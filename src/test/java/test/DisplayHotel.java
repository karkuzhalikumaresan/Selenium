package test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.pom.HotelBooking;

public class DisplayHotel extends BaseClass {

	public void createBookingId() throws IOException {
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
		
		List<WebElement> listOfHotels = findelements("//div[@class='col-md-5 hotel-suites']//child::h5");
		for(WebElement element:listOfHotels) {
			String txtNames = elementGetText(element);
			System.out.println(txtNames);	
		}
		
		List<WebElement> listOfPrice = findelements("//div[@class='prize']//child::strong");
		for(WebElement element1:listOfPrice) {
			String txtPrice = elementGetText(element1);
			System.out.println(txtPrice);
		}
	
	}

		public static void main(String[] args) throws IOException  {
			DisplayHotel book=new DisplayHotel();
			book.createBookingId();
		}
		

}
