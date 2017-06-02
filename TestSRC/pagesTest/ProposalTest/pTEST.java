package pagesTest.ProposalTest;

import Pages.Proposal.NewApplication;
import l.ReadGuru99ExcelFile;
import l.ReadObject;
import l.UIOperation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 5/30/2017.
 */
public class pTEST {
    WebDriver driver;
 /*   @BeforeMethod
    public void loadbrowser() throws InterruptedException {
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
    }*/
    @Test(dataProvider = "hybridData")
    public void SaveSelectPro(String testcaseName,String keyword,String objectName,String objectType,String value) throws Exception {


       if(testcaseName!=null&&testcaseName.length()!=0){
           driver = openBrowser("chrome");

        }
        GetUrl("url");
        LogFunction(driver);
        NewApplication newApplication = new NewApplication(driver);

        driver.switchTo().frame("ifrmListing");
        Thread.sleep(1000);//switch to iframe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame("IframeAddProposal");
        Thread.sleep(100);//switch to iframe
        ReadObject object = new ReadObject();
        Properties allObjects = object.getObjectRepository();
        UIOperation operation = new UIOperation(driver);
        //Call perform function to perform operation on UI
        operation.perform(allObjects, keyword, objectName,
                objectType, value);
    }

    @DataProvider(name="hybridData")
    public Object[][] getDataFromDataprovider() throws IOException{
        Object[][] object = null;
        ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
//Read keyword sheet
        Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "KeywordFramework");
//Find number of rows in excel file
        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
        System.out.println(rowCount);
        object = new Object[rowCount][5];
        for (int i = 0; i < rowCount; i++) {
            //Loop over all the rows
            Row row = guru99Sheet.getRow(i+1);
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


