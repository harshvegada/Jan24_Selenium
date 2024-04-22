package dharmaKanani;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	void testCase3() {
		System.out.println("STEP: Find the Row and Column count of the table.");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Row count in the table1: " + rowCount);

		System.out.println("STEP: Print the table 1 data.");
		for (int i = 1; i <= rowCount; i++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText());
		}
	}

	void testCase4() {
		System.out.println("STEP: Print the table 1 data.");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
	}

	void testCase5() {

		HashSet<String> setOfEmp = new HashSet<String>();
		List<WebElement> element = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		List<String> stringList = convertElementToString(element);
		System.out.println("STEP: find Duplicate ID");
		for (String id : stringList) {
			if (!setOfEmp.add(id)) {
				System.out.println("Duplicates id are->" + id);
			}
		}
		System.out.println("Size after removing duplicates -> " + setOfEmp.size());
		driver.quit();
	}

	List<String> convertElementToString(List<WebElement> element) {
		List<String> listOfNames = new LinkedList<String>();
		for (WebElement e : element) {
			listOfNames.add(e.getText());
		}
		return listOfNames;
	}
	
	public static void main(String[] args) {
		Assignment6 ass6 = new Assignment6();
		ass6.testCase1();
		ass6.testCase2();
		ass6.testCase3();
		ass6.testCase4();
		ass6.testCase5();
	}
}
