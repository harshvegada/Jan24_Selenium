package gauravGarg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTableDifferentWayAssignment6 {

	WebDriver wb;

	void loadBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step 2-: Click on Demo Table tab ");
		wb.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	}

//print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
	void testCase1() {
		System.out.println("Test Case 1");
		loadBrowser();
		int size = wb.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[2]")).size();
		System.out.println("Step 3-:Load the Element ");
		System.out.println("Step 4-:print the username of the employee whoes first name is Abhishek");
		for (int i = 1; i <= size; i++) {
			String firstName = wb.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + i + "]/td[2]")).getText();
			String username = wb.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + i + "]/td[4]")).getText();
			if (firstName.equals("Abhishek")) {
				System.out.println(username);
			}
		}
		wb.quit();
	}

// print all the rows of Employee Basic Table (using 2 loops).
	void testCase2() {
		System.out.println();
		System.out.println("Test Case 2");
		loadBrowser();
		int rowsize = wb.findElements(By.xpath("//table[@id='table1']//tr/td[1]")).size();
		int columnsize = wb.findElements(By.xpath("//table[@id='table1']//tr[1]/td")).size();
		System.out.println("Step 3-:Calculate Row Size and Column Sixe ");
		System.out.println("Step 4-:print the Table ");
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String text = wb.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]/td[" + j + "] "))
						.getText();
				System.out.print(text + " ");
			}
			System.out.println();
		}
		wb.quit();
	}

//TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	void testCase3() {
		System.out.println();
		System.out.println("Test Case 3");
		loadBrowser();
		int rowsize = wb.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("Step 3-:Calculate Row Size ");
		System.out.println("Step 4-:print the Table using 1 for loop");
		for (int i = 1; i <= rowsize; i++) {
			String text = wb.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText();
			System.out.println(text);
		}
		wb.quit();
	}

	// TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	void testCase4() {
		System.out.println();
		System.out.println("Test Case 4");
		loadBrowser();
		System.out.println("Step 3-:print the Table using no loop");
		String text = wb.findElement(By.xpath("//table[@id='table1']")).getText();
		System.out.println(text);
		wb.quit();
	}

	/*
	 * TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	 * output : 76585 is duplicate employee id unique employee ids are 8.
	 */
	void testCase5() {
		System.out.println();
		System.out.println("Test Case 5");
		loadBrowser();
		int size = wb.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).size();
		List<Integer> ls = new ArrayList<Integer>();
		System.out.println("Step 3-:print the Duplicate Element are");
		for (int i = 1; i <= size; i++) {
			String name = wb.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			if (!ls.contains(Integer.valueOf(name))) {
				ls.add(Integer.valueOf(name));
			} else {
				System.out.println(name);
			}
		}
		System.out.println("Step 4-:print the Unique Employee id are");
		System.out.println(ls.size());
	}

	public static void main(String[] args) {
		new PrintTableDifferentWayAssignment6().testCase1();
		new PrintTableDifferentWayAssignment6().testCase2();
		new PrintTableDifferentWayAssignment6().testCase3();
		new PrintTableDifferentWayAssignment6().testCase4();
		new PrintTableDifferentWayAssignment6().testCase5();
	}
}

