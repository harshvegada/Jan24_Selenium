package garimaSinghal;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1 {
	WebDriver driver;

	@BeforeClass
	void launchAndHitUrl() {
		System.out.println("STEP: Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Navigate to");
		driver.get("http://uitestingplayground.com/visibility");
	}

	@Test
	void checkVisibility() {
		System.out.println("STEP : Click on the Hide button");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		boolean isOpicityButton = driver.findElement(By.xpath("//button[@id='transparentButton']")).isDisplayed();
		Assert.assertFalse(isOpicityButton);
		System.out.println("Verify: Opicity Button is not visible");
		try {
			boolean isRemovedButton = driver.findElement(By.xpath("//button[@id='removedButton']")).isDisplayed();
			Assert.assertFalse(isRemovedButton);
			System.out.println("Verify: Removed Button is not visible");
		} catch (NoSuchElementException e) {
			System.out.println("Verify: Removed Button not at Dome");
		}
		boolean isInvisibleButton = driver.findElement(By.xpath("//button[@id='invisibleButton']")).isDisplayed();
		Assert.assertFalse(isInvisibleButton);
		System.out.println("Verify: Invisible Button is not visible");
		boolean isDisplayNoneButton = driver.findElement(By.xpath("//button[@id='notdisplayedButton']")).isDisplayed();
		Assert.assertFalse(isDisplayNoneButton);
		System.out.println("Verify:DisplayNone Button is not visible");
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}

}
