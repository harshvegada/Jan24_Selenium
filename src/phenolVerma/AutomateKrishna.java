/*
 Test Case - 1 - Under Registration login and capture the text from alert popup
 Test Case - 2 - Under Basic Element fill ALERT DEMO section
 Test Case - 3 - Under Basic Element fill BASIC FORMS section
 Test Case - 4 - Under Basic Element click on Alert button under DIFFERENT EXAMPLES OF ALERTS
 */

package phenolVerma;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateKrishna {

	// Creating Chrome webdriver object
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Sleep for 2 mins");
		Thread.sleep(2000);
	}

	// Test Case - 1 - Under Registration login and capture the text from alert
	// popup
	void testCase_1() throws InterruptedException {

		System.out.println("Opening the browser");
		openBrowser();

		System.out.println("Clicking on Registration link");
		driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();

		Thread.sleep(2000);

		System.out.println("Entering Username");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("maulik");

		System.out.println("Entering Password");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("maulik12345");

		System.out.println("Clicking on Login button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();

		System.out.println("Catching the Alret window");
		Alert alert = driver.switchTo().alert();

		// Getting the alert message
		String alertText = alert.getText();
		if (alertText.equals("Success!")) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}

		// Accepting the alert message
		alert.accept();
		System.out.println("Alret message window closed");

		System.out.println("Quiting the browser");
		driver.quit();
	}

	// Test Case - 2 - Under Basic Element fill ALERT DEMO section
	void testCase_2() throws InterruptedException {

		System.out.println("Opening the browser");
		openBrowser();

		Thread.sleep(2000);

		System.out.println("Clicking on Basic Element tab");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		System.out.println("Declaring the First name");
		String name = "Phenol";

		System.out.println("Declaring the last name");
		String lastName = "Verma";

		System.out.println("Declaring the company name");
		String companyName = "TechnoCredits";

		System.out.println("Concatinating the string to compare");
		String checkString = name + " and " + lastName + " and " + companyName;

		System.out.println("Passing First Name");
		driver.findElement(By.xpath("//input[@id=\"UserFirstName\"]")).sendKeys(name);

		System.out.println("Passing Last Name");
		driver.findElement(By.xpath("//input[@id=\"UserLastName\"]")).sendKeys(lastName);

		System.out.println("Passing First Name");
		driver.findElement(By.xpath("//input[@id=\"UserCompanyName\"]")).sendKeys(companyName);

		System.out.println("Clicking on Sumbit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("Catching the alert popup");
		Alert alert = driver.switchTo().alert();

		System.out.println("Capturing the text message from alert popup");
		String alertText = alert.getText();

		System.out.println("Comparing the string");
		if (alertText.equals(checkString)) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}

		System.out.println("Closing the alert message");
		alert.accept();

		System.out.println("Quiting the browser");
		driver.quit();
	}

	// Test Case - 3 - Under Basic Element fill BASIC FORMS section

	void testCase_3() throws InterruptedException {

		System.out.println("Opening the browser");
		openBrowser();
		
		Thread.sleep(2000);

		System.out.println("Clicking on Basic Element tab");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		System.out.println("Passing email");
		driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).sendKeys("phenol.verma@gmail.com");

		System.out.println("Passing password");
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("phenol");

		System.out.println("Selecting the checkbox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();

		System.out.println("Clciking on Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("Catching the alert popup");
		Alert alert = driver.switchTo().alert();

		System.out.println("Capturing the text message from alert popup");
		String alertText = alert.getText();

		System.out.println("Comparing the string");
		if (alertText.equals("You successfully clicked on it")) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}

		System.out.println("Closing the alert message");
		alert.accept();

		System.out.println("Quiting the browser");
		driver.quit();
	}

	//
	void testCase_4() throws InterruptedException {

		System.out.println("Opening the browser");
		openBrowser();
		
		Thread.sleep(2000);


		System.out.println("Clicking on Basic Element tab");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		// System.out.println(driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")).isDisplayed());
		// System.out.println(driver.findElement(By.xpath("//input[@class='form-control']")).isDisplayed());

		//Finding the element if not visible in view port
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",
		driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")));

		System.out.println("Clicking on Alert link");
		driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")).click();

		System.out.println("Catching the alert popup");
		Alert alert = driver.switchTo().alert();

		System.out.println("Capturing the text message from alert popup");
		String alertText = alert.getText();

		System.out.println("Comparing the string");
		if (alertText.equals("You must be TechnoCredits student!!")) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}

		System.out.println("Closing the alert message");
		alert.accept();

		System.out.println("Quiting the browser");
		driver.quit();
	}

	// Negative test case
	void alertNotHandeled() throws InterruptedException {

		openBrowser();
		testCase_1();

		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).clear();
		System.out.println("Clearing the username");

		driver.quit();
	}

	// Negative test case
	void alertHandeled() throws InterruptedException {
		openBrowser();

		testCase_1();

		// Catching Alert message window
		Alert alert = driver.switchTo().alert();
		System.out.println("Got the Alret window");

		// Getting the alert message
		String alertText = alert.getText();
		if (alertText.equals("Success!")) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}

		// Accepting the alert message
		alert.accept();
		System.out.println("Alret message window closed");

		alert = driver.switchTo().alert();

		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).clear();
		System.out.println("Clearing the username");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {

		AutomateKrishna automateKrishna = new AutomateKrishna();
		// automateKrishna.alertHandeled();
		// automateKrishna.alertDemo();
		System.out.println("**************** Test Case - 1 ****************");
		automateKrishna.testCase_1();

		System.out.println("**************** Test Case - 2 ****************");
		automateKrishna.testCase_2();

		System.out.println("**************** Test Case - 3 ****************");
		automateKrishna.testCase_3();

		System.out.println("**************** Test Case - 4 ****************");
		automateKrishna.testCase_4();
		
		System.out.println("All test passed");
	}
}
