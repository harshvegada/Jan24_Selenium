package pramodkumarBalla;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Assignment - 2 : 2nd April'2024
//
//Step 1 : Launch browser and hit https://facebook.com
//Step 2 : Click on Create Account button
//Step 3 : Enter appropiate value in all textbox. 
//Step 4 : Select Date from Date dropdown
//Step 5 : Select Month
//Step 6 : Select Year
//Step 7 : Verify Selected value of month with expected value
//Step 8 : Verify Selected value of date with expected value
//Step 9 : Verify Selected value of year with expected value  

public class Selenium_Assignment2 {
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		//Step 1 : Launch browser and hit https://facebook.com
		System.out.println("Opening URL");
		driver.get("https://www.facebook.com/");
		
		System.out.println("Sleep for 2 mins");
		Thread.sleep(2000);
		
		
		//Step 2 : Click on Create Account button
		System.out.println("Create new account");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		System.out.println("Sleep for 2 mins");
		Thread.sleep(2000);
		
		//Step 3 : Enter appropiate value in all textbox. 
		System.out.println("firstname");
		driver.findElement(By.name("firstname")).sendKeys("Pramod");
		System.out.println("lastname");
		driver.findElement(By.name("lastname")).sendKeys("balla");
		System.out.println("email");
		driver.findElement(By.name("reg_email__")).sendKeys("Pramodballa007@gmail.com");
		Thread.sleep(2000);
		System.out.println("password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Techno@1234");
		
		
		//Step 4 : Select Date from Date dropdown
		System.out.println("day");
		WebElement e1=driver.findElement(By.id("day"));
		Select sel = new Select(e1);
		sel.selectByVisibleText("5");
		
		//Step 5 : Select Month
		System.out.println("month");
		WebElement e2=driver.findElement(By.id("month"));
		Select s2= new Select(e2);
		s2.selectByVisibleText("May");
		
		//Step 6 : Select Year
		System.out.println("Year");
		WebElement e3=driver.findElement(By.id("year"));
		Select s3= new Select(e3);
		s3.selectByVisibleText("2005");
		
		
		//Step 7 : Verify Selected value of month with expected value
		List<WebElement> list=sel.getOptions();
		String selectedDay="";
		for(WebElement  str: list)
		{
			if(str.isSelected())
				selectedDay=str.getText();
		}
		if(selectedDay.equals("5"))
			System.out.println("Test Pass");
		else
			System.out.println("Test Pass");
		
		//Step 8 : Verify Selected value of date with expected value
		List<WebElement> list2 = s2.getOptions();
		String selectedmonth="";
		for(WebElement  str2: list2)
		{
			if(str2.isSelected())
				selectedmonth=str2.getText();
		}
		if(selectedmonth.equals("May"))
			System.out.println("Test Pass");
		else
			System.out.println("Test Pass");
		
		
		//Step 9 : Verify Selected value of year with expected value  

		List<WebElement> l4= s3.getOptions();
		String selectedyear="";
		for(WebElement w11:l4) {
			if(w11.isSelected())
			{
				selectedyear=w11.getText();
			}
		}
		if(selectedyear.equals("2005"))
			System.out.println("Test Pass");
		else
			System.out.println("Test Pass");
				
		
		System.out.println("Gender");
		driver.findElement(By.xpath("//input[@name=\"sex\"][@value=\"2\"]")).click();
		Thread.sleep(2000);
		
		System.out.println("close browser..");
		driver.quit();
		
	}

}
