package varshaNagadwala;

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

public class AutomationByKrishnaDemoEmployeeTable {

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

	// TC1 : In table 1, how many employees are there.
	// Answer : 5
	void testCase1() {

		System.out.println("TestCase1 Start");
		launchBrowser();

		System.out.println("STEP : Number of row");
		List<WebElement> listOfEmployee = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Total number of employee in table " + listOfEmployee.size());

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	// TC2 : In table1, how many column are there and print all headers of each
	// column [compare list to list].
	// Answer : 4
	// # FirstName LastName UserName

	void testCase2() {

		System.out.println("TestCase2 Start");
		launchBrowser();

		String[] expectedHeaderArr = { "#", "First Name", "Last Name", "Username" };

		System.out.println("STEP : Convert array into list");
		List<String> listOFExpectedHeader = Arrays.asList(expectedHeaderArr);

		System.out.println("STEP : number of column");
		List<WebElement> listOfActualHeader = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		System.out.println("STEP : convert webelement list to string");
		List<String> actualHeaderListText = convertToStringList(listOfActualHeader);

		System.out.println("STEP : print actual header data");
		System.out.println(actualHeaderListText);

		System.out.println("STEP : print expected header data");
		System.out.println(listOFExpectedHeader);

		System.out.println("VERIFY : List of expected header and actual header is same or not");
		if (actualHeaderListText.equals(listOFExpectedHeader))
			System.out.println("testCase2 Pass");
		else
			System.out.println("testCase2 Fail");

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC3 : Find of total username in table1, verify each  username is unique. Print all usernames.
	void testCase3() {

		System.out.println("TestCase3 Start");
		launchBrowser();

		System.out.println("STEP : number of column");
		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		System.out.println("STEP : convert webelement list to string");
		List<String> listOfUsername = convertToStringList(listOfElement);

		System.out.println("STEP : convert webelement listOfString into hashset");
		Set<String> setOfUsername = new HashSet<>(listOfUsername);

		System.out.println("VERIFY : List of string and set of username size are same or not");
		if (setOfUsername.size() == listOfUsername.size())
			System.out.println("testCase3 Pass");
		else
			System.out.println("testCase3 Fail");

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
	void testCase4() {

		System.out.println("TestCase4 Start");
		launchBrowser();

		System.out.println("STEP : number of column");
		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		System.out.println("STEP : convert webelement list to string");
		List<String> listOfLastName = convertToStringList(listOfElement);

		System.out.println("STEP : convert webelement listOfString into hashset");
		Set<String> setOfLastName = new HashSet<>();
		for (String lName : listOfLastName) {
			if (setOfLastName.contains(lName))
				System.out.println("Dublicated LastName is : " + lName);
			else
				setOfLastName.add(lName);
		}
		System.out.println("All the unique lastName are : " + setOfLastName);

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC5 : Print all the unique surnames and print duplicate surnames if any using Map.
	void testCase5() {

		System.out.println("TestCase5 Start");
		launchBrowser();

		System.out.println("STEP : number of column");
		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		System.out.println("STEP : convert webelement list to string");
		List<String> listOfLastName = convertToStringList(listOfElement);

		System.out.println("STEP : convert webelement listOfString into hashset");
		Map<String, Integer> mapOfLastName = new LinkedHashMap<>();
		for (String lName : listOfLastName) {
			if (mapOfLastName.containsKey(lName)) {
				int count = mapOfLastName.get(lName);
				mapOfLastName.put(lName, count + 1);
			} else
				mapOfLastName.put(lName, 1);
		}

		System.out.println("VERIFY : LastName is Duplicated or unique");
		String lastName = "";
		Set<String> arrKey = mapOfLastName.keySet();
		for (String key : arrKey) {
			int value = mapOfLastName.get(key);
			if (value > 1) {
				System.out.println("Dublicated LastName is : " + key);
				lastName += key + " ";
			} else {
				lastName += key + " ";
			}
		}
		System.out.println("All the unique lastName are : " + lastName);

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC6 : Print all the unique surnames and print duplicate surnames if any using Set. 
	void testCase6() {

		System.out.println("TestCase5 Start");
		launchBrowser();

		System.out.println("STEP : number of column");
		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		System.out.println("STEP : Create LinkedHashSet");
		Set<String> mapOfLastName = new LinkedHashSet<>();

		System.out.println("VERIFY : Element Present or not");
		for (WebElement lastName : listOfElement)
			if (mapOfLastName.contains(lastName.getText())) {
				System.out.println("Dublicated LastName is : " + lastName.getText());
			} else {
				mapOfLastName.add(lastName.getText());
			}

		System.out.println("All the unique lastName are : " + mapOfLastName);

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) {
		AutomationByKrishnaDemoEmployeeTable automationByKrishnaDemoEmployeeTable = new AutomationByKrishnaDemoEmployeeTable();
		automationByKrishnaDemoEmployeeTable.testCase1();
		System.out.println();
		automationByKrishnaDemoEmployeeTable.testCase2();
		System.out.println();
		automationByKrishnaDemoEmployeeTable.testCase3();
		System.out.println();
		automationByKrishnaDemoEmployeeTable.testCase4();
		System.out.println();
		automationByKrishnaDemoEmployeeTable.testCase5();
		System.out.println();
		automationByKrishnaDemoEmployeeTable.testCase6();
	}
}
