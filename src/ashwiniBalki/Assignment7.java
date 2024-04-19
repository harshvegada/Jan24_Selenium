package ashwiniBalki;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Assignment 7 - 8th April'2024 [IMP]
Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]
 */
public class Assignment7 {

	WebDriver driver;

	void setupLaunchBrowser() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP - click on Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void createMapofDept() {

		Map<String, Integer> deptMap = new HashMap<String, Integer>();
	    // get the size of Employee Department.
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for (int index = 1; index <= size; index++) {
			WebElement element = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"));
			String empDep = element.getText();

			if (deptMap.containsKey(empDep)) {
				int count = deptMap.get(empDep);
				deptMap.put(empDep, count + 1);
			} else {
				deptMap.put(empDep, 1);
			}
		}
		System.out.println("Map of Depaartment: " + deptMap);
	}

	void closeBrowser() {
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment7 assignment7 = new Assignment7();
		assignment7.setupLaunchBrowser();
		assignment7.createMapofDept();
		assignment7.closeBrowser();

	}
}
