package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.FileInputStream;

public class ExcelUtils {

	//Crear variables Static para el excel
    private static HSSFWorkbook excelWBook;
    private static HSSFSheet excelWSheet;
    private static HSSFCell cell;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		String[][] tabArray = null;
        FileInputStream excelFile = new FileInputStream(FilePath);
        excelWBook = new HSSFWorkbook(excelFile);
        excelWSheet = excelWBook.getSheet(SheetName);
        int startRow;
        int startCol;
        int ci, cj;
        int totalRows = excelWSheet.getLastRowNum();
        int totalCol = excelWSheet.getRow(0).getLastCellNum();

        tabArray = new String[totalRows][totalCol];
        ci = 0;
        for(startRow = 1; startRow <= totalRows; startRow++, ci++){
            cj = 0;
            for(startCol = 0; startCol < totalCol; startCol++, cj++){

                tabArray[ci][cj] = getCellDataDDT(startRow, startCol);
            }
        }

        return(tabArray);
    }
	
	public static String getCellDataDDT(int RowNum, int ColNum) throws Exception {
        String data = "";
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        if(cell.getCellTypeEnum() == CellType.STRING){
            data = cell.getStringCellValue();
        }else if(cell.getCellTypeEnum() == CellType.NUMERIC){
            data = String.format("%.0f",cell.getNumericCellValue());
        }
        return data;
    }


}
