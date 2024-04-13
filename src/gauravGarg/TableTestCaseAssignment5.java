package gauravGarg;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTestCaseAssignment5 {

	WebDriver wb;

	void loadBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step 2-: Click on Demo Table tab ");
		wb.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	}

	void testCase1() {
		loadBrowser();
		List<WebElement> listofEmployee = wb.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[1]"));
		System.out.println("Step 3-:Load the Element ");
		System.out.println("The number of employees are there " + listofEmployee.size());
		if (listofEmployee.size() == 5) {
			System.out.println("Test  Case Passed");
		} else {
			System.out.println("Test  Case Failed");
		}
		wb.quit();

	}

	void testCase2() {
		loadBrowser();
		List<WebElement> listofEmployee = wb.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		List<String> list = new ArrayList<String>(Arrays.asList("#", "First Name", "Last Name", "Username"));
		System.out.println("Step 3-:Load the column tab ");
		System.out.println("The number of Count of employee " + listofEmployee.size());
		System.out.println("Step 4-:Print all headers of each column ");
		List<String> list1 = new ArrayList<String>();
		for (WebElement element : listofEmployee) {
			System.out.print(element.getText() + "");
			list1.add(element.getText());
		}
		System.out.println();
		System.out.println("Step 5-:Result of TestCase of Count of employee ");
		if (listofEmployee.size() == 4) {
			System.out.println("Test  Case Passed");
		} else {
			System.out.println("Test  Case Failed");
		}
		System.out.println("Step 6-:Result of TestCase of all headers of each column ");
		if (list1.equals(list)) {
			System.out.println("Test  Case Passed");
		} else {
			System.out.println("Test  Case Failed");
		}
		wb.quit();
	}

	List<String> convertListWebelementToString(List<WebElement> ls) {
		List<String> list = new ArrayList<String>();
		for (WebElement element : ls) {
			list.add(element.getText());
		}
		return list;
	}

	void testCase3() {
		loadBrowser();
		List<WebElement> listofEmployee = wb.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		// List<String> list = new ArrayList<String>();
		System.out.println("Step 3-:Load the column  username");
		System.out.println("The number of count of username " + listofEmployee.size());
		System.out.println("Step 4-:Print all  username ");
		List<String> Foundedlist1 = new ArrayList<String>();
		for (WebElement element : listofEmployee) {
			System.out.print(element.getText() + " ");
			Foundedlist1.add(element.getText());
		}
		System.out.println();
		Set<String> UniqueFoundedlist1 = new LinkedHashSet<String>(Foundedlist1);
		List<String> list6 = new ArrayList<String>(UniqueFoundedlist1);
		System.out.println("Step 5-:Found unique element in Set ");
		System.out.println("Step 6-:Result of TestCase of verify each  username is unique ");
		if (list6.equals(Foundedlist1)) {
			System.out.println("Test  Case Passed");
		} else {
			System.out.println("Test  Case Failed");
		}

		/*
		 * for (int i = 0; i < Foundedlist1.size(); i++) {
		 * System.out.println(Foundedlist1.get(i)); } System.out.println(); for (String
		 * s:UniqueFoundedlist1) { System.out.println(s); }
		 */
		System.out.println();
		System.out.println(Foundedlist1);
		System.out.println(UniqueFoundedlist1);
		wb.quit();

	}

//TC4 : Print all the unique surnames and print duplicate surnames if any using List+Set. 
	void testCase4() {
		loadBrowser();
		List<WebElement> listofEmployee = wb.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[3]"));

		System.out.println("Step 3-:Load the column  Lastname");
		System.out.println("The number of count Lastname " + listofEmployee.size());
		List<String> Foundedlist1 = convertListWebelementToString(listofEmployee);
		List<String> DuplicateElement = new ArrayList<String>();
		Set<String> UniqueList = new LinkedHashSet<String>();
		System.out.println("Step 4-:Print all  Lastname ");
		System.out.println(Foundedlist1);
		for (String str : Foundedlist1) {
			if (!UniqueList.add(str)) {
				DuplicateElement.add(str);
			}
		}
		System.out.println("Step 5-:Print all Unique Lastname ");
		System.out.println(UniqueList);
		System.out.println("Step 6-:Print all Duplicate Lastname ");
		System.out.println(DuplicateElement);

		wb.quit();
	}

