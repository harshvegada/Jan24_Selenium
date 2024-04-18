package anandRathod;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	WebDriver driver;

	void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	void facebookSignUp() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("TestAnand");
		System.out.println("STEP: enter first name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("TestRat");
		System.out.println("STEP: enter last name");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Test@gmail.com");
		System.out.println("STEP: enter email id");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("Test12345");
		System.out.println("STEP: enter password");
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select selectDay = new Select(day);
		selectDay.selectByVisibleText("17");
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("5");
		List<WebElement> monthOptionElemts = selectMonth.getOptions();
		String selectedmonth = "";
		for (WebElement element : monthOptionElemts) {
			if (element.isSelected())

				selectedmonth = element.getText();
		}
		System.out.println("Verify- selected month is as Expected");
		if (selectedmonth.equals("May"))
			System.out.println("test pass");
		else
			System.out.println("Test fail");

		System.out.println("STEP-Select bithday date from date picker");
		WebElement d = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(d);
		dateSelect.selectByValue("5");
		List<WebElement> dateOptionElemts = dateSelect.getOptions();
		String selecteddate = "";
		for (WebElement element : dateOptionElemts) {
			if (element.isSelected())
				selecteddate = element.getText();
		}

		System.out.println("Verify- selected date is as Expected");
		if (selecteddate.equals("5"))
			System.out.println("test pass");
		else
			System.out.println("Test fail");

		System.out.println("STEP-Select bithday year from date picker");
		WebElement y = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(y);
		yearSelect.selectByValue("1991");
		List<WebElement> yearOptionElemts = yearSelect.getOptions();
		String selecteyear = "";
		for (WebElement element : yearOptionElemts) {
			if (element.isSelected())
				selecteyear = element.getText();
		}

		System.out.println("Verify- selected date is as Expected");
		if (selecteyear.equals("1991"))
			System.out.println("test pass");
		else
			System.out.println("Test fail");
	}

	public static void main(String[] args) {
		Assignment2 assignment2 = new Assignment2();
		assignment2.setup();
		assignment2.facebookSignUp();
	}
}