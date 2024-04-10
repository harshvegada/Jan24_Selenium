package varshaNagadwala;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Print Manager Id, number of reportees in each managerId, employee name under each manager as below.
//20209 -> 3 -> Abhijit Mane, Sumit Kulkarni, Pawan Belamkar

public class ABKFindFreqOfManagerIdInTable2 {

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

	void listOfMenteesUnderEachManager() {
		Map<String, List<String>> mapOfManagerId = new LinkedHashMap<>();
		System.out.println("TestCases Start");
		openBrowser();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

		System.out.println("STEP : Total number of row in table ");
		int totalRow = driver.findElements(By.xpath("//table[@class= 'table table-striped']/tbody/tr/td[5]")).size();

		System.out.println("STEP: Find the total frequency of ManagerId");
		for (int rowIndex = 1; rowIndex <= totalRow; rowIndex++) {
			String manageId = driver
					.findElement(By.xpath("//table[@class= 'table table-striped']/tbody/tr[" + rowIndex + "]/td[4]"))
					.getText();
			String mentees = driver
					.findElement(By.xpath("//table[@class= 'table table-striped']/tbody/tr[" + rowIndex + "]/td[3]"))
					.getText();

			if (mapOfManagerId.containsKey(manageId)) {
				List<String> list = mapOfManagerId.get(manageId);
				list.add(mentees);
				mapOfManagerId.put(manageId, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(mentees);
				mapOfManagerId.put(manageId, list);
			}
		}
		Set<String> keySet = mapOfManagerId.keySet();
		for (String mangerId : keySet) {
			List<String> list = mapOfManagerId.get(mangerId);
			System.out.println(mangerId + " : " + list.size() + " -> " + list);
		}

		System.out.println("STEP : Close the browser");
		driver.quit();
	}

	public static void main(String[] args) {
		ABKFindFreqOfManagerIdInTable2 aBKFindFreqOfManagerIdInTable = new ABKFindFreqOfManagerIdInTable2();
		aBKFindFreqOfManagerIdInTable.listOfMenteesUnderEachManager();
	}
}
