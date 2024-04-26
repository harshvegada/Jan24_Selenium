package varshaNagadwala;

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

//http://uitestingplayground.com/progressbar, click on the Start button, wait until it reaches 75% and then click on the Stop button, 
//the test should attempt to stop the execution at as close as possible to 75%, but there's a 5% leeway (so returning 80% would be fine).

public class Test2 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("STEP : Navigate to http://uitestingplayground.com/progressbar");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("http://uitestingplayground.com/progressbar");
	}

	@Test
	public void verifyStatusBar() {

		System.out.println("Step - click the Start button");
		driver.findElement(By.xpath("//button[@id='startButton']")).click();

		System.out.println("Step - Wait for the progress bar to reach 75%");
		WebElement progressBar = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='progressBar']")));
		int currentProgress = 0;
		while (currentProgress < 75) {
			currentProgress = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));
		}
		System.out.println(currentProgress);
		Assert.assertEquals(currentProgress, 75);

		System.out.println("Step - Click on stop button");
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
