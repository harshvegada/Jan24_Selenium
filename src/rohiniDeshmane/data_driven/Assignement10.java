package rohiniDeshmane.data_driven;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * Assignment - 10 : 13th April'2024
Login functionality on Automationbykrishna.com using data driven approach.
 */


public class Assignement10 {

WebDriver driver;
	
	@BeforeClass
	void openBrowser() {
		System.out.println("\n\nSTEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.linkText("Registration")).click();
		driver.manage().window().maximize();
	}
	
	@DataProvider(name="loginDataProvider")
	public Object loginDataProvider(){
		Object[][] data = new Object[3][3];
		
		data[0][0] ="mkanani";
		data[0][1] ="mkan123";
		data[0][2] ="Failed! please enter strong password";
		
		data[1][0] ="techno";
		data[1][1] ="creditsTech123";
		data[1][2] ="Success!";
		
		data[2][0] ="credits";
		data[2][1] ="c123";
		data[2][2] ="Failed! please enter strong password";
		
		return data;
	}
	
	@Test(dataProvider = "loginDataProvider")
	void verifyWithDatadriven(String uname, String password, String alertText) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).clear();
		
		System.out.println("STEP : add username and password "+uname+" "+password);
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys(password);
		
		System.out.println("STEP : Click on submit button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();
	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		Thread.sleep(2000);
		Assert.assertEquals(text, alertText);
		
		System.out.println("Test case Passed");
		
	}
}
