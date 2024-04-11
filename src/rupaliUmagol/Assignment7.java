/*Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]
 */
package rupaliUmagol;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	static WebDriver driver;

	void setup() {
		System.out.println("STEP : Launch Browser and hit Url");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP : Maximize Browser and add wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	Map<String, Integer> MapOfDeprtEmployee() {
		System.out.println("STEP : Click on Demo table");
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("STEP : Findout total No of Rows");
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		System.out.println("STEP : Take one Map and add Values to it");
		Map<String, Integer> mapOfDeprt = new LinkedHashMap<>();
		for (int i = 1; i <= noOfRows; i++) {
			String departmentName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			if (mapOfDeprt.containsKey(departmentName)) {
				int count = mapOfDeprt.get(departmentName);
				mapOfDeprt.put(departmentName, count + 1);
			} else
				mapOfDeprt.put(departmentName, 1);
		}
		return mapOfDeprt;
	}

	public static void main(String[] args) {
		Assignment7 assignment = new Assignment7();
		assignment.setup();
		Map<String, Integer> result = assignment.MapOfDeprtEmployee();

		System.out.println("STEP : Print Values from MAP");
		System.out.println(result);

		System.out.println("STEP : Close Browser");
		driver.quit();
	}
}
