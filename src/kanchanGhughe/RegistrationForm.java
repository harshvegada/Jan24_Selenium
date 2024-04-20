
package kanchanGhughe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/amol5/OneDrive/Desktop/1.html");
		System.out.println("Launch Chrome & Load URL");

		driver.findElement(By.id("firstName")).sendKeys("Bill");
		System.out.println("First Name is Entered...........");

		driver.findElement(By.name("lastName")).sendKeys("Gates");
		System.out.println("Last Name is Entered.............");

		driver.findElement(By.xpath("//input[@placeholder='Enter Your City Name']")).sendKeys("USA");
		System.out.println("City Name.......");

		driver.findElement(By.xpath("//input[@name='collegeName']")).sendKeys("USA University");
		System.out.println("College Name.......");

		// for Dropdown, branchSelection -Locater
		WebElement branchSelection = driver.findElement(By.xpath("//select[@id='branchSelection']"));
		Select select = new Select(branchSelection);
		select.selectByValue("2");
		Thread.sleep(2000);
		select.selectByVisibleText("Civil Branch");
		System.out.println("Civil Branch......");

		driver.findElement(By.id("yes")).click();
		System.out.println("Select Yes........");

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		System.out.println("Agreed to term and Condition");

		driver.findElement(By.xpath("//button")).click();
		System.out.println("Click on Submit Button");

		driver.close();
		System.out.println("Closing Browser");
	}

}
