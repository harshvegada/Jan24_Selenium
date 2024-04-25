package garimaSinghal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC2 {
	WebDriver driver;
WebDriverWait wait;
	@BeforeClass
	void launchAndHitUrl() {
		System.out.println("STEP: Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Navigate to");
		driver.get("http://uitestingplayground.com/progressbar");
	}
	
	@Test
	void stopProgressBar() {
		wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		System.out.println("STEP: Click On Start Button");
		driver.findElement(By.xpath("//button[@id='startButton']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='progressBar' and text()='75%']"), "75%"));
		System.out.println("STEP: Click On Stop Button");
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();

		String percentageOfProgress = driver.findElement(By.xpath("//div[@id='progressBar']")).getText();
		Assert.assertEquals(percentageOfProgress, "75%", "Progress Bar Text Not Matched");
		System.out.println("VERIFY : Progress bar Matches With 75%");
		}
	
	@AfterClass
	void closeBrowser() {
		System.out.println("Close the Browser");
		driver.quit();
	}
}
