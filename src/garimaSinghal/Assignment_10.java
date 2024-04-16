package garimaSinghal;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment_10 {
WebDriver driver;
	
	@BeforeClass
	void launchAndHitUrl() {
		System.out.println("STEP: Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Hit URL");
		driver.get("http://automationbykrishna.com/");
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void loginData(String uname,String pwd,String expectedText) {
		System.out.println("STEP: Click on Registration Link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		
		System.out.println("STEP: Enter text into Username");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		username.sendKeys(uname);

		System.out.println("STEP: Enter text into password more than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);

		System.out.println("STEP: click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP: Switch to alert and get text from it");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@DataProvider(name="loginDataProvider")
	public Object[][] getLoginData() {
		Object[][] data = new Object[3][3];
		
		data[0][0] = "mkanani";
		data[0][1] = "mkan123";
		data[0][2] = "Failed! please enter strong password";
		
		data[1][0] = "techno";
		data[1][1] = "creditsTech123";
		data[1][2] = "Success!";
		
		data[2][0] = "credits";
		data[2][1] = "c123";
		data[2][2] = "Success!";
		
		return data;
	}

}
