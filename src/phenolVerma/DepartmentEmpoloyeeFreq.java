/*
Assignment 7 - 8th April'2024 [IMP]
TestCase1 - Return the map of Employee Department and employees working in each Department.
TestCase2 - Return the map of Employee Department and employees with name using string.
TestCase3 - Return the map of Employee Department and employees with name using List.

output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]
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

public class DepartmentEmpoloyeeFreq {

	WebDriver driver;
	int tablelength;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");
	}

	void getEmployeeData() throws InterruptedException {

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

	// TestCase1 - Return the map of Employee Department and employees working in each Department.

	void getFreqOfDepatmentEmployee() throws InterruptedException {

		// Calling method to get manager and employee data
		getEmployeeData();

		System.out.println("Creating Map to store department and Employee number");
		Map<String, Integer> depatmentMap = new LinkedHashMap<String, Integer>();

		for (int index = 1; index <= tablelength; index++) {
			String depatment = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (depatmentMap.containsKey(depatment)) {
				int count = depatmentMap.get(depatment);
				depatmentMap.put(depatment, count + 1);
			} else {
				depatmentMap.put(depatment, 1);
			}
		}

		System.out.println("Department ID  |  Employee Count");
		for (Map.Entry<String, Integer> entry : depatmentMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
		// Close the WebDriver
		driver.quit();
	}

	// TestCase2 - Return the map of Employee Department and employees with name using string.

	void getNameOfDepartmentEmployeeUsingString() throws InterruptedException {

		// Calling method to get manager and employee data
		getEmployeeData();

		System.out.println("Creating Map to store managerName and Employee number");
		Map<String, String> deaptmentEmployeeMap = new LinkedHashMap<String, String>();

		for (int index = 1; index <= tablelength; index++) {

			String departmentName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String emploeeName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (deaptmentEmployeeMap.containsKey(departmentName)) {
				String temp = deaptmentEmployeeMap.get(departmentName);
				temp = temp + ", " + emploeeName;
				deaptmentEmployeeMap.put(departmentName, temp);
			} else {
				deaptmentEmployeeMap.put(departmentName, emploeeName);
			}
		}

		System.out.println("Department ID  | Number Of Employees  |  Employee Name");
		for (Map.Entry<String, String> entry : deaptmentEmployeeMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue().split(", ").length + " | " + entry.getValue());
		}
		// Close the WebDriver
		driver.quit();
	}

	// TestCase3 - Return the map of Employee Department and employees with name using List.

	void getNameOfDepartmentEmployeeUsingList() throws InterruptedException {

		// Calling method to get manager and employee data
		getEmployeeData();

		System.out.println("Creating Map to store depatment and Employee number");
		Map<String, LinkedHashSet<String>> departmentEmployeeMap = new LinkedHashMap<String, LinkedHashSet<String>>();

		for (int index = 1; index <= tablelength; index++) {

			String departmentName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String emploeeName = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (departmentEmployeeMap.containsKey(departmentName)) {
				departmentEmployeeMap.get(departmentName).add(emploeeName);
			} else {
				LinkedHashSet<String> employees = new LinkedHashSet<>();
				employees.add(emploeeName);
				departmentEmployeeMap.put(departmentName, employees);
			}
		}

		System.out.println("Manager ID  | Number Of Employees  |  Employee Name");
		for (Map.Entry<String, LinkedHashSet<String>> entry : departmentEmployeeMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue().size() + " | " + entry.getValue());
		}

		// Close the WebDriver
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		DepartmentEmpoloyeeFreq managerFrequencyCheck = new DepartmentEmpoloyeeFreq();

		managerFrequencyCheck.getFreqOfDepatmentEmployee();

		System.out.println("*************************************************");
		managerFrequencyCheck.getNameOfDepartmentEmployeeUsingString();

		System.out.println("*************************************************");
		managerFrequencyCheck.getNameOfDepartmentEmployeeUsingList();
	}

}