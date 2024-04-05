package varshaNagadwala;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationByKrishnaAutomateRegistration {

	WebDriver driver;
	WebElement fullName;
	WebElement address;
	WebElement emailId;
	WebElement cityName;
	WebElement companyName;
	WebElement userName;
	WebElement password;
	WebElement reEnterPassword;
	WebElement registrationButton;
	WebElement checkbox;

	void launchBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on registration link");
		driver.findElement(By.id("registration2")).click();

		fullName = driver.findElement(By.xpath("//input[@id='fullName']"));
		address = driver.findElement(By.xpath("//input[@id='address']"));
		emailId = driver.findElement(By.xpath("//input[@id='useremail']"));
		cityName = driver.findElement(By.xpath("//input[@id='usercity']"));
		companyName = driver.findElement(By.xpath("//input[@id='organization']"));
		userName = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		password = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		reEnterPassword = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		registrationButton = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		checkbox = driver.findElement(By.id("signupAgreement"));

	}

	void handleAlertAndVerifyMessage(String expectedText, String testCase) {

		System.out.println("STEP : Get the actual alert text");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println(alert.getText());
		alert.accept();

		System.out.println("VERIFY : Actualtext with Expectedtext");
		if (actualText.equals(expectedText)) {
			System.out.println(testCase + " -> Pass");
		} else {
			System.out.println(testCase + " -> Fail");
		}
	}

	void scrollToElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
	}

//	TestCase1 - Verify alert message when all the value provided for above fields
	void testCase1() {

		System.out.println("testCase1 Start");
		launchBrowser();

		System.out.println("STEP : Enter Full Name");
		fullName.sendKeys("Varsha");

		System.out.println("STEP : Enter Address");
		address.sendKeys("Wakad");

		System.out.println("STEP : Enter email Address");
		emailId.sendKeys("varsha@yahoo.com");

		System.out.println("STEP : Enter City Name");
		cityName.sendKeys("Pune");

		System.out.println("STEP : Enter Company Name");
		companyName.sendKeys("Technocredit");

		System.out.println("STEP : Select radio button");
		driver.findElement(By.id("radio-02")).click();

		System.out.println("STEP : Enter userName");
		userName.sendKeys("Varsha");

		System.out.println("STEP : Enter Password");
		password.sendKeys("0987654321");

		System.out.println("STEP : Re-Enter Password");
		reEnterPassword.sendKeys("0987654321");

		System.out.println("STEP : Call ScrollToElement Method");
		scrollToElement();

		System.out.println("STEP : Click on checkbox");
		checkbox.click();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		String expectedText = "Success";

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedText, "testCase1");
	}

//	TestCase2 - Verify alert message for name when name value not provided
	void testCase2() {

		System.out.println("testCase2 Start");

		String expectedAlertText = "Full name can't be blank";

		System.out.println("STEP : Take FullName value");
		String originalName = fullName.getAttribute("value");

		System.out.println("STEP : Clear fullName value");
		fullName.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase2");

		System.out.println("STEP : Enter Full Name");
		fullName.sendKeys(originalName);
	}

//	TestCase3 - Verify alert message for address when address value not provided but value provided for above fields
	void testCase3() {

		System.out.println("testCase3 Start");

		String expectedAlertText = "address cannot be blank";

		System.out.println("STEP : Take Address value");
		String originalAddress = address.getAttribute("value");

		System.out.println("STEP : Clear address value");
		address.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase3");

		System.out.println("STEP : Enter Address Name");
		address.sendKeys(originalAddress);
	}

//	TestCase4 - Verify alert message for email when email not provided but value provided for above fields
//	TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields
	void testCase4And5() {

		System.out.println("testCase4 Start");

		String expectedAlertText = "Please enter email id";

		System.out.println("STEP : Take EmailId value");
		String originalEmailId = emailId.getAttribute("value");

		System.out.println("STEP : Clear EmailId value");
		emailId.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase4");

		System.out.println();
		System.out.println("testCase5 Start");
		System.out.println("STEP : write wrong EmailId value");
		emailId.sendKeys("varsha");

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage("Please use correct email format", "testCase5");

		System.out.println("STEP : Clear EmailId value");
		emailId.clear();

		System.out.println("STEP : Enter EmailId Name");
		emailId.sendKeys(originalEmailId);
	}

