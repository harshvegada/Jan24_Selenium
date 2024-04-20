package garimaSinghal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_12 {
	WebDriver driver;
	WebDriverWait wait;
	SoftAssert softAssert;
	
	@BeforeMethod
	void launchAndHitUrl() {
		System.out.println("Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Navigate to URL");
		driver.get("https://demo.automationtesting.in/WebTable.html");
	}
	
	WebElement findElement(String path) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));	
	}
	
	void verifyElement(String path,String expectedMessage) {
		softAssert = new SoftAssert();
		String text=driver.findElement(By.xpath(path)).getText();
		System.out.println(text);
		softAssert.assertEquals(text, expectedMessage,"Headers not matched");
	}
	
	@Test
	void testCase(){
		Actions action =new Actions(driver);
		WebElement e=driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		action.moveToElement(e).build().perform();
		
		findElement("//a[text()='Frames']").click();	
		System.out.println("STEP 2 - Mouse Hover on SwitchTo menu, click on Frames submenu.");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));
		//String text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']"))).getText();
		//System.out.println(text);
		verifyElement("//h5[text()='iFrame Demo']","iFrame Demo");
		System.out.println("VERFIY - header of Single Iframe tab, it should be iFrame Demo");
	
		WebElement name=findElement("//div[@class='container']/div/div/input[@type='text']");
		findElement("//div[@class='container']/div/div/input[@type='text']").sendKeys("Garima");
		System.out.println("STEP 3 - Enter your name in text box");
		
		String actual=name.getAttribute("value");
		softAssert.assertEquals(actual, "Garima", "Name not matched");
		System.out.println("VERIFY - variable name has been entered correctly");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		
		verifyElement("//h5[text()='Nested iFrames']","Nested iFrames");
		System.out.println("VERIFY - Header of Single Iframe tab, is 'Nested iFrames");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		
		verifyElement("//h5[text()='iFrame Demo']","iFrame Demo");
		System.out.println("VERIFY - Inner Frame header is iFrame Demo");
		
		WebElement secondName=findElement("//div[@class='container']/div//input[@type='text']");
		secondName.sendKeys("Singhal");
		System.out.println("STEP 5 - Enter your Second name in the text box");
		
		String actual1=secondName.getAttribute("value");
		softAssert.assertEquals(actual1, "Singhal", "Name not matched");
		System.out.println("VERIFY - Second name has been entered correctly");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
		System.out.println("STEP 6 - Click on Single Iframe");
		
		softAssert.assertAll();
	}
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
