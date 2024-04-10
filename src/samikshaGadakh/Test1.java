package samikshaGadakh;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	WebDriver driver;

	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
	}

	void verifyUsername() {
		setup();
		int rows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
	    for(int index=1;index<=rows;index++) {
			String firstName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String lastName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			String expectedUserName=(firstName.charAt(0)+lastName).toLowerCase();
			String actualUserName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if(actualUserName.equals(expectedUserName)) {
				System.out.println("username " + actualUserName + " verified");
			}else
				System.out.println("username not verified");
		}
		
		driver.close();
	}
		
	public static void main(String[] args) {
		new Test1().verifyUsername();
	}

}
