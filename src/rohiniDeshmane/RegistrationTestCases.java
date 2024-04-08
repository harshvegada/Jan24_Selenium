package rohiniDeshmane;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTestCases {

	WebDriver webDriver;
	WebElement registrationBtn,agreementCheckbox;
	WebElement fullNameElement, address, mailId, city, companyName, userName, password, retypePassword;
	
	void setUp() {
		System.out.println("STEP - Launch chrome browser and hit automationByKrishna");
		webDriver = new ChromeDriver();
		webDriver.get("http://automationbykrishna.com");
		
		System.out.println("STEP - Click on Registration page");
		webDriver.findElement(By.xpath("//a[@id='registration2']")).click();
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Find all the elements of registration page");
		fullNameElement = webDriver.findElement(By.xpath("//input[@id='fullName']"));
		address = webDriver.findElement(By.xpath("//input[@id='address']"));
		mailId = webDriver.findElement(By.xpath("//input[@id='useremail']"));
		city = webDriver.findElement(By.xpath("//input[@id='usercity']"));
		companyName = webDriver.findElement(By.xpath("//input[@id='organization']"));
		userName = webDriver.findElement(By.xpath("//input[@id='usernameReg']"));
		password = webDriver.findElement(By.xpath("//input[@id='passwordReg']"));
		retypePassword = webDriver.findElement(By.xpath("//input[@id='repasswordReg']"));
		agreementCheckbox = webDriver.findElement(By.xpath("//input[@id='signupAgreement']"));
		registrationBtn = webDriver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
	}
	
	void verifyAlertText(String expectedText, String cName) {
		Alert alert = webDriver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println("VERIFY : alert text");
		System.out.println(actualText);
		if(actualText.equals(expectedText))
			System.out.println(cName+" Passed\n");
		else
			System.out.println(cName + " Failed\n");
		alert.accept();
	}
	
	void pageScroll(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	//TestCase1 - Verify alert message should be "success" when all the value provided for registration form fields as expected
	void validateAllFields() {
		System.out.println("STEP : Enter full name");
		fullNameElement.sendKeys("Rohini Deshmane");
		
		System.out.println("STEP : Enter Address");
		address.sendKeys("Royal Castle");
		
		System.out.println("STEP : Enter Mail id");
		mailId.sendKeys("abc@gmail.com");
		
		System.out.println("STEP : Enter city name");
		city.sendKeys("Pune");
		
		System.out.println("STEP : Enter company name");
		companyName.sendKeys("TCS");
		
		System.out.println("STEP : Enter user name");
		userName.sendKeys("rdeshmane");
		
		System.out.println("STEP : Enter Password");
		password.sendKeys("123456789");
		
		System.out.println("STEP : Retype password");
		retypePassword.sendKeys("123456789");
		
		System.out.println("STEP : Click on Checkbox");
		pageScroll(agreementCheckbox);
		agreementCheckbox.click();
		
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("STEP : Enter on Registration button");
		registrationBtn.click();
		verifyAlertText("Success", "Test Case 1 : ");
	}
	
	//TestCase2 - Verify alert message for name when name value not provided
	void validateFullName() {
		String expectedAlertText = "Full name can't be blank";
		String originalName = fullNameElement.getAttribute("value");
		System.out.println("STEP : Clear full name field");
		fullNameElement.clear();
		System.out.println("STEP : Click on registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedAlertText);
		verifyAlertText(expectedAlertText, "Test Case 2 : ");
		fullNameElement.sendKeys(originalName);
	}
	
	//TestCase3 - Verify alert message for address when address value not provided but value provided for above fields
	void validateAddress() {
		String expectedText = "address cannot be blank";
		String originalText = address.getAttribute("value");
		System.out.println("STEP : Clear address field");
		address.clear();
		
		System.out.println("STEP : Click on registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 3 : ");
		address.sendKeys(originalText);
	}
	
	//TestCase4 - Verify alert message for email when email not provided but value provided for above fields
	void validateEmail() {
		String expectedText = "Please enter email id";
		String originalText = mailId.getAttribute("value");
		System.out.println("STEP : Clear email id field");
		mailId.clear();
		
		System.out.println("STEP : Click on registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 4 : ");
		mailId.sendKeys(originalText);
	}
	
	//TestCase5 - Verify alert message for correct email when wrong email provided but value provided for above fields
	void verifyEmail() {
		String expectedText = "Please use correct email format";
		String originalText = mailId.getAttribute("value");
		System.out.println("STEP : Clear email id field");
		mailId.clear();
		
		System.out.println("STEP : Enter email id");
		mailId.sendKeys("Rohini");
		
		System.out.println("STEP : Click on Registration Button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 5 : ");
		mailId.sendKeys(originalText);
	}
	
	//TestCase6 - Verify alert message for city when city value not provided but value provided for above fields
	void validateCity() {
		String expectedText = "Please enter City";
		String originalText = city.getAttribute("value");
		
		System.out.println("STEP : Clear City field");
		city.clear();
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg Popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 6 : ");
		city.sendKeys(originalText);
	}
	
	//TestCase7 - Verify alert message for organization name when organization name value not provided but value provided for above fields
	void validateCompanyName() {
		String expectedText = "Please enter your current organization";
		String originalText = companyName.getAttribute("value");
		
		System.out.println("STEP : Clear company name");
		companyName.clear();
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 7 : ");
		companyName.sendKeys(originalText);
	}
	
	//TestCase8 - Verify alert message for username when username value not provided but value provided for above fields
	void validateUserName() {
		String expectedText = "Username is mandatory field.";
		String originalText = userName.getAttribute("value");
		
		System.out.println("STEP : Clear user name");
		userName.clear();
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 8 : ");
		userName.sendKeys(originalText);
	}
	
	//TestCase9 - Verify alert message for username less then 5 charater when username lenght is less then 5 but value provided for above fields
	void validateUserNameWithLength() {
		String expectedText = "Username length should be greater then 5 characters.";
		String originalText = userName.getAttribute("value");
		
		System.out.println("STEP : Clear user name");
		userName.clear();
		
		System.out.println("STEP : Enter User Name");
		userName.sendKeys("abc");
		
		System.out.println("STEP : Get user name input tag value");
		String enteredText = userName.getAttribute("value");
		
		System.out.println("VERIFY : Check entered username length");
		if(enteredText.length() < 5) {
			System.out.println("UserName length is less than 5");
		}
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 9 : ");
		
		userName.sendKeys(originalText);
	}
	
	//TestCase10 - Verify alert message for password when password value not provided but value provided for above fields
	void validatePassword() {
		String expectedText = "password is mandatory field.";
		String originalText = password.getAttribute("value");
		
		System.out.println("STEP : Clear Password");
		password.clear();
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 10 : ");
		password.sendKeys(originalText);
	}
	
	//TestCase11 - Verify alert message for password less then 5 character when password length is less then 5 but value provided for above fields
	void validatePasswordWithLength() {
		String expectedText = "password length should be greater then 5 characters.";
		String originalText = password.getAttribute("value");
		
		System.out.println("STEP : Clear Password");
		password.clear();
		
		System.out.println("STEP : Enter Password");
		password.sendKeys("abcd");
		
		System.out.println("STEP : Get Password input value");
		String enteredText = password.getAttribute("value");
		
		System.out.println("VERIFY : Check entered password length");
		if(enteredText.length() < 5) {
			System.out.println("Password length is less than 5");
		}	
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 11 : ");
		password.sendKeys(originalText);
	}
	
	//TestCase12 - Verify alert message for re-password when re-password value not provided but value provided for above fields
	void validateReTypePassword() {
		String expectedText = "please reenter password";
		String originalText = retypePassword.getAttribute("value");
		
		System.out.println("STEP : Clear Password");
		retypePassword.clear();
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 12 : ");
		retypePassword.sendKeys(originalText);
	}
	
	//TestCase13 - Verify alert message for re-password when password and re-password are not matching but value provided for above fields
	void validateReTypePawwordWithLength() {
		String expectedText = "retype password donot match.";
		String originalText = password.getAttribute("value");
		
		System.out.println("STEP : Clear Password");
		retypePassword.clear();
		
		System.out.println("STEP : Re-type Password");
		retypePassword.sendKeys("12345678");
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("STEP : Alert msg popup");
		System.out.println(expectedText);
		verifyAlertText(expectedText, "Test Case 13 : ");
		retypePassword.clear();
		retypePassword.sendKeys(originalText);
	}
	
	//TestCase14 - Verify alert message for Team and condition when Team and condition checkbox is not selected but value provided for above fields
	void validateTermConditionCheckbox() {
		String expectedText = "Please agree to terms of service and privacy policy";
		agreementCheckbox.click();
		
		System.out.println("STEP : Check Term and Condtion CheckBox selected");
		boolean checkboxStatus =  agreementCheckbox.isSelected();
		
		System.out.println("STEP : Click on Registration button");
		pageScroll(registrationBtn);
		registrationBtn.click();
		
		System.out.println("VERIFY : Checkbox is selected or not");
		if(!checkboxStatus)
			verifyAlertText(expectedText, "Test Case 14 : ");
	}
	
	public static void main(String[] args) {
		RegistrationTestCases registrationTestCases = new RegistrationTestCases();
		registrationTestCases.setUp();
		registrationTestCases.validateAllFields();
		registrationTestCases.validateFullName();
		registrationTestCases.validateAddress();
		registrationTestCases.validateEmail();
		registrationTestCases.verifyEmail();
		registrationTestCases.validateCity();
		registrationTestCases.validateCompanyName();
		registrationTestCases.validateUserName();
		registrationTestCases.validateUserNameWithLength();
		registrationTestCases.validatePassword();
		registrationTestCases.validatePasswordWithLength();
		registrationTestCases.validateReTypePassword();
		registrationTestCases.validateReTypePawwordWithLength();
		registrationTestCases.validateTermConditionCheckbox();
	}
}
