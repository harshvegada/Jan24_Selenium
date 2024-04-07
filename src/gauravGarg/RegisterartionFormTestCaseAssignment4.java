package gauravGarg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterartionFormTestCaseAssignment4 {

	WebDriver wb;
	WebElement name;
	WebElement address;
	WebElement emailid;
	WebElement city;
	WebElement companyname;
	WebElement gender;
	WebElement username;
	WebElement password;
	WebElement reconfirmpassword;
	WebElement agrreement;
	WebElement button;
	JavascriptExecutor je;

	void loadBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.id("registration2")).click();
		System.out.println("Step 2-:. Click n registeration Tab");
		wb.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	void CheckAlertMessgae(String expected , int number)
	{
		Alert al=wb.switchTo().alert();
		String get =al.getText();
		if(get.equals(expected))
		{
			System.out.println("Test Case " + number+ "  Passed ");
		}else
		{
			System.out.println("Test Case " + number+ "  Failed ");
		}
		al.accept();
	}

	void testCase1() {
		loadBrowser();
		name = wb.findElement(By.xpath("//input[@id='fullName']"));
		name.sendKeys("Gaurav Garg");
		System.out.println("Step 3-:. Put a value at username FullName in Registration Forum");
		address = wb.findElement(By.xpath("//input[@id='address']"));
		address.sendKeys("B-13 moti lal ");
		// Address should be less than 20 character
		System.out.println("Step 4-:. Put a value at Address in Registration Forum");
		emailid = wb.findElement(By.xpath("//input[@id='useremail']"));
		emailid.sendKeys("gauravgarg9136@gmail.com");
		System.out.println("Step 5-:. Put a value at email Id in Registration Forum");
		city = wb.findElement(By.xpath("//input[@id='usercity']"));
		city.sendKeys("Adarsh nagar");
		System.out.println("Step 6-:. Put a value at City in Registration Forum");
		companyname = wb.findElement(By.xpath("//input[@id='organization']"));
		companyname.sendKeys("Tata Consultancy Service");
		System.out.println("Step 7-:. Put a value at Company Name in Registration Forum");
		gender = wb.findElement(By.xpath("//input[@id='radio-01']"));

		je = (JavascriptExecutor) wb;
		je.executeScript("arguments[0].scrollIntoView(true)", gender);

		gender.click();
		System.out.println("Step 8-:. Select a Gender in Registration Forum");
		username = wb.findElement(By.xpath("//input[@id='usernameReg']"));
		username.sendKeys("Gaurav9136");
		System.out.println("Step 9-:. Put a value at Username in Registration Forum");
		password = wb.findElement(By.xpath("//input[@id='passwordReg']"));
		password.sendKeys("Gaurav9136672078");
		System.out.println("Step 10-:. Put a value at password in Registration Forum");
		reconfirmpassword = wb.findElement(By.xpath("//input[@id='repasswordReg']"));
		reconfirmpassword.sendKeys("Gaurav9136672078");
		System.out.println("Step 10-:. Put a value at for re-type password in Registration Forum");
		agrreement = wb.findElement(By.xpath("//input[@id='signupAgreement']"));
		agrreement.click();
		System.out.println("Step 11-:. Read the Term and Condition in Registration Forum");
		button = wb.findElement(By.xpath("	//button[@id='btnsubmitsignUp']"));
		button.click();
		System.out.println("Step 12-:. Put a value to submt in Registration Forum");
		CheckAlertMessgae("Success",1);
	}

	void testCase2()
	{
		System.out.println();
		System.out.println("TestCase 2");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String name1=name.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", name);
		System.out.println("Step 2-:. Taking a Backup of Name in Registration Forum");
		name.clear();
		System.out.println("Step 3-: Empty the  name field");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Full name can't be blank",2);
		name.sendKeys(name1);
		System.out.println("Step 5-:. Send the value of name with Backup Value");
	}
	
	void testCase3()
	{
		System.out.println();
		System.out.println("TestCase 3");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String address1=address.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", address);
		System.out.println("Step 2-:. Taking a Backup of address in Registration Forum");
		address.clear();
		System.out.println("Step 3-: Empty the  address field");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("address cannot be blank",3);
		address.sendKeys(address1);
		System.out.println("Step 5-:. Send the value of address with Backup Value");
	}
	void testCase4()
	{
		System.out.println();
		System.out.println("TestCase 4");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String emailid1=emailid.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", emailid);
		System.out.println("Step 2-:. Taking a Backup of emailid in Registration Forum");
		emailid.clear();
		System.out.println("Step 3-: Empty the  email field");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Please enter email id",4);
		emailid.sendKeys(emailid1);
		System.out.println("Step 5-:. Send the value of email with Backup Value");
	}
	void testCase5()
	{
		System.out.println();
		System.out.println("TestCase 5");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String emailid1=emailid.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", emailid);
		System.out.println("Step 2-:. Taking a Backup of emailid in Registration Forum");
		emailid.clear();
		emailid.sendKeys("gauerav777");
		System.out.println("Step 3-: Empty the  email field and enter incorect email id");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Please use correct email format",5);
		emailid.clear();
		emailid.sendKeys(emailid1);
		System.out.println("Step 5-:. Send the value of email with Backup Value");
	}
	
	void testCase6()
	{
		System.out.println();
		System.out.println("TestCase 6");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String city1=city.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", city);
		System.out.println("Step 2-:. Taking a Backup of city in Registration Forum");
		city.clear();
		System.out.println("Step 3-: Empty the  city field ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Please enter City",6);
		city.sendKeys(city1);
		System.out.println("Step 5-: Send the value of city with Backup Value");
	}
	
	void testCase7()
	{
		System.out.println();
		System.out.println("TestCase 7");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String companyname1=companyname.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", companyname);
		System.out.println("Step 2-:. Taking a Backup of companyname in Registration Forum");
		companyname.clear();
		System.out.println("Step 3-: Empty the  companyname field ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Please enter your current organization",7);
		companyname.sendKeys(companyname1);
		System.out.println("Step 5-: Send the value of companyname with Backup Value");
	}
	
	void testCase8()
	{
		System.out.println();
		System.out.println("TestCase 8");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String username1=username.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		System.out.println("Step 2-:. Taking a Backup of username in Registration Forum");
		username.clear();
		System.out.println("Step 3-: Empty the username field ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Username is mandatory field.",8);
		username.sendKeys(username1);
		System.out.println("Step 5-: Send the value of username with Backup Value");
	}
	
	void testCase9()
	{
		System.out.println();
		System.out.println("TestCase 9 -username is less than 5 character");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String username1=username.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		System.out.println("Step 2-:. Taking a Backup of username in Registration Forum");
		username.clear();
		username.sendKeys("gaur");
		System.out.println("Step 3-: Empty the username field and send new username wit length lesss than 5 character ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("Username length should be greater then 5 characters.",9);
		username.clear();
		username.sendKeys(username1);
		System.out.println("Step 5-: Send the value of username with Backup Value");
	}
	
	void testCase10()
	{
		System.out.println();
		System.out.println("TestCase 10 ");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String password1=password.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		System.out.println("Step 2-:. Taking a Backup of password in Registration Forum");
		password.clear();
		System.out.println("Step 3-: Empty the password field ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("password is mandatory field.",10);
		password.sendKeys(password1);
		System.out.println("Step 5-: Send the value of username with Backup Value");
	}
	void testCase11()
	{
		System.out.println();
		System.out.println("TestCase 11-password is less than 5 character ");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String password1=password.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)",password);
		System.out.println("Step 2-:. Taking a Backup of password in Registration Forum");
		password.clear();
		password.sendKeys("gau");
		System.out.println("Step 3-: Empty the password field ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("password length should be greater then 5 characters.",11);
		password.clear();
		password.sendKeys(password1);
		System.out.println("Step 5-: Send the value of username with Backup Value");
	}
	
	void testCase12()
	{
		System.out.println();
		System.out.println("TestCase 12 ");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String reconfirmpassword1=reconfirmpassword.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		System.out.println("Step 2-:. Taking a Backup of re-type in Registration Forum");
		reconfirmpassword.clear();
		System.out.println("Step 3-: Empty the re-type field ");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("please reenter password",12);
		reconfirmpassword.sendKeys(reconfirmpassword1);
		System.out.println("Step 5-: Send the value of re-type with Backup Value");
	}
	
	void testCase13()
	{
		System.out.println();
		System.out.println("TestCase 13- retype password donot match. ");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		String reconfirmpassword1=reconfirmpassword.getAttribute("value");
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		System.out.println("Step 2-:. Taking a Backup of re-type password in Registration Forum");
		reconfirmpassword.clear();
		reconfirmpassword.sendKeys("ddddddddd");
		System.out.println("Step 3-: Empty the re-type field and retype password which do not match.");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 4-: Now Submit the Test Case");
		CheckAlertMessgae("retype password donot match.",13);
		reconfirmpassword.clear();
		reconfirmpassword.sendKeys(reconfirmpassword1);
		System.out.println("Step 5-: Send the value of re-type with Backup Value");
	}
	
	void testCase14()
	{
		System.out.println();
		System.out.println("TestCase 14 ");
		System.out.println("Step 1-:. Add all the Value in Registration Forum");
		je.executeScript("arguments[0].scrollIntoView(true)", agrreement);
		agrreement.click();
		System.out.println("Step 2-:. Unclick the agrreement field in Registration Forum");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		System.out.println("Step 3-: Now Submit the Test Case");
		CheckAlertMessgae("Please agree to terms of service and privacy policy",14);
		agrreement.click();
		System.out.println("Step 4-: click the agrreement field in Registra tion Forum");
	}
	public static void main(String[] args) {
		RegisterartionFormTestCaseAssignment4 registerartionFormTestCaseAssignment4= new RegisterartionFormTestCaseAssignment4();
		registerartionFormTestCaseAssignment4.testCase1();
		registerartionFormTestCaseAssignment4.testCase2();
		registerartionFormTestCaseAssignment4.testCase3();
		registerartionFormTestCaseAssignment4.testCase4();
		registerartionFormTestCaseAssignment4.testCase5();
		registerartionFormTestCaseAssignment4.testCase6();
		registerartionFormTestCaseAssignment4.testCase7();
		registerartionFormTestCaseAssignment4.testCase8();
		registerartionFormTestCaseAssignment4.testCase9();
		registerartionFormTestCaseAssignment4.testCase10();
		registerartionFormTestCaseAssignment4.testCase11();
		registerartionFormTestCaseAssignment4.testCase12();
		registerartionFormTestCaseAssignment4.testCase13();
		registerartionFormTestCaseAssignment4.testCase14();
	}
}
