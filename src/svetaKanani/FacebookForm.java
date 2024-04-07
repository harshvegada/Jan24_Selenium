package svetaKanani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookForm {

	public void fbRegister() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		System.out.println("launch browser");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("Click on create button");
		driver.findElement(By.xpath("//div/a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(3000);
		System.out.println("Enter FirstName....");
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Sveta");
		
		System.out.println("Enter Surname....");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kanani");
		
		System.out.println("Enter MobileNo or Email...");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Sveta@gmail.com");
		
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Sveta@123");
		
		System.out.println("Select date..");
		WebElement e= driver.findElement(By.xpath("//select[@id='day']"));
		
		Select select = new Select(e);
		select.selectByValue("30");
		System.out.println("Select month..");
		driver.findElement(By.xpath("//select[@id='month']/option[@value='6']")).click();
		
		System.out.println("Select year..");
		driver.findElement(By.xpath("//select[@id='year']/option[@value='2002']")).click();
		
		System.out.println("Select checkbox..");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		
		System.out.println("close browser..");
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		FacebookForm fb = new FacebookForm();
		fb.fbRegister();
	}

}
