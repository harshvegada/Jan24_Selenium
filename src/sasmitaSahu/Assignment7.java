package sasmitaSahu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	WebDriver driver;

	void load() {
		System.out.println("STEP1-Launch the ChromeBowser");
		driver = new ChromeDriver();

		System.out.println("STEP2-Maximise the ChromeBowser");
		driver.manage().window().maximize();

		System.out.println("STEP3-hit the url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP4-Click on Demo tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void mapOfDepartment() {
		load();

		System.out.println("STEP5-Found the size of the employee table");
		Map<String, Integer> mapOfEmployee = new LinkedHashMap<String, Integer>();

		int sizeOfDept = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		System.out.println("Total size of dept :" + sizeOfDept);

		for (int i = 1; i <= sizeOfDept; i++) {
			WebElement e = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]"));
			String department = e.getText();

			if (mapOfEmployee.containsKey(department)) {
				int count = mapOfEmployee.get(department);
				mapOfEmployee.put(department, count + 1);
			} else
				mapOfEmployee.put(department, 1);

		}
		System.out.println("STEP6-print the map of employee");
		System.out.println(mapOfEmployee);
		System.out.println("Testcase pass");
	}

	public static void main(String[] args) {
		Assignment7 assignment7 = new Assignment7();
		assignment7.mapOfDepartment();

	}

}
