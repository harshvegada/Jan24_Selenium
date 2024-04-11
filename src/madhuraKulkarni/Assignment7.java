/*Assignment 7 - 8th April'2024 [IMP]

Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]*/

package madhuraKulkarni;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
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

	void getMapOfDepartment() {
		launchBrowser();
		System.out.println("STEP : Find the size of the employee table.");
		Map<String, Integer> mapOfEmployee = new LinkedHashMap<String, Integer>();
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		System.out.println("Row size of employee table : " + rowCount);

		for (int i = 1; i <= rowCount; i++) {
			WebElement e = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]"));
			String department = e.getText();

			if (mapOfEmployee.containsKey(department)) {
				int count = mapOfEmployee.get(department);
				mapOfEmployee.put(department, count + 1);
			} else
				mapOfEmployee.put(department, 1);
		}
		System.out.println("STEP: Print the map of Employee");
		System.out.println(mapOfEmployee);
		System.out.println("--------Test case passed---------");
		driver.quit();
	}

	public static void main(String[] args) {
		new Assignment7().getMapOfDepartment();
	}
}
