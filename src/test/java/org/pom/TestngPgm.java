package org.pom;

import org.testng.annotations.Test;

public class TestngPgm {
	
	@Test(priority=-20)
	private void login() {
		
	}
	@Test (priority=-10)
	private void searchHotel() {
		
	}
	@Test(enabled=false)
	private void SelectHotel() {
		
	}
	@Test(priority=10 , invocationCount = 10)
	private void bookHotel() {
		
	}
	@Test(priority=20)
	private void confirmBooking() {
		
	}
}
