package gauravGarg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiveTestCaseAssignment1 {

	void positiveCase() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("1. Url Loaded");
		wb.findElement(By.id("registration2")).click();
		System.out.println("2. Click n registeration Tab");
		Thread.sleep(2000);
		wb.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("ram");
		System.out.println("3. Put a value at username Sign in");
		wb.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("shyam9999");
		System.out.println("4. Put a value at password");
		// wb.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("shya");[Password
		// is less than 8 doing Interupted Exception]
		wb.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("5. Put a value at password");
		Alert al = wb.switchTo().alert();
		String actualText = al.getText();
		String expected = "Success!";
		if (actualText.equals(expected)) {
			System.out.println("6.Success Positive Test Case");
		} else {
			System.out.println("6.Failed Negative Test Case");
		}
		al.accept();
		wb.quit();
		System.out.println("7.Program Quit");
	}

	void negativeCase() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("1. Url Loaded");
		wb.findElement(By.id("registration2")).click();
		System.out.println("2. Click n registeration Tab");
		Thread.sleep(2000);
		wb.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("ram");
		System.out.println("3. Put a value at username Sign in");
		wb.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("shu");
		System.out.println("4. Put a value at password");
		// wb.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("shya");[Password
		// is less than 8 doing Interupted Exception]
		wb.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("5. Put a value at password");
		Alert al = wb.switchTo().alert();
		String actualText = al.getText();
		String expected = "Success!";
		if (actualText.equals(expected)) {
			System.out.println("6.Success Positive Test Case");
		} else {
			System.out.println("6.Failed Negative Test Case");
		}
		al.accept();
		wb.quit();
		System.out.println("7.Program Quit");
	}

	void BasicELementTab() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("1. Url Loaded");
		wb.findElement(By.id("basicelements")).click();
		System.out.println("2. Click on Element Tab");
		Thread.sleep(2000);
		String firstName = "Gaurav";
		String lastName = "Gaurav";
		String company = "TATA CONSULTACY SERVICE";
		wb.findElement(By.xpath("//input[@id=\"UserFirstName\"]")).sendKeys(firstName);
		System.out.println("3. Put a value at FirstName");
		wb.findElement(By.xpath("//input[@id=\"UserLastName\"]")).sendKeys(lastName);
		System.out.println("4. Put a value at LastName");
		wb.findElement(By.xpath("//input[@id=\"UserCompanyName\"]")).sendKeys(company);
		System.out.println("5. Put a value at user Company");
		wb.findElement(By.xpath("//button[@onclick ='myFunctionPopUp()'] ")).click();
		System.out.println("6. Submit a form");
		Alert al = wb.switchTo().alert();
		String actualText = al.getText();
		// String expected="Gaurav and Garg and TATA CONSULTACY SERVICE";
		String expected = firstName + " and " + lastName + " and " + company;
		if (expected.equals(actualText)) {
			System.out.println("7. Alert is ok");
		} else {
			System.out.println("7. Alert is not ok");
		}
		al.accept();
		wb.quit();
		System.out.println("8.Quit the Browser ");
	}

	void BasicFormsTab() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("1. Url Loaded");
		wb.findElement(By.id("basicelements")).click();
		System.out.println("2. Click on Element Tab");
		Thread.sleep(2000);
		wb.findElement(By.xpath("//input[@name='emailId']")).sendKeys("gauravgarg9136@gmail.com");
		System.out.println("3. Put a gmail id on browser");
		wb.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Gaurav913");
		System.out.println("4. Put a passwod on browser");
		// wb.findElement(By.xpath("//div[@name ='secondSegment']//input[@type
		// ='checkbox']")).click();
		wb.findElement(By.xpath("//div[@id ='firstRow']/div[2]/section/div/div[4]/label/input")).click();
		System.out.println("4. Click on the checkbox  browser");
		wb.findElement(By.xpath("//button[@onclick ='myFunction()'] ")).click();
		System.out.println("5. Button  click");
		Alert al = wb.switchTo().alert();

		String actualText = al.getText();
		String expected = "You successfully clicked on it";

		if (expected.equals(actualText)) {
			System.out.println("6.Successfully Login");
		} else {
			System.out.println("6.Successfully not Login");
		}
		al.accept();
		wb.quit();
		System.out.println("7. Quit Browser ");
	}

	void checkingAlertBox() throws InterruptedException {
		WebDriver wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://automationbykrishna.com");
		System.out.println("1. Url Loaded");
		wb.findElement(By.id("basicelements")).click();
		System.out.println("2. Click on Element Tab");
		Thread.sleep(2000);
		boolean b = wb.findElement(By.xpath("//button[@id='javascriptAlert']")).isDisplayed();
//		System.out.print(b);
//		wb.findElement(By.xpath("//button[@id='javascriptAlert']")).click(); 
		// 1st way to achive
		JavascriptExecutor js = (JavascriptExecutor) wb;
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println("3. Scroll the Window");
		wb.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("4. Button Submit");
		/* 2nd way to achive
		WebElement wb1 = wb.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor je = (JavascriptExecutor) wb;
		je.executeScript("arguments[0].scrollIntoView(true)", wb1);
		Thread.sleep(2000);
		wb.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		*/
		wb.quit();
		System.out.println("5. Quit Browser");
	}

	public static void main(String[] args) throws InterruptedException {
		// new FiveTestCaseAssignment1().positiveCase();
		// new FiveTestCaseAssignment1().negativeCase();
		// new FiveTestCaseAssignment1().BasicELementTab();
		// new FiveTestCaseAssignment1().BasicFormsTab();
		   new FiveTestCaseAssignment1().checkingAlertBox();
	}
}
