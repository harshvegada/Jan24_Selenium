package ashwiniBalki;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenApproachLoginTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void launchBrowserSetUp(){
		
	    System.out.println("Launch Browser");
		driver = new ChromeDriver();
		
		System.out.println("STEP: Hit URL");
		driver.get("http://automationbykrishna.com");
		
		System.out.println("STEP: Maximise the browser window");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void loginTest(String userName, String password, String expectedAlertText) {
		
		System.out.println("------------");
		System.out.println("STEP:Click on Registration menu");
		driver.findElement(By.linkText("Registration")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("Enter UserName");
		WebElement uname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		uname.sendKeys(userName);
		
		System.out.println("Enter password and Click on login");
		driver.findElement(By.xpath("//input[@id ='pwdSignin']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id ='btnsubmitdetails']")).click();
		
		Alert alert = driver. switchTo().alert();
		String actualalertText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualalertText, expectedAlertText);
		
	}
	
	@DataProvider(name = "loginDataProvider")
	public String[][] getLoginData(){
		String[][] data = new String [2][3];
		
		data[0][0]="ashwini";
		data[0][1]="Ashwini1234";
		data[0][2]="Success!";
		
		data[1][0]="ashwini";
		data[1][1]="Ash";
		data[1][2]="Failed! please enter strong password";
		
		return data;
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
