package ankitaVitthalSambhare;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	WebDriver driver;
	WebElement regirstrationButton;
	WebElement Uname;
	WebElement address;
	WebElement emailId;
	WebElement city;
	WebElement companyName;
	WebElement userName;
	WebElement password;
	WebElement reEnterPassword;
	WebElement AgreeAndTerms;

	void setup() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP - click on registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("find out all the elements of registration page");

		Uname = driver.findElement(By.xpath("//input[@id='fullName']"));
		address = driver.findElement(By.xpath("//input[@id='address']"));
		emailId = driver.findElement(By.xpath("//input[@id='useremail']"));
		city = driver.findElement(By.xpath("//input[@id='usercity']"));
		companyName = driver.findElement(By.xpath("//input[@id='organization']"));
		userName = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		password = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		reEnterPassword = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		regirstrationButton = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		AgreeAndTerms = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
	}

	void verifyAlertText(String expectedAlertText, String tcName) {
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		alert.accept();

		System.out.println("VERIFY - Alert text");
		if (actualAlertText.equals(expectedAlertText))
			System.out.println(tcName + " - pass");
		else
			System.out.println(tcName + " - fail");
	}

	void scrollElement(WebElement e) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	// TestCase1 - Verify alert message should be "success" when all the value
	// provided for registration form fields as expected
	void testcase1() {
		setup();
		System.out.println("STEP - Enter the Name");
		Uname.sendKeys("ankita");
		System.out.println("STEP - Enter the Address");
		address.sendKeys("Kothrud");
		System.out.println("STEP - Enter the Email Id");
		emailId.sendKeys("ankita123@gmail.com");
		System.out.println("STEP - Enter the City");
		city.sendKeys("Pune");
		System.out.println("STEP - Enter the Company Name");
		scrollElement(companyName);
		companyName.sendKeys("techno credits");
		System.out.println("STEP - Enter the userName");
		scrollElement(userName);
		userName.sendKeys("anku123");
		System.out.println("STEP - Enter the Password");
		scrollElement(password);
		password.sendKeys("ankita@123");
		System.out.println("STEP - Re-Enter the Password");
		scrollElement(reEnterPassword);
		reEnterPassword.sendKeys("ankita@123");
		System.out.println("STEP - Click on agree Terms and Conditions Checkbox");
		scrollElement(regirstrationButton);
		AgreeAndTerms.click();
		System.out.println("STEP - Click on Registration Button");
		regirstrationButton.click();
		verifyAlertText("Success", "TC1");
	}

	// Testcase2 - Verify alert message for name when name value not provided
	void testcase2() {
		System.out.println("Verify alert message for name when name value not provided");
		String originalName = Uname.getAttribute("value");
		Uname.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Full name can't be blank", "TC2");
		Uname.sendKeys(originalName);
	}

	// TestCase3 - Verify alert message for address when address value not provided
	// but value provided for above fields
	void testcase3() {
		System.out.println(
				"Verify alert message for address when address value not provided but value provided for above fields");
		String originalName = address.getAttribute("value");
		address.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("address cannot be blank", "TC3");
		address.sendKeys(originalName);
	}

	// TestCase4 - Verify alert message for email when email not provided but value
	// provided for above fields
	void testcase4() {
		System.out
				.println("Verify alert message for email when email not provided but value provided for above fields");
		String originalName = emailId.getAttribute("value");
		emailId.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Please enter email id", "TC4");
		emailId.sendKeys(originalName);
	}

	// TestCase5 - Verify alert message for correct email when wrong email provided
	// but value provided for above fields
	void testcase5() {
		System.out.println(
				"Verify alert message for correct email when wrong email provided but value provided for above fields");
		String originalName = emailId.getAttribute("value");
		emailId.clear();
		emailId.sendKeys("ankita");
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Please use correct email format", "TC5");
		emailId.clear();
		emailId.sendKeys(originalName);
	}

	// TestCase6 - Verify alert message for city when city value not provided but
	// value provided for above fields
	void testcase6() {
		System.out.println(
				"Verify alert message for city when city value not provided but value provided for above fields");
		String originalName = city.getAttribute("value");
		city.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Please enter City", "TC6");
		city.sendKeys(originalName);
	}

	// TestCase7 - Verify alert message for organization name when organization name
	// value not provided but value provided for above fields
	void testcase7() {
		System.out.println(
				"Verify alert message for organization name when organization name value not provided but value provided for above fields");
		String originalName = companyName.getAttribute("value");
		companyName.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Please enter your current organization", "TC7");
		companyName.sendKeys(originalName);
	}

	// TestCase8 - Verify alert message for username when username value not
	// provided but value provided for above fields
	void testcase8() {
		System.out.println(
				"Verify alert message for username when username value not provided but value provided for above fields");
		String originalName = userName.getAttribute("value");
		userName.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Username is mandatory field.", "TC8");
		userName.sendKeys(originalName);
	}

	// TestCase9 - Verify alert message for username less then 5 character when
	// username length is less then 5 but value provided for above fields
	void testcase9() {
		System.out.println(
				"Verify alert message for username when username value not provided but value provided for above fields");
		String originalName = userName.getAttribute("value");
		userName.clear();
		userName.sendKeys("anki");
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Username length should be greater then 5 characters.", "TC9");
		userName.clear();
		userName.sendKeys(originalName);
	}

	// TestCase10 - Verify alert message for password when password value not
	// provided but value provided for above fields
	void testcase10() {
		System.out.println(
				"Verify alert message for password when password value not provided but value provided for above fields");
		String originalName = password.getAttribute("value");
		password.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("password is mandatory field.", "TC10");
		password.sendKeys(originalName);
	}

	// TestCase11 - Verify alert message for password less then 5 character when
	// password length is less then 5 but value provided for above fields
	void testcase11() {
		System.out.println(
				"Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields");
		String originalName = password.getAttribute("value");
		password.clear();
		password.sendKeys("anki");
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("password length should be greater then 5 characters.", "TC11");
		password.clear();
		password.sendKeys(originalName);
	}

	// TestCase12 - Verify alert message for re-password when re-password value not
	// provided but value provided for above fields
	void testcase12() {
		System.out.println(
				"Verify alert message for re-password when re-password value not provided but value provided for above fields");
		String originalName = reEnterPassword.getAttribute("value");
		reEnterPassword.clear();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("please reenter password", "TC12");
		reEnterPassword.sendKeys(originalName);
	}

	// TestCase13 - Verify alert message for re-password when password and
	// re-password are not matching but value provided for above fields
	void testcase13() {
		System.out.println(
				"Verify alert message for re-password when password and re-password are not matching but value provided for above fields");
		String originalName = reEnterPassword.getAttribute("value");
		reEnterPassword.clear();
		reEnterPassword.sendKeys("3577567");
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("retype password donot match.", "TC13");
		reEnterPassword.clear();
		reEnterPassword.sendKeys(originalName);
	}

	// TestCase14 - Verify alert message for Team and condition when Team and
	// condition checkbox is not selected but value provided for above fields
	void testcase14() {
		System.out.println(
				"Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields");
		AgreeAndTerms.click();
		scrollElement(regirstrationButton);
		regirstrationButton.click();
		verifyAlertText("Please agree to terms of service and privacy policy", "TC14");
		AgreeAndTerms.click();
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment4 Assignment4 = new Assignment4();
		Assignment4.testcase1();
		Assignment4.testcase2();
		Assignment4.testcase3();
		Assignment4.testcase4();
		Assignment4.testcase5();
		Assignment4.testcase6();
		Assignment4.testcase7();
		Assignment4.testcase8();
		Assignment4.testcase9();
		Assignment4.testcase10();
		Assignment4.testcase11();
		Assignment4.testcase12();
		Assignment4.testcase13();
		Assignment4.testcase14();
	}
}
