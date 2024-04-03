package shafaqueAli;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookAutomation {

	void Facebook() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		System.out.println("STEP1 :Browser is opened and URL is launched");

		driver.findElement(By.xpath("//div[@class='_6ltg']/a[@role='button']")).click();
		System.out.println("STEP2 : Clicked on Create New Account");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("shafaq");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ali");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sali123@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Abcd1234#");
		System.out.println("Step 3 : Enter appropiate value in all textbox.");

		System.out.println("STEP4: Select bithday month");
		WebElement e = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(e);
		monthSelect.selectByVisibleText("Aug");
		List<WebElement> monthOptionElemts = monthSelect.getOptions();
		String selectedmonth = "";
		for (WebElement element : monthOptionElemts) {
			if (element.isSelected())

				selectedmonth = element.getText();
		}

		System.out.println("STEP5: selected month is as Expected");
		if (selectedmonth.equals("May"))
			System.out.println("test pass");
		else
			System.out.println("Test fail");

		System.out.println("STEP6:Select bithday date from date picker");
		WebElement d = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateSelect = new Select(d);
		dateSelect.selectByValue("18");
		List<WebElement> dateOptionElemts = dateSelect.getOptions();
		String selecteddate = "";
		for (WebElement element : dateOptionElemts) {
			if (element.isSelected())
				selecteddate = element.getText();
		}

		System.out.println("Verify- selected date is as Expected");
		if (selecteddate.equals("18"))
			System.out.println("test pass");
		else
			System.out.println("Test fail");

		System.out.println("STEP7:Select bithday year from date picker");
		Thread.sleep(2000);
		WebElement y = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(y);
		yearSelect.selectByValue("1995");
		List<WebElement> yearOptionElemts = yearSelect.getOptions();
		String selecteyear = "";
		for (WebElement element : yearOptionElemts) {
			if (element.isSelected())
				selecteyear = element.getText();
		}

		System.out.println("Verify- selected date is as Expected");
		if (selecteyear.equals("1995"))
			System.out.println("test pass");
		else
			System.out.println("Test fail");

	}

	public static void main(String[] args) throws InterruptedException {
		FacebookAutomation facebookAutomation = new FacebookAutomation();
		facebookAutomation.Facebook();
	}
}
