/*"Assignment - 10 : 13th April'2024
Login functionality on Automationbykrishna.com using data driven approach." */
package phenolVerma;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Assignment10LoginTestDataProvider {

	WebDriver driver;

	@BeforeMethod
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}

	@Test(dataProvider = "loginDataProvider")
	public void loginTest(String userName, String passWord, String expectedAlertText) throws InterruptedException {

		System.out.println("Clicking on registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		System.out.println("Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(userName);
		
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(passWord);
		
		System.out.println("Click on submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Alert alert = driver.switchTo().alert();
		
		System.out.println("Getting alert message");
		String actualAlertText = alert.getText();
		
		System.out.println("Checking actual vs expected alert message");
		Assert.assertEquals(actualAlertText, expectedAlertText);
		alert.accept();

	}

	@DataProvider(name = "loginDataProvider")
	public String[][] loginData() {
		String[][] data = new String[2][3];

		data[0][0] = "phenol";
		data[0][1] = "phenol";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "phenol.verma";
		data[1][1] = "phenol@123";
		data[1][2] = "Success!";
		
		return data;
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}
