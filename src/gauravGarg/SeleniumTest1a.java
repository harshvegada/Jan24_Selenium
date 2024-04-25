/*
 * TC 1 : Navigate to http://uitestingplayground.com/visibility, click on the Hide button and ensure the following statements are true:

The button labeled Opacity 0 should not be displayed
The button labeled Removed should not be displayed
The button labeled Visibility Hidden should not be displayed
The button labeled Display None should not be displayed
 */

package gauravGarg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest1a {

	WebDriver wb;
    
	@BeforeMethod
	void lauchBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://uitestingplayground.com/visibility");
		System.out.println("STEP 1- Hit the url.");
	}
	
	void isDisplayedButtion(String buttonName)
	{
		try
		{
			WebElement a= wb.findElement(By.xpath("//button[@id='"+buttonName+"']"));
			System.out.println(a.isDisplayed());
		}catch(Exception e)
		{
			System.out.println("false");
		}
			
	}
	@Test
	void SelenuimTest1()
	{
		isDisplayedButtion("hideButton");
		isDisplayedButtion("transparentButton");
		isDisplayedButtion("removedButton");
		isDisplayedButtion("invisibleButton");
		isDisplayedButtion("notdisplayedButton");
		System.out.println("STEP 2- Checking the visibility of all button.");
		wb.findElement(By.xpath("//button[@id='hideButton']")).click();
		System.out.println("STEP 2- Click on Hide button");
		isDisplayedButtion("hideButton");
		isDisplayedButtion("transparentButton");
		isDisplayedButtion("removedButton");
		isDisplayedButtion("invisibleButton");
		isDisplayedButtion("notdisplayedButton");
		System.out.println("STEP 4- Checking the visibility of all button.");
	}
	//button[@id='hideButton']
	//button[@id='transparentButton']
	//button[@id='removedButton']
	//button[@id='invisibleButton']
	//button[@id='notdisplayedButton']
}
