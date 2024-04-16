/*Assignment 8 - 10th April'2024 [IMP]

Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=2=4}, {10101=2}]
ManagerId 20205 having maximum mentees.*/

package madhuraKulkarni;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {
	WebDriver driver;

	void launchBrowser() {
		System.out.println("STEP: Launch browser and hit URL");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("STEP: Driver launched successfully...");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'table-striped')]")));
	}

	// Return the map of department name and number of employees working in each
	// department.

	void getMapOfDeptAndEmployee() {
		launchBrowser();
		int rowCount = driver.findElements(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr")).size();
		Map<String, Integer> mapOfEmp = new HashMap<String, Integer>();

		for (int i = 1; i <= rowCount; i++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			if (mapOfEmp.containsKey(managerId)) {
				int count = mapOfEmp.get(managerId) + 1;
				mapOfEmp.put(managerId, count);
			} else {
				mapOfEmp.put(managerId, 1);
			}
		}
		System.out.println("STEP : Get managerIds and employee working in each department.");
		System.out.println(mapOfEmp);
		int maxCount = 0;
		String data = "";
		Set<String> keyset = mapOfEmp.keySet();
		for (String key : keyset) {
			if (maxCount < mapOfEmp.get(key)) {
				maxCount = mapOfEmp.get(key);
				data = key;
			}
		}
		System.out.println("ManagerID : " + data + " is having maximum mentees.");
		driver.quit();
	}

	public static void main(String[] args) {
		new Assignment8().getMapOfDeptAndEmployee();
	}
}
