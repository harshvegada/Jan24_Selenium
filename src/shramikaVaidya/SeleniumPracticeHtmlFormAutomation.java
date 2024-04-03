package shramikaVaidya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumPracticeHtmlFormAutomation {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launch browser");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("hit the url");
		driver.get("file:///D:/java/intw%20imp%20prog/todaysQue/hy/myhtmlform.html");
		
		System.out.println("Enter FirstName");
		driver.findElement(By.xpath("//input[@id=\'Firstname\']")).sendKeys("Shramika");
		
		System.out.println("Enter LastName");
		driver.findElement(By.xpath("//input[@id=\'Lastname\']")).sendKeys("Vaidya");
		
		System.out.println("Enter City");
		driver.findElement(By.xpath("//input[@id=\'City\']")).sendKeys("Pune");
		
		
		System.out.println("Enter collagename ");
		driver.findElement(By.xpath("//input[@id=\'collagename\']")).sendKeys("BDCOE");
		
		System.out.println("Select Your Branch");
		WebElement branchSelect = driver.findElement(By.xpath("//select[@id=\'branch_Selection\']"));
		Select select = new Select(branchSelect);
		select.selectByValue("2");
		
		System.out.println("Do you Want to stay in Collage Hostel?");
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		
		System.out.println("Click on CheckBox");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		System.out.println("Select Button");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
