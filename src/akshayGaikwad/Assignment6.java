/*
 Assignment 6 - 8th April'2024

TC1 : print the username of the employee whoes first name is Abhishek, considering rows are dynamic.
TC2 : print all the rows of Employee Basic Table (using 2 loops).
TC3 : print all the rows of Employee Basic Table (only one loop on tr).
TC4 : print whole table without loop.
TC5 : find the duplicate employee id from EMPLOYEE MANAGER table, if any..
 */
package akshayGaikwad;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	WebDriver driver;
	
	void setup() {
		System.out.println("STEP : Launch Browser and hit automationbykrishna");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("STEP : Got to Demo table tab on page");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}
	
	void printUsernameFromName(String FirstName) {
		
		System.out.println("STEP : Get list of Names");
		List<WebElement> listOfName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		int count = listOfName.size();
		for(int index = 0; index < count;index++) {
			String name = listOfName.get(index).getText();
			if(name.equals(FirstName)) {
				System.out.println("VERIFY : Username of "+FirstName+" is "+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+(index+1)+"]/td[4]")).getText());
			}
		}
	}
	
	void closeBrowser() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}
	
	void printTableLoops() {
		System.out.println("STEP : Print Table using 2 loops");

		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		
		for(int index = 1; index <= colCount; index++) {
			String header = driver.findElement(By.xpath("//table[@id='table1']//th["+index+"]")).getText();
			System.out.print(header + "   ");
		}
		System.out.println();
		
		for(int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			for(int colIndex = 1; colIndex<=colCount; colIndex++) {
				String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText();
				System.out.print(text + "  ");
			}
			System.out.println();
		}		
	}
	
	void printTableOneLoop() {
		System.out.println("STEP : Print Table using 1 loop");

		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]")).size();
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']//thead/tr")).getText());
		for(int index =1; index<= rowCount; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]")).getText());
		}
	}
	
	void printTableWOLoop() {
		System.out.println("STEP : Print Table without using loop");

		System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
	}
	
	List<String> getStringList(List<WebElement> listWE){
		List<String> list = new ArrayList<>();
		for(WebElement we : listWE) {
			list.add(we.getText());
		}
		return list;
	}
	void duplicateEmpId() {
		System.out.println("STEP : Get list of Employee");

		List<WebElement> listOfEmpIdEle = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[2]"));
		List<String> listOfEmpId = getStringList(listOfEmpIdEle);
		Set<String> setOfEmpId = new LinkedHashSet<>();
		for(String empID : listOfEmpId) {
			if(!setOfEmpId.add(empID)) {
				System.out.println("VERIFY : Duplicate entry -> " + empID);
			}
		}
		
		System.out.println("VERIFY : Total Unique id are "+setOfEmpId.size());
	}
	
	public static void main(String[] args) {
		Assignment6 obj = new Assignment6();
		obj.setup();
		System.out.println("-----------------------------------");
		obj.printUsernameFromName("Abhishek");
		System.out.println("-----------------------------------");
		obj.printTableLoops();
		System.out.println("-----------------------------------");
		obj.printTableOneLoop();
		System.out.println("-----------------------------------");
		obj.printTableWOLoop();
		System.out.println("-----------------------------------");
		obj.duplicateEmpId();
		System.out.println("-----------------------------------");
		obj.closeBrowser();
	}
}
