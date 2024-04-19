package shramikaVaidya;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment11 {
		
	WebDriver driver;
		
		@BeforeClass
		void openBrowser() {
			System.out.println("STEP : Launch Brouser and Hit url");
			driver = new ChromeDriver();
			driver.get("http://automationbykrishna.com/index.html#");
			System.out.println("Step: click on Registration");
			driver.findElement(By.linkText("Registration")).click();
			driver.manage().window().maximize();
		}
		
		
		@Test(dataProvider = "loginDataProvider")
		void verifyLoginWithExcelData(String name, String password, String alertText) throws InterruptedException {
			
			System.out.println(name+" "+password+" "+alertText);
			driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).clear();
			driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).clear();

			driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys(name);
			driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys(password);

			System.out.println("STEP : Click on submit button");
			driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();

			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println(text);
			alert.accept();
			//Thread.sleep(2000);
			Assert.assertEquals(text, alertText);

			System.out.println("Test case Passed");
		}
		
		@DataProvider(name="loginDataProvider")
		public Object loginDataProvider() {
			Object[][] data = ExcelOperations.readData(".\\data1.XLSX", "Logindata");
			return data;
		}
		
	}



