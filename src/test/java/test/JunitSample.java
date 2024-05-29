package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitSample {
	static WebDriver driver;
	
	
	@BeforeClass
	public static void beforeClass() {
		driver=new ChromeDriver();
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	
	@Before
	public void beforeMethod() throws IOException {
		//Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\Screenshot\\OmrLogin.png");
		FileUtils.copyFile(f,d);
	}
	
	@After
	public void afterMethod() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		WebElement userName = driver.findElement(By.cssSelector(".icoTwitter.mr-2.dropdown-toggle"));
		File f = userName.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\karku\\eclipse-workspace\\FrameworkClass\\Screenshot\\userLoginoutput.png");
		FileUtils.copyFile(f,d);
	}
	
	@Test
	public void login() {
		WebElement userIdTextBox = driver.findElement(By.id("email"));
		userIdTextBox.sendKeys("karkuzhalikumaresan@gmail.com");
		String actualName = userIdTextBox.getAttribute("value");
		Assert.assertEquals("verify userId textbox","karkuzhalikumaresan@gmail.com",actualName);
		WebElement pwdTextBox = driver.findElement(By.id("pass"));
		pwdTextBox.sendKeys("Karu@1993");
		String actualPwd = pwdTextBox.getAttribute("value");
		Assert.assertEquals("verify password textbox","Karu@1993",actualPwd);
		WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Login']"));
		btnLogin.click();
		
		WebElement userName = driver.findElement(By.cssSelector(".icoTwitter.mr-2.dropdown-toggle"));
		String text = userName.getText();
		boolean b = text.contains("Welcome");
		Assert.assertTrue("verify username after login",b);
		System.out.println(text);
	}
	
	
	
	

}
