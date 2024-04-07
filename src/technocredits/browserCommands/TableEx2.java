package technocredits.browserCommands;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableEx2 {
	WebDriver driver;
	
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	
	List<String> convertToStringList(List<WebElement> list){
		List<String> listOfString = new ArrayList<String>();
		for(WebElement e : list) {
			listOfString.add(e.getText());
		}
		return listOfString;
	}
	
	void verifyTableHeader() {
		setup();
		List<String> list = new ArrayList<String>();
		LinkedHashSet<String> duplicateLastNameSet = new LinkedHashSet<>();
		driver.findElement(By.linkText("Demo Tables")).click();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int rowCount=1;rowCount<=totalRows;rowCount++) {			
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowCount+"]/td[3]")).getText();
			if(list.contains(lastName)) {
				duplicateLastNameSet.add(lastName);
			}else {
				list.add(lastName);
			}
		}
		System.out.println("Duplicate lastname is/are : " + duplicateLastNameSet);
	}
	
	void verifyTableHeader1() {
		setup();
		LinkedHashSet<String> duplicateLastNameSet = new LinkedHashSet<>();
		driver.findElement(By.linkText("Demo Tables")).click();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int rowCount=1;rowCount<=totalRows;rowCount++) {			
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowCount+"]/td[3]")).getText();
			if(!duplicateLastNameSet.add(lastName))
				System.out.println("Duplicate lastname : " + lastName);
		}
	}
	
	public static void main(String[] args) {
		new TableEx2().verifyTableHeader();
	}
}
