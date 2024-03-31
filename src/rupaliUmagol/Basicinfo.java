package rupaliUmagol;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basicinfo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		System.out.println("launch url");
		driver.get("http://automationbykrishna.com");
	
		System.out.println("open basic Elements :");
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Rupali");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Umagol");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Moolya Software");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Alert Message");
		Alert alert=driver.switchTo().alert();
		
		String actualText=alert.getText();
		System.out.println(actualText);
		alert.accept();
		driver.close();
	}

}
