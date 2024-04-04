package akshadaRajput;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelections {

	WebDriver driver;


	void launchBrowser() {
		System.out.println("Step 1: Launching browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
	}

	void selectActionsSingle() throws InterruptedException {
		System.out.println("Step 2: Clicking on the Basic Elements Tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		WebElement dropdownFormat = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		Select select = new Select(dropdownFormat);
		if (dropdownFormat.isDisplayed()) {
			System.out.println("Step 3: Checking dropdown selection pattern");
			if (!select.isMultiple()) {
		
				System.out.println("Single Select");
				singleSelection();
				
			}
				
			else {
				System.out.println("Step 3: Scrolling the Window");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", dropdownFormat);
				
				System.out.println("Step 4: Checking dropdown selection pattern");
				
				
				if (!select.isMultiple()) {
					System.out.println("Single Select");
					singleSelection();
				}
				}
					

		}

	}

	void singleSelection() {
		WebElement dropdownFormat = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		
		
		System.out.println("Step 5 : Printing the total number of options available for selection");
		
		Select select= new Select (dropdownFormat);
		List<WebElement> options=select.getOptions();
		
		System.out.println("Options to select:" + options.size());
		
		System.out.println("Step 6 : Printing the list of options available for selection");
		for(WebElement e: options) {
			System.out.println(e.getText());
		}

		System.out.println("Step 7: Selecting option 3");
		select.selectByVisibleText("3");
		
		WebElement e=select.getFirstSelectedOption();
		System.out.println( e.getText() + " is selected");

	}
	
	

	void selectActionsMultiple() throws InterruptedException {
		

		System.out.println("Step 8: Clicking on the Basic Elements Tab");
		
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		WebElement multipleSelectionDropDown=driver.findElement(By.xpath("//select[@class='form-control']"));

		Select select= new Select(multipleSelectionDropDown);

		System.out.println("Step 9: Checking dropdown selection pattern");
		
		if(multipleSelectionDropDown.isDisplayed()) {
			if(select.isMultiple()) {
		System.out.println("Multiple Select");
		multipleSelection();
	}
		}
	else {
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argumets[0].scrollIntoView(true)", multipleSelectionDropDown);

		System.out.println("Step 9: Checking dropdown selection pattern");
		
		if(select.isMultiple()) {
			System.out.println("Multiple Select");
		multipleSelection();
	}
	}
	}
	void multipleSelection() {
		WebElement multipleSelectionDropDown=driver.findElement(By.xpath("//select[@class='form-control']"));
		System.out.println("Step 10 : Printing the total number of options available for selection");
		
		Select select= new Select (multipleSelectionDropDown);
		List<WebElement> options=select.getOptions();
		System.out.println("Options to select:" + options.size());
		
		System.out.println("Step 11 : Printing the list of options available for selection");
		
		for(WebElement e: options) {
			System.out.println(e.getText());
		}
		
		System.out.println("Step 12: Selecting option odd numbers in the options");
		select.selectByIndex(0);
		select.selectByIndex(2);
		select.selectByVisibleText("5");
		
	List<WebElement> selectedOptions=select.getAllSelectedOptions();
	for(WebElement e: selectedOptions) {
		System.out.println("Step 13 " + e.getText() + " are selected");
	}
		
	}
	
	void closeBrowser() {
		System.out.println("Step 14: Closing the broswer");
		driver.quit();
	}
	
	public static void main(String args[]) throws InterruptedException {
		DropDownSelections dropDownSelections = new DropDownSelections();
		dropDownSelections.launchBrowser();
		dropDownSelections.selectActionsSingle();
		dropDownSelections.closeBrowser();
		dropDownSelections.launchBrowser();
		dropDownSelections.selectActionsMultiple();
		dropDownSelections.closeBrowser();
	}
}
