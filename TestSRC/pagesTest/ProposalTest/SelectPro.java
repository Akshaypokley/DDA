package pagesTest.ProposalTest;

import Pages.Proposal.NewApplication;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class SelectPro {
    WebDriver driver;

    @BeforeMethod
    public void loadbrowser() {
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
    }

    @Test(dataProvider = "ProposalInfo")
    public void SaveSelectPro(String caseType, String Location/*,String BuildingNo,String BlockNo,String HouseNo,String PinCode,String
                              PlotNo,String PockectNo,String RoadS,String SchmeNo,String SecoNo,String Situated
    ,String ward*/) throws InterruptedException {

        NewApplication newApplication = new NewApplication(driver);

        driver.switchTo().frame("ifrmListing");
        Thread.sleep(1000);//switch to iframe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame("IframeAddProposal");
        Thread.sleep(100);//switch to iframe
        newApplication.setCaseType(caseType);
        newApplication.setLocation(Location);
   /*    newApplication.ClickDUACNO();
        newApplication.setBuildingNo(BuildingNo);*/
        /*newApplication.setBlockNo(BlockNo);
        newApplication.setHouseNo(HouseNo);
        newApplication.setPincode(PinCode);
        newApplication.setPlotNo(PlotNo);
        newApplication.setPockectNo(PockectNo);
        newApplication.setRoad_Street(RoadS);
        newApplication.setSchmeNo(SchmeNo);
        newApplication.setSecotorNo(SecoNo);
        newApplication.setSituated(Situated);
        newApplication.setWard(ward);
        newApplication.setSave();*/
    }


    @DataProvider
    public Object[][] ProposalInfo() throws IOException, BiffException {
//Object[][] objects=null;

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
            int j=5;

            int n=4;
            XSSFCell cell = (XSSFCell) row1.getCell(n); // Get the Cell at the Index / Colum you want.


            if (cell == null) {
                data[i - 2][n] = "";
            } else {
               cell.setCellType(Cell.CELL_TYPE_STRING);
                data[i- 2][n] = cell.getStringCellValue();
            }
            ++n;
            ++j;

        }
        return data;
    }}