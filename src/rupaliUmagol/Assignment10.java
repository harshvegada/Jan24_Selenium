/*Assignment - 10 : 13th April'2024
Login functionality on Automationbykrishna.com using data driven approach.*/
package rupaliUmagol;

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

public class Assignment10 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.out.println("STEP 1: lunch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP 2 : Open Url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP 3 : Click on registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
	}

	@Test(dataProvider = "loginDataProvider")
	public void SignUp(String uname, String pwd, String expectedResult) {
		System.out.println("STEP 4 : Enter userName");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement username = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));

		username.sendKeys(uname);

		System.out.println("STEp 5 : Enter Password");
		WebElement password = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		password.sendKeys(pwd);

		System.out.println("STEP 6 : Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("VERIFY : Expected and Actual Text of Alert");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), expectedResult);
		alert.accept();
	}

	@DataProvider(name = "loginDataProvider")
	public String[][] loginDataProvide() {
		String[][] data = new String[3][3];

		data[0][0] = "Rupali";
		data[0][1] = "Rupali@123456";
		data[0][2] = "Success!";

		data[1][0] = "Rupali";
		data[1][1] = "Rup";
		data[1][2] = "Failed! please enter strong password";

		data[2][0] = "Vinod";
		data[2][1] = "Ru";
		data[2][2] = "Success!";

		return data;
	}

	@AfterMethod
	public void setUpEnd() {
		System.out.println("STEP 7 : Close Browser");
		driver.quit();
	}
}
