/*
TestCase1:
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

package phenolVerma;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateFacebook {

	WebDriver driver;

	// Step 1 : Launch browser and hit https://facebook.com

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		System.out.println("Maximaize the browser");
		driver.manage().window().maximize();

		System.out.println("Open Facebook");
		driver.get("https://facebook.com");

		Thread.sleep(2000);
	}

	void testCase1() throws InterruptedException {

		System.out.println("Launch browser and hit https://facebook.com");
		openBrowser();

		System.out.println("Step 2 : Click on Create Account button");
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);

		System.out.println("Step 3 : Enter appropiate value in all textbox.");

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Phenol");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Verma");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("phenol.verma@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("phenol.verma@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("phenol");

		System.out.println("Enter Date of Birth");

		System.out.println("Creating web elemet for day");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
		System.out.println("Creating select element for Date");
		Select daySelect = new Select(dayElement);
		System.out.println("Step 4 : Select Date from Date dropdown");
		daySelect.selectByVisibleText("17");

		System.out.println("Creating web elemet for month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		System.out.println("Creating select element for month");
		Select monthSelect = new Select(monthElement);
		System.out.println("Step 5 : Select Month");
		monthSelect.selectByIndex(3);

		System.out.println("Creating web elemet for year");
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		System.out.println("Creating select element for year");
		Select yearSelect = new Select(yearElement);
		System.out.println("Step 6 : Select Year");
		yearSelect.selectByValue("1981");

		System.out.println("Step 7 : Verify Selected value of month with expected value");
		List<WebElement> dayOptionElement = daySelect.getOptions();
		for (WebElement day : dayOptionElement) {
			if (day.isSelected()) {
				System.out.println(day.getText());
			}
		}

		System.out.println("Step 8 : Verify Selected value of date with expected value");
		List<WebElement> monthOptionElement = monthSelect.getOptions();
		for (WebElement month : monthOptionElement) {
			if (month.isSelected()) {
				System.out.println(month.getText());
			}
		}

		System.out.println("Step 9 : Verify Selected value of year with expected value");
		List<WebElement> yearOptionElement = yearSelect.getOptions();
		for (WebElement year : yearOptionElement) {
			if (year.isSelected()) {
				System.out.println(year.getText());
			}
		}
		
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomateFacebook automateFacebook = new AutomateFacebook();
		automateFacebook.testCase1();
	}
}
