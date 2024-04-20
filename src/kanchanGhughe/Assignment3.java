/*
 Step 1. Url Loaded and Maximized
Step 2. Click on Element Tab
Step 3. Scroll the Window
Step 4.How Many option we have to select a value 5
Step 5.List of option that we can select : 1 2 3 4 5 
Step 6.Check weather it is Multiple Select : true
Step 7.Now Select odd Value-1,3 and 5
Step 8.Print the Selected Value using method getFirstSelectedOption and.getAllSelectedOptions  -
Value we retrive using getFirstSelectedOption -: 1
Value we retieve using getAllSelectedOptions -: 1 3 4 
Step 9 Close the broswer
 */

package kanchanGhughe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	void multiSelectEleFromDropdown() throws InterruptedException {

		System.out.println("Launch Chrome browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP:Hit and open URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP:Click on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(1000);
		System.out.println("STEP:Scroll the Window");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,1200)", "");

		Thread.sleep(2000);

		WebElement multiSelectElement = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		Select multiSelect = new Select(multiSelectElement);

		if (multiSelect.isMultiple()) {
			System.out.println("STEP:List is multi select");
		} else {
			System.out.println("STEP:List is single selected");
		}

		List<WebElement> listofAllOptions = multiSelect.getOptions();
		System.out.println("STEP:number of options available " + listofAllOptions.size());
		System.out.println("STEP : options to select");
		for (WebElement e : listofAllOptions) {
			System.out.println(e.getText() + "-> ");
		}

		System.out.println();
		System.out.println("STEP: Select option from List");

		multiSelect.selectByVisibleText("3");
		multiSelect.selectByVisibleText("3");
		multiSelect.selectByVisibleText("5");

		List<WebElement> listOfSelected = multiSelect.getAllSelectedOptions();
		for (WebElement e : listOfSelected) {
			System.out.println(e.getText() + " ");
		}

		System.out.println("STEP:Close the browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment3().multiSelectEleFromDropdown();
	}
}
