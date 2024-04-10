/*Print Manager Id, number of reportees in each managerId, employee name under each manager as below.

20209 -> 3 -> Abhijit Mane, Sumit Kulkarni, Pawan Belamkar
*/
package akshayGaikwad;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment9 {
	WebDriver driver;
	
	void setup() {
		System.out.println("STEP : Launch Browser and hit automationbykrishna");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		System.out.println("STEP : Got to Demo table tab on page");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	Map<String,List<String>> getMapMangIDNameRepotee(){
		System.out.println("STEP : Get count of employees");
		int count = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]")).size();
		Map<String,List<String>> map = new LinkedHashMap<>();
		System.out.println("STEP : Get map of manager ID and Employees");
		for(int index = 1 ; index <= count; index++) {
			String mangID = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[4]")).getText();
			String empName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[3]")).getText();
			if(map.containsKey(mangID)) {
				List<String> list = map.get(mangID);
				list.add(empName);
				map.put(mangID, list);
			}else {
				List<String> list = new ArrayList<String>();
				list.add(empName);
				map.put(mangID, list);
			}
		}
		System.out.println("STEP : Print Manager ID and Employees reporting");
		Set<String> set = map.keySet();
		for(String name : set) {
			System.out.println(name + " -> " + map.get(name).size() + " -> " + map.get(name));
		}
		
		return map;
	}
	
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	public static void main(String[] args) {
		Assignment9 obj = new Assignment9();
		obj.setup();
		obj.getMapMangIDNameRepotee();
		obj.closeBrowser();
	}
		
}
