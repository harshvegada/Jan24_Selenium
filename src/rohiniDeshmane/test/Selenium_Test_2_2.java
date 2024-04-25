package rohiniDeshmane.test;

import java.time.Duration;

import javax.xml.stream.events.Characters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium_Test_2_2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	void launchBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/progressbar");
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, Duration.ofSeconds(90));
	}
	
	@Test
	void TestCase2() {
		System.out.println("STEP : Click on Start Button");
		driver.findElement(By.xpath("//button[@id='startButton']")).click();
		
		System.out.println("STEP : Check progress bar status");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='progressBar']"),"75%"));
		
		System.out.println("STEP : Click on STOP Button");	
		driver.findElement(By.xpath("//button[@id='stopButton']")).click();
	
		System.out.println("Verify : Expected result is between 75 and 80. Got 75");
		String percentage = driver.findElement(By.xpath("//div[@id='progressBar']")).getText();
		Assert.assertEquals(percentage, "75%");
		System.out.println(percentage);
	}
}
