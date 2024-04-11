package pujaPoreddiwar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Assignment5_DemoTable {

	WebDriver driver;

	void openBrowser() {
		driver = new ChromeDriver();

		System.out.println("STEP: Url Loaded and Maximized");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: Click on Demo Table tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}

	// TC1 : In table 1, how many employees are there
	void testCase1() {
		openBrowser();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> listOfEmp = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("In table 1, " + listOfEmp.size() + " employees are there.");
		System.out.println("Verify the size of employees");
		if (listOfEmp.size() == 5) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}

	List<String> convertToStringList(List<WebElement> list) {
		List<String> listOfString = new ArrayList<String>();
		for (WebElement e : list) {
			listOfString.add(e.getText());
		}
		return listOfString;
	}

	// TC2 : In table1, how many column are there and print all headers of each
	// column [compare list to list].
	void testCase2() {
		System.out.println("--------Test case 2 ----------------");

		String[] arr = { "#", "First Name", "Last Name", "Username" };
		List<String> expectedHeaderList = Arrays.asList(arr);
		System.out.println("Expected Header list is : " + expectedHeaderList);

		driver.findElement(By.linkText("Demo Tables")).click();
		List<WebElement> actualHeaderList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		List<String> actualHeaderListText = convertToStringList(actualHeaderList);

		System.out.println("Actual Header list is : " + actualHeaderListText);
		System.out.println("VERIFY :Actual Header is matching with expcted Headers ");
		if (actualHeaderListText.equals(expectedHeaderList)) {
			System.out.println("Yes Matching : Test Passed");
		} else {
			System.out.println("Not Matching : Test Failed");
		}
	}

	// TC3 : Find of total username in table1, verify each username is unique. Print
	// all usernames.
	void testCase3() {

		System.out.println("--------Test case 3 ----------------");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		System.out.println("Total No of Usernames : " + listOfElements.size());

		List<String> listOfElementText = convertToStringList(listOfElements);
		HashSet<String> setOfUsername = new HashSet<String>(listOfElementText);

		if (listOfElementText.size() == setOfUsername.size()) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}

	// TC4 : Print all the unique surnames and print duplicate surnames if any using
	// List+Set.
	void testCase4() {
		System.out.println("--------Test case 4 ----------------");
		List<String> list = new ArrayList<String>();
		LinkedHashSet<String> duplicateNameSet = new LinkedHashSet<String>();
		int count = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowCount = 1; rowCount <= count; rowCount++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowCount + "]/td[3]"))
					.getText();
			if (list.contains(lastName)) {
				duplicateNameSet.add(lastName);
			} else {
				list.add(lastName);
			}
		}
		System.out.println("Duplicate Surname is  : " + duplicateNameSet);
	}

	// TC5 : Print all the unique surnames and print duplicate surnames if any using
	// Map.
	void testCase5() {

		System.out.println("--------Test case 5 ----------------");
		int count = 0;
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastName = convertToStringList(listOfElements);
		Map<String, Integer> mapLastName = new LinkedHashMap<>();
		System.out.println(listOfLastName);
		for (String lastName : listOfLastName) {
			if (mapLastName.containsKey(lastName)) {
				count = mapLastName.get(lastName);
				mapLastName.put(lastName, count + 1);
			} else {
				mapLastName.put(lastName, count);
			}
		}
		System.out.println(mapLastName);
		Set<String> setOfKeys = mapLastName.keySet();
		for (String key : setOfKeys) {
			if (mapLastName.get(key) != 1) {
				System.out.println("Unique LastNames are : " + key);
			} else {
				System.out.println("Duplicate LastNames are : " + key);
			}
		}
	}

	void testCase6() {

		System.out.println("--------Test case 6 ----------------");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOflastName = convertToStringList(listOfElements);
		Set<String> setOfDuplicate = new LinkedHashSet<>();
		for (String name : listOflastName) {
			if (!setOfDuplicate.add(name)) {
				System.out.println(" Duplicate Last Names in a Table " + name);
			}
		}
		System.out.println("Unique Last Names in a Table : " + setOfDuplicate);
	}

	void testCase7() {
		System.out.println("--------Test case 7 ----------------");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int index = 1; index <= rowCount; index++) {
			String firstname = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastname = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			map.put(firstname, lastname);
		}
		System.out.println("STEP: Print firstname and lastname from table");
		System.out.println(map);
		if (map.get("Priya").equals("Patro")) {
			System.out.println("VERIFY : Test passed - Priya lastname is Patro");
		} else {
			System.out.println("VERIFY : Test failed - Priya lastname is not Patro");
		}
		driver.quit();
	}

	
	public static void main(String[] args) {
		Assignment5_DemoTable demoTable = new Assignment5_DemoTable();
		demoTable.testCase1();
		demoTable.testCase2();
		demoTable.testCase3();
		demoTable.testCase4();
		demoTable.testCase5();
		demoTable.testCase6();
		demoTable.testCase7();
	}

}
