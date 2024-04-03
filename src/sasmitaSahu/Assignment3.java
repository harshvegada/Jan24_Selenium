package sasmitaSahu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	
	void isDropdownMultiselect() throws InterruptedException {
		System.out.println("STEP1-Lunch the chrome browser");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP2-Maximize chrome browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP3-Hit the url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP4-Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(3000);
		
		System.out.println("STEP5-Scroll down the browser");
		WebElement dropdownElement= driver.findElement(By.xpath("//select[@class ='form-control m-bot15']"));
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)",dropdownElement);
		
		System.out.println("STEP6-Select from dropsown");
		Select element= new Select(dropdownElement);
		element.selectByIndex(3);
		
		System.out.println("VERIFY-Selected dropdown value");
		WebElement selectedElements = element.getFirstSelectedOption();
		System.out.println(selectedElements .getText());
		
		System.out.println("VERIFY-Dropdown is multiselected");
		System.out.println(element.isMultiple());
		
		System.out.println("Step-7-Close the browser");
		driver.quit();
	}
	void multiseelect() throws InterruptedException {
		System.out.println("STEP1-Lunch the chrome browser");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP2-Maximize chrome browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP3-Hit the url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP4-Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(3000);
		
		System.out.println("STEP5-Scroll down the browser");
		WebElement dropdownElement2= driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor je2= (JavascriptExecutor)driver;
		je2.executeScript("arguments[0].scrollIntoView(true)",dropdownElement2);
		driver.findElement(By.xpath("//select[@class ='form-control']"));
		
		System.out.println("STEP6-Select value from dropdown");
		Select dropdown= new Select(dropdownElement2);
		dropdown.selectByIndex(0);
		dropdown.selectByIndex(2);
		dropdown.selectByIndex(4);
		
		System.out.println("STEP7-Total dropdown values");
		Select select = new Select(dropdownElement2);
		List<WebElement> list= select.getOptions();
		System.out.println(list.size());
		
		System.out.println("STEP8-List of values present in the drop down");
		for (WebElement element : list) {
			System.out.print(element.getText()+" " );
		}
		
		System.out.println();
		
		System.out.println("VERIFY-Total selected dropdown value");
		List<WebElement> list2 = select.getAllSelectedOptions();
		for (WebElement element : list2) {
			System.out.print(element.getText() + " ");
		}
		System.out.println();
		System.out.println("VERIFY-1st selected dropdown value");
		WebElement multipleElements = dropdown.getFirstSelectedOption();
		System.out.println(multipleElements .getText());
		
		System.out.println("VERIFY-Dropdown is multiselected");
		System.out.println(dropdown.isMultiple());
		
		System.out.println("STEP9-Close the browser");
		driver.quit();
		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment3 assignment3= new Assignment3();
		//assignment3.isDropdownMultiselect();
		System.out.println("==================");
		assignment3.multiseelect();
	}

}
