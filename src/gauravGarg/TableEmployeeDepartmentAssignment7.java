package gauravGarg;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableEmployeeDepartmentAssignment7 {

	WebDriver wb;

	void loadBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step 2-: Click on Demo Table tab ");
		wb.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	}

	/*
	 * Return the map of department name and number of employees working in each
	 * department. Hint : Map<String, Integer> output : [{7001-Admin=2},
	 * {7002-Finance=2}, {7013-IT=3}]
	 */
	void testCase1() {
		System.out.println("Test Case 1");
		loadBrowser();
		int size = wb.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		System.out.println("Step 3-: Click on Employer Manager and calculate size of row ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		System.out.println("Step 4-: Create on Map of String and Inetger ");
		for (int i = 1; i <= size; i++) {
			String department = wb
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			if (!map.containsKey(department)) {
				map.put(department, 1);
			} else {
				int count = map.get(department);
				map.put(department, count + 1);
			}
		}
		System.out.println(
				"Step 4-: Load the data of map with string Employee departement and count of Employee departement ");
		System.out.println(map);
		wb.quit();
	}

	/*
	 * Return the map of department name and number of employees working in each
	 * department. Hint : Map<String, List<String> output : {7003-HR=[Sumit
	 * Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka
	 * Bhale], 7002-Finance=[Sumit Mate, Sumit Mate], 7001-Admin=[Abhijit Mane,
	 * Prayag Mokate]}
	 * 
	 */
	void testCase2() {
		System.out.println();
		System.out.println("Test Case 2");
		loadBrowser();
		int size = wb.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		System.out.println("Step 3-: Click on Employer Manager and calculate size of row ");
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		System.out.println("Step 4-: Create on Map of String and List of String ");
		for (int i = 1; i <= size; i++) {
			String department = wb
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			String empName = wb.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			if (!map.containsKey(department)) {
				ArrayList<String> sr = new ArrayList<String>();
				sr.add(empName);
				map.put(department, sr);
			} else {
				ArrayList<String> count = map.get(department);
				count.add(empName);
				map.put(department, count);
			}
		}
		System.out.println(
				"Step 4-: Load the dadta of map with string Employee departement and list of string of employee name");
		System.out.println(map);
		wb.quit();

	}

	public static void main(String[] args) {
		new TableEmployeeDepartmentAssignment7().testCase1();
		new TableEmployeeDepartmentAssignment7().testCase2();
	}
}

