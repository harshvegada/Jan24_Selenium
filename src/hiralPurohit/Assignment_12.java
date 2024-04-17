package hiralPurohit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_12 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP1 - Launch Chrome Browser & navigate to URL");
		driver.get("https://demo.automationtesting.in/WebTable.html");

	}

	@Test
	public void toGetElementOfIframe() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("STEP2 - Mouse Hover on SwitchTo menu, click on Frames submenu.");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Frames']"))).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));

		System.out.println("VERFIY - header of Single Iframe tab, it should be iFrame Demo");
		WebElement iframeHeader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']")));
		softAssert.assertTrue(iframeHeader.isDisplayed(), "VERIFY - Header of Single Iframe tab, is not 'iFrame Demo'");

		System.out.println("STEP 3 - Enter your name in text box");
		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container']/div/div/input[@type='text']")));
		element1.sendKeys("hiral");

		System.out.println("VERIFY - variable name has been entered correctly");
		String value = element1.getAttribute("value");
		softAssert.assertTrue(value.equals("hiral"), "Name has been entered correctly");

		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));

		System.out.println("Verify the nested frame header");
		WebElement element2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Nested iFrames']")));
		softAssert.assertEquals(element2.isDisplayed(), true, "Nested frame not visible");
		
		
		System.out.println("STEP- Click on Iframe with in an Iframe button");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));

		Thread.sleep(5000);
		
		System.out.println("VERIFY - Inner Frame header is iFrame Demo");
		WebElement innerIframe2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']")));
		softAssert.assertTrue(innerIframe2.isDisplayed(), "VERIFY - Header of Single Iframe tab, is not 'iFrame Demo'");
		System.out.println("VERIFY - Header of Single Iframe tab, is 'iFrame Demo'");

		System.out.println("STEP 5 - Enter your name in text box");
		WebElement element3 = driver.findElement(By.xpath("//input[@type='text']"));

		element3.sendKeys("purohit");
		String name2 = element3.getAttribute("value");
		softAssert.assertTrue(name2.equals("purohit"), "Name has been entered correctly");

		driver.switchTo().defaultContent();
		System.out.println("STEP 6 - Click on 'Single Iframe'.");
		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();

		softAssert.assertAll();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
