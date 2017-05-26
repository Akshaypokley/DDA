import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by akshay.pokley on 5/26/2017.
 */
public class gdf {

    public static void main(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream("Excelsheet/TestCase.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("TestCase");
        XSSFRow row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        int RowCount = sheet.getPhysicalNumberOfRows();

        String data[][] = new String[RowCount - 2][2];
        for (int i = 2; i < RowCount; i++)

            for (Row row1 : sheet)


        {
            int j = 4;

            int n = 4;
            XSSFCell cell = (XSSFCell) row1.getCell(n); // Get the Cell at the Index / Colum you want.


         /*   if (cell == null) {
                data[i - 2][n] = "";
            } else {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 2][n] = cell.getStringCellValue();
            }*/
            String value = cell.getStringCellValue();
            System.out.println("Value of the Excel Cell is - " + value);
            ++j;

        }
    }


}