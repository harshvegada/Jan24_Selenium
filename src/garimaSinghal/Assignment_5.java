package garimaSinghal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5 {
	WebDriver driver;
	void setUp() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		
		System.out.println("STEP - click on Demo Table link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	void testCase1() {
		setUp();
		int noOfRows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		System.out.println("Number of Employees in a table : "+noOfRows);
		
	}
	
	void testCase2() {
		
		String[] arr = {"#","First Name","Last Name","Username"};
		List<String> expectedHeader = new ArrayList<>(Arrays.asList(arr));
		List<WebElement> listOfHeaders=driver.findElements(By.xpath("//table[@class='table']/thead/tr/th"));
		System.out.println("No of Columns in Employee Table : "+listOfHeaders.size());
		int expectedNoOfHeaders=4;
		System.out.println("VERIFY : Match No of Headers with Expected Headers");
		if(expectedNoOfHeaders==listOfHeaders.size()) {
			System.out.println("Test case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		System.out.println("STEP : Get all the Header of table");
	
		List<String> actualHeadersOfList=getConversionWebElementList(listOfHeaders);
		System.out.println(actualHeadersOfList);
		System.out.println("VERIFY : Match Actual Headers and Expected Headers");
		if(expectedHeader.equals(actualHeadersOfList)) {
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		
	}
	
	void testCase3() {

		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		System.out.println("Total No of Usernames : "+listOfElements.size());
		List<String> listOfUsernames=getConversionWebElementList(listOfElements);
		HashSet<String> setOfUsername= new HashSet<String>(listOfUsernames);
		if(listOfUsernames.size()==setOfUsername.size()) {
			System.out.println("VERIFY : Usernames are Unique");
		}else {
			System.out.println("VERIFY : There are some duplicate Usernames");
		}	
	}
	
	void testCase4() {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastName = new ArrayList<>();
		Set<String> setOfDuplicate = new LinkedHashSet<>();
		for(WebElement e:listOfElements) {
			if(listOfLastName.contains(e.getText())) {
				setOfDuplicate.add(e.getText());
			}else {
				listOfLastName.add(e.getText());
			}			
		}
		System.out.println("Unique Last Names from Table : "+listOfLastName);
		System.out.println("Duplicate Last Names from Table : "+setOfDuplicate);
	}
	
	void testCase5() {
		int count=0;
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOflastName=getConversionWebElementList(listOfElements);
		Map<String,Integer> mapOfLastNames=new LinkedHashMap<>();
		System.out.println(listOflastName);
		for(String lastname : listOflastName) {
			if(mapOfLastNames.containsKey(lastname)) {
				count=	mapOfLastNames.get(lastname);
				mapOfLastNames.put(lastname, ++count);
			}else {
				mapOfLastNames.put(lastname, 1);
			}
		}
		System.out.println(mapOfLastNames);
		Set<String> keySet = mapOfLastNames.keySet();
		for (String key : keySet) {
			if(mapOfLastNames.get(key)==1)
			System.out.println("Unique Last Names : "+key);
			else
			System.out.println("Duplicate Last Names : "+key);
		}
	}
	
	void testCase6() {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOflastName=getConversionWebElementList(listOfElements);
		Set<String> setOfDuplicate = new LinkedHashSet<>();
		for(String name:listOflastName) {
			if(!setOfDuplicate.add(name)) {
				System.out.println("VERIFY : Duplicate Last Names in a Table "+name);
			}
		}System.out.println("VERIFY : Unique Last Names in a Table : "+setOfDuplicate);
	}
	
	void testCase7() {
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String,String> map= new LinkedHashMap<String,String>();
		for(int index=1;index<=rowCount;index++) {
			String firstname=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+index+"]/td[2]")).getText();
			String lastname=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+index+"]/td[3]")).getText();
			map.put(firstname, lastname);
		}
		System.out.println("STEP: Get firstname and lastname from table");
		System.out.println(map);
		if(map.get("Priya").equals("Patro")){
			System.out.println("VERIFY : Test passed as Priya lastname is Patro");
		}else {
			System.out.println("VERIFY : Test failed Priya lastname is not Patro");
		}
	}
	
	List<String> getConversionWebElementList(List<WebElement> listOfHeaders){
		List<String> listOfactualHeaders= new ArrayList<String>();
		for(WebElement e:listOfHeaders ) {
			listOfactualHeaders.add(e.getText());
		}
		return listOfactualHeaders;
	}
	
	public static void main(String[] args) {
		Assignment_5 assignment_5=new Assignment_5();
		System.out.println("================TestCase1================");
		assignment_5.testCase1();
		System.out.println("===============TestCase2=================");
		assignment_5.testCase2();
		System.out.println("==============TestCase3==================");
		assignment_5.testCase3();
		System.out.println("==============TestCase4==================");
		assignment_5.testCase4();
		System.out.println("===============TestCase5=================");
		assignment_5.testCase5();
		System.out.println("================TestCase6================");
		assignment_5.testCase6();
		System.out.println("================TestCase7================");
		assignment_5.testCase7();
		assignment_5.driver.quit();
	}
}
