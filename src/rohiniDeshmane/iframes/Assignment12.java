package rohiniDeshmane.iframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment12 {
	WebDriver driver;
	
	@BeforeClass
	void openBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/WebTable.html");
		driver.manage().window().maximize();
	}
	
	@Test
	void iframeTesting() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("STEP 2 - Mouse Hover on \"SwitchTo\" menu, click on \"Frames\" submenu.");
		WebElement switchToField = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(switchToField).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Frames']")));
		System.out.println(frame.isDisplayed());
		frame.click();
		
		WebElement frameOne= driver.findElement(By.xpath("//iframe[@ id='singleframe']"));
		driver.switchTo().frame(frameOne);
		
		System.out.println("VERFIY - header of Single Iframe tab, it should be \"iFrame Demo\"");
		WebElement frameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//h5")));// driver.findElement().getText();
		softAssert.assertEquals("iFrame Demo", frameTextField.getText());
		
		System.out.println("STEP 3 - Enter your name in text box");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/div/div/input[@type='text']"))).sendKeys("Rohini");// driver.findElement().getText();
		
		WebElement frameTypeField = driver.findElement(By.xpath("//div[@class='container']/div/div/input[@type='text']"));
		System.out.println("VERIFY - variable name has been entered correctly [e.getAttribute(\"value\")]");
		wait.until(ExpectedConditions.textToBePresentInElementValue(frameTypeField, "Rohini")) ;
		softAssert.assertEquals(frameTypeField.getAttribute("value"), "Rohini");
	
		driver.switchTo().defaultContent();
		
		System.out.println("STEP 4 - Click on Iframe with in an Iframe button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[text()='Iframe with in an Iframe']"))).click();
		
		System.out.println("Move to inner iframe");
		WebElement frameOutside= driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
		driver.switchTo().frame(frameOutside);
		WebElement frameinsideside= driver.findElement(By.xpath("//div[@class='iframe-container']/iframe"));
		driver.switchTo().frame(frameinsideside);
	
		System.out.println("STEP 5 - Enter your name in the text box");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/div/div/input[@type='text']"))).sendKeys("Deshmane");
		
		System.out.println("VERIFY - Inner Frame header is \"iFrame Demo\"");
		WebElement innerframeTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//h5")));
		softAssert.assertEquals("iFrame Demo", innerframeTextField.getText());
		
		System.out.println("VERIFY - Out frame header is \"Nested iFrames\"");
		driver.switchTo().parentFrame();
		WebElement outerframeTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='iframe-container']//h5")));
		softAssert.assertEquals("Nested iFrames", outerframeTextField.getText());
		
		System.out.println("STEP 6 - Click on \"Single Iframe\".");
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[text()='Single Iframe ']"))).click();
		
		System.out.println("VERIFY \"iFrame Demo\" header is displayed.");
		driver.switchTo().frame(frameOne);
		frameTextField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//h5")));
		softAssert.assertEquals("iFrame Demo", frameTextField.getText());
		softAssert.assertAll();
	}
}
