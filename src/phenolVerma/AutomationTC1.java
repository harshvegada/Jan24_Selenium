/*
 TC 1 : Verify Login with Valid Credentails
 STEP 1 - Launch Chrome browser
STEP 2 - Hit https://staging.theeliteqa.com/login URL
VERFIY - Login page is visible
STEP 3 - Enter valid username
STEP 4 - Enter valid password
STEP 5 - Click on Login button
VERIFY - Dashboard page is displayed"
 * 
 */
package phenolVerma;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTC1 {

	WebDriver driver;
	WebDriverWait wait;

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
	public void verifyLogin() throws InterruptedException {

		System.out.println("Waiting till Sign In visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sign In']")));

		System.out.println("VERFIY - Login page is visible");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]")).isDisplayed();

		System.out.println("STEP 3 - Enter valid username");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]")).sendKeys("phenol@gmail.com");

		System.out.println("STEP 4 - Enter valid password");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("January@123");

		System.out.println("STEP 5 - Click on Login button");
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		System.out.println("Waiting till Dashboard visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
		
		System.out.println("Checking URL for logged in");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL.contains("dashboard"), true, "Dashboard page displayed");

		System.out.println("VERIFY - Dashboard page is displayed");
		driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
	}
}
