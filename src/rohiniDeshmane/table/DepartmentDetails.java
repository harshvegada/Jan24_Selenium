package rohiniDeshmane.table;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Assignment 7 - 8th April'2024 [IMP]

Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]
 */
public class DepartmentDetails {

	WebDriver webDriver;
	
	void setUp() {
		System.out.println("STEP : URL loaded and Maximized");
		webDriver = new ChromeDriver();
		webDriver.get("http://automationbykrishna.com/index.html");
		webDriver.manage().window().maximize();
		
		System.out.println("STEP : Click on basic element tab");
		webDriver.findElement(By.xpath("//a[@id='demotable']")).click();
		
	}
	
	void mapWithDepartmentDetails() {
		HashMap<String, Integer> employeeDetails = new HashMap<>();
		System.out.println("STEP : Get Size of Employee records");
		int size = webDriver.findElements(By.xpath("//div[@id='empmanager']//table/tbody/tr")).size();    
		
		System.out.println("STEP : Get Department Details");
		for(int i=1; i<= size; i++) {
			WebElement departmentNameWE = webDriver.findElement(By.xpath("//div[@id='empmanager']//table/tbody/tr["+i+"]/td[5]"));
			String departmentName = departmentNameWE.getText();
			if(employeeDetails.containsKey(departmentName))
				employeeDetails.put(departmentName, employeeDetails.get(departmentName)+1);
			else
				employeeDetails.put(departmentName, 1);
		}
		
		System.out.println("STEP : Print Department Details");
		System.out.println(employeeDetails);
		System.out.println("Test Case Passed");
	}
	
	public static void main(String[] args) {
		DepartmentDetails departmentDetails = new DepartmentDetails();
		departmentDetails.setUp();
		departmentDetails.mapWithDepartmentDetails();
	}
}
