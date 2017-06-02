import Pages.Proposal.NewApplication;
import l.ReadGuru99ExcelFile;
import l.ee;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 6/2/2017.
 */
public class je {
    static WebDriver driver;
    @Test(dataProvider="hybridData")
    public static void E(String testcaseName,String keyword,String objectName,String value) throws InterruptedException, IOException {

        if(testcaseName!=null&&testcaseName.length()!=0){
            driver = openBrowser("chrome");
            GetUrl("url");
            LogFunction(driver);
            NewApplication newApplication = new NewApplication(driver);

            driver.switchTo().frame("ifrmListing");
            Thread.sleep(1000);//switch to iframe
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.switchTo().frame("IframeAddProposal");
            Thread.sleep(50);//switch to iframe
        }

        ee operation = new ee(driver);
        try {
            operation.perform(keyword, objectName,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //   int row = sh.getLastRowNum();

        //  String[][] getdata = new String[row][col];


    }

        @DataProvider(name="hybridData")
        public Object[][] getDataFromDataprovider() throws IOException{
            Object[][] object = null;
            FileInputStream fis = new FileInputStream("Excelsheet/TestCase.xls");
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sh = wb.getSheet("TestCase");
            HSSFRow rows = sh.getRow(1);
//Read keyword sheet
//Find number of rows in excel file
            int rowCount =sh.getLastRowNum()-sh.getFirstRowNum();
            System.out.println(rowCount);
            object = new Object[rowCount][4];
            for (int i = 0; i < rowCount; i++) {
                //Loop over all the rows
                Row row = sh.getRow(i+1);
                //Create a loop to print cell values in a row
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    //Print excel data in console
                    object[i][j] = row.getCell(j).toString();
                }
            }
            System.out.println("");
            return object;
        }
    }


























       /* int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
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

        }*/

