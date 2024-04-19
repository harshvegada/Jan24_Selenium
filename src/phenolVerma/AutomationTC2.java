/*
 * TC 2 : Verify Login using Invalid Credentials
"STEP 1 - Launch Chrome browser
STEP 2 - Hit https://staging.theeliteqa.com/login URL.
STEP 3 - Enter valid username
STEP 4 - Enter Invalid password
STEP 5 - Click on Login button
VERIFY - Popup with the error message ""Authentication failed, please check your username and password."" should be displayed
VERIFY - Login page is still visible."
* 
 * 
 */

package phenolVerma;
 

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTC2 {

	WebDriver driver;
	WebDriverWait wait;;

	@BeforeMethod
	public void openbrowser() {
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("https://staging.theeliteqa.com/login");
	}

	@AfterMethod
	public void afterMenthod() {
		// Close the WebDriver
		driver.quit();
	}

	
	@Test
	void verfiyLoginFail() {

		System.out.println("Waiting till Sign In visible");
		System.out.println("Waiting till Sign In visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sign In']")));

		System.out.println("VERFIY - Login page is visible");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]")).isDisplayed();

		System.out.println("STEP 3 - Enter valid username");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]")).sendKeys("phenol@gmail.com");

		System.out.println("STEP 4 - Enter valid password");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("phenol@123");

		System.out.println("STEP 5 - Click on Login button");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Clicked");
		
		System.out.println("VERIFY - Popup with the error message \"Authentication failed, please check your username and password.\" should be displayed");
		
		WebElement popupMessageWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Authentication failed, please check your username and password.']")));

		String expectedMessage = "Authentication failed, please check your username and password.";
				
		String actualMessage = popupMessageWindow.getText();
		System.out.println(actualMessage);
		
		assertEquals(expectedMessage, actualMessage, "Message not matched.");
			
	}
}
