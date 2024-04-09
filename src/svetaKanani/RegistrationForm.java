/*Assignment - 1 : 31st March'2024 
Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification*/
package svetaKanani;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationForm {

	WebDriver driver;
	void setup() {
		driver=new ChromeDriver();
		System.out.println("open browser..");
		driver.get("http://automationbykrishna.com/#");
		
	}
	
	public void testcase1() throws InterruptedException {
		System.out.println("----------TestCase 1----------");
		//open the browser and load URL
		setup();
		
		System.out.println("click on registration link ");
		System.out.println("maximize window..");
		driver.manage().window().maximize();
		
		System.out.println("Click on register..");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(1000);
		
		System.out.println("enter username..");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("sveta");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("sveta123@");
		
		System.out.println("Click on login button..");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		if(alert.getText().equals("Success!")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Oops Fail....!");
		}
		
		System.out.println("Alert Accept");
		alert.accept();
		
		System.out.println("Testcase 1 end");
		
	}
	public void testCase2() throws InterruptedException {
		System.out.println("----------TestCase 2----------");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("maximize window..");
		driver.manage().window().maximize();
		
		System.out.println("Click on register..");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		System.out.println("enter username..");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("sveta");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("1234");
		
		System.out.println("Click on login button..");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert = driver.switchTo().alert();
		
		if(alert.getText().equals("Failed! please enter strong password")) {
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Oops Fail....!");
		}
		
		System.out.println("Accept alert..");
		alert.accept();
		
		System.out.println("Testcase 2 end");
		
	}
	
	public void testCase3() throws InterruptedException {
		
		System.out.println("----------TestCase 3----------");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("maximize window..");
		driver.manage().window().maximize();
		
		System.out.println("Click on Basic Element..");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		System.out.println("Enter first name..");
		WebElement fname = driver.findElement(By.xpath("//input[@placeholder='Enter User Firstname']"));
		fname.sendKeys("Sveta");
		
		System.out.println("Enter last name..");
		WebElement lname =driver.findElement(By.xpath("//input[@name='ulname']"));
		lname.sendKeys("Kanani");
		
		System.out.println("Enter Company name..");
		WebElement cname =driver.findElement(By.xpath("//input[@id='UserCompanyName']"));
		cname.sendKeys("TCS");
		
		System.out.println("click on Submit button..");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		if(alert.getText().equals("Sveta and Kanani and TCS")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Oops Fail....!");
		}
		
		alert.accept();
		System.out.println("Testcse 3 end");
	}
	
	public void testCase4() throws InterruptedException {
		System.out.println("----------TestCase 4----------");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("maximize window..");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		System.out.println("Click on Basic Element..");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		System.out.println("Enter Email Address..");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("Sveta");
		
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Kanani123");
		
		
		System.out.println("click on checkbox..");
		driver.findElement(By.xpath("//div[@class='panel-body']//input[@type='checkbox']")).click();
		
		System.out.println("click on Submit button..");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		
		
		System.out.println("Switch  on Alert..");
		Alert alert = driver.switchTo().alert();
		
		if(alert.getText().equals("You successfully clicked on it")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Oops Fail....!");
		}
		
		alert.accept();
		System.out.println("Testcast 4 end");
	}
	
	void testcase5() throws InterruptedException {
		System.out.println("----------TestCase 5----------");
		driver.get("http://automationbykrishna.com/#");
		
		driver.manage().window().maximize();
		System.out.println("Click on Basic Element..");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//scroll using javascriptExecuter if element not visible in current screen
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0,250)");
		
		System.out.println("click Alert button..");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		System.out.println("Switch to alert pop-up");
		Alert alert =driver.switchTo().alert();
		
		if(alert.getText().equals("You must be TechnoCredits student!!")) {
			System.out.println("Test Pass!");
		}
		else {
			System.out.println("Oops fail..!");
		}
		
		System.out.println("Accept the Alert..");
		alert.accept();
		
		System.out.println("browser closed..");
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		
		RegistrationForm register=new RegistrationForm();
		
		register.testcase1();
		register.testCase2();
		register.testCase3();
		register.testCase4();
		register.testcase5();
		

	}

}
