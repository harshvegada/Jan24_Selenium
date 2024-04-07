/*
TestCase1 : In table 1, how many employees are there. Answer : 5
TestCase2 : In table1, how many column are there and print all headers of each column [compare list to list]. Answer : 4, # FirstName LastName UserName
TestCase3 : Find of total username in table1, verify each  username is unique. Print all usernames. 
TestCase4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
TestCase5 : Print all the unique surnames and print duplicate surnames if any using Map. 
TestCase6 : Print all the unique surnames and print duplicate surnames if any using Set. 
TestCase7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of the employee should be Patro whoes firstname is Priya.
 */

package phenolVerma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDempTableKrishana {

	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	// TestCase1 : In table 1, how many employees are there. Answer : 5
	void testCase1() throws InterruptedException {

		System.out.println("Open Browser");
		openBrowser();

		int actualEmployeeCount = 5;

		System.out.println("Getting the size of the table");
		int employeeCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Records in Employee table - " + employeeCount);

		if (actualEmployeeCount == employeeCount) {
			System.out.println("Test Case 1 passed");
		} else {
			System.out.println("Test Case 1 not passed");
		}
	}

	// TestCase2 : In table1, how many column are there and print all headers of
	// each column [compare list to list]. Answer : 4, # FirstName LastName UserName

	void testCase2() throws InterruptedException {

//		System.out.println("Open Browser");
//		openBrowser();

		int actualColoumnCount = 4;

		System.out.println("Getting count of the coloumn in the table");
		int countColoum = driver.findElements(By.xpath("//table[@id='table1']//th")).size();

		System.out.println("Printing Coloumn name");
		for (int index = 1; index <= countColoum; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']//th[" + index + "]")).getText());
		}

		if (actualColoumnCount == countColoum) {
			System.out.println("Test case 2 passed");
		} else {
			System.out.println("Test case 2 not passed");

		}
	}

	// TestCase3 : Find of total username in table1, verify each username is unique.
	// Print all usernames.

	void testCase3() throws InterruptedException {

//		System.out.println("Open Browser");
//		openBrowser();

		int countUsername = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr/td[4]")).size();
		System.out.println("Total number of username in the table - " + countUsername);

		System.out.println("Creating Hashset to store unique username");
		HashSet<WebElement> getUserName = new HashSet<WebElement>();

		System.out.println("Storing username in Webelement");

		System.out.println("Printing username");

		for (int index = 1; index <= countUsername; index++) {
			WebElement userNameElement = driver
					.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[4]"));
			if (!getUserName.add(userNameElement)) {
				System.out.println("Duplicate username found");
				break;
			}
		}
		for (WebElement e : getUserName) {
			System.out.println(e.getText());
		}
		if (countUsername == getUserName.size()) {
			System.out.println("Test Case 3 passed");
		} else {
			System.out.println("Test Case 3 not passed");
		}
	}

	// TestCase4 : Print all the unique surnames and print duplicate surnames if any
	// using List+Set.

	void testCase4() throws InterruptedException {

//		System.out.println("Open Browser");
//		openBrowser();

		System.out.println("Createing Arraylist to save surname");
		ArrayList<WebElement> surName = new ArrayList<WebElement>();

		System.out.println("Creating Hashset to store duplicate surname");
		HashSet<WebElement> surnameHashSet = new HashSet<WebElement>();

		System.out.println("Getting surname lenght");
		int actualCountSurname = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]")).size();
		System.out.println(actualCountSurname);

		for (int index = 1; index <= actualCountSurname; index++) {
			WebElement surnameElement = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"));
			System.out.println(surnameElement.getText());

			if (surName.contains(surnameElement)) {
				surnameHashSet.add(surnameElement);
			} else {
				surName.add(surnameElement);
			}
		}

		for (WebElement e : surnameHashSet)
			System.out.println(e.getText());
		System.out.println("***************************");
		for (WebElement e : surName)
			System.out.println(e.getText());
	}

	// TestCase5 : Print all the unique surnames and print duplicate surnames if any
	// using Map.
	void testCase5() throws InterruptedException {

//		System.out.println("Open Browser");
//		openBrowser();

		System.out.println("Createing Map to save surname");
		Map<String, Integer> surNameMap = new HashMap<String, Integer>();

		System.out.println("Getting surname lenght");
		int actualCountSurname = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]")).size();
		System.out.println(actualCountSurname);

		for (int index = 1; index <= actualCountSurname; index++) {
			String sunameKey = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			if (surNameMap.containsKey(sunameKey)) {
				int count = surNameMap.get(sunameKey);
				surNameMap.put(sunameKey, count + 1);
			} else {
				surNameMap.put(sunameKey, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : surNameMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("Duplicate surname in the table - " + entry.getKey());
			}
		}

		System.out.println("Unique surname in the table - ");
		for (Map.Entry<String, Integer> entry : surNameMap.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
			}
		}
	}

	// TestCase6 : Print all the unique surnames and print duplicate surnames if any
	// using Set.

	void testCase6() throws InterruptedException {
//		System.out.println("Open Browser");
//		openBrowser();

		System.out.println("Createing Linked HashSet to save surname");
		Set<String> surNameSet = new LinkedHashSet<String>();

		System.out.println("Getting surname lenght");
		int actualCountSurname = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]")).size();
		System.out.println(actualCountSurname);

		for (int index = 1; index <= actualCountSurname; index++) {
			String element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (!surNameSet.add(element)) {
				System.out.println("Duplicate surname - " + element);
			}
		}
		System.out.println("Unique surname list in the table - " + surNameSet);
	}

	// TestCase7 : Return firstname and lastname of each employee in Map<String,
	// String>, in main method verify the lastname of the employee should be Patro
	// whoes firstname is Priya.

	void testCase7() throws InterruptedException {

//		System.out.println("Open Browser");
//		openBrowser();

		System.out.println("Createing Map to save FirstName and LastName");
		Map<String, String> firstLastNameMap = new HashMap<String, String>();

		System.out.println("Getting surname lenght");
		int actualCountFirstName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]")).size();
		System.out.println(actualCountFirstName);

		for (int index = 1; index <= actualCountFirstName; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			firstLastNameMap.put(firstName, lastName);
		}

		//System.out.println(firstLastNameMap);

		System.out.print("Firstname where last name is Patro table - ");
		for (Map.Entry<String, String> entry : firstLastNameMap.entrySet()) {
			if (entry.getValue().equals("Patro")) {
				System.out.println(entry.getKey());
			}
		}
		driver.quit();
	}

	void Extra() throws InterruptedException {

		System.out.println("Open Browser");
		openBrowser();

		System.out.println("Getting table size for username");
		int tableSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println(tableSize);

		System.out.println("Creating ArrayList to store actual username");
		ArrayList<String> actualUsername = new ArrayList<String>();

		System.out.println("Creating ArrayList to store Created username");
		ArrayList<String> createdUsername = new ArrayList<String>();

		for (int index = 1; index <= tableSize; index++) {

			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			String sirName = (firstName.substring(0, 1) + lastName).toLowerCase();
			createdUsername.add(sirName);
		}
		System.out.println(createdUsername);

		for (int index = 1; index <= tableSize; index++) {

			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			actualUsername.add(userName);
		}

		System.out.println(actualUsername);
	}

	public static void main(String[] args) throws InterruptedException {
		TestDempTableKrishana testDempTableKrishana = new TestDempTableKrishana();
		System.out.println("**********************************");
		testDempTableKrishana.testCase1();

		System.out.println("**********************************");
		testDempTableKrishana.testCase2();

		System.out.println("**********************************");
		testDempTableKrishana.testCase3();

		System.out.println("**********************************");
		testDempTableKrishana.testCase4();
		
		System.out.println("**********************************");
		testDempTableKrishana.testCase5();

		System.out.println("**********************************");
		testDempTableKrishana.testCase6();

		System.out.println("**********************************");
		testDempTableKrishana.testCase7();
		
	}
}
