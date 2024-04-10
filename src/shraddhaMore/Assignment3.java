package shraddhaMore;

/*Assignment 3: 3 April 2024
 * STEP 1: Launch the browser and hit the URL.
 * STEP 2: Click on Basic Elements.
 * STEP 3: Scroll the window till select dropdown.
 * STEP 4: Select the options expanding the dropdown menu :
 * STEP 5: Check if dropdown is multiple select.
 * STEP 6: Select any 1 option from available options.
*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	WebDriver driver;

	void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 1: Launch the browser and hit the URL.");
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(3000);
		System.out.println("Verify: Browser launched successfully");
	}

	void testCase1() throws InterruptedException {
		launchBrowser();
		System.out.println("STEP 2: Click on Basic Elements.");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP 3: Scroll down");
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectElement);
		System.out.println("Verify: Window scrolled down");
		Select selectlist = new Select(selectElement);
		System.out.println("STEP 4: Select the options from dropdown menu : ");

		List<WebElement> listOfSelectOptions = selectlist.getOptions();
		System.out.println("Size of list of options: " + listOfSelectOptions.size());
		System.out.println("STEP 5: Check if dropdown is multiple select.");
		System.out.println("Is Dropdown multiselect ? " + (selectlist.isMultiple()));
		System.out.println("STEP 6: Select any 1 option from dropdown");
		selectlist.selectByVisibleText("5");
		String expectedSelectedOption = "5";
		String actualSelectedOption = selectlist.getFirstSelectedOption().getText();
		if (actualSelectedOption.equals(expectedSelectedOption)) {
			System.out.println("Expected and actual options matches");
			System.out.println("Test pass");
		} else {
			System.out.println("Expected and Actual option does not match");
			System.out.println("Test fail");
		}
		Thread.sleep(3000);
		driver.quit();
	}

	void testCase2() throws InterruptedException {
		launchBrowser();
		System.out.println("STEP 2: Click on Basic Elements.");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP 3: Scroll the window down");
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectElement);
		System.out.println("Srolled down");
		Select selectlist = new Select(selectElement);
		System.out.println("STEP 4: Select multiple options from dropdown: ");
		List<WebElement> listOfSelectOptions = selectlist.getOptions();
		System.out.println("Size of option list is: " + listOfSelectOptions.size());
		for (WebElement e : listOfSelectOptions) {
			System.out.println(e.getText());
		}
		System.out.println("STEP 5: Check if dropdown is multiple select.");
		System.out.println("Is Dropdown multiselect ? " + (selectlist.isMultiple()));
		System.out.println("STEP 6: Select multi options from available options.");
		for (int i = 0; i < listOfSelectOptions.size(); i++) {
			if (i % 2 == 0)
				selectlist.selectByIndex(i);
		}
		System.out.println("STEP 6: Verify the multiple options selected:");
		for (WebElement e : listOfSelectOptions) {
			if (e.isSelected())
				System.out.println("Option selected: " + "-->" + e.getText());
			else
				System.out.println("Option not selected: " + "-->" + e.getText());

		}
		Thread.sleep(3000);
		driver.quit();
	}

	void test() throws InterruptedException {
		testCase1();
		testCase2();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment3().test();
	}

}