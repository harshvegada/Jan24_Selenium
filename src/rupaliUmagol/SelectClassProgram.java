/*Step 1 : Launch browser and hit https://facebook.com
Step 2 : Click on Create Account button
Step 3 : Enter appropiate value in all textbox. 
Step 4 : Select Date from Date dropdown
Step 5 : Select Month
Step 6 : Select Year
Step 7 : Verify Selected value of month with expected value
Step 8 : Verify Selected value of date with expected value
Step 9 : Verify Selected value of year with expected value
 */
package rupaliUmagol;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassProgram {

	WebDriver driver;

	void getBrowser() {
		System.out.println("STEP : Open WebDriver");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize Browser");
		driver.manage().window().maximize();

		System.out.println("STEP : launch url");
		driver.get("https://www.facebook.com");
	}

	void getDateFromLogin() throws InterruptedException {
		getBrowser();
		System.out.println("STEP : Click on Create Account button");
		driver.findElement(By.xpath("//a[@rel='async']")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Enter First Name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rupali");

		System.out.println("STEP : Enter SurName");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Umagol");

		System.out.println("STEP : Enter Mobile Number or Email Address");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("rupali.umagol@gmail.com");

		System.out.println("STEP : Enter New Password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("12345678");

		System.out.println("STEP : Select Date from date drop down");
		WebElement element = driver.findElement(By.xpath("//select[@id='day']"));

		System.out.println("VERIFY : Verify Selected value of date with expected value");
		Select select = new Select(element);
		select.selectByVisibleText("6");

		List<WebElement> options = select.getOptions();

		for (WebElement ele : options) {
			String ExpectedDate = "6";
			if (ele.isSelected()) {
				if (ExpectedDate.equals(ele.getText())) {
					System.out.println("Test Passed");
				} else
					System.out.println("Test Failed");
			}
		}

		System.out.println("STEP : Select Month from Month drop down");
		WebElement element1 = driver.findElement(By.xpath("//select[@id='month']"));

		System.out.println("VERIFY : Verify Selected value of date with expected value");
		Select selectForMonth = new Select(element1);
		selectForMonth.selectByVisibleText("Aug");

		List<WebElement> optionsOfMonth = selectForMonth.getOptions();

		for (WebElement ele : optionsOfMonth) {
			String ExpectedDate = "Aug";
			if (ele.isSelected()) {
				if (ExpectedDate.equals(ele.getText())) {
					System.out.println("Test Passed");
				} else
					System.out.println("Test Failed");
			}
		}

		System.out.println("STEP : Select Year from Year drop down");
		WebElement element2 = driver.findElement(By.xpath("//select[@id='year']"));

		System.out.println("VERIFY : Verify Selected value of date with expected value");
		Select selectForYear = new Select(element2);
		selectForYear.selectByVisibleText("2024");

		List<WebElement> optionsForYear = selectForYear.getOptions();

		for (WebElement ele : optionsForYear) {
			String ExpectedDate = "2024";
			if (ele.isSelected()) {
				if (ExpectedDate.equals(ele.getText())) {
					System.out.println("Test Passed");
				} else
					System.out.println("Test Failed");
			}
		}

		System.out.println("STEP : Close Browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		SelectClassProgram selectClass = new SelectClassProgram();
		selectClass.getDateFromLogin();
	}
}
