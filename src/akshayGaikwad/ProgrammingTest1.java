package akshayGaikwad;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgrammingTest1 {
	WebDriver driver;
	
	void setup() {
		System.out.println("STEP : Launch browser and hit automationbykrishna");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com");
	}
	
	void verifyUserName() {
		System.out.println("STEP : Find all usernames in table");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> listOfUsername = driver.findElements(By.xpath("//table[@id='table1']//tr/td[4]"));
		int count = listOfUsername.size();
		
		System.out.println("STEP : Compare usernames with expected username");
		for(int index = 1; index <= count; index++) {
			String fName = driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]/td[2]")).getText();
			String lName = driver.findElement(By.xpath("//table[@id='table1']//tr["+index+"]/td[3]")).getText();
			String expectedUserName = (fName.charAt(0) + lName).toLowerCase();
			if(expectedUserName.equals(listOfUsername.get(index-1).getText())) {
				System.out.println("VERIFY : PASS -> Expected : " + expectedUserName + ", Observed : " + listOfUsername.get(index-1).getText());
			}else {
				System.out.println("VERIFY : FAIL -> Expected : " + expectedUserName + ", Observed : " + listOfUsername.get(index-1).getText());
			}
		}
	}
	
	void closeBrowser() {
		System.out.println("STEP : Close the Browser");
		driver.quit();
	}
	
	public static void main(String[] args) {
		ProgrammingTest1 obj = new ProgrammingTest1();
		obj.setup();
		obj.verifyUserName();
		obj.closeBrowser();
	}
}
