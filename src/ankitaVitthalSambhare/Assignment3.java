package ankitaVitthalSambhare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	WebDriver driver;

	void lunchURL() {
		driver = new ChromeDriver();
		System.out.println("Step1:- Launch URL in chorme");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("URL is sucessfully launch in the google chrome http://automationbykrishna.com/#");
		System.out.println("Step2:- Click on the Basic Element tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Sucessfully clicked on the basicelement tab");
	}

	void verifySingleSelectedDropDownAndSelectValue() throws InterruptedException {
		lunchURL();
		Thread.sleep(5000);
		System.out.println("Step3:- Scroll Down the window");
		WebElement WE = driver.findElement(By.xpath("//select[@class='form-control m-bot15']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", WE);
		System.out.println("Sucessfuly window scrolled down");

		System.out.println("Step4:- Verify Drop Down is multiSelected or not");
		Select select = new Select(WE);
		if (select.isMultiple()) {
			System.out.println("DropDown is multiSelected!!");
		} else {
			System.out.println("DropDown is not multiSelect!!");
		}

		System.out.println("Step5:- Compare the Selected and Actual value is same or differnet");

		select.selectByVisibleText("5");
		List<WebElement> getAllAvailableValuesFromDropDown = select.getOptions();
		String actualValue = "";
		String ExpectedValue = "5";
		for (WebElement webelement : getAllAvailableValuesFromDropDown) {

			if (webelement.isSelected()) {
				System.out.println(webelement.getText());
				actualValue = webelement.getText();
			}
		}

		if (actualValue.equals(ExpectedValue)) {
			System.out.println("Selected Value match!!");
		} else {
			System.out.println("Selected Value is not match");
		}
		System.out.println("Step6:- Closing the browser");

		driver.quit();
	}

	void VerifyDropDownIsMultiSelectedAndSelectedMultipleValue() throws InterruptedException {
		lunchURL();
		Thread.sleep(5000);
		WebElement WE1 = driver.findElement(By.xpath("//select[@class='form-control']"));

		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je1.executeScript("arguments[0].scrollIntoView(true)", WE1);
		System.out.println("Step3:- Verify drop Down is multi-Selected or not");
		Select select1 = new Select(WE1);
		if (select1.isMultiple()) {
			System.out.println("Drop Down Is MultiSelect!!");
		} else {
			System.out.println("Drop Down Is not Multi Selected");
		}

		select1.selectByVisibleText("1");
		select1.selectByVisibleText("3");
		select1.selectByVisibleText("5");
		List<WebElement> getAllAvailableValuesFromDropDown = select1.getOptions();
		System.out.println("Step4:- Print the count of avilable values in the Drop-Down ");
		System.out.println(getAllAvailableValuesFromDropDown.size());
		System.out.println(("Step5:- Print all the values avilable in the Drop-Down"));
		for (WebElement we : getAllAvailableValuesFromDropDown) {
			System.out.print(we.getText() + " ");
		}
		System.out.println();
		System.out.println("Step6:- Print selected values only");
		List<WebElement> selectedOptions = select1.getAllSelectedOptions();
		for (WebElement e : selectedOptions) {

			System.out.println(e.getText());
		}
		System.out.println("Step7:- Print 1st selected value");
		WebElement selectedListItems = select1.getFirstSelectedOption();
		System.out.println(selectedListItems.getText());
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment3 ass3 = new Assignment3();
		System.out.println("--------------------Test Case 1------------------------------");
		ass3.verifySingleSelectedDropDownAndSelectValue();
		System.out.println("--------------------Test Case 2------------------------------");
		ass3.VerifyDropDownIsMultiSelectedAndSelectedMultipleValue();
	}
}
