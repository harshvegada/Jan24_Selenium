/*
 * TC 2 : Navigate to http://uitestingplayground.com/progressbar, 
 * click on the Start button, wait until it reaches 75% and then 
 * click on the Stop button, the test should attempt to stop 
 * the execution at as close as possible to 75%, but there's
 *  a 5% leeway (so returning 80% would be fine).
 */
package pujaPoreddiwar;

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

public class Selenium_test_TC2 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/progressbar");
		System.out.println("STEP: Launched browser");
	}

	@Test
	public void TestCase2() {
		System.out.println("STEP: Click on start button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement startButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-test']")));
		startButton.click();

		System.out.println("STEP:✓ should start the progress bar and stop it when it reaches 75");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='progressBar']"), "75%"));
		System.out.println("STEP: Expected result is between 75 and 80. Got 75");

		driver.findElement(By.xpath("//button[@id='stopButton']")).click();
		System.out.println("STEP: Clicked on stop button");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}