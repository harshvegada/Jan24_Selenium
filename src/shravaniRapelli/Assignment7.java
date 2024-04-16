package shravaniRapelli;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Assignment7 {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	void setUp() {
		driver = new ChromeDriver();
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP - click on Demo link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void TestCase1() {
		setUp();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 1; i <= row; i++) {
			String depttname = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			if (map.containsKey(depttname)) {
				int count = map.get(depttname) + 1;
				map.put(depttname, count);
			} else {
				map.put(depttname, 1);
			}
		}
		System.out.println("STEP : Get department name and number of employees working in each department");
		System.out.println(map);
	}

	void TestCase2() {
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 1; i <= row; i++) {
			String depttname = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			String empname = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]")).getText();
			if (map.containsKey(depttname)) {
				List<String> listOfEmp = map.get(depttname);
				listOfEmp.add(empname);
				map.put(depttname, listOfEmp);
			} else {
				List<String> listOfEmp = new LinkedList<String>();
				listOfEmp.add(empname);
				map.put(depttname, listOfEmp);
			}
		}
		System.out.println("STEP : Get department name and name of employees working in each department");
		System.out.println(map);
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment7 assgn7 = new Assignment7();
		System.out.println("**********Test Case 1**********");
		assgn7.TestCase1();
		System.out.println("**********Test Case 2**********");
		assgn7.TestCase2();
	}
}

