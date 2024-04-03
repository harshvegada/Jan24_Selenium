package shravaniRapelli;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Launch Browser");
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		System.out.println("STEP : Clicking on create new account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);
		System.out.println("STEP : Sending first Name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Shravani");
		System.out.println("STEP : Sending surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rapelli");
		System.out.println("STEP : Sending email or mobile number");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9834866647");
		System.out.println("STEP : Sending password");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Shravani1234");
		
		System.out.println("STEP : Select birth month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Dec");
		List<WebElement> listOfMonth = monthSelect.getOptions();
		String selectedMonth=" ";
		for(WebElement element : listOfMonth) {
			if(element.isSelected()) {
				System.out.println(element.getText());
				selectedMonth=element.getText();
			}
		}
		System.out.println("VERIFY : Selected month is correct");
		if(selectedMonth.equals("Dec")) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}
		
		System.out.println("STEP : Select birth day");
		WebElement dayElement = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select daySelect = new Select(dayElement);
		daySelect.selectByVisibleText("11");
		List<WebElement> listOfDay = daySelect.getOptions();
		String selectedDay="";
		for(WebElement element : listOfDay) {
			if(element.isSelected()) {
				System.out.println(element.getText());
				selectedDay=element.getText();
			}
		}
		System.out.println("VERIFY : Selected day is correct");
		if(selectedDay.equals("11")) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}

		System.out.println("STEP : Select birth year");
		WebElement yearElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText("2000");
		List<WebElement> listOfYear = yearSelect.getOptions();
		String selectedYear="";
		for(WebElement element : listOfYear) {
			if(element.isSelected()) {
				System.out.println(element.getText());
				selectedYear=element.getText();
			}
		}
		System.out.println("VERIFY : Selected day is correct");
		if(selectedYear.equals("2000")) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}
		driver.quit();
	}
}
