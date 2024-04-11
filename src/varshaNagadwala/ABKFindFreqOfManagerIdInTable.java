package varshaNagadwala;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Return the map of department name and number of employees working in each department.
//Hint : Map<String, Integer>
//output : [{20209=3}, {20205=2=4}, {10101=2}]
//ManagerId 20205 having maximum mentees.

public class ABKFindFreqOfManagerIdInTable {

	WebDriver driver;
	WebDriverWait wait;

	void openBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Basic Element link");
		driver.findElement(By.linkText("Demo Tables")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	Map<String, Integer> findFreqOfEmployeesworkingUnderEachManager() {
		Map<String, Integer> mapOfManagerId = new LinkedHashMap<>();
		System.out.println("checkFirstList Start");
		openBrowser();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("STEP : Total number of row in table ");
		int totalRow = driver.findElements(By.xpath("//table[@class= 'table table-striped']/tbody/tr/td[5]")).size();

		System.out.println("STEP: Find the total frequency of ManagerId");
		for (int rowIndex = 1; rowIndex <= totalRow; rowIndex++) {
			String manageId = driver
					.findElement(By.xpath("//table[@class= 'table table-striped']/tbody/tr[" + rowIndex + "]/td[4]"))
					.getText();

			if (mapOfManagerId.containsKey(manageId)) {
				int count = mapOfManagerId.get(manageId) + 1;
				mapOfManagerId.put(manageId, count);
			} else {
				mapOfManagerId.put(manageId, 1);
			}
		}
		return mapOfManagerId;
	}

	String getMaxmanagerId() {
		int maxId = 0;
		String managerName = "";

		Map<String, Integer> mapOfManagerId = findFreqOfEmployeesworkingUnderEachManager();

		System.out.println(mapOfManagerId);

		System.out.println("STEP : Find the manager have more employee");
		Set<String> keySet = mapOfManagerId.keySet();
		for (String kSet : keySet) {
			Integer value = mapOfManagerId.get(kSet);
			if (maxId < value) {
				maxId = value;
				managerName = kSet;
			}
		}
		return managerName;
	}

	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}

	public static void main(String[] args) {
		ABKFindFreqOfManagerIdInTable aBKFindFreqOfManagerIdInTable = new ABKFindFreqOfManagerIdInTable();
		System.out.println("Having maximum mentees : " + aBKFindFreqOfManagerIdInTable.getMaxmanagerId());
		aBKFindFreqOfManagerIdInTable.closeBrowser();
	}
}
