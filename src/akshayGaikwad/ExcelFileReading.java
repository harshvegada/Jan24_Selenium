package akshayGaikwad;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileReading {
	
	static void getDataFromExcel() {
		String filePath = ".\\Data.xlsx";
		String sheetName = "LoginData";
		File file = new File(filePath);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);
			sheet.getRow(0).getCell(0).getStringCellValue();

			int row = sheet.getLastRowNum();
			int col = sheet.getRow(0).getLastCellNum();

			String[][] dataArr = new String[row][col];

			for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
				for (int colIndex = 0; colIndex < col; colIndex++) {
					dataArr[rowIndex-1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
					System.out.println(sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue());
				}
			}
		} catch (Exception e) {
			System.out.println("File not found at given location");
		}
	}
	
	public static void main(String[] args) {
		getDataFromExcel();
	}
	
	
}