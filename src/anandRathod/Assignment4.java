package anandRathod;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	WebElement registrationBtn;

	void setup() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		System.out.println("STEP - Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP - click on registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		registrationBtn = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
	}

	void verifyAlertText(String expectedAlertText, String tcName) {
		System.out.println("STEP - Switch to alert");
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		System.out.println("Actual Alertmessage " + actualAlertText);
		alert.accept();
		System.out.println("VERIFY: Alert text");
		if (expectedAlertText.equals(actualAlertText))
			System.out.println(tcName + " Pass");
		else
			System.out.println(tcName + " Fail");
	}

	// TestCase1 - Verify alert message when all the value provided for above fields
	void testCase1() {
		setup();
		System.out.println("STEP - Entering full name");
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Anand Rathod");
		System.out.println("STEP - Entering address");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("TLD, Pune-411048");
		System.out.println("STEP - Entering email address");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("rathod.a86@gmail.com");
		System.out.println("STEP - Entering city");
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys("Pune");
		System.out.println("STEP - Entering organization ");
		driver.findElement(By.xpath("//input[@name='organization']")).sendKeys("Achilles");
		System.out.println("STEP - Entering user name");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("anand17");
		System.out.println("STEP - Entering password");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("Test12345");
		System.out.println("STEP - Entering re-enter password");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("Test12345");
		WebElement check = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", check);
		System.out.println("STEP - Select the checkbox");
		check.click();
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();

		String expectedAlertText = "Success";
		verifyAlertText(expectedAlertText, "Test Case 1");
	}

	// TestCase2 - Verify alert message for name when name value not provided
	void testCase2() {
		System.out.println("STEP - Clearing full name");
		WebElement e = driver.findElement(By.xpath("//input[@id='fullName']"));
		String fullname = e.getAttribute("value");
		System.out.println(fullname);
		System.out.println("STEP - Clearing the data");
		e.clear();
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "Full name can't be blank";
		verifyAlertText(expectedAlertText, "Test Case 2");
		System.out.println("STEP: again enter full name");
		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys("Anand Rathod");

	}

	// TestCase3 - Verify alert message for address when address value not provided
	// but value provided for above fields
	void testCase3() {
		System.out.println("STEP - Clearing address");
		WebElement e = driver.findElement(By.xpath("//input[@placeholder='Address']"));
		String address = e.getAttribute("value");
		System.out.println(address);
		System.out.println("STEP - Clearing the data");
		e.clear();
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "address cannot be blank";
		verifyAlertText(expectedAlertText, "Test Case 3");
		System.out.println("STEP: again enter addres");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("TLD, Pune-411048");

	}

	// TestCase4 - Verify alert message for email when email not provided but value
	// provided for above fields
	// TestCase5 - Verify alert message for correct email when wrong email provided
	// but value provided for above fields
	void testCase4and5() {
		System.out.println("STEP - Coping email");
		WebElement e = driver.findElement(By.xpath("//input[@name='useremail']"));
		String email = e.getAttribute("value");
		System.out.println(email);
		System.out.println("STEP - Clearing the data");
		e.clear();
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("rathod");
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");

		registrationBtn.click();
		String expectedAlertText = "Please use correct email format";
		verifyAlertText(expectedAlertText, "Wrong Formate emailID");
		e.clear();
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText2 = "Please enter email id";
		verifyAlertText(expectedAlertText2, "Test Case 4 and 5");
		System.out.println("STEP: again enter email id");
		driver.findElement(By.xpath("//input[@name='useremail']")).sendKeys("rathod.a86@gmail.com");
	}
	// TestCase6 - Verify alert message for city when city value not provided but
	// value provided for above fields

	void testCase6() {
		System.out.println("STEP - Coping the city");
		WebElement e = driver.findElement(By.xpath("//input[@id='usercity']"));
		String city = e.getAttribute("value");
		System.out.println(city);
		System.out.println("STEP - Clearing the data");
		e.clear();
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "Please enter City";
		verifyAlertText(expectedAlertText, "Test Case 6");
		System.out.println("STEP: again enter City");
		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys("Pune");
	}
	//TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields
	void testCase7() {
		System.out.println("STEP - Coping organization name");
		WebElement e = driver.findElement(By.xpath("//input[@name='organization']"));
		String organizaation = e.getAttribute("value");
		System.out.println(organizaation);
		System.out.println("STEP - Clearing the data");
		e.clear();
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "Please enter your current organization";
		verifyAlertText(expectedAlertText, "Test Case 7");
		System.out.println("STEP: again enter organization");
		driver.findElement(By.xpath("//input[@name='organization']")).sendKeys("Achilles");
	}
	
	//TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
	void testCase8() {
		System.out.println("STEP - Coping user name");
		WebElement e = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		String organizaation = e.getAttribute("value");
		System.out.println(organizaation);
		System.out.println("STEP - Clearing the data");
		e.clear();
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "Username is mandatory field.";
		verifyAlertText(expectedAlertText, "Test Case 8");
		System.out.println("STEP: again enter user name");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("anand17");
	}
	
	
	//TestCase9 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields
	void testCase9() {
		System.out.println("STEP - Coping user name");
		WebElement e = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		String userName = e.getAttribute("value");
		System.out.println(userName);
		System.out.println("STEP - Clearing the data");
		e.clear();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("anand");
		System.out.println("STEP - Scrolling down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "Username length should be greater then 5 characters.";
		System.out.println("Expected Alertmessage" + expectedAlertText);
		verifyAlertText(expectedAlertText, "Test Case 9");
		System.out.println("STEP: again enter user name");
		e.clear();
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("anand17");
	}
	
	//TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
	void testCase11() {
		System.out.println("STEP - Coping password");
		WebElement e = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		String password = e.getAttribute("value");
		System.out.println(password);
		System.out.println("STEP - Clearing the data");
		e.clear();
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("Test1");
		/*
		 * System.out.println("STEP - Scrolling down"); JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true)", registrationBtn);*/
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "password length should be greater then 5 characters.";
		verifyAlertText(expectedAlertText, "Test Case 11");
		System.out.println("STEP: again enter password");
		e.clear();
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("Test12345");
	}
	
	//TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
	void testCase12() {
		System.out.println("STEP - Coping re-password");
		WebElement e = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		String repassword = e.getAttribute("value");
		System.out.println(repassword);
		System.out.println("STEP - Clearing the data");
		e.clear();
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "please reenter password";
		verifyAlertText(expectedAlertText, "Test Case 12");
		System.out.println("STEP: again enter password");
		e.clear();
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("Test12345");
	}
	
	//TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
	void testCase13() {
		System.out.println("STEP - Coping re-password");
		WebElement e = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		String repassword = e.getAttribute("value");
		System.out.println(repassword);
		System.out.println("STEP - Clearing the data");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("123");
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "retype password donot match.";
		verifyAlertText(expectedAlertText, "Test Case 13");
		System.out.println("STEP: again enter password");
		e.clear();
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("Test12345");
	}
	
	//TestCase14 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields
	void testCase14() {
		System.out.println("STEP - Unchecked the Terms & Conditions checkbox");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		System.out.println("STEP - Click on Submit button");
		registrationBtn.click();
		String expectedAlertText = "Please agree to terms of service and privacy policy";
		verifyAlertText(expectedAlertText, "Test Case 14");
		System.out.println(expectedAlertText);
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
	}
	
	
	public static void main(String[] args) {
		Assignment4 assignment4 = new Assignment4();
		assignment4.testCase1();
		assignment4.testCase2();
		assignment4.testCase3();
		assignment4.testCase4and5();
		assignment4.testCase6();
		assignment4.testCase7();
		assignment4.testCase8();
		assignment4.testCase9();
		assignment4.testCase11();
		assignment4.testCase12();
		assignment4.testCase13();
		assignment4.testCase14();
	}
}