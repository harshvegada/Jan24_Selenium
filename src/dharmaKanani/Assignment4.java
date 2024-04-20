/*
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
package dharmaKanani;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	
	void setUp(){
		driver = new ChromeDriver();
		System.out.println("open browser..");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	void testCase1() {
		setUp();
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Success";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();
		
		System.out.println("Testcast1 end..");
	}
	
	void testCase2() {
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Full name can't be blank";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();
		
		System.out.println("Browser close");
		System.out.println();
	}
	
	void testCase3() {	

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="address cannot be blank";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		System.out.println("Accept alert");
		alert.accept();
		
		System.out.println("Testcast3 end..");
		System.out.println();
	}
	
	void testCase4() {
		
		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
	
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
	
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
	
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
	
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
	
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
	
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
	
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
	
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
	
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
	
		String Expectedtxt="Please enter email id";
		Alert alert =driver.switchTo().alert();
	
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();
	
		System.out.println("Testcast4 end..");
		System.out.println();
	}
	
	void testCase5() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Please use correct email format";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		
		System.out.println("Accept alert");
		alert.accept();
		
		System.out.println("Testcast5 end..");
		System.out.println();
	}
	
	void testCase6() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Please enter City";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();
		
		System.out.println("Testcast6 end..");	
		System.out.println();
	}
	
	void testCase7() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Please enter your current organization";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();

		System.out.println("Testcast7 end..");
		System.out.println();
	}
	
	void testCase8() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Username is mandatory field.";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();

		System.out.println("Testcast8 end..");
		System.out.println();
	}
	
	void testCase9() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharma");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Username length should be greater then 5 characters.";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();

		System.out.println("Testcast9 end..");
		System.out.println();
	}
	void testCase10() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="password is mandatory field.";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();

		System.out.println("Testcast10 end..");
		System.out.println();
	}
	
	void testCase11() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
	
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="password length should be greater then 5 characters.";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();

		System.out.println("Testcast11 end..");
		System.out.println();
	}
	
	void testCase12() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
	
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
	
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
	
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
	
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
	
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
	
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
	
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
	
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
	
		String Expectedtxt="please reenter password";
		Alert alert =driver.switchTo().alert();
	
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();
		
		System.out.println("Testcast12 end..");
		System.out.println();
	}
	
	void testCase13() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma");
		
		System.out.println("check Checkbox...");
		driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="retype password donot match.";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();

		System.out.println("Testcast13 end..");
		System.out.println();
	}
	
	void testCase14() {

		System.out.println("click on registration link ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		System.out.println("ENter Full name..");
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("dharma kanani");
		
		System.out.println("Enter Address...");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Email id...");
		driver.findElement(By.xpath("//input[@placeholder='Other Email ID']")).sendKeys("dharma@gmail.com");
		
		System.out.println("Enter City name..");
		driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("Jamnagar");
		
		System.out.println("Enter Company Name..");
		driver.findElement(By.xpath("//input[@placeholder='Company Name/Student']")).sendKeys("UPET");
		
		System.out.println("Select radio button");
		driver.findElement(By.xpath("//label/input[@id='radio-02']")).click();
		
		System.out.println("Enter Username..");
		driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("dharmakanani");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("dharma123");
		
		System.out.println("Enter Repassword..");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("dharma123");
		
		System.out.println("click on Signin");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		
		String Expectedtxt="Please agree to terms of service and privacy policy";
		Alert alert =driver.switchTo().alert();
		
		System.out.println("Verify alert text..");
		if(alert.getText().equals(Expectedtxt)) {
			System.out.println("Success!");
		}else {
			System.out.println("Fail!");
		}
		System.out.println("Accept alert");
		alert.accept();
		
		driver.quit();
		System.out.println("Testcast14 end..");
	}
	
	public static void main(String[] args) {
		Assignment4 ass_4 = new Assignment4();
		ass_4.testCase1();
		ass_4.testCase2();
		ass_4.testCase3();
		ass_4.testCase4();
		ass_4.testCase5();
		ass_4.testCase6();
		ass_4.testCase7();
		ass_4.testCase8();
		ass_4.testCase9();
		ass_4.testCase10();
		ass_4.testCase11();
		ass_4.testCase12();
		ass_4.testCase13();
		ass_4.testCase14();
	}
}	

	