package ashwiniBalki;

import java.util.HashMap;
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

/*
Assignment - 5 : 7th April
URl-http://automationbykrishna.com/#
TC1 : In table 1, how many employees are there. 
Answer : 5
TC2 : In table1, how many column are there and print all headers of each column [compare list to list].
Answer : 4
TC3 : Find of total username in table1, verify each  username is unique. Print all usernames.
TC4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
TC5 : Print all the unique surnames and print duplicate surnames if any using Map. 
TC6 : Print all the unique surnames and print duplicate surnames if any using Set. 
TC7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of
 the employe
 e should be Patro whoes firstname is Priya.
 */
public class Assignment5_TableDetails {
	WebDriver driver;

	// Open Browser
	void launchBrowser() {

		System.out.println("Step: Launch Chorme browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step : Hit URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("Click on Demo table");
		driver.findElement(By.xpath("//a[@id = 'demotable']")).click();
	}

	void closeBrowser() {
		System.out.println("Close Browser");
		driver.quit();
	}

	// TC1 : In table 1, how many employees are there.
	void tc1() {

		System.out.println("TC1 --Check how many employees/rows are there?");
		List<WebElement> empcount = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr"));
		System.out.println("Total number of employees are: " + empcount.size());
	}

	// TC2 : In table1, how many column are there and print all headers of each
	// column [compare list to list].

	void tc2() {

		String expectedHeaders = "# First Name Last Name Username";

		System.out.println("TC2 -- how many column are there and print all headers of each column");
		List<WebElement> listOfHeader = driver.findElements(By.xpath("//table[@id = 'table1']/thead/tr/th"));
		System.out.println("Total Columns are: " + listOfHeader.size());

		System.out.println("Step: Verify Test case is passed or Failed");
		if (listOfHeader.size() == 4) {
			System.out.println("Test Case Pass");
		} else {
			System.out.println("Test Case fail");
		}

		System.out.println("Step: Print all headers of each column and compare list to list.");
		String actualHeaders = "";
//    	for (int index = 0 ; index <  listOfHeader.size() ; index++ ) {
//    		System.out.print( listOfHeader.get(index).getText());
//    		actualHeaders = actualHeaders + listOfHeader.get(index).getText() + " ";
//    	}

		for (WebElement e : listOfHeader) {
			actualHeaders = actualHeaders + e.getText() + " ";
		}

		System.out.println(actualHeaders);
		actualHeaders = actualHeaders.trim();

		if (actualHeaders.equals(expectedHeaders)) {
			System.out.println("Test Pass - ActualHeaders & ExpectedHeaders are same");
		} else {
			System.out.println("Test Fail -  ActualHeaders & ExpectedHeaders are not same");
		}
	}

	// TC3 : Find of total username in table1, verify each username is unique. Print
	// all usernames.
	void tc3() {

		System.out.println("TC3 --Find of total username in table1");
		List<WebElement> usernameList = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[4]"));
		System.out.println("UserName List size: " + usernameList.size());
		Set<WebElement> setOfUserName = new HashSet<>(usernameList);

		if (usernameList.size() == setOfUserName.size()) {
			System.out.println("Test Pass - All usernames are unique");
		} else {
			System.out.println("Test Fail - All username are not unique");
		}
	}

	// TC4 : Print all the unique surnames and print duplicate surnames if any using
	// List+Set.
	void tc4() {

		System.out.println("TC4 --Print all the unique surnames and print duplicate surnames if any using List+Set.");
		List<WebElement> listOfSurname = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[3]"));

		Set<String> setOfSurname = new LinkedHashSet<>();
		Set<String> setOfDuplctSurname = new LinkedHashSet<>();

		for (WebElement e : listOfSurname) {
			String surname = e.getText();

			if (setOfSurname.contains(surname)) {
				setOfDuplctSurname.add(surname);

			} else {
				setOfSurname.add(surname);
			}
		}

		System.out.println("Print unique LastName: ");
		for (String surname : setOfSurname) {
			if (!setOfDuplctSurname.contains(surname)) {
				System.out.println(surname);
			}
		}

		System.out.println("Print duplicate LastName: ");
		for (String surname : setOfDuplctSurname) {
			System.out.println(surname);
		}
	}

	// TC5 : Print all the unique surnames and print duplicate surnames if any using
	// Map.
	void tc5() {

		System.out.println("TC5 : Print all the unique surnames and print duplicate surnames if any using");

		List<WebElement> listOfSurname = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[3]"));

		System.out.println("Create Hasmap for surname(key) and count(value)");
		Map<String, Integer> mapOfLastName = new LinkedHashMap<>();

		for (WebElement e : listOfSurname) {
			String surname = e.getText();

			if (mapOfLastName.containsKey(surname)) {
				int count = mapOfLastName.get(surname);
				mapOfLastName.put(surname, count + 1);
			} else {
				mapOfLastName.put(surname, 1);
			}
		}
		System.out.println("Print unique LastName: ");
		Set<String> surnameSet = mapOfLastName.keySet();

		for (String key : surnameSet) {
			if (mapOfLastName.get(key) == 1) {
				System.out.println(key);
			}
		}
		System.out.println("Print duplicate lastName: ");
		for (String key : surnameSet) {
			if (mapOfLastName.get(key) > 1) {
				System.out.println(key);
			}
		}
	}

	// TC6 : Print all the unique surnames and print duplicate surnames if any using
	// Set.
	void tc6() {

		System.out.println("TC6 : Print all the unique surnames and print duplicate surnames if any using");

		List<WebElement> listOfSurname = driver.findElements(By.xpath("//table[@id = 'table1']/tbody/tr/td[3]"));

		System.out.println("Create LinkedHashSet");
		Set<String> setOfSurname = new LinkedHashSet<>();
		Set<String> setOfDuplctSurname = new LinkedHashSet<>();

		for (WebElement e : listOfSurname) {
			String surname = e.getText();

			if (setOfSurname.contains(surname)) {
				setOfDuplctSurname.add(surname);

			} else {
				setOfSurname.add(surname);
			}
		}

		System.out.println("Print unique LastName: ");
		for (String surname : setOfSurname) {
			if (!setOfDuplctSurname.contains(surname)) {
				System.out.println(surname);
			}
		}

		System.out.println("Print duplicate LastName: ");
		for (String surname : setOfDuplctSurname) {
			System.out.println(surname);
		}
	}

	/*
	 * TC7 : Return firstname and lastname of each employee in Map<String, String>,
	 * in main method verify the lastname of the employe e should be Patro whoes
	 * firstname is Priya.
	 */
	void tc7() {
		System.out.println("TC7 : Return firstname and lastname of employee");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> fullNameMap = new LinkedHashMap<String, String>();

		for (int i = 1; i <= rowCount; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();

			fullNameMap.put(firstName, lastName);
		}
		String value = fullNameMap.get("Priya");
		if (value.equals("Patro")) {
			System.out.println("Test pass - Priya's last name is Patro");
		} else {
			System.out.println("Test fail - Priya's last name is not Patro");
		}
	}

	public static void main(String[] args) {
		Assignment5_TableDetails assignment5_TableDetails = new Assignment5_TableDetails();
		assignment5_TableDetails.launchBrowser();
		assignment5_TableDetails.tc1();
		System.out.println("------------------------------");
		assignment5_TableDetails.tc2();
		System.out.println("------------------------------");
		assignment5_TableDetails.tc3();
		System.out.println("------------------------------");
		assignment5_TableDetails.tc4();
		System.out.println("------------------------------");
		assignment5_TableDetails.tc5();
		System.out.println("------------------------------");
		assignment5_TableDetails.tc6();
		System.out.println("------------------------------");
		assignment5_TableDetails.tc7();
		assignment5_TableDetails.closeBrowser();

	}
}
