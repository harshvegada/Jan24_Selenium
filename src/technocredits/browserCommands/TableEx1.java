package technocredits.browserCommands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableEx1 {
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
		String[] arr = {"#","First Name","Last Name","Username"};
		List<String> expectedHeaderList = Arrays.asList(arr);
		System.out.println(expectedHeaderList);
		
		
		driver.findElement(By.linkText("Demo Tables")).click();
		List<WebElement> actualHeaderList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		List<String> actualHeaderListText = convertToStringList(actualHeaderList);
		
		System.out.println(actualHeaderListText);
		System.out.println(actualHeaderListText.equals(expectedHeaderList));
	}
	
	public static void main(String[] args) {
		new TableEx1().verifyTableHeader();
	}
}
