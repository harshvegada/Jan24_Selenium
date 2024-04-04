package akshayGaikwad;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {
	WebDriver driver = new ChromeDriver();
	
	void multiSelect() {
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		System.out.println("STEP : Launch Brower and hit URL");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP : Go to Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		
		System.out.println("STEP : Scroll to list");
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		WebElement multiSelectEle = driver.findElement(By.xpath("//select[@class='form-control']"));
		je.executeScript("arguments[0].scrollIntoView(true)", multiSelectEle);
				
		Select multiSelect = new Select(multiSelectEle);
		
		if(multiSelect.isMultiple()) {
			System.out.println("VERIFY : List is multiselect");
		}else {
			System.out.println("VERIFY : List is single selected");
		}
		
		List<WebElement> listOfAllOptions = multiSelect.getOptions();
		
		System.out.println("VERFIY : Number of options avilable to select : " + listOfAllOptions.size());
		System.out.print("VERIFY : Options to select : ");
		
		for(WebElement we : listOfAllOptions) {
			System.out.print(we.getText() + " ");
		}
		System.out.println();
		System.out.println("STEP : Select options from list");
		
		multiSelect.selectByVisibleText("1");
		multiSelect.selectByVisibleText("3");
		multiSelect.selectByVisibleText("5");
		
		List<WebElement> listOfSelected  = multiSelect.getAllSelectedOptions();
		
		System.out.print("VERIFY : All selected options from list are : ");
		for(WebElement we : listOfSelected) {
			System.out.print(we.getText() + " ");
		}
		System.out.println();
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	public static void main(String[] args){
		new MultiSelect().multiSelect();
	}
}
