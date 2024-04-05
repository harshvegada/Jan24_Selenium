package ashwiniBalki;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

/*
Assignment - 3 : 3rd April'2024
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
Step 9 Close the broswer.
 */
public class Assgn3_SelectDropdownOptions {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step 1 : Url Loaded and Maximized ");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html#");

		System.out.println("Step 2. Click on Element Tab");
		driver.findElement(By.xpath("//a[@id ='basicelements']")).click();

		Thread.sleep(3000);
		System.out.println("Step 3. Scroll the Window");
		WebElement selectElement = driver.findElement(By.xpath("//select[@class ='form-control m-bot15']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectElement);

		System.out.println("Step 4.How Many option we have to select from dropdown.");
		// object of Select class
		Select sd = new Select(selectElement);

		// get options of dropdown in list
		List<WebElement> dropdownOption = sd.getOptions();
		System.out.print("options are : ");
		int value;
		System.out.println(dropdownOption.size());
		value = dropdownOption.size();

		System.out.println("Step 5.List of option that we can select : 1 2 3 4 5");

		for (int i = 0; i < dropdownOption.size(); i++) {
			System.out.println(dropdownOption.get(i).getText());
		}

		System.out.println("Step 6.Check weather it is Multiple Select");
		// return true if multi-select dropdown
		Thread.sleep(2000);
		WebElement multiselectElement = driver.findElement(By.xpath("//select[@class ='form-control']"));
		Select multiselect = new Select(multiselectElement);

		boolean b = multiselect.isMultiple();
		System.out.println("Boolen value for drodown: " + b);

		Thread.sleep(3000);
		System.out.println("Step 7.Now Select odd Value: 1,3 and 5");
		multiselect.selectByVisibleText("1");
		Thread.sleep(3000);
		multiselect.selectByVisibleText("3");
		Thread.sleep(3000);
		multiselect.selectByVisibleText("5");
		Thread.sleep(3000);

		System.out.println("Step 8.Print first Selected Value");
		// using method getFirstSelectedOption and getAllSelectedOptions
		System.out.println(multiselect.getFirstSelectedOption().getText());
		System.out.println("Print all Selected Value");
		List<WebElement> allOption = multiselect.getAllSelectedOptions();
		for (int i = 0; i < allOption.size(); i++) {
			System.out.println(allOption.get(i).getText());
		}
	}

}
