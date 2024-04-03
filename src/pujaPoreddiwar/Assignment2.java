/*
 * Assignment - 2 : 2nd April'2024
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

package pujaPoreddiwar;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	WebDriver driver;

	void TestCase() throws InterruptedException {
		System.out.println("STEP: Launch chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		Thread.sleep(5000);

		System.out.println("STEP: Hit URL");
		driver.get("https://facebook.com");

		System.out.println("STEP: Click on Create New account");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		Thread.sleep(3000);

		System.out.println("STEP: Enter appropiate value in all textbox.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Techno");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Credits");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Puja1234@abc.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("Puja1234@abc.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("TechnoCredits@1234");

		System.out.println("STEP: Select Date from Date dropdown");
		WebElement we = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(we);
		daySelect.selectByIndex(7);

		List<WebElement> dayOptionEle = daySelect.getOptions();
		String selectedDay = "";
		for (WebElement e : dayOptionEle) {
			if (e.isSelected()) {
				System.out.println(e.getText());
				selectedDay = e.getText();
			}
		}
		System.out.println("VERIFY: Selected Date from Date dropdown is same as expected");
		if (selectedDay.equals("8")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		
		
		System.out.println("STEP: Select Month from Date dropdown");
		WebElement we1 = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(we1);
		monthSelect.selectByValue("8");

		List<WebElement> monthOptionEle = monthSelect.getOptions();
		String selectedMonth = "";
		for (WebElement e1 : monthOptionEle) {
			if (e1.isSelected()) {
				System.out.println(e1.getText());
				selectedMonth = e1.getText();
			}
		}
		System.out.println("VERIFY: Selected month from Month dropdown is same as expected");
		if (selectedMonth.equals("Aug")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
		
		System.out.println("STEP : Select year from Year dropdwn");
		WebElement we2 = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(we2);
		yearSelect.selectByVisibleText("1994");
		
		List<WebElement> yearOptionEle = yearSelect.getOptions();
		String selectedYear = "";
		for(WebElement e2 : yearOptionEle) {
			if(e2.isSelected()) {
				System.out.println(e2.getText());
				selectedYear = e2.getText();
			}
		}
		System.out.println("VERIFY: Selected year from year dropdown is same as expected");
		if (selectedYear.equals("1994")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment2 fbTC = new Assignment2();
		fbTC.TestCase();
	}

}
