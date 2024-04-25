/*TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statements are true:

The button labeled Opacity 0 should not be displayed
The button labeled Removed should not be displayed
The button labeled Visibility Hidden should not be displayed
The button labeled Display None should not be displayed
 */
package sasmitaSahu;
import static org.testng.Assert.assertEquals;

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

public class Testcase1test {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	void launchAndHiturl() {
		System.out.println("STEP-Launch the browser");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("STEP-HIT the url");
		driver.get("http://uitestingplayground.com/visibility");	
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	@Test
	void checkHideFunction()throws InterruptedException {
		System.out.println("STEP-Click on hide button");
		driver.findElement(By.xpath("//button[@id='hideButton']")).click();
		
		
		System.out.println("STEP-Check the visiablity of Opacity 0 button");
		boolean isOpacity0buttoninvisiable = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='transparentButton']")));
        Assert.assertTrue(isOpacity0buttoninvisiable, " the Opacity 0 button was displayed");
		
		System.out.println("STEP-Check the visiablity of removedButton button");
		boolean isremovedButtonInvisiable=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='removedButton']")));
		Assert.assertTrue(isremovedButtonInvisiable, "removedButton was displayed");
		
	    System.out.println("STEP-Check the visiablity of Visibility Hidden");
		boolean isVisibilityButtonInvisiable=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='invisibleButton']")));
		Assert.assertTrue(isVisibilityButtonInvisiable, "Visibility Hidden button was displayed");
	   
	    System.out.println("STEP-Check the visiablity of Display None");
	    boolean isDisplayNoneButtonInvisiable=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Display None']")));
		Assert.assertTrue(isDisplayNoneButtonInvisiable, "Display None button was displayed");

	}
	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}

	}


