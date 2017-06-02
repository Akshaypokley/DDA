package pagesTest.ProposalTest;

import Pages.Proposal.NewApplication;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.bcel.classfile.Constant;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

/*    @BeforeMethod
    public void loadbrowser() {
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
    }*/

    @Test(dataProvider = "ProposalInfo")
    public void SaveSelectPro(String testcaseName,String keyword,String objectName,String objectType,String value/*,String BuildingNo,String BlockNo,String HouseNo,String PinCode,String
                              PlotNo,String PockectNo,String RoadS,String SchmeNo,String SecoNo,String Situated
    ,String ward*/) throws InterruptedException {
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
        NewApplication newApplication = new NewApplication(driver);

        driver.switchTo().frame("ifrmListing");
        Thread.sleep(1000);//switch to iframe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame("IframeAddProposal");
        Thread.sleep(100);//switch to iframe
        System.out.println(testcaseName);
        System.out.println(keyword);

        System.out.println(objectName);System.out.println(objectType);
        newApplication.setCaseType(value);
       // newApplication.setLocation(Location);

    }


    @DataProvider
    public Object[][] ProposalInfo() throws IOException, BiffException {
        try {
            FileInputStream fis = new FileInputStream("Excelsheet/TestCase.xls");

            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet sheet = wb.getSheet("TestCase");

            for (int count = 1; count <= sheet.getLastRowNum(); count++) {
                XSSFRow row = sheet.getRow(count);
                System.out.println("Running test case " + row.getCell(0).toString());

                //row.getCell(1).toString(),row.getCell(2).toString();

                System.out.println("Count" + row);

                //ExcelUtils.setExcelFile(Constant.Path_TestData,Constant.File_TestData);
                // ExcelUtils.setCellData("PASS",count,4);


            }
            fis.close();

        } catch (IOException e) {

            System.out.println("Test data file not found");
        }
        return new Object[0][];
    }}