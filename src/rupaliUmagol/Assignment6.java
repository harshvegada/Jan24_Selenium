package rupaliUmagol;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;

	void setUp() {
		System.out.println("STEP : Launch ChromeBrowser and Open Url");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP : Maximize Window and add wait");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP : Click On Demo Table tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}

	// TC1 : print the username of the employee whoes first name is Abhishek,
	// considering rows are dynamic.
	// output:asharma
	void getUserName() {
		System.out.println("STEP : Find all FirstName");
		List<WebElement> listOfFirstNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));

		System.out.println("STEP : Find FirstName as abhishek");
		for (int i = 1; i <= listOfFirstNames.size(); i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();
			if (firstName.equals("Abhishek")) {
				System.out.println(userName);
			}
		}
	}

	// TC2 : print all the rows of Employee Basic Table (using 2 loops).
	void printAllRows() {
		System.out.println("STEP : Count the size of Rows of Employee Table");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("STEP : Count the size of Rows of Employee Table");
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();

		System.out.println("STEP : Print All Rows");
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 1; j <= totalCol; j++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getText() + " ");
			}
			System.out.println();
		}
	}

	// TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	// : getText -> //table[@id='table1']/tbody/tr[1]
	void PrintAllRowsUsingOneLoop() {
		System.out.println("STEP : Count the size of Rows of Employee Table");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int i = 1; i <= totalRows; i++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText());
			System.out.println();
		}
	}

	// TC4 : print whole table without loop.
	void PrintWholeTable() {
		System.out.println("STEP : Print whole Table");
		System.out.print(driver.findElement(By.xpath("//table[@id='table1']")).getText());
	}

	// TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	// output : 76585 is duplicate employee id
	// unique employee ids are 8.

	List<String> convertWebElementToString(List<WebElement> element) {
		List<String> ListOfStringIds = new ArrayList<>();
		for (WebElement e : element) {
			ListOfStringIds.add(e.getText());
		}
		return ListOfStringIds;
	}

	void getDuplicateEmployeeId() {
		Set<String> setOfid = new LinkedHashSet<>();

		System.out.println("STEP : Find total No of Rows ");
		List<WebElement> listOfIds = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));

		System.out.println("STEP : Count of rows ");
		int count = listOfIds.size();

		System.out.println("STEP : Convert WebElement List to String List");
		List<String> listOfStringIds = convertWebElementToString(listOfIds);

		System.out.println("VERIFY : Find Duplicate Ids");
		for (String ids : listOfStringIds)
			if (!setOfid.add(ids)) {
				System.out.println("Duplicate IDs : " + ids);
			} 
		
		System.out.println("STEP : close Browser");
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment6 assignment = new Assignment6();
		assignment.setUp();
		assignment.getUserName();
		assignment.printAllRows();
		assignment.PrintAllRowsUsingOneLoop();
		assignment.PrintWholeTable();
		assignment.getDuplicateEmployeeId();
		
	}
}
