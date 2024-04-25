package ashwiniBalki;

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

/*
 TC 2 : Navigate to http://uitestingplayground.com/progressbar, click on the Start button, wait until it reaches 75% and then click on the Stop button, the test should attempt to stop the execution at as close as possible to 75%, but there's a 5% leeway (so returning 80% would be fine).
 */
public class Selenium_Test_1_Tc2 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setut() {
		System.out.println("STEP: Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("Step: Hit URL");
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/progressbar");

		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	}

	@Test
	public void tc2() {

		System.out.println("STEP : Click On Start button");
		driver.findElement(By.xpath("//button[@id ='startButton']")).click();

		
		WebElement progressBarElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='progressBar']")));
		
		
 	    System.out.println("STEP : Waiting for bar value to be 75%");
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='75%']")));
 	   
		System.out.println("STEP: Click on Stop button when progress bar is at 75%");
		driver.findElement(By.xpath("//button[@id ='stopButton']")).click();
		
		String barvalue = progressBarElement.getText();
		System.out.println("Expected result is between 75 and 80. Got : " + barvalue);
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
