import Pages.Login;
import Pages.Proposal.NewApplication;
import l.ee;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 5/31/2017.
 */
public class Ex {

   static WebDriver driver;
@Test
    public static void E() throws InterruptedException, IOException {

    // TODO Auto-generated method stub
    driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
        NewApplication newApplication = new NewApplication(driver);

        driver.switchTo().frame("ifrmListing");
        Thread.sleep(1000);//switch to iframe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame("IframeAddProposal");
        Thread.sleep(50);//switch to iframe
        ee operation = new ee(driver);
        FileInputStream fis = new FileInputStream("Excelsheet/TestCase.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheet("TestCase");
        HSSFRow rows = sh.getRow(1);
     //   int row = sh.getLastRowNum();
        int col = rows.getLastCellNum();
      //  String[][] getdata = new String[row][col];


        int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
        //Create a loop over all the rows of excel file to read it
        for (int i = 1; i < rowCount+1; i++) {
            //Loop over all the rows
            Row row = sh.getRow(i);
            if (row.getCell(0).toString().length() == 0) {
                //Print testcase detail on console
                System.out.println(row.getCell(1).toString() + "----" + row.getCell(2).toString() + "----" +
                        row.getCell(3).toString());
                //Call perform function to perform operation on UI

                try {
                    operation.perform(row.getCell(1).toString(), row.getCell(2).toString(),
                            row.getCell(3).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }


            } else {
                //Print the new testcase name when it started
                System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
            }

        }
    }
}