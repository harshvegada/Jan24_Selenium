package rupaliUmagol;

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
	List<WebElement> TotalRows;

	void setUp() {
		System.out.println("STEP : Launch Browser and Open Url");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP : Maximize Browser and add wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP : Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	// TC1 : In table 1, how many employees are there.
	// Answer : 5
	void getNoOfEmployee() {
		setUp();

		System.out.println("STEP : Find Employee from table");
		List<WebElement> listOfEmployee = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

		System.out.println("STEP : Total No of Employee");
		int count = listOfEmployee.size();
		System.out.println("No of Employees are : " + count);
	}

	// TC2 : In table1, how many column are there and print all headers of each
	// column [compare list to list].
	// Answer : 4
	// # FirstName LastName UserName
	List<String> convertWebElementToString(List<WebElement> listofElement) {
		List<String> listOfEle = new ArrayList<>();
		for (WebElement e : listofElement) {
			listOfEle.add(e.getText());
		}
		return listOfEle;
	}

	void getColumnHeader() {
		System.out.println("STEP : Find Columns from table");
		List<WebElement> NoOfHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		System.out.println("STEP : Total No of Columns");
		int count = NoOfHeaders.size();
		System.out.println("No of headers are : " + count);
		if (count == 4)
			System.out.println("Test passed");
		else
			System.out.println("Test Failed");

		String arr[] = { "#", "First Name", "Last Name", "Username" };
		List<String> expectedHeader = Arrays.asList(arr);

		System.out.println("STEP : Find headers");
		List<WebElement> ListOfHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		System.out.println("STEP : Convert WebElement List to ArrayList");
		List<String> ActualList = convertWebElementToString(ListOfHeaders);

		System.out.println("STEP : Print Coloumn Headers.");
		System.out.println(ActualList);

		System.out.println("VERIFY : Verify Expected an Actual coloumn headers.");
		if (ActualList.equals(ActualList)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}

	// TC3 : Find of total username in table1, verify each username is unique. Print
	// all usernames.
	void getUserName() {
		System.out.println("STEP : Get All user names");
		List<WebElement> ListOfUserName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));

		System.out.println("STEP : Find count of Usernames");
		if (ListOfUserName.size() == 5)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");

		System.out.println("STEP : Print All UserNames");
		for (WebElement e : ListOfUserName) {
			System.out.println(e.getText());
		}

		System.out.println("STEP : Convert WebElement List TO String List");
		List<String> listOfUsers = convertWebElementToString(ListOfUserName);

		System.out.println("STEP : get Unique list of User names");
		Set<String> UniqueList = new HashSet<>(listOfUsers);

		System.out.println("STEP : Print Unique list Of User Names");
		System.out.println(UniqueList);
	}

	// TC4 : Print all the unique surnames and print duplicate surnames if any using
	// List+Set.
	void PrintUniqueAndDuplicateSurname() {

		List<String> listOfSurname = new ArrayList<>();
		LinkedHashSet<String> uniqueList = new LinkedHashSet<>();

		System.out.println("STEP : Get total rows from table");
		TotalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

		System.out.println("STEP : Check unique and Duplicate Elements");
		for (int i = 1; i < TotalRows.size(); i++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();

			if (listOfSurname.contains(surname)) {
				uniqueList.add(surname);
			} else
				listOfSurname.add(surname);
		}
		System.out.println("Duplicate Elements : " + uniqueList);
	}

	// TC5 : Print all the unique surnames and print duplicate surnames if any using
	// Map.
	void PrintUniqueSurnameUsingMAP() {

		Map<String, Integer> countOfSurname = new LinkedHashMap<>();

		System.out.println("STEP : Find Unique surnames using map");
		for (int i = 1; i < TotalRows.size(); i++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();
			if (countOfSurname.containsKey(surname)) {
				int count = countOfSurname.get(surname);
				countOfSurname.put(surname, count + 1);
			} else
				countOfSurname.put(surname, 1);
		}

		Set<String> setOf = countOfSurname.keySet();
		for (String str : setOf) {
			if (countOfSurname.get(str) > 1) {
				System.out.println("Duplicate Surname : " + str);
			}
		}
	}

	// TC6 : Print all the unique surnames and print duplicate surnames if any using
	// Set.

	void printDuplicateSurnameUsingSet() {
		Set<String> setOfSurname = new LinkedHashSet<>();

		System.out.println("STEP : Find Unique surnames using Set");
		for (int i = 1; i < TotalRows.size(); i++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();
			if (!setOfSurname.add(surname))
				System.out.println("Duplicate Surnames are : " + surname);
		}
	}

	// TC7 : Return firstname and lastname of each employee in Map<String, String>,
	// in main method verify the lastname of the employee should be Patro whoes
	// firstname is Priya.
	Map<String, String> FirstNameandLastName() {
		Map<String, String> names = new LinkedHashMap<>();

		System.out.println("STEP : Find Firstname and Lastname of each entry");
		for (int i = 1; i <= TotalRows.size(); i++) {
			String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String lastname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();

			System.out.println("STEP : Add FirstName and LastName to Map");
			names.put(firstname, lastname);
		}
		return names;
	}

	public static void main(String[] args) {
		Assignment5 assignment = new Assignment5();
		assignment.getNoOfEmployee();
		assignment.getColumnHeader();
		assignment.getUserName();
		assignment.PrintUniqueAndDuplicateSurname();
		assignment.PrintUniqueSurnameUsingMAP();
		assignment.printDuplicateSurnameUsingSet();

		Map<String, String> result = assignment.FirstNameandLastName();
		System.out.println(result);

		System.out.println("VERIFY : Last name of Priya");
		if (result.get("Priya").equals("Patro"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}
}
