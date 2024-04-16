
/*
 Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification
 */

package kanchanGhughe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	WebDriver driver;

	void login() throws InterruptedException {
		System.out.println("TestCase1 - Registration page alert message check for password more than 8 characters");
		System.out.println("STEP:Chrome browser launch");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: hit URL");
		driver.get("http://automationbykrishna.com");
		System.out.println("STEP:Click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP: enter text into username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Kanchan");
	}

	// Registration page alert message check for password more than 8 characters
	void testCase1() throws InterruptedException {
		login();

		System.out.println("STEP: enter text into password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("435252556747");

		System.out.println("STEP:click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP:get text from Alert");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println(actualText);
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passed");
		} else
			System.out.println("Test Failed");

	}

	void testCase2() throws InterruptedException {
		System.out.println("TestCase2-Registration page alert message check for password less than 8 characters");
		login();

		System.out.println("STEP: enter text into password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("556747");

		System.out.println("STEP:click on Login button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP:get text from Alert");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println(actualText);
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passed");
		} else
			System.out.println("Test Failed");
	}

	void testCase3() throws InterruptedException {
		System.out.println("TestCase3-Basic elements Page - AlertDemo - alert message verification");
		String firstName = "Techno";
		String lastName = "Credits";
		String cmpName = "Techno Credits";
		System.out.println("STEP:Chrome browser launch");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP:click on Basic elements page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
		System.out.println("STEP:First Name entered");
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);

		Thread.sleep(2000);
		System.out.println("STEP:Last name entered");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);

		System.out.println("STEP:Company Name entered");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(cmpName);

		System.out.println("STEP:Clicked on Submit button");
		driver.findElement(By.xpath("//div/div[@class='form-group']/button[@type='submit']")).click();

		System.out.println("STEP:Alert msg Verification");
		String expectedText = firstName + " and " + lastName + " and " + cmpName;
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("Expected Text : " + (expectedText.length()));
		System.out.println("Actual Text : " + (actualText.length()));
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passed");
		} else
			System.out.println("Test Failed");
	}

	void testCase4() throws InterruptedException {
		System.out.println("TestCase4-Basic elements Page - BASIC FORMS - alert message verification");
		String emailID = "TechnoCredits@gmail.com";
		String password = "132425252";

		System.out.println("STEP:Chrome browser launch");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP:click on Basic elements page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		System.out.println("STEP:Email ID entered");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(emailID);

		System.out.println("STEP:Password entered");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);

		System.out.println("STEP:Clicked Checkbox");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		System.out.println("STEP:Clicked on Submit Button");
		driver.findElement(By.xpath("//div/button[@id='submitb2']")).click();

		System.out.println("STEP:Alert msg Verification");
		Alert alert = driver.switchTo().alert();
		String expectedText = "You successfully clicked on it";
		String actualText = alert.getText();
		System.out.println("Expected Text : " + (expectedText.length()));
		System.out.println("Actual Text : " + (actualText.length()));
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passed");
		} else
			System.out.println("Test Failed");
	}

	void testCase5() throws InterruptedException {

		System.out.println("TestCase5-Basic elements Page - Alert button - alert message verification");
		System.out.println("STEP:Chrome browser launch");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP:click on Basic elements page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
		System.out.println("STEP:Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("STEP:Alert msg Verification");
		Alert alert = driver.switchTo().alert();
		String expectedText = "You must be TechnoCredits student!!";
		String actualText = alert.getText();
		System.out.println("Expected Text : " + (expectedText.length()));
		System.out.println("Actual Text : " + (actualText.length()));
		if (actualText.equals(expectedText)) {
			System.out.println("Test Passed");
		} else
			System.out.println("Test Failed");

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment1().login();
		new Assignment1().testCase1();
		new Assignment1().testCase2();
		new Assignment1().testCase3();
		new Assignment1().testCase4();
		new Assignment1().testCase5();

	}
}
