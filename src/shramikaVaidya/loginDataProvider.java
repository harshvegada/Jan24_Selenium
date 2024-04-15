package shramikaVaidya;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;


public class loginDataProvider {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Launch brouser and hit url");
	}
	
	@Test(dataProvider = "loginDataProvider")
	public void Assignment10(String uname, String pwd, String expectedAlertText) {
		//String expectedAlertText = "Failed! please enter strong password";
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement unameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		unameElement.sendKeys(uname);
		
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualAlertText, expectedAlertText);
	
	}
		 
	@DataProvider(name="loginDataProvider")
	public String[][] getLoginData() {
		String[][] data = new String[3][3];
		
		data[0][0] = "mkanani";
		data[0][1] = "mkan123";
		data[0][2] = "Failed! please enter strong password";
		
		data[1][0] = "techno";
		data[1][1] = "creditsTech123";
		data[1][2] = "Success!";
		
		data[2][0] = "credits";
		data[2][1] = "c123";
		data[2][2] = "Failed! please enter strong password";
		
		return data;
	}

}
