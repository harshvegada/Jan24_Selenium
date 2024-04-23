/*
 * Assignment - 12 : 16th April'2024
NOTE : use SoftAssert for verification.
STEP 1 - Launch Chrome Browser & navigate to URL - https://demo.automationtesting.in/WebTable.html
STEP 2 - Mouse Hover on "SwitchTo" menu, click on "Frames" submenu.
VERFIY - header of Single Iframe tab, it should be "iFrame Demo"
STEP 3 - Enter your name in text box
VERIFY - variable name has been entered correctly [e.getAttribute("value")]
STEP 4 - Click on Iframe with in an Iframe button
STEP 5 - Enter your name in the text box
VERIFY - Inner Frame header is "iFrame Demo"
VERIFY - Out frame header is "Nested iFrames"
STEP 6 - Click on "Single Iframe".
VERIFY "iFrame Demo" header is displayed
 */
package gauravGarg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class mouseOverAndFrameAssignment12 {

	
	WebDriver wb;
	@BeforeMethod
	void lauchBrowser()
	{
	    wb = new ChromeDriver();
		wb.manage().window().maximize();
		System.out.println("STEP 1 - Launch Chrome browser");
		wb.get("https://demo.automationtesting.in/WebTable.html");
		System.out.println("STEP 2 - Hit https://demo.automationtesting.in/WebTable.html");
	}
	
	@Test
	void mouseoverAndFrame()
	{
		SoftAssert  softassert= new SoftAssert();
		Actions action= new Actions(wb);
		action.moveToElement(wb.findElement(By.xpath("//a[text()='SwitchTo']"))).build().perform();
		WebDriverWait wait= new WebDriverWait(wb,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Frames']"))).click();
//		wb.findElement(By.xpath("//div[@class='btn skip']")).click();
		System.out.println("STEP 2 - Mouse Hover on SwitchTo menu, click on Frames submenu.");
	    JavascriptExecutor js=(JavascriptExecutor)wb;
		js.executeScript("arguments[0].scrollIntoView(true)",wb.findElement(By.xpath("//a[text()='Single Iframe ']")));
		wb.switchTo().frame("singleframe");
		String text=wb.findElement(By.xpath("//h5[text()='iFrame Demo']")).getText();
		softassert.assertEquals(text, "iFrame Demo");
		System.out.println("VERFIY - header of Single Iframe tab, it should be iFrame Demo");
		wb.findElement(By.xpath("//input[@type='text']")).sendKeys("Gaurav");
		System.out.println("STEP 3 - Enter your name in text box");
	    String inputtext=wb.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
	    softassert.assertEquals(inputtext, "Gaurav");
	    System.out.println("VERIFY - variable name has been entered correctly [e.getAttribute(value)]");
		wb.switchTo().parentFrame();
		wb.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		wb.switchTo().frame(wb.findElement(By.xpath("//iframe[@style='float: left;height: 300px;width:600px']")));
		wb.switchTo().frame(wb.findElement(By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']")));
		wb.findElement(By.xpath("//input[@type='text']")).sendKeys("Gaurav Garg");
		System.out.println("STEP 5 - Enter your name in the text box");
		
		boolean text2=wb.findElement(By.xpath("//section//div[@class='container']/h5")).isDisplayed();
		softassert.assertEquals(text2, true);
		System.out.println("VERIFY - Inner Frame header is iFrame Demo");
		wb.switchTo().parentFrame();
		boolean text3=wb.findElement(By.xpath("//section//div[@class='iframe-container']/h5")).isDisplayed();
		softassert.assertEquals(text3, true);
		System.out.println("VERIFY - Out frame header is Nested iFrames");
		wb.switchTo().defaultContent();
		wb.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
		System.out.println("STEP 6 - Click on Single Iframe.");
		System.out.println("VERIFY iFrame Demo header is displayed");	
		softassert.assertAll();
	}
	
	@AfterMethod
	void close()
	{
		wb.quit();
	}
}
