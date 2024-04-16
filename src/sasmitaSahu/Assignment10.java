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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment10 {
	@Test(dataProvider = "loginTest")
	public void loginTest(String uname, String pwd, String expectedText) {

		System.out.println("Step1-Launch the chrome browser");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step2-Maximize the borwser");
		driver.manage().window().maximize();

		System.out.println("Step3-hit the url");
		driver.get("http://automationbykrishna.com/");

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

	@DataProvider(name = "loginTest")
	public Object[][] getLoginData() {
		Object[][] data = new Object[3][3];

		data[0][0] = "mkanani";
		data[0][1] = "mkan123";
		data[0][2] = "Failed! please enter strong password";

		data[1][0] = "techno";
		data[1][1] = "creditsTech123";
		data[1][2] = "Success!";

		data[2][0] = "credits";
		data[2][1] = "c123";
		data[2][2] = "Success!";

		return data;
	}
}
