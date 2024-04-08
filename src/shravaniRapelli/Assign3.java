package shravaniRapelli;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign3 {

	WebDriver driver;
	void setUp() {
		driver = new ChromeDriver();
		System.out.println("STEP : Launch the browser");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		
	}
	
	void toCheckSingleSelection() throws InterruptedException {
		setUp();
		System.out.println("STEP : Clicking on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,1400)");
		
		WebElement ele = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		Select select = new Select(ele);
		System.out.println("STEP : Check wheather the dropdown is single slect or multiselect");
		System.out.println(select.isMultiple());
		
		System.out.println("STEP : Select value 3 from dropdown");
		if(!select.isMultiple()) {
			select.selectByVisibleText("3");
		}
		
		System.out.println("VERIFY : Verify select vaule is correct");
		String expectedText = "3";
		WebElement element = select.getFirstSelectedOption();
		String actualText = element.getText();
		if(actualText.equals(expectedText)) {
			System.out.println("TestCase Pass");
		}else
			System.out.println("TestCase Fail");
		
		driver.quit();
	}
	
	void toCheckMultiSelection() throws InterruptedException {
		setUp();
		System.out.println("STEP : Clicking on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,1400)");
		WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(element);
		System.out.println("STEP : Check wheather the dropdown is single slect or multiselect");
		System.out.println(select.isMultiple());
		
		System.out.println("STEP : Select values from dropdown");
		if(select.isMultiple()) {
			select.selectByVisibleText("1");
			select.selectByVisibleText("3");
			select.selectByVisibleText("5");
		}
		System.out.println("STEP : Check size of select elements");
		List<WebElement> list = select.getAllSelectedOptions();
		System.out.println(list.size());
		
		System.out.println("VERIFY : verify selected and expected value");
		for(WebElement ele : list) {
			if(ele.getText().equals("1") || ele.getText().equals("3") || ele.getText().equals("5"))
				System.out.println("TestCase Pass");
			else
				System.out.println("TestCase Fail");
		}
		driver.quit();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assign3 assgn3 = new Assign3();
		assgn3.setUp();
		assgn3.toCheckSingleSelection();
		assgn3.toCheckMultiSelection();
	}
}
