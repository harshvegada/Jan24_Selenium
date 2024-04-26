package sakshi;

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

public class TC2 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Navigate to http://uitestingplayground.com/progressbar");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/progressbar");
	}
	
	@Test
	public void tC2() {
		System.out.println("Step 2 - click the Start button");
		driver.findElement(By.xpath("//button[@id='startButton']")).click();
		
		System.out.println("Step 3 - Wait for the progress bar to reach 75%");
		WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='progressBar']")));
		int currentProgress = 0;
		while (currentProgress < 75) {
			currentProgress = Integer.parseInt(progressBar.getAttribute("aria-valuenow"));
		}
		System.out.println(currentProgress);
		Assert.assertEquals(currentProgress, 75);
		
		System.out.println("Step 4 - Click on stop button");
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();      
		}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}

