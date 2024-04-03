package hiralPurohit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Step: Lanuch chrome browser");
		driver.manage().window().maximize();

		System.out.println("Step: hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step:click on BasicElement");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		System.out.println("Step: enter email");
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("rajpurohithiral@gmail.com");

		System.out.println("Step: enter password");
		driver.findElement(By.id("pwd")).sendKeys("hiral@133");

		System.out.println("Step: click on checkbox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();

		System.out.println("Step: click on submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		String expectedMessege = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualMessege = alert.getText();

		if (actualMessege.equals(expectedMessege)) {
			System.out.println("Success positive test case");
		} else {
			System.out.println("Success negative test case");
		}
		
		System.out.println("Steps-Accept the alert");
		alert.accept();
	}

}
