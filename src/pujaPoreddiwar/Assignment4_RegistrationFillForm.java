/*
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

package pujaPoreddiwar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_RegistrationFillForm {

	WebDriver driver;
	String fullName = "PujaPP";
	String address = "Wakad";
	String emailAddress = "pujap12@abc.com";
	String city = "Pune";
	String company = "Techo Credits";
	String password = "Techno@1234";

	void openBrowser() {
		System.out.println("STEP: Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Hit URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// TestCase1 - Verify alert message when all the value provided for above fields
	void testCase1() {
		openBrowser();
		System.out.println("--------------Test Case 1--------------");
		System.out.println("STEP: fill all details under Registration");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.findElement(By.xpath("//input[@name='fName']")).sendKeys(fullName);
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='organization']")).sendKeys(company);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//input[@id='radio-02']")).click();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys(fullName);
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();

		String expectedText = "Success";
		Alert alert = driver.switchTo().alert();
		String actualText = "Success";

		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}
		System.out.println("VERIFY: alert message when all the value provided for above fields");
		System.out.println("STEP: (Success) Alert popup closed");
		alert.accept();
	}

	// TestCase2 - Verify alert message for name when name value not provided
	void testCase2() {
		System.out.println("--------------Test Case 2--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je1.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//input[@name='fName']")).clear();
		JavascriptExecutor je2 = (JavascriptExecutor) driver;
		je2.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText = "Full name can't be blank";
		Alert alert = driver.switchTo().alert();
		String actualText = "Full name can't be blank";
		System.out.println("Verify alert message for name when name value not provided");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP: (Full name can't be blank) Alert popup closed");
		alert.accept();
		driver.findElement(By.xpath("//input[@name='fName']")).sendKeys(fullName);
	}

	// TestCase3 - Verify alert message for address when address value not provided
	
	void testCase3() {
		System.out.println("--------------Test Case 3--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Address']")).clear();
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je1.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText = "address cannot be blank";
		Alert alert = driver.switchTo().alert();
		String actualText = "address cannot be blank";
		System.out.println("Verify alert message for address when address value not provided");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		
		System.out.println("STEP: (address cannot be blank) Alert popup closed");
		alert.accept();
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(address);
	}
	
	//Verify alert message for email when email not provided but value provided for above fields
	void testCase4() {
		System.out.println("--------------Test Case 4--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='useremail']")).clear();
		JavascriptExecutor je =(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText = "Please enter email id";
		Alert alert = driver.switchTo().alert();
		String actualText = "Please enter email id";
		System.out.println("Verify alert message for email when email not provided but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		System.out.println("STEP: (Please enter email id) Alert popup closed");
		alert.accept();
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("123223");
		JavascriptExecutor je1 =(JavascriptExecutor)driver;
		je1.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
	}
	//Verify alert message for correct email when wrong email provided but value provided for above fields
	void testCase5() {
		
		System.out.println("--------------Test Case 5--------------");
		String expectedText1 = "Please use correct email format";
		Alert alert1 = driver.switchTo().alert();
		String actualText1 = "Please use correct email format";
		System.out.println("Verify alert message for correct email when wrong email provided but value provided for above fields");
		if(actualText1.equals(expectedText1)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		System.out.println("STEP: (Please use correct email format) Alert popup closed");
		alert1.accept();
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys(emailAddress);
	}
	
	//Verify alert message for city when city value not provided but value provided for above fields
	void testCase6() {
		System.out.println("--------------Test Case 6--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).clear();
		JavascriptExecutor je =(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText = "Please enter City";
		Alert alert = driver.switchTo().alert();
		String actualText = "Please enter City";
		System.out.println("Verify alert message for city when city value not provided but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP: (Please enter City) Alert popup closed");
		alert.accept();
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys(city);
		
	}
	
	//Verify alert message for organization name when organization name value not provided but value provided for above field
	void testCase7() {
		System.out.println("--------------Test Case 7--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='organization']")).clear();
		JavascriptExecutor je =(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText = "Please enter your current organization";
		Alert alert = driver.switchTo().alert();
		String actualText = "Please enter your current organization";
		System.out.println("Verify alert message for organization name when organization name value not provided but value provided for above field");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP: (Please enter your current organization) Alert popup closed");
		alert.accept();
		driver.findElement(By.xpath("//input[@name='organization']")).sendKeys(company);
	}

	//Verify alert message for username when username value not provided but value provided for above fields
	void testCase8() {
		System.out.println("--------------Test Case 8--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='usernameReg']")).clear();
		JavascriptExecutor je =(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText = "Username is mandatory field.";
		Alert alert = driver.switchTo().alert();
		String actualText = "Username is mandatory field.";
		System.out.println("Verify alert message for organization name when organization name value not provided but value provided for above field");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP: (Please enter your current organization) Alert popup closed");
		alert.accept();
	}
	
	//Verify alert message for username less then 5 character when username length is less then 5 but value provided for above fields
	void testCase9() {
		System.out.println("--------------Test Case 9--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("12");
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText ="Username length should be greater then 5 characters.";
		Alert alert = driver.switchTo().alert();
		String actualText = "Username length should be greater then 5 characters.";
		System.out.println("Verify alert message for username less then 5 character when username length is less then 5 but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP:(Username is mandatory field.) Alert popup closed ");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys(fullName);
	}
	
	//Verify alert message for password when password value not provided but value provided for above fields
	void testCase10() {
		System.out.println("--------------Test Case 10--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='passwordReg']")).clear();
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText ="password is mandatory field.";
		Alert alert = driver.switchTo().alert();
		String actualText = "password is mandatory field.";
		System.out.println("Verify alert message for password when password value not provided but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP:(password is mandatory field.) Alert popup closed ");
		alert.accept();
	}
	
	// Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
	void testCase11() {
		System.out.println("--------------Test Case 11--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("12");
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText ="password length should be greater then 5 characters.";
		Alert alert = driver.switchTo().alert();
		String actualText = "password length should be greater then 5 characters.";
		System.out.println("Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP:(password length should be greater then 5 characters.) Alert popup closed ");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='passwordReg']")).clear();
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys(password);
	}
	
	//Verify alert message for re-password when re-password value not provided but value provided for above fields
	void testCase12() {
		System.out.println("--------------Test Case 12--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).clear();
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText ="please reenter password";
		Alert alert = driver.switchTo().alert();
		String actualText = "please reenter password";
		System.out.println("Verify alert message for re-password when re-password value not provided but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP:(please reenter password) Alert popup closed ");
		alert.accept();
	}
	
	//Verify alert message for re-password when re-password value not provided but value provided for above fields
	void testCase13() {
		System.out.println("--------------Test Case 13--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("13");
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText ="retype password donot match.";
		Alert alert = driver.switchTo().alert();
		String actualText = "retype password donot match.";
		System.out.println("Verify alert message for password when password value not provided but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP:(retype password donot match.) Alert popup closed ");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).clear();
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys(password);
	}
	
	//Verify alert message for Terms and condition when Team and condition checkbox is not selected but value provided for above fields
	void testCase14() {
		System.out.println("--------------Test Case 14--------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		JavascriptExecutor je =(JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		String expectedText ="Please agree to terms of service and privacy policy";
		Alert alert = driver.switchTo().alert();
		String actualText = "Please agree to terms of service and privacy policy";
		System.out.println("Verify alert message for password when password value not provided but value provided for above fields");
		if(actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test fail");
		}
		System.out.println("STEP:(Please agree to terms of service and privacy policy) Alert popup closed ");
		alert.accept();
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
	}
	
	public static void main(String[] args) {
		Assignment4_RegistrationFillForm regiFormFill = new Assignment4_RegistrationFillForm();
		regiFormFill.testCase1();
		regiFormFill.testCase2();
		regiFormFill.testCase3();
		regiFormFill.testCase4();
		regiFormFill.testCase5();
		regiFormFill.testCase6();
		regiFormFill.testCase7();
		regiFormFill.testCase8();
		regiFormFill.testCase9();
		regiFormFill.testCase10();
		regiFormFill.testCase11();
		regiFormFill.testCase12();
		regiFormFill.testCase13();
		regiFormFill.testCase14();
	}
}
