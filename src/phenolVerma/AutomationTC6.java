/*
 * TC 6 : eliteQA tab switch & webcame error.
"(Pre-requisite: create Assesment)
STEP1- Login with Valid credentials.
STEP2: Click on ""Library"" button
STEP3: Click on Assessments tab
STEP4: Click on automation test engineer test
STEP5: click on Take Snapshots via webcam every 30 second
STEP6:verify Proctoring setting updated successfully messege
STEP7: click on Test Preview button
STEP8: Switch to Excellio Candidate Assesment Portal
STEP9: I agree to the Privacy Policy and Terms of Use of EliteQA. button
STEP10: Click on Submit Test button
STEP11:Verify ""Can't start test, Please turn on camera"" messege"
 */
package phenolVerma;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTC6 {

	WebDriver driver;
	WebDriverWait wait;
	String expectedAlertText;

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

		System.out.println("************************TC 4 : Verify Dashboard UI validation\r\n***********************");

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

		System.out.println("STEP 2 - Click on Library Menu.");
		driver.findElement(By.xpath("//span[text()='Library']")).click();

		System.out.println("STEP3: Click on Assessments tab");
		driver.findElement(By.xpath("//span[text()='Assessments']")).click();

		Thread.sleep(1000);

		System.out.println("STEP4: Click on automation test engineer test");
		driver.findElement(By.xpath("//span[text()='automation test engineer test']")).click();

		Thread.sleep(2000);

		System.out.println("STEP5: click on Take Snapshots via webcam every 30 second");
		driver.findElement(
				By.xpath("//div[@class='settings-list']/div[@class='group'][2]//span[@class='slider round']")).click();

		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[text()='Proctoring setting updated successfully.']"))).isDisplayed(),
				"Proctoring setting updated successfully.");
		
		System.out.println("STEP7: click on Test Preview button");
		driver.findElement(By.xpath("//span[text()='Test Preview']")).click();
		
		System.out.println("STEP8: Switch to Excellio Candidate Assesment Portal");
		String mainWindowHandleId = driver.getWindowHandle();
		Set<String> allWindowHandleIds = driver.getWindowHandles();

		for (String winId : allWindowHandleIds) {
			if (!winId.equals(mainWindowHandleId))
				driver.switchTo().window(winId);
		}
		
		Thread.sleep(2000);
		
		System.out.println("STEP9: I agree to the Privacy Policy and Terms of Use of EliteQA. button");
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		
		System.out.println("STEP10: Click on Submit Test button");
		driver.findElement(By.xpath("//span[text()='Start Test']")).click();
		
		System.out.println("STEP11:Verify \"Can't start test, Please turn on camera\" messege");
		
		Assert.assertTrue(
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@class=\"error-popup-title\"]"))).isDisplayed(),
				"Can't start test, Please turn on camera");
		
		//driver.findElement(By.xpath("//div[@class=\"error-popup-title\"]")).getText();
		
	}

}
