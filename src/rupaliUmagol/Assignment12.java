package rupaliUmagol;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment12 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void SetUp() {
		System.out.println(
				"STEP 1 - Launch Chrome Browser & navigate to URL - https://demo.automationtesting.in/WebTable.html");
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/WebTable.html");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	@Test
	public void frameDemo() {
		System.out.println("STEP 2 - Mouse Hover on \"SwitchTo\" menu, click on \"Frames\" submenu.");
		WebElement SwitchTo = driver.findElement(By.xpath("//a[text()='SwitchTo']"));

		SoftAssert softAssert = new SoftAssert();
		Actions action = new Actions(driver);
		action.moveToElement(SwitchTo).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Frames']"))).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));

		System.out.println("VERFIY - header of Single Iframe tab, it should be \"iFrame Demo\"");
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true)",wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame
		// Demo']"))));

		boolean header = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']")))
				.isDisplayed();
		softAssert.assertTrue(header, "header of Single Iframe tab is not displayed");

		System.out.println("STEP 3 - Enter your name in text box");
		WebElement inputbox = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container']/div/div/input[@type='text']")));
		inputbox.sendKeys("Rupali");

		System.out.println("VERIFY - variable name has been entered correctly [e.getAttribute(\"value\")]");
		String nameEntered = inputbox.getAttribute("value");

		softAssert.assertTrue(nameEntered.equals("Rupali"), "name enterd is wrong");

		driver.switchTo().defaultContent();

		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Iframe with in an Iframe']")))
				.click();

		System.out.println("STEP 5 - Enter your name in the text box");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));

		System.out.println("VERIFY - Out frame header is \"Nested iFrames\"");
		boolean multiheader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Nested iFrames']")))
				.isDisplayed();
		softAssert.assertTrue(multiheader, "header of Nested Iframe tab is not displayed");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));

		System.out.println("VERIFY - Inner Frame header is \"iFrame Demo\"");
		boolean innerheader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='iFrame Demo']")))
				.isDisplayed();
		softAssert.assertTrue(innerheader, "Inner Frame header is \\\"iFrame Demo is not displayed");

		System.out.println("STEP 6 - Enter name in the textBox");
		WebElement inputbox2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='container']/div//input[@type='text']")));
		inputbox2.sendKeys("Umagol");

		System.out.println("VERIFY - variable name has been entered correctly [e.getAttribute(\"value\")]");
		String nameEnteredinnerTextBox = inputbox2.getAttribute("value");

		softAssert.assertTrue(nameEnteredinnerTextBox.equals("Umagol"), "name enterd is wrong");

		System.out.println("STEP 7 - Click on \"Single Iframe\".");
		driver.switchTo().defaultContent();

		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true)",
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Single Iframe ']"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Single Iframe ']"))).click();

		System.out.println("VERIFY \"iFrame Demo\" header is displayed.");

		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
