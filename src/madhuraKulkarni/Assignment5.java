/*Assignment - 5 : 7th April

TC1 : In table 1, how many employees are there. 
Answer : 5

TC2 : In table1, how many column are there and print all headers of each column [compare list to list].
Answer : 4
# FirstName LastName UserName

TC3 : Find of total username in table1, verify each  username is unique. Print all usernames. 
TC4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
TC5 : Print all the unique surnames and print duplicate surnames if any using Map. 
TC6 : Print all the unique surnames and print duplicate surnames if any using Set. 
TC7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of the employee should be Patro whoes firstname is Priya.*/
package madhuraKulkarni;

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

public class Assignment5 {
	WebDriver driver;

	void launchBrowser() {
		System.out.println("STEP: Launch browser and hit URL");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

//TC1 : In table 1, how many employees are there. 
	void testCase1() {
		launchBrowser();
		System.out.println("TC1 : In table 1, how many employees are there?");
		int actualEmpCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int expectedEmpCount = 5;
		System.out.println("Number of employees in table 1 are : " + actualEmpCount);
		if (actualEmpCount == expectedEmpCount)
			System.out.println("TestCase 1 passed");
		else
			System.out.println("TestCase 1 failed");
	}

	// TC2 : In table1, how many column are there and print all headers of each
	// column [compare list to list].
	void testCase2() {
		System.out.println(
				"TC2 : In table1, how many column are there and print all headers of each column [compare list to list].");
		List<WebElement> listOfHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int actualHeaderColumns = listOfHeaders.size();
		String[] arr = { "#", "First Name", "Last Name", "Username" };
		List<String> listOfExpectedHeaders = new ArrayList<>(Arrays.asList(arr));
		int expectedHeaderCount = 4;
		System.out.println("STEP: Verify the actual header columns and expected header columns");
		if (actualHeaderColumns == expectedHeaderCount)
			System.out.println("TestCase 2 passed");
		else
			System.out.println("TestCase 2 failed");

		System.out.println("-----------------------------");
		System.out.println("STEP: Verify the actual headers and expected headers.");
		System.out.println("STEP: Convert the List of WebElements to List of String:");
		List<String> listOfActualHeaders = getListOfWebElement(listOfHeaders);
		System.out.println("STEP: Verify the actual headers and expected headers: ");
		if (listOfExpectedHeaders.equals(listOfActualHeaders))
			System.out.println("TestCase2  passed");
		else
			System.out.println("TestCase2 failed");
	}

	List<String> getListOfWebElement(List<WebElement> listOfHeaders) {
		List<String> listOfActualHeaders = new ArrayList<String>();
		for (WebElement e : listOfHeaders) {
			listOfActualHeaders.add(e.getText());
		}
		return listOfActualHeaders;
	}

	// TC3 : Find of total username in table1, verify each username is unique. Print
	// all usernames.
	void testCase3() {
		System.out.println("STEP: Find total Usernames in a table.");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		System.out.println("Total No of Usernames : " + listOfElements.size());
		List<String> listOfUserNames = getListOfWebElement(listOfElements);
		HashSet<String> setOfUsername = new LinkedHashSet<String>(listOfUserNames);
		System.out.println("STEP: Verify that the user names are unique.");
		if (listOfUserNames.size() == setOfUsername.size()) {
			System.out.println("TestCase 3 Passed: All user names are unique.");
		} else {
			System.out.println("TestCase 3 failed: There are some duplicate user names.");
		}
	}

	// TC4 : Print all the unique surnames and print duplicate surnames if any using
	// List+Set.

	void testCase4() {
		System.out.println("STEP: Print all the unique surnames and print duplicate surnames if any using LIST+SET");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastNames = new ArrayList<String>();
		Set<String> setOfDuplicateLastName = new LinkedHashSet<String>();
		for (WebElement e : listOfElements) {
			if (!(listOfLastNames.contains(e.getText())))
				listOfLastNames.add(e.getText());
			else
				setOfDuplicateLastName.add(e.getText());
		}
		System.out.println("List of Unique Last Names in the table are : " + listOfLastNames);
		System.out.println("List of Duplicate Last Names in the table are : " + setOfDuplicateLastName);
	}

	// TC5 : Print all the unique surnames and print duplicate surnames if any using
	// Map.

	void testCase5() {
		int count = 1;
		System.out.println("STEP: Print all the unique surnames and print duplicate surnames if any using Map. ");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastNames = getListOfWebElement(listOfElements);
		System.out.println("Printing List of Last Names : " + listOfLastNames);
		Map<String, Integer> mapOfLastNames = new LinkedHashMap<String, Integer>();
		for (String lastName : listOfLastNames) {
			if (mapOfLastNames.containsKey(lastName)) {
				count = mapOfLastNames.get(lastName);
				mapOfLastNames.put(lastName, count);
				count++;
			} else
				mapOfLastNames.put(lastName, 1);
		}
		System.out.println("STEP: Print the map of Last names.");
		Set<String> keySet = mapOfLastNames.keySet();
		for (String key : keySet) {
			if (mapOfLastNames.get(key) == 1)
				System.out.println("Unique Last Names are : " + key);
			else
				System.out.println("Duplicate Last Names are : " + key);
		}
	}
	// TC6 : Print all the unique surnames and print duplicate surnames if any using
	// Set.

	void testCase6() {
		System.out.println("STEP: Print all the unique surnames and print duplicate surnames if any using Map. ");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastNames = getListOfWebElement(listOfElements);
		System.out.println("Printing List of Last Names : " + listOfLastNames);
		Set<String> setOfLastNames = new LinkedHashSet<String>();
		for (String lastName : listOfLastNames) {
			if (setOfLastNames.add(lastName))
				System.out.println("Duplicate Last Name is : " + lastName);
		}
		System.out.println("Unique Last Names in the table are : " + setOfLastNames);
	}

	// TC7 : Return firstname and lastname of each employee in Map<String, String>,
	// in main method verify the lastname of the employee should be Patro whoes
	// firstname is Priya.

	void testCase7() {
		int numberOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> mapOfTable = new LinkedHashMap<String, String>();
		System.out.println("STEP : Fill the first name and last name in the map.");
		for (int index = 1; index <= numberOfRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			mapOfTable.put(firstName, lastName);
		}
		System.out.println("STEP: Get firstname and lastname from table");
		System.out.println(mapOfTable);
		if (mapOfTable.get("Priya").equals("Patro")) {
			System.out.println("TestCase 7 passed: First Name Priya matches the Last Name Patro.");

		} else {
			System.out.println("TestCase 7 failed: First Name Priya doesn't match with the Last Name Patro.");
		}

	}

	void display() {
		System.out.println("-------------TestCase 1 started--------------");
		testCase1();
		System.out.println("-------------TestCase 2 started--------------");
		testCase2();
		System.out.println("-------------TestCase 3 started--------------");
		testCase3();
		System.out.println("-------------TestCase 4 started--------------");
		testCase4();
		System.out.println("-------------TestCase 5 started--------------");
		testCase5();
		System.out.println("-------------TestCase 6 started--------------");
		testCase6();
		System.out.println("-------------TestCase 7 started--------------");
		testCase7();
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment5 assignent5 = new Assignment5();
		assignent5.display();
	}

}
