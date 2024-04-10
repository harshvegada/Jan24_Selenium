package sasmitaSahu;

import java.util.ArrayList;
import java.util.Arrays;
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

	void testcase1() {
		load();
		List<WebElement> listofemp = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Total number of employess present in the table " + listofemp.size());
	}

	void testcase2() {
		String ExpectedHeaders = "# First Name Last Name Username";
		System.out.println("STEP5 : Get all header names");
		List<WebElement> listOfheaders = driver.findElements(By.xpath("//table[@id='table1']//th"));
		System.out.println("VERIFY : Number of rows in table are " + listOfheaders.size());

		if (listOfheaders.size() == 4) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		String ActualHeaders = "";
		for (WebElement e : listOfheaders) {
			System.out.println(e.getText());
		}
		ExpectedHeaders = ActualHeaders.trim();
		if (ActualHeaders.equals(ExpectedHeaders)) {
			System.out.println("Test passed as Headers names are as expected");
		} else {
			System.out.println("Test passed as Headers names are as not expected");
		}
	}

	void testcase3() {
		List<WebElement> listofUsernames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		Set<WebElement> setOfUserName = new HashSet<>(listofUsernames);
		if (listofUsernames.size() == setOfUserName.size()) {
			System.out.println("All usernames are unique");
		} else {
			System.out.println("All usernames are not unique");
		}
	}

	void testcase4() {
		List<WebElement> sizeoflastnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		System.out.println(sizeoflastnames.size());
		List<String> listofnames = new ArrayList<>();
		Set<String> duplicateelements = new LinkedHashSet<>();
		for (WebElement e : sizeoflastnames) {
			if (listofnames.contains(e.getText())) {
				duplicateelements.add(e.getText());
			} else {

				listofnames.add(e.getText());
			}
		}
		System.out.println("unique last names " + listofnames);
		System.out.println("Duplicate last names " + duplicateelements);
	}

	List<String> getConversionWebElementList(List<WebElement> listofheaders) {
		List<String> listofActualHeaders = new ArrayList<String>();
		for (WebElement e : listofheaders) {
			listofActualHeaders.add(e.getText());
		}
		return listofActualHeaders;
	}

	void testcase5() {
		int count = 0;
		List<WebElement> sizeoflastnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOflastName = getConversionWebElementList(sizeoflastnames);
		Map<String, Integer> mapoflastNames = new LinkedHashMap<>();
		System.out.println(listOflastName);
		for (String lastname : listOflastName) {
			if (mapoflastNames.containsKey(lastname)) {
				count = mapoflastNames.get(lastname);
				mapoflastNames.put(lastname, ++count);
			} else
				mapoflastNames.put(lastname, 1);
		}
		System.out.println(mapoflastNames);
		Set<String> keySet = mapoflastNames.keySet();
		for (String key : keySet) {
			if (mapoflastNames.get(key) == 1)
				System.out.println("unique last names : " + key);
			else
				System.out.println("Duplicate last names : " + key);
		}
	}

	void testcase6() {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfirsttName = getConversionWebElementList(listOfElements);
		Set<String> setOfDuplicate = new LinkedHashSet<>();
		for (String name : listOfirsttName) {
			if (!setOfDuplicate.add(name)) {
				System.out.println("VERIFY : Duplicate Last Names  " + name);
			}
		}
		System.out.println("VERIFY : Unique Last Names  : " + setOfDuplicate);
	}

	void testcase7() {
		int rownumber = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int index = 1; index <= rownumber; index++) {
			String firstname = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastname = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			map.put(firstname, lastname);
		}
		System.out.println("STEP: Get firstname and lastname ");
		System.out.println(map);
		if (map.get("Priya").equals("Patro")) {
			System.out.println("VERIFY : Testcase passed as Priya lastname is Patro");
		} else {
			System.out.println("VERIFY : Testcase failed Priya lastname is not Patro");
		}
	}

	public static void main(String[] args) {
		Assignment5 assignment5 = new Assignment5();
		assignment5.testcase1();
		assignment5.testcase2();
		assignment5.testcase3();
		assignment5.testcase4();
		assignment5.testcase5();
		assignment5.testcase6();
		assignment5.testcase7();
	}

}
