/*
 * 
 * TC 3 : Verify Assessment Count
"STEP 1- Login with Valid credentials.
STEP 2 - Go to Assessments Tab
STEP 3 - Count total number of assessments from Published, Completed and Draft
STEP 4 - Go to Dashboard tab
VERIFY - Total assessments count on dashboard page against Assessments tab.
VERIFY - Recent assessments should be 6 or less than 6."
*/
package phenolVerma;

import static org.testng.Assert.assertEquals;

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

public class AutomationTC3 {

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

	int getIntegerValue(String status) {
		String str = driver.findElement(By.xpath("//span[text()='" + status + "']")).getText();
		int digit = Integer.parseInt((str.split(" ")[1].replace("(", "").replace(")", "")));
		return digit;
	}

	@Test
	public void verifyLogin() throws InterruptedException {

		System.out.println("************************STEP 1- Login with Valid credentials.***********************");

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

		int actualAssestmentCount = Integer.parseInt(
				driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[1]/div[2]/div[1]/span/b")).getText());

		System.out.println("STEP 2 - Go to Assessments Tab");
		driver.findElement(By.xpath("//span[text()='Assessments']")).click();

		System.out.println("Waiting till Assessments visible");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Assessments']")));

		int publishedCount = getIntegerValue("published");
		int completedCount = getIntegerValue("completed");
		int draftCount = getIntegerValue("draft");

		System.out.println("Counting the differnt assestment");
		int totalAssistmentCount = publishedCount + completedCount + draftCount;
		System.out.println(totalAssistmentCount);
		System.out.println(actualAssestmentCount);

		System.out.println("Verfiy test case");
		assertEquals(totalAssistmentCount, actualAssestmentCount, "Count missmatch");
	}
}
