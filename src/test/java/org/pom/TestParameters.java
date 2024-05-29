package org.pom;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;																																																																
import org.testng.annotations.Test;

import test.BaseClass;
import test.BaseClass1;

public class TestParameters extends BaseClass1 {

	@BeforeClass
	public static void beforeClass() {
		browserLaunch();
		enterApplnUrl("https://omrbranch.com/");
		maximizeWindow();
		implictWait();
	}

	@Test
	private void login() {
		LoginPage loginpage = new LoginPage();
		loginpage.login("karkuzhalikumaresan@gmail.com","Karu@1993");
	}

}
