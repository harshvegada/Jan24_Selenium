package sasmitaSahu;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment9 {

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
		LinkedHashMap<String, String> managercountmap = new LinkedHashMap<String, String>();
		int totalRows = driver.findElements(By.xpath("//table[@class= 'table table-striped']/tbody/tr")).size();
		System.out.println(totalRows);
		for (int rowindex = 1; rowindex <= totalRows; rowindex++) {
			String managerID = driver
					.findElement(By.xpath("//table[@class= 'table table-striped']/tbody/tr[" + rowindex + "]/td[4]"))
					.getText();
			String EmployeeName = driver
					.findElement(By.xpath("//table[@class= 'table table-striped']/tbody/tr[" + rowindex + "]/td[3]"))
					.getText();

			if (managercountmap.containsKey(managerID)) {
				String temp = managercountmap.get(managerID) + "," + EmployeeName;
				managercountmap.put(managerID, temp);
			} else {
				managercountmap.put(managerID, EmployeeName);
			}
		}
		Set<String> managerid = managercountmap.keySet();
		for (String currentmngName : managerid) {
			String employeelist = managercountmap.get(currentmngName);
			System.out.println(currentmngName + "->" + employeelist.split(",").length + ":" + employeelist);

		}
	}

	public static void main(String[] args) {
		Assignment9 assignment9 = new Assignment9();
		assignment9.mapOfDepartment();

	}

}
