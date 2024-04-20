package ashwiniBalki;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 /*
Assignment 6 - 8th April'2024
TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
output :  asharma
TC2 : print all the rows of Employee Basic Table (using 2 loops).
TC3 : print all the rows of Employee Basic Table (only one loop on tr).
Hint : getText -> //table[@id='table1']/tbody/tr[1] 
TC4 : print whole table without loop.
TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.
output : 76585 is duplicate employee id
         unique employee ids are 8.
 */
public class Assignment_6 {
	WebDriver driver;

	void setupLaunchBrowser() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP - click on Demo Table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void tc1() {
		System.out.println(
				"TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.");
		List<WebElement> empCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int count = empCount.size();
		System.out.println("Employee: " + count);

		for (int index = 1; index <= empCount.size(); index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (firstName.equals("Abhishek")) {
				System.out.println(firstName + "'s username is " + userName);
				if (userName.equals("asharma")) {
					System.out.println("Test case Pass");
				} else {
					System.out.println("Test case fail");
				}
			}
		}
	}
	
	void tc2() {
		System.out.println("TC2 : print all the rows of Employee Basic Table (using 2 loops)");
		int rowsize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Number of rows for table: " + rowsize);
		
		int columnsize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		System.out.println("Number of rows for table: "+ columnsize);
		
		System.out.println("Print the table ");
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				String tdtext = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "] "))
						.getText();
				System.out.print(tdtext + " ");
			}
			System.out.println();
		}
	}
	
	// print all the rows of Employee Basic Table (only one loop on tr).
	void tc3() {
		System.out.println("TC3: print all the rows of Employee Basic Table (only one loop on tr).");
		int rowsize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Number of rows for table: " + rowsize);
		for (int i = 1; i <= rowsize; i++) {

			String trtext = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]")).getText();
			System.out.println(trtext);
		}
	}
	
	// print whole table without loop.
	void tc4() {
		System.out.println("TC4 : print whole table without loop.");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText());
	}
	
	// find the duplicate employee id from EMPLOYEE MANAGER table, if any.
	void tc5() {
		System.out.println("TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any.");
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")).size();
		List<Integer> lstOfId = new ArrayList<Integer>();
		System.out.println("Print duplicate element");
		for (int i = 1; i <= size; i++) {
			String name = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[2]")).getText();
			if (!lstOfId.contains(Integer.valueOf(name))) {
				lstOfId.add(Integer.valueOf(name));
			} else {
				System.out.println(name);
			}
		}
		System.out.println("Unique Employee id count: " + lstOfId.size());
		
	}
	
	public static void main(String[] args) {
		Assignment_6 assignment_6 = new Assignment_6();
		assignment_6.setupLaunchBrowser();
		System.out.println("--------------------");
		assignment_6.tc1();
		System.out.println("--------------------");
		assignment_6.tc2();
		System.out.println("--------------------");
		assignment_6.tc3();
		System.out.println("--------------------");
		assignment_6.tc4();
		System.out.println("--------------------");
		assignment_6.tc5();
		System.out.println("--------------------");
		assignment_6.driver.quit();
		
	}

}
