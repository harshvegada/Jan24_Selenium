/*Assignment - 10 : 13th April'2024
Login functionality on Automationbykrishna.com using data driven approach.
*/

package madhuraKulkarni;

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
	@BeforeClass
	void launchBrowser() {
		System.out.println("STEP: Launch browser and hit URL");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}

	@DataProvider(name="loginDataProvider")
	public Object[][] getLoginData() {
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Madhura";
		data[0][1] = "m23";
		data[0][2] = "Failed! please enter strong password";
		
		data[1][0] = "Madhura";
		data[1][1] = "Madhura@12345";
		data[1][2] = "Success!";
		
		data[2][0] = "Madhura";
		data[2][1] = "mg123";
		data[2][2] = "Failed! please enter strong password";
		
		return data;
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void loginTest(String uname, String pwd, String expectedAlertText) {
		//String expectedAlertText = "Failed! please enter strong password";
		driver.findElement(By.linkText("Registration")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement unameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		unameElement.sendKeys(uname);
		
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualAlertText, expectedAlertText);
		System.err.println("Test passed");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
