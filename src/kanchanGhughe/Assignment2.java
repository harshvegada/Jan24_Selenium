
/*Step 1 : Launch browser and hit https://facebook.com
Step 2 : Click on Create Account button
Step 3 : Enter appropiate value in all textbox. 
Step 4 : Select Date from Date dropdown
Step 5 : Select Month
Step 6 : Select Year
Step 7 : Verify Selected value of month with expected value
Step 8 : Verify Selected value of date with expected value
Step 9 : Verify Selected value of year with expected value  */

package kanchanGhughe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	void facebook() throws InterruptedException {
		String firstName = "Techno";
		String surname = "Credits";
		String mbNumber = "3214536622";
		String password = "124353";

		System.out.println("Launch Chrome browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Hit and open URL");
		driver.get("https://facebook.com");

		System.out.println("Click on Create Account button");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		Thread.sleep(2000);
		System.out.println("first Name Entered");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);

		System.out.println("Surname Entered");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surname);

		Thread.sleep(2000);
		System.out.println("Mobile Number Entered");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mbNumber);

		Thread.sleep(2000);
		System.out.println("Password Entered");
		driver.findElement(By.xpath("//div/input[@id='password_step_input']")).sendKeys(password);

		Thread.sleep(2000);
		System.out.println("Select Day from dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(e);
		daySelect.selectByValue("20");

		List<WebElement> dayOptionElement = daySelect.getOptions();
		String selectedDay = "";
		for (WebElement element : dayOptionElement) {
			if (element.isSelected()) {
				System.out.println("day:" + element.getText());
				selectedDay = element.getText();
			}
		}
		System.out.println("Verify Selected Day : ");
		if (selectedDay.equals("20")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		Thread.sleep(2000);
		System.out.println("Select Month from dropdown");

		WebElement e2 = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(e2);

		monthSelect.selectByVisibleText("Jun");

		List<WebElement> monthOptionElement = monthSelect.getOptions();
		String selectedMonth = "";
		for (WebElement element : monthOptionElement) {
			if (element.isSelected()) {
				System.out.println("Month:" + element.getText());
				selectedMonth = element.getText();
			}
		}
		System.out.println("Verify Selected Month : ");
		if (selectedMonth.equals("Jun")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}

		Thread.sleep(2000);
		System.out.println("Select Year from dropdown");

		WebElement e3 = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(e3);

		yearSelect.selectByVisibleText("2020");

		List<WebElement> yearOptionElement = yearSelect.getOptions();
		String selectedYear = "";
		for (WebElement element : yearOptionElement) {
			if (element.isSelected()) {
				System.out.println("Year:" + element.getText());
				selectedYear = element.getText();
			}
		}
		System.out.println("Verify Selected Year : ");
		if (selectedYear.equals("2020")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment2().facebook();

	}

}
