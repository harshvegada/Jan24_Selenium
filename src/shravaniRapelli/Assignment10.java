package shravaniRapelli;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void TestCaseLogin(String username, String password, String expectedResult ) {
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualAlertText, expectedResult);
		System.err.println("Test passed");
	}
	
	@DataProvider(name="loginDataProvider")
	public Object[][] getLoginData() {
		Object[][] data = new Object[3][3];

		data[0][0] = "Shravani";
		data[0][1] = "Shravani123";
		data[0][2] = "Success!";

		data[1][0] = "Shravani";
		data[1][1] = "Shra12";
		data[1][2] = "Failed! please enter strong password";

		data[2][0] = "technocredits";
		data[2][1] = "tech1";
		data[2][2] = "Failed! please enter strong password";

		return data;
	}
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
