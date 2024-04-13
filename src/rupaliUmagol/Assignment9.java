/*Print Manager Id, number of reportees in each managerId, employee name under each manager as below.

20209 -> 3 -> Abhijit Mane, Sumit Kulkarni, Pawan Belamkar*/
package rupaliUmagol;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment9 {
	WebDriver driver;

	void setup() {
		System.out.println("STEP : Launch Browser and hit Url");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP : Maximize Browser and add wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	Map<String, List<String>> getCountOfEmployeeMangerID() {
		System.out.println("STEP : Click on Demo table");
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("STEP : Findout total No of Rows");
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		System.out.println("STEP : Get One MAP and add Values to it");
		Map<String, List<String>> CountOfManagerID = new LinkedHashMap<>();
		for (int i = 1; i <= noOfRows; i++) {
			String EmpManagerID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			String employeeName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]")).getText();
			if (CountOfManagerID.containsKey(EmpManagerID)) {
				List<String> emp = CountOfManagerID.get(EmpManagerID);
				if (!emp.contains(employeeName))
					emp.add(employeeName);
				CountOfManagerID.put(EmpManagerID, emp);
			} else {
				List<String> emp = new ArrayList<String>();
				emp.add(employeeName);
				CountOfManagerID.put(EmpManagerID, emp);
			}
		}
		return CountOfManagerID;
	}

	public static void main(String[] args) {
		Assignment9 assignment = new Assignment9();
		assignment.setup();
		Map<String, List<String>> result = assignment.getCountOfEmployeeMangerID();
		System.out.println("Print Map :");
		System.out.println(result);
	}
}