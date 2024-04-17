package hiralPurohit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment_11 {

	public static Object[][] fileinput(String workbookPath, String sheetname) {
		File file = new File(workbookPath);
		Object[][] data = null;
		try {
			FileInputStream fileinput = new FileInputStream(file);
			Workbook myBook = new XSSFWorkbook(fileinput);
			Sheet sheet = myBook.getSheet(sheetname);
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new Object[rowCount][columnCount];
			for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
				for (int colIndex = 0; colIndex < columnCount; colIndex++) {
					data[rowIndex-1][colIndex]=sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				}
			}
			myBook.close();
		} catch (IOException ie) {
			System.out.println("File not found");
		}
		return data;
	}

}
