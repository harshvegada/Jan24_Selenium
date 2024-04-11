package shravaniRapelli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	WebDriver driver;
	@SuppressWarnings("deprecation")
	void setUp(){
		driver = new ChromeDriver();
		System.out.println("STEP: launch browser");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP : Click on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	// In table 1, how many employees are there. Answer : 5
	void testCase1() {
		setUp();
		int empCnt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println(empCnt);
		driver.quit();
	}
	
	//In table1, how many column are there and print all headers of each column [compare list to list].Answer : 4
	void testCase2() {
		setUp();
		List<WebElement> listOfHeaders = driver.findElements(By.xpath("//table[@class='table']/thead/tr/th"));
		System.out.println("number of columns in employee table " + listOfHeaders.size());
		System.out.println("VERIFY : Size of header list is correct");
		if(listOfHeaders.size()==4) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}
		
		String actualHeader="";
		for(WebElement e : listOfHeaders) {
			actualHeader += e.getText()+ " ";
		}
		actualHeader = actualHeader.trim();
		System.out.println(actualHeader);
		String expectedHeader = "# First Name Last Name Username";
		if(actualHeader.equals(expectedHeader)) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}
		driver.quit();
	}
	
	List<String> convertIntoTextList(List<WebElement> userNameList){
		List<String> listOfWebElements = new ArrayList<String>();
		for(WebElement ele : userNameList) {
			listOfWebElements.add(ele.getText());
		}
		return listOfWebElements;
	}
	
	//TC3 : Find of total username in table1, verify each  username is unique. Print all usernames. 
	void testCase3() {
		setUp();
		System.out.println("STEP : To check how many usernames are there in the table");
		List<WebElement> listOfUName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		System.out.println("Number of User Names : " + listOfUName.size());
		System.out.println("VERIFY : The number of usernames are same in the table");
		if(listOfUName.size()== 5 ) {
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase Fail");
		}
		
		List<String> userNameTextList = convertIntoTextList(listOfUName);
		Set<String> userNameSet = new HashSet<String>(userNameTextList);
		System.out.println("Unique user names are " + userNameSet);
		driver.quit();
	}
	
	//Print all the unique surnames and print duplicate surnames if any using List+Set. 
	void testCase4() {
		setUp();
		List<WebElement> surnameList= driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		 List<String>lastnameList=new ArrayList<>();
		 Set<String>duplicateSet= new LinkedHashSet<>();

		 for(WebElement e:surnameList) {
			 if(lastnameList.contains(e.getText())) {
				 duplicateSet.add(e.getText());
			 }else {
				 lastnameList.add(e.getText());
			 }
		 }
		 System.out.println("UniQue Surname are: "+lastnameList);
		 System.out.println("Duplicate Surname are: "+duplicateSet);
		 driver.quit();
	}
	
	//TC5 : Print all the unique surnames and print duplicate surnames if any using Map. 
	void testCase5() {
		setUp();
		List<WebElement> webList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		List<String> lastnameList = convertIntoTextList(webList);
		Map<String, Integer> surnameMap = new HashMap<String, Integer>();

		for (String lastName : lastnameList) {
			if (surnameMap.containsKey(lastName)) {
				int count = surnameMap.get(lastName);
				surnameMap.put(lastName, count + 1);
			} else {
				surnameMap.put(lastName, 1);
			}
			Set<String> keyset = surnameMap.keySet();
			for (String key : keyset) {
				int num = surnameMap.get(key);
				if (num == 1) {
					System.out.println("Unique surName : " + key);
				} else {
					System.out.println("Duplicate surName : " + key);
				}
			}
		}
		driver.quit();
	}
	
	//TC6 : Print all the unique surnames and print duplicate surnames if any using Set.
	void testCase6() {
		setUp();
		List<WebElement>webList=driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		List<String>lastnameList=convertIntoTextList(webList);
		Set<String> surnameSet=new HashSet<String>();

		for(String lastName:lastnameList) {
			if(!surnameSet.add(lastName)) {
				System.out.println("Duplicates Surname are: "+lastName);
			}else {
				System.out.println("Unique Surname are: "+lastName);
			}
		}
		driver.quit();
	}
	
	// TC7 : Return firstname and lastname of each employee in Map<String, String>,in main method verify
		//the lastname of the employee should be Patro whoesfirstname is Priya.
		void testCase7() {
			setUp();
			int rowCount= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
			Map<String, String> fullnameMap=new LinkedHashMap<String, String>();

			for(int index=1; index<=rowCount; index++) {
				String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
				String lastName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
				fullnameMap.put(firstName, lastName);
			}
			String key=fullnameMap.get("Priya");
			if(key.equals("Patro")) {
				System.out.println("Test passed as priya's lastName is Patro");
			}else {
				System.out.println("Test failed as priya's lastName is Patro");
			}driver.quit();
		}

	public static void main(String[] args) {
		Assignment5 assgn5 = new Assignment5();
		assgn5.setUp();
		assgn5.testCase1();
		assgn5.testCase2();
		assgn5.testCase3();
		assgn5.testCase4();
		assgn5.testCase5();
		assgn5.testCase6();
		assgn5.testCase7();
		
	}
}
