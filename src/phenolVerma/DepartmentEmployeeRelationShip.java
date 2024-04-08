package phenolVerma;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DepartmentEmployeeRelationShip {

    WebDriver driver;

    void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        System.out.println("Opening URL");
        driver.get("http://automationbykrishna.com");
    }

    void getFreqOfDepartmentEmployee() throws InterruptedException {
        openBrowser();

        // Clicking on Demo Tables tab
        driver.findElement(By.id("demotable")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        System.out.print("Getting table lenght - ");
		int tablelength = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		System.out.println(tablelength);

		System.out.println("Creating Map to store Department and Employee number");
        Map<String, List<String>> departmentEmployeeMap = new LinkedHashMap<String, List<String>>();
        
        for (int index = 1; index <= tablelength; index++) {
        	
			String department = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[5]")).getText();
			String emploeeName = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[" + index + "]/td[3]")).getText();
            
            if (departmentEmployeeMap.containsKey(department)) {
                departmentEmployeeMap.get(department).add(emploeeName);
            } else {
                List<String> employees = new ArrayList<>();
                employees.add(emploeeName);
                departmentEmployeeMap.put(department, employees);
            }
        }
        
        System.out.println("Department Name  |  Employee Name");
        for (Map.Entry<String, List<String>> entry : departmentEmployeeMap.entrySet()) {
           System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        // Close the WebDriver
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        DepartmentEmployeeRelationShip departmentEmployeeRelationShip = new DepartmentEmployeeRelationShip();
        departmentEmployeeRelationShip.getFreqOfDepartmentEmployee();
    }
}
