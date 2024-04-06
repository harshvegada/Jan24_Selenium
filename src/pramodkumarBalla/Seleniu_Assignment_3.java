package pramodkumarBalla;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//TestCase1 - Get List1
//TestCase2 - Verify, list1 is multiselect
//TestCase3 - Select value in List1
//TestCase4 - Get selected value from List1
//TestCase5 - Verify the entered value is matching
//
//TestCase6 - Get List2
//TestCase7 - Verify, list1 is multiselect
//TestCase8 - Select odd numbers in List2
//TestCase9 - Get selected values from List1
//TestCase10 - Verify the entered values are matching

public class Seleniu_Assignment_3 {

	// Creating Chrome webdriver object
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Sleep for 2 mins");
		Thread.sleep(2000);
	}

	void multiSelect1() throws InterruptedException
	{
		// Open browser
		openBrowser();

		// Clicking on Basic Element tab
		System.out.println("click on basicelements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Sleep for 2 sec");
		Thread.sleep(2000);

		// Finding the element if not visible in view port
		System.out.println("scroll Into View");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//label[text()=\"Selects\"]")));

		System.out.println("Select the dropdown");
		WebElement w1= driver.findElement(By.xpath("//div/select[@class='form-control m-bot15']"));
		Select list1Select=new Select(w1);

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

	void multiSelect2() throws InterruptedException
	{
		// Open browser
		openBrowser();

		// Clicking on Basic Element tab
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Sleep for 2 sec");
		Thread.sleep(2000);

		// Finding the element if not visible in view port
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//label[text()=\"Selects\"]")));

		WebElement e4= driver.findElement(By.xpath("//div/select[@class='form-control']"));
		Select s6= new Select(e4);

		if(s6.isMultiple()) {
			System.out.println("List2 is multiselect");
		} else {
			System.out.println("List2 is not multiselect");
		}

		int list2Size = s6.getOptions().size();

		// Declaring list to capture user entered values in list2
		List<WebElement> userSelectedOptionsList2 = new LinkedList<WebElement>();

		for (int index = 1; index <= list2Size; index++) {
			if (index % 2 != 0) {
				s6.selectByVisibleText(Integer.toString(index));
				userSelectedOptionsList2 = s6.getAllSelectedOptions();
			}
		}

		// Declaring list to entered values in list2
		List<WebElement> selectedOptionsList2 = new LinkedList<WebElement>();

		// TestCase4 - Get selected value from List1
		selectedOptionsList2 = s6.getAllSelectedOptions();

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

		Seleniu_Assignment_3 s3 = new Seleniu_Assignment_3();
		s3.multiSelect1();
		s3.multiSelect2();
	}

}
