package varshaNagadwala;

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

//TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statement

//The button labeled Opacity 0 should not be displayed
//The button labeled Removed should not be displayed
//The button labeled Visibility Hidden should not be displayed
//The button labeled Display None should not be displayed

public class Test1 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("STEP : Navigate to http://uitestingplayground.com/visibility");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("http://uitestingplayground.com/visibility");
	}

	public boolean isElementVisibleOnUi(String text) {
		try {
			return wait.until(
					ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='" + text + "']")));
		} catch (Exception e) {
			return false;
		}
	}

	@Test
	public void verifyPage() {
		System.out.println("STEP - Click on hide button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Hide']"))).click();

		System.out.println("STEP -The button labeled Opacity 0 should not be displayed");
		Assert.assertEquals(isElementVisibleOnUi("Opacity 0"), true, "Opacity 0 button is displayed");

		System.out.println("STEP -The button labeled Removed should not be displayed");
		Assert.assertEquals(isElementVisibleOnUi("Removed"), true, "Removed button is displayed");

		System.out.println(
				"STEP -The button labeled The button labeled Visibility Hidden should not be displayed should not be displayed");
		Assert.assertEquals(isElementVisibleOnUi("Visibility Hidden"), true, "Visibility Hidden button is displayed");

		System.out.println("STEP -The button labeled Display None should not be displayed");
		Assert.assertEquals(isElementVisibleOnUi("Display None"), true, "Display None button is displayed");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
