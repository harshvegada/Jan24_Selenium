package hiralPurohit;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=4}, {10101=2}]
ManagerId 20205 having maximum mentees.*/

public class Assignment_8th {
	WebDriver driver;
	WebDriverWait wait;

	void browserSetup() {
		driver = new ChromeDriver();

		System.out.println("STEP: Hit the URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		System.out.println("STEP: click on demoTable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));
	}

	void toGetMap() {

		Map<String, Integer> depMap = new HashMap<String, Integer>();
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		for (int rowindex = 1; rowindex <= size; rowindex++) {
			String empManagerID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowindex + "]/td[4]"))
					.getText();
			if (depMap.containsKey(empManagerID)) {
				int count = depMap.get(empManagerID) + 1;
				depMap.put(empManagerID, count);
			} else {
				depMap.put(empManagerID, 1);
			}
		}

		Set<String> empkey = depMap.keySet();
		int maxCount = 0;
		String temp = "";
		for (String key : empkey) {
			if (maxCount < depMap.get(key))
				;
			maxCount = depMap.get(key);
			temp = key;
		}
		System.out.println("map of department name and number of employees working in each department");
		System.out.println(depMap);
		System.out.println("ManagerId " + temp + " is having maximum mentees");
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment_8th as8 = new Assignment_8th();
		as8.browserSetup();
		as8.toGetMap();
	}
}
