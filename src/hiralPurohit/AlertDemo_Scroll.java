package hiralPurohit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo_Scroll {
	
	void alert_Scroll() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step: Hit the Url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step: Select BasicElement");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(5000);
		
		System.out.println("Step: Click on Alert Button");
		WebElement alertElement=driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",alertElement);
		
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert=driver.switchTo().alert();
		String actualMessege=alert.getText();
		
		System.out.println("Verify Actualalerttext with Expectedalerttext");
		if(expectedText.equals(actualMessege)) {
			System.out.println("Positive test Case");
		}else {
			System.out.println("Negative test Case");
		}
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new AlertDemo_Scroll().alert_Scroll();
	}
}
