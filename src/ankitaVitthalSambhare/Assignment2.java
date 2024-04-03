package ankitaVitthalSambhare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	WebDriver driver;

	void lunchURL() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("User sucessfully navigated to https://www.facebook.com ");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(5000);
		System.out.println("User is sccessfully clicked on the create new account button");

	}

	void VerifyFirstNLastNEmailPassword() throws InterruptedException {

		System.out.println("Step1:- Verify that, user is able to enter first name");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ankita");
		System.out.println("User sccessfully entered firstname");

		System.out.println("Step2:- Verify that, user is able to enter last name");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ankita");
		System.out.println("User sccessfully entered lastname");

		System.out.println("Step3:- Verify that, user is able to enter mobile no or email id");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Ankita@gmail.com");
		System.out.println("User sccessfully entered email ID");

		System.out.println("Step4:- Verify that, user is able to enter password");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Ankita@123");
		System.out.println("User sccessfully entered email ID");

	}

	void verifyBirthdayDateDropDown() {
		System.out.println("Step5:- Verify that, Birthday date is correctly selected");
		WebElement WE = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(WE);
		daySelect.selectByIndex(11);
		List<WebElement> daysAllOption = daySelect.getOptions();
		String selectedDay = "";
		String expectedResult = "12";
		for (WebElement webelement : daysAllOption) {

			if (webelement.isSelected()) {
				System.out.println(webelement.getText());
				selectedDay = webelement.getText();
			}
		}

		if (selectedDay.equals(expectedResult)) {
			System.out.println("Text match!!Birthday is correctly selected as " + selectedDay);
		} else {
			System.out.println("Text not match!!Birthday is correctly selected as " + selectedDay);
		}

	}

	void VerifyBirthdayMonthDropDown() {

		System.out.println("Step6:-Verify that, Birthday month is correctly selected");
		WebElement WE1 = driver.findElement(By.xpath("//select[@id='month']"));
		Select MonthSelect = new Select(WE1);
		MonthSelect.selectByIndex(9);
		List<WebElement> MonthAllOption = MonthSelect.getOptions();
		String selectedMonth = "";
		String expectedResultforMonth = "Oct";
		for (WebElement webelement : MonthAllOption) {

			if (webelement.isSelected()) {
				System.out.println(webelement.getText());
				selectedMonth = webelement.getText();
			}
		}

		if (selectedMonth.equals(expectedResultforMonth)) {
			System.out.println("Text match!!Birthday month is correctly selected as " + selectedMonth);
		} else {
			System.out.println("Text not match!!Bithday month is incorrectly selected as " + selectedMonth);
		}

	}

	void VerifyBirhtdayYearDropDown() {

		WebElement WE2 = driver.findElement(By.xpath("//select[@id='year']"));
		Select YearSelect = new Select(WE2);
		YearSelect.selectByValue("1997");
		List<WebElement> YearAllOption = YearSelect.getOptions();
		String selectedYear = "";
		String expectedResultforYear = "1997";
		for (WebElement webelement : YearAllOption) {

			if (webelement.isSelected()) {
				System.out.println(webelement.getText());
				selectedYear = webelement.getText();
			}
		}
		System.out.println("Step7:- Verify that, Birthday year is selected correctly");

		if (selectedYear.equals(expectedResultforYear)) {
			System.out.println("Text match!!Birthday year is correctly selected as " + selectedYear);
		} else {
			System.out.println("Text not match!!Birthday year is incorrectly selected as " + selectedYear);
		}
	}

	void display() throws InterruptedException {
		lunchURL();
		VerifyFirstNLastNEmailPassword();
		verifyBirthdayDateDropDown();
		VerifyBirthdayMonthDropDown();
		VerifyBirhtdayYearDropDown();
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Assignment2 ass2 = new Assignment2();
		ass2.display();

	}
}
