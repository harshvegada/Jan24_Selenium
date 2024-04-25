package atishaJadhav;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	WebDriver driver;

	void openBrowser() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
	}

	void testCase1() throws InterruptedException {
		openBrowser();
		// TestCase1 - Registration page alert message check for password more than 8
		// characters
		System.out.println("click on registration button and check for alert msg for mor than 8 characters");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);

		System.out.println("putting value in user name text box");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Atisha");

		System.out.println("Entering value in password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("atisha@1234");

		System.out.println("click on checkbox");
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();

		System.out.println("clicking on button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("getting alert msg");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expected = "Success!";
		if (actualText.equals(expected)) {
			System.out.println(" test case-1-pass");
		} else {
			System.out.println(" test case-1-fails");
		}
		alert.accept();
		driver.quit();
		System.out.println(
				"TestCase1 - Registration page alert message check for password more than 8 characters---is Done");

	}

	// Test case-2
	void testCase2() throws InterruptedException {
		openBrowser();
		System.out.println("click on registration  and check for alert msg for mor than 8 characters");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);

		System.out.println("putting value in user name text box");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Atisha");

		System.out.println("Entering value in password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("at_j");

		System.out.println("click on checkbox");
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();

		System.out.println("clicking on button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("getting alert msg");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expected = "Success!";
		if (actualText.equals(expected)) {
			System.out.println(" test case-2-pass");
		} else {
			System.out.println(" test case-2-fails");
		}
		alert.accept();
		driver.quit();

		System.out.println(
				"TestCase2 - Registration page alert message check for password less than 8 character----is Done");
	}

	// TestCase-3
	void testCase3() throws InterruptedException {
		openBrowser();

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on basic elements tab");
		Thread.sleep(2000);
		// Finding the elements of AlertDemo Section
		String firstName = "Atisha";
		String lastName = "Jadhav";
		String company = "Abc";

		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(company);

		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("getting Alert msg");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expected = firstName + " and " + lastName + " and " + company;
		if (actualText.equals(expected)) {
			System.out.println("Test case-3 - pass");

		} else {
			System.out.println("Test case-3 -failed");
		}
		alert.accept();
		driver.quit();

		System.out.println(" TestCase3-Basic elements Page - AlertDemo - alert message verification---is Done");
	}

	// TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
	void testCase4() throws InterruptedException {
		openBrowser();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on basic elements tab");
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']"));
		driver.findElement(By.xpath("//input[@id='pwd']"));
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String Expected = "You successfully clicked on it";
		if (actualText.equals(Expected)) {
			System.out.println("Test case 4- passed");

		} else {
			System.out.println("Test case 4- failed");
		}
		alert.accept();
		driver.quit();

	}

	// TestCase5 - Basic elements Page - Alert button - alert message verification
	void testCase5() throws InterruptedException {
		openBrowser();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on basic elements tab");
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)", "");

		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String Expected = "You must be TechnoCredits student!!";
		if (actualText.equals(Expected)) {
			System.out.println("Test case 5- passed");

		} else {
			System.out.println("Test case 5- failed");
		}
		alert.accept();
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Assignment1 assignment = new Assignment1();
		assignment.testCase1();
		System.out.println("_______________________________________");
		assignment.testCase2();
		System.out.println("_______________________________________");
		assignment.testCase3();
		System.out.println("_______________________________________");
		assignment.testCase4();
		System.out.println("_______________________________________");
		assignment.testCase5();
	}
}
