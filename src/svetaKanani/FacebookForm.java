package svetaKanani;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookForm {

	public void fbRegister() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//launch browser 
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//click on create account Button
		driver.findElement(By.xpath("//div/a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Sveta");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kanani");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Sveta@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Sveta@123");
		WebElement e= driver.findElement(By.xpath("//select[@id='day']"));
		Select select = new Select(e);
		select.selectByValue("30");
		
		driver.findElement(By.xpath("//select[@id='month']/option[@value='6']")).click();
		
		driver.findElement(By.xpath("//select[@id='year']/option[@value='2002']")).click();
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
	FacebookForm fb = new FacebookForm();
	fb.fbRegister();
	
	}

}
