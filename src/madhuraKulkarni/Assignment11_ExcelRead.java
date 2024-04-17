package madhuraKulkarni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment11_ExcelRead {
	public String[][] readDataFromExcelSheet(String workbookPath, String sheetname) throws IOException {
		File file = new File(workbookPath);
		String[][] data = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fileInputStream);
			Sheet sheet = wb.getSheet(sheetname);

			int totalRows = sheet.getLastRowNum();
			int totalCols = sheet.getRow(0).getLastCellNum();
			data = new String[totalRows][totalCols];
			for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
				for (int colIndex = 0; colIndex < totalCols; colIndex++) {
					data[rowIndex - 1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found at location: " + workbookPath);
		}
		return data;
	}
}
