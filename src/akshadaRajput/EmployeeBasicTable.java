package akshadaRajput;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeBasicTable {

	WebDriver driver;

	void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("demotable")).click();

	}

	void printUsernameOfEmployee() {
		System.out.println(
				"TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic."
						+ " output :  asharma");
		launchBrowser();

		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= totalRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();

			if (firstName.equals("Abhishek")) {
				String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
						.getText();

				if (userName.equals("asharma"))
					System.out.println("TC1 pass");

				else
					System.out.println("TC1 Fail");
			}
		}
	}

	void pintAllRowsUsingTwoLoops() {
		launchBrowser();
		System.out.println("TC2 : print all the rows of Employee Basic Table (using 2 loops)");

		int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= totalColumns; index++) {
			String column = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + index + "]")).getText();
			System.out.print(column);

		}

		System.out.println();

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]")).getText();
			System.out.print(row);
			System.out.println();
		}

		teardown();
	}

	void printAllRowsUsingSingleLoop() {
		System.out.println("TC3 : print all the rows of Employee Basic Table (only one loop on tr).");
		launchBrowser();

		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= totalRows; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]")).getText());
		}

		teardown();
	}

	void printTable() {

		System.out.println("TC4 : print whole table without loop.");
		launchBrowser();
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
		teardown();
	}

	List<String> returnWebElementText(List<WebElement> listOfWebElement) {
		List<String> listOfString = new ArrayList<String>();

		for (WebElement e : listOfWebElement) {
			listOfString.add(e.getText());
		}

		return listOfString;
	}

	void getDuplicateEmpId() {
		System.out.println("TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.");

		launchBrowser();

		List<WebElement> listOfWebElements = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));

		List<String> listOfEmpIds = returnWebElementText(listOfWebElements);
		Set<String> setOfEmpIds = new LinkedHashSet<String>();

		for (String empId : listOfEmpIds) {
			if (!setOfEmpIds.add(empId))
				System.out.println(empId + " is duplicate");
		}

		System.out.println("Unique employee ids are " + setOfEmpIds.size());

		teardown();
	}

	void teardown() {
		driver.quit();
	}

	public static void main(String args[]) {
		EmployeeBasicTable employeeBasicTable = new EmployeeBasicTable();
		employeeBasicTable.printUsernameOfEmployee();
		System.out.println();
		employeeBasicTable.pintAllRowsUsingTwoLoops();
		System.out.println();
		employeeBasicTable.printAllRowsUsingSingleLoop();
		System.out.println();
		employeeBasicTable.printTable();
		System.out.println();
		employeeBasicTable.getDuplicateEmpId();
	}

}
