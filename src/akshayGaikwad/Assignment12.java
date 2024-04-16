package akshayGaikwad;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment12 {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	void iFrameTest() {
		System.out.println("STEP 1 - Launch Chrome Browser & navigate to URL - https://demo.automationtesting.in/WebTable.html");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://demo.automationtesting.in/WebTable.html");
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println("STEP 2 - Mouse Hover on \"SwitchTo\" menu, click on \"Frames\" submenu.");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).perform();
		driver.findElement(By.xpath("//a[text()='Frames']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));

		WebElement iframeHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']")));
		softAssert.assertTrue(iframeHeader.isDisplayed(),"VERIFY - Header of Single Iframe tab, is not 'iFrame Demo'");
		System.out.println("VERIFY - Header of Single Iframe tab, is 'iFrame Demo'");
		
		System.out.println("STEP 3 - Enter your name in text box");
		WebElement textType = driver.findElement(By.xpath("//input[@type='text']"));
		
		textType.sendKeys("Akshay");
		String text = textType.getAttribute("value");
		softAssert.assertTrue(text.equals("Akshay"),"VERIFY - Name has been entered correctly");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));

		WebElement innerIframeHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Nested iFrames']")));
		softAssert.assertTrue(innerIframeHeader.isDisplayed(),"VERIFY - Header of Single Iframe tab, is not 'Nested iFrames'");
		System.out.println("VERIFY - Header of Single Iframe tab, is 'Nested iFrames'");
		
		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));

		WebElement innerIframeHeader2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']")));
		softAssert.assertTrue(innerIframeHeader2.isDisplayed(),"VERIFY - Header of Single Iframe tab, is not 'iFrame Demo'");
		System.out.println("VERIFY - Header of Single Iframe tab, is 'iFrame Demo'");
		
		System.out.println("STEP 5 - Enter your name in text box");
		WebElement textType2 = driver.findElement(By.xpath("//input[@type='text']"));
		
		textType2.sendKeys("Gaikwad");
		String text2 = textType2.getAttribute("value");
		softAssert.assertTrue(text2.equals("Gaikwad"),"VERIFY - Name has been entered correctly");
		
		driver.switchTo().defaultContent();
		System.out.println("STEP 6 - Click on 'Single Iframe'.");
		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
		
		softAssert.assertAll();
		
		System.out.println("STEP 7 - Close the browser");
		driver.quit();
	}
}
