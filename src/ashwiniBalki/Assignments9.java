package ashwiniBalki;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
Assignment 9 - 10th April'2024 [IMP]
Print Manager Id, number of reportees in each managerId, employee name under each manager as below.
20209 -> 3 -> Abhijit Mane, Sumit Kulkarni, Pawan Belamkar
 */
public class Assignments9 {

	WebDriver driver;
	WebDriverWait wait;

	void launchBrowserSetUp() {
		driver = new ChromeDriver();
		System.out.println("STEP: Launch the URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		System.out.println("STEP: click on demotable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

	}

	void tc1() {
		launchBrowserSetUp();
		System.out.println("Print Manager Id, number of reportees in each managerId, employee name under each manager");

		LinkedHashMap<String, List<String>> deptEmplMap = new LinkedHashMap<String, List<String>>();
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		for (int rowIndex = 1; rowIndex <= size; rowIndex++) {

			String employeeManagerID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[4]"))
					.getText();
			String EmployeeName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[3]"))
					.getText();

			if (deptEmplMap.containsKey(employeeManagerID)) {
				List<String> empList = deptEmplMap.get(employeeManagerID);
				if (!empList.contains(EmployeeName)) {
					empList.add(EmployeeName);
					deptEmplMap.put(employeeManagerID, empList);
				}
			} else {
				List<String> list = new ArrayList<String>();
				list.add(EmployeeName);
				deptEmplMap.put(employeeManagerID, list);
			}
		}

		Set<String> keySet = deptEmplMap.keySet();
		for (String key : keySet) {
			List<String> list = deptEmplMap.get(key);
			System.out.println(key + "---->" + list.size() + "=" + list);
		}
		System.out.println("STEP:Close the browser");
		driver.quit();
	}

	public static void main(String[] args) {
		Assignments9 assignments9 = new Assignments9();
		assignments9.tc1();
	}

}

