/*
 Return the map of ManagerId and number of employees reporting .
Hint : Map<String, Integer>
output : [{20209=3}, {20205=2=4}, {10101=2}]
ManagerId 20205 having maximum mentees.
 */
package akshayGaikwad;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
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
	
	Map<String,Integer> getMapMangIDNumOfEmp(){
		Map<String,Integer> map = new LinkedHashMap<>();
		System.out.println("STEP : Get numbers of employees Per ManagerID");
		int count = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[3]")).size();
		for(int index = 1; index <= count; index++) {
			String depName = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[4]")).getText();
			if(map.containsKey(depName)) {
				map.put(depName,(map.get(depName))+1);
			}else {
				map.put(depName,1);
			}
		}
		maxCountFromMap(map); 
		return map;
	}
	
	void maxCountFromMap(Map<String,Integer> map) {
		Set<String> set = map.keySet();
		System.out.println("STEP : Get EmployeeID having maximum mentees");
		int maxCount = 0;
		String maxEmp = "";
		for(String name: set) {
			if(maxCount<map.get(name)) {
				maxCount = map.get(name);
				maxEmp = name;
			}
		}
		System.out.println("VERIFY : ManagerID "+maxEmp+" is having maximun mentees");
	}
	
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	public static void main(String[] args) {
		Assignment8 obj = new Assignment8();
		obj.setup();
		System.out.println(obj.getMapMangIDNumOfEmp());
		obj.closeBrowser();
	}
	
}
