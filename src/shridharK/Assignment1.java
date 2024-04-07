package shridharK;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	WebDriver driver;

	void openBrowser() {
		System.out.println("Step - Launching of browser and opening http://automationbykrishna.com/");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}

	// TestCase1 - Registration page alert message check for password more than 8
	// characters
	void checkingStrongPasswordStrength() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id = 'registration2']")).click();
		System.out.println("Step : clicked on registration tab");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shridhar");
		System.out.println("Step : Enter UserName");

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Shri12345");
		System.out.println("Step : Enter password");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step - Click on tick to sumbit");

		Alert alert = driver.switchTo().alert();
		String expected = "Success!";
		String actual = alert.getText();
		if (expected.equals(actual)) {
			System.out.println("Verify : Account created SuccessFully - Testcase 1 passed");
		} else {
			System.out.println("Account is not created - TestCase1 Failed");
		}
		alert.accept();
		System.out.println("Step : Alert accepted");

		Thread.sleep(2000);
	}

	// TestCase 2 - Registration page alert message check for password less than 8
	// characters
	void checkingWeakPassword() throws InterruptedException {
		System.out.println("Refresh the browser");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step - click on registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		Thread.sleep(2000);

		System.out.println("Step - Send keys in username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shridhar");

		System.out.println("Step - Send keys in password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123");

		System.out.println("Step - Click on sumbit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Alert alert = driver.switchTo().alert();
		String expected = "Failed! please enter strong password";
		String actual = alert.getText();
		if (expected.equals(actual)) {
			System.out.println("Verified : password is less than 8 char - testcase 2 pass");
		} else {
			System.out.println("Weak password, test case 2 fail");
		}
		alert.accept();
		System.out.println("Step : Alert accepted");

		Thread.sleep(2000);
	}

	// TestCase3 - Basic elements Page - AlertDemo - alert message verification
	void alertDemoTest() throws InterruptedException {
		System.out.println("Step : Refreshing the page");
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		System.out.println("Step : click on basic element");

		Thread.sleep(2000);

		String firstName = "Shridhar";
		String lastName = "Kumbhar";
		String company = "Dassault";
		driver.findElement(By.xpath("//input[@id = 'UserFirstName']")).sendKeys(firstName);
		System.out.println("Step : First Name entered");

		driver.findElement(By.xpath("//input[@id = 'UserLastName']")).sendKeys(lastName);
		System.out.println("Step : Last name entered");

		driver.findElement(By.xpath("//input[@id = 'UserCompanyName']")).sendKeys(company);
		System.out.println("Step : Company name entered");

		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("Step : click on sumbit");

		Alert alert = driver.switchTo().alert();
		String expected = firstName + " and " + lastName + " and " + company;
		String actual = alert.getText();
		if (expected.equals(actual)) {
			System.out.println("Alert Demo , test case - 3 is passed");
		} else {
			System.out.println("Alert Demo , test case - 3 is failed");
		}

		alert.accept();
		System.out.println("Step - accept the alert");

		Thread.sleep(2000);
	}

	// TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
	void basicFormAlertMessageTest() throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		System.out.println("Step - Select basic elememt tab");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id = 'exampleInputEmail1']")).sendKeys("shri0101@gmail.com");
		System.out.println("Step - Entere mail");

		driver.findElement(By.xpath("//input[@id = 'pwd']")).sendKeys("12345678");
		System.out.println("Step - Enter password");

		driver.findElement(By.xpath("//div[@class = 'col-lg-6']//input[@type = 'checkbox']")).click();
		System.out.println("Select checkbox");

		driver.findElement(By.xpath("//button[@id = 'submitb2']")).click();
		System.out.println("Step - click on submit");

		Alert alert = driver.switchTo().alert();
		String expected = "You successfully clicked on it";
		String actual = alert.getText();
		if (expected.equals(actual)) {
			System.out.println("BASIC FORMS - alert message verify : Test case 4 pass");
		} else {
			System.out.println("BASIC FORMS - alert message verification failed : Test case 4 failed");
		}

		alert.accept();
		System.out.println("Step - Accept the alert");
	}

	// TestCase5 - Basic elements Page - Alert button - alert message verification
	void basicElementAlertButton() {
		System.out.println("Refresh the browser");
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		System.out.println("Step - select basicelement tab");

		driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();
		System.out.println("Step - click on alert button");

		String expected = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		if (expected.equals(actual)) {
			System.out.println("Basic elements Page - Alert button verified - Test case 5 pass");
		} else {
			System.out.println("Basic elements Page - Alert button verified failed- Test case 5 failed");
		}

		alert.accept();
		System.out.println("Step - Alert accepted");
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment1 as = new Assignment1();
		as.openBrowser();
		System.out.println("--------------");
		as.checkingStrongPasswordStrength();
		System.out.println("--------------");
		as.checkingWeakPassword();
		System.out.println("--------------");
		as.alertDemoTest();
		System.out.println("--------------");
		as.basicFormAlertMessageTest();
		System.out.println("--------------");
		as.basicElementAlertButton();
	}
}
