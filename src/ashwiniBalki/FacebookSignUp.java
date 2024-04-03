package ashwiniBalki;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
Assignment - 2 : 2nd April'2024
Step 1 : Launch browser and hit https://facebook.com
Step 2 : Click on Create Account button
Step 3 : Enter appropiate value in all textbox. 
Step 4 : Select Date from Date dropdown
Step 5 : Select Month
Step 6 : Select Year
Step 7 : Verify Selected value of month with expected value
Step 8 : Verify Selected value of date with expected value
Step 9 : Verify Selected value of year with expected value  
 */
public class FacebookSignUp {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step 1 : Launch browser and hit https://facebook.com");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		System.out.println("Step 2 : Click on Create Account button");
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

		Thread.sleep(2000);

		System.out.println("Step 3 : Enter appropiate value in  FirstName, LastName, email and password");
		driver.findElement(By.xpath("//input[@name= 'firstname']")).sendKeys("Ashwini");
		driver.findElement(By.xpath("//input[@name= 'lastname']")).sendKeys("Balki");
		driver.findElement(By.xpath("//input[@name= 'reg_email__']")).sendKeys("7755943530");
		driver.findElement(By.xpath("//input[@name= 'reg_passwd__']")).sendKeys("Asddsaf76");

		System.out.println("Step 4 : Select Date from Date dropdown");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id= 'day']"));
		Select daySelect = new Select(dayElement);
		// daySelect.selectByValue("3");
		daySelect.selectByVisibleText("3");
		// daySelect.selectByIndex(2);

		List<WebElement> dayOptionElement = daySelect.getOptions();
		String selectedDate = "";
		for (WebElement element : dayOptionElement) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				selectedDate = element.getText();
			}
		}
		System.out.println("VERIFY : Selected Date is as expected");
		if (selectedDate.equals("3")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		// For month dropdown
		System.out.println("Step 5 : Select Month from month dropdown");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id= 'month']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Oct");

		List<WebElement> monthOptionElement = monthSelect.getOptions();
		String selectedMonth = "";
		for (WebElement element : monthOptionElement) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				selectedMonth = element.getText();
			}
		}
		System.out.println("VERIFY : Selected month is as expected");
		if (selectedMonth.equals("Oct")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		// For year
		System.out.println("Step 6 : Select year from year dropdown");
		WebElement yearElement = driver.findElement(By.xpath("//select[@id= 'year']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText("1991");

		List<WebElement> yearOptionElement = yearSelect.getOptions();
		String selectedYear = "";
		for (WebElement element : yearOptionElement) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				selectedYear = element.getText();
			}
		}
		System.out.println("VERIFY : Selected year is as expected");
		if (selectedYear.equals("1991")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

	}

}
