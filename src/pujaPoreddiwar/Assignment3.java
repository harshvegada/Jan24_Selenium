package pujaPoreddiwar;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	WebDriver driver;

	void selectSingleValue() throws InterruptedException {
		driver = new ChromeDriver();

		System.out.println("STEP: Url Loaded and Maximized");
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: Click on Element Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(3000);
//-------------List 1 implementation--------------------------

		System.out.println("=============================================");
		System.out.println("STEP: Scroll the Window till select drop down");
		WebElement selectDropDown = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectDropDown);

		Select selectValueFromDropDown = new Select(selectDropDown);

		System.out.println("VERIFY: Check whether List 1 is Multiple Select drop down ?");
		System.out.println(selectValueFromDropDown.isMultiple());

		System.out.println("STEP: Selected option is");
		selectValueFromDropDown.selectByVisibleText("3");

		List<WebElement> selectedOptionEle = selectValueFromDropDown.getOptions();
		String selectedEle = "";
		for (WebElement e : selectedOptionEle) {
			if (e.isSelected()) {
				System.out.println(e.getText());
				selectedEle = e.getText();
			}
		}
		System.out.println("VERIFY: Selected drop down value from list 1 is same as expected");
		if (selectedEle.equals("3")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
//-------------List 2 implementation--------------------------

		System.out.println("=============================================");
		WebElement selectDropDown2 = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", selectDropDown2);
		Select selectValueFromDropDown2 = new Select(selectDropDown2);

		System.out.println("VERIFY: Check whether List 2 is Multiple Select drop down ?");
		System.out.println(selectValueFromDropDown2.isMultiple());

		System.out.println("STEP: Check how many option we can select from List 2");
		List<WebElement> selectOptionEle = selectValueFromDropDown.getOptions();
		System.out.println(selectOptionEle.size());

		System.out.println("STEP: List of options that we can select from list 2 are: ");
		for (WebElement e : selectOptionEle) {
			System.out.println(e.getText());
		}

		selectValueFromDropDown2.selectByVisibleText("1");
		selectValueFromDropDown2.selectByVisibleText("3");
		selectValueFromDropDown2.selectByVisibleText("5");

		System.out.println("STEP: 1st Selected option is : ");
		WebElement selectedListItems = selectValueFromDropDown2.getFirstSelectedOption();
		System.out.println(selectedListItems.getText());

		// driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment3().selectSingleValue();
	}
}
