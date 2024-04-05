/*
/*
 * 
TestCase1 - Verify alert message when all the value provided for above fields
TestCase2 - Verify alert message for name when name value not provided
TestCase3 - Verify alert message for address when address value not provided but value provided for above fields
TestCase4 - Verify alert message for email when email not provided but value provided for above fields
TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields
TestCase6 - Verify alert message for city when city value not provided but value provided for above fields
TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields
TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
TestCase9 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields
TestCase10 - Verify alert message for password when password value not provided but value provided for above fields
TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
TestCase14 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields
*/

package phenolVerma;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormAutoMateKrishna {

	// Declaring the elements
	WebDriver driver;
	WebElement nameElement;
	WebElement addressElement;
	WebElement emailElement;
	WebElement cityElement;
	WebElement companyElememt;
	WebElement userNameElement;
	WebElement passwordElement;
	WebElement rePasswordElement;
	WebElement registrationButtonElement;
	WebElement checkboxElement;

	void openBrowser() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("Moving to Registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);

		// Initiating the elements
		nameElement = driver.findElement(By.xpath("//input[@id='fullName']"));
		addressElement = driver.findElement(By.xpath("//input[@id='address']"));
		emailElement = driver.findElement(By.xpath("//input[@id='useremail']"));
		cityElement = driver.findElement(By.xpath("//input[@id='usercity']"));
		companyElememt = driver.findElement(By.xpath("//input[@id='organization']"));
		userNameElement = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		passwordElement = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		rePasswordElement = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		registrationButtonElement = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		checkboxElement = driver.findElement(By.xpath("//input[@id=\'signupAgreement\']"));
	}

	void scrollElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	void alrethandle(String alertMessageDefault, String testCase) {
		Alert alert = driver.switchTo().alert();
		String alretMessage = alert.getText();
		System.out.println(alretMessage);

		if (alertMessageDefault.equals(alretMessage)) {
			System.out.println(testCase + " passed");
		} else {
			System.out.println(testCase + " not passed");
		}
		alert.accept();
	}

	// TestCase1 - Verify alert message when all the value provided for above fields
	void testCase1() throws InterruptedException {
		openBrowser();

		nameElement.sendKeys("Phenol Verma");
		addressElement.sendKeys("Green Republic");
		emailElement.sendKeys("phenol.verma@gmail.com");
		cityElement.sendKeys("Pune");
		companyElememt.sendKeys("Citi Bank");
		userNameElement.sendKeys("phenolverma");
		passwordElement.sendKeys("phenol");
		rePasswordElement.sendKeys("phenol");
		scrollElement(registrationButtonElement);
		checkboxElement.click();
		registrationButtonElement.click();

		String alertMessageDefault = "Success";
		String testCase = "TestCase1";

		alrethandle(alertMessageDefault, testCase);
	}

	// TestCase2 - Verify alert message for name when name value not provided
	void testCase2() {

		System.out.println("Captring the Name value");
		String capturElementeValue = nameElement.getAttribute("value");
		System.out.println("Clearing the Name value");
		nameElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Full name can't be blank";
		String testCase = "TestCase2";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the name value again");
		nameElement.sendKeys(capturElementeValue);
	}

	// TestCase3 - Verify alert message for address when address value not provided
	// but value provided for above fields
	void testCase3() {

		System.out.println("Captring the address value");
		String capturElementeValue = addressElement.getAttribute("value");
		System.out.println("Clearing the address value");
		addressElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "address cannot be blank";
		String testCase = "TestCase3";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the address value again");
		addressElement.sendKeys(capturElementeValue);
	}

	// TestCase4 - Verify alert message for email when email not provided but value
	// provided for above fields
	void testCase4() {

		System.out.println("Captring the email value");
		String capturElementeValue = emailElement.getAttribute("value");
		System.out.println("Clearing the email value");
		emailElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Please enter email id";
		String testCase = "TestCase4";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the email value again");
		emailElement.sendKeys(capturElementeValue);
	}

	// TestCase5 - Verify alert message for correct email when wrong email provided
	// but value provided for above fields
	void testCase5() {

		System.out.println("Captring the email value");
		String capturElementeValue = emailElement.getAttribute("value");
		System.out.println("Clearing the email value");
		emailElement.clear();

		emailElement.sendKeys("phenol.com");

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Please use correct email format";
		String testCase = "TestCase5";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		emailElement.clear();

		System.out.println("Restoring the email value again");
		emailElement.sendKeys(capturElementeValue);
	}

	// TestCase6 - Verify alert message for city when city value not provided but
	// value provided for above fields
	void testCase6() {

		System.out.println("Captring the city value");
		String capturElementeValue = cityElement.getAttribute("value");
		System.out.println("Clearing the city value");
		cityElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Please enter City";
		String testCase = "TestCase6";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the city value again");
		cityElement.sendKeys(capturElementeValue);
	}

	// TestCase7 - Verify alert message for organization name when organization name
	// value not provided but value provided for above fields
	void testCase7() {

		System.out.println("Captring the organization value");
		String capturElementeValue = companyElememt.getAttribute("value");
		System.out.println("Clearing the organization value");
		companyElememt.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Please enter your current organization";
		String testCase = "TestCase7";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the organization value again");
		companyElememt.sendKeys(capturElementeValue);
	}

	// TestCase8 - Verify alert message for username when username value not
	// provided but value provided for above fields
	void testCase8() {

		System.out.println("Captring the username value");
		String capturElementeValue = userNameElement.getAttribute("value");
		System.out.println("Clearing the username value");
		userNameElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Username is mandatory field";
		String testCase = "TestCase8";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the username value again");
		userNameElement.sendKeys(capturElementeValue);
	}

	// TestCase9 - Verify alert message for username less then 5 charater when
	// username lenght is less then 5 but value provided for above fields
	void testCase9() {

		System.out.println("Captring the username value");
		String capturElementeValue = userNameElement.getAttribute("value");
		System.out.println("Clearing the username value");
		userNameElement.clear();

		userNameElement.sendKeys("phe");

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Username length should be greater then 5 characters.";
		String testCase = "TestCase9";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		userNameElement.clear();

		System.out.println("Restoring the username value again");
		userNameElement.sendKeys(capturElementeValue);
	}

	// TestCase10 - Verify alert message for password when password value not
	// provided but value provided for above fields
	void testCase10() {

		System.out.println("Captring the password value");
		String capturElementeValue = passwordElement.getAttribute("value");
		System.out.println("Clearing the password value");
		passwordElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "password is mandatory field.";
		String testCase = "TestCase10";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the password value again");
		passwordElement.sendKeys(capturElementeValue);
	}

	// TestCase11 - Verify alert message for password less then 5 character when
	// password length is less then 5 but value provided for above fields
	void testCase11() {

		System.out.println("Captring the password value");
		String capturElementeValue = passwordElement.getAttribute("value");
		System.out.println("Clearing the password value");
		passwordElement.clear();

		passwordElement.sendKeys("phe");

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "password length should be greater then 5 characters.";
		String testCase = "TestCase11";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		passwordElement.clear();

		System.out.println("Restoring the password value again");
		passwordElement.sendKeys(capturElementeValue);
	}

	// TestCase12 - Verify alert message for re-password when re-password value not
	// provided but value provided for above fields
	void testCase12() {

		System.out.println("Captring the re-password value");
		String capturElementeValue = rePasswordElement.getAttribute("value");
		System.out.println("Clearing the password value");
		rePasswordElement.clear();

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "please reenter password";
		String testCase = "TestCase12";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Restoring the re-password value again");
		rePasswordElement.sendKeys(capturElementeValue);
	}

	// TestCase13 - Verify alert message for re-password when password and
	// re-password are not matching but value provided for above fields
	void testCase13() {

		System.out.println("Captring the re-password value");
		String capturElementeValue = rePasswordElement.getAttribute("value");
		System.out.println("Clearing the password value");
		rePasswordElement.clear();

		rePasswordElement.sendKeys("phen");

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "retype password donot match.";
		String testCase = "TestCase13";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		rePasswordElement.clear();

		System.out.println("Restoring the re-password value again");
		rePasswordElement.sendKeys(capturElementeValue);
	}

	// TestCase14 - Verify alert message for Team and condition when Team and
	// condition checkbox is not selected but value provided for above fields
	void testCase14() {

		// Scrolling till Registration button
		scrollElement(registrationButtonElement);

		System.out.println("Unselecting the checkbox");
		checkboxElement.click();

		System.out.println("Clicking on Registration button");
		registrationButtonElement.click();

		// Declaring the defaults message and testcase number
		String alertMessageDefault = "Please agree to terms of service and privacy policy";
		String testCase = "TestCase14";

		System.out.println("Handling the alert popup");
		alrethandle(alertMessageDefault, testCase);

		System.out.println("Selecting again the checkbox");
		checkboxElement.click();
	}

	public static void main(String[] args) throws InterruptedException {
		RegistrationFormAutoMateKrishna RegistrationFormAutoMateKrishna = new RegistrationFormAutoMateKrishna();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase1();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase2();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase3();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase4();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase5();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase6();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase7();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase8();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase9();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase10();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase11();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase12();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase13();
		System.out.println("******************************************");
		RegistrationFormAutoMateKrishna.testCase14();
		System.out.println("******************************************");
	}
}
