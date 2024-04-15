package varshaNagadwala;

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

public class AutomationByKrishnaLoginValidationWithExcel {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@DataProvider(name = "loginData")
	public Object[][] testData() {
		Object[][] data = ReadExcelInputFile.readFileInput(".//src//varshaNagadwala//Data.xlsx", "LoginData");

		return data;
	}

	@Test(dataProvider = "loginData")
	public void validateLoginPage(String userName, String password, String expectedResult) {

		System.out.println("-----Testcases Start----");

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("registration2")).click();

		WebElement uname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));

		System.out.println("STEP : Enter userName");
		uname.sendKeys(userName);

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);

		System.out.println("STEP : Click on login");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("VERIFY : Actual annd Expected Result");
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		alert.accept();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}
}
