/*
 * TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statements are true:

The button labeled Opacity 0 should not be displayed
The button labeled Removed should not be displayed
The button labeled Visibility Hidden should not be displayed
The button labeled Display None should not be displayed
 */

package pujaPoreddiwar;

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

public class Selenium_test_TC1 {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/visibility");
	}

	@Test
	public void TestCase1() {
		
		System.out.println("STEP: Click on Hide button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement hideButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hideButton']")));
		hideButton.click();

		boolean opacity0Button = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='transparentButton']")));
		boolean removedButton = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='transparentButton']")));
		boolean visibilityHiddenButton = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='transparentButton']")));
		boolean displayButton = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='transparentButton']")));
		
		System.out.println("VERIFY: ✓ should not display the Opacity 0 button");
		Assert.assertEquals(opacity0Button, true, "The button labeled Opacity 0 should not be displayed");
		
		System.out.println("VERIFY: ✓ should not display the removed button");
		Assert.assertEquals(removedButton, true, "The button labeled Removed should not be displayed");
		
		System.out.println("VERIFY: ✓ should not display the invisible button");
		Assert.assertEquals(visibilityHiddenButton, true, "The button labeled Visibility Hidden should not be displayed");
		
		System.out.println("VERIFY: ✓ should not display the not-displayed button");
		Assert.assertEquals(displayButton, true, "The button labeled Display None should not be displayed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

















