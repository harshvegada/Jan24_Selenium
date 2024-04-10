package phenolVerma;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserNameCheck {

	// Creating Chrome webdriver object
	WebDriver driver;

	void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		System.out.println("Opening URL");
		driver.get("http://automationbykrishna.com");
	}

	void userNameFormatCheck() throws InterruptedException {

		System.out.println("Open Browser");
		openBrowser();

		// Clicking on Demo Tables tab
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		System.out.println("Getting table size for username");

		int tableSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println(tableSize);

		System.out.println("Creating ArrayList to store actual username");
		ArrayList<String> actualUsername = new ArrayList<String>();

		System.out.println("Creating ArrayList to store Created username");
		ArrayList<String> createdUsername = new ArrayList<String>();

		for (int index = 1; index <= tableSize; index++) {

			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			String sirName = (firstName.substring(0, 1) + lastName).toLowerCase();
			createdUsername.add(sirName);
		}
		System.out.println("Username formation - " + createdUsername);

		for (int index = 1; index <= tableSize; index++) {

			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			actualUsername.add(userName);
		}

		System.out.println("Actual username from the table - " + actualUsername);

		if (actualUsername.equals(createdUsername)) {
			System.out.println("Test Case passed");
		} else {
			System.out.println("Test Case not passed");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		UserNameCheck userNameCheck = new UserNameCheck();
		userNameCheck.userNameFormatCheck();
	}
}
