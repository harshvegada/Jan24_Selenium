package varshaNagadwala;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelInputFile {

	public static Object[][] readFileInput(String workbookPath, String sheetName) {
		File file = new File(workbookPath);
		Object[][] data = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fileInputStream);
			Sheet sheet = wb.getSheet(sheetName);

			int totalRows = sheet.getLastRowNum();
			System.out.println(totalRows);

			int totalCols = sheet.getRow(0).getLastCellNum();
			data = new Object[totalRows][totalCols];

			for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
				for (int colIndex = 0; colIndex < totalCols; colIndex++) {
					System.out.print(sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue() + " ");
					Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
					if (cell.getCellType() == null) {
						data[rowIndex - 1][colIndex] = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.STRING) {
						data[rowIndex - 1][colIndex] = cell.getStringCellValue();
					} else if (cell.getCellType() == CellType.NUMERIC) {
						data[rowIndex - 1][colIndex] = String.valueOf(cell.getStringCellValue()).split("//.");
					} else if (cell.getCellType() == CellType.BOOLEAN) {
						data[rowIndex - 1][colIndex] = String.valueOf(cell.getStringCellValue());
					}
				}
				System.out.println();
			}
			wb.close();
		} catch (IOException e) {
			System.out.println("File not found on location : " + workbookPath);
		}
		return data;
	}
}
