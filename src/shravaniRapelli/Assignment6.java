package shravaniRapelli;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	
	WebDriver driver;
	@SuppressWarnings("deprecation")
	void setUp() {
		driver = new ChromeDriver();
		System.out.println("STEP : Launch the browser");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP : Click on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	//TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
	//output :  asharma
	void testCase1() {
		setUp();
		System.out.println("########Test Case 1########");
		System.out.println("STEP : count how many usernames are there in table");
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int i=1; i<=rowSize; i++) {
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]")).getText();
			String UserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i+ "]/td[4]")).getText();
			if(firstName.equals("Abhishek")) {
				System.out.println(firstName + "'s username is " + UserName);
				if(UserName.equals("asharma")) {
					System.out.println("TestCase Pass");
				}else {
					System.out.println("TestCase fail");
				}
			}
		}
		driver.quit();
	}
	
	//TC2 : print all the rows of Employee Basic Table (using 2 loops).
	void testCase2() {
		setUp();
		System.out.println("########Test Case 2########");
		System.out.println("print all rows of employee table");
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']//tr/td[1]")).size();
		System.out.println("Rows in table : " + totalRow);
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']//tr[1]/th")).size();
		System.out.println("Columns in table : " + totalCol);
		
		for(int i=1; i<=totalRow; i++) {
			for(int j=1; j<=totalCol; j++) {
				System.out.print(driver.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]/td[" + j + "]")).getText() + " ");
			}
			System.out.println("");
		}
		driver.quit();
	}
	
	//TC3 : print all the rows of Employee Basic Table (only one loop on tr).
	void testCase3() {
		setUp();
		System.out.println("########Test Case 3########");
		System.out.println("STEP : find row and column in table");
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Rows in table : " + totalRow);
		for (int i = 1; i<=totalRow; i++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText());
		}
		driver.quit();
	}
	
	//TC4 : print whole table without loop.
	void testCase4() {
		setUp();
		System.out.println("########Test Case 4########");
		System.out.println("STEP : Print whole table");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
		driver.quit();
	}
	List<String> convertIntoString(List<WebElement> element) {
		List<String> tempList = new ArrayList<String>();
		for (WebElement e : element) {
			tempList.add(e.getText());
		}
		return tempList;
	}
	//find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	//output : 76585 is duplicate employee id
    //unique employee ids are 8.
	void testCase5() {
		setUp();
		System.out.println("########Test Case 5########");
		System.out.println("find duplicate id from employee manager table");
		Set<String> empSet = new HashSet<String>();

		List<WebElement> tableList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		int row = tableList.size();
		List<String> stringList = convertIntoString(tableList);

		System.out.println("STEP: verify duplicate id");
		for (String id : stringList) {
			if (!empSet.add(id)) {
				System.out.println("Duplicates id are->" + id);
			}
		}
		System.out.println("unique employee id's are -> " + empSet.size());
		driver.quit();
	}
	
	public static void main(String[] args) {
		Assignment6 assgn6 = new Assignment6();
		assgn6.setUp();
		assgn6.testCase1();
		assgn6.testCase2();
		assgn6.testCase3();
		assgn6.testCase4();
		assgn6.testCase5();
	}

}
