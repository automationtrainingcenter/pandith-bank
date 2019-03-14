package in.srssprojects.keximbank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper {
	Workbook book;
	Sheet sh;

	// set excel file to read the data
	public void setExcelToReadData(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(BaseClass.getFolderPath(".", fileName));
			book = new HSSFWorkbook(fis);
			sh = book.getSheet(sheetName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getRowCount() {
		return sh.getLastRowNum();
	}

	public int getCellCount() {
		return sh.getRow(0).getLastCellNum();
	}

	public String readData(int rnum, int cnum) {
		Object data = null;
		Cell cell = sh.getRow(rnum).getCell(cnum);
		CellType cType = cell.getCellTypeEnum();
		switch (cType) {
		case NUMERIC:
			data = (int) cell.getNumericCellValue();
			break;
		case STRING:
			data = cell.getStringCellValue();
			break;
		default:
			break;
		}
		return data.toString();
	}

	public String[][] getExcelData(String fileName, String sheetName) {
		setExcelToReadData(fileName, sheetName);
		int nor = getRowCount();
		int noc = getCellCount();
		String[][] data = new String[nor][noc];
		for (int r = 0; r < nor; r++) {
			for (int c = 0; c < noc; c++) {
				data[r][c] = readData(r + 1, c);
			}
		}

		return data;
	}

}
