package rohiniDeshmane.dropDown;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/*
 Open http://automationbykrishna.com/index.html this URL and click on Basic element
 scroll page, and check select dropdown, there are 2 drop downs for those 2 dropdowns
 check following conditiosn : 
 1) Check weather dropdowns are multiple select or single select.
 2) Check how many options we can select for both dropdowns
 3) Select 3 number for first dropdown and verify selected value and expected value,
 if both are equals then pass test case else test case failed.
 4) For 2nd dropdown, select event index number and verify selected and expected
 value if both are equals then pass test case else test case failed.
 * 
 */
public class Assignment3MultipleSelect {
	WebDriver driver;
	
	void openBrowser() {
		System.out.println("\n\nSTEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on Basic element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
	}
	
	void selectDropDownWithSingleSelect() throws InterruptedException {
		openBrowser();
		
		System.out.println("STEP : Scorll down the window");
		Thread.sleep(2000);
		WebElement dropdownlist = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", dropdownlist);
		
		System.out.println("STEP : Check dropdown is single select or multi select ");
		Select select = new Select(dropdownlist);
		System.out.println("List is multi select = "+select.isMultiple());
		
		System.out.println("STEP : Check How many options we can select "+select.getOptions().size());
		
		System.out.println("STEP : Select value 3 from down");
		dropdownlist.sendKeys("3");
		
		System.out.println("Verify : Expected value and selected value matched or not");
		if(select.getFirstSelectedOption().getText().equals("3"))
			System.out.println("Test Case Passed");
		else
			System.out.println("Test Case Failed");
		
		Thread.sleep(2000);
		System.out.println("STEP : Browser close");
		driver.quit();
	}
	
	void selectDropDownWithMultiSelect() throws InterruptedException {
		openBrowser();
		
		System.out.println("STEP : Scroll down Window");
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", dropdown);
		
		System.out.println("STEP : Check list is single select or multi select");
		Select select = new Select(dropdown);
		System.out.println("Checkt list single select or multi select = " + select.isMultiple());
		
		System.out.println("STEP : Check how many number of elements we can select "+select.getOptions().size());
		
		System.out.println("STEP : Select event index numbers");
		for(int i=0; i<select.getOptions().size(); i++) {
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
		
		Thread.sleep(2000);
		System.out.println("STEP : Browser close");
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment3MultipleSelect assignment3MultipleSelect = new Assignment3MultipleSelect();
		assignment3MultipleSelect.selectDropDownWithSingleSelect();
		assignment3MultipleSelect.selectDropDownWithMultiSelect();
	}
}
