package hiralPurohit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KrishnaAutomation {

	WebDriver driver;

	void positiveCase() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("Step: Lanuch chrome browser");
		driver.manage().window().maximize();

		System.out.println("Step: hit url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step:click on registration link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);

		System.out.println("Step: enter text into userName");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("mkanani");

		System.out.println("Step: Enter text into password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("maulik12345");

		System.out.println("Step: submit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String text1 = "Success!";
		if (actualText.equals(text1)) {
			System.out.println("Success positive test case");
		} else {
			System.out.println("Success negative test case");
		}
		alert.accept();
		System.out.println("Alert messege window close");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("clearing user name");
		driver.quit();
	}

	void negativeCase() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("Step: launch the Browser");
		driver.manage().window().maximize();

		System.out.println("Step:Hit the url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step: click on registration");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);

		System.out.println("Step: Enter the userName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Hiral");

		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("hiral%");

		System.out.println("Step: submit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String text1 = "Success!";
		if (actualText.equals(text1)) {
			System.out.println("Success positive test case");
		} else {
			System.out.println("Success negative test case");
		}
		alert.accept();
		System.out.println("Alert messege window close");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("clearing user name");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		KrishnaAutomation launchChrome = new KrishnaAutomation();
		launchChrome.positiveCase();
		System.out.println(".................................");
		System.out.println("                                 ");
		launchChrome.negativeCase();
	}

}
