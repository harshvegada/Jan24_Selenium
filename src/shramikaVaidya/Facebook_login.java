package shramikaVaidya;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook_login {

	void toTestfacebookLogin() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("Launch the browser");
		driver.manage().window().maximize();

		System.out.println("Step: Hit the URL");
		driver.get("https://www.facebook.com");

		System.out.println("Step: click on Create New Account");
		driver.findElement(By.xpath("//a[@rel='async']")).click();
		Thread.sleep(2000);

		System.out.println("Step: Enter your first name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Shramika");

		System.out.println("Step: Enter your LastName");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("vaidya");

		System.out.println("Step:Enter your email");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("savi.vaidya17@gmail.com");

		System.out.println("Step: Set password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("9921312288");

		System.out.println("Step: Select day from drop down");
		WebElement element = driver.findElement(By.xpath("//select[@name='birthday_day']"));

		System.out.println("Step: Verifying date");
		Select select = new Select(element);
		select.selectByVisibleText("17");

		List<WebElement> dateOption = select.getOptions();
		for (WebElement date : dateOption) {
			String expected = "17";
			if (date.isSelected()) {
				if (expected.equals(date.getText())) {
					System.out.println("Test pass");
				} else {
					System.out.println("test Fail");
				}
			}
		}
		System.out.println("Step: Select month from drop down");
		WebElement element1 = driver.findElement(By.xpath("//select[@name='birthday_month']"));

		System.out.println("Step: Verifying month");
		Select select1 = new Select(element1);
		select1.selectByVisibleText("Aug");

		List<WebElement> monthOption = select.getOptions();
		for (WebElement month : monthOption) {
			String expected1 = "Aug";
			if (month.isSelected()) {
				if (expected1.equals(month.getText())) {
					System.out.println("Test Positive");
				} else {
					System.out.println("Negative test");
				}
			}
		}

		System.out.println("Step: Select Year from drop down");
		WebElement element2 = driver.findElement(By.xpath("//select[@name='birthday_year']"));

		System.out.println("Step: Verify year");
		Select select2 = new Select(element2);
		select2.selectByVisibleText("1992");

		List<WebElement> yearOption = select.getOptions();
		for (WebElement year : yearOption) {
			String expected2 = "1992";
			if (year.isSelected()) {
				if (expected2.equals(year.getText())) {
					System.out.println("Test Positive");
				} else {
					System.out.println("Negative test");
				}
			}
		}
		System.out.println("Step: close the browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		new Facebook_login().toTestfacebookLogin();
	}
}
