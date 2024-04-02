package sasmitaSahu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP-Launch the browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP-hit the url");
		driver.get("https://www.facebook.com/");
		System.out.println("STEP-Click on Create new Account button");
		driver.findElement(By.xpath("//div[@class='_6ltg']/a[@role='button']")).click();
		Thread.sleep(2000);
		System.out.println("STEP-Enter Firstname");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sasmita");
		System.out.println("STEP-Enter Lastname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("sahu");
		System.out.println("STEP-Enter mobile number or email address");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("9894185675");
		System.out.println("STEP-Enter password");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("123sasmita");
		System.out.println("STEP-Select bithday month");
		WebElement e = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(e);
		monthSelect.selectByVisibleText("May");
		List<WebElement> monthOptionElemts = monthSelect.getOptions();
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
		Thread.sleep(2000);
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
}
