package phenolVerma;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateKrishna {

	// Creating Chrome webdriver object
	WebDriver driver;

	void OpenBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com");
		System.out.println("Opening URL");
		Thread.sleep(2000);
	}

	void CreateDriver() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();
		System.out.println("Clicking on Registration link");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("maulik");
		System.out.println("Entering Username");

		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("maulik12345");
		System.out.println("Entering Password");

		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();
		System.out.println("Clicking on Login button");
	}

	void AlertNotHandeled() throws InterruptedException {

		OpenBrowser();
		CreateDriver();

		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).clear();
		System.out.println("Clearing the username");

		driver.close();
	}

	void AlertHandeled() throws InterruptedException {
		OpenBrowser();

		CreateDriver();

		// Catching Alert message window
		Alert alert = driver.switchTo().alert();
		System.out.println("Got the Alret window");

		// Getting the alert message
		String alertText = alert.getText();
		if (alertText.equals("Success!")) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}

		// Accepting the alert message
		alert.accept();
		System.out.println("Alret message window closed");

		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).clear();
		System.out.println("Clearing the username");
		driver.close();
	}

	void AlertDemo() throws InterruptedException {

		// createDriver();
		OpenBrowser();

		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"UserFirstName\"]")).sendKeys("Phenol");
		driver.findElement(By.xpath("//input[@id=\"UserLastName\"]")).sendKeys("Verma");
		driver.findElement(By.xpath("//input[@id=\"UserCompanyName\"]")).sendKeys("TechnoCredits");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();

		driver.close();
	}

	void BasicForm() throws InterruptedException {

		OpenBrowser();

		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).sendKeys("phenol.verma@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("phenol");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();

		driver.close();
	}

	void DifferentExpamleOfAlret() throws InterruptedException {
		OpenBrowser();
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		// Scrolling down the window by 500 pixel
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		if (alertText.equals("You must be TechnoCredits student!!")) {
			System.out.println("Text case Passed!");
		} else {
			System.out.println("Text case failed!");
		}
		alert.accept();
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		AutomateKrishna automateKrishna = new AutomateKrishna();
		// automateKrishna.AlertHandeled();
		// automateKrishna.AlertDemo();
		// automateKrishna.BasicForm();
		// automateKrishna.AlertNotHandeled();
		automateKrishna.DifferentExpamleOfAlret();

	}
}
