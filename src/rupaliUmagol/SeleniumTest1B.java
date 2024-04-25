package rupaliUmagol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest1B {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		System.out.println(
				"STEP 1 - Launch Chrome Browser & navigate to URL - https://demo.automationtesting.in/WebTable.html");
		driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/progressbar");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test
	public void chekforPercent() {
		System.out.println("STEP : Click on Start Button");
		driver.findElement(By.xpath("//button[@id='startButton']")).click();

		System.out.println("STEP : wait until it reaches 75%");
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='progressBar' and text()='75%']"), "75%"));

		System.out.println("STEP : Click on Stop Button");
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();

		System.out.println("VERIFY : Progress bar Stops at which place");
		String percentage = driver.findElement(By.xpath("//div[@id='progressBar']")).getText();
		System.out.println(percentage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
