package sasmitaSahu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	WebDriver driver;
	WebElement FullName;
	WebElement Address;
	WebElement EmailId;
	WebElement City;
	WebElement CompanyName;
	WebElement gender;
	WebElement username;
	WebElement password;
	WebElement RetypePassword;
	WebElement Agreement;
	WebElement button;
	JavascriptExecutor je;
	
	void Bowserload() throws InterruptedException {
		System.out.println("STEP1-Launch the ChromeBowser");
		 driver = new ChromeDriver();
		
		System.out.println("STEP2-Maximise the ChromeBowser");
		driver.manage().window().maximize();
		
		System.out.println("STEP3-hit the url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP4-Click on registration button");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	void alertMessageCheck(String expectedText, int number) {
		System.out.println("Step5-Switch to alert message window");
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Alert window open");
		String actualText = alert.getText();
		alert.accept();
		
		System.out.println("Verify Actualalerttext with Expectedalerttext");
		if (actualText.equals(expectedText)) {
			System.out.println("Test case" + number + " passed");
		}else {
		
			System.out.println("Test case" + number + " failed ");
	}
		
	}
	
	void testCase1() throws InterruptedException {
		Bowserload();
		
		System.out.println("Step6-Enter fullname");
		FullName= driver.findElement(By.xpath("//input[@name='fName']"));
		FullName.sendKeys("sasmita");
		
		
		System.out.println("Step7-Enter Address");
		Address=driver.findElement(By.xpath("//input[@id='address']"));
		Address.sendKeys("Mantra moments");
		
		System.out.println("Step8-Enter EmailId");
		EmailId=driver.findElement(By.xpath("//input[@id='useremail']"));
		EmailId.sendKeys("sasmitasahu23@gmail.com");
		
		System.out.println("Step9-Enter City");
		City=driver.findElement(By.xpath("//input[@id='usercity']"));
		City.sendKeys("pune");
		
		System.out.println("Step10-Enter company name ");
		CompanyName=driver.findElement(By.xpath("//input[@id='organization']"));
		CompanyName.sendKeys("Novac");
		
		System.out.println("Step11-Enter gender");
		gender=driver.findElement(By.xpath("//label[@for='radio-01']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", gender);
		gender.click();
		
		System.out.println("Step12-Enter username");
		username=driver.findElement(By.xpath("//input[@id='usernameReg']"));
		username.sendKeys("sasmita123");
		
		System.out.println("Step12-Enter password");
		password=driver.findElement(By.xpath("//input[@id='passwordReg']"));
		password.sendKeys("samsita");
		
		System.out.println("Step13-Enter RetypePassword");
		RetypePassword=driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		RetypePassword.sendKeys("samsita");
		
		System.out.println("Step14-click on Agreement");
		Agreement=driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		Agreement.click();
		
		System.out.println("Step15-click on submit button");
		button=driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		button.click();
		
		alertMessageCheck("Success",1);
	}
	
	void testcase2(){
		System.out.println("Verify the alert message when fullname filed is blank");
		String FullName1 =FullName.getAttribute("value");
		System.out.println(FullName1);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", FullName);
		FullName.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Full name can't be blank",2);
		FullName.sendKeys(FullName1);
	}
	
	void testcase3(){
		System.out.println("Verify the alert message when Address filed is blank");
		String Address1 =Address.getAttribute("value");
		System.out.println(Address);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", Address);
		Address.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("address cannot be blank",3);
		Address.sendKeys(Address1);
	}
	
	void testcase4(){
		System.out.println("Verify the alert message when email field is blank");
		String EmailId1 =EmailId.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", EmailId);
		EmailId.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Please enter email id",4);
		EmailId.sendKeys(EmailId1);
	}
	void testcase5(){
		System.out.println("Verify the alert message when email field is wrong format");
		String EmailId1 =EmailId.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", EmailId);
		EmailId.clear();
		EmailId.sendKeys("sasmita8999");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Please use correct email format",5);
		EmailId.sendKeys(EmailId1);
	}
	void testcase6(){
		System.out.println("Verify the alert message when City field is blank");
		String City1 =City.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", City);
		City.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Please enter City",6);
		City.sendKeys(City1);
	}
	
	void testcase7(){
		System.out.println("Verify the alert message when CompanyName field is blank");
		String CompanyName1 =CompanyName.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", CompanyName);
		CompanyName.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Please enter your current organization",7);
		CompanyName.sendKeys(CompanyName1);
	}
	
	void testcase8(){
		System.out.println("Verify the alert message when username field is blank");
		String username1 =username.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		username.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Username is mandatory field.",8);
		username.sendKeys(username1);
	}
	
	void testcase9(){
		System.out.println("Testcase9-Verify alert message for username less then 5 charater");
		String username1 =username.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", username);
		username.clear();
		username.sendKeys("hgj");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Username length should be greater then 5 characters.",9);
		username.clear();
		username.sendKeys(username1);
	}
	void testcase10(){
		System.out.println("Testcase10-Verify alert message for password when password value not provided");
		String password1 =password.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", password);
		password.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("password is mandatory field.",10);
		password.sendKeys(password1);
	}
	void testcase11(){
		System.out.println("Testcase11-Verify alert message for password less then 5 character");
		String password1 =password.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", password);
		password.clear();
		password.sendKeys("fj");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("password length should be greater then 5 characters.",11);
		password.clear();
		password.sendKeys(password1);
	}
	void testcase12(){
		System.out.println("Testcase12-Verify alert message for re-password when re-password value not provided");
		String RetypePassword1 =RetypePassword.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", RetypePassword);
		RetypePassword.clear();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("please reenter password",12);
		RetypePassword.sendKeys(RetypePassword1);
	}
	void testcase13(){
		System.out.println("Testcase13-Verify alert message for re-password when password and re-password are not matching");
		String RetypePassword1 =RetypePassword.getAttribute("value");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", RetypePassword);
		RetypePassword.clear();
		RetypePassword.sendKeys("hfjfn");
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("retype password donot match.",13);
		RetypePassword.clear();
		RetypePassword.sendKeys(RetypePassword1);
	}
	void testcase14(){
		System.out.println("Testcase14-Verify alert message for Team and condition when Team and condition checkbox is not selected");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", Agreement);
		Agreement.click();
		je.executeScript("arguments[0].scrollIntoView(true)", button);
		button.click();
		alertMessageCheck("Please agree to terms of service and privacy policy",14);
		Agreement.click();
	}
	
	
		
	

	public static void main(String[] args) throws InterruptedException {
		Assignment4 assignment4= new Assignment4();
		assignment4.testCase1();
		assignment4.testcase2();
		assignment4.testcase3();
		assignment4.testcase4();
		assignment4.testcase5();
		assignment4.testcase6();
		assignment4.testcase7();
		assignment4.testcase8();
		assignment4.testcase9();
		assignment4.testcase10();
		assignment4.testcase11();
		assignment4.testcase12();
		assignment4.testcase13();
		assignment4.testcase14();
	}

}

