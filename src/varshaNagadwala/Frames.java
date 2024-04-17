package varshaNagadwala;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//NOTE : use SoftAssert for verification. 
//
//STEP 1 - Launch Chrome Browser & navigate to URL - https://demo.automationtesting.in/WebTable.html
//STEP 2 - Mouse Hover on "SwitchTo" menu, click on "Frames" submenu.
//VERFIY - header of Single Iframe tab, it should be "iFrame Demo"
//STEP 3 - Enter your name in text box
//VERIFY - variable name has been entered correctly [e.getAttribute("value")]
//STEP 4 - Click on Iframe with in an Iframe button
//STEP 5 - Enter your name in the text box
//VERIFY - Inner Frame header is "iFrame Demo"
//VERIFY - Out frame header is "Nested iFrames"
//STEP 6 - Click on "Single Iframe".
//VERIFY "iFrame Demo" header is displayed. 
//
//Hint : To publish result, use softAssert.AssertAll();

public class Frames {

	WebDriver driver;
	WebDriverWait wait;
	SoftAssert softAssert;

	@BeforeMethod
	void LaunchBrowser() {
		System.out.println("STEP - Launch Chrome browser");
		driver = new ChromeDriver();

		System.out.println("STEP - Maximize the Browser");
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		softAssert = new SoftAssert();
	}

	@Test
	public void TestCase1() {

		System.out.println("STEP - Hit https://demo.automationtesting.in/WebTable.html URL");
		driver.get("https://demo.automationtesting.in/WebTable.html");

		System.out.println("STEP - Mouse Hover on \"SwitchTo\" menu, click on \"Frames\" submenu.");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//a[text()='Frames']")).click();

		System.out.println("VERFIY - header of Single Iframe tab, it should be \"iFrame Demo\"");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Single Iframe ']")));
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(iFrame);
		String actualFrameName = driver.findElement(By.xpath("//h5[text()='iFrame Demo']")).getText();
		String expectedFrameName = "iFrame Demo";
		softAssert.assertEquals(actualFrameName, expectedFrameName);

		System.out.println("STEP - Enter your name in text box");
		WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
		name.sendKeys("Varsha");
		String actualText = name.getAttribute("value");
		String expectedText = "Varsha";
		softAssert.assertEquals(actualText, expectedText);
		driver.switchTo().defaultContent();

		System.out.println("STEP - Click on Iframe with in an Iframe button");
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();

		System.out.println("STEP - Enter your name in the text box");
		WebElement iFrame1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@src='MultipleFrames.html']")));
		driver.switchTo().frame(iFrame1);

		WebElement iFrame2 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(iFrame2);

		WebElement name1 = driver.findElement(By.xpath("//input[@type='text']"));
		name1.sendKeys("VarshaNAGADWALA");
		String actualText1 = name1.getAttribute("value");
		String expectedText1 = "VarshaNAGADWALA";
		softAssert.assertEquals(actualText1, expectedText1);

		System.out.println("VERIFY - Inner Frame header is \"iFrame Demo\"");
		String actualFrameName2 = driver.findElement(By.xpath("//h5[text()='iFrame Demo']")).getText();
		String expectedFrameName2 = "iFrame Demo";
		softAssert.assertEquals(actualFrameName2, expectedFrameName2);

		System.out.println("VERIFY - Out frame header is \"Nested iFrames");
		driver.switchTo().parentFrame();
		String actualFrameName1 = driver.findElement(By.xpath("//h5[text()='Nested iFrames']")).getText();
		String expectedFrameName1 = "Nested iFrames";
		softAssert.assertEquals(actualFrameName1, expectedFrameName1);

		System.out.println("STEP - Click on Single Iframe.");
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();

		System.out.println("VERIFY \"iFrame Demo\" header is displayed.");
		WebElement iFrame3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='singleframe']")));
		driver.switchTo().frame(iFrame3);
		String actualFrameName3 = driver.findElement(By.xpath("//h5[text()='iFrame Demo']")).getText();
		String expectedFrameName3 = "iFrame Demo";
		softAssert.assertEquals(actualFrameName3, expectedFrameName3);

		softAssert.assertAll();

		System.out.println("Close the Browser");
		driver.quit();
	}
}
