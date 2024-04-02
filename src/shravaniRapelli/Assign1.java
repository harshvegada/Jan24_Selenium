package shravaniRapelli;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Assign1 {
	
	void testCase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("########Test Case 1########");
		System.out.println("STEP: Launch the browser");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP : Clicking on registeration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP : Sending text into username");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("shravani");
		System.out.println("STEP : Sending text into password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Shravani123");
		System.out.println("STEP : Clicking on submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		System.out.println("STEP : Get text from Alert");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("VERIFY : Alert message is same as expected message ");
		if(actualText.equals(expectedText)) {
			System.out.println("TestCase Pass");
		}
		else {
			System.out.println("TextCase Fail");
		}
		alert.accept();
		driver.quit();
	}
	
	void testCase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("########Test Case 2########");
		System.out.println("STEP: Launch the browser");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP : Clicking on registeration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP : Sending text into username");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("shravani");
		System.out.println("STEP : Sending text into password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Shrav");
		System.out.println("STEP : Clicking on submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		System.out.println("STEP : Get text from Alert");
		String expectedText = "Success!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("VERIFY : Alert message is same as expected message ");
		if(actualText.equals(expectedText)) {
			System.out.println("TestCase Pass");
		}
		else {
			System.out.println("TextCase Fail");
		}
		alert.accept();
		driver.quit();
	}

	void testCase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("########Test Case 3########");
		System.out.println("STEP: Launch the browser");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP : Clicking on Basic elements");
		System.out.println("Alert Demo form");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP : Sending User FirstName");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Shravani");
		System.out.println("STEP : Sending User LastName");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Rapelli");
		System.out.println("STEP : Sending User CompanyName");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Wipro");
		System.out.println("STEP : Clicking on submit button");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		System.out.println("handle alert text");
		String firstName = "Shravani";
		String lastName = "Rapelli";
		String companyName = "Wipro";
		String expectedText = firstName +" and "+ lastName +" and "+ companyName;
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("VERIFY : Alert message is same as expected message");
		if(actualText.equals(expectedText)) {
			System.out.println("TestCase Pass");
		}else
			System.out.println("TestCase Fail");
		alert.accept();
		driver.quit();
	}
	
	void testCase4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("########Test Case 4########");
		System.out.println("STEP: Launch the browser");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP : Clicking on Basic elements");
		System.out.println("Basic forms");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP : Sending email address");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("shravani@gmail.com");
		System.out.println("STEP : Sending Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Shravani123");
		System.out.println("STEP : Select Checkbox");
		driver.findElement(By.xpath("//div[@name='secondSegment']//input[@type='checkbox']")).click();
		System.out.println("STEP : Clicking on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Thread.sleep(2000);
		System.out.println("handle alert text");
		String expectedText = "You successfully clicked on it";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("VERIFY : Alert message is same as expected message");
		if(actualText.equals(expectedText)) {
			System.out.println("TestCase Pass");
		}else
			System.out.println("TestCase Fail");
		alert.accept();
		driver.quit();
	}
	
	void testCase5() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.out.println("########Test Case 5########");
		System.out.println("STEP: Launch the browser");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("STEP : Clicking on Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("STEP: Clicking on alert button");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		System.out.println("handle alert text");
		String expectedText = "You must be TechnoCredits student!!";
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("VERIFY : Alert message is same as expected message");
		if(actualText.equals(expectedText)) {
			System.out.println("TestCase Pass");
		}else
			System.out.println("TestCase Fail");
		alert.accept();
		driver.quit();

	}
	public static void main(String[] args) throws InterruptedException{
		Assign1 assgn1 = new Assign1();	
		assgn1.testCase1();
		assgn1.testCase2();
		assgn1.testCase3();
		assgn1.testCase4();
		assgn1.testCase5();
	}

}


