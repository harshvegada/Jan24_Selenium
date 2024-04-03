/*Assignment - 1 : 31st March'2024 
Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification*/
package madhuraKulkarni;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	WebDriver launchDriver() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser launched...");
		return driver;
	}

	// TestCase1 - Registration page alert message check for password more than 8
	// characters
	void verifyLoginWithCorrectPasswordOnRegistration() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("Clicked on Registration...");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Madhura");
		System.out.println("Entered User Name...");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Madhura@123");
		System.out.println("Entered password greater than 8 characters...");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Clicked on submit button...");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("Cleared User Name...");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		System.out.println("Cleared password...");
		driver.quit();
	}

	// TestCase2 - Registration page alert message check for password less than 8
	// characters
	void verifyLoginWithIncorrectPasswordOnRegistration() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("Clicked on Registration...");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Madhura");
		System.out.println("Entered User Name...");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("12345");
		System.out.println("Entered password less than 8 characters...");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Clicked on submit button...");
		String expectedText = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("Cleared User Name...");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		System.out.println("Cleared password...");
		driver.quit();
	}
//TestCase3 - Basic elements Page - AlertDemo - alert message verification

	void verifyAlertMessageForAlertDemoOnBasicElements() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		driver.findElement(By.id("UserFirstName")).sendKeys("Madhura");
		System.out.println("Entered User First Name");
		driver.findElement(By.id("UserLastName")).sendKeys("Kulkarni");
		System.out.println("Entered User Last Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Techno");
		System.out.println("Entered Company Name");
		driver.findElement(By.xpath("//div[@name='secondSegment']//button[@type='submit']")).click();
		System.out.println("Clicked on Submit button");
		String firstName = "Madhura";
		String lastName = "Kulkarni";
		String cmpName = "Techno";
		String expectedText = firstName + " and " + lastName + " and " + cmpName;
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		alert.accept();
		driver.findElement(By.id("UserFirstName")).clear();
		System.out.println("Cleared User Name...");
		driver.findElement(By.id("UserLastName")).clear();
		System.out.println("Cleared password...");
		driver.findElement(By.id("UserCompanyName")).clear();
		System.out.println("Cleared company name");
		driver.quit();

	}

	// TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
	void verifyAlertMessageForBasicFormsOnBasicElements() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic Elements...");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("madhura.test@gmail.com");
		System.out.println("Entered User email address...");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("madhura.test");
		System.out.println("Entered password...");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("Clicked on checkbox...");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("Clicked on submit button...");
		String expectedText = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();
		System.out.println("Cleared User email address...");
		driver.findElement(By.xpath("//input[@id='pwd']")).clear();
		System.out.println("Cleared password...");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("Cleared checkbox selection...");
		driver.quit();

	}

//TestCase5 - Basic elements Page - Alert button - alert message verification*/
	void verifyAlertMessageForAlertButtonOnBasicElements() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic Elements...");
		Thread.sleep(3000);
		WebElement alertElement = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		System.out.println("Switched to alert window ...");
		String actualText = alert.getText();
		System.out.println("Captured alert window text...");
		if (actualText.equals(expectedText))
			System.out.println("Test Passed");
		else
			System.out.println("Test failed");
		alert.accept();
		System.out.println("Closed alert pop up window...");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment1 ass1 = new Assignment1();
		System.out.println(
				"-----TestCase1 - Registration page alert message check for password more than 8 characters-----");
		ass1.verifyLoginWithCorrectPasswordOnRegistration();
		System.out.println(
				"------TestCase2 - Registration page alert message check for password less than 8 characters------");
		ass1.verifyLoginWithIncorrectPasswordOnRegistration();
		System.out.println("------TestCase3 - Basic elements Page - AlertDemo - alert message verification--------");
		ass1.verifyAlertMessageForAlertDemoOnBasicElements();
		System.out.println("-----TestCase4 - Basic elements Page - BASIC FORMS - alert message verification-------");
		ass1.verifyAlertMessageForBasicFormsOnBasicElements();
		System.out.println("TestCase5 - Basic elements Page - Alert button - alert message verification");
		ass1.verifyAlertMessageForAlertButtonOnBasicElements();
	}

}