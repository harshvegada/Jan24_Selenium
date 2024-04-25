package sakshi;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Step - Navigate to http://uitestingplayground.com/visibility");
		//System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/visibility");
	}
	
	public void verifyIsButtonDisplayed(String buttonName) {
		try {
			boolean buttonVisiblityFlag = driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).isDisplayed();
			System.out.println(buttonVisiblityFlag);
			Assert.assertFalse(buttonVisiblityFlag);
		}catch(NoSuchElementException exception) {
			System.out.println("false");
			Assert.assertFalse(false);
		}
	}
	
	@Test
	public void tC1() {
		System.out.println("Strp 2 - click on the Hide button");
		driver.findElement(By.xpath("//button[text()='Hide']")).click();
		
		System.out.println("Step 3 - The button labeled Opacity 0 should not be displayed");
		verifyIsButtonDisplayed("Opacity 0");
	
		System.out.println("Step 4 - The button labeled Removed should not be displayed");
		verifyIsButtonDisplayed("Removed");
		
		System.out.println("Step 5 - The button labeled Visibility Hidden should not be displayed");
		verifyIsButtonDisplayed("Visibility Hidden");
		
		System.out.println("Step 6 - The button labeled Display None should not be displayed");
		verifyIsButtonDisplayed("Display None");	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
