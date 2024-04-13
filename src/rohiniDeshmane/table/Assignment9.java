package rohiniDeshmane.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 Assignment 9 - 10th April'2024 [IMP]
Print Manager Id, number of reportees in each managerId, employee name under each manager as below.

20209 -> 3 -> Abhijit Mane, Sumit Kulkarni, Pawan Belamkar

 */
public class Assignment9 {
	WebDriver driver;

	void openBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();

		System.out.println("STEP : Click on table tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	void getReporteeDetails() {
		Map<String, List<String>> reporteeDetails = new HashMap();
		List<WebElement> webElement = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("VERIFY : Number of element with expected Count "+webElement.size());
	
		for(int i=1; i<=webElement.size(); i++) {
			String empManagerID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[4]")).getText();
			String employeeName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]")).getText();
		
			if(reporteeDetails.containsKey(empManagerID)) {
				List<String> emp = reporteeDetails.get(empManagerID);
				if(!emp.contains(employeeName)) {
					emp.add(employeeName);
				}
				reporteeDetails.put(empManagerID, emp);
				
			} else {
				List<String> emp = new ArrayList<String>();
				emp.add(employeeName);
				reporteeDetails.put(empManagerID, emp);
			}
		}
		System.out.println("Employee details = "+reporteeDetails);
		System.out.println("Test Case Passed");
	}
	
	public static void main(String[] args) {
		Assignment9 assignment = new Assignment9();
		assignment.openBrowser();
		assignment.getReporteeDetails();
	}
}
