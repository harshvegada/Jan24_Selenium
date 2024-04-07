package garimaSinghal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_1 {
	
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
		int rowSize=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Verify : UserName with FirstName and LastName");
		for(int i=1;i<=rowSize;i++) {
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowSize+"]/td[2]")).getText();
			String lastName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowSize+"]/td[3]")).getText();
			String expectedUsername=(firstName.charAt(0)+lastName).toLowerCase();
			String username=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowSize+"]/td[4]")).getText();
			if(expectedUsername.equals(username)) {
				System.out.println("username verified");
			}else {
				System.out.println("username not verified");
			}
		}
		driver.quit();
	}
	
	public static void main(String[] args) {
		new Test_1().testCase1(); 
	}
}
