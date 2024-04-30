package akshadaRajput;

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

public class AutomateWebTable {

	WebDriver driver;

	void launchBrowser() {
		System.out.println("Prerequisites: Luanching browser and navigating to Demo Tables");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	List<String> covertToStringList(List<WebElement> lisOfElements) {

		List<String> actualHeader = new ArrayList<String>();

		for (WebElement e : lisOfElements) {
			actualHeader.add(e.getText());
		}
		return actualHeader;
	}

	boolean returnListCompareResult(List<String> expectedList, List<String> actualList) {
		if (expectedList.equals(actualList))
			return true;
		else
			return false;
	}

	boolean returnSizeCompareResult(int expectedCount, int actualCount) {
		if (expectedCount == actualCount)
			return true;
		else
			return false;
	}

	void returnFinalTestStatus(boolean size, boolean condition, String tcid) {
		if (size && condition)
			System.out.println(tcid + " Pass");
		else
			System.out.println(tcid + " Fail");
	}

	void getTotalEmpCount() {

		launchBrowser();

		System.out.println("TC1 : In table 1, how many employees are there?");

		List<WebElement> totalCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

		System.out.println("Total count of employee is " + totalCount.size());

		if (returnSizeCompareResult(5, totalCount.size()))
			System.out.println("TestCase1 Pass");
		else
			System.out.println("TestCase1 Fail");
		driver.quit();
	}

	void getColumns() {
		System.out.println(
				"TestCase2: In table1, how many column are there? print all headers of each column [compare list to list].");

		launchBrowser();

		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		// Get number of columns
		System.out.println("Headers: " + listOfElements.size());

		boolean sizeResult = returnSizeCompareResult(4, listOfElements.size());

		// Compare Headers

		for (WebElement header : listOfElements) {
			System.out.println("Headers in table are " + header.getText());
		}

		List<String> expectedHeader = new ArrayList<String>(Arrays.asList("#", "First Name", "Last Name", "Username"));
		List<String> actualHeader = covertToStringList(listOfElements);

		boolean listResult = returnListCompareResult(expectedHeader, actualHeader);

		returnFinalTestStatus(sizeResult, listResult, "TestCase2");
		
		driver.quit();

	}

	void checkUsernames() {
		launchBrowser();

		System.out.println(
				"TestCase3 : Find of total username in table1, verify each  username is unique. Print all usernames.");

		// Get number of records of username column
		List<WebElement> listOfUsernames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));

		System.out.println("Total number of username is: " + listOfUsernames.size());

		boolean countFlag = returnSizeCompareResult(listOfUsernames.size(), 5);

		// Get unique usernames

		List<String> expectedUsername = new ArrayList<String>(
				Arrays.asList("mkanani", "kkanani", "dboda", "asharma", "ppatro"));

		List<String> actualList = covertToStringList(listOfUsernames);

		Set<String> actualSet = new HashSet<String>(actualList);

		boolean usernameFlag = returnListCompareResult(expectedUsername, actualList);

		returnFinalTestStatus(countFlag, usernameFlag, "TestCase3");

		System.out.println("Usernames are: " + actualList);
		
		driver.quit();

	}

	void printSurnamesUsingListAndSet() {
		System.out.println(
				"TestCase4: Print all the unique surnames and print duplicate surnames if any using List+Set.");
		launchBrowser();

		List<WebElement> listOfSurnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		int totalCount = listOfSurnames.size();

		Set<String> setOfSurnames = new LinkedHashSet<String>();
		List<String> arrayList = new ArrayList<String>();

		for (int rowCount = 1; rowCount <= totalCount; rowCount++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowCount + "]/td[3]"))
					.getText();
			if (arrayList.contains(surname))
				setOfSurnames.add(surname);
			else
				arrayList.add(surname);
		}
		System.out.println("Duplicate surnames are: " + setOfSurnames);
		
		driver.quit();

	}

	void printSurnamesUsingSet() {
		System.out.println("TestCase6: Print all the unique surnames and print duplicate surnames if any using Set");
		launchBrowser();

		List<WebElement> listOfSurnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));

		int totalCount = listOfSurnames.size();

		Set<String> setOfSurnames = new LinkedHashSet<String>();

		for (int rowCount = 1; rowCount <= totalCount; rowCount++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowCount + "]/td[3]"))
					.getText();
			if (setOfSurnames.contains(surname))
				System.out.println("Duplicate LastNames are:" + surname);
			else
				setOfSurnames.add(surname);
		}
		System.out.println("Unique surnames are: " + setOfSurnames);

		driver.quit();

	}

	void printSpecificSurnamesUsingMap() {
		System.out.println(
				"TC7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of the employee should be Patro whoes firstname is Priya.");

		launchBrowser();

		List<WebElement> listOfFirstNames = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]"));
		int totalRowCount = listOfFirstNames.size();
		List<WebElement> listOfLastNames = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		Map<String, String> mapOfNames = new LinkedHashMap<String, String>();

		String firstName = "";
		String lasttName = "";

		for (int index = 1; index <= totalRowCount; index++) {
			firstName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]")).getText();
			lasttName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[3]")).getText();
			mapOfNames.put(firstName, lasttName);
		}

		System.out.println(mapOfNames);

		if (mapOfNames.get("Priya").equals("Patro"))
			System.out.println("TC7 Pass");
		else
			System.out.println("TC7 Fail");

		driver.quit();

	}

	void printSurnamesUsingMap() {
		System.out.println("TC5 : Print all the unique surnames and print duplicate surnames if any using Map. ");
		launchBrowser();

		List<WebElement> listOfLastNames = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		int totalRowsCount = listOfLastNames.size();

		Map<String, Integer> mapOfNames = new LinkedHashMap<String, Integer>();

		for (int index = 1; index <= totalRowsCount; index++) {
			String lastName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (mapOfNames.containsKey(lastName)) {
				int count = mapOfNames.get(lastName);
				mapOfNames.put(lastName, count + 1);
			} else {
				mapOfNames.put(lastName, 1);
			}
		}

		Set<String> lastNameSet = mapOfNames.keySet();

		for (String key : lastNameSet) {
			if (mapOfNames.get(key) > 1)
				System.out.println("Duplicate surnames is/are: " + key);
			else if (mapOfNames.get(key) == 1)
				System.out.println("Unique surnames is/are: " + key);

		}
		driver.quit();

	}
	

	public static void main(String args[]) {
		AutomateWebTable automateWebTable = new AutomateWebTable();
		
		 automateWebTable.getTotalEmpCount(); 
		 System.out.println();
		 automateWebTable.getColumns(); 
		System.out.println();
		automateWebTable.checkUsernames(); 
		System.out.println();
		 automateWebTable.printSurnamesUsingListAndSet();
		 System.out.println();
		automateWebTable.printSpecificSurnamesUsingMap(); 
		System.out.println();
		automateWebTable.printSurnamesUsingMap();
	}
}
