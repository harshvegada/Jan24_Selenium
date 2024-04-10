/*Assignment - 4 : 5th April'2024

Test and Automate Registration Form http://automationbykrishna.com

TestCase1 - Verify alert message when all the value provided for above fields
TestCase2 - Verify alert message for name when name value not provided
TestCase3 - Verify alert message for address when address value not provided but value provided for other fields
TestCase4 - Verify alert message for email when email not provided but value provided for above fields
TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields
TestCase6 - Verify alert message for city when city value not provided but value provided for above fields
TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields
TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
TestCase9 - Verify alert message for username less than 5 characters but value provided for above fields
TestCase10 - Verify alert message for password when password value not provided but value provided for above fields
TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
TestCase14 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields*/

package madhuraKulkarni;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	WebElement fullNameElement;
	WebElement addressElement;
	WebElement emailIdElement;
	WebElement cityElement;
	WebElement companyElement;
	WebElement registrationBtn;
	WebElement userNameElement;
	WebElement passwordElement;
	WebElement reEnterPasswordElement;
	WebElement agreementElement;
	WebElement genderElement;

	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP: Launch the browser and hit URL.");
		driver.get("http://automationbykrishna.com");
		System.out.println("STEP - click on the registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("STEP: Finding out all the elements of registration page.");
		fullNameElement = driver.findElement(By.xpath("//input[@id='fullName']"));
		addressElement = driver.findElement(By.xpath("//input[@id='address']"));
		emailIdElement = driver.findElement(By.xpath("//input[@id='useremail']"));
		cityElement = driver.findElement(By.xpath("//input[@id='usercity']"));
		companyElement = driver.findElement(By.xpath("//input[@id='organization']"));
		userNameElement = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		passwordElement = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		reEnterPasswordElement = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		registrationBtn = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		genderElement = driver.findElement(By.xpath("//label[@for='radio-02']"));
		agreementElement = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
	}

	void scrollElement(WebElement e) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	void verifyAlertText(String expectedAlertMessage, int testCaseId) {
		System.out.println("STEP: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP: Capture the text displayed on Alert window.");
		String actualAlertMessage = alert.getText();
		alert.accept();
		System.out.println("STEP: Verify the alert message.");
		if (actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("Test case " + testCaseId + " is passed.");
		} else {
			System.out.println("Test case " + testCaseId + " is failed.");
		}
	}

	// TestCase1 - Verify alert message when all the value provided for above fields
	void verifyTestCase1() {
		launchBrowser();
		System.out.println("STEP: Enter full name:");
		fullNameElement.sendKeys("Madhura Kulkarni");
		System.out.println("STEP: Enter address:");
		addressElement.sendKeys("Jule Solapur");
		System.out.println("STEP: Enter email address:");
		emailIdElement.sendKeys("madhura.kulkarni009@gmail.com");
		System.out.println("STEP: Enter city name:");
		cityElement.sendKeys("Soalpur");
		System.out.println("STEP: Enter company name:");
		companyElement.sendKeys("Techno");
		System.out.println("STEP: Select gender:");
		scrollElement(genderElement);
		genderElement.click();
		System.out.println("STEP: Enter User name:");
		userNameElement.sendKeys("mkulkarni");
		System.out.println("STEP: Enter Password:");
		passwordElement.sendKeys("Madhura@1234");
		System.out.println("STEP: Re-Enter Password:");
		reEnterPasswordElement.sendKeys("Madhura@1234");
		System.out.println("STEP: Select the checkbox of agrrement.");
		agreementElement.click();
		System.out.println("STEP: CLick on registration button.");
		registrationBtn.click();
		verifyAlertText("Success", 1);
	}

	// Testcase2 - Verify alert message for name when name value not provided
	void verifyTestCase2() {
		System.out.println("STEP: Verify alert message for name when name is not provided");
		String fullName = fullNameElement.getAttribute("value");
		fullNameElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Full name can't be blank", 2);
		fullNameElement.sendKeys(fullName);
	}

	// TestCase3 - Verify alert message for address when address is not provided but
	// value provided for other fields
	void verifyTestCase3() {
		System.out.println(
				"STEP: Verify alert message for address when address is not provided but value provided for other fields");
		String address = addressElement.getAttribute("value");
		addressElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("address cannot be blank", 3);
		addressElement.sendKeys(address);
	}

	// TestCase4 - Verify alert message for email when email id is not provided but
	// value provided for other fields
	void verifyTestCase4() {
		System.out.println(
				"STEP: Verify alert message for email when email id is not provided but value provided for other fields");
		String email = emailIdElement.getAttribute("value");
		emailIdElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Please enter email id", 4);
		emailIdElement.sendKeys(email);
	}

	// TestCase5 - Verify alert message for correct email when wrong email provided
	// but value provided for above fields
	void verifyTestCase5() {
		System.out
				.println("STEP: Verify alert message for incorrect email provided but value provided for above fields");
		String email = emailIdElement.getAttribute("value");
		emailIdElement.clear();
		emailIdElement.sendKeys("test");
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Please use correct email format", 5);
		emailIdElement.sendKeys(email);
	}

	// TestCase6 - Verify alert message for city when city value is not provided but
	// value provided for other fields
	void verifyTestCase6() {
		System.out.println(
				"STEP: Verify alert message for city when city value is not provided but value provided for other fields");
		String city = cityElement.getAttribute("value");
		cityElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Please enter City", 6);
		cityElement.sendKeys(city);
	}

	// TestCase7 - Verify alert message for organization name when organization name
	// value not provided but value provided for above fields
	void verifyTestCase7() {
		System.out.println(
				"STEP: Verify alert message for organization name when organization name value not provided but value provided for above fields");
		String company = companyElement.getAttribute("value");
		companyElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Please enter your current organization", 7);
		companyElement.sendKeys(company);
	}

	// TestCase8 - Verify alert message for username when username value not
	// provided but value provided for above fields
	void verifyTestCase8() {
		System.out.println(
				"STEP: Verify alert message for username when username value not provided but value provided for above fields");
		String userName = userNameElement.getAttribute("value");
		userNameElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Username is mandatory field.", 8);
		userNameElement.sendKeys(userName);
	}

	// TestCase9 - Verify alert message for username less than 5 characters but
	// value provided for above fields
	void verifyTestCase9() {
		System.out.println(
				"STEP: Verify alert message for username less than 5 characters but value provided for above fields");
		String userName = userNameElement.getAttribute("value");
		userNameElement.clear();
		userNameElement.sendKeys("mgk");
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Username length should be greater then 5 characters.", 9);
		userNameElement.sendKeys(userName);
	}

	// TestCase10 - Verify alert message for password when password value not
	// provided but value provided for above fields
	void verifyTestCase10() {
		System.out.println(
				"STEP: Verify alert message for password when password value not provided but value provided for above fields");
		String password = passwordElement.getAttribute("value");
		passwordElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("password is mandatory field.", 10);
		passwordElement.sendKeys(password);
	}

	// TestCase11 - Verify alert message for password less then 5 characters but
	// value provided for above fields
	void verifyTestCase11() {
		System.out.println(
				"STEP: Verify alert message for password less then 5 characters but value provided for above fields");
		String password = passwordElement.getAttribute("value");
		passwordElement.clear();
		passwordElement.sendKeys("mgk");
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("password length should be greater then 5 characters.", 11);
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	// TestCase12 - Verify alert message for re-password when re-password value not
	// provided but value provided for above fields
	void verifyTestCase12() {
		System.out.println(
				"STEP: Verify alert message for re-password when re-password value not provided but value provided for above fields");
		String repassword = reEnterPasswordElement.getAttribute("value");
		reEnterPasswordElement.clear();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("please reenter password", 12);
		reEnterPasswordElement.clear();
		reEnterPasswordElement.sendKeys(repassword);
	}

	// TestCase13 - Verify alert message for re-password when password and
	// re-password are not matching but value provided for above fields
	void verifyTestCase13() {
		System.out.println(
				"STEP: Verify alert message for re-password when password and re-password are not matching but value provided for above fields");
		String repassword = reEnterPasswordElement.getAttribute("value");
		reEnterPasswordElement.clear();
		reEnterPasswordElement.sendKeys("mgk@54321");
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("retype password donot match.", 13);
		reEnterPasswordElement.clear();
		reEnterPasswordElement.sendKeys("Madhura@1234");
	}

	// TestCase14 - Verify alert message for Terms and condition checkbox is not
	// selected but value provided for above fields
	void verifyTestCase14() {
		System.out.println(	"STEP: Verify alert message for Terms and condition checkbox is not selected but value provided for above fields");
		agreementElement.click();
		scrollElement(registrationBtn);
		registrationBtn.click();
		verifyAlertText("Please agree to terms of service and privacy policy", 14);
		agreementElement.click();
		//registrationBtn.click();
		driver.quit();
	}

	void display() {
		System.out.println("-------------------Test Case 1 started-----------------");
		verifyTestCase1();
		System.out.println("-------------------Test Case 2 started-----------------");
		verifyTestCase2();
		System.out.println("-------------------Test Case 3 started-----------------");
		verifyTestCase3();
		System.out.println("-------------------Test Case 4 started-----------------");
		verifyTestCase4();
		System.out.println("-------------------Test Case 5 started-----------------");
		verifyTestCase5();
		System.out.println("-------------------Test Case 6 started-----------------");
		verifyTestCase6();
		System.out.println("-------------------Test Case 7 started-----------------");
		verifyTestCase7();
		System.out.println("-------------------Test Case 8 started-----------------");
		verifyTestCase8();
		System.out.println("-------------------Test Case 9 started-----------------");
		verifyTestCase9();
		System.out.println("-------------------Test Case 10 started-----------------");
		verifyTestCase10();
		System.out.println("-------------------Test Case 11 started-----------------");
		verifyTestCase11();
		System.out.println("-------------------Test Case 12 started-----------------");
		verifyTestCase12();
		System.out.println("-------------------Test Case 13 started-----------------");
		verifyTestCase13();
		System.out.println("-------------------Test Case 14 started-----------------");
		verifyTestCase14();
	}

	public static void main(String[] args) {
		Assignment4 assignment4 = new Assignment4();
		assignment4.display();
	}

}
