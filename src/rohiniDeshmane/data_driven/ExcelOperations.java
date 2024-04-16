package rohiniDeshmane.data_driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static Object[][] readData(String workbookPath, String sheetName) {
		File file = new File(workbookPath);
		Object[][] data =null;
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			
			int totalColm = sheet.getRow(0).getLastCellNum();
			int totalRows = sheet.getLastRowNum();
			
			data = new Object[totalRows][totalColm];
			
			for(int i=1; i<=totalRows; i++) {
				for(int j=0; j<totalColm; j++) {
					data[i-1][j] =sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j] =sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j] =sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
