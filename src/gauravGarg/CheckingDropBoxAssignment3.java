package gauravGarg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckingDropBoxAssignment3 {


	void checkingSingleSelectDropDown() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com/");
		System.out.println("Step 1. Url Loaded and Maximized");
		wb.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Step 2. Click on Element Tab");
		Thread.sleep(3000);
		WebElement we1 = wb.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor js = (JavascriptExecutor) wb;
		js.executeScript("arguments[0].scrollIntoView(true)", we1);
		System.out.println("Step 3. Scroll the Window");
		Select select = new Select(we1);
		List<WebElement> ls = select.getOptions();
		
		System.out.println("Step 4.How Many option we have to select a value");
		System.out.println(ls.size());
		System.out.println("Step 5.List of option that we can select");
		for (WebElement element : ls) {
			System.out.print(element.getText() + " ");
		}
		System.out.println();
		System.out.println("Step 6.Check weather it is Multiple Select");
		System.out.println(select.isMultiple());	
		System.out.println("Step 7.Now Select odd Value-1,3 and 5");
		select.selectByIndex(3);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("Step 8.Print the Selected Value using method getFirstSelectedOption and.getAllSelectedOptions  -");
		WebElement ab = select.getFirstSelectedOption();
		System.out.println("Value we retrive using getFirstSelectedOption -:"+ "\n"+ ab.getText());
	
		List<WebElement> ab1 = select.getAllSelectedOptions();
		System.out.println("Value we retieve using getAllSelectedOptions -:");
		for (WebElement element : ab1) {
			System.out.print(element.getText() + " ");
		}
		System.out.println();
		System.out.println("Step 9 Close the broswer");
		wb.quit();
	}

	void checkingMultiSelectDropDown() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com/");
		System.out.println("Step 1. Url Loaded and Maximized");
		wb.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Step 2. Click on Element Tab");
		Thread.sleep(3000);
		WebElement we1 = wb.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) wb;
		js.executeScript("arguments[0].scrollIntoView(true)", we1);
		System.out.println("Step 3. Scroll the Window");
		Select select = new Select(we1);
		List<WebElement> ls = select.getOptions();
		
		System.out.println("Step 4.How Many option we have to select a value");
		System.out.println(ls.size());
		System.out.println("Step 5.List of option that we can select");
		for (WebElement element : ls) {
			System.out.print(element.getText() + " ");
		}
		System.out.println();
		System.out.println("Step 6.Check weather it is Multiple Select");
		System.out.println(select.isMultiple());	
		System.out.println("Step 7.Now Select odd Value-1,3 and 5");
		select.selectByIndex(3);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("Step 8.Print the Selected Value using method getFirstSelectedOption and.getAllSelectedOptions  -");
		WebElement ab = select.getFirstSelectedOption();
		System.out.println("Value we retrive using getFirstSelectedOption -: "+ "\n"+ ab.getText());
	
		List<WebElement> ab1 = select.getAllSelectedOptions();
		System.out.println("Value we retieve using getAllSelectedOptions -:");
		for (WebElement element : ab1) {
			System.out.print(element.getText() + " ");
		}
		System.out.println();
		System.out.println("Step 9 Close the broswer");
		wb.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		 new CheckingDropBoxAssignment3().checkingSingleSelectDropDown();
		 //new CheckingDropBoxAssignment3().checkingMultiSelectDropDown();
	}
}
