/*Assignment - 2 : 2nd April'2024

Step 1 : Launch browser and hit https://facebook.com
Step 2 : Click on Create Account button
Step 3 : Enter appropiate value in all textbox. 
Step 4 : Select Date from Date dropdown
Step 5 : Select Month
Step 6 : Select Year
Step 7 : Verify Selected value of month with expected value
Step 8 : Verify Selected value of date with expected value
Step 9 : Verify Selected value of year with expected value  */
package madhuraKulkarni;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment2 {

	WebDriver launchBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("Browser launched...");
		return driver;
	}

	void verifyCreateNewAccount() throws InterruptedException {
		WebDriver driver = launchBrowser();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@rel='async']")).click();
		System.out.println("Clicked on Create new Account button...");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Madhura");
		System.out.println("Entered first name...");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kulkarni");
		System.out.println("Entered last name...");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("madhura.test@gmail.com");
		System.out.println("Entered email address...");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("madhura.test@gmail.com");
		System.out.println("Re-entered email address...");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("madhura&test123");
		System.out.println("Entered password...");
		WebElement e1 = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(e1);
		daySelect.selectByIndex(4);
		System.out.println("Entered Day...");

		WebElement e2 = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(e2);
		monthSelect.selectByVisibleText("Aug");
		System.out.println("Entered month...");

		WebElement e3 = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(e3);
		yearSelect.selectByValue("1990");
		System.out.println("Entered year...");
		System.out.println("--------Success--------");
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment2().verifyCreateNewAccount();
	}

}
