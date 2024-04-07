package hiralPurohit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Assignment_4 {

	WebDriver driver;
	WebElement firstname;
	WebElement adress;
	WebElement email;
	WebElement city;
	WebElement companyName;
	WebElement gender;
	WebElement username;
	WebElement password;
	WebElement retypePassWord;
	WebElement agreeTermsCond;
	WebElement button;

	void loadBrowser() {
		driver = new ChromeDriver();
		System.out.println("STEP: Launch the URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		System.out.println("STEP: click on registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void alertText(String expectedText, int num) {
		System.out.println("STEP: switch to alert messege");
		Alert alert = driver.switchTo().alert();

		System.out.println("Alert window open");
		String actualText = alert.getText();
		alert.accept();

		System.out.println("Verify ActualTextMessege with ExpectedText");
		if (actualText.equals(expectedText)) {
			System.out.println("TestCase: " + num + " Passed");
		} else {
			System.out.println("TestCase:" + num + " Failed");
		}
	}

	void scrollElement(WebElement e) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	// TestCase1 - Verify alert message should be "success" when all the value
	// provided for registration form fields as expected
	void TestCase1() {

		loadBrowser();
		System.out.println("Test Case 1");
		System.out.println("STEP 1:Enter Full name");
		firstname = driver.findElement(By.xpath("//input[@id='fullName']"));
		firstname.sendKeys("Hiral");

		System.out.println("STEP 2: Enter Your Adress");
		adress = driver.findElement(By.xpath("//input[@id='address']"));
		adress.sendKeys("Dhanori");

		System.out.println("STEP 3: Enter Your Email");
		email = driver.findElement(By.xpath("//input[@id='useremail']"));
		email.sendKeys("rajpurohithiral@gmail.com");

		System.out.println("Step 4: Enter Your City");
		city = driver.findElement(By.xpath("//input[@id='usercity']"));
		city.sendKeys("Pune");

		System.out.println("STEP 5: Enter Your Company name");
		companyName = driver.findElement(By.xpath("//input[@id='organization']"));
		companyName.sendKeys("Techno");

		System.out.println("STEP 6: click on gender button");
		gender = driver.findElement(By.xpath("//label[@for='radio-02']"));
		scrollElement(gender);
		gender.click();

		System.out.println("STEP 7: Enter Username");
		username = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		username.sendKeys("hpurohit");

		System.out.println("STEP 8: Enter Password");
		password = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		password.sendKeys("123@webelement");

		System.out.println("STEP 9: Enter password again");
		retypePassWord = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		retypePassWord.sendKeys("123@webelement");

		System.out.println("STEP 10: click on agreement");
		agreeTermsCond = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		agreeTermsCond.click();

		System.out.println("STEP 11: click on ok Button");
		button = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		button.click();

		alertText("Success", 1);
	}

	// Testcase2 - Verify alert message for name when name value not provided
	void testCase2() {
		System.out.println("Verify alert messege for firstname when value is not provided ");
		String firstName = firstname.getAttribute("value");
		firstname.clear();
		scrollElement(button);
		button.click();
		alertText("Full name can't be blank", 2);
		firstname.sendKeys(firstName);
	}

	//TestCase3 - Verify alert message for address when address value not provided but value provided for above fields
	void testCase3() {
		System.out.println("Verify alert messege for adress when value is not provided ");
		String myadress = adress.getAttribute("value");
		adress.clear();
		scrollElement(button);
		button.click();
		alertText("address cannot be blank", 3);
		adress.sendKeys(myadress);
	}

	//TestCase4 - Verify alert message for email when email not provided but value provided for above fields
	void testCase4() {
		System.out.println("Verify alert messege for email when value is not provided ");
		String emailId = email.getAttribute("value");
		email.clear();
		scrollElement(button);
		button.click();
		alertText("Please enter email id", 4);
		email.sendKeys(emailId);

	}
	
	//TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields
	void testCase5() {
		System.out.println("Verify alert messege for email when value is not provided ");
		String emailId = email.getAttribute("value");
		email.clear();
		email.sendKeys("jkjkdak");
		scrollElement(button);
		button.click();
		alertText("Please use correct email format", 5);
		email.clear();
		email.sendKeys(emailId);
	}
	
	//TestCase6 - Verify alert message for city when city value not provided but value provided for above fields
	void testCase6() {
		System.out.println("Verify alert messege for city name when value is not provided ");
		String cityname = city.getAttribute("value");
		city.clear();
		scrollElement(button);
		button.click();
		alertText("Please enter City", 6);
		city.sendKeys(cityname);
	}

	// TestCase7 - Verify alert message for organization name when organization name
	void testCase7() {
		System.out.println("Verify alert messege for organization name when value is not provided ");
		String comapany = companyName.getAttribute("value");
		companyName.clear();
		scrollElement(button);
		button.click();
		alertText("Please enter your current organization", 7);
		companyName.sendKeys(comapany);
	}

	//TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
	void testCase8() {
		System.out.println("Verify alert messege for username name when value is not provided");
		String uname = username.getAttribute("value");
		username.clear();
		scrollElement(button);
		button.click();
		alertText("Username is mandatory field.", 8);
		username.sendKeys(uname);
	}

	 //TestCase9 - Verify alert message for username less then 5 character when username length is less then 5 but value provided for above fields
	void testCase9() {
		System.out.println("Verify alert messege for username name lenght less than 5 ");
		String uname = username.getAttribute("value");
		username.clear();
		username.sendKeys("jik");
		scrollElement(button);
		button.click();
		alertText("Username length should be greater then 5 characters.", 9);
		username.clear();
		username.sendKeys(uname);
	}

	void testCase10() {
		System.out.println("Verify alert messege for password when value is not provided");
		String pass = password.getAttribute("value");
		password.clear();
		scrollElement(button);
		button.click();
		alertText("password is mandatory field.", 10);
		password.sendKeys(pass);
	}

	//TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
	void testCase11() {
		System.out.println("verify the password is less than 5 character is what");
		String pass = password.getAttribute("value");
		password.clear();
		password.sendKeys("htg");
		scrollElement(button);
		button.click();
		alertText("password length should be greater then 5 characters.", 11);
		password.clear();
		password.sendKeys(pass);

	}

	//TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
	void testCase12() {
		System.out.println("Verify alert message for re-password when re-password value not provided");
		String repass = retypePassWord.getAttribute("value");
		retypePassWord.clear();
		scrollElement(button);
		button.click();
		alertText("please reenter password", 12);
		retypePassWord.sendKeys(repass);
	}

	//TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
	void testCase13() {
		System.out.println("Verify alert message for re-password is not matching with password entered");
		String repass = retypePassWord.getAttribute("value");
		retypePassWord.clear();
		retypePassWord.sendKeys("kjlknyjj");
		scrollElement(button);
		button.click();
		alertText("retype password donot match.", 13);
		retypePassWord.clear();
		retypePassWord.sendKeys(repass);
	}
	
	//TestCase14 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields
	void testCase14() {
		System.out.println("verify to click on terms and conditions");
		agreeTermsCond.click();
		scrollElement(button);
		button.click();
		alertText("Please agree to terms of service and privacy policy", 14);
		agreeTermsCond.click();
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment_4 assignment4 = new Assignment_4();
		assignment4.TestCase1();
		System.out.println("==========================================");
		assignment4.testCase2();
		System.out.println("==========================================");
		assignment4.testCase3();
		System.out.println("==========================================");
		assignment4.testCase4();
		System.out.println("==========================================");
		assignment4.testCase5();
		System.out.println("==========================================");
		assignment4.testCase6();
		System.out.println("==========================================");
		assignment4.testCase7();
		System.out.println("==========================================");
		assignment4.testCase8();
		System.out.println("==========================================");
		assignment4.testCase9();
		System.out.println("==========================================");
		assignment4.testCase10();
		System.out.println("==========================================");
		assignment4.testCase11();
		System.out.println("==========================================");
		assignment4.testCase12();
		System.out.println("==========================================");
		assignment4.testCase13();
		System.out.println("==========================================");
		assignment4.testCase14();
		System.out.println("==========================================");

	}

}
