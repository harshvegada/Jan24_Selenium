/*1. Registration Login
 *2. UnSuccessful Login
 */
package rupaliUmagol;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
	WebDriver driver;

	void getBrowser() {
		System.out.println("STEP : Open WebDriver");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize Browser");
		driver.manage().window().maximize();

		System.out.println("STEP : launch url");
		driver.get("http://automationbykrishna.com");
	}

	void getSuccuesslogin() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Click on Registration Tab");
		driver.findElement(By.id("registration2")).click();

		System.out.println("STEP : Wait for 2 seconds to load the page");
		Thread.sleep(2000);

		System.out.println("STEP : Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("mkanani");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123456789");

		System.out.println("STEP : Click on submit buton");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("VERIFY : Validate the Alert Message");
		Alert alert = driver.switchTo().alert();
		String expectedText = "Success!";

		String actualText = alert.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Test case passed !");
		} else
			System.out.println("Test case failed !");

		System.out.println("STEP : Accept the Alert");
		alert.accept();

		System.out.println("STEP : Close Browser");
		driver.quit();
	}

	void alertNotHandledAtlogin() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Click on Registration Tab");
		driver.findElement(By.id("registration2")).click();

		System.out.println("STEP : Wait for 2 seconds to load the page");
		Thread.sleep(2000);

		System.out.println("STEP : Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("mkanani");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123456789");

		System.out.println("STEP : Click on submit buton");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		System.out.println("STEP : Clear UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
	}
	
	void getUnSuccuesslogin() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Click on Registration Tab");
		driver.findElement(By.id("registration2")).click();

		System.out.println("STEP : Wait for 2 seconds to load the page");
		Thread.sleep(2000);

		System.out.println("STEP : Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("mkanani");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("12345");

		System.out.println("STEP : Click on submit buton");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("VERIFY : Validate the Alert Message");
		Alert alert = driver.switchTo().alert();
		String expectedText = "Success!";

		String actualText = alert.getText();
		if (actualText.equals(expectedText)) {
			System.out.println("Test case passed !");
		} else
			System.out.println("Test case failed !");

		System.out.println("STEP : Accept the Alert");
		alert.accept();

		System.out.println("STEP : Close Browser");
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		Registration launchChrome = new Registration();
		System.out.println("1 : Successful Login");
		launchChrome.getSuccuesslogin();
		//System.out.println("1 : When Alert is not Handled at the time of Login");
		//launchChrome.alertNotHandledAtlogin();
		
		System.out.println("2 : UnSuccessful Login");
		launchChrome.getUnSuccuesslogin();
	}
}
