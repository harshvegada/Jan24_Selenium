package rupaliUmagol;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgrammingTest1 {
	WebDriver driver;

	void getBrowser() {
		System.out.println("STEP : Open WebDriver");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize Browser");
		driver.manage().window().maximize();

		System.out.println("STEP : launch url");
		driver.get("http://automationbykrishna.com");

	}

	void VerifyUserName() {
		getBrowser();

		System.out.println("STEP : Click on Demo Table");
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("STEP : wait");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		System.out.println("STEP : FindOut totalRows ");
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int size = totalRows.size();

		System.out.println("VERIFY : Username are correct");
		for (int i = 1; i <= size; i++) {
			String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();

			String username = (firstname.substring(0, 1) + lastName).toLowerCase();
			// System.out.println(username);

			String Expectedusername = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]"))
					.getText();

			if (username.equals(Expectedusername)) {
				System.out.println("Test Passed");
			} else
				System.out.println("Test Failed");
		}

		System.out.println("STEP : Close Driver");
		driver.quit();

	}

	public static void main(String[] args) {
		new ProgrammingTest1().VerifyUserName();
	}
}
