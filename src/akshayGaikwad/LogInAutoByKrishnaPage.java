package akshayGaikwad;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInAutoByKrishnaPage {
	WebDriver driver = new ChromeDriver();
	
	void successAccountCreation() throws Exception {
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.id("registration2")).click();
		System.out.println("STEP : Clicked on registration tab");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Akshay");
		System.out.println("STEP : Username entered");
		
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Akshay123456");
		System.out.println("STEP : Password entered");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP : Clicked Submit");

		Alert alert = driver.switchTo().alert();
		String expectedText = "Success!";
		String msg = alert.getText();

		if (msg.equals(expectedText)) {
			System.out.println("VERIFY : Account created Successfully!!!");
		} else {
			System.out.println("VERIFY : Account is not created");
		}

		alert.accept();
		System.out.println("STEP : Alert accepted");

		Thread.sleep(2000);
	}

	void exceptionAccountCreation() throws Exception {

		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.id("registration2")).click();
		System.out.println("STEP : Clicked on registration tab");

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Akshay");
		System.out.println("STEP : Username entered");

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("3456");
		System.out.println("STEP : Password entered");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP : Clicked Submit");


		Alert alert = driver.switchTo().alert();
		String expectedText = "Success!";
		String msg = alert.getText();

		if (msg.equals(expectedText)) {
			System.out.println("VERIFY : Account created Successfully!!!");
		} else {
			System.out.println("VERIFY : Account is not created");
		}

		alert.accept();
		System.out.println("STEP : Alert accepted");
		
		Thread.sleep(2000);
	}

	void basicElements() throws Exception {
		
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP : Clicked on Basic elements tab");

		Thread.sleep(2000);

		String firstName = "Akshay";
		String lastName = "Gaikwad";
		String companyName = "Dassault Systems";

		String expectedStr = firstName + " and " + lastName + " and " + companyName;
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		System.out.println("STEP : First name entered");

		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		System.out.println("STEP : Last name entered");

		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		System.out.println("STEP : Company name entered");

		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("STEP : Clicked Submit");

		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		if (expectedStr.equals(alertMsg)) {
			System.out.println("VERIFY : Account created Successfully!!!");
		} else {
			System.out.println("VERIFY : Wrong message");
		}

		alert.accept();
		System.out.println("STEP : Alert accepted");

		Thread.sleep(3000);

		driver.findElement(By.name("emailId")).sendKeys("username@gmail");
		System.out.println("STEP : Username entered");

		driver.findElement(By.id("pwd")).sendKeys("ABCD9876");
		System.out.println("STEP : Password entered");

		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("STEP : Checkbox checked");

		driver.findElement(By.id("submitb2")).click();
		System.out.println("STEP : Clicked submit");


		Alert alertForm = driver.switchTo().alert();
		String expectedMsgForm = "You successfully clicked on it";

		String formMsg = alertForm.getText();
		if (formMsg.equals(expectedMsgForm)) {
			System.out.println("VERIFY : Account created Successfully!!!");
		} else {
			System.out.println("VERIFY : Wrong message");
		}
		alert.accept();
		System.out.println("STEP : Alert accepted");

		Thread.sleep(2000);
	}

	void validteAlert() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP : Clicked on basic elements tab");
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP : Clicked on Alert");

		String expectedText = "You must be TechnoCredits student!!";

		Alert alert = driver.switchTo().alert();

		String msg = alert.getText();
		if (msg.equals(expectedText)) {
			System.out.println("VERIFY : Correct message");
		} else {
			System.out.println("VERIFY : Wrong message");
		}
		alert.accept();
		System.out.println("STEP : Alert accepted");
	}
	
	void closeBrowser() {
		driver.quit();
		System.out.println("STEP : Browser closed");
	}

	public static void main(String[] args) throws Exception {
		LogInAutoByKrishnaPage obj = new LogInAutoByKrishnaPage();
		obj.successAccountCreation();
		obj.exceptionAccountCreation();
		obj.basicElements();
		obj.validteAlert();
		obj.closeBrowser();
	}
}
