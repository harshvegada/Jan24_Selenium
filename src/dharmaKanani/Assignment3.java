package dharmaKanani;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	WebDriver driver;

	void openBrowser() {
		System.out.println("Step: Launch Chrome browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step: Hit the URL");
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("STEP : Click on Basic element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

	}

	void selectDropDownWithSingleSelect() {
		openBrowser();

		System.out.println("STEP : Scorll down the window");
		WebElement dropdownlist = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", dropdownlist);

		System.out.println("STEP : Check dropdown is single select or multi select ");
		Select select = new Select(dropdownlist);
		System.out.println("List is multi select = "+select.isMultiple());

		System.out.println("STEP : Check How many options we can select " + select.getOptions().size());

		System.out.println("STEP : Select value 3 from down");
		dropdownlist.sendKeys("3");

		System.out.println("Verify : Expected value and selected value matched or not");
		if(select.getFirstSelectedOption().getText().equals("3"))
			System.out.println("Test Case Passed");
		else
			System.out.println("Test Case Failed");

		System.out.println("STEP : Browser close");
		driver.quit();
	}

	void selectDropDownWithMultiSelect() {
		openBrowser();

		System.out.println("STEP : Scroll down Window");
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", dropdown);

		System.out.println("STEP : Check list is single select or multi select");
		Select select = new Select(dropdown);
		System.out.println("Checkt list single select or multi select = " + select.isMultiple());

		System.out.println("STEP : Check how many number of elements we can select " + select.getOptions().size());

		System.out.println("STEP : Select event index numbers");
		for(int i = 0; i < select.getOptions().size(); i++) {
			if(i%2 == 0)
				select.selectByIndex(i);
		}

		System.out.println("Check size of web element selected ");
		List<WebElement> list = select.getAllSelectedOptions();
		System.out.println(list.size());

		System.out.println("VERIFY : verify selected and expected value");
		for(WebElement element : list) {
			if(element.getText().equals("1") || element.getText().equals("3") || element.getText().equals("5"))
				System.out.println("Test Passed !");
			else
				System.out.println("Test Failed !");
		}

		System.out.println("STEP : Browser close");
		driver.quit();
	}
	
	public static void main(String[] args) {
		Assignment3 ass3 = new Assignment3();
		ass3.selectDropDownWithSingleSelect();
		ass3.selectDropDownWithMultiSelect();
	}
}	

