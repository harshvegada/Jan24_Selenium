package akshayGaikwad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReading {
	
	static String[][] getDataFromExcel(String filePath, String sheetName) {
		File file = new File(filePath);
		Workbook wb;
		String[][] dataArr = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			wb = new XSSFWorkbook(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);
			int row = sheet.getLastRowNum();
			int col = sheet.getRow(0).getLastCellNum();

			dataArr = new String[row][col];

			for (int rowIndex = 1; rowIndex <= row; rowIndex++) {
				for (int colIndex = 0; colIndex < col; colIndex++) {
					dataArr[rowIndex-1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
					System.out.print(sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue()+" ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("File not found at given location");
		}
		return dataArr;
	}
}