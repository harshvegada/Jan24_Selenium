package varshaNagadwala;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationByKrishnaVerifyTableInformation {

	WebDriver driver;

	void launchBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Demo Table link");
		driver.findElement(By.id("demotable")).click();
	}

	List<String> convertToStringList(List<WebElement> list) {
		List<String> listOfString = new ArrayList<String>();
		for (WebElement e : list) {
			listOfString.add(e.getText());
		}
		return listOfString;
	}

//	TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
//	output :  asharma
	void testCase1() {

		System.out.println("TestCase1 Start");
		launchBrowser();

		System.out.println("STEP : Number of row");
		int totalNoOfRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("STEP : Create map of string");
		Map<String, String> listOfElement = new LinkedHashMap<>();

		System.out.println("STEP : Add all the name and it username in map");
		for (int i = 1; i <= totalNoOfRow; i++) {
			String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]")).getText();

			listOfElement.put(firstname, username);
		}

		String name = "Abhishek";

		System.out.println("STEP : Get the value of name");
		if (listOfElement.containsKey(name))
			System.out.println(listOfElement.get(name));

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC2 : print all the rows of Employee Basic Table (using 2 loops).
	void testCase2() {

		System.out.println("TestCase2 Start");
		launchBrowser();

		System.out.println("STEP : Number of column");
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("STEP : Number of column");
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th")).size();

		System.out.println("STEP : Print all the entries in employees table");
		for (int j = 1; j <= totalRow; j++) {
			for (int i = 1; i <= totalCol; i++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + j + "]/td[" + i + "]"))
						.getText() + " ");
			}
			System.out.println();
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	void testCase3() {

		System.out.println("TestCase3 Start");
		launchBrowser();

		System.out.println("STEP : Number of column");
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		System.out.println("STEP : Print all the entries in employees table");
		for (int j = 1; j <= totalRow; j++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + j + "]")).getText());
		}
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC4 : print whole table without loop.
	void testCase4() {

		System.out.println("TestCase4 Start");
		launchBrowser();

		System.out.println("STEP : Print all the entries in employees table");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

//	TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
//	output : 76585 is duplicate employee id
//	unique employee ids are 8.
	void testCase5() {

		System.out.println("TestCase5 Start");
		launchBrowser();

		System.out.println("STEP : Take all the webelement");
		List<WebElement> listOfEmployeesId = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));

		System.out.println("STEP : Convert array into list");
		List<String> listOfEmployeesIdStr = convertToStringList(listOfEmployeesId);

		System.out.println("STEP : Create set");
		Set<String> setOfEmployeeId = new LinkedHashSet<>();

		System.out.println("STEP : add all the id in the Set is dublicated than print that id");
		for (String id : listOfEmployeesIdStr) {
			if (setOfEmployeeId.contains(id)) {
				System.out.println(id);
			} else {
				setOfEmployeeId.add(id);
			}
		}
		System.out.println("Total Unique employees id is/are " + setOfEmployeeId.size());

		System.out.println("STEP : Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) {
		AutomationByKrishnaVerifyTableInformation automationByKrishnaVerifyTableInformation = new AutomationByKrishnaVerifyTableInformation();
		automationByKrishnaVerifyTableInformation.testCase1();
		System.out.println();
		automationByKrishnaVerifyTableInformation.testCase2();
		System.out.println();
		automationByKrishnaVerifyTableInformation.testCase3();
		System.out.println();
		automationByKrishnaVerifyTableInformation.testCase4();
		System.out.println();
		automationByKrishnaVerifyTableInformation.testCase5();

	}
}
