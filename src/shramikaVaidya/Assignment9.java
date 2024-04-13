package shramikaVaidya;

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

public class Assignment9 {

	WebDriver driver;
	WebDriverWait wait;

	void getBrowserSetUp() {
		driver = new ChromeDriver();
		System.out.println("STEP: Hit the URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP: click on demotable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

	}

	void testCase1() {
		getBrowserSetUp();
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
		Assignment9 assignment9 = new Assignment9();
		assignment9.testCase1();
	}
}