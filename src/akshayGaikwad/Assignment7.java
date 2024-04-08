/*
Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{7001-Admin=2}, {7002-Finance=2}, {7013-IT=3}]
 */
package akshayGaikwad;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	WebDriver driver;
	
	void setup() {
		System.out.println("STEP : Launch Browser and hit automationbykrishna");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP : Got to Demo table tab on page");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	Map<String,Integer> getNumOfEmpFromDep(){
		System.out.println("STEP : Get list of Department");
		List<WebElement> listOfDep = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		Map<String,Integer> mapOfEmp = new LinkedHashMap<>();
		
		System.out.println("STEP : Get the map of Department and number of employees");
		for(WebElement we : listOfDep) {
			String name = we.getText();
			if(mapOfEmp.containsKey(name)) {
				int count = mapOfEmp.get(name);
				mapOfEmp.put(name, ++count);
			}else {
				mapOfEmp.put(name,1);
			}
		}
		return mapOfEmp;
	}
	
	List<String> getStringList(List<WebElement> input){
		List<String> output = new ArrayList<>();
		for(WebElement we : input) {
			output.add(we.getText());
		}
		return output;
	}
	
	Map<String,List<String>> getEmplPerDep(){
		Map<String,List<String>> mapOfDepEmp = new LinkedHashMap<>();
		
		System.out.println("STEP : Get list of Department");
		List<String> listOfDep = getStringList(driver.findElements(By.xpath("//div[@id='empmanager']//tbody//td[5]")));
		
		System.out.println("STEP : Get list of Employees");
		List<String> listOfEmp = getStringList(driver.findElements(By.xpath("//div[@id='empmanager']//tbody//td[3]")));
		
		System.out.println("STEP : Get the map of Department and name of employees");
		int count = listOfDep.size();
		for(int index = 1; index <= count; index++) {
			String name = listOfDep.get(index-1);
			if(mapOfDepEmp.containsKey(name)) {
				List<String> list = mapOfDepEmp.get(name);
				list.add(listOfEmp.get(index-1));
				mapOfDepEmp.put(name,list);
			}else {
				List<String> list = new ArrayList<>();
				list.add(listOfEmp.get(index-1));
				mapOfDepEmp.put(name,list);
			}
		}
		return mapOfDepEmp;
	}
	
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	public static void main(String[] args) {
		Assignment7 obj = new Assignment7();
		obj.setup();
		System.out.println("----------------------------------------------------");
		System.out.println(obj.getNumOfEmpFromDep());
		System.out.println("----------------------------------------------------");
		System.out.println(obj.getEmplPerDep());
		System.out.println("----------------------------------------------------");
		obj.closeBrowser();
	}
}
