package sasmitaSahu;

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
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step-Launch the browser");
		driver.get("http://automationbykrishna.com/");
	}
	@DataProvider (name = "loginDataProvider")
	 String[][] getData() {
	 return new Assignment11Dataprovider().readData("D:\\JAVASELENIUM\\IDE\\Jan24_EliteQA_Automation_sasmita\\Testing excel.xlsx", "Logindata");
	}
	@Test(dataProvider = "loginDataProvider")
	public void loginTest(String uname, String pwd, String expectedText) {
		System.out.println("Step4-Click on registration button");
		driver.findElement(By.id("registration2")).click();

		System.out.println("Step5-Enter username");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernmame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unameSignin")));
		usernmame.sendKeys("sasmita");

		System.out.println("Step6-Enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys("samita213");

		System.out.println("Step7-Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("STEP8: Switch to alert and get text from it");
		Alert alert = driver.switchTo().alert();
		String actualAlert = alert.getText();
		alert.accept();

		Assert.assertEquals(actualAlert, expectedText);

	}
	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
