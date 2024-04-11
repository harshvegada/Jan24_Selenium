package garimaSinghal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {
	WebDriver driver;

	void setUp() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP - click on Demo Table link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void testCase1() {
		setUp();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int i = 1; i <= totalRows; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();
			if (firstName.equals("Abhishek")) {
				System.out.println(firstName + "--->" + username);
			}
		}
	}

	void testCase2() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int totalcols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th")).size();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			for (int colIndex = 1; colIndex <= totalcols; colIndex++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText() + " ");
			}
			System.out.println();
		}
	}

	void testCase3() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]")).getText() + " ");
		}
	}

	void testCase4() {
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
		Assignment_6 assignment_6 = new Assignment_6();
		System.out.println("===============================");
		assignment_6.testCase1();
		System.out.println("===============================");
		assignment_6.testCase2();
		System.out.println("===============================");
		assignment_6.testCase3();
		System.out.println("===============================");
		assignment_6.testCase4();
		System.out.println("===============================");
		assignment_6.testCase5();
	}
}
