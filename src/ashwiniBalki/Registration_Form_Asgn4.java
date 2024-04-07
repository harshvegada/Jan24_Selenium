package ashwiniBalki;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

/*
Assignment - 4 : 5th April'2024
Test and Automate Registration Form http://automationbykrishna.com
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
public class Registration_Form_Asgn4 {
	WebDriver driver;

	WebElement fullName;
	WebElement address;
	WebElement emailid;
	WebElement city;
	WebElement companyName;
	WebElement radiobutton;
	WebElement userName;
	WebElement password;
	WebElement reEnterPwd;
	WebElement TermsnpolicyCeckbox;
	WebElement submitBtn;

	void setupLaunchBrowser() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP - click on registration link");
		driver.findElement(By.xpath("//a[@id = 'registration2']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	
	
		System.out.println("find out all the elements of registration page");
		fullName = driver.findElement(By.xpath("//input[@id = 'fullName']"));
		address = driver.findElement(By.xpath("//input[@id = 'address']"));
		emailid = driver.findElement(By.xpath("//input[@id = 'useremail']"));
		city = driver.findElement(By.xpath("//input[@id = 'usercity']"));
		companyName = driver.findElement(By.xpath("//input[@id = 'organization']"));
		radiobutton = driver.findElement(By.xpath("//input[@id = 'radio-02']"));
		userName = driver.findElement(By.xpath("//input[@id = 'usernameReg']"));
		password = driver.findElement(By.xpath("//input[@id = 'passwordReg']"));
		reEnterPwd = driver.findElement(By.xpath("//input[@id = 'repasswordReg']"));
		TermsnpolicyCeckbox = driver.findElement(By.xpath("//input[@id = 'signupAgreement']"));
		submitBtn = driver.findElement(By.xpath("//button[@id = 'btnsubmitsignUp']"));
	}

	void scrollview() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
	}

	void VerifyalertText(String expectedAlertText , String testCase ) {
		
		System.out.println("Verify and handel alert message");
		
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		alert.accept();

		System.out.println("Verify - Alert Text");
		
		if (actualAlertText.equals(expectedAlertText)) {
			System.out.println(testCase + "--->Test Passed");
		} else {
			System.out.println(testCase + "--->Test Failed");
		}

	}

	// TestCase1 - Verify alert message should be "success" when all the value
	// provided for registration form fields as expected
	void testCase1() {
		System.out.println("TestCase1 - Verify alert message when all the value provided for above fields");
		
		System.out.println("Enter Full Name");
		fullName.sendKeys("Ashwini Balki");
		
		System.out.println("Enter address");
		address.sendKeys("Suyog Nagar, Nagpur");
		
		System.out.println("Enter email");
		emailid.sendKeys("ashwinibodhe13@gmai.com");
		
		System.out.println("Enter City");
		city.sendKeys("Nagpur");
		
		System.out.println("Enter Company Name");
		companyName.sendKeys("Techno");
		
		System.out.println("Click on radio button");
		radiobutton.click();
		
		System.out.println("Enter User Name");
		userName.sendKeys("Ashwini");
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Enter password");
		password.sendKeys("Ashwini@123");
		
		System.out.println("Re-enter password");
		reEnterPwd.sendKeys("Ashwini@123");
		
		System.out.println("Click on terms & Condition checkbox");
		TermsnpolicyCeckbox.click();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Success";
		
		VerifyalertText(expectedAlertText ,"testCase1" );
		
	}
	//TestCase2 - Verify alert message for name when name value not provided
	void testCase2() {
		
		System.out.println("TestCase2 - Verify alert message for name when name value not provided");
		
		System.out.println("Clear full Name");
		fullName.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Full name can't be blank";
		VerifyalertText(expectedAlertText, "testCase2");
	}
	
	//TestCase3 - Verify alert message for address when address value not provided but value provided for above fields
	void testCase3(){
		System.out.println("TestCase3 - Verify alert message for address when address value not provided but value provided for above fields");
	
		System.out.println("Enter full Name");
		fullName.sendKeys("Ashwini Balki");
		
		System.out.println("Clear address");
		address.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "address cannot be blank";
		VerifyalertText(expectedAlertText, "testCase3");
		
	}
	
 //TestCase4 - Verify alert message for email when email not provided but value provided for above fields
	void testCase4() {
	System.out.println("TestCase4 - Verify alert message for email when email not provided but value provided for above fields");
		
	System.out.println("Enter address");
	address.sendKeys("Suyog Nagar, Nagpur");
	
	System.out.println("Clear email");
	emailid.clear();
	
	System.out.println("Scroll the screen");
	scrollview();
	
	System.out.println("Click on submit button");
	submitBtn.click();
	
	String expectedAlertText = "Please enter email id";
	VerifyalertText(expectedAlertText, "testCase4");
	
	}
	
	//TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields
	void testCase5() {
		System.out.println("TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields");
	
		System.out.println("Enter wrong email");
		emailid.sendKeys("ashwinibodhe13@gmacom");
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Please use correct email format";
		VerifyalertText(expectedAlertText, "testCase5");
		
	}
	
	//TestCase6 - Verify alert message for city when city value not provided but value provided for above fields
	void testCase6(){
		System.out.println("TestCase6 - Verify alert message for city when city value not provided but value provided for above fields");
	
		System.out.println("clear old email");
		emailid.clear();
		emailid.sendKeys("ashwinibodhe13@gmai.com");
		
		System.out.println("Clear City Nmae");
		city.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Please enter City";
		VerifyalertText(expectedAlertText, "testCase6");
		
	}
	
	//TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields
	void testCase7() {
		System.out.println("TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields");
	
		System.out.println("Enter City");
		city.sendKeys("Nagpur");
		 
		System.out.println("Clear Company Name");
		companyName.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Please enter your current organization";
		VerifyalertText(expectedAlertText, "testCase7");
		
	}
	
	//TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
	void testCase8() {
		System.out.println("TestCase8 - Verify alert message for username when username value not provided but value provided for above fields");
		
		System.out.println("Enter Company Name");
		companyName.sendKeys("Techno");
		
		System.out.println("Clear User Name");
		userName.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Username is mandatory field.";
		VerifyalertText(expectedAlertText, "testCase8");
		
	}
	
	//TestCase9 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields
	void testCase9() {
		System.out.println("TestCase9 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields");
		
		System.out.println("Enter User Nameless than 5 character");
		userName.sendKeys("Ash");
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Username length should be greater then 5 characters.";
		VerifyalertText(expectedAlertText, "testCase9");
		
	}
	
	//TestCase10 - Verify alert message for password when password value not provided but value provided for above fields
	void testCase10() {
		System.out.println("TestCase10 - Verify alert message for password when password value not provided but value provided for above fields");
		
		System.out.println("Clear User Name and then enter valid userName");
		userName.clear();
		userName.sendKeys("Ashwini");
		
		System.out.println("Clear password");
		password.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "password is mandatory field.";
		VerifyalertText(expectedAlertText, "testCase10");
		
	}
	
	//TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
	void testCase11() {
		System.out.println("Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields");
	
		System.out.println("Enter password less than 5 character");
		password.sendKeys("Ashw");
	
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "password length should be greater then 5 characters.";
		VerifyalertText(expectedAlertText, "testCase11");
		
	}
	//TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
	void testCase12() {
		System.out.println("TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields");
	
		System.out.println("Clear password field");
		password.clear();
		
		System.out.println("enter password");
		password.sendKeys("Ashwini@123");
		
		System.out.println("Clear Re-enter password");
		reEnterPwd.clear();
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "please reenter password";
		VerifyalertText(expectedAlertText, "testCase12");
		
	}
	
	//TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
	void testCase13() {
		System.out.println("TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields");
		
		System.out.println("Password and Re-enter  password does not match");
		reEnterPwd.sendKeys("Ashwini@1");
		
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "retype password donot match.";
		VerifyalertText(expectedAlertText, "testCase13");
		
	}
	
	//TestCase14 - Verify alert message for Team and condition when Term and condition checkbox is not selected but value provided for above fields
	void testCase14() {
		System.out.println("TestCase14 - Verify alert message for Team and condition when Term and condition checkbox is not selected but value provided for above fields");
	
		System.out.println("Scroll the screen");
		scrollview();
		
		System.out.println("clear Re-enter password");
		reEnterPwd.clear();
		System.out.println("Enter coorect re-enter password");
		reEnterPwd.sendKeys("Ashwini@123");
		
		System.out.println("Click on terms & Condition checkbox");
		TermsnpolicyCeckbox.click();
	
		
		System.out.println("Click on submit button");
		submitBtn.click();
		
		String expectedAlertText = "Please agree to terms of service and privacy policy";
		VerifyalertText(expectedAlertText, "testCase14");
		
		System.out.println("Click on terms & Condition checkbox");
		TermsnpolicyCeckbox.click();
	
		System.out.println("Click on submit button");
		submitBtn.click();
		
	}
	
	void closeBrowser() {
		driver.quit();
	}
	public static void main(String[] args) {
		Registration_Form_Asgn4 registrationFormAsgn4 = new Registration_Form_Asgn4();
		registrationFormAsgn4.setupLaunchBrowser();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase1();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase2();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase3();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase4();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase5();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase6();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase7();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase8();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase9();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase10();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase11();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase12();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase13();
		System.out.println("------------------------");
		registrationFormAsgn4.testCase14();
		System.out.println("------------------------");
		registrationFormAsgn4.closeBrowser();
	}

}
