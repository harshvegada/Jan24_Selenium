package samikshaGadakh;

import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchFacebook {

	WebDriver driver;

	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		System.out.println("Launch facebook");
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}

	void createAccount() throws InterruptedException {
		setup();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);
		System.out.println("open sign up page");
		System.out.println("Step : enter first name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("smiksha");

		System.out.println("Step: enter surname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("gadakh");

		System.out.println("Step: enter email or mobile no");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("samikshagadakh24@gmail.com");

		System.out.println("Step: enter new password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("samiksha@123");

		System.out.println("Step: select  day in date of birth");
		WebElement e = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(e);
		daySelect.selectByValue("21");
		String expectedDate = "21";

		List<WebElement> dateOption = daySelect.getOptions();
		for (WebElement day : dateOption) {
			if (day.isSelected()) {
				if (expectedDate.equals(day.getText())) {
					System.out.println("Date verified");
				} else
					System.out.println("Date not verified.");
			}
		}

		System.out.println("Step: select month of birth");
		WebElement m = driver.findElement(By.xpath("//select[@id='month']"));
		Select monthSelect = new Select(m);
		monthSelect.selectByVisibleText("Dec");
		String expectedMonth="Dec";

		List<WebElement> monthOption = monthSelect.getOptions();
		for (WebElement month : monthOption) {
			if (month.isSelected()) {
				if (expectedMonth.equals(month.getText())) {
					System.out.println("Month verified");
				} else
					System.out.println("Month not verified.");
			}
		}

		System.out.println("Step : select year of birth");
		WebElement y = driver.findElement(By.xpath("//select[@id='year']"));
		Select yearSelect = new Select(y);
		yearSelect.selectByValue("1996");
		String expectedYear="1996";

		List<WebElement> yearOption = yearSelect.getOptions();
		for (WebElement year : yearOption) {
			if (year.isSelected()) {
				if (expectedYear.equals(year.getText())) {
					System.out.println("Year verified");
				} else
					System.out.println("Year not verified.");
			}
		}

		System.out.println("Step: select Gender");
		driver.findElement(By.xpath("//label[text()='Female']")).click();

		System.out.println("Close the browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		LaunchFacebook facebook = new LaunchFacebook();
		facebook.createAccount();
	}
}
