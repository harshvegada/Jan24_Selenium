package pujaPoreddiwar;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment9 {
	WebDriver driver;

	void setUp() {
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP - click on Demo link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped']/tbody/tr")));
	}

	void testCase() {
		setUp();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <= row; i++) {
			String mngId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			String empname = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]")).getText();
			if (map.containsKey(mngId)) {
				String temp = map.get(mngId) + "," + empname;
				map.put(mngId, temp);
			} else {
				map.put(mngId, empname);
			}
		}
		System.out
				.println("STEP : Get Manager IDs with number of counts and name of employees working in each Manager");
		Set<String> setOfMngIds = map.keySet();
		for (String currentMngId : setOfMngIds) {
			String empList = map.get(currentMngId);
			System.out.println(currentMngId + " : " + empList.split(",").length + " = " + empList);
		}
		driver.quit();
	}

	public static void main(String[] args) {
		new Assignment9().testCase();
	}
}
