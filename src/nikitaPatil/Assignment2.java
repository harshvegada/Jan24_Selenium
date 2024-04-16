package nikitaPatil;


	
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Assignment2 {

		WebDriver driver = new ChromeDriver();

		Assignment2() throws InterruptedException{
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();

			System.out.println("STEP : Click on create new account");
			driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
			Thread.sleep(2000);

			System.out.println("STEP : Enter First Name");
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nikita");

			System.out.println("STEP : Enter Surname");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Patil");

			System.out.println("STEP : Enter emailID");
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("nikita@gmail.com");

			System.out.println("STEP : Enter Password");
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("12345789");

			System.out.println("STEP : Enter Date of Birth");
			Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
			daySelect.selectByVisibleText("19");
			List<WebElement> dayList = daySelect.getOptions();

			for(WebElement e : dayList) {
				if(e.isSelected()) {
					System.out.println(e.getText() + " is selected Date");
				}
			}

			System.out.println("STEP : Enter Month of Birth");
			Select monthSelect  = new Select(driver.findElement(By.name("birthday_month")));
			monthSelect.selectByVisibleText("Jan");
			List<WebElement> monthList = monthSelect.getOptions();

			for(WebElement e : monthList) {
				if(e.isSelected()) {
					System.out.println(e.getText() + " is selected as Month");
				}
			}

			System.out.println("STEP : Enter Month of Birth");
			Select yearSelect  = new Select(driver.findElement(By.name("birthday_year")));
			yearSelect.selectByVisibleText("2000");
			List<WebElement> yearList = yearSelect.getOptions();

			for(WebElement e : yearList) {
				if(e.isSelected()) {
					System.out.println(e.getText() + " is selected as Year");
				}
			}

			System.out.println("STEP : Select gender");
			driver.findElement(By.xpath("//input[@value='1']")).click();

			Thread.sleep(5000);

			driver.quit();
		}

		public static void main(String[] args) throws Exception {
			Assignment2 a = new Assignment2(); 

             
	}
	}

