/*
TestCase1 - Verify alert message for name when name value not provided
TestCase2 - Verify alert message for address when address value not provided but value provided for above fields
TestCase3 - Verify alert message for email when email not provided but value provided for above fields
TestCase4 - Verify alert message for correct email when wrong email provided but value provided for above fields
TestCase5 - Verify alert message for city when city value not provided but value provided for above fields
TestCase6 - Verify alert message for organization name when organization name value not provided but value provided for above fields
TestCase7 - Verify alert message for username when username value not provided but value provided for above fields
TestCase8 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields
TestCase9 - Verify alert message for password when password value not provided but value provided for above fields
TestCase10 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
TestCase11 - Verify alert message for re-password when re-password value not provided but value provided for above fields
TestCase12 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
TestCase13 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields
TestCase14 - Verify alert message when all the value provided for above fields
 * 
 */

package phenolVerma;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegstrationFormKrishna {

	// Creating Chrome webdriver object
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");
	}

	void scrollScreenToFindElement() {

		// Finding the element if not visible in view port
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")));
		System.out.println("Clicking on tick mark button to submit the registration form");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
	}

	void capturingAlert() {
		System.out.println("Catching the alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("Capture and printing alert message");
		System.out.println("Message is - " + alert.getText());

		System.out.println("Closing alert");
		alert.accept();
	}

	void testRegistrationForm() throws InterruptedException {

		openBrowser();

		System.out.println("Moving to Registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		Thread.sleep(2000);

		// TestCase1 - Verify alert message for name when name value not provided
		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 1 passed");

		// TestCase2 - Verify alert message for address when address value not provided
		// but value provided for above fields
		System.out.println("Providing the Full Name");
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Phenol Verma");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 2 passed");

		// TestCase3 - Verify alert message for email when email not provided but value
		// provided for above fields
		System.out.println("Providing the address");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Lohegaon");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 3 passed");

		// TestCase4 - Verify alert message for correct email when wrong email provided
		// but value provided for above fields
		System.out.println("Providing the worng email");
		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("adsds.com");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 4 passed");

		// TestCase5 - Verify alert message for city when city value not provided but
		// value provided for above fields
		System.out.println("Providing the correct email");

		System.out.println("Clear the email text box");
		driver.findElement(By.xpath("//input[@id='useremail']")).clear();

		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("phenol.verma@gmail.com");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 5 passed");

		// TestCase6 - Verify alert message for organization name when organization name
		// value not provided but value provided for above fields

		System.out.println("Providing the City name");

		System.out.println("Clear the email text box");
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys("Pune");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 6 passed");

		// TestCase7 - Verify alert message for username when username value not
		// provided but value provided for above fields

		System.out.println("Providing the organization name");

		driver.findElement(By.xpath("//input[@id='organization']")).sendKeys("Citi Bank");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 7 passed");

		// TestCase8 - Verify alert message for username less then 5 charater when
		// username lenght is less then 5 but value provided for above fields

		System.out.println("Providing the wrong username");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("phe");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 8 passed");

		// TestCase9 - Verify alert message for password when password value not
		// provided but value provided for above fields

		System.out.println("Providing the username");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).clear();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("phenolverma");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 9 passed");

		// TestCase10 - Verify alert message for password less then 5 charater when
		// password lenght is less then 5 but value provided for above fields
		System.out.println("Providing the worng password");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("phe");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 10 passed");

		// TestCase11 - Verify alert message for re-password when re-password value not
		// provided but value provided for above fields
		System.out.println("Providing the password");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).clear();

		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("phenol");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 11 passed");

		// TestCase12 - Verify alert message for re-password when password and
		// re-password are not matching but value provided for above fields
		System.out.println("Providing the password");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("phe");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 12 passed");

		// TestCase13 - Verify alert message for Team and condition when Team and
		// conditioncheckbox is not selected but value provided for above fields
		System.out.println("Providing the password");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).clear();

		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("phenol");

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 13 passed");

		// TestCase14 - Verify alert message when all the value provided for above
		// fields
		System.out.println("Click on the checkbox");
		driver.findElement(By.xpath("//input[@id=\'signupAgreement\']")).click();

		// Calling scrollscreen method and capture alert method
		scrollScreenToFindElement();
		capturingAlert();
		System.out.println("Test case 14 passed");

		System.out.println("Quiting browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		TestRegstrationFormKrishna testRegstrationFormKrishna = new TestRegstrationFormKrishna();
		testRegstrationFormKrishna.testRegistrationForm();
		System.out.println("All test case Passed");
	}
}
