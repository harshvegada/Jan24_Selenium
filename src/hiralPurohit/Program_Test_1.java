package hiralPurohit;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_Test_1 {

	WebDriver driver;

	void getDemoTable() {
		driver = new ChromeDriver();
		System.out.println("STEP:1 Maximize driver window");
		driver.manage().window().maximize();

		System.out.println("STEP 2:Hit th URL");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP 3: click on Demotable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	void toVerifyUserName() {
		getDemoTable();

		System.out.println("STEP 4: Find No of Rows");
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int size = totalRows.size();
		System.out.println("NO of rows: " + size);

		System.out.println("STEP: Verification of UserName");
		for (int index = 1; index <= size; index++) {
			
			String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();		
			String lastname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
			String ExpectedUsername = (firstname.substring(0, 1) + lastname).toLowerCase();
			String ActualUsername = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			
			if (ActualUsername.equals(ExpectedUsername)) {
				System.out.println("Test pass");
			} else {
				System.out.println("Test Fail");
			}
		}driver.quit();
	}
	
	public static void main(String[] args) {
		new Program_Test_1().toVerifyUserName();
	}
}