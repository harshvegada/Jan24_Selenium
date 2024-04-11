package akshadaRajput;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleRegistrationFormAlerts {

	WebDriver driver;

	void launchBrowser() {
		System.out.println("Prerequisite: Launching browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	void navigateToRegistrationPage() throws InterruptedException {
		System.out.println("Prerequisite: Navigating to Registration Page");
		driver.findElement(By.id("registration2")).click();
	}

	void compareAlert(String expected, String tcid) {
		Alert alert = driver.switchTo().alert();
		if (expected.equals(alert.getText()))
			System.out.println(tcid + " pass");
		else
			System.out.println(tcid + " fail");

		alert.accept();
	}

	void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.id("signupAgreement")));

	}

	void alertWithValidInputsToAllFields() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println("TestCase1: Verify alert message when all the value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Success";
		compareAlert(expectedAlert, "TestCase1");

		System.out.println("Closing browser");

		driver.quit();
	}

	void alertWithNoInputToName() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println("TestCase2: Verify alert message for name when name value not provided");

		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Full name can't be blank";
		compareAlert(expectedAlert, "TestCase2");

		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToAddress() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase3: Verify alert message for address when address value not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "address cannot be blank";
		compareAlert(expectedAlert, "TestCase3");

		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToEmail() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase4: Verify alert message for email when email not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Please enter email id";
		compareAlert(expectedAlert, "TestCase4");

		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithInvalidInputToEmail() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase5: Verify alert message for correct email when wrong email provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Please use correct email format";
		compareAlert(expectedAlert, "TestCase5");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToCity() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase6: Verify alert message for city when city value not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Please enter City";
		compareAlert(expectedAlert, "TestCase6");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToOrganization() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase7: Verify alert message for organization name when organization name value not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Please enter your current organization";
		compareAlert(expectedAlert, "TestCase7");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToUserName() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase8: Verify alert message for username when username value not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Username is mandatory field.";
		compareAlert(expectedAlert, "TestCase8");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithInvalidInputToUsername() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase9: Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Username length should be greater then 5 characters.";
		compareAlert(expectedAlert, "TestCase9");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToPassword() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase10:  Verify alert message for password when password value not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "password is mandatory field.";
		compareAlert(expectedAlert, "TestCase10");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithInvalidInputToPassword() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase11: Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "password length should be greater then 5 characters.";
		compareAlert(expectedAlert, "TestCase11");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNoInputToRePassword() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase12: Verify alert message for re-password when re-password value not provided but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "please reenter password";
		compareAlert(expectedAlert, "TestCase12");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithNotMatchingPasswords() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase13: Verify alert message for re-password when password and re-password are not matching but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123456");
		driver.findElement(By.id("signupAgreement")).click();
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "retype password donot match.";
		compareAlert(expectedAlert, "TestCase13");
		System.out.println("Closing browser");
		driver.quit();
	}

	void alertWithTermsAndConditionsSelection() throws InterruptedException {
		launchBrowser();
		navigateToRegistrationPage();

		System.out.println(
				"TestCase14: Verify alert message for Term and condition when Term and condition checkbox is not selected but value provided for above fields");

		driver.findElement(By.id("fullName")).sendKeys("Abc Pqr Xyz");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Maharashtra, India");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("test@test.in");
		driver.findElement(By.id("usercity")).sendKeys("Pune");
		driver.findElement(By.name("organization")).sendKeys("Technocredits");
		scrollPage();
		driver.findElement(By.id("radio-02")).click();
		driver.findElement(By.id("usernameReg")).sendKeys("abc_xyz");
		driver.findElement(By.id("passwordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("repasswordReg")).sendKeys("Abcd_password@123");
		driver.findElement(By.id("btnsubmitsignUp")).click();

		String expectedAlert = "Please agree to terms of service and privacy policy";
		compareAlert(expectedAlert, "TestCase14");
		System.out.println("Closing browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		HandleRegistrationFormAlerts handleRegistrationFormAlerts = new HandleRegistrationFormAlerts();
		handleRegistrationFormAlerts.alertWithValidInputsToAllFields();
		handleRegistrationFormAlerts.alertWithNoInputToName();
		handleRegistrationFormAlerts.alertWithNoInputToAddress();
		handleRegistrationFormAlerts.alertWithNoInputToEmail();
		handleRegistrationFormAlerts.alertWithInvalidInputToEmail();
		handleRegistrationFormAlerts.alertWithNoInputToCity();
		handleRegistrationFormAlerts.alertWithNoInputToOrganization();
		handleRegistrationFormAlerts.alertWithNoInputToUserName();
		handleRegistrationFormAlerts.alertWithInvalidInputToUsername();
		handleRegistrationFormAlerts.alertWithNoInputToPassword();
		handleRegistrationFormAlerts.alertWithInvalidInputToPassword();
		handleRegistrationFormAlerts.alertWithNoInputToRePassword();
		handleRegistrationFormAlerts.alertWithNotMatchingPasswords();
		handleRegistrationFormAlerts.alertWithTermsAndConditionsSelection();
	}
}
