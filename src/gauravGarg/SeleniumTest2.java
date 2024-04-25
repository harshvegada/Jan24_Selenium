/*
 * TC 2 : Navigate to http://uitestingplayground.com/progressbar, 
 * click on the Start button, wait until it reaches 75% and then
 *  click on the Stop button, the test should attempt to stop the execution at as close as possible to 75%, 
 *  but there's a 5% leeway (so returning 80% would be fine).
 */
package gauravGarg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest2 {

WebDriver wb;
WebDriverWait wait;    
	@BeforeMethod
	void lauchBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://uitestingplayground.com/progressbar");
		wait= new WebDriverWait(wb,Duration.ofSeconds(50));
		System.out.println("STEP 1- Hit the url.");
	}
	
	@Test
	void SelenuimTest2()
	{
		wb.findElement(By.xpath("//button[@id='startButton']")).click();
		System.out.println("STEP 2- Click on start Button.");
//		wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//div[@id='progressBar']"),"75%"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='progressBar']"),"75%"));
		System.out.println("STEP 3- Check the progress bar value to 75%");
		wb.findElement(By.xpath("//button[@id='stopButton']")).click();
		System.out.println("STEP 4- Click on stop Button.");
		
		
	}
}
