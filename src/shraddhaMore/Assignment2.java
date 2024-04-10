/*Assignment - 2 
Step 1 : Launch browser and hit https://facebook.com
Step 2 : Click on Create Account button
Step 3 : Enter appropriate value in all textbox. 
Step 4 : Select Date from Date dropdown
Step 5 : Select Month from month dropdown
Step 6 : Select Year from year dropdown
Step 7 : Verify Selected value of date with expected value
Step 8 : Verify Selected value of month with expected value
Step 9 : Verify Selected value of year with expected value  */
package shraddhaMore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Assignment2 {
	WebDriver driver;

	void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Step 1 : Launch browser and hit https://facebook.com");
		driver.get("https://www.facebook.com/");
		System.out.println("Verify: Browser launched");
		System.out.println("Step 2 : Click on Create Account button");
		driver.findElement(By.xpath("//a[@rel='async']")).click();
		Thread.sleep(3000);
		System.out.println("Verify: Clicked on Create new Account button");

	}

	void createNewAccount() throws InterruptedException {
		System.out.println("Step 3 : Enter values in all textbox.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Shraddha");
		System.out.println("Verify: First name Entered");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("More");
		System.out.println("Verify: Last name Entered");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("shraddha.test@gmail.com");
		System.out.println("Verify: Email Id entered");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("shraddha.test@gmail.com");
		System.out.println("verify: Email id reentered");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("test123");
		System.out.println("Verify: password entered");
	}

	void verifyDayFromDropdown() {
		System.out.println("Step 4 : Select Date from Date dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(e);
		daySelect.selectByIndex(4);
		System.out.println("Verify: Day selected");
		List<WebElement> dayOptionSelect = daySelect.getOptions();
		String daySelected = "";
		for (WebElement element : dayOptionSelect) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				daySelected = element.getText();
			}
		}
		System.out.println("Step 5 : Verify Selected value of date with expected value");
		if (daySelected.equals("5")) {
			System.out.println("Verify: day selected");
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}

	void verifyMonthFromDropdown() {
		System.out.println("Step 6 : Select Month from month dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(e);
		monthSelect.selectByVisibleText("Aug");
		System.out.println("Verify: Month is selected");
		List<WebElement> monthOptionSelect = monthSelect.getOptions();
		String monthSelected = "";
		for (WebElement element : monthOptionSelect) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				monthSelected = element.getText();
			}
		}
		System.out.println("Step 7 : Verify Selected value of month with expected value");
		if (monthSelected.equals("Aug")) {
			System.out.println("Verify: Month correct month is selected");
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}

	void verifyYearFromDropdown() {
		System.out.println("Step 8 : Select Year from dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(e);
		yearSelect.selectByValue("1990");
		List<WebElement> yearOptionSelect = yearSelect.getOptions();
		String yearSelected = "";
		for (WebElement element : yearOptionSelect) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				yearSelected = element.getText();
			}
		}
		System.out.println("Step 9 : Verify Selected value of year with expected value");
		if (yearSelected.equals("1990")) {
			System.out.println("Verify: Correct year is selected");
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}

	void faceBook() throws InterruptedException {
		launchBrowser();
		createNewAccount();
		verifyDayFromDropdown();
		verifyMonthFromDropdown();
		verifyYearFromDropdown();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment2().faceBook();
	}
}
