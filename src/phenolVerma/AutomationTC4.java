/*
 * TC 4 : Dashboard UI validation
 * "TC 4 : Verify Dashboard UI validation
STEP 1- Login with Valid credentials.
VERFIY - Invites Used, Total Assessments, Total Appeared, Total Qualified is visible
VERIFY - Assessments, Library, Candidates, Interviews tabs are visible.
VERIFY - Create Assessments and Create Question button is clickable."   */


package phenolVerma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTC4 {

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
	
	// check button visibility

	boolean checkButtonEnable(WebElement we) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(we));
			return true;
		} catch (Exception e) {
			return false;
		}
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

		System.out.println("VERFIY - Invites Used, Total Assessments, Total Appeared, Total Qualified is visible");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Invites Used']")).isDisplayed(), "Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Total Assessments']")).isDisplayed(),
				"Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Total Appeared']")).isDisplayed(),
				"Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Total Qualified']")).isDisplayed(),
				"Not visiable");
		System.out.println("VERFIED - Invites Used, Total Assessments, Total Appeared, Total Qualified is visible");

		System.out.println("VERIFY - Assessments, Library, Candidates, Interviews tabs are visible.");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed(), "Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Assessments']")).isDisplayed(), "Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Library']")).isDisplayed(), "Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Candidates']")).isDisplayed(), "Not visiable");
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Interviews']")).isDisplayed(), "Not visiable");
		System.out.println("VERIFIED - Assessments, Library, Candidates, Interviews tabs are visible.");

		System.out.println("VERIFY - Create Assessments and Create Question button is clickable.");
		WebElement createAssementButton = driver.findElement(By.xpath("//button[@class='createAssementButton']"));
		Assert.assertTrue(checkButtonEnable(createAssementButton));

		WebElement createQuestionButton = driver.findElement(By.xpath("//button[@class='createQuestionButton']"));
		Assert.assertTrue(checkButtonEnable(createQuestionButton));

		System.out.println("VERIFIED - Create Assessments and Create Question button is clickable.");
	}
}
