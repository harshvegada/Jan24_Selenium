/*Assignment - 1 
Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification*/
package shraddhaMore;

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
		System.out.println("Browser launched");
		return driver;
	}

	// TestCase1 - Registration page alert message check for password more than 8
	// characters
	void loginWithCorrectPassword() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shraddha");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Shraddha@123");
		System.out.println("Entered password greater than 8 characters");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Clicked on submit button");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		alert.accept();
		driver.quit();
	}

	// TestCase2 - Registration page alert message check for password less than 8
	// characters
	void loginWithIncorrectPassword() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("Clicked on Registration");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shraddha");
		System.out.println("Entered User Name...");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Shra");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Clicked on submit button");
		String expectedText = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		alert.accept();
		driver.quit();
	}
//TestCase3 - Basic elements Page - AlertDemo - alert message verification

	void alertMessageVerification() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		driver.findElement(By.id("UserFirstName")).sendKeys("Shraddha");
		System.out.println("Entered User First Name");
		driver.findElement(By.id("UserLastName")).sendKeys("More");
		System.out.println("Entered User Last Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Techno");
		System.out.println("Entered Company Name");
		driver.findElement(By.xpath("//div[@name='secondSegment']//button[@type='submit']")).click();
		System.out.println("Clicked on Submit button");
		String firstName = "Shraddha";
		String lastName = "More";
		String cmpName = "Amdocs";
		String expectedText = firstName + " and " + lastName + " and " + cmpName;
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		alert.accept();
		driver.quit();
	}

	// TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
	void validateAlertMessageOnBasicElements() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("abc.test@gmail.com");
		System.out.println("Entered User email address.");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("abc.test");
		System.out.println("Entered password...");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("Clicked on checkbox");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("Clicked on submit button");
		String expectedText = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test failed");
		alert.accept();
		driver.quit();
	}

//TestCase5 - Basic elements Page - Alert button - alert message verification*/
	void validateAlertButtonOnBasicElements() throws InterruptedException {
		WebDriver driver = launchDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic Elements");
		Thread.sleep(3000);
		WebElement alertElement = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		System.out.println("Switched to alert window ");
		String actualText = alert.getText();
		System.out.println("Captured alert window text");
		if (actualText.equals(expectedText))
			System.out.println("Test Pass");
		else
			System.out.println("Test fail");
		alert.accept();
		System.out.println("Closed alert pop up window");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment1 ass1 = new Assignment1();
		ass1.loginWithCorrectPassword();
		ass1.loginWithIncorrectPassword();
		ass1.alertMessageVerification();
		ass1.validateAlertMessageOnBasicElements();
		ass1.validateAlertButtonOnBasicElements();
	}

}