package samikshaGadakh;

import java.awt.Window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWeb {

	WebDriver driver;

	void pwdLenMoreThan8() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("======Test case 1=======");
		System.out.println("Launch chrome browser");

		System.out.println("Step: hit url");
		driver.get("http://Automationbykrishna.com");
		System.out.println("click on reg");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println("enter first name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("samikshagadakh24@gmail.com");

		System.out.println("enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("samiksha@123");

		System.out.println("Step: click on submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step : get text from alert");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Test pass");
		} else
			System.out.println("Test fail");

		Thread.sleep(1000);
		alert.accept();
		driver.close();
	}

	void pwdLenLessThan8() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("=======Test case 2=======");
		System.out.println("Launch chrome browser");

		System.out.println("Step: hit url");
		driver.get("http://Automationbykrishna.com");
		System.out.println("click on reg");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println("enter first name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("samikshagadakh24@gmail.com");

		System.out.println("enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("sami123");

		System.out.println("Step: click on submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Step : get text from alert");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Test pass");
		} else
			System.out.println("Test fail");

		Thread.sleep(1000);
		alert.accept();
		driver.close();
	}

	void verifyAlert1() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("======Test case 3======");
		System.out.println("Launch chrome browser");

		System.out.println("Step: hit url");
		driver.get("http://Automationbykrishna.com");

		System.out.println("Step : click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("Step : enter userfirst name");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys("Samiksha");

		System.out.println("Step : enter user last name");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys("Gadakh");

		System.out.println("Step: company Name");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys("Technocredits");

		System.out.println("Step : hit submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		System.out.println("Step: verify alert");
		String ExpectedText = "Samiksha and Gadakh and Technocredits";

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (actualText.endsWith(ExpectedText)) {
			System.out.println("Test pass");
		} else
			System.out.println("test fail");

		Thread.sleep(2000);
		alert.accept();
		driver.close();
	}

	void verifyAlert2() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("======Test case 4======");
		System.out.println("Launch chrome browser");

		System.out.println("Step: hit url");
		driver.get("http://Automationbykrishna.com");

		System.out.println("Step : click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(2000);

		System.out.println("Step : enter email");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("Samikshagadakh24@gmail.com");

		System.out.println("Step : enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("samiksha@123");

		System.out.println("Step: click on checkbox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();

		System.out.println("Step : hit submit button");
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,550)", "");
		WebElement alertElement = driver.findElement(By.xpath("//button[@id='submitb2']"));
		alertElement.click();

		System.out.println("Step: verify alert");
		String ExpectedText = "You successfully clicked on it";

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (actualText.endsWith(ExpectedText)) {
			System.out.println("Test pass");
		} else
			System.out.println("test fail");

		Thread.sleep(2000);
		alert.accept();

		driver.close();
	}
	
	void verifyAlert3() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("======Test case 5======");
		System.out.println("Launch chrome browser");

		System.out.println("Step: hit url");
		driver.get("http://Automationbykrishna.com");

		System.out.println("Step : click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		
		Thread.sleep(3000);
		System.out.println("Step : click on alert button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element =driver.findElement(By.id("javascriptAlert"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		
		System.out.println("check expected text and actual text :");
		String expectedString = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualText=alert.getText();
		
		if(actualText.equals(expectedString)) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}

		driver.close();

	}

	public static void main(String[] args) throws Exception {
		LaunchWeb launchweb = new LaunchWeb();
		launchweb.pwdLenMoreThan8();
		Thread.sleep(1000);
		launchweb.pwdLenLessThan8();
		Thread.sleep(1000);
		launchweb.verifyAlert1();
		Thread.sleep(1000);
		launchweb.verifyAlert2();
		Thread.sleep(1000);
		launchweb.verifyAlert3();

	}
}