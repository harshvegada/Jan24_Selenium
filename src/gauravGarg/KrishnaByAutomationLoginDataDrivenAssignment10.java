package gauravGarg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KrishnaByAutomationLoginDataDrivenAssignment10 {

	WebDriver wb;
	@BeforeMethod
	void lauchBrowser()
	{
	    wb = new ChromeDriver();
		wb.manage().window().maximize();
		System.out.println("STEP 1 - Launch Chrome browser");
		wb.get("http://automationbykrishna.com");
		System.out.println("STEP 2 - Hit http://automationbykrishna.com");
	}
	
	@Test(dataProvider = "Login Detail using Array Creation")
	 void verifyLogin(String a, String b,String c)
	{
		WebDriverWait wait =new WebDriverWait(wb,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration2")));
		wb.findElement(By.id("registration2")).click();
		System.out.println("Step 3- Click n registeration Tab");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		wb.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(a);
		System.out.println("Step 4. Put a value at username Sign in");
		wb.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(b);
		System.out.println("Step 5. Put a value at password");
		wb.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step 6. Submit a Form");
		Alert al = wb.switchTo().alert();
		String actualText = al.getText();
		String expected = c;
		Assert.assertEquals(actualText, expected);
	}
	
	
	@Test(dataProvider = "Login Detail using Data Table")
	 void verifyLoginusingExcel(String a, String b,String c)
	{
		WebDriverWait wait =new WebDriverWait(wb,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration2")));
		wb.findElement(By.id("registration2")).click();
		System.out.println("Step 3- Click n registeration Tab");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		wb.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(a);
		System.out.println("Step 4. Put a value at username Sign in");
		wb.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(b);
		System.out.println("Step 5. Put a value at password");
		wb.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step 6. Submit a Form");
		Alert al = wb.switchTo().alert();
		String actualText = al.getText();
		String expected = c;
		Assert.assertEquals(actualText, expected);
	}
	@AfterMethod
	void closeBrowser()
	{
		wb.quit();
	}
	
	@DataProvider(name ="Login Detail using Array Creation")
	public String[][]  Data()
	{
		String[][] a=new String[3][3] ;
		a[0][0]="gaurav@gmail.com";
		a[0][1]="January@123";
	    a[0][2]="Success!";
	    
	    a[1][0]="gaurav@gmail.com";
		a[1][1]="Janu";
	    a[1][2]="Failed! please enter strong password";
	    
	    a[2][0]="gaurav@gmail.com";
		a[2][1]="Janu";
	    a[2][2]="Failed! please enter strong password";
	    
	    return a;
	}
	
	@DataProvider(name ="Login Detail using Data Table")
	public String[][]  DatausingTable() 
	{
		String[][] a=null;
		File file = new File("F:\\texchnocredit\\Java24_EliteQA_Automation\\src\\LoginDetail.xlsx");
        try {
        
			FileInputStream fs = new FileInputStream(file);
			Workbook wb=new XSSFWorkbook(fs);
			Sheet sheet=wb.getSheet("LoginData");
			int row=sheet.getLastRowNum();
			int column=sheet.getRow(0).getLastCellNum();
			System.out.println(row);
			System.out.println(column);
			a=new String[row][column] ;
			for(int i=1;i<=row;i++)
	        {
				for(int j=0;j<column;j++)
				{
			//		System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				 a[i-1][j ]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
	        	
	        }
			 for (int i = 0; i < a.length; i++) { //this equals to the row in our matrix.
		         for (int j = 0; j < a[i].length; j++) { //this equals to the column in each row.
		            System.out.print(a[i][j] + " ");
		         }
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return a;
	}
}
