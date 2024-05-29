package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginpage {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
		WebElement TxtBoxEmail = driver.findElement(By.id("email"));
		TxtBoxEmail.sendKeys("karkuzhalikumaresan@gmail.com");
		WebElement TxtPasswordBox = driver.findElement(By.id("pass"));
		TxtPasswordBox.sendKeys("@Karu1993");
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();
	}

}
