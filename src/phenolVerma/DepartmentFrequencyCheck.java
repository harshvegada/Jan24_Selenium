/*
 Assignment 7 - 8th April'2024 [IMP]
Return the map of department name and number of employees working in each department.
*/

package phenolVerma;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DepartmentFrequencyCheck {

	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");
	}

	void getFreqOfDepatmentEmployee() throws InterruptedException {

		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		System.out.print("Getting Employee Name lenght - ");
		int tablelength = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println(tablelength);

		System.out.println("Create the list of deplartment name");
		List<WebElement> departmentElements = new ArrayList<WebElement>();
		for (int deptIndex = 1; deptIndex <= tablelength; deptIndex++) {
			departmentElements.add(driver.findElement(
					By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + deptIndex + "]/td[5]")));
		}

		System.out.println("Creating Map to store Department and Employee number");
		Map<String, Integer> departMap = new LinkedHashMap<String, Integer>();

		for (int index = 1; index <= tablelength; index++) {
			String department = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[5]")).getText();
			if (departMap.containsKey(department)) {
				int count = departMap.get(department);
				departMap.put(department, count + 1);
			} else {
				departMap.put(department, 1);
			}
		}

		System.out.println("Department Name  |  Employee Count");
		for (Map.Entry<String, Integer> entry : departMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DepartmentFrequencyCheck departmentFrequencyCheck = new DepartmentFrequencyCheck();
		departmentFrequencyCheck.getFreqOfDepatmentEmployee();
	}

}
