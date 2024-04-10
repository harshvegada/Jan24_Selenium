/*Return the map of department name and number of employees working in each department.
Hint : Map<String, Integer>
output : [{20209=3}, {20205=2=4}, {10101=2}]
ManagerId 20205 having maximum mentees. 
 */

package sasmitaSahu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
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
		Map<String, Integer> mngmap = new HashMap<String, Integer>();
		int totalRows=driver.findElements(By.xpath("//table[@class= 'table table-striped']/tbody/tr")).size();
         System.out.println(totalRows);
         for(int rowindex=1; rowindex<=totalRows; rowindex++) {
        	 String managerID= driver.findElement(By.xpath("//table[@class= 'table table-striped']/tbody/tr["+rowindex+"]/td[4]")).getText();
        	
        	 if(mngmap.containsKey(managerID)) {
        		 int count=mngmap.get(managerID)+1;
        		 mngmap.put(managerID, count);
        		 
        	 }else { 
        		 mngmap.put(managerID,1);
        	 }
        	
         }
         System.out.println("STEP5-Mnager ids and no of employee working in each manager");
    	 System.out.println(mngmap);
        		int maxcount=0;
        		String output="";
        		Set<String> keySet =mngmap.keySet();
        		for(String key:keySet)
        			if(maxcount<mngmap.get(key)) {
        				maxcount=mngmap.get(key);
        				output=key;
        			}
        		System.out.println("Managerid " +output +" having maximum mentor");
        			
        			}
        	 
         



	public static void main(String[] args) {
		Assignment8 assignment8 = new Assignment8();
		assignment8.mapOfDepartment();

	}

}
