package madhuraKulkarni;

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
		System.out.println("Browser launched successfully...");
	}

	void verifyIsMultipleDropdownTestCase1() throws InterruptedException {
		launchBrowser();
		System.out.println("STEP 2: Click on Basic Elements.");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP 3: Scroll the window till select dropdown.");
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectElement);
		System.out.println("Srolled upto select dropdown...");
		Select selectlist = new Select(selectElement);
		System.out.println("STEP 4: Select the options expanding the dropdown menu : ");

		List<WebElement> listOfSelectOptions = selectlist.getOptions();
		System.out.println("Size of list of select options is : " + listOfSelectOptions.size());
		System.out.println("STEP 5: Check if dropdown is multiple select.");
		System.out.println("Is Dropdown multiselect ? " + (selectlist.isMultiple()));
		System.out.println("STEP 6: Select any 1 option from available options.");
		selectlist.selectByVisibleText("4");
		String expectedSelectedOption = "4";
		String actualSelectedOption = selectlist.getFirstSelectedOption().getText();
		if (actualSelectedOption.equals(expectedSelectedOption)) {
			System.out.println("Expected selected option matches with actual selected option...");
			System.out.println("Test passed...");
		} else {
			System.out.println("Expected selected option doesn't match with actual selected option...");
			System.out.println("Test failed...");
		}
		Thread.sleep(3000);
		driver.quit();
	}

	void verifyIsMultipleDropdownTestCase2() throws InterruptedException {
		launchBrowser();
		System.out.println("STEP 2: Click on Basic Elements.");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP 3: Scroll the window till select dropdown.");
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectElement);
		System.out.println("Srolled upto select dropdown...");
		Select selectlist = new Select(selectElement);
		System.out.println("STEP 4: Select the multiple options : ");
		List<WebElement> listOfSelectOptions = selectlist.getOptions();
		System.out.println("Size of list of select options is : " + listOfSelectOptions.size());
		System.out.println("List of available optins for selection");
		for (WebElement e : listOfSelectOptions) {
			System.out.println(e.getText());
		}
		System.out.println("STEP 5: Check if dropdown is multiple select.");
		System.out.println("Is Dropdown multiselect ? " + (selectlist.isMultiple()));
		System.out.println("STEP 6: Select multiple options (1,3 & 5) from available options.");
		for (int i = 0; i < listOfSelectOptions.size(); i++) {
			if (i % 2 == 0)
				selectlist.selectByIndex(i);
		}
		System.out.println("STEP 6: Verify the multiple options selected:");
		for (WebElement e : listOfSelectOptions) {
			if (e.isSelected())
				System.out.println("Option selected: " + "-->" + e.getText() + " Test passed...");
			else
				System.out.println("Option not selected: " + "-->" + e.getText() + " Test failed...");

		}
		Thread.sleep(3000);
		driver.quit();
	}

	void display() throws InterruptedException {
		System.out.println("-----------------Test Case 1 execution -------------------");
		System.out.println("Test Case 1: Verify the dropdown selection when multiple option selection is not enabled.");
		verifyIsMultipleDropdownTestCase1();
		System.out.println("-----------------Test Case 2 execution -------------------");
		System.out.println("Test Case 1: Verify the dropdown selection when multiple option selection is enabled.");
		verifyIsMultipleDropdownTestCase2();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment3().display();
	}

}
