package varshaNagadwala;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Selenium_1 {

	WebDriver driver;
	void openBrowser() {
		System.out.println("STEP : Launch Chrome Browser");
		driver = new ChromeDriver();

		System.out.println("STEP : Maximize the Browser Window");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	void verifyUserNameFormation() {

		System.out.println("checkFirstList Start");
		openBrowser();

		System.out.println("STEP : Hit the URL");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP : Click on Basic Element link");
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("STEP : Total number of row in table ");
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		List<String> listExpectedUserName = new ArrayList<>();
		List<String> listActualUserName = new ArrayList<>();

		System.out.println("STEP : Get all the firstName, LastName and UserName, and add it is list");
		for (int i = 1; i < totalRow; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]"))
					.getText();

			String expectedUserName = firstName.toLowerCase().substring(0, 1)
					+ lastName.toLowerCase().substring(0, lastName.length());

			listExpectedUserName.add(expectedUserName);
			listActualUserName.add(actualUserName);
		}

		System.out.println("STEP : Print expected username list ");
		System.out.println(listExpectedUserName);
		System.out.println("STEP : Print actual username list ");
		System.out.println(listActualUserName);
		System.out.println("VERIFY : Actual UserName is equal to Expected UserName");
		if (listActualUserName.equals(listExpectedUserName)) {
			System.out.println("Testcase Pass");
		} else {
			System.out.println("Testcase Fail");
		}
		System.out.println("STEP : Close the browser");
		driver.quit();
	}

	public static void main(String[] args) {
		new Test_Selenium_1().verifyUserNameFormation();
	}
}
