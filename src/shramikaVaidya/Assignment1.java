package shramikaVaidya;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	WebDriver driver;
	String username = "Techno@123";
	String password8char = "123456719";
	String password4char = "12345";
	String email_id = "savi172@gmail.com";
	String firstName = "shramika";
	String lastName = "Vaidya";
	String companyName = "Amazon";

	void testCase2() throws InterruptedException {

		System.out.println("step1: Launch Brouser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("step 2 : Hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step3: click on Registration link");

		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		Thread.sleep(2000);

		System.out.println("Step4: Enter Text into UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);

		System.out.println("Step5: Enter Text into Password more than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password8char);

		System.out.println("Step5: click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Step6: Switch to alert and get Text");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = "success!";

		System.out.println("Step7 : Verify Alert message is same as Expected or not");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("step 8: (Success!) Alert Popup Closed");
		alert.accept();
		driver.quit();
	}

//-----------------------------------------------------------------------------------------------------------------------		
	void testCase3() throws InterruptedException {

		System.out.println("step1: Launch Brouser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("step 2 : Hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step3: click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(5000);

		System.out.println("Step4: Enter Text into UserName");
		driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(username);

		System.out.println("Step5: Enter Text into Password more than  characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password4char);

		System.out.println("Step5: click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Step6: Switch to alert and get Text");
		String expectedText = "Failed";
		Alert alert = driver.switchTo().alert();
		String actualText = "Failed";

		System.out.println("Step7 : Verify Alert message is same as Expected or not");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("step 8: (Failed.. please enter password) Alert Popup Closed");
		alert.accept();
		driver.quit();
	}

//-------------------------------------------------------------------------------------------------------------------------------	
	void testCase4() throws InterruptedException {

		System.out.println("step1: Launch Brouser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("step 2 : Hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("step1 : Click on basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);

		System.out.println("step2 : Enter FirstName");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);

		System.out.println("step3 : Enter LastName");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);

		System.out.println("step4 : Enter ComapnyName");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(companyName);

		System.out.println("strep 5 : click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		System.out.println(" step6 : verify message and click Alert on Button");
		String expectedText1 = firstName + "and" + lastName + "and" + companyName;

		Alert alert1 = driver.switchTo().alert();
		String actualText1 = alert1.getText();

		System.out.println("Step7 : Verify Alert message is same as Expected or not");

		if (actualText1.equals(expectedText1)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("step 8: (AlertDemo) Alert Popup Closed");
		alert1.accept();
		driver.quit();

	}
//---------------------------------------------------------------------------------------------------------------------		

	void testCase5() throws InterruptedException {

		System.out.println("step1: Launch Brouser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("step 2 : Hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("step1 : Click on basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);

		System.out.println("step2 : Enter basic form details ");
		System.out.println("enter email address");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(email_id);

		System.out.println("step3 : Enter password");
		driver.findElement(By.id("pwd")).sendKeys(password8char);

		System.out.println("step4 : Select CheckBox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();

		System.out.println("strep 5 : click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		System.out.println(" step6 : verify message and click Alert on Button");
		String expectedText2 = "you succesfully clicked on it";

		Alert alert2 = driver.switchTo().alert();
		String actualText2 = "you succesfully clicked on it";

		System.out.println("Step7 : Verify Alert message is same as Expected or not");

		if (actualText2.equals(expectedText2)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("step 8: (BasicForm) Alert Popup Closed");
		alert2.accept();
		driver.quit();
	}

	// ----------------------------------------------------------------------------------------------------------------------------

	void testCase6() throws InterruptedException {

		System.out.println("step1: Launch Brouser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("step 2 : Hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step 2: Click on basic elements ");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);

		System.out.println("step1 : Click on Alert button");
		driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']")).click();

		System.out.println(" step2 : verify message and click Alert on Button");
		String expectedText3 = "you must be technocredits student";

		Alert alert3 = driver.switchTo().alert();
		String actualText3 = alert3.getText();

		System.out.println("Step7 : Verify Alert message is same as Expected or not");
		if (actualText3.equals(expectedText3)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("step 8: (Alert button) Alert Popup Closed");
		alert3.accept();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment1 assignment1 = new Assignment1();
		assignment1.testCase2();
		System.out.println("-------------------------------------");
		assignment1.testCase3();
		System.out.println("----------------------------------------");
		assignment1.testCase4();
		System.out.println("-----------------------------------------");
		assignment1.testCase5();
		System.out.println("------------------------------------------");
		assignment1.testCase6();
	}
}
