/*3. Alert Demo
 *4. Basic Forms
 *5. Alert Button
 */
package rupaliUmagol;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basicinfo {
	WebDriver driver;

	void getBrowser() {
		System.out.println("STEP : Open WebDriver");
		driver = new ChromeDriver();
		System.out.println("STEP : Maximize Browser");
		driver.manage().window().maximize();

		System.out.println("STEP : launch url");
		driver.get("http://automationbykrishna.com");
	}

	void getAlertDemo() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Assign the values to Elements");
		String FirstName = "Rupali";
		String LastName = "Umagol";
		String UserCompanyName = "Techno";

		System.out.println("STEP : Click on Basic Elements Tab");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP : Wait for 2 seconds to load the page");
		Thread.sleep(2000);

		System.out.println("STEP : Enter FirstName");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(FirstName);

		System.out.println("STEP : Enter LastName");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(LastName);

		System.out.println("STEP : Enter Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(UserCompanyName);

		System.out.println("STEP : Click on Submit");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println("VERIFY : Validate the Alert Message");
		Alert alert = driver.switchTo().alert();
		String ExpectedText = FirstName + " and " + LastName + " and " + UserCompanyName;

		String actualText = alert.getText();
		if (actualText.equals(ExpectedText)) {
			System.out.println("Test case passed !");
		} else
			System.out.println("Test case failed !");

		System.out.println("STEP : Accept the Alert");
		alert.accept();

		System.out.println("STEP : Close Browser");
		driver.quit();
	}

	void getBasicForms() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Click on Basic Element Tab");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP : Wait for 2 second");
		Thread.sleep(2000);

		System.out.println("STEP : Enter Email Id");
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("rupali.umagol@gmail.com");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("123456789");

		System.out.println("STEP : Click on CheckBox");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		System.out.println("STEP : Click on Submit");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("VERIFY : Validate the Alert Message");
		Alert alert = driver.switchTo().alert();
		String ExpectedText = "You successfully clicked on it";

		String actualText = alert.getText();
		if (actualText.equals(ExpectedText)) {
			System.out.println("Test case passed !");
		} else
			System.out.println("Test case failed !");

		System.out.println("STEP : Accept the Alert");
		alert.accept();

		System.out.println("STEP : Close Browser");
		driver.quit();

	}

	void getAlertButton() throws InterruptedException {
		getBrowser();

		System.out.println("STEP : Click on Basic Element Tab");
		driver.findElement(By.id("basicelements")).click();

		System.out.println("STEP : Wait for 2 second");
		Thread.sleep(2000);

		System.out.println("STEP : Scroll page till Element is Displayed");
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		System.out.println("STEP : Click on Alert Button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("VERIFY : Validate the Alert Message");
		Alert alert = driver.switchTo().alert();
		String ExpectedText = "You must be TechnoCredits student!!";
		String ActualText = alert.getText();
		if (ActualText.equals(ExpectedText)) {
			System.out.println("Test Passed");
		} else
			System.err.println("Test Failed");

		System.out.println("STEP : Accept the Alert");
		alert.accept();

		System.out.println("STEP : Close Browser");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		Basicinfo basicinfo = new Basicinfo();
		System.out.println("3. Alert Demo tab : ");
		basicinfo.getAlertDemo();

		System.out.println("4. BASIC FORMS : ");
		basicinfo.getBasicForms();

		System.out.println("5. Alert Button : ");
		basicinfo.getAlertButton();
	}
}
