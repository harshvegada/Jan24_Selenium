package dharmaKanani;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	WebDriver driver;

	void getSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP: Hit the Url");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: Click on DemoTable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	void toGetMapofDep() {
		getSetup();

		Map<String, Integer> empMap = new HashMap<String, Integer>();
		System.out.println("STEP: get the size of Employee Department");
		int size = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();

		for (int index = 1; index <= size; index++) {
			WebElement emp = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"));
			String empDep = emp.getText();

			if (empMap.containsKey(empDep)) {
				int count = empMap.get(empDep);
				empMap.put(empDep, count + 1);
			} else {
				empMap.put(empDep, 1);
			}

		}
		System.out.println("TestPass of Employee Dep");
		System.out.println(empMap);
		driver.quit();
	}

	public static void main(String[] args) {
		new Assignment7().toGetMapofDep();
	}
}
