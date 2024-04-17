package hiralPurohit;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven11 {
	WebDriver driver;

	@BeforeClass
	void toGetBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP: HIt the Url");
		driver.get("http://automationbykrishna.com");
		System.out.println("STEP: Click on registration Button");

	}

	@DataProvider(name = "loginData")
	public static Object[][] testdata() {
		Object[][] data = Assignment_11.fileinput(".//src//hiralPurohit//data1.xlsx", "loginData");
		return data;
	}

	@Test(dataProvider = "loginData")
	public void toDoregistration(String userName, String pass, String popup) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP: Enter the userName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")))
				.sendKeys(userName);

		System.out.println("STEP: Enter the password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pwdSignin']")))
				.sendKeys(userName);

		System.out.println("STEP: click on submit button");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnsubmitdetails']"))).click();

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualText, "Failed! please enter strong password");

	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}

}
