package akshayGaikwad;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment10 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	void setup() {
		System.out.println("STEP : Launch Chrome browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@DataProvider(name = "loginData")
	String[][] getLoginData(){
		String[][] data = new String[3][3];
		
		data[0][0] = "akshay";
		data[0][1] = "abcd12345";
		data[0][2] = "Success!";
		
		data[1][0] = "akshay";
		data[1][1] = "abc";
		data[1][2] = "Failed! please enter strong password";
		
		data[2][0] = "akshay";
		data[2][1] = "abc12345678";
		data[2][2] = "Failed! please enter strong password";
		
		return data;
	}
	
	@Test(dataProvider = "loginData")
	void signUpDataProvider(String uName, String pwd, String msg) {
		System.out.println("STEP : Go to registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("STEP : Enter Username");

		WebElement uNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		uNameEle.sendKeys(uName);
		
		System.out.println("STEP : Enter Password");

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		
		System.out.println("STEP : Submit");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String currectText = alert.getText();
		alert.accept();
		
		Assert.assertTrue(msg.equals(currectText), "VERIFY : Test Failed as Message is Wrong");
		System.out.println("VERIFY : Test Passed");
		System.out.println("-------------------------------");
	}
	
	@AfterClass
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
}
