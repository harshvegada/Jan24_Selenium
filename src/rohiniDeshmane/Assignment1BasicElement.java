package rohiniDeshmane;
/*
 * Assignment - 1 : 31st March'2024 
Prerequisite - Open browser & hit http://automationbykrishna.com
TestCase3 - Basic elements Page - AlertDemo - alert message verification
TestCase4 - Basic elements Page - BASIC FORMS - alert message verification
TestCase5 - Basic elements Page - Alert button - alert message verification
 */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1BasicElement {

void testClickOnAlertButton() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Browser Launched");
		driver.get("http://automationbykrishna.com/index.html");
		//driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,-500);");

		System.out.println("STEP : click on Basic Element button");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();
		
		Thread.sleep(2000);
		
		WebElement alertElement=driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",alertElement);
		
		driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")).click();
		String expectedText = "You must be TechnoCredits student!!";
		
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if(actualText.equals(expectedText)) {
			System.out.println("Test case Passed !!");
		} else
			System.out.println("Test case Failed");
		alert.accept();
	}
	
	void testForBasicElementLeftPart() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Browser Launched");
		driver.get("http://automationbykrishna.com/index.html");
		
		System.out.println("STEP : click on Basic Element button");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();
		
		Thread.sleep(2000);
		
		System.out.println("STEP : Enter in Email ID");
		driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).sendKeys("rohinideshmane.21@gmail.com");
	
		System.out.println("STEP : Enter in password");
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("12345678");
	
		System.out.println("STEP : clicked on radio check me out");
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
		
		System.out.println("STEP : Click on submit button");
		driver.findElement(By.xpath("//button[@id=\"submitb2\"]")).click();
		
	}
	
	void testForBasicElementBtn() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Browser Launched");
		driver.get("http://automationbykrishna.com/index.html");
		
		System.out.println("STEP : click on Basic Element button");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();
		
		Thread.sleep(2000);
		
		System.out.println("STEP : Enter in First Name");
		driver.findElement(By.xpath("//input[@id=\"UserFirstName\"]")).sendKeys("Rohini");
		
		System.out.println("STEP : Enter in Last Name");
		driver.findElement(By.xpath("//input[@id=\"UserLastName\"]")).sendKeys("Deshmane");
	
		System.out.println("STEP : Enter in Company Name");
		driver.findElement(By.xpath("//input[@id=\"UserCompanyName\"]")).sendKeys("Cognizant");
		
		System.out.println("STEP : Click on submit button");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment1BasicElement assignment1BasicElement = new Assignment1BasicElement();
		assignment1BasicElement.testForBasicElementBtn();
		assignment1BasicElement.testForBasicElementLeftPart();
		assignment1BasicElement.testClickOnAlertButton();
	}
}
