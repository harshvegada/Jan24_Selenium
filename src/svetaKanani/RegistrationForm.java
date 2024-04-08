/*Assignment - 1 : 31st March'2024 
Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification*/
package svetaKanani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationForm {

	public void registerForm() throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		System.out.println("open Browser..");
		driver.get("http://automationbykrishna.com/#");
		System.out.println("maximize window..");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Click on register..");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(1000);
		System.out.println("enter username..");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("sveta");
		//driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("sveta");
		System.out.println("Enter password..");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("sveta123@");
		System.out.println("Click on login button..");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals("Success!")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Oops Fail....!");
		}
		alert.accept();
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		new RegistrationForm().registerForm();

	}

}
