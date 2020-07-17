package commons;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Wrapper {

		 static String path = "resource//ELearningtestdata.xlsx";
		 static String sheet = "Sheet1";
		
		public static String getDataFromExcel(int row, int col) throws IOException {
			FileInputStream fs = new FileInputStream(path);
			Workbook book = new XSSFWorkbook(fs);
			Sheet sh = book.getSheet(sheet);
			Row rows = sh.getRow(row);
			Cell cell = rows.getCell(col);
			
			DataFormatter df = new DataFormatter();
			String formatValue = df.formatCellValue(cell);
			System.out.println("Formatted Value : " + formatValue);
			return formatValue;
		}
		
		public static void main(String[] args) throws IOException {
		String val = getDataFromExcel(1,1);
		System.out.println("got value from function" + val);

	}

}
