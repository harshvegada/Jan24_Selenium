package sasmitaSahu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Assignment11Dataprovider {
	@Test
	String[][] readData(String workBook, String sheetName) {
		File file = new File(workBook);
		String[][] data = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);

			int totalRow = sheet.getLastRowNum();
			int totalColumn = sheet.getRow(0).getLastCellNum();
			data = new String[totalRow][totalColumn];
			for (int rowIndex = 1; rowIndex <= totalRow; rowIndex++) {
				for (int columnInd = 0; columnInd < totalColumn; columnInd++) {
					data[rowIndex - 1][columnInd] = sheet.getRow(rowIndex).getCell(columnInd).getStringCellValue();
				}
			}
		} catch (IOException ae) {
			System.out.println("Inappropriate data");
		}
		return data;
	}
}
