package gauravGarg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckExpectedDateFacebookAssignment2 {

	void checkDateWithExpectedDate() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		System.out.println("Step 1 : Launch browser and hit https://facebook.com");
		wb.get("https://facebook.com");
		System.out.println("Step 2 : Click on Create Account button");
		wb.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(8000);
		System.out.println("Step 3 : Enter appropiate value in all textbox.");
		wb.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Gaurav");
		wb.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Garg");
		wb.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("gauravgarg9136@gmail.com");
		wb.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("gauravgarg9136@gmail.com");
		wb.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Gaurav913");
		System.out.println("Step 4 : Select Date from Date dropdown");
		WebElement wb1 = wb.findElement(By.xpath("//select[@name='birthday_day']"));
		Select daySelect = new Select(wb1);
		daySelect.selectByVisibleText("17");
		System.out.println("Step 5 : Select Month");
		WebElement wb2 = wb.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthSelect = new Select(wb2);
		monthSelect.selectByVisibleText("Aug");
		System.out.println("Step 6 : Select Year");
		WebElement wb3 = wb.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yearSelect = new Select(wb3);
		yearSelect.selectByValue("1997");
		String date = "";
		String month = "";
		String year = "";
		List<WebElement> monthOption = monthSelect.getOptions();
		for (WebElement element : monthOption) {
			if (element.isSelected()) {
				month = element.getText();
			}
		}

		System.out.println("Step 7 : Verify Selected value of month with expected value");
		if (month.equals("Aug")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		List<WebElement> dayOption = daySelect.getOptions();
		for (WebElement element : dayOption) {
			if (element.isSelected()) {
				date = element.getText();
			}
		}

		System.out.println("Step 8 : Verify Selected value of date with expected value");
		if (date.equals("17")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		List<WebElement> yearOption = yearSelect.getOptions();
		for (WebElement element : yearOption) {
			if (element.isSelected()) {
				year = element.getText();
			}
		}
		System.out.println("Step 9 : Verify Selected value of year with expected value  ");
		if (year.equals("1997")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new CheckExpectedDateFacebookAssignment2().checkDateWithExpectedDate();
	}
}
