package shramikaVaidya;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	WebDriver driver;

	void getDemoTable() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP:1 Hit the url");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP:2 Click on Demotable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	List<String> getCovertTextList(List<WebElement> listOfUserName) {
		List<String> listOfWebElemnts = new ArrayList<String>();
		for (WebElement e : listOfUserName) {
			listOfWebElemnts.add(e.getText());
		}
		return listOfWebElemnts;
	}

	void testCase1() {
		getDemoTable();
		System.out.println("TestCase1: No of Employees in table");
		List<WebElement> empList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(empList.size());
	}

	void testCase2() {
		List<WebElement> headerlist = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("STEP:Print  no of columns in Table");
		System.out.println(headerlist.size());

		if (headerlist.size() == 4) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		String actualHeader = "";
		for (WebElement e : headerlist) {
			actualHeader = actualHeader + e.getText() + " ";
		}

		actualHeader = actualHeader.trim();
		System.out.println(actualHeader);
		String expectedHaeder = "# First Name Last Name Username";

		if (actualHeader.equals(expectedHaeder)) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}

	void testCase3() {
		List<WebElement> usernameList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		System.out.println("No of Username: " + usernameList.size());
		if (usernameList.size() == 5) {
			System.out.println("No of username match: Test Pass");
		} else {
			System.out.println("No of username match: Test Fail");
		}

		List<String> usernameTextList = getCovertTextList(usernameList);
		Set<String> usernameSet = new HashSet<String>(usernameTextList);
		System.out.println("Unique usernames are: " + usernameSet);

	}

	void testCase4() {
		List<WebElement> surnameList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		List<String> lastnameList = new ArrayList<>();
		Set<String> duplicateSet = new LinkedHashSet<>();

		for (WebElement e : surnameList) {
			if (lastnameList.contains(e.getText())) {
				duplicateSet.add(e.getText());
			} else {
				lastnameList.add(e.getText());
			}
		}
		System.out.println("UniQue Surname are: " + lastnameList);
		System.out.println("Duplicate Surname are: " + duplicateSet);
	}

	void testCase5() {
		List<WebElement> webList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		List<String> lastnameList = getCovertTextList(webList);
		Map<String, Integer> surnameMap = new HashMap<String, Integer>();

		for (String lastName : lastnameList) {
			if (surnameMap.containsKey(lastName)) {
				int count = surnameMap.get(lastName);
				surnameMap.put(lastName, count + 1);
			} else {
				surnameMap.put(lastName, 1);
			}
			Set<String> keyset = surnameMap.keySet();
			for (String key : keyset) {
				int num = surnameMap.get(key);
				if (num == 1) {
					System.out.println("Unique surName : " + key);
				} else {
					System.out.println("Duplicate surName : " + key);
				}
			}
		}
	}

	void testCase6() {
		List<WebElement> webList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[3]"));
		List<String> lastnameList = getCovertTextList(webList);
		Set<String> surnameSet = new HashSet<String>();

		for (String lastName : lastnameList) {
			if (!surnameSet.add(lastName)) {
				System.out.println("Duplicates Surname are: " + lastName);
			} else {
				System.out.println("Unique Surname are: " + lastName);
			}
		}
	}

	void testCase7() {
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> fullnameMap = new LinkedHashMap<String, String>();

		for (int index = 1; index <= rowCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			fullnameMap.put(firstName, lastName);
		}
		String key = fullnameMap.get("Priya");
		if (key.equals("Patro")) {
			System.out.println("Test passed as priya's lastName is Patro");
		} else {
			System.out.println("Test failed as priya's lastName is Patro");
		}
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment5 assignment_5 = new Assignment5();
		assignment_5.testCase1();
		System.out.println("---------------------------------");
		assignment_5.testCase2();
		System.out.println("------------------------------------");
		assignment_5.testCase3();
		System.out.println("----------------------------------------");
		assignment_5.testCase4();
		System.out.println("-----------------------------------------");
		assignment_5.testCase5();
		System.out.println("-----------------------------------------");
		assignment_5.testCase6();
		System.out.println("-----------------------------------------");
		assignment_5.testCase7();
		System.out.println("-----------------------------------------");
	}

}
