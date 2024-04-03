package padmajaDeshmukh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KrishnaBasicElement {

	void alertDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Padmaja");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Deshukh");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("LTIMindtree");
		driver.findElement(By.xpath("//*[@id=\"firstRow\"]/div[1]/section/div/div[4]/button")).click();

		System.out.println("STEP : get text from alert");
		String expectedText = "Padmaja and Deshukh and LTIMindtree";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (actualText.equals(expectedText))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();
		driver.quit();

	}

	void basicForm() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("padmajadeshmukh1@gmail.com");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Deshukh");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("LTIMindtree");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("STEP : get text from alert");
		String expectedText = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();
		driver.quit();
	}

	void alert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		System.out.println("STEP : get text from alert");
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		if (actualText.equals(expectedText))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		alert.accept();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		KrishnaBasicElement krishna = new KrishnaBasicElement();
		// krishna.alertDemo();
		// krishna.basicForm();
		krishna.alert();

	}
}
