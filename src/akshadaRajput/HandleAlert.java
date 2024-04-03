package akshadaRajput;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {

	WebDriver driver;

	void launchBrowser() {

		System.out.println("Prerequisite: Open browser & hit http://automationbykrishna.com");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

	}

	void alertHandlingwithPasswordLengthGreaterThan8() throws InterruptedException {

		launchBrowser();
		Thread.sleep(2000);

		System.out.println("Submitting username and password");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("unameSignin")).sendKeys("akshada_rajput");
		driver.findElement(By.id("pwdSignin")).sendKeys("Abcd@1234");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlert = alert.getText();
		String expectedAlert = "Success!";

		System.out.println("Comparing expected and actual alerts");
		if (actualAlert.equals(expectedAlert))
			System.out.println("TC Pass");
		else
			System.out.println("TC Fail");

		alert.accept();
		driver.quit();
	}

	void alertHandlingwithPasswordLengthLessThan8() throws InterruptedException {

		launchBrowser();
		Thread.sleep(2000);

		System.out.println("Submitting username and password");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("unameSignin")).sendKeys("akshada_rajput");
		driver.findElement(By.id("pwdSignin")).sendKeys("Abcd@12");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlert = alert.getText();
		String expectedAlert = "Failed! please enter strong password";

		System.out.println("Comparing expected and actual alerts");
		if (actualAlert.equals(expectedAlert))
			System.out.println("TC Pass");
		else
			System.out.println("TC Fail");

		alert.accept();
		driver.quit();
	}

	void basicElementsPageAlertMessageVerification() throws InterruptedException {
		launchBrowser();
		Thread.sleep(2000);

		System.out.println("Submitting FirstName, LastName and CompanyName");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("ufname")).sendKeys("test_automation");
		driver.findElement(By.xpath("//input[@placeholder='Enter User Lastname']")).sendKeys("Lname");
		driver.findElement(By.id("UserCompanyName")).sendKeys("cmpName");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		Alert alert = driver.switchTo().alert();
		String FirstName = "test_automation";
		String LastName = "Lname";
		String CompanyName = "cmpName";

		String expectedAlert = FirstName + " and " + LastName + " and " + CompanyName;

		System.out.println("Comparing expected and actual alerts");
		if (expectedAlert.equals(alert.getText()))
			System.out.println("TC Pass");
		else
			System.out.println("TC Fail");

		alert.accept();
		driver.quit();
	}

	void basicFormsAlertMessageVerification() throws InterruptedException {

		launchBrowser();
		Thread.sleep(2000);

		System.out.println("Submitting email address and password");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("exampleInputEmail1")).sendKeys("test@test.com");
		driver.findElement(By.id("pwd")).sendKeys("Abcd1234");
		driver.findElement(By.id("submitb2")).click();

		Alert alert = driver.switchTo().alert();
		String expectedAlert = "You successfully clicked on it";

		System.out.println("Comparing expected and actual alerts");
		if (expectedAlert.equals(alert.getText()))
			System.out.println("TC Pass");
		else
			System.out.println("TC Fail");
		alert.accept();
		driver.quit();
	}

	void alertButtonAlertMessageVerification() throws InterruptedException {

		launchBrowser();
		Thread.sleep(2000);

		System.out.println("Clicking alerts button");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//button[@class='btn btn-success']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

		Alert alert = driver.switchTo().alert();
		String expectedAlert = "You must be TechnoCredits student!!";

		System.out.println("Comparing expected and actual alerts");
		if (expectedAlert.equals(alert.getText()))
			System.out.println("TC Pass");
		else
			System.out.println("TC Fail");
		alert.accept();

		driver.quit();
	}

	public static void main(String args[]) throws InterruptedException {
		HandleAlert handleAlert = new HandleAlert();

		System.out.println("TestCase1 - Registration page alert message check for password more than 8 characters");
		handleAlert.alertHandlingwithPasswordLengthGreaterThan8();

		System.out.println();
		System.out.println("TestCase2 - Registration page alert message check for password less than 8 characters");
		handleAlert.alertHandlingwithPasswordLengthLessThan8();


		System.out.println();
		System.out.println("TestCase3 - Basic elements Page - AlertDemo - alert message verification");
		handleAlert.basicElementsPageAlertMessageVerification();


		System.out.println();
		System.out.println("TestCase4 - Basic elements Page - BASIC FORMS - alert message verification");
		handleAlert.basicFormsAlertMessageVerification();


		System.out.println();
		System.out.println("TestCase5 - Basic elements Page - Alert button - alert message verification");
		handleAlert.alertButtonAlertMessageVerification();
	}
}
