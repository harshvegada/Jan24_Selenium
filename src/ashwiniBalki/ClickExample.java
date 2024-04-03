package ashwiniBalki;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.internal.Require.ArgumentChecker;

import net.bytebuddy.asm.Advice.Argument;

public class ClickExample {

	// TestCase1 - Registration page alert message check for password more than 8
	// characters
	void loginAlertHandeled() throws InterruptedException {
		System.out.println("TestCase1 - Registration page alert message check for password more than 8 characters");
		System.out.println("Step1: Launch Chorme browser");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step2 : Hit URL");
		driver.get("http://automationbykrishna.com");

		driver.manage().window().maximize();

		System.out.println("Step3: Click registration link");
		driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();

		Thread.sleep(2000);

		System.out.println("Step4: enter text in username");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("mkanani1");

		System.out.println("Step 5: Enter text in password");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("123456789");

		System.out.println("Ster 6 : Click on login button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();

		System.out.println("Step 7: Switch to alert and get text from alert");
		String expectedText = "Success!";
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("Verify actual alert text with expected alert text");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("Step: Accept alert");
		alert.accept();

		System.out.println("Step: Close session");
		driver.quit();

	}

	// TestCase2 - Registration page alert message check for password less than 8
	// characters
	void loginalertNotHandled() throws InterruptedException {
		System.out.println("TestCase2 - Registration page alert message check for password less than 8 characters");
		System.out.println("Step1 : Launch Chorme browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step2 : Hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Step3 : Click registration link");
		driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();

		Thread.sleep(2000);

		System.out.println("Step 4 : Enter Username and invalid Password");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("Ashwini");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("sdew");

		System.out.println("Step 5 : Click on login button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();

		Thread.sleep(2000);

		System.out.println("Step 6 :Switch to alert and get text");
		String expectedText = "Failed! please enter strong password";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("Verify actual alert text with expected alert text");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("Step 7 : Accept alert");
		alert.accept();

		System.out.println("Step 8 : Close session");
		driver.quit();
	}

	// TestCase3 - Basic elements Page - AlertDemo - alert message verification
	void basicElement() throws InterruptedException {
		System.out.println(" TestCase3 - Basic elements Page - AlertDemo - alert message verification");
		System.out.println("Step 1 : Launch Chorme browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step 2 : Hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Step 3 : Click on Basic Element");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		Thread.sleep(2000);

		System.out.println("Step 4 : Add Firstname");
		driver.findElement(By.xpath("//input[@id=\"UserFirstName\"]")).sendKeys("Ashwini");

		System.out.println("Step 5 : Add LastName");
		driver.findElement(By.xpath("//input[@id=\"UserLastName\"]")).sendKeys("Balki");

		System.out.println("Step 6 : Add Company name");
		driver.findElement(By.xpath("//input[@id=\"UserCompanyName\"]")).sendKeys("Techno");

		System.out.println("Step 7 : Click on submit button");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		System.out.println("Step 8 :Switch to alert and get text");
		String expectedText = "Ashwini and Balki and Techno";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("Verify actual alert text with expected alert text");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("Step 9 : Accept alert");
		alert.accept();

		System.out.println("Step 10 : Close session");
		driver.quit();

	}

	// TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
	void basicForm() throws InterruptedException {
		System.out.println("TestCase4 - Basic elements Page - BASIC FORMS - alert message verification");
		System.out.println("Step 1 : Launch Chorme browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step 2 : Hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Step 3 : Click on Basic Element");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		Thread.sleep(2000);

		System.out.println("Step 4 : Enter email");
		driver.findElement(By.xpath("//input[@id= 'exampleInputEmail1']")).sendKeys("ashwinibodhe13@gmail.com");

		System.out.println("Step 5 : Enter Password");
		driver.findElement(By.xpath("//input[@id= 'pwd']")).sendKeys("Ashwini@123");

		System.out.println("Step 6 :Selct checkbox");
		driver.findElement(By.xpath("//div[ @name = 'secondSegment']//input[@type= 'checkbox']")).click();

		System.out.println("Step 7 : Click on submit button");
		driver.findElement(By.xpath("//button[@id= 'submitb2']")).click();

		System.out.println("Step 8 :Switch to alert and get text");
		String expectedText = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("Verify actual alert text with expected alert text");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}
		System.out.println("Step 9 : Accept alert");
		alert.accept();

		System.out.println("Step 10 : Close session");
		driver.quit();
	}

	// TestCase5 - Basic elements Page - Alert button - alert message verification
	void alertButton() throws InterruptedException {
		System.out.println(" TestCase5 - Basic elements Page - Alert button - alert message verification");
		System.out.println("Step 1 : Launch Chorme browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step 2 : Hit URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Step 3 : Click on Basic Element");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		Thread.sleep(2000);
		System.out.println("Step 4 :Click on Alert button");
		WebElement alertElement = driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);

		driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")).click();

		System.out.println("Step 5 :Switch to alert and get text");
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("Verify actual alert text with expected alert text");
		if (actualText.equals(expectedText)) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test fail");
		}

		System.out.println("Step 6 : Accept alert");
		alert.accept();

		System.out.println("Step 7 : Close session");
		driver.quit();

	}

	public static void main(String[] args) {
		ClickExample clickExample = new ClickExample();

		try {
			clickExample.loginAlertHandeled();
			clickExample.loginalertNotHandled();
			clickExample.basicElement();
			clickExample.basicForm();
			clickExample.alertButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
