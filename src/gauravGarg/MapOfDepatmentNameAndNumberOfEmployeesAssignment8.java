package gauravGarg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MapOfDepatmentNameAndNumberOfEmployeesAssignment8 {

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
		Map<String, Integer> map = new HashMap<String, Integer>();
		System.out.println("Step 4-: Create on Map of String and Inetger ");
		for (int i = 1; i <= size; i++) {
			String EmployeeId = wb
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			if (!map.containsKey(EmployeeId)) {
				map.put(EmployeeId, 1);
			} else {
				int count = map.get(EmployeeId);
				map.put(EmployeeId, count + 1);
			}
		}
		System.out.println(
				"Step 4-: Load the data of map with string EmployeeId and count of EmployeeId ");
		System.out.println(map);
		Set<String> key=map.keySet();
		Iterator<String> i=key.iterator();
		int count=0;
		String found="";
		while(i.hasNext())
		{
			String value = i.next();
			int actual=map.get(value);
			
			if(count<=actual)
			{
				count=actual;
				found= value;
			}
		}
		System.out.println("ManagerId  with  having maximum count ."+found +"and"+ +count);
		wb.quit();
	}

	public static void main(String[] args) {
		new MapOfDepatmentNameAndNumberOfEmployeesAssignment8().testCase1();
	
	}
}
