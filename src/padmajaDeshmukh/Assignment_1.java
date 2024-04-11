/*Assignment - 1 : 31st March'2024 

Prerequisite - Open browser & hit http://automationbykrishna.com

TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification
 */

package padmajaDeshmukh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	WebDriver driver;

	void launchBrowser() {
		System.out.println("STEP : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

//TestCase1 - Registration page alert message check for password more than 8 characters

	void testCase1() throws InterruptedException {
		System.out.println("TestCase1 start");
		launchBrowser();

		System.out.println("STEP : Hit URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Registartion link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(3000);

		System.out.println("STEP : Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Padmaja");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123456789");

		System.out.println("STEP : Click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		String expectedText = "Success!";
		System.out.println("STEP : Get Actual alert Text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("STEP : Verify if Actual and Expected Texts are same");
		if (actualText.equals(expectedText))
			System.out.println("TestCase1 -> Pass");
		else
			System.out.println("TestCase1 -> Fail");

		System.out.println("STEP : Accept Alert");
		alert.accept();

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//TestCase2 - Registration page alert message check for password less than 8 characters

	void testCase2() throws InterruptedException {
		System.out.println("TestCase2 start");
		launchBrowser();

		System.out.println("STEP : Hit URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Registartion link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(3000);

		System.out.println("STEP : Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Padmaja");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("1234567");

		System.out.println("STEP : Click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		String expectedText = "Failed! please enter strong password";
		System.out.println("STEP : Get Actual alert Text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("STEP : Verify if Actual and Expected Texts are same");
		if (actualText.equals(expectedText))
			System.out.println("TestCase2 -> Pass");
		else
			System.out.println("TestCase2 -> Fail");

		System.out.println("STEP : Accept Alert");
		alert.accept();

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//TestCase3 - Basic elements Page - AlertDemo - alert message verification

	void testCase3() throws InterruptedException {
		System.out.println("TestCase3 start");
		launchBrowser();

		System.out.println("STEP : Hit URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click On Basic Element link");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("STEP : Enter FirstName");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Padmaja");

		System.out.println("STEP : Enter LastName");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Deshmukh");

		System.out.println("STEP : Enter CompanyName");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("LTIMindtree");

		System.out.println("STEP : Click on Submit Button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String expectedText = "Padmaja and Deshmukh and LTIMindtree";
		System.out.println("STEP : Get Actual text from Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("STEP : Verify if Actual and Expected texts are same");
		if (actualText.equals(expectedText))
			System.out.println("TestCase3 -> Pass");
		else
			System.out.println("TestCase3 -> Fail");

		System.out.println("STEP : Accept Alert");
		alert.accept();

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//TestCase4 - Basic elements Page - BASIC FORMS - alert message verification

	void testCase4() throws InterruptedException {
		System.out.println("TestCase4 start");
		launchBrowser();

		System.out.println("STEP : Hit URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click On Basic Element link");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("STEP : Enter Email address");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("padmajadeshmukh1@gmai.com");

		System.out.println("STEP : Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Padmajad");

		System.out.println("STEP : Select the checkbox");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		System.out.println("STEP : Click on Submit Button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		String expectedText = "You successfully clicked on it";

		System.out.println("STEP : Get Actual Text from alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("STEP : Verify if the Actual and Expected text is same");
		if (actualText.equals(expectedText))
			System.out.println("TestCase4 -> Pass");
		else
			System.out.println("TestCase4 -> Fail");

		System.out.println("STEP : Accespt Alert");
		alert.accept();

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//TestCase5 - Basic elements Page - Alert button - alert message verification

	void testCase5() throws InterruptedException {
		System.out.println("TestCase5 start");
		launchBrowser();

		System.out.println("STEP : Hit URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click On Basic Element link");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("Step : Scroll down");
		WebElement alertElement = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);

		System.out.println("STEP : Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		String expectedText = "You must be TechnoCredits student!!";

		System.out.println("STEP : Get Actual Text from Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("STEP : Verify the Alert message");
		if (actualText.equals(expectedText))
			System.out.println("TestCase5 -> Pass");
		else
			System.out.println("TestCase5 -> Fail");

		System.out.println("STEP : Accept the Alert");
		alert.accept();

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment_1 assignment = new Assignment_1();
		assignment.testCase1();
		System.out.println();
		assignment.testCase2();
		System.out.println();
		assignment.testCase3();
		System.out.println();
		assignment.testCase4();
		System.out.println();
		assignment.testCase5();
		System.out.println();
	}
}
