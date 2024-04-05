package rupaliUmagol;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectProgram {

	WebDriver driver;

	void getBrowser() {
		System.out.println("STEP : Open WebDriver");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize Browser");
		driver.manage().window().maximize();

		System.out.println("STEP : launch url");
		driver.get("http://automationbykrishna.com");
	}

	void checkSingleSelection() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Open WebDriver");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		Select select = new Select(element);

		System.out.println("STEP : Check wheather drop down is Single select or Multiple Select");
		System.out.println(select.isMultiple());

		System.out.println("STEP : Select Value 3 from DropDown");
		if (!select.isMultiple()) {
			select.selectByVisibleText("3");
		}

		System.out.println("VERIFY : Verify Selected value of date with expected value");
		String ExpectedText = "3";
		WebElement ele = select.getFirstSelectedOption();
		String ActualResult = ele.getText();
		if (ActualResult.equals(ExpectedText))
			System.out.println("Test Passed.");
		else
			System.out.println("Test Failed.");

		System.out.println("STEP : Close Driver ");
		driver.quit();
	}

	void checkMultipleSelection() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Open WebDriver");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("STEP : Wait for 2 seconds");
		Thread.sleep(2000);

		System.out.println("STEP : Scroll down till the Element is displayed");
		WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP : Create Select class object to select options ");
		Select select = new Select(element);

		System.out.println("STEP : Check wheather drop down is Single select or Multiple Select");
		System.out.println(select.isMultiple());

		System.out.println("STEP : Select Values from DropDown");
		if (select.isMultiple()) {
			for (int i = 0; i < select.getOptions().size(); i++) {
				if (i % 2 == 0)
					select.selectByIndex(i);
			}

			System.out.println("STEP : Check size of WebElement selected.");
			List<WebElement> list = select.getAllSelectedOptions();
			System.out.println("Size of Selected Element : "+list.size());

			System.out.println("VERIFY : Verify Selected value of date with expected value");
			String str1 = "1", str2 = "3", str3 = "5";
			for (WebElement e : list)
				if (e.getText().equals(str1) || e.getText().equals(str2) || e.getText().equals(str3))
					System.out.println("Test Passed.");
				else
					System.out.println("Test Failed.");
		}

		System.out.println("STEP : Close Driver ");
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		MultipleSelectProgram multiSelection = new MultipleSelectProgram();
		multiSelection.checkSingleSelection();
		multiSelection.checkMultipleSelection();
	}
}
