package pagesTest.ProposalTest;

import Pages.Proposal.NewApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void loadbrowser()
    {
        driver= openBrowser("chrome");
        GetUrl("url");
        LogFunction(driver);
    }

    @Test
    public void SaveSelectPro() throws InterruptedException {
        /*ArchitectMenu architectMenu=new ArchitectMenu(driver);
       // architectMenu.ClickAppliatiSubmittionlink();
        architectMenu.ClickApplicationlink();*/


        NewApplication newApplication=new NewApplication(driver);

        driver.switchTo().frame("ifrmListing");
        Thread.sleep(1000);//switch to iframe
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame("IframeAddProposal");
        Thread.sleep(1000);//switch to iframe
        newApplication.setCaseType("New");
        newApplication.setLocation("3");
        newApplication.ClickDUACNO();
        newApplication.setBuildingNo("232");
        newApplication.setBlockNo("342");
        newApplication.setHouseNo("343");
        newApplication.setPincode("123456");
        newApplication.setPlotNo("342");
        newApplication.setPockectNo("7623456");
        newApplication.setRoad_Street("76787");
        newApplication.setSchmeNo("776");
        newApplication.setSecotorNo("7878");
        newApplication.setSituated("3423");
        newApplication.setWard("78");
        newApplication.setSave();
    }
}
