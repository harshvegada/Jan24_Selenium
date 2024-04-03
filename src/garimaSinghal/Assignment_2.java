package garimaSinghal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Launch browser and hit https://facebook.com");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");

		System.out.println("STEP : Click on Create Account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter appropiate value in all textbox. ");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("garima");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("singhal");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9971453457");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("garima22");

		System.out.println("STEP : Select Date from Date dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select selectDay = new Select(e);
		selectDay.selectByVisibleText("22");
		List<WebElement> listDay = selectDay.getOptions();

		System.out.println("Step 7 : Verify Selected value of month with expected value");
		for (WebElement day : listDay) {
			String expected = "22";
			if (day.isSelected()) {
				if (expected.equals(day.getText())) {
					System.out.println("Test passed");
				} else {
					System.out.println("Test Fail");
				}
			}
		}

		System.out.println("STEP : Select Month from Month dropdown");
		WebElement e1 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select selectMonth = new Select(e1);
		selectMonth.selectByVisibleText("Dec");
		List<WebElement> listMonth = selectMonth.getOptions();

		System.out.println("Step 8 : Verify Selected value of date with expected value");
		for (WebElement month : listMonth) {
			String expected = "Dec";
			if (month.isSelected()) {
				if (expected.equals(month.getText())) {
					System.out.println("Test passed");
				} else {
					System.out.println("Test Fail");
				}
			}
		}

		System.out.println("STEP : Select Year from year dropdown");
		WebElement e2 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select selectYear = new Select(e2);
		selectYear.selectByVisibleText("1985");
		List<WebElement> listYear = selectYear.getOptions();

		System.out.println("Step 9 : Verify Selected value of year with expected value  ");
		for (WebElement year : listYear) {
			String expected = "1985";
			if (year.isSelected()) {
				if (expected.equals(year.getText())) {
					System.out.println("Test passed");
				} else {
					System.out.println("Test Fail");
				}
			}
		}
		driver.quit();
	}
}
