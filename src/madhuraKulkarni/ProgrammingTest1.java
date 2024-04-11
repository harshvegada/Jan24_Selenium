
package madhuraKulkarni;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgrammingTest1 {
	WebDriver driver;

	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP 1: Launch the browser and hit the URL.");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Browser launched successfully...");
	}

	void verifyUserNames() {
		launchBrowser();
		System.out.println("STEP: Find all the user names in the table.");
		List<WebElement> listOfUserNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		int sizeOfList = listOfUserNames.size();

		for (int i = 1; i <= sizeOfList; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();
			String expectedUserName = (firstName.charAt(0) + lastName).toLowerCase();
			String actualUserName = listOfUserNames.get(i - 1).getText();

			if (expectedUserName.equals(actualUserName)) {
				System.out.println("Test case passed");
				System.out.println(
						"Expected Username: " + expectedUserName + " and " + "Actual UserName: " + actualUserName);
			} else {
				System.out.println("Test case failed");
				System.out.println(
						"Expected Username: " + expectedUserName + "-->" + "Actual UserName: " + actualUserName);
			}
		}
		driver.quit();
	}

	public static void main(String[] args) {
		new ProgrammingTest1().verifyUserNames();
	}

}
