package rohiniDeshmane.table;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

WebDriver driver;
	
	void openBrowser() {
		System.out.println("STEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on Basic element tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
	}
	
	//TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
	//output :  asharma
	void printUsernameWithCondition() {
		System.out.println("STEP : Get first names");
		List<WebElement> firstNameWE = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		
		System.out.println("STEP : Compare first name with first name asAbhishek");
		for(int i=0; i< firstNameWE.size(); i++) {
			String firstName = firstNameWE.get(i).toString();
			if(firstName.equals("Abhishek")) {
				System.out.println("VERIFY : first name and print last name");
				System.out.println("Last name = "+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+(++i)+"]/td["+(++i)+"]")));
			}
		}
		System.out.println("Test Case 1 : Passed \n");
	}
	
	//TC2 : print all the rows of Employee Basic Table (using 2 loops).
	void printAllRowsOfTableWithLoop() {
		System.out.println("STEP : Get total row count");
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th")).size();
		
		System.out.println("STEP : Print all rows of employee table");
		for(int rowIndex=1;rowIndex<=5;rowIndex++){
			for(int colIndex=1;colIndex<=totalCol;colIndex++){
				System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText() + " ");
			}
			System.out.println("");
		}
		System.out.println("Test Case 2 : Passed \n");
	}
	
	//TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	void printAllRowsOfTableWithOneLoop() {
		System.out.println("STEP : Print all details");
		for(int i=1; i<= 5; i++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]")).getText());
		}
		System.out.println("Test Case 3 : Passed \n");
	}
	
	//TC4 : print whole table without loop.
	void printTableWithoutLoop() {
		System.out.println("STEP : Print Table data");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
		System.out.println("Test Case 4 : Passed \n");
	}
	
	//TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	//output : 76585 is duplicate employee id
    //unique employee ids are 8.
	void printDuplicateEmpId() {
		System.out.println("STEP : Get size of rows");
		int size = driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
		int uniqueCount = 0;
		
		HashMap<Integer, Integer> empDetails = new HashMap<>();
		System.out.println("STEP : Find duplicates and print");
		
		for(int i=1; i<size; i++) {
			int value = Integer.parseInt(driver.findElement(By.xpath("//div[@id='empmanager']//tbody//tr["+i+"]//td[2]")).getText());
			if(empDetails.containsKey(value)) {
				empDetails.put(value, empDetails.get(value)+1);
				System.out.println(value+" is duplicate Employee id");
			} else {
				empDetails.put(value,1);
				uniqueCount++;
			}	
		}
		System.out.println("Unique employee id is = "+uniqueCount);
		System.out.println("Test Case 5 : Passed");
	}
	
	public static void main(String[] args) {
		Assignment6 assignment = new Assignment6();
		assignment.openBrowser();
		assignment.printUsernameWithCondition();
		assignment.printAllRowsOfTableWithLoop();
		assignment.printAllRowsOfTableWithOneLoop();
		assignment.printTableWithoutLoop();
		assignment.printDuplicateEmpId();
		
	}
}
