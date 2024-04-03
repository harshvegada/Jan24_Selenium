/*NoAlertPresentException- for not javascriptalert
 */
package sasmitaSahu;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Notjavascriptalert {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP-Lunch the chrome driver");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP-hit url");
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		System.out.println("STEP-Click on basicelemts");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		System.out.println("STEP-Scroll down the page and click on scroll and  form in modal");
		WebElement alertElement = driver
				.findElement(By.xpath("//div[@class='panel-body'][1]/a[@data-toggle='modal'][1]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", alertElement);
		driver.findElement(By.xpath("//div[@class='panel-body'][1]/a[@data-toggle='modal'][1]")).click();
		System.out.println("Step-Switch to alert message window");
		Alert alert = driver.switchTo().alert();
	}

}