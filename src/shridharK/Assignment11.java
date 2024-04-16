//Login automation by krishna functionality using data driven approch using Excel sheet.
package shridharK;

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

public class Assignment11 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@DataProvider (name = "loginDataProvider")
	String[][] getData() {
		return new Assignment11DataProvider().readData(".//src//shridharK//data.xlsx", "LoginData"); 
	}
	
	@Test (dataProvider = "loginDataProvider")
	void loginTest(String userName , String password , String verificationAlertMsg) {
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
