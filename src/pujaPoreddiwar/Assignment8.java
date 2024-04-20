/*
 * Assignment 8 - 10th April'2024 [IMP]
Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=4}, {10101=2}]
ManagerId 20205 having maximum Mentors.
 */

package pujaPoreddiwar;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment8 {

	WebDriver driver;

	void setUp() {
		driver = new ChromeDriver();
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP - click on Demo link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']/tbody/tr")));
	}

	void testCase1() {
		setUp();
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText();
			if (map.containsKey(managerId)) {
				int count = map.get(managerId) + 1;
				map.put(managerId, count);
			} else {
				map.put(managerId, 1);
			}
		}
		System.out.println("STEP :Department name and number of employees working in each department");
		System.out.println(map);
		int maxCount = 0;
		String output = "";
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (maxCount < map.get(key)) {
				maxCount = map.get(key);
				output = key;
			}
		}
		System.out.println("ManagerId " + output + " having Maximum Mentors");
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment8 assignment_8 = new Assignment8();
		assignment_8.testCase1();
	}
}