//TC5 : Print all the unique surnames and print duplicate surnames if any using Map. 
	void testCase5() {
		loadBrowser();
		List<WebElement> listofEmployee = wb.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[3]"));
		System.out.println("Step 3-:Load the column  Lastname");
		System.out.println("The number of count Lastname " + listofEmployee.size());
		List<String> Foundedlist1 = convertListWebelementToString(listofEmployee);
		System.out.println("Step 4-:Print all  Lastname ");
		System.out.println(Foundedlist1);
		Map<String, Integer> mp = new HashMap<String, Integer>();
		for (String str : Foundedlist1) {
			if (mp.containsKey(str)) {
				int count = mp.get(str);
				mp.put(str, count + 1);
			} else {
				mp.put(str, 1);
			}
		}
		System.out.println(mp);
		Set<String> key = mp.keySet();
		System.out.println("Step 5-:Print all Unique Lastname ");
		for (String s : key) {
			int count = mp.get(s);
			if (count == 1) {
				System.out.print(s + "");
			}
		}
		System.out.println();
		System.out.println("Step 6-:Print all Duplicate Lastname ");
		for (String s : key) {
			int count = mp.get(s);
			if (count > 1) {
				System.out.print(s);
			}
		}
		System.out.println();
		wb.quit();
	}

//TC6 : Print all the unique surnames and print duplicate surnames if any using Set. 	
	void testCase6() {
		loadBrowser();
		List<WebElement> listofEmployee = wb.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[3]"));
		System.out.println("Step 3-:Load the column  Lastname");
		System.out.println("The number of count Lastname " + listofEmployee.size());
		List<String> Foundedlist1 = convertListWebelementToString(listofEmployee);
		List<String> DuplicateElement = new ArrayList<String>();
		ArrayList<String> UniqueList = new ArrayList<String>();
		System.out.println("Step 4-:Print all  Lastname ");
		System.out.println(Foundedlist1);
		for (String str : Foundedlist1) {
			if (!UniqueList.contains(str)) {
				UniqueList.add(str);
			} else {
				DuplicateElement.add(str);
			}
		}
		System.out.println("Step 5-:Print all Unique Lastname ");
		System.out.println(UniqueList);
		System.out.println("Step 6-:Print all Duplicate Lastname ");
		System.out.println(DuplicateElement);
		wb.quit();
	}
//TC7 : Return firstname and lastname of each employee in Map<String, String>, in main method verify the lastname of the employee should be Patro whoes firstname is Priya.

	void testCase7() {
		loadBrowser();
		int count = wb.findElements(By.xpath("//table[@id='table1']/tbody//tr/td[2]")).size();
		Map<String, String> mp = new HashMap<String, String>();
		System.out.println("Step 3-:Load the FirstName and  Lastname");
		for (int index = 1; index <= count; index++) {
			String firstname = wb.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[2]"))
					.getText();
			String lastname = wb.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]/td[3]"))
					.getText();
			mp.put(firstname, lastname);
		}
		System.out.println("Step 4-:Print the map FirstName and  Lastname ");
		System.out.println(mp);
		System.out.println("Step 6-:Result of TestCase of all headers of each column ");
		Set<String> set = mp.keySet();
		String str = mp.get("Priya");
		System.out.println("Step 7-:Comparing expected Result and find Result ");
		if (str.equals("Patro")) {
			System.out.println("Test  Case Passed");
		} else {
			System.out.println("Test  Case Failed");
		}
		wb.quit();
	}

	public static void main(String[] args) {
		new TableTestCaseAssignment5().testCase1();
		new TableTestCaseAssignment5().testCase2();
		new TableTestCaseAssignment5().testCase3();
		new TableTestCaseAssignment5().testCase4();
		new TableTestCaseAssignment5().testCase5();
		new TableTestCaseAssignment5().testCase6();
		new TableTestCaseAssignment5().testCase7();
	}

}