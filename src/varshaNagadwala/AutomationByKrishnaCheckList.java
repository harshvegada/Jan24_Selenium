package varshaNagadwala;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Step 1. Url Loaded and Maximized
//Step 2. Click on Element Tab
//Step 3. Scroll the Window
//Step 4.How Many option we have to select a value
//5
//Step 5.List of option that we can select
//1 2 3 4 5 
//Step 6.Check weather it is Multiple Select
//true
//Step 7.Now Select odd Value-1,3 and 5
//Step 8.Print the Selected Value using method getFirstSelectedOption and.getAllSelectedOptions  -
//Value we retrive using getFirstSelectedOption -:
//1
//Value we retieve using getAllSelectedOptions -:
//1 3 4 
//Step 9 Close the broswer

public class AutomationByKrishnaCheckList {

	WebDriver driver;

	void openBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	void scrollToElement(WebElement ScrollElement) {
		System.out.println("STEP : Typecast the driver to JavascriptEecutor");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("STEP : Scroll the element");
		js.executeScript("arguments[0].scrollIntoView(true)",
				driver.findElement(By.xpath("//select[@class='form-control m-bot15']")));
	}

	void checkFirstList() {

		System.out.println("checkFirstList Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Basic Element link");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP : FindElement and store it is webelement");
		WebElement wb = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));

		System.out.println("STEP : Call scrolltoelement method");
		scrollToElement(wb);

		System.out.println("STEP : call Select method");
		Select selectList = new Select(wb);

		System.out.println("VERIFY : Check this list is multiList");
		if (selectList.isMultiple()) {
			System.out.println("selectList is multiList");
		} else {
			System.out.println("selectList is not multiList");
		}

		System.out.println("STEP : Select option");
		String value = "4";
		selectList.selectByVisibleText(value);

		System.out.println("VERIFY : Select option is equal to getFirstSelectedOption");
		if (value.equals(selectList.getFirstSelectedOption().getText())) {
			System.out.println(value + " is equal to " + selectList.getFirstSelectedOption().getText());
			System.out.println("checkFirstList is Pass");
		} else {
			System.out.println(value + " is not equal to " + selectList.getFirstSelectedOption().getText());
			System.out.println("checkFirstList is Fail");
		}

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void checkSecondList() {

		System.out.println("checkSecondList Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Basic Element link");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP : FindElement and store it is webelement");
		WebElement wb = driver.findElement(By.xpath("//select[@class='form-control']"));

		System.out.println("STEP : Call scrolltoelement method");
		scrollToElement(wb);

		System.out.println("STEP : call Select method");
		Select selectList = new Select(wb);

		System.out.println("VERIFY : Check this list is multiList");
		if (selectList.isMultiple()) {
			System.out.println("selectList is multiList");
		} else {
			System.out.println("selectList is not multiList");
		}

		System.out.println("STEP : Created list");
		List<WebElement> listOfOption = selectList.getOptions();

		System.out.println("STEP : Created Other list for selected option");
		List<WebElement> listOfSelectedOptions = new LinkedList<WebElement>();

		System.out.println("STEP : Select option");
		String value = "";

		for (int i = 0; i < listOfOption.size(); i += 2) {
			value = listOfOption.get(i).getText();
			selectList.selectByVisibleText(value);
		}
		listOfOption = selectList.getAllSelectedOptions();
		listOfSelectedOptions = selectList.getAllSelectedOptions();

		System.out.println("VERIFY : Select option is equal to getFirstSelectedOption");
		if (listOfOption.equals(listOfSelectedOptions)) {
			System.out.println("listOfOption is equal to listOfSelectedOptions");
			System.out.println("checkSecondList is Pass");
		} else {
			System.out.println("listOfOption is not equal to listOfSelectedOptions");
			System.out.println("checkSecondList is Fail");
		}

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) {
		AutomationByKrishnaCheckList automationByKrishnaCheckList = new AutomationByKrishnaCheckList();
		automationByKrishnaCheckList.checkFirstList();
		System.out.println();
		automationByKrishnaCheckList.checkSecondList();
	}
}
