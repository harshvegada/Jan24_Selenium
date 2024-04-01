/*AlertDemo Page
 */

package sasmitaSahu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bsicelemts {

	public static void main(String[] args) throws InterruptedException {
		String UserFirstName ="sasmita";
		String UserLastName="sahu";
		String UserCompanyName="Novac technologies";
		String ExpectedAlertMessage= UserFirstName+ " and "+UserLastName+" and "+UserCompanyName;
		System.out.println("STEP-Lunch the chrome driver");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP-hit url");;
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP-Enter userfirstname");
		driver.findElement(By.id("UserFirstName")).sendKeys("sasmita");
		System.out.println("STEP-Enter userlastname");
		driver.findElement(By.id("UserLastName")).sendKeys("sahu");
		System.out.println("STEP-Enter usercomapnyname ");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Novac technologies");
		System.out.println("STEP-Click on submit button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Step-Switch to alert message window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert window open");
		String actualText = alert.getText();
		System.out.println("Verify Actualalerttext with Expectedalerttext");
		if (actualText.equals(ExpectedAlertMessage))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		
		

	}


	}


