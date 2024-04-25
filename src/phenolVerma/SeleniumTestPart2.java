package phenolVerma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTestPart2 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/progressbar");
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	@Test
	void TestCase2() {
		System.out.println("click on the Start button");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-test']")).click();

		System.out.println("wait until it reaches 75%");
		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='progressBar']"), "75%"));
			System.out.println("waited until it reaches 75% and clicked");
		} catch (Exception ex) {
			System.out.println("Cant capture 75%");
		}

		System.out.println("click on the Stop button");
		driver.findElement(By.xpath("//button[@class='btn btn-info btn-test']")).click();
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}
}
