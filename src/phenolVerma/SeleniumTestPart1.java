
/*Selenium Test - 1 [1 hr]

*Test cases we need to automate:*

TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statements are true:

The button labeled Opacity 0 Button should not be displayed
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

package phenolVerma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTestPart1 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/visibility");
	}

	boolean elementDisplayed(By by) {
		try {
		WebElement e =wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return !(e.isDisplayed());
		} catch(Exception e) {
			return true;
		}
	}

	@Test
	void TestCase1() {
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		// The button labeled Opacity 0 should not be displayed
		if (elementDisplayed(By.xpath("//button[text()='Opacity 0']"))) {
			System.out.println("✓ should not display the Opacity 0 button");
		} else {
			System.out.println("✓ Still display the Opacity 0  button");
		}

		// The button labeled Removed should not be displayed
		if (elementDisplayed(By.xpath("//button[text()='Removed']"))) {
			System.out.println("✓ should not display the removed button");
		} else {
			System.out.println("✓ Still display the removed button");
		}

		// The button labeled Visibility Hidden should not be displayed
		if (elementDisplayed(By.xpath("//button[text()='Visibility Hidden']"))) {
			System.out.println("✓ should not display the invisible button");
		} else {
			System.out.println("✓ Still display the Visibility Hidden button");
		}

		// The button labeled Display None should not be displayed
		if (elementDisplayed(By.xpath("//button[text()='Display None']"))) {
			System.out.println("✓ should not display the Display None button");
		} else {
			System.out.println("✓ Still display the Display None button");
		}
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}
}
