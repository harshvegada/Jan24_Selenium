/*Without handling alertmessage clear the username
 */


package sasmitaSahu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automate {

	void clearTheUsername() throws InterruptedException {
		System.out.println("STEP-Lunch the chrome driver");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP-hit url");
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		System.out.println("STEP-Click on Registration button");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);
		System.out.println("STEP-Enter the username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("sasmita");
		System.out.println("STEP-Enter the password");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123sasmita");
		System.out.println("STEP-Click on Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Verify the alert message");
		String expectedText = "Success!";
		System.out.println("Step-Switch to alert message window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert window open");
		String actualText = alert.getText();
		System.out.println("Verify Actualalerttext with Expectedalerttext");
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		System.out.println("Clear the username before closing the alert message ");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();

	}

	public static void main(String[] args) throws InterruptedException {
		Automate automate = new Automate();
		automate.clearTheUsername();

	}

}