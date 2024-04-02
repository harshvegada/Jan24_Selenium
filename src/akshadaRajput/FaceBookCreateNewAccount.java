package akshadaRajput;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookCreateNewAccount {

	static void launchBrowser() throws InterruptedException {

		System.out.println("Step 1 : Launch browser and hit https://facebook.com");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		
		System.out.println("Step 2 : Click on Create Account button");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(2000);
		
		
		System.out.println("Step 3 : Enter appropiate value in all textbox.");
		driver.findElement(By.name("firstname")).sendKeys("Ridhaan");
		driver.findElement(By.name("lastname")).sendKeys("Rajput");
		driver.findElement(By.name("reg_email__")).sendKeys("ridhaan_rajput@test.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("ridhaan_rajput@test.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Abcd1234#");

		
		System.out.println("Step 4 : Select Date from Date dropdown");
		Select selectDate = new Select(driver.findElement(By.id("day")));
		selectDate.selectByValue("6");

		
		System.out.println("Step 5 : Select month");
		Select selectMonth = new Select(driver.findElement(By.id("month")));
		selectMonth.selectByVisibleText("Feb");
		
		
		System.out.println("Step 6 : Select year");
		Select selectYear = new Select(driver.findElement(By.name("birthday_year")));
		selectYear.selectByValue("2023");
		
		
		System.out.println("Step 7 : Verify Selected value of date with expected value");
		List<WebElement> dateSelectionStatus = selectDate.getOptions();
		
		String actualDate = "";

		for (WebElement date : dateSelectionStatus) {
			if (date.isSelected())
				actualDate = date.getText();
		}

		if (actualDate.equals("6"))
			System.out.println("Date Selection TC Pass");
		else
			System.out.println("Date Selection TC Fail");

		
		
		System.out.println("Step 8 : Verify Selected value of month with expected value");
		String actualMonth = "";

		List<WebElement> monthSelectionStatus = selectMonth.getOptions();
		
		for (WebElement month : monthSelectionStatus) {
			if (month.isSelected())
				actualMonth = month.getText();
		}

		if (actualMonth.equals("Feb"))
			System.out.println("Month Selection TC Pass");
		else
			System.out.println("Month Selection TC Fail");

		
		
		System.out.println("Step 9 : Verify Selected value of year with expected value");
		String actualYear = "";
		
		List<WebElement> yearSelectionStatus = selectYear.getOptions();
		
		for (WebElement year : yearSelectionStatus) {
			if (year.isSelected())
				actualYear = year.getText();
		}
		
		if (actualYear.equals("2023"))
			System.out.println("Year Selection TC Pass");
		else
			System.out.println("Year Selection TC Fail");
		
		
		System.out.println("Closing browser");
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String args[]) throws InterruptedException {
		launchBrowser();
	}
}
