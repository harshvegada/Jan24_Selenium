/*Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=2=4}, {10101=2}]
ManagerId 20205 having maximum mentees. 
 */
package rupaliUmagol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
	WebDriver driver;

	void setup() {
		System.out.println("STEP : Launch Browser and hit Url");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP : Maximize Browser and add wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	Map<String, Integer> getCountOfEmployeeMangerID() {
		System.out.println("STEP : Click on Demo table");
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("STEP : Findout total No of Rows");
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		System.out.println("STEP : Get One MAP and add Values to it");
		Map<String, Integer> CountOfManagerID = new LinkedHashMap<>();
		for (int i = 1; i <= noOfRows; i++) {
			String EmpManagerID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			if (CountOfManagerID.containsKey(EmpManagerID)) {
				int count = CountOfManagerID.get(EmpManagerID);
				CountOfManagerID.put(EmpManagerID, count + 1);
			} else
				CountOfManagerID.put(EmpManagerID, 1);
		}

		Set<String> Keys = CountOfManagerID.keySet();
		int max = 0;
		String value = "";
		for (String key : Keys) {
			if (CountOfManagerID.get(key) > max) {
				max = CountOfManagerID.get(key);
				value = key;
			}
		}
		System.out.println("ManagerId " + value + " having maximum mentees.");
		return CountOfManagerID;
	}

	public static void main(String[] args) {
		Assignment8 assignment = new Assignment8();
		assignment.setup();
		Map<String, Integer> result = assignment.getCountOfEmployeeMangerID();
		System.out.println("Print Map :");
		System.out.println(result);
	}
}
