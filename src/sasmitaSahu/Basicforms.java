/*Basic Forms automate
 */
package sasmitaSahu;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basicforms {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP-hit url");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Click on basicelemnt");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("Enter email address");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("sasmitasahu23@gmail.com");
		System.out.println("Enter password");
		driver.findElement(By.id("pwd")).sendKeys("123sahu123");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("click on submit button");
		driver.findElement(By.id("submitb2")).click();
		String expectedText = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert window open");
		String actualText = alert.getText();
		System.out.println("Verify Actualalerttext with Expectedalerttext");
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		
	}

	}




	


