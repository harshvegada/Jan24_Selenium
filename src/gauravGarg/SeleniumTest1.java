package gauravGarg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest1 {

	List<String> covertListWebelementtoString(List<WebElement> wb) {
		List<String> ls = new ArrayList<String>(wb.size());
		for (WebElement element : wb) {
			ls.add(element.getText());
		}
		return ls;
	}

	void firstWay() {
		System.out.println("first way");
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step 2-: Click on basic element tab ");
		wb.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
		List<WebElement> list1 = wb.findElements(By.xpath("//table[@id='table1']//td[2]"));
		List<WebElement> list2 = wb.findElements(By.xpath("//table[@id='table1']//td[3]"));
		System.out.println("Step 3-: Load the first Name and last Name ");
		List<WebElement> expectedresult = wb.findElements(By.xpath("//table[@id='table1']//td[4]"));
		List<String> list3 = covertListWebelementtoString(list1);
		List<String> list4 = covertListWebelementtoString(list2);
		List<String> expectedList = covertListWebelementtoString(expectedresult);
		System.out.println("Step 4-: Convert the WebELement to String");
		List<String> findList = new ArrayList<String>();
		for (int i = 0; i < list3.size(); i++) {

			findList.add((list3.get(i).charAt(0) + "" + list4.get(i)).toLowerCase());
		}
		System.out.println("Step 5-: Combined both First name (First Character) and Last name");
		
		System.out.println("Step 6-: Print the expected result and combined result");
		for(int i =0;i<findList.size();i++)
		{
			System.out.println(findList.get(i) +" " +expectedList.get(i) );
		}
		System.out.println("Step 7-: Check the expected result with combined combination");
		if (findList.equals(expectedList)) {
			System.out.println("TestCase Passed");
		} else {
			System.out.println("TestCase Failed");
		}	
		
		wb.quit();
	}
	
	void secondWay()
	{
		System.out.println();
		System.out.println("Second way");
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("Step 1-:. Url Loaded");
		wb.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step 2-: Click on basic element tab ");
		wb.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
		int len = wb.findElements(By.xpath("//table[@id='table1']//td[2]")).size();
		List<String> foundResult= new ArrayList<String>();
		for(int i=1;i<=len;i++)
		{
			String firstName= wb.findElement(By.xpath("//table[@id='table1']//tr["+i+"]/td[2]")).getText();
			String LastName= wb.findElement(By.xpath("//table[@id='table1']//tr["+i+"]/td[3]")).getText();
			foundResult.add((firstName.charAt(0)+LastName).toLowerCase());			
		}
		System.out.println("Step 3-: Load the first Name & last Name  ");
		System.out.println("Step 4-: Combined both First name (First Character) and Last name");
		
		List<WebElement> expectedresult = wb.findElements(By.xpath("//table[@id='table1']//td[4]"));
		List<String> expectedList = covertListWebelementtoString(expectedresult);
		
		System.out.println("Step 5-: Print the expected result and combined result");
		for(int i =0;i<foundResult.size();i++)
		{
			System.out.println(foundResult.get(i) +" " +expectedList.get(i) );
		}
		System.out.println("Step 6-: Check the expected result with combined combination");
		if (foundResult.equals(expectedList)) {
			System.out.print("TestCase Passed");
		} else {
			System.out.print("TestCase Failed");
		}
		wb.quit();
	}

	public static void main(String[] args) {
		new SeleniumTest1().firstWay();
		new SeleniumTest1().secondWay();
	}
}
