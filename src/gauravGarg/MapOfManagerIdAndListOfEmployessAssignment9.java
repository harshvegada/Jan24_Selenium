package gauravGarg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapOfManagerIdAndListOfEmployessAssignment9 {

	WebDriver wb;

	void loadBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step 2-: Click on Demo Table tab ");
		wb.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	}

	void testCase1() {
		System.out.println("Test Case 1");
		loadBrowser();
		int size = wb.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		System.out.println("Step 3-: Click on Employer Manager and calculate size of row ");
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		System.out.println("Step 4-: Create on Map of String and Inetger ");
		for (int i = 1; i <= size; i++) {
			String EmployeeId = wb
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			String name = wb
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]")).getText();
			if (!map.containsKey(EmployeeId)) {
				List<String> ls=new ArrayList<String>();
				ls.add(name);
				map.put(EmployeeId, ls);
			} else {
				List<String> ls= map.get(EmployeeId);
				ls.add(name);
				map.put(EmployeeId, ls);
			}
		}
		System.out.println(
				"Step 4-: Load the data of map with string EmployeeId and map of name with EmployeeId");
		System.out.println(map);
		wb.quit();
	}
	public static void main(String[] args) {
		new MapOfManagerIdAndListOfEmployessAssignment9().testCase1();
	}
}
