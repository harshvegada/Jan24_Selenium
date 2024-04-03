/*
 * TestCase1 - Get List1
 * TestCase2 - Verify, list1 is multiselect
 * TestCase3 - Select value in List1
 * TestCase4 - Get selected value from List1
 * TestCase5 - Verify the entered value is matching
 * 
 * TestCase6 - Get List2
 * TestCase7 - Verify, list2 is multiselect
 * TestCase8 - Select odd numbers in List2
 * TestCase9 - Get selected values from List2
 * TestCase10 - Verify the entered values are matching
 *  */

package phenolVerma;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KrishnaListItemCheck {

	// Creating Chrome webdriver object
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");

	}

	void automateList1() throws InterruptedException {
		// Open browser
		openBrowser();
		// Clicking on Basic Element tab
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Sleep for 2 sec");
		Thread.sleep(2000);

		// Finding the element if not visible in view port
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")));

		// TestCase1 - Get List1
		WebElement webElementList1 = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		Select list1Select = new Select(webElementList1);

		// TestCase2 - Verify, list1 is multiselect
		if (list1Select.isMultiple()) {
			System.out.println("List1 is multiselect");
		} else {
			System.out.println("List1 is not multiselect");
		}

		// TestCase3 - Select value in List1
		String selectOption = "3";
		list1Select.selectByVisibleText(selectOption);

		// TestCase4 - Get selected value from List1
		System.out.println("Selected value in List1 by user - " + list1Select.getFirstSelectedOption().getText());

		// TestCase5 - Verify the entered value is matching
		if (selectOption.equals(list1Select.getFirstSelectedOption().getText())) {
			System.out.println("Selected value is matching");
		} else {
			System.out.println("Selected value is not matching");

		}
		System.out.println("Quiting browser");
		driver.quit();
	}

	void automateList2() throws InterruptedException {
		// Open browser
		openBrowser();

		// Clicking on Basic Element tab
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Sleep for 2 sec");
		Thread.sleep(2000);

		// Finding the element if not visible in view port
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//button[@id=\"javascriptAlert\"]")));

		// TestCase6 - Get List2
		WebElement webElementList2 = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select list2Select = new Select(webElementList2);

		// TestCase7 - Verify, list2 is multiselect
		if (list2Select.isMultiple()) {
			System.out.println("List2 is multiselect");
		} else {
			System.out.println("List2 is not multiselect");
		}

		// TestCase8 - Select odd numbers in List2
		int list2Size = list2Select.getOptions().size();
		System.out.println("Multilist2 size - " + list2Size);

		// Declaring list to capture user entered values in list2
		List<WebElement> userSelectedOptionsList2 = new LinkedList<WebElement>();

		for (int index = 1; index <= list2Size; index++) {
			if (index % 2 != 0) {
				list2Select.selectByVisibleText(Integer.toString(index));
				userSelectedOptionsList2 = list2Select.getAllSelectedOptions();
			}
		}

		// Declaring list to entered values in list2
		List<WebElement> selectedOptionsList2 = new LinkedList<WebElement>();

		// TestCase4 - Get selected value from List1
		selectedOptionsList2 = list2Select.getAllSelectedOptions();

		// TestCase5 - Verify the entered value is matching
		if (userSelectedOptionsList2.equals(selectedOptionsList2)) {
			System.out.println("Selected values are matching");
		} else {
			System.out.println("Selected values are not matching");
		}

		System.out.println("Quiting browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		KrishnaListItemCheck krishnaListItemCheck = new KrishnaListItemCheck();
		System.out.println("Output for single selected list");
		krishnaListItemCheck.automateList1();
		
		System.out.println("***********************************************");

		System.out.println("Output for multi selected list");
		krishnaListItemCheck.automateList2();
	}
}
