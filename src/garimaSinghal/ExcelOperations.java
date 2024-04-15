package garimaSinghal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	public static Object[][] readData(String workbookPath, String sheetName) {
		File file = new File(workbookPath);
		Object[][] data=null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);
			
			int totalRows = sheet.getLastRowNum();
			
			
			int totalCols = sheet.getRow(0).getLastCellNum(); //3
			data = new Object[totalRows][totalCols];
			
			for(int rowIndex=1;rowIndex<=totalRows;rowIndex++) {
				for(int colIndex=0;colIndex<totalCols;colIndex++) {
				data[rowIndex-1][colIndex]=sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				}
			}
			wb.close();
		} catch (IOException e) {
			System.out.println("File not found on location : " + workbookPath);
		}
		
		return data;
	}
}
