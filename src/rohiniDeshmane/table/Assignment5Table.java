package rohiniDeshmane.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5Table {

	WebDriver driver;
	
	void openBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on Basic element tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
	}
	
	//TC1 : In table 1, how many employees are there. 
	void validateNumberOfEmp() {
		int expectedCount = 5;
		System.out.println("STEP : Get Number of Element");
		List<WebElement> webElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("VERIFY : Number of element with expected Count");
		if(expectedCount == webElement.size()) {
			System.out.println("Expected count and actual count = "+webElement.size()+"\nTest Case 1 : Passed \n");
		}
		
	}
	
	ArrayList<String> webElementToTextList(List<WebElement> webElement) {
		ArrayList<String> textList = new ArrayList<String>();
		for(int i=0; i<webElement.size(); i++) {
			textList.add(webElement.get(i).getText());
		}
		return textList;
	}
	
	//TC2 : In table1, how many column are there and print all headers of each column [compare list to list].
	void validateColums() {
		String arr[] = {"#", "FirstName", "LastName", "UserName"};
		List<String> actualList = new ArrayList<String>(Arrays.asList(arr));
		
		System.out.println("STEP : Get Coloum details");
		List<WebElement> webElement = driver.findElements(By.xpath("//table[@id='table1']/thead/tr"));
		
		System.out.println("STEP : Convert web element to text list");
		ArrayList<String> expectedList = webElementToTextList(webElement);
		
		System.out.println("VERIFY : actual list with expected list");
		if(actualList.equals(expectedList)) {
			System.out.println("Test case 2 : Passed \n");
		}
		
	}
	
	//TC3 : Find of total username in table1, verify each  username is unique. Print all usernames. 
	void validateUniqueUsername() {
		String arr[] = {"mkanani","kkanani","dboda","asharma","ppatro"};
		List<String> actualList = new ArrayList<String>(Arrays.asList(arr));
		
		System.out.println("STEP : Get Coloum details");
		List<WebElement> userNameWebElementList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
	
		System.out.println("STEP : Convert web element to text list");
		List<String> listOfElementText = webElementToTextList(userNameWebElementList);	
		
		System.out.println(actualList +"\n"+listOfElementText);
		System.out.println("VERIFY : actual list with expected list");
		if(actualList.equals(listOfElementText)) {
			System.out.println("Test case 3 : Passed \n");
		}
	}
	
	//TC4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
	void validateSurnamePrintDuplicate() {
		List<String> list = new ArrayList<>();
		LinkedHashSet<String> duplicateNameSet = new LinkedHashSet<>();
		
		System.out.println("STEP : Get total row count");
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.println("VERIFY : duplicate last name");
		for(int i=1; i<=rowSize; i++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
			if(list.contains(lastName))
				duplicateNameSet.add(lastName);
			else
				list.add(lastName);
		}
		System.out.println("Duplicate last name = "+duplicateNameSet);
		System.out.println("Test case 4 : Passed \n");
	}
	
	
	//TC5 : Print all the unique surnames and print duplicate surnames if any using Map. 
	void validateSurnameDuplicateMap() {
		Map<String, Integer> duplicateSurnames = new HashMap<>();
		System.out.println("STEP : Get total row count");
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.println("VERIFY : duplicate last name");
		for(int i=1; i<=rowSize; i++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
			if(!duplicateSurnames.containsKey(surName))
				duplicateSurnames.put(surName, 1);
			else
				duplicateSurnames.put(surName, duplicateSurnames.get(surName)+1);
		}
		
		Set<String> hs = duplicateSurnames.keySet();
		for(String key : hs) {
			if(duplicateSurnames.get(key)>1)
				System.out.println("Duplicate surname = "+key);
		}
		
		System.out.println("Test Case 5 : Passed \n");
	}
	
	//TC6 : Print all the unique surnames and print duplicate surnames if any using Set. 
	void validateSurnameDuplicateSet() {
		LinkedHashSet<String> duplicateNameSet = new LinkedHashSet<>();
		
		System.out.println("STEP : Get total row count");
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.println("VERIFY : duplicate last name");
		for(int i=1; i<=rowSize; i++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
			if(!duplicateNameSet.add(lastName))
				System.out.println("Duplicate last name = "+lastName);
		}
		
		System.out.println("Test case 6 : Passed \n");
	}
	
	//TC7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of the employee should be Patro whoes firstname is Priya.
	void validateFirstLastNameWithMap() {
		Map<String, String> duplicateSurnames = new HashMap<>();
		System.out.println("STEP : Get total row count");
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		System.out.println("STEP : Get first name and last name values");
		for(int i=1; i<=rowSize; i++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[2]")).getText();
			duplicateSurnames.put(firstName, surName);
		}
		System.out.println("VERIFY : the lastname of the employee whoes firstname is Priya");
		System.out.println(duplicateSurnames.get("Priya"));
		System.out.println("Test Case 7 : Passed");
	}
	
	public static void main(String[] args) {
		Assignment5Table assignment5Table = new Assignment5Table();
		assignment5Table.openBrowser();
		assignment5Table.validateNumberOfEmp();
		assignment5Table.validateColums();
		assignment5Table.validateUniqueUsername();
		assignment5Table.validateSurnamePrintDuplicate();
		assignment5Table.validateSurnameDuplicateMap();
		assignment5Table.validateSurnameDuplicateSet();
		assignment5Table.validateFirstLastNameWithMap();
	}
}
