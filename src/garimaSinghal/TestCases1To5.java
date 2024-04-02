package garimaSinghal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Click On Basic Element Tab");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Garima");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Singhal");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Garima Enterprises");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("gari.here2008@gmail.com");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Singhal123");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		driver.close();
	}
}
