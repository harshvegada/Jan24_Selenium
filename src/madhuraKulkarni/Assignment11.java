/*Assignment - 11 : 14th April'2024
Login automation by krishna functionality using data driven approch using Excel sheet.*/

package madhuraKulkarni;

import java.io.IOException;
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

public class Assignment11 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched successfully");
	}

	@DataProvider(name = "loginDataProvider")
	public String[][] getLoginData() throws IOException {
		String[][] data = new Assignment11_ExcelRead().readDataFromExcelSheet(".//src//madhuraKulkarni//Data.xlsx",
				"LoginData");
		return data;
	}

	@Test(dataProvider = "loginDataProvider")
	void verifyLoginFunctionality(String userName, String passWord, String expectedVerificationText) {
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")))
				.sendKeys(userName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pwdSignin']")))
				.sendKeys(passWord);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnsubmitdetails']"))).click();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = expectedVerificationText;
		alert.accept();
		Assert.assertEquals(actualText, expectedText);
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
