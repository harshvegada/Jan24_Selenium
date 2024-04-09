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
package shridharK;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	void faceBookAccountCreationTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Step - Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("Step - Hit the facebook URL");
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		System.out.println("Step - Slect create account");
		driver.findElement(By.xpath("//a[text() = 'Create new account']")).click();

		Thread.sleep(2000);

		System.out.println("Step - Send keys to Firstname");
		driver.findElement(By.xpath("//input[@placeholder = 'First name']")).sendKeys("Shri");
		System.out.println("Step - Send Keys to Surname");
		driver.findElement(By.xpath("//input[@aria-label = 'Surname']")).sendKeys("Kum");
		System.out.println("Step - Send keys to mobile num");
		driver.findElement(By.xpath("//input[@aria-label = 'Mobile number or email address']")).sendKeys("1111");
		System.out.println("Step - Send keys to Password");
		driver.findElement(By.xpath("//input[@id = 'password_step_input']")).sendKeys("789");
		System.out.println("Day dropdown Element");
		WebElement dayDropDownEle = driver.findElement(By.xpath("//select[@id = 'day']"));
		System.out.println("Creating Select object for day dropdown");
		Select daySelect = new Select(dayDropDownEle);
		System.out.println("Step - Select index two ie date 3");
		daySelect.selectByIndex(2);

		System.out.println("Month dropdown element");
		WebElement monthDropDown = driver.findElement(By.xpath("//select[@id = 'month']"));
		System.out.println("Creating Month dropdown object");
		Select monthSelect = new Select(monthDropDown);
		System.out.println("Step - Select month from dropdown");
		monthSelect.selectByVisibleText("Aug");

		System.out.println("Year dropdown element");
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@id = 'year']"));
		System.out.println("Creating Select object for year");
		Select yearSelect = new Select(yearDropDown);
		System.out.println("Step - Select year from dropdown");
		yearSelect.selectByValue("1990");

		System.out.println("Verificatopn of selected date");
		String selectedDay = "";
		List<WebElement> listOfDayElement = daySelect.getOptions();
		for (WebElement e : listOfDayElement) {
			if (e.isSelected()) {
				System.out.println(e.getText());
				selectedDay = e.getText();
			}
		}
		System.out.println("Step - Verify correct date selected");
		if (selectedDay.equals("3")) {
			System.out.println("Test for day selection is passed");
		} else {
			System.out.println("Test for day selection is failed");
		}

		System.out.println("Verification test for month");
		String monthSelected = "";
		List<WebElement> monthDropDownElement = monthSelect.getOptions();
		for (WebElement monthElement : monthDropDownElement) {
			if (monthElement.isSelected()) {
				System.out.println(monthElement.getText());
				monthSelected = monthElement.getText();
			}
		}
		System.out.println("Step - Verify correct month selected");
		if (monthSelect.equals("Aug")) {
			System.out.println("Test passed for month selection");
		} else {
			System.out.println("Test for month selection failed");
		}

		System.out.println("Verification of year selection");
		String yearSelected = "";
		List<WebElement> yearDropDownElements = yearSelect.getOptions();
		for (WebElement yearElement : yearDropDownElements) {
			if (yearElement.isSelected()) {
				System.out.println(yearElement.getText());
				yearSelected = yearElement.getText();
			}
		}
		System.out.println("Step - verify 1990 year selected");
		if (yearSelected.equals("1990")) {
			System.out.println("Test passed for year selection");
		} else {
			System.out.println("Test failed for year selection");
		}

		System.out.println("Gender selection");
		driver.findElement(By.xpath("//label[text() = 'Male']")).click();
		Thread.sleep(2000);
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment2().faceBookAccountCreationTest();
	}
}
