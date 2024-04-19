/*
TC 5 : Verify Create Question Error validation.
"STEP 1- Login with Valid credentials.
STEP 2 - Click on Library Menu.
STEP 3 - Click on Create Question button.
STEP 4 - Click on MCQ.
STEP 5 - Click on Save button.
VERIFY - ""Enter question title"" error message should be displayed.
STEP 6 - Add ""Access modifier - Theory"" Title in Question.
STEP 7 - Click on Save button.
VERIFY - ""Enter question score"" error message should be displayed.
STEP 8 - Add ""1"" in the score value.
STEP 9 - Click on Save button.
VERIFY - ""Enter question."" error message should be displayed.
STEP 10 - Enter question ""Constructor can be declared as Protected""
STEP 11 - ""Atleast one correct answer should be selected."" error message should be displayed
STEP 12 - Enter option 1 value as true and option 2 value is false.
STEP 13 - Select correct answer by clicking on the first option.
STEP 14 - Click on Save button.
VERIFY - ""Difficulty level is mandatory."" error message should be displayed.
STEP 15 - Select difficulty level as Easy.
STEP 16 - Click on Save button.
VERIFY - ""Atleast one skill is mandatory."" error message should be displayed.
STEP 17 - Select skill ""Java"" from search box.
STEP 18- Select topic ""object-oriented programming"".
STEP 19 - Click on Save button.
VERIFY - ""Question created successfully."" success message should be displayed."
 */

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

public class AutomationTC5 {

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

	void getAltertText(String expectedAlertText) throws InterruptedException {

		Thread.sleep(1000);

		System.out.println("Click on Save button");
		driver.findElement(By.xpath("//label[text()='Save']")).click();

		Thread.sleep(1000);
		int count = 0;
		// Alert message test
		String actualAlertText = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText();
		System.out.println(++count);
		System.out.println(actualAlertText);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();

		Assert.assertEquals(expectedAlertText, actualAlertText);
		// , actualAlertText + "Message does not match");
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

		System.out.println("STEP 3 - Click on Create Question button.");
		driver.findElement(By.xpath("//p[text()='Create Question']")).click();

		System.out.println("STEP 4 - Click on MCQ.");
		driver.findElement(By.xpath("//div[@class=\"mcq-svg-container\"]")).click();

		// Alert message check
		expectedAlertText = "Enter question title.";
		getAltertText(expectedAlertText);

		// Question
		System.out.println("VERIFY - \"\"Enter question title\"\" error message should be displayed.");
		driver.findElement(By.xpath("//input[@placeholder='Your question title']"))
				.sendKeys("String is immutable or not");

		// Alert message check
		expectedAlertText = "Enter question score.";
		getAltertText(expectedAlertText);

		// Score
		System.out.println("VERIFY - \"\"Enter question score\"\" error message should be displayed.");
		WebElement score = driver.findElement(By.xpath("//input[@placeholder='Score']"));
		score.sendKeys("10");

		// Alert message check
		expectedAlertText = "Enter question.";
		getAltertText(expectedAlertText);

		// Problem
		System.out.println("VERIFY - \"\"Enter question.\"\" error message should be displayed.");
		WebElement problem = driver
				.findElement(By.xpath("//div[@class='se-wrapper-inner se-wrapper-wysiwyg sun-editor-editable'][1]"));
		problem.sendKeys("Hello");

		// Alert message check
		expectedAlertText = "Atleast one correct answer should be selected.";
		getAltertText(expectedAlertText);

		// Options
		System.out.println(
				"STEP 11 - \"\"Atleast one correct answer should be selected.\"\" error message should be displayed");
		WebElement option1 = driver.findElement(By.xpath(
				"//div[@class='add-solution-answer-input-container']/div[@class='answers-container']/div[@class='answer-box'][1]//div[@class='se-wrapper']//p"));
		option1.sendKeys("True");

		WebElement option2 = driver.findElement(By.xpath(
				"//div[@class='add-solution-answer-input-container']/div[@class='answers-container']/div[@class='answer-box'][2]//div[@class='se-wrapper']//p"));
		option2.sendKeys("False");

		// Alert message check
		expectedAlertText = "Atleast one correct answer should be selected.";
		getAltertText(expectedAlertText);

		// Select Checkbox
		System.out.println("STEP 13 - Select correct answer by clicking on the first option.");
		WebElement selectcheckbox = driver.findElement(By.xpath(
				"//div[@class='add-solution-answer-input-container']/div[@class='answers-container']/div[@class='answer-box'][1]/div[@class='check-box']"));
		selectcheckbox.click();

		// Alert message check
		expectedAlertText = "Difficulty level is mandatory.";
		getAltertText(expectedAlertText);

		// Difficulty level
		System.out.println("VERIFY - \"\"Difficulty level is mandatory.\"\" error message should be displayed.");
		driver.findElement(By.xpath("//button[text()='Easy']")).click();

		// Alert message check
		expectedAlertText = "Atleast one skill is mandatory.";
		getAltertText(expectedAlertText);

		// Skill
		System.out.println("VERIFY - \"\"Atleast one skill is mandatory.\"\" error message should be displayed.");
		driver.findElement(By.xpath("//input[@placeholder='Search skill here...']")).sendKeys("java");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='skill-item']/span[text()='java']")).click();

		// Alert message check
		expectedAlertText = "Atleast one topic is mandatory.";
		getAltertText(expectedAlertText);

		// Topic
		System.out.println("STEP 18- Select topic \"\"object-oriented programming.");
		driver.findElement(By.xpath("//input[@placeholder='Search topic here...']"))
				.sendKeys("object-oriented programming");
		driver.findElement(By.xpath("//div[@class='add-topics-list-item']/p[text()='object-oriented programming']"))
				.click();

		System.out.println("STEP 5 - Click on Save button");
		driver.findElement(By.xpath("//label[text()='Save']")).click();

		// Assert.fail();
	}
}
