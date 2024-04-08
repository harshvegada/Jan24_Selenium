package dharmaKanani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormEx1 {
	
	WebDriver driver;
	String username = "Techno@123";
	String password8Char = "12345678@#";
	String password6Char = "1234@#";
	String emailId = "technocredits1@gmail.com";
	String firstName = "Dharma";
	String lastName = "Kanani";
	String CompanyName = "Technocredits";
	
	void setUp() {
		driver = new ChromeDriver();
		System.out.println("STEP: Launch chrome Browser");
		driver.manage().window().maximize();

		System.out.println("STEP: Hit URL");
		driver.get("http://automationbykrishna.com/#");
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	void Case1() throws InterruptedException {

		setUp();
		System.out.println("STEP: Click on Registration Link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		Thread.sleep(2000);
		System.out.println("STEP: Enter text into Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);

		System.out.println("STEP: Enter text into paassword more than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password8Char);

		System.out.println("STEP: click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP: Switch to alert and get text from it");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("VERIFY: Alert message is same as expected or not");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP:Alert Accepted");
		alert.accept();
		driver.quit();
	}

	void Case2() throws InterruptedException {

		setUp();

		System.out.println("STEP: Click on Registration Link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);

		System.out.println("STEP: Enter text into Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);

		System.out.println("STEP: Enter text into paassword less than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password6Char);

		System.out.println("STEP: click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP: Switch to alert and get text from it");
		String expectedText = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("VERIFY: Alert message is same as expected or not");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP:Alert Accepted");
		alert.accept();

		driver.quit();
	}

	// ---------------------------Alert Demo ---------------
	void Case3() throws InterruptedException {

		setUp();

		Thread.sleep(5000);

		System.out.println("STEP: Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);

		System.out.println("STEP: Enter First Name");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);

		System.out.println("STEP: Enter Last Name");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);

		System.out.println("STEP: Enter Company Name");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(CompanyName);

		System.out.println("STEP: Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		System.out.println("STEP: Verify alert message and click on Alert ok button");
		String expectedText1 = firstName + " and " + lastName + " and " + CompanyName;

		Alert alert1 = driver.switchTo().alert();
		String actualText1 = alert1.getText();

		if (actualText1.equals(expectedText1)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP: Alert Accepted");
		alert1.accept();

		driver.quit();
	}

	// ----------------------------Basic Form ---------------
	void Case4() throws InterruptedException {

		setUp();

		Thread.sleep(5000);

		System.out.println("STEP: Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);

		System.out.println("STEP: enter Basic Forms details");
		System.out.println("STEP: enter Email address");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(emailId);

		System.out.println("STEP: enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password8Char);

		System.out.println("STEP: select checkbox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();

		System.out.println("STEP: click on submit button");
		driver.findElement(By.xpath("//button[@onclick=\"myFunction()\"]")).click();

		System.out.println("STEP: Verify alert message and click on Alert ok button");
		String expectedText2 = "You successfully clicked on it";

		Alert alert2 = driver.switchTo().alert();
		String actualText2 = alert2.getText();

		if (actualText2.equals(expectedText2)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("STEP: Alert Accepted");
		alert2.accept();

		Thread.sleep(3000);
		driver.quit();
	}

	// -----------------------Alert button-------------

	void Case5() throws InterruptedException {

		setUp();

		Thread.sleep(2000);

		System.out.println("STEP: Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);

		System.out.println("STEP: click on Alert button");
		driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']")).click();

		System.out.println("STEP: Verify alert message and click on Alert ok button");
		String expectedText3 = "You must be TechnoCredits student!!";

		Alert alert3 = driver.switchTo().alert();
		String actualText3 = alert3.getText();

		System.out.println("VERIFY: Alert message is same as expected");
		if (actualText3.equals(expectedText3)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("STEP: Alert Accepted");
		alert3.accept();

		driver.quit();

	}	
	public static void main(String[] args) throws InterruptedException {
		RegistrationFormEx1 registrationformex1 = new RegistrationFormEx1();
		registrationformex1.Case1();
		registrationformex1.Case2();
		registrationformex1.Case3();
		registrationformex1.Case4();
		registrationformex1.Case5();
	}
}
