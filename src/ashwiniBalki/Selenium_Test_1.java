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
/*
 TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statements are true:
The button labeled Opacity 0 should not be displayed
The button labeled Removed should not be displayed
The button labeled Visibility Hidden should not be displayed
The button labeled Display None should not be displayed

 */
import org.testng.annotations.Test;
public class Selenium_Test_1 {
	
    WebDriver driver;
    WebDriverWait wait;
	
	@BeforeMethod
	public void setut() {
		System.out.println("STEP: Launch Chrome Browser");
		driver = new ChromeDriver();
		
		System.out.println("Step: Hit URL");
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/visibility");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));		
	}
	
	@Test
	public void tc1() {
		System.out.println("STEP: Check Hide button is visoble and click on the Hide button");
		WebElement hideButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id ='hideButton']")));
		hideButton.isDisplayed();
		hideButton.click();
		
		System.out.println("STEP: The button labeled Opacity 0 should not be Displayed");
		boolean isOpacity0btnHidden = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id ='transparentButton']")));
		Assert.assertTrue(isOpacity0btnHidden , "The button labeled Opacity 0 was displayed");
		
		System.out.println("STEP: The button labeled Removed should not be displayed ");
		boolean isRemovedbtnHidden = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id ='removedButton']")));
		Assert.assertTrue(isRemovedbtnHidden, "The button labeled Removed was  displayed");
		
		System.out.println("STEP: The button labeled Visibility Hidden should not be displayed ");
		boolean isVisibilitybtnHidden = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id ='invisibleButton']")));
		Assert.assertTrue(isVisibilitybtnHidden, "The button labeled Visibility Hidden was displayed");
		
		System.out.println("STEP: The button labeled Display None should not be displayed");
		boolean isDisplayNonebtnHidden = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id ='invisibleButton']")));
		Assert.assertTrue(isDisplayNonebtnHidden, "The button labeled Display None was displayed");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
