/*TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
output : asharma
TC2 : print all the rows of Employee Basic Table (using 2 loops).
TC3 : print all the rows of Employee Basic Table (only one loop on tr).
Hint : getText -> //table[@id='table1']/tbody/tr[1]
TC4 : print whole table without loop.
TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
output : 76585 is duplicate employee id
unique employee ids are 8.*/

package madhuraKulkarni;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;

	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 1: Launch the browser and hit the URL.");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Browser launched successfully...");
	}

	// TC1 : print the username of the employee whoes first name is Abhishek,
	// considering rows are dynamic.
	// output : asharma

	void testCase1() {
		launchBrowser();
		System.out.println("STEP: Find the total number of rows in first name column: ");
		int firstNameCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]")).size();
		System.out.println("Total number of rows in first name column are: " + firstNameCount);
		System.out.println("STEP: Find the username of the employee whoes first name is Abhishek");
		for (int i = 1; i <= firstNameCount; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();
			if (firstName.equals("Abhishek"))
				System.out.println("UserName is : " + userName);
		}
	}

	// TC2 : print all the rows of Employee Basic Table (using 2 loops).

	void testCase2() {
		System.out.println("STEP: Find the Row and Column count of the table.");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']//tr/td[1]")).size();
		System.out.println("Row count in the table1: " + rowCount);

		int columnCount = driver.findElements(By.xpath("//table[@id='table1']//tr[1]/td")).size();
		System.out.println("Column count in the table1: " + columnCount);

		System.out.println("STEP: Print the table 1 data");
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 1; j <= columnCount; j++) {
				System.out.println(
						driver.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]/td[" + j + "]")).getText()
								+ " ");
			}
			System.out.println("");
		}
	}

	// TC3 : print all the rows of Employee Basic Table (only one loop on tr).
//Hint : getText -> //table[@id='table1']/tbody/tr[1]

	void testCase3() {
		System.out.println("STEP: Find the Row and Column count of the table.");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Row count in the table1: " + rowCount);

		System.out.println("STEP: Print the table 1 data.");
		for (int i = 1; i <= rowCount; i++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText());
		}
	}

	// TC4 : print whole table without loop.

	void testCase4() {
		System.out.println("STEP: Print the table 1 data.");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
	}

	// TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	void testCase5() {
		System.out.println("STEP: Find the row count of table.");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).size();
		System.out.println("Row count in the table1: " + rowCount);

		List<Integer> list = new ArrayList<Integer>();
		System.out.println("STEP: Find the duplicate employee id.");
		for (int i = 1; i <= rowCount; i++) {
			String employeeId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(employeeId);
			if (!list.contains(Integer.valueOf(employeeId))) {
				list.add(Integer.valueOf(employeeId));
			} else {
				System.out.println("Duplicate employee Id is : " + employeeId);
			}
		}
	}

	void display() {
		System.out.println("--------------TestCase 1 Started-----------------------");
		testCase1();
		System.out.println("--------------TestCase 2 Started-----------------------");
		testCase2();
		System.out.println("--------------TestCase 3 Started-----------------------");
		testCase3();
		System.out.println("--------------TestCase 4 Started-----------------------");
		testCase4();
		System.out.println("--------------TestCase 5 Started-----------------------");
		testCase5();
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment6 assignment6 = new Assignment6();
		assignment6.display();
	}

}
