/*Assignment - 2 : 2nd April'2024

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

package padmajaDeshmukh;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {
	WebDriver driver;

	void openBrowser() {
		System.out.println("STEP1 : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();
	}

	void createAccount() throws InterruptedException {

		// System.out.println("TestCase Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("https://facebook.com/");

		Thread.sleep(2000);

		System.out.println("STEP2 : Click on Create Account Button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		Thread.sleep(2000);

		System.out.println("STEP3 : Enter all the details");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Padmaja");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Deshmukh");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("padmajadeshmukh1@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("RtyHre56#");

		System.out.println("STEP4 : Select Date value from dropdown");
		WebElement dateElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select selectDate = new Select(dateElement);
		selectDate.selectByIndex(5);

		System.out.println("STEP5 : Select Month value from dropdown");
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonth = new Select(monthElement);
		selectMonth.selectByValue("1");

		System.out.println("STEP6 : Select Year value from dropdown");
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		Select selectYear = new Select(yearElement);
		selectYear.selectByVisibleText("1991");

		System.out.println("STEP7 : Verify Selected value of day with expected value");
		String selectedDay = "";
		List<WebElement> listOfDayElement = selectDate.getOptions();
		for (WebElement e : listOfDayElement) {
			if (e.isSelected()) {
				System.out.println(e.getText());
				selectedDay = e.getText();
			}
		}
		if (selectedDay.equals("6")) {
			System.out.println("Test Pass : Selected vlaue and expected values are same");
		} else {
			System.out.println("Test Fail : Selected vlaue and expected values are not same");
		}

		System.out.println("STEP8 : Verify Selected value of month with expected value");
		String selectedMonth = "";
		List<WebElement> listOfMonth = selectMonth.getOptions();
		for (WebElement element : listOfMonth) {
			if (element.isSelected()) {
				System.out.println(element.getText());
				selectedMonth = element.getText();
			}
		}
		if (selectedMonth.equals("Jan")) {
			System.out.println("Test Pass : Selected vlaue and expected values are same");
		} else {
			System.out.println("Test Fail : Selected vlaue and expected values are not same");
		}

		System.out.println("STEP9 : Verify Selected value of year with expected value ");
		String selectedYear = "";
		List<WebElement> listOfYear = selectYear.getOptions();
		for (WebElement element1 : listOfYear) {
			if (element1.isSelected()) {
				System.out.println(element1.getText());
				selectedYear = element1.getText();
			}
		}
		if (selectedYear.equals("1991")) {
			System.out.println("Test Pass : Selected vlaue and expected values are same");
		} else {
			System.out.println("Test Fail : Selected vlaue and expected values are not same");
		}

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment_2 assignment2 = new Assignment_2();
		assignment2.createAccount();
	}
}
