package rupaliUmagol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		System.out.println(
				"STEP 1 - Launch Chrome Browser & navigate to URL - https://demo.automationtesting.in/WebTable.html");
		driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/visibility");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@Test
	public void clickOnHidden() throws InterruptedException {
		System.out.println("STEP : click on the Hide button  ");
		driver.findElement(By.xpath("//button[text()='Hide']")).click();

		System.out.println("VERIFY : The button labeled Opacity 0 should not be displayed");
		Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Opacity 0']")).isDisplayed(),
				"Opacity button is still present");

		System.out.println("VERIFY : The button labeled Visibility Hidden should not be displayed");
		Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Visibility Hidden']")).isDisplayed(),
				"Visibility Hidden button is still present");

		System.out.println("VERIFY : The button labeled Display None should not be displayed");
		Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Display None']")).isDisplayed(),
				"Display None button is still present");
		
		System.out.println("VERIFY : The button labeled Removed should not be displayed");
		//Assert.assertFalse(driver.findElement(By.xpath("//button[@id='removedButton']")).isDisplayed(),
			//	"Removed button is still present");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
