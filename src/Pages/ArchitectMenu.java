package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by laxmikant on 19/05/2017.
 */
public class ArchitectMenu
{
        WebDriver driver;

    @FindBy(xpath = ".//*[@id='lblULBName']")
    WebElement HomeeLogo;

    /* Report */
    @FindBy(xpath = "//li[1]/a/div/div[2]/span")
    WebElement ReportLink;

    @FindBy(xpath = ".//*[@id='a_21957']/span")
    WebElement ArchitectWiseRe;
    /*-----------------------------*/


    /*Dashboard */
    @FindBy(xpath = "//li[2]/a/div/div[2]/span")
    WebElement ClickDashBoard;

    @FindBy(xpath = ".//*[@id='a_21971']/span")
    WebElement DashBoardLink;
    /*-----------------------------*/


    /* Appliation Submittion */

    @FindBy(xpath = ".//*[@id='MainUL']/li[1]/a/div/div[2]/span")
    WebElement AppliatiSubmittionlink;

    @FindBy(xpath = ".//*[@id='a_157']/span")
    WebElement Applicationlink;

    @FindBy(xpath = ".//*[@id='a_22012']/span")
    WebElement SubmittedApplication;
    /*-----------------------------*/


    /* Application Status */

    @FindBy(xpath = "//li[4]/a/div/div[2]/span")
    WebElement ApplicationStatus;

    @FindBy(xpath = ".//*[@id='a_22018']/span")
    WebElement ObjeFileFire;

    @FindBy(xpath = ".//*[@id='a_22022']/span")
    WebElement DrawingNotInformat;

    @FindBy(xpath = ".//*[@id='a_22023']/span")
    WebElement ScrutinyCnBEDone;

    @FindBy(xpath = ".//*[@id='a_22024']/span")
    WebElement DrawingFailInRules;

    @FindBy(xpath = ".//*[@id='a_22040']/span")
    WebElement ObjectBuildingFile;

    @FindBy(xpath = ".//*[@id='a_22041']/span")
    WebElement ApprovedFile;
    /*-----------------------------*/


    /* Payments*/

    @FindBy(xpath = "//li[5]/a/div/div[2]/span")
    WebElement Payments;

    @FindBy(xpath = ".//*[@id='a_22053']/span")
    WebElement PaidProcessFessF;

    @FindBy(xpath = ".//*[@id='a_22057']/span")
    WebElement PaidProcessingFessBuil;

    @FindBy(xpath = ".//*[@id='a_22052']/span")
    WebElement PendingProcessFessF;

    @FindBy(xpath = ".//*[@id='a_22056']/span")
    WebElement PendingProcessingFessBuil;

    /*-----------------------------*/

    public ArchitectMenu(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!HomeeLogo.isDisplayed())
            throw new IllegalStateException("This Not ArchitectMenu");
    }

    public WebElement getHomeeLogo()
    {
        return HomeeLogo;
    }

    /* Report */
    public void ClickReportLink()
    {
        ReportLink.click();
    }

    public void ClickArchitectWiseRe()
    {
        ArchitectWiseRe.click();
    }

    /*-----------------------------*/


    /*Dashboard */
    public void ClickDashBoardLink()
    {
        DashBoardLink.click();
    }


    public void ClickDashBoardL()
    {
        ClickDashBoard.click();
    }
    /*-----------------------------*/


    /* Appliation Submittion */

    public void ClickAppliatiSubmittionlink()
    {
        AppliatiSubmittionlink.click();
    }


    public void ClickApplicationlink()
    {
        Applicationlink.click();
    }

    public void ClickSubmittedApplication()
    {
        SubmittedApplication.click();
    }

    /*-----------------------------*/


    /* Application Status */

    public void ClickApplicationStatus()
    {
        ApplicationStatus.click();
    }

  public void ClickObjeFileFire()
  {
      ObjeFileFire.click();
  }

    public void ClickDrawingNotInformat()
    {
        DrawingNotInformat.click();
    }

    public void ClickScrutinyCnBEDone()
    {
        ScrutinyCnBEDone.click();
    }

    public void ClickDrawingFailInRules()
    {
        DrawingFailInRules.click();
    }

    public void ClickObjectBuildingFile()
    {
        ObjectBuildingFile.click();
    }

    public void ClickApprovedFile()
    {
        ApprovedFile.click();
    }

  /*-----------------------------*/


    /* Payments*/

    public void ClickPayments() {
        Payments.click();
    }

    public void ClickPendingProcessingFessBuil()
    {
        PendingProcessingFessBuil.click();
    }
    public void ClickPendingProcessFessF()
    {
        PendingProcessFessF.click();
    }
    public void ClickPaidProcessingFessBuil()
    {
        PaidProcessingFessBuil.click();
    }
    public void ClickPaidProcessFessF()
    {
        PaidProcessFessF.click();
    }


    /*-----------------------------*/

}

