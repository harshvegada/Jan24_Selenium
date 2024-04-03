package ankitaVitthalSambhare;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentNo1 {
	WebDriver driver;

	// Lanuch the automationbykrishna URL in chrome browser
	void launchUrl() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step1:- Lanuch the automationbykrishna URL in chrome browser");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("Url is sucessfully lanuch");

	}
	// Scnerio 1:- Verify that, user is sucessfully able to login when user enter
	// username and password length is more than 8 character on registration tab.

	void loginFunctionalityOnRegistrationTabPassMoreThan8Char() throws InterruptedException {
		launchUrl();

		System.out.println("Step2:- Click on the registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("User sucessfully clicked on the registration tab");

		Thread.sleep(2000);
		System.out.println("Step3:- Enter the user name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Ankita");
		System.out.println("user sucessfully entered user name");

		System.out.println("Step4:- Enter the password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Ankita@@12");
		System.out.println("user sucessfully entered password");

		System.out.println("Step5:- Clicked on the submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("user sucessfully clicked on the submit button");

		System.out.println("Step6:- get text from alert & compare the text");
		String excpetedresult = "Success!";
		Alert alert = driver.switchTo().alert(); // it is pointing to alert
		String actualresult = alert.getText();

		if (actualresult.equals(excpetedresult)) {
			System.out.println("Actual and Expected text matach!");
		} else {
			System.out.println("Test case failed!");
		}
		alert.accept(); // accept is a method to click on the ok button on alert pop up
		System.out.println("Alert pop-up closed sucessfully");

		driver.quit();

	}

	//// Scnerio 2:- Verify that, user is sucessfully able to login when user enter
	// username and password length is less than 8 character on registration tab.

	void loginFunctionalityOnRegistrationTabPassLessThan8Char() throws InterruptedException {
		launchUrl();

		System.out.println("Step2:- Click on the registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("User sucessfully clicked on the registration tab");

		Thread.sleep(2000);
		System.out.println("Step3:- Enter the user name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Ankita");
		System.out.println("user sucessfully entered user name");

		System.out.println("Step4:- Enter the password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Ankita");
		System.out.println("user sucessfully entered password");

		System.out.println("Step5:- Clicked on the submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("user sucessfully clicked on the submit button");

		System.out.println("Step6:- get text from alert & compare the text");
		String excpetedresult = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert(); // it is pointing to alert
		String actualresult = alert.getText();

		if (actualresult.equals(excpetedresult)) {
			System.out.println("Actual and Expected text matach!");
		} else {
			System.out.println("Test case failed!");
		}
		alert.accept(); // accept is a method to click on the ok button on alert pop up
		System.out.println("Alert pop-up closed sucessfully");

		driver.quit();

	}

	// Scenario3:-Verify that, user is able to fill all basic details and verify the
	// alert message verification for Alert demo on basic element tab.

	void handleAlertDemoOnBasicElementPage() throws InterruptedException {
		launchUrl();

		System.out.println("Step2:- Clicked on the Basic element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("User sucessfully clicked on the basic element tab");

		Thread.sleep(2000);
		System.out.println("Step3:- Enter the user name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Ankita");
		System.out.println("User sucessfully entered user name");

		System.out.println("Step4:- Enter the lastname");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Sambhare");
		System.out.println("User sucessfully entered last name");

		System.out.println("Step5:- Enter the Company name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("technocredits");
		System.out.println("User sucessfully entered company name");

		System.out.println("Step6:- Clicked on the submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("User sucessfully clicked on the submit button");

		System.out.println("Step7:- get text from alert & compare text");
		String firstname = "Ankita";
		String lastname = "Sambhare";
		String companyname = "technocredits";
		String excpetedresult = firstname + " and " + lastname + " and " + companyname;

		Alert alert = driver.switchTo().alert();
		String actualresult = alert.getText();
		System.out.println(excpetedresult);
		System.out.println(actualresult);

		if (actualresult.equals(excpetedresult)) {
			System.out.println("Actual and Expected text matach!");
		} else {
			System.out.println("Test case failed!");
		}
		alert.accept();
		System.out.println("Alert pop up closed sucessfully");
		driver.quit();

	}
	// Senario4:-Verify that, user is able to fill all basic details and verify the
	// alert message verification for basic forms on basic element tab.

	void fillUptheBasicFormOnBasicElementsTab() throws InterruptedException {

		launchUrl();
		System.out.println("Step2:- Clicked on the Basic element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("User sucessfully clicked on the basic element tab");

		Thread.sleep(2000);
		System.out.println("Step3:- Enter the email ID");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("Ankita");
		System.out.println("User sucessfully entered email ID");

		System.out.println("Step4:- Enter the password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Ankita@12");
		System.out.println("User sucessfully entered password");

		System.out.println("Step5:- Click on the checkbox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("User sucessfully clicked on the checkbox");

		System.out.println("Step6:- Click on the submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("User sucessfully clicked on the submit button");

		String ExpectedResult = "You successfully clicked on it";

		Alert alert = driver.switchTo().alert();
		String ActualResult = alert.getText();

		if (ExpectedResult.equals(ActualResult)) {
			System.out.println("Actual and Expected Text is match!");

		} else {
			System.out.println("text not match! please check text");
		}

		alert.accept();
		System.out.println("Alert pop up closed sucessfully");
		driver.quit();

	}

	// Senario5:-verify the alert message verification for alert box on basic
	// element tab.
	void alertOntheBasicElementPage() throws InterruptedException {
		launchUrl();

		System.out.println("Step2:- Clicked on the Basic element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("User sucessfully clicked on the basic element");
		Thread.sleep(5000);

		WebElement we = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", we);

		System.out.println("Step3:- click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("Step4:- Verify the alert message and click on the ok button");
		String ExpectedResult = "You must be TechnoCredits student!!";

		Alert alert = driver.switchTo().alert();
		String ActualResult = alert.getText();

		if (ExpectedResult.equals(ActualResult)) {
			System.out.println("Actual and expected text is match");
		} else {
			System.out.println("text not match");
		}

		alert.accept();
		System.out.println("Alert pop up closed sucessfully");
		driver.quit();

	}

	public static void main(String[] args) throws Exception {
		AssignmentNo1 ass1to5 = new AssignmentNo1();
		System.out.println(
				"----------Test Case1:- Login Functionality on the Registration Tab When password more than 8 char--------------------------");
		ass1to5.loginFunctionalityOnRegistrationTabPassMoreThan8Char();
		System.out.println(
				"----------Test Case2:- Login Functionality on the Registration Tab When password less than 8 char--------------------------");
		ass1to5.loginFunctionalityOnRegistrationTabPassLessThan8Char();
		System.out.println(
				"----------Test Case3:- Fill Up the Alert Demo Form and verify alert message--------------------------");
		ass1to5.handleAlertDemoOnBasicElementPage();
		System.out.println(
				"---------- Test Case4:- Fill Up the Alert Basic Form and verify alert message--------------------------");
		ass1to5.fillUptheBasicFormOnBasicElementsTab();
		System.out.println("----------Test Case5:- Text verification the Alert box--------------------------");
		ass1to5.alertOntheBasicElementPage();
	}
}
