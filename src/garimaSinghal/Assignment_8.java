package garimaSinghal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_8 {
	WebDriver driver;

	void setUp() {
		driver = new ChromeDriver();
		System.out.println("STEP - Launch chrome browser and hit automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP - click on Demo link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	void testCase1() {
		setUp();
		int row = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 1; i <= row; i++) {
			String mngId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			if (map.containsKey(mngId)) {
				int count = map.get(mngId) + 1;
				map.put(mngId, count);
			} else {
				map.put(mngId, 1);
			}
		}
		System.out.println("STEP : Get Manager Ids and number of employees working in each Manager");
		System.out.println(map);
		int maxCount = 0;
		String output = "";
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			if (maxCount < map.get(key)) {
				maxCount = map.get(key);
				output = key;
			}
		}
		System.out.println("ManagerId " + output + " having Maximum Mentors");
	}

	void testCase2() {
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
			System.out.println(currentMngId + "--->" + empList.split(",").length + " = " + empList);
		}
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment_8 assignment_8 = new Assignment_8();
		System.out.println("==============================");
		assignment_8.testCase1();
		System.out.println("==============================");
		assignment_8.testCase2();
	}
}