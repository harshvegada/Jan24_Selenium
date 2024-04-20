/*
 * Assignment 7 - 8th April'2024 [IMP]

Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]
 */

package pujaPoreddiwar;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment7 {

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
				.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")));
	}

	void testCase1() {
		setUp();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 1; i <= row; i++) {
			String depttname = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			if (map.containsKey(depttname)) {
				int count = map.get(depttname) + 1;
				map.put(depttname, count);
			} else {
				map.put(depttname, 1);
			}
		}
		System.out.println("STEP : Department name and number of employees working in each department");
		System.out.println(map);
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment7 assignment7 = new Assignment7();
		assignment7.testCase1();
	}
}