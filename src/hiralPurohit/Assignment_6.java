package hiralPurohit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
//TC2 : print all the rows of Employee Basic Table (using 2 loops).
//TC3 : print all the rows of Employee Basic Table (only one loop on tr).
//TC4 : print whole table without loop.
//TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.

public class Assignment_6 {

	WebDriver driver;

	void getBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Hit the URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: Click on Demotable Tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void testCase1() {
		System.out.println("STEP: count userName");
		int row = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= row; index++) {

			String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (firstname.equals("Abhishek")) {
				System.out.println(firstname + "'s username is" + username);
				if (username.equals("asharma")) {
					System.out.println("Test pass");
				} else {
					System.out.println("Test fail");
				}
			}
		}
	}

	void testCase2() {
		System.out.println("TestCase2: Print All The Rows Of Table");
		int column = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th")).size();
		int row = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
			for (int colIndex = 1; colIndex <= column; colIndex++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText() + " ");
			}
			System.out.println();
		}
	}

	void testCase3() {
		System.out.println("TestCase3: Print all row using one for loop");
		int row = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= row; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]")).getText());
		}
	}

	void testCase4() {
		System.out.println("TestCase4: Print all row without loop");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
	}

	List<String> convertIntoString(List<WebElement> element) {
		List<String> tempList = new ArrayList<String>();
		for (WebElement e : element) {
			tempList.add(e.getText());
		}
		return tempList;
	}

	void testCase5() {
		System.out.println("TestCase5: find the duplicate employee id");
		Set<String> empSet = new HashSet<String>();

		List<WebElement> tableList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		int row = tableList.size();
		List<String> stringList = convertIntoString(tableList);

		System.out.println("STEP: verify duplicate id");
		for (String id : stringList) {
			if (!empSet.add(id)) {
				System.out.println("Duplicates id are:" + id);
			}
		}
		System.out.println("Size after removing duplicates" + empSet.size());
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment_6 assignment_6 = new Assignment_6();
		assignment_6.getBrowser();
		System.out.println("========================================");
		assignment_6.testCase1();
		System.out.println("========================================");
		assignment_6.testCase2();
		System.out.println("========================================");
		assignment_6.testCase3();
		System.out.println("========================================");
		assignment_6.testCase4();
		System.out.println("========================================");
		assignment_6.testCase5();
		System.out.println("========================================");
	}

}
