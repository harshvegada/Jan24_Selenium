package atishaJadhav;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();

	}

	void testCases() throws InterruptedException {
		openBrowser();

		System.out.println("Step 2 : Click on Create Account button");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);

		System.out.println("Step 3 : Entering appropiate value in all textbox. ");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Atisha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Jadhav");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("atisha@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("at_@1234");
		System.out.println("Step 4 : Select Date from Date dropdown");
		Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
		daySelect.selectByVisibleText("29");
		List<WebElement> daylist = daySelect.getOptions();
		for (WebElement e : daylist) {
			if (e.isSelected()) {
				System.out.println(e.getText() + " is selected Date");
			}
		}
//		JavascriptExecutor je = (JavascriptExecutor)driver;
//		je.executeScript("Window.scrollBy(0,500)");
//		
		System.out.println("Step 5 : Select Month");
		Select monthSelect = new Select(driver.findElement(By.name("birthday_month")));
		monthSelect.selectByVisibleText("Oct");
		List<WebElement> monthlist = monthSelect.getOptions();
		for (WebElement e : monthlist) {
			if (e.isSelected()) {
				System.out.println(e.getText() + " is selected month");
			}
		}
		System.out.println("Step 5 : Select year");
		Select yearSelect = new Select(driver.findElement(By.name("birthday_year")));
		yearSelect.selectByVisibleText("2001");
		List<WebElement> yearlist = yearSelect.getOptions();
		for (WebElement e : yearlist) {
			if (e.isSelected()) {
				System.out.println(e.getText() + " is selected year");
			}
		}

		driver.findElement(By.xpath("//input [@value='1']")).click();

		Thread.sleep(2000);
		System.out.println("quiting the browser");
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Assignment2 assignment = new Assignment2();
		System.out.println("Step 1 : Launch browser and hit https://facebook.com");
		assignment.testCases();
	}
}