//	TestCase6 - Verify alert message for city when city value not provided but value provided for above fields
	void testCase6() {

		System.out.println("testCase6 Start");

		String expectedAlertText = "Please enter City";

		System.out.println("STEP : Take City value");
		String originalCity = cityName.getAttribute("value");
		cityName.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase6");

		System.out.println("STEP : Enter City Name");
		cityName.sendKeys(originalCity);
	}

//	TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields
	void testCase7() {

		System.out.println("testCase7 Start");

		String expectedAlertText = "Please enter your current organization";

		System.out.println("STEP : Take Company name value");
		String originalCompanyName = companyName.getAttribute("value");
		companyName.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase7");

		System.out.println("STEP : Enter Company Name");
		companyName.sendKeys(originalCompanyName);
	}

//	TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
//	TestCase9 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields
	void testCase8And9() {

		System.out.println("testCase8 Start");

		String expectedAlertText = "Username is mandatory field.";

		System.out.println("STEP : Take UserName value");
		String originalUserName = userName.getAttribute("value");
		userName.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase8");

		System.out.println();
		System.out.println("testCase9 Start");
		System.out.println("STEP : write userName less than 5 characters value");
		userName.sendKeys("vars");

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage("Username length should be greater then 5 characters.", "testCase9");

		System.out.println("STEP : Clear Username value");
		userName.clear();

		System.out.println("STEP : Enter Username Name");
		userName.sendKeys(originalUserName);
	}

//	TestCase10 - Verify alert message for password when password value not provided but value provided for above fields
//	TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
	void testCase10And11() {

		System.out.println("testCase10 Start");

		String expectedAlertText = "password is mandatory field.";

		System.out.println("STEP : Take Password value");
		String originalPassword = password.getAttribute("value");
		password.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase10");

		System.out.println();
		System.out.println("testCase11 Start");
		System.out.println("STEP : write Password less than 5 characters value");
		password.sendKeys("1234");

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage("password length should be greater then 5 characters.", "testCase11");

		System.out.println("STEP : Clear password value");
		password.clear();

		System.out.println("STEP : Enter Password Name");
		password.sendKeys(originalPassword);
	}

//	TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
//	TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
	void testCase12And13() {

		System.out.println("testCase11 Start");

		String expectedAlertText = "please reenter password";

		System.out.println("STEP : Take Re-Password value");
		String originalRePassword = reEnterPassword.getAttribute("value");
		reEnterPassword.clear();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase11");

		System.out.println();
		System.out.println("testCase13 Start");
		System.out.println("STEP : write Re-Password other than password value");
		reEnterPassword.sendKeys("0987");

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage("retype password donot match.", "testCase13");

		System.out.println("STEP : Clear Re-password value");
		reEnterPassword.clear();

		System.out.println("STEP : Enter Re-Password Name");
		reEnterPassword.sendKeys(originalRePassword);
	}

//	TestCase14 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields
	void testCase14() {

		System.out.println("testCase14 Start");

		String expectedAlertText = "Please agree to terms of service and privacy policy";

		System.out.println("STEP : Call ScrollToElement Method");
		scrollToElement();

		System.out.println("STEP : Uncheck the checkBox");
		checkbox.click();

		System.out.println("STEP : Click on submit");
		registrationButton.click();

		System.out.println("STEP : Call Alert Method");
		handleAlertAndVerifyMessage(expectedAlertText, "testCase14");

		System.out.println("STEP : check the checkBox");
		checkbox.click();
	}

	void closeBrowser() {

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) {
		AutomationByKrishnaAutomateRegistration automationByKrishnaAutomateRegistration = new AutomationByKrishnaAutomateRegistration();
		automationByKrishnaAutomateRegistration.testCase1();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase2();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase3();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase4And5();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase6();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase7();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase8And9();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase10And11();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase12And13();
		System.out.println();
		automationByKrishnaAutomateRegistration.testCase14();
		automationByKrishnaAutomateRegistration.closeBrowser();
	}
}
