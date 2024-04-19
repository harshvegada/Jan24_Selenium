package ashwiniBalki;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Assignment 8 - 10th April'2024 [IMP]
Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=2=4}, {10101=2}]
ManagerId 20205 having maximum mentees."
 */
public class Assignment8 {

	WebDriver driver;

	void setupLaunchBrowser() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP - click on Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void closeBrowser() {
		driver.quit();
	}

	void createMapofManager() {

		Map<String, Integer> managerMap = new HashMap<String, Integer>();
		// get the size of Employee Department.
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		for (int index = 1; index <= size; index++) {
			WebElement element = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"));
			String empDep = element.getText();

			if (managerMap.containsKey(empDep)) {
				int count = managerMap.get(empDep);
				managerMap.put(empDep, count + 1);
			} else {
				managerMap.put(empDep, 1);
			}
		}
		System.out.println("Manager mentees map: " + managerMap);
		
		// Get Manager with Max mentees
		int maxMenteeCount = 0;
		String managerId = "";
		Set<String> keySet = managerMap.keySet();
		for (String mgrId : keySet) {
			if (maxMenteeCount < managerMap.get(mgrId)) {
				maxMenteeCount = managerMap.get(mgrId);
				managerId = mgrId;
			}
		}
		System.out.println("ManagerId " + managerId + " having maximum mentees.");
	}

	public static void main(String[] args) {

		Assignment8 assignment8 = new Assignment8();
		assignment8.setupLaunchBrowser();

		assignment8.createMapofManager();
		assignment8.closeBrowser();
	}

}
