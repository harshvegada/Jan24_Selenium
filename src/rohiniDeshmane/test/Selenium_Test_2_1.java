package rohiniDeshmane.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 *Test cases we need to automate:*


TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statements are true:

The button labeled Opacity 0 should not be displayed
The button labeled Removed should not be displayed
The button labeled Visibility Hidden should not be displayed
The button labeled Display None should not be displayed


TC 2 : Navigate to http://uitestingplayground.com/progressbar, click on the Start button, wait until it reaches 75% and then click on the Stop button, the test should attempt to stop the execution at as close as possible to 75%, but there's a 5% leeway (so returning 80% would be fine).


====================================
Once everything has been executed, we expect to see the following on the console:

✓ should not display the Opacity 0 button
 ✓ should not display the removed button
 ✓ should not display the invisible button
 ✓ should not display the not-displayed button
 ✓ should start the progress bar and stop it when it reaches 75
   Expected result is between 75 and 80. Got 75

 */

public class Selenium_Test_2_1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	void launchBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/visibility");
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@Test
	void TestCase1() {
		System.out.println("STEP : Click on Hide Button");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='hideButton']"))).click();
		
		System.out.println("STEP : The button labeled Opacity 0 should not be displayed");
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='transparentButton']"))));
		
		System.out.println("STEP : The button labeled Removed should not be displayed");
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='removedButton']"))));
		
		System.out.println("STEP : The button labeled Visibility Hidden should not be displayed");
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='invisibleButton']"))));
	
		System.out.println("STEP : The button labeled Display None should not be displayed");
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='notdisplayedButton']"))));
	
	}
}
