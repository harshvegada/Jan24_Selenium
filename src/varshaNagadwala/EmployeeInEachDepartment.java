package varshaNagadwala;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Return the map of department name and number of employees working in each department.
//Hint : Map<String, Integer>
//output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]

public class EmployeeInEachDepartment {

	WebDriver driver;

	void launchBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Demo Table link");
		driver.findElement(By.id("demotable")).click();
	}

	List<String> convertToStringList(List<WebElement> list) {
		List<String> listOfString = new ArrayList<String>();
		for (WebElement e : list) {
			listOfString.add(e.getText());
		}
		return listOfString;
	}

	void testCase1() {
		System.out.println("TestCase Start");
		launchBrowser();

		System.out.println("STEP : Take all the webelement");
		List<WebElement> listOfEmployee = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));

		System.out.println("STEP : Create map");
		Map<String, Integer> mapOfEmployeesInEachDP = new LinkedHashMap<>();

		System.out.println("STEP : Add the department data in map");
		for (WebElement element : listOfEmployee) {
			if (mapOfEmployeesInEachDP.containsKey(element.getText())) {
				int count = mapOfEmployeesInEachDP.get(element.getText());
				mapOfEmployeesInEachDP.put(element.getText(), count + 1);
			} else {
				mapOfEmployeesInEachDP.put(element.getText(), 1);
			}
		}
		System.out.println("Print Employee working in each department : " + mapOfEmployeesInEachDP);

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	void testCase2() {
		System.out.println("TestCase2 Start");
		launchBrowser();

		System.out.println("STEP : get list of webelement");
		List<WebElement> listEmpElementsId = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		List<WebElement> listEmpElementsName = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));

		System.out.println("STEP : Convert int list of string");
		List<String> listOfEmployeeId = convertToStringList(listEmpElementsId);
		List<String> listOfEmployeeName = convertToStringList(listEmpElementsName);

		System.out.println("STEP : total number of row");
		int totalRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]")).size();

		System.out.println("STEP : Create map");
		Map<String, List<String>> mapOfEmployees = new LinkedHashMap<>();

		for (int i = 1; i <= totalRow; i++) {
			String name = listOfEmployeeId.get(i - 1);
			if (mapOfEmployees.containsKey(name)) {
				List<String> list = mapOfEmployees.get(name);
				list.add(listOfEmployeeName.get(i - 1));
				mapOfEmployees.put(name, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(listOfEmployeeName.get(i - 1));
				mapOfEmployees.put(name, list);
			}
		}
		System.out.println(mapOfEmployees);
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	Map<String, List<String>> getEmplPerDep() {
		Map<String, List<String>> mapOfDepEmp = new LinkedHashMap<>();

		System.out.println("STEP : Get list of Department");
		List<String> listOfDep = convertToStringList(
				driver.findElements(By.xpath("//div[@id='empmanager']//tbody//td[5]")));

		System.out.println("STEP : Get list of Employees");
		List<String> listOfEmp = convertToStringList(
				driver.findElements(By.xpath("//div[@id='empmanager']//tbody//td[3]")));

		System.out.println("STEP : Get the map of Department and name of employees");
		int count = listOfDep.size();
		for (int index = 1; index <= count; index++) {
			String name = listOfDep.get(index - 1);
			if (mapOfDepEmp.containsKey(name)) {
				List<String> list = mapOfDepEmp.get(name);
				list.add(listOfEmp.get(index - 1));
				mapOfDepEmp.put(name, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(listOfEmp.get(index - 1));
				mapOfDepEmp.put(name, list);
			}
		}
		return mapOfDepEmp;
	}

	public static void main(String[] args) {
		EmployeeInEachDepartment employeeInEachDepartment = new EmployeeInEachDepartment();
		employeeInEachDepartment.testCase1();
		System.out.println();
		employeeInEachDepartment.testCase2();
	}
}
