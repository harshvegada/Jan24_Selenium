/*Alertmessage Forms 
 */
package sasmitaSahu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertmessage {

	void alert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP-hit url");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Click on basicelemnt");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement alertElement = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		String expectedText = "You must be TechnoCredits student!!";
		System.out.println("Step-Switch to alert message window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert window open");
		String actualText = alert.getText();
		System.out.println("Verify Actualalerttext with Expectedalerttext");
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");

		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Alertmessage compareAlert = new Alertmessage();
		compareAlert.alert();
	}

}