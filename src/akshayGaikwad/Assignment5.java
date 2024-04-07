package akshayGaikwad;
/*C1 : In table 1, how many employees are there. 
Answer : 5


TC2 : In table1, how many column are there and print all headers of each column [compare list to list].
Answer : 4
----------------------------------------------------------
TC3 : Find of total username in table1, verify each  username is unique. Print all usernames. 
---------------------------------------------
TC4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
TC5 : Print all the unique surnames and print duplicate surnames if any using Map. 
TC6 : Print all the unique surnames and print duplicate surnames if any using Set. 
TC7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of the employee should be Patro whoes firstname is Priya.
*/

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	WebDriver driver;

	void setup() {
		System.out.println("STEP : Launch browser and hit automationbykrishna");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}

	void getNumberOfEmploy() {
		List<WebElement> listOfEmp = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("VERIFY : Number of employees in table are " + listOfEmp.size());
	}

	void printHeaderNames() {
		String[] arr = {"#","First Name","Last Name","Username"};
		List<String> expectedHeader = new ArrayList<>(Arrays.asList(arr));
		
		System.out.println("STEP : Get all header names");
		List<WebElement> listOfFeilds = driver.findElements(By.xpath("//table[@id='table1']//th"));
		System.out.println("VERIFY : Number of colums in table are " + listOfFeilds.size());

		System.out.println("STEP : Print header names");
		System.out.print("VERIFY : Names of header as follow : ");
		List<String> currentHeader = new ArrayList<String>();
		for (WebElement we : listOfFeilds) {
			System.out.print(we.getText() + ", ");
			currentHeader.add(we.getText());
		}
		System.out.println();
		
		if(currentHeader.equals(expectedHeader)) {
			System.out.println("VERIFY : Test Passed as Header names are as expected");
		}else {
			System.out.println("VERIFY : Test Failed as Header names are noy as expected");
		}
	}
	
	void getUserNames() {
		List<WebElement> listOfUsername = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		Set<WebElement> setOfUserName = new HashSet<>(listOfUsername);
		if(listOfUsername.size() == setOfUserName.size()) {
			System.out.println("VERIFY : Test passed as All usernames are unique");
		}else {
			System.out.println("VERIFY : Test failed as Some usernames are duplicate");
		}
	}
	
	Map<String,String> getNameSurname(){
		System.out.println("STEP : Get list of First names");
		List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		
		System.out.println("STEP : Get list of Last names");
		List<WebElement> listOfSurnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		
		Map<String,String> mapOfFullName = new LinkedHashMap<>();
		
		for(int index = 0; index < listOfNames.size();index++) {
			mapOfFullName.put(listOfNames.get(index).getText(), listOfSurnames.get(index).getText());
		}
		
		return mapOfFullName;
	}
	
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	void printUniqueLastNameListSet() {
		System.out.println("STEP : Get list of Surnames");
		List<WebElement> listOfLastNameEle = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastName = new ArrayList<>();
		Set<String> setOfDuplicate = new LinkedHashSet<>();
		for(WebElement we : listOfLastNameEle) {
			if(listOfLastName.contains(we.getText())) {
				setOfDuplicate.add(we.getText());
			}else {
				listOfLastName.add(we.getText());
			}
		}
		System.out.println("VERIFY : Duplicate entries from table are " + setOfDuplicate);
		System.out.println("VERIFY : Unique surnames from table are " + listOfLastName);
	}
	
	void printUniqueLastNameMap() {
		System.out.println("STEP : Get List of Surnames");
		List<String> listOfName = new ArrayList<>();
		int count = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]")).size();
		for(int index = 1; index <= count; index++) {
			listOfName.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText());
		}
		Map<String,Integer> map = new HashMap<>();
		for(String name : listOfName) {
			if(map.containsKey(name)) {
				int count1 = map.get(name);
				map.put(name, ++count1);
			}else {
				map.put(name, 1);
			}
		}
		List<String> duplicateSurname = new ArrayList<>();
		List<String> uniqueSurname = new ArrayList<>();
		Set<String> setOfKeys = map.keySet();
		for(String key: setOfKeys) {
			if(map.get(key) > 1) {
				duplicateSurname.add(key);
			}else {
				uniqueSurname.add(key);
			}
		}
		System.out.println("VERIFY : Duplicate surnames are :" + duplicateSurname);
		System.out.println("VERIFY : Unique surnames are :" + uniqueSurname);
	}
	
	void printUniqueLastNameSet(){
		System.out.println("STEP : Get List of Surnames");
		List<String> listOfName = new ArrayList<>();
		int count = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]")).size();
		for(int index = 1; index <= count; index++) {
			listOfName.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText());
		}
		
		Set<String> setOfSurnames = new LinkedHashSet<>();
		System.out.print("VERIFY : Duplicate entries of surname are  : ");
		for(String name : listOfName) {
			if(!setOfSurnames.add(name)) {
				System.out.print(name + ", ");
			}
		}
		System.out.println();
		System.out.println("VERIFY : Unique surnames are " + setOfSurnames);
	}
		
	public static void main(String[] args) {
		Assignment5 obj = new Assignment5();
		obj.setup();
		System.out.println("---------------------------------");
		obj.getNumberOfEmploy();
		System.out.println("---------------------------------");
		obj.printHeaderNames();
		System.out.println("---------------------------------");
		obj.getUserNames();
		System.out.println("---------------------------------");
		Map<String,String> map = obj.getNameSurname();
		System.out.println(map);
		if(map.get("Priya").equals("Patro")){
			System.out.println("VERIFY : Test passed as Priya lastname is Patro");
		}else {
			System.out.println("VERIFY : Test failed Priya lastname is not Patro");
		}
		System.out.println("---------------------------------");
		obj.printUniqueLastNameListSet();
		System.out.println("---------------------------------");
		obj.printUniqueLastNameSet();
		System.out.println("---------------------------------");
		obj.printUniqueLastNameMap();
		System.out.println("---------------------------------");
		obj.closeBrowser();
	}
}
