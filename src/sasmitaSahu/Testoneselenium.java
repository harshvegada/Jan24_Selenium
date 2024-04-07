package sasmitaSahu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testoneselenium {
	WebDriver driver;

	void load() {
		System.out.println("STEP1-Launch the ChromeBowser");
		driver = new ChromeDriver();

		System.out.println("STEP2-Maximise the ChromeBowser");
		driver.manage().window().maximize();

		System.out.println("STEP3-hit the url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("STEP4-Click on Demo tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void verifyUsernameFiled() {
		load();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println(rows);
		for (int i = 1; i <= rows; i++) {
			String firstname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			// System.out.println(firstname);
			String lastname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]")).getText();
			// System.out.println(lastname);
			String ExpectedUsername = (firstname.charAt(0) + lastname).toLowerCase();
			// System.out.println(ExpectedUsername);
			String ActualUsername = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[4]"))
					.getText();
			// System.out.println(ActualUsername);
			if (ActualUsername.equals(ExpectedUsername))
				System.out.println("username " + ActualUsername + " verified");
			else
				System.out.println("username not verified");
		}
		driver.close();
	}

	public static void main(String[] args) {
		Testoneselenium testoneselenium = new Testoneselenium();
		testoneselenium.load();
		testoneselenium.verifyUsernameFiled();

	}

}
