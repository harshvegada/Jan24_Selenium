package hiralPurohit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	void toGetAlertDemoTesting() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Launch the browser");
		driver.manage().window().maximize();

		System.out.println("Step: Hit Url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step:click on BasicElement");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("Step:Enter First name");
		driver.findElement(By.id("UserFirstName")).sendKeys("Hiral");

		System.out.println("Step: Enter Last name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Purohit");

		System.out.println("Step:Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("TechnoCredits");
		Thread.sleep(2000);

		System.out.println("Step: clock on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		String expectedMessege = "Hiral and Purohit and TechnoCredits";
		Alert alert = driver.switchTo().alert();
		String actualMessege = alert.getText();

		if (expectedMessege.equals(actualMessege)) {
			System.out.println("Positive test case");
		} else {
			System.out.println("Negative test case");
		}

		System.out.println("Steps-Accept the alert");
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		AlertDemo alertdemo = new AlertDemo();
		alertdemo.toGetAlertDemoTesting();
	}

}
