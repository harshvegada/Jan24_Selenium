package shridharK;

//Login functionality on Automationbykrishna.com using data driven approach.

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
	
	@DataProvider (name = "loginDataProvider")
	String[][] getTestData() {
		String[][] loginData = new String[3][3];
		
		loginData[0][0] = "mkanani";
		loginData[0][1] = "mkanTech123";
		loginData[0][2] = "Success!";
		
		loginData[1][0] = "techno";
		loginData[1][1] = "creditsTech123";
		loginData[1][2] = "Success!";
		
		loginData[2][0] = "credits";
		loginData[2][1] = "c123";
		loginData[2][2] = "Failed! please enter strong password";
		
		return loginData;
	}
	
	@Test (dataProvider = "loginDataProvider")
	void loginTest(String userName , String password , String verificationAlertMsg ) {
		driver.findElement(By.id("registration2")).click();
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement userNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		userNameInput.sendKeys(userName);
		
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		String expected = verificationAlertMsg;
		alert.accept();
		Assert.assertEquals(actual, expected);
	}
	
	@BeforeClass
	void setUp() {
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}

