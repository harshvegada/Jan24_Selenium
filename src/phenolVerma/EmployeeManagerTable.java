/*
Assignment 6 - 8th April'2024
TestCase1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
output :  asharma
TestCase2 : print all the rows of Employee Basic Table (using 2 loops).
TestCase3 : print all the rows of Employee Basic Table (only one loop on tr).
Hint : getText -> //table[@id='table1']/tbody/tr[1] 
TestCase4 : print whole table without loop.
TestCase5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
output : 76585 is duplicate employee id
         unique employee ids are 8. 
 */

package phenolVerma;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeManagerTable {

	// Creating Chrome webdriver object
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("Implecite wait for 50 seconds");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	// TestCase1 : print the username of the employee whoes first name is Abhishek,
	// considering rows are dynamic.
	void testCase1() throws InterruptedException {

		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		System.out.print("Getting Employee Name lenght - ");
		int tablelength = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr")).size();
		System.out.println(tablelength);

		for (int rowIndex = 1; rowIndex <= tablelength; rowIndex++) {
			String surnameTofindFirstName = "Abhishek";
			String firstName = driver.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();
			if (firstName.equals("Abhishek")) {
				String surnameForFirstName = driver
						.findElement(By.xpath("//table[@id=\"table1\"]/tbody/tr[" + rowIndex + "]/td[4]")).getText();
				System.out.println("Srname of " + surnameTofindFirstName + " - " + surnameForFirstName);
			}
		}
		driver.quit();
	}

	// TestCase2 : print all the rows of Employee Basic Table (using 2 loops).
	void testCase2() throws InterruptedException {

		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		int tableLenght = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println("Length of the table - " + tableLenght);

		int coloumnLenght = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//th")).size();
		System.out.println("Count of coloumn of the table - " + coloumnLenght);

		System.out.println("Printing the table with 2 for loops");
		for (int rowIndex = 1; rowIndex <= tableLenght; rowIndex++) {
			for (int colIndex = 1; colIndex <= coloumnLenght; colIndex++) {
				System.out.print(driver.findElement(By.xpath(
						"//table[@class=\"table table-striped\"]/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText() + " ");
			}
			System.out.println("");
		}
		driver.quit();
	}

	// TestCase3 : print all the rows of Employee Basic Table (only one loop on tr).
	void testCase3() throws InterruptedException {

		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		int tableLenght = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println("Length of the table - " + tableLenght);

		int coloumnLenght = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//th")).size();
		System.out.println("Count of coloumn of the table - " + coloumnLenght);

		System.out.println("Printing the table with 1 for loops");
		for (int rowIndex = 1; rowIndex <= tableLenght; rowIndex++) {

			System.out.print(
					driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + rowIndex + "]"))
							.getText() + " ");
			System.out.println("");
		}
		driver.quit();
	}

	// TestCase4 : print whole table without loop.
	void testCase4() throws InterruptedException {
		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		int tableLenght = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println("Length of the table - " + tableLenght);

		int coloumnLenght = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//th")).size();
		System.out.println("Count of coloumn of the table - " + coloumnLenght);

		System.out.println("Printing the table with tbody only");
		System.out.print(driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody")).getText() + " ");
		System.out.println("");
		driver.quit();
	}

	// TestCase5 : find the duplicate employee id from EMPLOYEE MANAGER table, if
	// any.
	void testCase5() throws InterruptedException {

		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		System.out.println("Createing Map to save Employee Id");
		Map<String, Integer> emplaoyeeIdMap = new HashMap<String, Integer>();

		System.out.print("Getting Employee ID lenght - ");
		int actualEmployeeId = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println(actualEmployeeId);

		for (int index = 1; index <= actualEmployeeId; index++) {
			String emplaoyeeIdKey = driver
					.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (emplaoyeeIdMap.containsKey(emplaoyeeIdKey)) {
				int count = emplaoyeeIdMap.get(emplaoyeeIdKey);
				emplaoyeeIdMap.put(emplaoyeeIdKey, count + 1);
			} else {
				emplaoyeeIdMap.put(emplaoyeeIdKey, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : emplaoyeeIdMap.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("Duplicate Employee Id in the table - " + entry.getKey());
			}
		}
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		EmployeeManagerTable employeeManagerTable = new EmployeeManagerTable();

		System.out.println("***************************************");
		employeeManagerTable.testCase1();

		System.out.println("***************************************");
		employeeManagerTable.testCase2();

		System.out.println("***************************************");
		employeeManagerTable.testCase3();

		System.out.println("***************************************");
		employeeManagerTable.testCase4();

		System.out.println("***************************************");
		employeeManagerTable.testCase5();
	}
}