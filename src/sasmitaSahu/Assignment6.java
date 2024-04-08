package sasmitaSahu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;

	void load() {
		System.out.println("STEP1-Launch the ChromeBowser");
		driver = new ChromeDriver();

		System.out.println("STEP2-Maximise the ChromeBowser");
		driver.manage().window().maximize();

		System.out.println("STEP3-hit the url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP4-Click on Demo tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	// print the username of the employee whoes first name is Abhishek, considering
	// rows are dynamic.

	void testcase1() {
		load();
		System.out.println("Testcase 1");
		int sizeOfFirstName = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[2]")).size();
		System.out.println("Total no of rows : " + sizeOfFirstName);

		System.out.println("STEP5-Print the usernme of the employee whose firstname is abhishek");
		for (int i = 1; i <= sizeOfFirstName; i++) {
			String firstname = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String username = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (firstname.equals("Abhishek")) {
				System.out.println(username);
			}
		}
	}

	// print all the rows of Employee Basic Table (using 2 loops).
	void testcase2() {
		System.out.println("Testcase 2");
		int rowsize = driver.findElements(By.xpath("//table[@id='table1']//tr/td[1]")).size();
		System.out.println(rowsize);

		int columnsize = driver.findElements(By.xpath("//table[@id='table1']//tr[1]/td")).size();
		System.out.println(columnsize);

		System.out.println("STEP8-Print the table ");
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String text = driver.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]/td[" + j + "] "))
						.getText();
				System.out.print(text + " ");
			}
			System.out.println();
		}
	}

	// print all the rows of Employee Basic Table (only one loop on tr).
	void testcase3() {
		System.out.println("Testcase 3");
		int rowsize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println(rowsize);
		for (int i = 1; i <= rowsize; i++) {

			String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText();
			System.out.println(text);
		}
	}

	// print whole table without loop.
	void testcase4() {
		System.out.println("Testcase 4");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
	}

	// find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	void testcase5() {
		System.out.println("Testcase 5");
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).size();
		List<Integer> ls = new ArrayList<Integer>();
		System.out.println("STEP9-print duplicate element");
		for (int i = 1; i <= size; i++) {
			String name = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(name);
			if (!ls.contains(Integer.valueOf(name))) {
				ls.add(Integer.valueOf(name));
			} else {
				System.out.println(name);
			}
		}
		System.out.println("STEP10-:print the Unique Employee id are");
		System.out.println(ls.size());
	}

	public static void main(String[] args) {
		Assignment6 assignment6 = new Assignment6();
		assignment6.testcase1();
		assignment6.testcase2();
		assignment6.testcase3();
		assignment6.testcase4();
		assignment6.testcase5();
	}

}
