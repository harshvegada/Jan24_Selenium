package pujaPoreddiwar;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Assignment6_DemoTable1 {

	WebDriver driver;

	void openBrowser() {
		driver = new ChromeDriver();

		System.out.println("STEP: URL Loaded and Maximized");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: Click on Element Tab");
		driver.findElement(By.linkText("Demo Tables")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='table1']/thead/tr[1]/th[2]")));
		System.out.println("Element found");
	}

	//TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
	//output :  asharma
	void testCase1() {
		openBrowser();
		System.out.println("------------------Test Case 1-------------------");
		System.out.println("STEP: count UserNames");
		int countRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("VERFIY: indentify Abhishek's LastName is asharma");
		for (int i = 1; i <= countRow; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();
			if (firstName.equals("Abhishek")) {
				System.out.println("UserName of " + firstName + " is :" + userName);
				if (userName.equals("asharma")) {
					System.out.println("Test Passed");
				} else {
					System.out.println("Test Failed");
				}
			}
		}
	}

	//TC2 : print all the rows of Employee Basic Table (using 2 loops).
	void testCase2() {
		System.out.println("------------------Test Case 2-------------------");
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th")).size();
		int totalrow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= totalrow; rowIndex++) {
			for (int colIndex = 1; colIndex <=totalCol; colIndex++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText() + " ");
			}
			System.out.println("");
		}

	}

	//TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	void testCase3() {
		System.out.println("------------------Test Case 3-------------------");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int rowIndex = 1;rowIndex<=rowCount;rowIndex++) {
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]")).getText());
		}
	}
	
	//TC4 : print whole table without loop.
	void testCase4() {
		System.out.println("------------------Test Case 4-------------------");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
	}
	
	List<String> convertStringToList(List<WebElement> element){
		List<String> list = new ArrayList<String>();
		for( WebElement e : element) {
			list.add(e.getText());
		}
		return list;
	}
	
	void testCase5() {
		System.out.println("------------------Test Case 5-------------------");
		System.out.println("Find Dupicate Employee id");
		Set<String> setOfEmployee =new HashSet<String>();
		List<WebElement> listOfElement = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		List<String> stringList = convertStringToList(listOfElement);

		System.out.println("VERIFY:Id is Duplicate or not ");
		for (String empId : stringList) {
			if (!setOfEmployee.add(empId)) {
				System.out.println( empId + ": is duplicate employee id" );
			}
		}
		System.out.println("Unique employee ids are " + setOfEmployee.size());
		driver.quit();
	}
	
	public static void main(String[] args) {
		Assignment6_DemoTable1 demoTable1 = new Assignment6_DemoTable1();
		demoTable1.testCase1();
		demoTable1.testCase2();
		demoTable1.testCase3();
		demoTable1.testCase4();
		demoTable1.testCase5();

	}

}
