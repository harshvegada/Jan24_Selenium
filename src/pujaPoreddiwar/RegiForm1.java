/* TestCase1- Open browser 
 * TestCase2- Registration page alert message check for password more than 8 characters
 * TestCase3- Registration page alert message check for password less than 8 characters
 * TestCase4- Basic elements Page - AlertDemo - alert message verification
 * TestCase5- Basic elements Page - BASIC FORMS - alert message verification
 * TestCase6- Basic elements Page - Alert button - alert message verification
 */

package pujaPoreddiwar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegiForm1 {

	WebDriver driver;
	String username = "Techno@123";
	String password8Char = "1234567891";
	String password4Char = "12345";
	String emailId = "technocredits@abc.com";
	String firstName = "Puja";
	String lastName = "Poreddiwar";
	String CompanyName = "Technocredits";

	void TestCase1() {
		System.out.println("STEP: Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Hit URL");
		driver.get("http://automationbykrishna.com/");
	}

	void TestCase2() throws InterruptedException {

		TestCase1();

		System.out.println("STEP: Click on Registration Link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		System.out.println("STEP: Enter text into Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);

		System.out.println("STEP: Enter text into paassword more than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password8Char);

		System.out.println("STEP: click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP: Switch to alert and get text from it");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = "Success!";

		System.out.println("VERIFY: Alert message is same as expected or not");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP: (Success!) Alert popup closed");
		alert.accept();

		
	}

	void TestCase3() throws InterruptedException {

		TestCase1();

		System.out.println("STEP: Click on Registration Link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		System.out.println("STEP: Enter text into Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);

		System.out.println("STEP: Enter text into paassword less than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password4Char);

		System.out.println("STEP: click on Submit Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("STEP: Switch to alert and get text from it");
		String expectedText = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert();
		String actualText = "Failed! please enter strong password";

		System.out.println("VERIFY: Alert message is same as expected or not");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP: (Failed! please enter password) Alert popup closed");
		alert.accept();

		driver.close();
	}

	// ---------------------------Alert Demo ---------------
	void TestCase4() throws InterruptedException {

		TestCase1();

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
		String expectedText1 = firstName + "and" + lastName + "and" + CompanyName;

		Alert alert1 = driver.switchTo().alert();
		String actualText1 = alert1.getText();

		if (actualText1.equals(expectedText1)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		System.out.println("STEP: (AlertDemo) - Alert popup closed");
		alert1.accept();

		driver.close();

		Thread.sleep(3000);
	}

	// ----------------------------Basic Form ---------------
	void TestCase5() throws InterruptedException {

		TestCase1();

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
		String actualText2 = "You successfully clicked on it";

		if (actualText2.equals(expectedText2)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("STEP: (Basic Forms) Alert popup closed");
		alert2.accept();

		Thread.sleep(3000);
	}

	// -----------------------Alert button-------------

	void TestCase6() throws InterruptedException {

		WebElement alertElement = driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);

		System.out.println("STEP: click on Alert button");
		driver.findElement(By.xpath("//button[@onclick='callJavaScriptAlert()']")).click();

		System.out.println("STEP: Verify alert message and click on Alert ok button");
		String expectedText3 = "You must be TechnoCredits student!!";

		Alert alert3 = driver.switchTo().alert();
		String actualText3 = "You must be TechnoCredits student!!";

		System.out.println("VERIFY: Alert message is same as expected");
		if (actualText3.equals(expectedText3)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("STEP:(Alert button) Alert popup closed");
		alert3.accept();

		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		RegiForm1 automation1 = new RegiForm1();
		automation1.TestCase1();
		automation1.TestCase2();
		automation1.TestCase3();
		automation1.TestCase4();
		automation1.TestCase5();
		automation1.TestCase6();

		// System.out.println("=====================");
		// automation1.UnhandledAlertScenario();
	}

}
