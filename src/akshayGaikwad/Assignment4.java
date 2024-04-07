package akshayGaikwad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	WebDriver driver;
	WebElement regstrionBtn;
	WebElement fullNameEle;
	WebElement emailaddresEle;
	WebElement otheraddEle;
	WebElement cityEle;
	WebElement companyEle;
	WebElement usernameEle;
	WebElement passEle;
	WebElement rePassEle;
	WebElement checkBox;

	void setup() {
		System.out.println("STEP : Launch browser and hit automationbykrishna");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("registration2")).click();

		System.out.println("STEP - Find out all elements on registration form");
		fullNameEle = driver.findElement(By.xpath("//input[@id='fullName']"));
		emailaddresEle = driver.findElement(By.xpath("//input[@id='address']"));
		otheraddEle = driver.findElement(By.xpath("//input[@id='useremail']"));
		cityEle = driver.findElement(By.xpath("//input[@id='usercity']"));
		companyEle = driver.findElement(By.xpath("//input[@id='organization']"));
		usernameEle = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		passEle = driver.findElement(By.xpath("//input[@id='passwordReg']"));
		rePassEle = driver.findElement(By.xpath("//input[@id='repasswordReg']"));
		checkBox = driver.findElement(By.xpath("//input[@id='signupAgreement']"));
		regstrionBtn = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
	}

	void verifyAlertText(String expecStr, String testCase) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		if (text.equals(expecStr)) {
			System.out.println("VERIFY : " + testCase + " is Passed");
		} else {
			System.out.println("VERIFY : " + testCase + " is Failed");
		}
		alert.accept();
	}

	void successCase() {
		System.out.println("STEP : Enter Full name");
		fullNameEle.sendKeys("Akshay Gaikwad");

		System.out.println("STEP : Enter emailid name");
		emailaddresEle.sendKeys("abcd123@gmail.com");

		System.out.println("STEP : Enter another emailid");
		otheraddEle.sendKeys("xyz123@gmail.com");

		System.out.println("STEP : Enter City name");
		cityEle.sendKeys("Pune");

		System.out.println("STEP : Enter Company name");
		companyEle.sendKeys("Dassault");

		System.out.println("STEP : Enter Username");
		usernameEle.sendKeys("Akshay18");

		System.out.println("STEP : Enter Password");
		passEle.sendKeys("123456");

		System.out.println("STEP : Reenter Password");
		rePassEle.sendKeys("123456");

		JavascriptExecutor je = (JavascriptExecutor) driver;

		je.executeScript("arguments[0].scrollIntoView(true)", checkBox);
		System.out.println("STEP : Checking checkbox");
		checkBox.click();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Success", "Success Registraation");
	}

	void fullNameBlank() {
		String fullName = fullNameEle.getAttribute("value");
		fullNameEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Full name can't be blank", "Full Name blank alert");

		System.out.println("STEP : Enter Full name again");
		fullNameEle.sendKeys(fullName);
	}

	void emailBlank() {
		String email = emailaddresEle.getAttribute("value");
		emailaddresEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("address cannot be blank", "Email blank alert");

		System.out.println("STEP : Enter Email again");
		emailaddresEle.sendKeys(email);
	}

	void otheraddBlank() {
		String email = otheraddEle.getAttribute("value");
		otheraddEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Please enter email id", "Other Email blank alert");

		System.out.println("STEP : Enter other Email again");
		otheraddEle.sendKeys(email);
	}

	void cityNameBlank() {
		String city = cityEle.getAttribute("value");
		cityEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Please enter City", "City name blank alert");

		System.out.println("STEP : Enter City name again");
		cityEle.sendKeys(city);
	}

	void companyBlank() {
		String company = companyEle.getAttribute("value");
		companyEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Please enter your current organization", "Company name blank alert");

		System.out.println("STEP : Enter company again");
		companyEle.sendKeys(company);
	}

	void userNameBlank() {
		String userName = usernameEle.getAttribute("value");
		usernameEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Username is mandatory field.", "Username blank alert");

		System.out.println("STEP : Enter Username again");
		usernameEle.sendKeys(userName);
	}

	void shortUserName() {
		String userName = usernameEle.getAttribute("value");
		usernameEle.clear();
		usernameEle.sendKeys("aksh");
		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Username length should be greater then 5 characters.", "Username is short alert");

		System.out.println("STEP : Enter Username again");
		usernameEle.clear();
		usernameEle.sendKeys(userName);
	}

	void passwordBlank() {
		String password = passEle.getAttribute("value");
		passEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("password is mandatory field.", "Password blank alert");

		System.out.println("STEP : Enter Password again");
		passEle.sendKeys(password);
	}

	void shortPassword() {
		String password = passEle.getAttribute("value");
		passEle.clear();
		passEle.sendKeys("123");

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("password length should be greater then 5 characters.", "Password short alert");

		System.out.println("STEP : Enter Password again");
		passEle.clear();
		passEle.sendKeys(password);
	}

	void reEnterPassBlank() {
		String password = rePassEle.getAttribute("value");
		rePassEle.clear();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("please reenter password", "Reenter blank alert");

		System.out.println("STEP : Enter Password again");
		rePassEle.sendKeys(password);
	}

	void reEnterPassWrong() {
		String password = rePassEle.getAttribute("value");
		rePassEle.clear();
		rePassEle.sendKeys("789456");
		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("retype password donot match.", "Reenter password wrong alert");

		System.out.println("STEP : Enter Password again");
		rePassEle.clear();
		rePassEle.sendKeys(password);
	}

	void uncheckAlert() {
		checkBox.click();

		System.out.println("STEP : Click Registration");
		regstrionBtn.click();
		verifyAlertText("Please agree to terms of service and privacy policy", "CheckBox unchecked alert");

		checkBox.click();
	}

	void closeBrowwer() {
		System.out.println("STEP : Close the browser");
		driver.quit();
	}

	public static void main(String[] args) {
		Assignment4 object = new Assignment4();
		object.setup();
		System.out.println("-------------------------------------------------------------------");
		object.successCase();
		System.out.println("-------------------------------------------------------------------");
		object.fullNameBlank();
		System.out.println("-------------------------------------------------------------------");
		object.emailBlank();
		System.out.println("-------------------------------------------------------------------");
		object.otheraddBlank();
		System.out.println("-------------------------------------------------------------------");
		object.cityNameBlank();
		System.out.println("-------------------------------------------------------------------");
		object.companyBlank();
		System.out.println("-------------------------------------------------------------------");
		object.userNameBlank();
		System.out.println("-------------------------------------------------------------------");
		object.shortUserName();
		System.out.println("-------------------------------------------------------------------");
		object.passwordBlank();
		System.out.println("-------------------------------------------------------------------");
		object.shortPassword();
		System.out.println("-------------------------------------------------------------------");
		object.reEnterPassBlank();
		System.out.println("-------------------------------------------------------------------");
		object.reEnterPassWrong();
		System.out.println("-------------------------------------------------------------------");
		object.uncheckAlert();
		System.out.println("-------------------------------------------------------------------");
		object.closeBrowwer();
	}
}
