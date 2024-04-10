package rupaliUmagol;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	WebElement fullName;
	WebElement address;
	WebElement emailId;
	WebElement city;
	WebElement company;
	WebElement female;
	WebElement userName;
	WebElement password;
	WebElement rePassword;
	WebElement terms;
	WebElement submit;

	void getSetUp() {
		System.out.println("STEP : Lunch ChromeBrowser and open Url");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP : Miximize brower and add wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP : Click on Registration Page");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		System.out.println("STEP : Find Out Elements for Registration");
		fullName = driver.findElement(By.xpath("//input[@id='fullName']"));
		address = driver.findElement(By.xpath("//input[@id='address']"));
		emailId = driver.findElement(By.xpath("//input[@id='useremail']"));
		city = driver.findElement(By.xpath("//input[@id='usercity']"));
		company = driver.findElement(By.xpath("//input[@id='organization']"));
		female = driver.findElement(By.xpath("//input[@id='radio-02']"));
		userName = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		password = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		rePassword = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		terms = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		submit = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
	}

	void verifyAlertText(String ExpectedText, String tcName) {
		Alert alert = driver.switchTo().alert();

		String ActalText = alert.getText();
		if (ActalText.equals(ExpectedText)) {
			System.out.println(tcName + " Passed ");
		} else
			System.out.println(tcName + " Failed ");

		System.out.println("STEP : Accept Alert");
		alert.accept();
	}

	void ScrollElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	// TestCase1 - Verify alert message when all the value provided for above fields
	void TestCase1() {
		getSetUp();
		System.out.println("STEP : Enter Full Name ");
		fullName.sendKeys("RupaliUmagol");

		System.out.println("STEP : Enter Address ");
		address.sendKeys("Hinjewadi");

		System.out.println("STEP : Enter Email ID ");
		emailId.sendKeys("rupali.uamgol@gmail.com");

		System.out.println("STEP : Enter City ");
		city.sendKeys("Pune");

		System.out.println("STEP : Scroll Down ");
		ScrollElement(company);

		System.out.println("STEP : Enter Company Name ");
		company.sendKeys("Moolya");

		System.out.println("STEP : Click on Female radio button ");
		female.click();

		System.out.println("STEP : Enter User Name ");
		userName.sendKeys("RupaliU");

		System.out.println("STEP : Enter PassWord ");
		password.sendKeys("12345678");

		System.out.println("STEP : ReEnter PassWord ");
		rePassword.sendKeys("12345678");

		System.out.println("STEP : Click On Terms and Conditions ");
		terms.click();

		System.out.println("STEP : Click On Submit ");
		submit.click();

		verifyAlertText("Success", "TestCase1");
	}

	// TestCase2 - Verify alert message for name when name value not provided
	void TestCase2() {
		System.out.println("STEP : Get Full Name Entered");
		String name = fullName.getAttribute("value");

		System.out.println("STEP : Clear the Full Name Entered");
		fullName.clear();

		System.out.println("STEP : Scroll and click on Submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Full name can't be blank", "TestCase2");

		System.out.println("STEP : Enter Full name again");
		fullName.sendKeys(name);

	}

	// TestCase3 - Verify alert message for address when address value not provided
	// but value provided for above fields
	void TestCase3() {
		System.out.println("STEP : Get Address Entered");
		String name = address.getAttribute("value");

		System.out.println("STEP : Clear the Address Entered");
		address.clear();

		System.out.println("STEP : Scroll and click on Submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("address cannot be blank", "TestCase3");

		System.out.println("STEP : Enter Address again");
		address.sendKeys(name);
	}

	// TestCase4 - Verify alert message for email when email not provided but value
	// provided for above fields
	void TestCase4() {
		System.out.println("STEP : Get EmailId Entered");
		String name = emailId.getAttribute("value");

		System.out.println("STEP : Clear the EmailID Entered");
		emailId.clear();

		System.out.println("STEP : Scroll and click on Submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Please enter email id", "TestCase4");

		System.out.println("STEP : Enter EmailID again");
		emailId.sendKeys(name);

	}

	// TestCase5 - Verify alert message for correct email when wrong email provided
	// but value provided for above fields
	void TestCase5() {
		System.out.println("STEP : Get EmailId Entered");
		String name = emailId.getAttribute("value");

		System.out.println("STEP : Clear the EmailID Entered");
		emailId.clear();

		System.out.println("SETP : Enter Invalid EmailID");
		emailId.sendKeys("rupali.umagol");

		System.out.println("STEP : Scroll and click on Submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Please use correct email format", "TestCase5");

		System.out.println("STEP : Clear the EmailID Entered");
		emailId.clear();

		System.out.println("STEP : Enter EmailID again");
		emailId.sendKeys(name);
	}

	// TestCase6 - Verify alert message for city when city value not provided but
	// value provided for above fields
	void TestCase6() {
		System.out.println("STEP : Get City Entered");
		String name = city.getAttribute("value");

		System.out.println("STEP : Clear the City Entered");
		city.clear();

		System.out.println("STEP : Scroll and click on Submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Please enter City", "TestCase6");

		System.out.println("STEP : Enter City again");
		city.sendKeys(name);
	}

	// TestCase7 - Verify alert message for organization name when organization name
	// value not provided but value provided for above fields
	void TestCase7() {
		System.out.println("STEP : Get Orgnization Entered");
		String name = company.getAttribute("value");

		System.out.println("STEP : Clear the City Entered");
		company.clear();

		System.out.println("STEP : Scroll and click on Submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Please enter your current organization", "TestCase7");

		System.out.println("STEP : Enter Orgnization again");
		company.sendKeys(name);
	}

	// TestCase8 - Verify alert message for username when username value not
	// provided but value provided for above fields
	void TestCase8() {
		System.out.println("STEP : Get UserName Entered");
		String name = userName.getAttribute("value");

		System.out.println("STEP : Clear UserName");
		userName.clear();

		System.out.println("STEP : Scroll Down and Click Submit ");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Username is mandatory field.", "TestCase8");

		System.out.println("STEP : Enter User Name again");
		userName.sendKeys(name);
	}

	// TestCase9 - Verify alert message for username less then 5 charater when
	// username lenght is less then 5 but value provided for above fields
	void TestCase9() {
		System.out.println("STEP : Get UserName Entered");
		String name = userName.getAttribute("value");

		System.out.println("STEP : Clear UserName Entered");
		userName.clear();

		System.out.println("STEP : Enter UserName less than 5 Character");
		userName.sendKeys("rups");

		System.out.println("STEP : Scroll down and click on submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Username length should be greater then 5 characters.", "TestCase9");

		System.out.println("STEP : Clear invalid User Name Entered");
		userName.clear();

		System.out.println("STEP : Enter valid User Name again");
		userName.sendKeys(name);
	}

	// TestCase10 - Verify alert message for password when password value not
	// provided but value provided for above fields
	void TestCase10() {
		System.out.println("STEP : Get PassWord Entered");
		String name = password.getAttribute("value");

		System.out.println("STEP : Clear Password");
		password.clear();

		System.out.println("STEP : Scroll Down and Click Submit ");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("password is mandatory field.", "TestCase10");

		System.out.println("STEP : Enter Password again");
		password.sendKeys(name);
	}

	// TestCase11 - Verify alert message for password less then 5 character when
	// password length is less then 5 but value provided for above fields
	void TestCase11() {
		System.out.println("STEP : Get PassWord Entered");
		String name = password.getAttribute("value");

		System.out.println("STEP : Clear PassWord Entered");
		password.clear();

		System.out.println("STEP : Enter PassWord less than 5 Character");
		password.sendKeys("rups");

		System.out.println("STEP : Scroll down and click on submit");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("password length should be greater then 5 characters.", "TestCase11");

		System.out.println("STEP : Clear invalid PassWord Entered");
		password.clear();

		System.out.println("STEP : Enter valid PassWord again");
		password.sendKeys(name);
	}

	// TestCase12 - Verify alert message for re-password when re-password value not
	// provided but value provided for above fields
	void TestCase12() {
		System.out.println("STEP : Get  Re-PassWord Entered");
		String name = rePassword.getAttribute("value");

		System.out.println("STEP : Clear Re-Password");
		rePassword.clear();

		System.out.println("STEP : Scroll Down and Click Submit ");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("please reenter password", "TestCase12");

		System.out.println("STEP : Enter Re-Password again");
		rePassword.sendKeys(name);
	}

	// TestCase13 - Verify alert message for re-password when password and
	// re-password are not matching but value provided for above fields
	void TestCase13() {
		System.out.println("STEP : Get Value Entered for Password");
		String name = password.getAttribute("value");

		System.out.println("STEP : Clear the Re Passoword Entered");
		rePassword.clear();

		System.out.println("STEP : Enter re Password not matching with Password");
		rePassword.sendKeys("12345");

		System.out.println("STEP : Scroll Down and Click Submit ");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("retype password donot match.", "TestCase13");

		System.out.println("STEP : Clear the Invalid Re Passoword Entered");
		rePassword.clear();

		System.out.println("STEP : Enter same Re-Password as password again");
		rePassword.sendKeys(name);
	}

	// TestCase14 - Verify alert message for Team and condition when Team and
	// condition checkbox is not selected but value provided for above fields
	void TestCase14() {
		System.out.println("STEP : Click on terms and Conditions to unselect checkbox");
		terms.click();

		System.out.println("STEP : Scroll Down and Click Submit ");
		ScrollElement(submit);
		submit.click();

		System.out.println("VERIFY : Expected and Actual Alert Message");
		verifyAlertText("Please agree to terms of service and privacy policy", "TestCase14");

		System.out.println("STEP : Click on terms and Conditions to unselect checkbox");
		terms.click();

		System.out.println("STEP : Click on submit");
		submit.click();

		System.out.println("STEP : Close driver");
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment4 assignment = new Assignment4();
		assignment.TestCase1();
		assignment.TestCase2();
		assignment.TestCase3();
		assignment.TestCase4();
		assignment.TestCase5();
		assignment.TestCase6();
		assignment.TestCase7();
		assignment.TestCase8();
		assignment.TestCase9();
		assignment.TestCase10();
		assignment.TestCase11();
		assignment.TestCase12();
		assignment.TestCase13();
		assignment.TestCase14();
	}
}
