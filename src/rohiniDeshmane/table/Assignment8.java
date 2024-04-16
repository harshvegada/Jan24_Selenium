package rohiniDeshmane.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Assignment 8 - 10th April'2024 [IMP]

Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=2=4}, {10101=2}]
ManagerId 20205 having maximum mentees.
*/

public class Assignment8 {

WebDriver driver;
	
	void openBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on table tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	void departmentDetails() {
		Map<String, Integer> departMEntDetails = new HashMap<>();
		List<WebElement> webElement = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("VERIFY : Number of element with expected Count "+webElement.size());
		
		for(int i=1; i<=webElement.size(); i++) {
			String managementID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[4]")).getText();
			if(departMEntDetails.get(managementID) != null) {
				departMEntDetails.put(managementID, departMEntDetails.get(managementID)+1);
			} else
				departMEntDetails.put(managementID, 1);
		}
		
		System.out.println("Department details : "+departMEntDetails);
		System.out.println("Test Case Passed !");
	}
	
	public static void main(String[] args) {
		Assignment8 assignment8 = new Assignment8();
		assignment8.openBrowser();
		assignment8.departmentDetails();
		
	}
}
