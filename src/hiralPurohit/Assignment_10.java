package hiralPurohit;

import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment_10 {
		
	WebDriver driver;
		
	@BeforeClass
	void setBrowser() {
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("STEP:Hit the url");
	driver.get("http://automationbykrishna.com");
	driver.findElement(By.linkText("Registration")).click();
	}
	
	@Test
	(dataProvider="loginData")
	void loginSetup(String name, String pwd,String expectedText) {
	//expectedText="Failed! please enter strong password";
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
		System.out.println("Enter Your username");
		WebElement uname =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		uname.sendKeys(name);
			
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
			
		System.out.println("Click on submit buttun");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
			
		Alert alert=driver.switchTo().alert();
		String actualText=alert.getText();
		String ExpectedText="Success!";
		alert.accept();
		Assert.assertEquals(actualText,ExpectedText);
	}	
	@DataProvider(name="loginData")
		public Object[][]getLogin(){
		Object[][]data=new Object[3][3];
			
		data[0][0]="hiralp";
		data[0][1]="hiral@1234";
		data[0][2]="Success!";
			
		data[1][0]="techno";
		data[1][1]="te1";
		data[1][2]="Failed! please enter strong password";
			
		data[2][0]="credit";
		data[2][1]="hip1";
		data[2][2]="Success!";
			
		return data;
	}
		
	@AfterClass
	public void extFromBrowser() {
	driver.quit();
	}
}
