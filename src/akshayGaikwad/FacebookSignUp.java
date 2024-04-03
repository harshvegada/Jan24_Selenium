package akshayGaikwad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUp {

	WebDriver driver = new ChromeDriver();

	void facebookSignUop() throws Exception {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on create new account");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP : Enter First Name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Akshay");
		
		System.out.println("STEP : Enter Surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gaikwad");
		
		System.out.println("STEP : Enter emailID");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("abcd@gmail.com");
		
		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("12345789");
		
		System.out.println("STEP : Enter Date of Birth");
		Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
		daySelect.selectByVisibleText("25");
		List<WebElement> dayList = daySelect.getOptions();
		
		for(WebElement e : dayList) {
			if(e.isSelected()) {
				System.out.println(e.getText() + " is selected Date");
			}
		}
		
		System.out.println("STEP : Enter Month of Birth");
		Select monthSelect  = new Select(driver.findElement(By.name("birthday_month")));
		monthSelect.selectByVisibleText("Aug");
		List<WebElement> monthList = monthSelect.getOptions();
		
		for(WebElement e : monthList) {
			if(e.isSelected()) {
				System.out.println(e.getText() + " is selected as Month");
			}
		}
		
		System.out.println("STEP : Enter Month of Birth");
		Select yearSelect  = new Select(driver.findElement(By.name("birthday_year")));
		yearSelect.selectByVisibleText("1996");
		List<WebElement> yearList = yearSelect.getOptions();
		
		for(WebElement e : yearList) {
			if(e.isSelected()) {
				System.out.println(e.getText() + " is selected as Year");
			}
		}
		
		System.out.println("STEP : Select gender");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		new FacebookSignUp().facebookSignUop();
	}
}
