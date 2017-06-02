import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akshay.pokley on 5/26/2017.
 */
public class gdf {

    public static void main(String args[]) throws IOException {
        String filename = "Excelsheet/TestCase.xls";
        List sheetData = new ArrayList();

        FileInputStream fis = new FileInputStream(filename);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFRow row = sheet.getRow(0);
        int RowCount = sheet.getPhysicalNumberOfRows();
        String data3[][] = new String[RowCount-1][1];

        Iterator rows = sheet.rowIterator();
        while (rows.hasNext()) {
            HSSFRow row3 = (HSSFRow) rows.next();
            Iterator cells = row3.cellIterator();

            List data = new ArrayList();
            while (cells.hasNext()) {
                HSSFCell cell = (HSSFCell) cells.next();
                data.add(cell);
            }

            sheetData.add(data);
        }
        /*for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
         //   List list = (List) sheetData.get(i);
Iterator<Cell> d=row.cellIterator();
            for (int j = 2; j < row.getPhysicalNumberOfCells(); j++) {
              HSSFCell cell = (HSSFCell) d.ge;
           //    System.out.print(cell.getRichStringCellValue().getString());

                if (cell == null) {
                    data3[i-1][j] = "";
                } else {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    data3[i-1][j] =cell.getStringCellValue();
                }

               if (j < list.size() - 1) {
                    System.out.print(", ");*/
               }


            }






