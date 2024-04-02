package rohiniDeshmane;
/*
 * 
Assignment - 1 : 31st March'2024 
Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase1 - Registration page alert message check for password more than 8 characters
TestCase2 - Registration page alert message check for password less than 8 characters
 */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment1TextBoxes {

	void testForRegistrationBtnMoreThanEight() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP : Browser Launched");
		driver.get("http://automationbykrishna.com/index.html");
		
		System.out.println("STEP : click on registration button");
		driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP : add username and password");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("mkanani");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("123456789");
		
		System.out.println("STEP : Click on submit button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();
	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if(text.equals("Success!")){
			alert.accept();
			System.out.println("Login in Successful");
		} else
			System.out.println("Login failed");	
		System.out.println("Test case Passed");
	}
	
	void testForRegistrationBtnLessThanEight() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP : Browser Launched");
		driver.get("http://automationbykrishna.com/index.html");
		
		System.out.println("STEP : click on registration button");
		driver.findElement(By.xpath("//a[@id=\"registration2\"]")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP : add username and password");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("mkanani");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("1234567");
		
		System.out.println("STEP : Click on submit button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();
	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if(text.equals("Success!")){
			alert.accept();
			System.out.println("Login in Successful");
		} else
			System.out.println("Login failed");	
		System.out.println("Test case Passed");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment1TextBoxes assignment1TextBoxes = new Assignment1TextBoxes();
		assignment1TextBoxes.testForRegistrationBtnLessThanEight();
		assignment1TextBoxes.testForRegistrationBtnMoreThanEight();
	}
}
