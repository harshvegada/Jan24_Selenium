package akshayGaikwad;

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

public class Assignment11 {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	void setup() {
		driver  = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}
	
	@DataProvider(name = "loginDataProvider")
	String[][] getLoginData(){
		return ExcelFileReading.getDataFromExcel(".\\src\\akshayGaikwad\\Data.xlsx","LoginData");
	}
	
	@Test(dataProvider = "loginDataProvider")
	void logInTests(String userName, String pwd, String msg) throws InterruptedException {
		System.out.println("STEP : Go to Registration");
		WebElement regEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='registration2']")));
		regEle.click();
		
		System.out.println("STEP : Enter Username");
		WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		we.sendKeys(userName);
		
		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().equals(msg),"VERIFY : Alert messege does not match " + userName);
		alert.accept();
		System.out.println("VERIFY : Correct message is displayed");
	}
	
	@AfterMethod
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
}
