package shramikaVaidya;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgrammingTestcase1 {

	WebDriver wb;
	WebDriverWait wait;

	@BeforeMethod
	void lauchBrowser() {
		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://uitestingplayground.com/visibility");
		System.out.println("STEP 1- Hit the url.");
	}

	void isDisplayedButton(String buttonName) {
		try {
			WebElement button = wb.findElement(By.xpath("//button[@id='" + buttonName + "']"));
			System.out.println(button.isDisplayed());
		} catch (Exception e) {
			System.out.println("false");
		}

	}

	@Test
	void SelenuimTest1() {
		System.out.println("STEP :- Checking the visibility of all button.");
		wb.findElement(By.xpath("//button[@id='hideButton']")).click();
		System.out.println("STEP 1- Click on Hide button");

		isDisplayedButton("transparentButton");
		System.out.println("Verify:The button labeled Display should not be displayed");

		isDisplayedButton("removedButton");
		System.out.println("Verify:The button labeled Display should not be displayed");

		isDisplayedButton("invisibleButton");
		System.out.println("Verify:The button labeled Display should not be displayed");

		isDisplayedButton("notdisplayedButton");
		System.out.println("Verify:The button labeled Display should not be displayed");
	}

	@Test
	void Testcase2() {

		wb = new ChromeDriver();
		wb.manage().window().maximize();
		wb.get("http://uitestingplayground.com/progressbar");
		wait = new WebDriverWait(wb, Duration.ofSeconds(30));
		System.out.println("STEP 1- Hit the url");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='startButton']"))).click();
		System.out.println("STEP 2- Click on start Button.");

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='progressBar']"), "75%"));
		System.out.println("Verify :- wait until it reaches 75% and then click on the Stop button,");

		wb.findElement(By.xpath("//button[@id='stopButton']")).click();
		System.out.println("STEP 4- Click on stop Button.");

	}

	@AfterMethod
	void closeBrouser() {
		wb.quit();
	}
}
