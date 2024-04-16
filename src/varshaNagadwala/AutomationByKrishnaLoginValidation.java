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

public class AutomationByKrishnaLoginValidation {

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
	public String[][] testData() {
		String[][] data = new String[3][3];

		data[0][0] = "varsha";
		data[0][1] = "va12";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "varsha";
		data[1][1] = "varsha1234";
		data[1][2] = "Success!";

		data[2][0] = "varsha";
		data[2][1] = "var23";
		data[2][2] = "Failed! please enter strong password";

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
