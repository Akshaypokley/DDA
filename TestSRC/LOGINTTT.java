import Pages.Login;
import Pages.Proposal.NewApplication;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilites.AlertFunction.AlerFun;
import static Utilites.LoginFunction.LogFunction;
import static Utilites.OpenBrowser.GetUrl;
import static Utilites.OpenBrowser.openBrowser;

/**
 * Created by akshay.pokley on 5/31/2017.
 */
public class LOGINTTT {
    WebDriver driver;

/*    @BeforeMethod
    public void loadbrowser() {
        driver = openBrowser("chrome");
        GetUrl("url");
    }*/


    @Test(dataProvider = "userdata")
    public void LoginTest(String Keywrord,String Keyword, String objectName, String value) throws InterruptedException {
        driver = openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
        NewApplication newApplication = new NewApplication(driver);

        driver.switchTo().frame("ifrmListing");
        Thread.sleep(1000);//switch to iframe
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame("IframeAddProposal");
        Thread.sleep(50);//switch to iframe
        switch (Keyword.toUpperCase()) {
            case "CLICK":
                switch (objectName) {
                    case "Submit":
                        Login login = new Login(driver);
                        login.ClickLoginBtn();

                }

                break;
            case "SETTEXT":
            //    NewApplication newApplication = new NewApplication(driver); //Set text on control
                switch (objectName) {

                    case "UserName":

                        newApplication.setCaseType(value);
                    case "password":
                        // NewApplication newApplication1 = new NewApplication(driver);
                        newApplication.setLocation(value);
                        System.out.println(value);
                }
                break;

      /*  System.out.println(sername);
        System.out.println(pasword);      System.out.println(asword);*/
        }
    }

    @DataProvider(name = "userdata")
    public Object[][] userdata() throws IOException {
        FileInputStream fis=new FileInputStream("Excelsheet/TestCase.xls");
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sh=wb.getSheet("TestCase");
        HSSFRow rows=sh.getRow(0);
        int row=sh.getLastRowNum();
        int col=rows.getLastCellNum();
        String [][] getdata=new String[row][col];

        for(int i=0;i<row;i++)
        {
            int k=i;
            rows=sh.getRow(k+1);
            for(int j=0;j<col;j++)
            {
                int l=j;
                //  short First2=rows.getLastCellNum();
                getdata[k][j]=rows.getCell(j).getStringCellValue();
                System.out.println(rows.getCell(l).getStringCellValue());
            }
        }

        return getdata;
    }
    }

