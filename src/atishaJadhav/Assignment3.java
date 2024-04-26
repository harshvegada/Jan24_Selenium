package atishaJadhav;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	WebDriver driver;

	// WebElement webElement;
	void openBrowser() {
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}

	void testCases() throws InterruptedException {
		openBrowser();
		System.out.println("-----Step 2. Click on Element Tab-----");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("-----Step 3. Scroll the Window-----");
		WebElement select = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", select);

		System.out.println("-----Step 4.How Many option we have to select a value 5-----");
		List<WebElement> list = driver.findElements(By.xpath("//select[@class='form-control']/option"));
		System.out.println("Options we have to select are :- " + list.size());

		System.out.println("-----Step 5.List of option that we can select : 1 2 3 4 5----- ");
		for (WebElement wb : list) {
			System.out.print("option that we can select :- " + wb.getText() + " ");
		}
		System.out.println();
		System.out.println("-----Step 6.Check weather it is Multiple Select : true-----");
		// isMultiSelect??
		Select se = new Select(select);
		if (se.isMultiple())
			System.out.println("Yes it is multiple select");
		else
			System.out.println("Not Multiselect");

		System.out.println("-----Step 7.Now Select odd Value-1,3 and 5-----");
		se.selectByVisibleText("1");
		se.selectByVisibleText("3");
		se.selectByVisibleText("5");

		System.out.println(
				"----Step 8.Print the Selected Value using method getFirstSelectedOption and.getAllSelectedOptions  ---");

		System.out.print("--Value we retrive using getFirstSelectedOption -: ");
		select = se.getFirstSelectedOption();
		System.out.print(select.getText());
		System.out.println();
		List<WebElement> selectedList = se.getAllSelectedOptions();
		System.out.print("System.out.print(\"--Value we retrive using getAllSelectedOption :-");
		for (WebElement element : selectedList) {
			System.out.print(element.getText() + " ");

		}
		System.out.println();
		System.out.println("Step 9 Close the broswer");
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Assignment3 assignment3 = new Assignment3();
		System.out.println("-----Step 1. Url Loaded and Maximized-----");

		assignment3.testCases();
	}
}
