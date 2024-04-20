package anandRathod;

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
	WebDriverWait wait;

	@BeforeMethod
	void setup() {
		System.out.println("Step : Launch browser");
		driver = new ChromeDriver();
		System.out.println("Step : hit URL");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html");
		System.out.println("Step : Clicked on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}

	@Test(dataProvider = "LoginDataProvider")
	public void loginTest(String uname, String pwd, String ExpectedalertMessage) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		usernameElement.sendKeys(uname);

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		alert.accept();
		Assert.assertEquals(actualAlertText, ExpectedalertMessage);
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] getLoginData() {
		String[][] data = new String[2][3];

		data[0][0] = "arathod";
		data[0][1] = "Test@12345";
		data[0][2] = "Success!";

		data[1][0] = "arathod";
		data[1][1] = "Test@1";
		data[1][2] = "Failed! please enter strong password";

		return data;
	}
}