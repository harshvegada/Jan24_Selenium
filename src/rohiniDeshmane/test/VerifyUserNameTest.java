package rohiniDeshmane.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyUserNameTest {
	WebDriver driver;
	
	void openBrowser() {
		System.out.println("\n\nSTEP : Url Loaded and Maximized");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		driver.manage().window().maximize();
		
		System.out.println("STEP : Click on Basic element tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
	}
	
	List<String> convertIntoTextList(List<WebElement> listOfWebElement){
		List<String> listOfString = new ArrayList<String>();
		
		for(int i=0; i<listOfWebElement.size(); i++) {
			listOfString.add(listOfWebElement.get(i).getText().toLowerCase());
		}
		
		return listOfString;
	}
	
	List<Character> convertIntoCharList(List<WebElement> listOfWebElement){
		List<Character> listOfChar = new ArrayList<Character>();
		
		for(int i=0; i<listOfWebElement.size(); i++) {
			listOfChar.add(listOfWebElement.get(i).getText().toLowerCase().charAt(0));
		}
		
		return listOfChar;
	}
	
	void verifyUserName() {
		String[] usernameArr = {"mkanani","kkanani","dboda","asharma","ppatro"};
		List<String> expectedUsername = new ArrayList<String>(Arrays.asList(usernameArr));
		System.out.println(expectedUsername);
		
		
		System.out.println("STEP : Get all First names");
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<Character> listOfCharFName = convertIntoCharList(listOfElements);
		
		System.out.println("STEP : Get all last names");
		List<WebElement> listOfElementsln = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		List<String> listOfLastName =  convertIntoTextList(listOfElementsln);
		
		System.out.println("STEP : Combined first name and last name");
		List<String> userNameCombination = new ArrayList<String>();
		
		for(int i=0; i<listOfLastName.size(); i++) {
			String combinedStr = listOfCharFName.get(i)+listOfLastName.get(i);
			userNameCombination.add(combinedStr);
		}
		System.out.println(userNameCombination);
		
		System.out.println("Verify : expected and actual user name "+userNameCombination.equals(expectedUsername));
		System.out.println("Test case passed");
	}
	
	public static void main(String[] args) {
		VerifyUserNameTest verifyUserNameTest = new VerifyUserNameTest();
		verifyUserNameTest.openBrowser();
		verifyUserNameTest.verifyUserName();
	}
}
