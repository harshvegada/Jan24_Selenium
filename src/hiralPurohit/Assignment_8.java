package hiralPurohit;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_8 {

	WebDriver driver;
	WebDriverWait wait;

	void browserSetUp() {
		driver = new ChromeDriver();
		System.out.println("STEP: Hit the URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();

		System.out.println("STEP: click to Demo Table ");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']")));

	}

	void getMapOfEmployeeNoDepartment() {
		Map<String, Integer> deprtmentMap = new HashMap<String, Integer>();
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();

		for (int index = 1; index <= size; index++) {

			String EmployeeDepartment = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (deprtmentMap.containsKey(EmployeeDepartment)) {
				int count = deprtmentMap.get(EmployeeDepartment);
				deprtmentMap.put(EmployeeDepartment, count + 1);
			} else {
				deprtmentMap.put(EmployeeDepartment, 1);
			}
		}
		System.out.println("Map of of department name and number of employees working in each department");
		System.out.println(deprtmentMap);
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment_8 as8 = new Assignment_8();
		as8.browserSetUp();
		as8.getMapOfEmployeeNoDepartment();
	}

}
