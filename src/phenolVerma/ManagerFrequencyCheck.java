/*
 Assignment 8 - 9th April'2024 [IMP]
TestCase1 - Return the map of manager name and number of employees working in each manager.
TestCase2 - Return the map of manager name and name of employees working in each manager using string.
TestCase3 - Return the map of manager name and name of employees working in each manager using List.
*/

package phenolVerma;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagerFrequencyCheck {

	WebDriver driver;
	int tablelength;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");
	}

	void getManagerEmployeeData() throws InterruptedException {

		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		System.out.print("Getting Employee Name lenght - ");
		tablelength = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println(tablelength);

		System.out.println("Create the list of deplartment name");
		List<WebElement> managerElements = new ArrayList<WebElement>();
		for (int deptIndex = 1; deptIndex <= tablelength; deptIndex++) {
			managerElements.add(driver.findElement(
					By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + deptIndex + "]/td[5]")));
		}
	}

	// TestCase1 - Return the map of manager name and number of employees working in
	// each manager.

	void getFreqOfManagerDepatmentEmployee() throws InterruptedException {

		// Calling method to get manager and employee data
		getManagerEmployeeData();

		System.out.println("Creating Map to store manager and Employee number");
		Map<String, Integer> managerMap = new LinkedHashMap<String, Integer>();

		for (int index = 1; index <= tablelength; index++) {
			String manager = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (managerMap.containsKey(manager)) {
				int count = managerMap.get(manager);
				managerMap.put(manager, count + 1);
			} else {
				managerMap.put(manager, 1);
			}
		}

		System.out.println("Manager ID  |  Employee Count");
		for (Map.Entry<String, Integer> entry : managerMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
		// Close the WebDriver
		driver.quit();
	}

	// TestCase2 - Return the map of manager name and name of employees working in
	// each manager using string.

	void getNameOfManagerEmployeeUsingString() throws InterruptedException {

		// Calling method to get manager and employee data
		getManagerEmployeeData();

		System.out.println("Creating Map to store managerName and Employee number");
		Map<String, String> managerEmployeeMap = new LinkedHashMap<String, String>();

		for (int index = 1; index <= tablelength; index++) {

			String managerName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String emploeeName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (managerEmployeeMap.containsKey(managerName)) {
				String temp = managerEmployeeMap.get(managerName);
				temp = temp + ", " + emploeeName;
				managerEmployeeMap.put(managerName, temp);
			} else {
				managerEmployeeMap.put(managerName, emploeeName);
			}
		}

		System.out.println("Manager ID  | Number Of Employees  |  Employee Name");
		for (Map.Entry<String, String> entry : managerEmployeeMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue().split(", ").length + " | " + entry.getValue());
		}
		// Close the WebDriver
		driver.quit();
	}

	// TestCase3 - Return the map of manager name and name of employees working in
	// each manager using List.

	void getNameOfManagerEmployeeUsingList() throws InterruptedException {

		// Calling method to get manager and employee data
		getManagerEmployeeData();

		System.out.println("Creating Map to store managerName and Employee number");
		Map<String, LinkedHashSet<String>> managerEmployeeMap = new LinkedHashMap<String, LinkedHashSet<String>>();

		for (int index = 1; index <= tablelength; index++) {

			String managerName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String emploeeName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (managerEmployeeMap.containsKey(managerName)) {
				managerEmployeeMap.get(managerName).add(emploeeName);
			} else {
				LinkedHashSet<String> employees = new LinkedHashSet<>();
				employees.add(emploeeName);
				managerEmployeeMap.put(managerName, employees);
			}
		}

		System.out.println("Manager ID  | Number Of Employees  |  Employee Name");
		for (Map.Entry<String, LinkedHashSet<String>> entry : managerEmployeeMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue().size() + " | " + entry.getValue());
		}

		// Close the WebDriver
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		ManagerFrequencyCheck managerFrequencyCheck = new ManagerFrequencyCheck();

		managerFrequencyCheck.getFreqOfManagerDepatmentEmployee();

		System.out.println("*************************************************");
		managerFrequencyCheck.getNameOfManagerEmployeeUsingString();

		System.out.println("*************************************************");
		managerFrequencyCheck.getNameOfManagerEmployeeUsingList();
	}

}