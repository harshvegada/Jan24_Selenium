package hiralPurohit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sel_Assignment_3 {

	void toPerformCheckboxTesting() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP: launch the Browser");
		driver.manage().window().maximize();

		System.out.println("STEP: Hit the Url");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: click on basicElements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("STEP: Scroll the Window");
		WebElement element = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP: Select the Dropdown");
		Select selectDropDown = new Select(element);
		selectDropDown.selectByIndex(4);

		System.out.println("STEP: verify the Selected value");
		WebElement elements = selectDropDown.getFirstSelectedOption();
		String getElement = elements.getText();
		System.out.println(getElement);

		System.out.println("STEP: verify dropdown is multiSelected");
		System.out.println(selectDropDown.isMultiple());

		System.out.println("STEP: Close the Browser");
		driver.quit();
	}

	void toPerformMultipleCheckbox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP: launch the Browser");
		driver.manage().window().maximize();

		System.out.println("STEP: Hit the Url");
		driver.get("http://automationbykrishna.com");

		System.out.println("STEP: click on basicElements Tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		System.out.println("Step: Scroll thpage to the Element");
		WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP: select the dropdown");
		Select selectElement = new Select(element);

		System.out.println("STEP: print Number of elements in Dropdown");
		List<WebElement> listOfOption = selectElement.getOptions();
		System.out.println(listOfOption.size());

		System.out.println("STEP: Print the elements of DropDown");
		for (WebElement e : listOfOption) {
			System.out.print(e.getText() + " ");
		}
		System.out.println();

		System.out.println("STEP: Verify the the DropDown is MultiSelected");
		System.out.println(selectElement.isMultiple());

		System.out.println("STEP: Select odd value from dropdown");
		if (selectElement.isMultiple()) {
			for (int index = 0; index < selectElement.getOptions().size(); index++) {
				if (index % 2 == 0) {
					selectElement.selectByIndex(index);
				}
			}
		}

		System.out.println("STEP: Print the selected First value");
		WebElement elements = selectElement.getFirstSelectedOption();
		String getElement = elements.getText();
		System.out.println(getElement);

		System.out.println("Verify multiple selected value by printing");
		List<WebElement> listElement = selectElement.getAllSelectedOptions();
		for (WebElement e : listElement) {
			System.out.print(e.getText() + " ");
		}
		System.out.println();

		System.out.println("STEP: Close the Browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Sel_Assignment_3 selAss3 = new Sel_Assignment_3();
		System.out.println("TEST CASE1: Single Select DropDown");
		selAss3.toPerformCheckboxTesting();
		System.out.println("============================================");
		System.out.println("                                             ");
		System.out.println("TEST CASE2: Multiple Select DropDown");
		selAss3.toPerformMultipleCheckbox();
	}
}
