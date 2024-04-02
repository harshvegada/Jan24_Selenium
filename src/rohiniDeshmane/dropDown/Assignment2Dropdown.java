package rohiniDeshmane.dropDown;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2Dropdown {

	void dropdownDateVerification() throws InterruptedException  {
		System.out.println("Step 1 : Launch browser and hit https://facebook.com");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		System.out.println("Step 2 : Click on Create Account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		
		System.out.println("Step 3 : Enter appropiate value in all textbox. ");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rohini");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Deshmane");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("rohinideshmane.21@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("123456789");
		
		System.out.println("Step 4 : Select Date from Date dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dateSelect = new Select(e);
		dateSelect.selectByValue("21");
		
		System.out.println("Step 5 : Select Month");
		e = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthSelect = new Select(e);
		monthSelect.selectByIndex(2);
		
		System.out.println("Step 6 : Select Year");
		e = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yearSelect = new Select(e);
		yearSelect.selectByVisibleText("1993");
		
		System.out.println("Step 7 : Verify Selected value of month with expected value");
		List<WebElement> monthElementList = monthSelect.getOptions();
		for(int i =0; i<monthElementList.size(); i++) {
			if(monthElementList.get(i).isSelected()) {
				if(monthElementList.get(i).getText().equals("Mar")) {
					System.out.println("March Month Selected");
				} else
					System.out.println("Month incorrect Selected");
			}
		}
		
		System.out.println("Step 8 : Verify Selected value of date with expected value");
		List<WebElement> dateElementList =  dateSelect.getOptions();
		for(int i=0; i<dateElementList.size(); i++) {
			if(dateElementList.get(i).isSelected()) {
				if(dateElementList.get(i).getText().equals("21")) {
					System.out.println("21 date Selected");
				} else
					System.out.println("Date incorrect selected");
			}
		}
		
		System.out.println("Step 9 : Verify Selected value of year with expected value");
		List<WebElement> yearElementList = yearSelect.getOptions();
		for(int i=0; i<yearElementList.size(); i++) {
			if(yearElementList.get(i).isSelected()) {
				if(yearElementList.get(i).getText().equals("1993")) {
					System.out.println("1993 year Selected");
				} else
					System.out.println("Year incorrect selected");
			}
		}
		
		System.out.println("Test Case Passed !!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment2Dropdown assignment2Dropdown = new Assignment2Dropdown();
		assignment2Dropdown.dropdownDateVerification();
	}
}
