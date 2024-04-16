package nikitaPatil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Assignment - 1
//Prerequisite - Open browser & hit http://automationbykrishna.com
//TestCase1 - Registration page alert message check for password more than 8 characters
//TestCase2 - Registration page alert message check for password less than 8 characters
//TestCase3 - Basic elements Page - AlertDemo - alert message verification
//TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
//TestCase5 - Basic elements Page - Alert button - alert message verification


public class Assignment1 {

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
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Nikita");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Nikita12345");

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
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Nikita");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Nikita12345");

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
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Nikita");

		System.out.println("STEP : Enter  userLastName");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Patil");

		System.out.println("STEP : Enter companyName");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Infosys");

		System.out.println("STEP : Click on submit");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		String expectedText = "Nikita and Patil and Infosys";

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
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("Nikita");

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Nikita12345");

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

	

	public static void main(String[] args) throws InterruptedException {
	    Assignment1 a= new Assignment1();
		a.testCase1();
		System.out.println();
		a.testCase2();
		System.out.println();
		a.testCase3();
		System.out.println();
		a.testCase4();
		System.out.println();
		a.testCase5();
		
	}
}