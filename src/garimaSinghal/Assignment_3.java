package garimaSinghal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_3 {

	void getList1() throws InterruptedException {

		System.out.println("Prerequisite - Open browser & hit http://automationbykrishna.com");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("Click on Get Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Scroll the Window");
		WebElement alertElement = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);
		Select selectList = new Select(alertElement);
		System.out.println("STEP : How Many option we have to select a value");
		List<WebElement> list = selectList.getOptions();
		System.out.println(list.size());
		System.out.println("STEP : Check dropdown is multi select or not");
		System.out.println("List is MultiSelect : " + selectList.isMultiple());
		selectList.selectByVisibleText("5");
		String expected = "5";
		System.out.println("Verify : Expected Result Matched With Actual Result");
		if (selectList.getFirstSelectedOption().getText().equals(expected)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		Thread.sleep(2000);
		driver.quit();
	}

	void getMultiList() throws InterruptedException {

		System.out.println("Prerequisite - Open browser & hit http://automationbykrishna.com");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("Click on Get Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Scroll the Window");
		WebElement alertElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);
		Select selectList = new Select(alertElement);
		System.out.println("STEP : How Many option we have to select a value");
		List<WebElement> list = selectList.getOptions();
		System.out.println(list.size());
		System.out.println("STEP : List of option that we can select");
		System.out.println(list);
		System.out.println("STEP : Check dropdown is multi select or not");
		System.out.println("List is MultiSelect : " + selectList.isMultiple());
		System.out.println("STEP : Now Select odd Value-1,3 and 5");
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0)
				selectList.selectByIndex(i);
		}
		System.out.println("Verify : Expected Result Matched With Actual Result");
		for (WebElement e : list) {
			if (e.isSelected()) {
				System.out.println("Test Case passed");
			} else {
				System.out.println("TestCase Fail");
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment_3 assignment = new Assignment_3();
		System.out.println("===========Test Case 1===========");
		assignment.getList1();
		System.out.println("===========Test Case 2===========");
		assignment.getMultiList();

	}
}
