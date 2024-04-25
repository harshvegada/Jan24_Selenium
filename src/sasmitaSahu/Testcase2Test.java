/*
 * TC 2 : Navigate to http://uitestingplayground.com/progressbar, click on the Start button, wait until it reaches 75% and then click on the Stop button, the test should attempt to stop the execution at as close as possible to 75%, but there's a 5% leeway (so returning 80% would be fine).
 */

package sasmitaSahu;

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

public class Testcase2Test {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void launchAndHiturl() {
		System.out.println("STEP-Launch the browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP-HIT the url");
		driver.get("http://uitestingplayground.com/progressbar");

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test
	void progressBar() {
		System.out.println("STEP-Click on start button");
		driver.findElement(By.xpath("//button[@id='startButton']")).click();

		System.out.println("STEP-Start the progress bar ");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='progressBar']"), "75%"));
		System.out.println("STEP-Click on stop button");
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();

		System.out.println("STEP-Check the prcentage of progressbar");
		String progresspercent = driver.findElement(By.xpath("//div[@id='progressBar']")).getText();
		Assert.assertEquals(progresspercent, "75%");
		System.out.println(progresspercent);
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}

}
