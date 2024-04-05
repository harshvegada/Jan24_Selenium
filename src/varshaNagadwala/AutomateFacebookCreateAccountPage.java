package varshaNagadwala;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Assignment - 2
//Step 1 : Launch browser and hit https://facebook.com   
//Step 2 : Click on Create Account button
//Step 3 : Enter appropiate value in all textbox. 
//Step 4 : Select Date from Date dropdown
//Step 5 : Select Month
//Step 6 : Select Year
//Step 7 : Verify Selected value of month with expected value
//Step 8 : Verify Selected value of date with expected value
//Step 9 : Verify Selected value of year with expected value  

public class AutomateFacebookCreateAccountPage {

	WebDriver driver;
	
	void launchBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

	}

	void validateFacebookLogin() throws InterruptedException {

		System.out.println("TestCase Start");
		launchBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("https://www.facebook.com/");

		Thread.sleep(2000);

		System.out.println("STEP : Click on created new account");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		Thread.sleep(2000);
		System.out.println("STEP : Enter All the Details");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Varsha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nagadwala");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Varsha@yahoo.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("Varsha@yahoo.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("1234556");

		System.out.println("STEP : Select date from dropdown");
		WebElement dateElement = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select selectDate = new Select(dateElement);
		selectDate.selectByValue("15");

		Thread.sleep(2000);

		System.out.println("STEP : Create the list of Date");
		List<WebElement> listOfDate = selectDate.getOptions();

		System.out.println("STEP : Get ActualDate");
		String actualDate = "";
		for (WebElement date : listOfDate) {
			if (date.isSelected())
				actualDate = date.getText();
		}

		System.out.println("STEP : Select month from dropdown");
		WebElement monthElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select selectMonth = new Select(monthElement);
		selectMonth.selectByVisibleText("Aug");

		Thread.sleep(2000);

		System.out.println("STEP : Create the list of Month");
		List<WebElement> listOfMonth = selectMonth.getOptions();

		System.out.println("STEP : Get ActualMonth");
		String actualMonth = "";
		for (WebElement month : listOfMonth) {
			if (month.isSelected())
				actualMonth = month.getText();
		}

		System.out.println("STEP : Select year from dropdown");
		WebElement yearElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select selectYear = new Select(yearElement);
		selectYear.selectByIndex(23);

		Thread.sleep(2000);

		System.out.println("STEP : Create the list of Year");
		List<WebElement> listOfYear = selectYear.getOptions();

		System.out.println("STEP : Get ActualYear");
		String actualYear = "";
		for (WebElement year : listOfYear) {
			if (year.isSelected())
				actualYear = year.getText();
		}

		System.out.println(
				"VERIFY :expectedDate, expectedMonth and expectedYear are equal to actualDate, actualMonth and actualYear ");
		String expectedDate = "15";
		String expectedMonth = "Aug";
		String expectedYear = "2001";

		if (actualDate.equals(expectedDate) && actualMonth.equals(expectedMonth) && actualYear.equals(expectedYear)) {
			System.out.println("Testcases -> Pass");
		} else {
			System.out.println("Testcases -> Fail");
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomateFacebookCreateAccountPage automateFacebookCreateAccountPage = new AutomateFacebookCreateAccountPage();
		automateFacebookCreateAccountPage.validateFacebookLogin();
	}
}
