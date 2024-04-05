package varshaNagadwala;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.UncaughtExceptionHandlers;

//Assignment - 1
//Prerequisite - Open browser & hit http://automationbykrishna.com
//TestCase1 - Registration page alert message check for password more than 8 characters
//TestCase2 - Registration page alert message check for password less than 8 characters
//TestCase3 - Basic elements Page - AlertDemo - alert message verification
//TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
//TestCase5 - Basic elements Page - Alert button - alert message verification
//Testcase6 - Registration Page enter username and password click on submit without handling alert try to clear the username.

public class AutomationByKrishna {

	WebDriver driver;

	void openBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();
	}

	void testCase1() throws InterruptedException {

		System.out.println("TestCase1 Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("registration2")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("varsha");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("1234567890");

		System.out.println("STEP : Click on submit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		String expectedText = "Success!";

		System.out.println("STEP : Get the actual alert text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		Thread.sleep(2000);
		alert.accept();

		System.out.println("VERIFY : Actualtext with Expectedtext");
		if (actualText.equals(expectedText)) {
			System.out.println("TestCase1 -> Pass");
		} else {
			System.out.println("TestCase1 -> Fail");
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void testCase2() throws InterruptedException {

		System.out.println("TestCase2 Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("registration2")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("varsha");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("1234");

		System.out.println("STEP : Click on submit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		String expectedText = "Failed! please enter strong password";

		System.out.println("STEP : Get the actual alert text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		Thread.sleep(2000);
		alert.accept();

		System.out.println("VERIFY : Actualtext with Expectedtext");
		if (actualText.equals(expectedText)) {
			System.out.println("TestCase2 -> Pass");
		} else {
			System.out.println("TestCase2 -> Fail");
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void testCase3() throws InterruptedException {

		System.out.println("TestCase3 Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter userFirstName");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Varsha");

		System.out.println("STEP : Enter  userLastName");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Nagadwala");

		System.out.println("STEP : Enter companyName");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("SteepGraph");

		System.out.println("STEP : Click on submit");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		String expectedText = "Varsha and Nagadwala and SteepGraph";

		System.out.println("STEP : Get the actual alert text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		Thread.sleep(2000);
		alert.accept();

		System.out.println("VERIFY : Actualtext with Expectedtext");
		if (actualText.equals(expectedText)) {
			System.out.println("TestCase3 -> Pass");
		} else {
			System.out.println("TestCase3 -> Fail");
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void testCase4() throws InterruptedException {

		System.out.println("TestCase4 Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("varsha");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("12345678");

		System.out.println("STEP : Click the checkbox");
		driver.findElement(By.xpath("//div[@class='col-lg-6']//input[@type='checkbox']")).click();

		System.out.println("STEP : Click on submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		String expectedText = "You successfully clicked on it";

		System.out.println("STEP : Get the actual alert text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		Thread.sleep(2000);
		alert.accept();

		System.out.println("VERIFY : Actualtext with Expectedtext");
		if (actualText.equals(expectedText)) {
			System.out.println("TestCase4 -> Pass");
		} else {
			System.out.println("TestCase4 -> Fail");
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void testCase5() throws InterruptedException {

		System.out.println("TestCase5 Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		String expectedText = "You must be TechnoCredits student!!";

		System.out.println("STEP : Get the actual alert text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		Thread.sleep(2000);
		alert.accept();

		System.out.println("VERIFY : Actualtext with Expectedtext");
		if (actualText.equals(expectedText)) {
			System.out.println("TestCase5 -> Pass");
		} else {
			System.out.println("TestCase5 -> Fail");
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void testCase6() throws InterruptedException {

		System.out.println("TestCase1 Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("registration2")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("varsha");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("1234567890");

		System.out.println("STEP : Click on submit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Thread.sleep(2000);
		try {
			System.out.println("STEP : Clear the username without handling Alert Popup");
			driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		} catch (UnhandledAlertException ae) {
			System.out.println("STEP : Clear the username after Alert Popup handle");
			driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		} finally {
			System.out.println("STEP : Close the Browser");
			driver.quit();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationByKrishna automationByKrishna = new AutomationByKrishna();
		automationByKrishna.testCase1();
		System.out.println();
		automationByKrishna.testCase2();
		System.out.println();
		automationByKrishna.testCase3();
		System.out.println();
		automationByKrishna.testCase4();
		System.out.println();
		automationByKrishna.testCase5();
		System.out.println();
		automationByKrishna.testCase6();
	}
}
