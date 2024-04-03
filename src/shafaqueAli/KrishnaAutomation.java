package shafaqueAli;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KrishnaAutomation {

//		  TestCase1 - Registration page alert message check for password more than 8 characters

	void TestCase1() throws InterruptedException

	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP1 :Browser is opened and URL is launched");

		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP2 : Clicked on Registration");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Krishna");
		System.out.println("STEP3: Username Entered");

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Abcd123436");
		System.out.println("STEP4: password Entered");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP5 :clicked on submit");

		Alert alert = driver.switchTo().alert();
		String Expectedtext = "Success!";
		String Actualtext = alert.getText();

		if (Actualtext.equals(Expectedtext)) {
			;
			System.out.println("STEP6: Sucess Test case");
		} else {
			System.out.println("STEP6: Failed Test case");
		}

		alert.accept();

		// driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.quit();
		System.out.println("STEP7:Program Quit");

	}
//		TestCase2 - Registration page alert message check for password less than 8 characters

	void TestCase2() throws InterruptedException

	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP1 :Browser is opened and URL is launched");

		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP2 : Clicked on Registration");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Krishna");
		System.out.println("STEP3: Username Entered");

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Abcd");
		System.out.println("STEP4: password Entered");

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP5 :clicked on submit");

		Alert alert = driver.switchTo().alert();
		String Expectedtext = "Success!";
		String Actualtext = alert.getText();

		if (Actualtext.equals(Expectedtext)) {
			;
			System.out.println("STEP6: Sucess Test case");
		} else {
			System.out.println("STEP6: Failed Test case");
		}

		alert.accept();

		// driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.quit();
		System.out.println("STEP7:Program Quit");
	}

//		TestCase3 - Basic elements Page - AlertDemo - alert message verification

	void TestCase3() throws InterruptedException {
		String firstname = "Shafaque";
		String lastname = "Ali";
		String companyname = "techno";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP1 :Browser is opened and URL is launched");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP2 :Clicked on Basic Elements tab");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstname);
		System.out.println("STEP3: FirstName Entered");

		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastname);
		System.out.println("STEP3: LastName Entered");

		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyname);
		System.out.println("STEP3: CompanyName Entered");

		driver.findElement(By.xpath("//button[@onclick ='myFunctionPopUp()'] ")).click();
		System.out.println("STEP4: Submit a form");

		Alert alert = driver.switchTo().alert();
		String Expectedtext = firstname + " and " + lastname + " and " + companyname;
		String Actualtext = alert.getText();
		System.out.println(Expectedtext);

		if (Actualtext.equals(Expectedtext)) {
			;
			System.out.println("STEP5: Sucess Alert");
		} else {
			System.out.println("STEP5: Failed Alert");
		}

		alert.accept();
		driver.quit();
		System.out.println("STEP6:Program Quit");
	}

//		TestCase4 - Basic elements Page - BASIC FORMS - alert message verification

	void TestCase4() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP1: Browser is opened and URL is launched");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP2: Clicked on BasicForms");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("abc@gmail.com");
		System.out.println("STEP3:Email entered");

		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("abc@12345");
		System.out.println("STEP4:pwd entered");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Alert alert = driver.switchTo().alert();
		String Expectedtext = "You successfully clicked on it";
		String Actualtext = alert.getText();
		System.out.println(Expectedtext);

		if (Actualtext.equals(Expectedtext)) {
			;
			System.out.println("STEP5: Sucess Alert");
		} else {
			System.out.println("STEP5: Failed Alert");
		}

		alert.accept();
		driver.quit();
		System.out.println("STEP6:Program Quit");
	}

//		TestCase5 - Basic elements Page - Alert button - alert message verification

	void TestCase5() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP1:Browser is opened and URL is launched");

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP2:Clicked on BasicForms");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP3:Clicked on Alter button");

		Alert alert = driver.switchTo().alert();
		String Expectedtext = "You must be TechnoCredits student!!";
		String Actualtext = alert.getText();
		System.out.println(Expectedtext);

		if (Actualtext.equals(Expectedtext)) {
			;
			System.out.println("STEP4: Sucess Alert");
		} else {
			System.out.println("STEP4: Failed Alert");
		}

		alert.accept();
		driver.quit();
		System.out.println("STEP5:Program Quit");
	}

	public static void main(String[] args) throws InterruptedException {
		KrishnaAutomation krishnaAutomation = new KrishnaAutomation();
		// krishnaAutomation.TestCase1();
		// krishnaAutomation.TestCase2();
		// krishnaAutomation.TestCase3();
		// krishnaAutomation.TestCase4();
		krishnaAutomation.TestCase5();

	}
}
