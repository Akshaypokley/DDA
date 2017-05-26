package Pages.Proposal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by akshay.pokley on 5/24/2017.
 */
public class SelectProposal {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='lblDesign']")
    WebElement ArchiteNM;


    @FindBy(xpath = ".//*[@id='btnNewApplication']")
    WebElement SelectPro;

    @FindBy(xpath = ".//*[@id='txtProposalTitle']")
    WebElement Proposaltitle;

    @FindBy(xpath = ".//*[@id='cboProposalType']")
    WebElement ProposalType;

    @FindBy(xpath = ".//*[@id='CboPlotUse']")
    WebElement proposalUse;

    @FindBy(xpath = ".//*[@id='cboCompanyActivitys']")
    WebElement CompanyActivity;

    @FindBy(xpath = "")
    WebElement PossesionDate;

    @FindBy(xpath = ".//*[@id='txtRRate']")
    WebElement ReadRR;

    @FindBy(xpath = ".//*[@id='CboLocation']")
    WebElement industrialArea;

    @FindBy(xpath = ".//*[@id='txtBuildingHeight']")
    WebElement BulidingHeigh;

    @FindBy(xpath = ".//*[@id='txtPlotNo']")
    WebElement PlotNo;

    @FindBy(xpath = ".//*[@id='cboMPCB']")
    WebElement MPCBConsent;

    @FindBy(xpath = ".//*[@id='RdoDCYes']")
    WebElement CheckConversionY;

    @FindBy(xpath = ".//*[@id='RdoDCNo']")
    WebElement CheckConversionN;

    @FindBy(xpath = ".//*[@id='rdoYes']")
    WebElement extraFloorHY;

    @FindBy(xpath = ".//*[@id='rdoNo']")
    WebElement extraFloorHN;

    @FindBy(xpath = ".//*[@id='txtFSIArea']")
    WebElement AdditionalFSI;

    @FindBy(xpath = ".//*[@id='cboSPA']")
    WebElement ConcerSPA;

    @FindBy(xpath = ".//*[@id='txtPlotArea']")
    WebElement plotarea;

    @FindBy(xpath = ".//*[@id='txtBasementArea']")
    WebElement BasementArea;

    @FindBy(xpath = ".//*[@id='txtbuiltUpArea']")
    WebElement GrossBuiltupArea;

    @FindBy(xpath =".//*[@id='txtRCCArea']" )
    WebElement RCCArea;

    @FindBy(xpath = ".//*[@id='txtShed']")
    WebElement ShedArea;

    @FindBy(xpath = ".//*[@id='TxtOtherArea']")
    WebElement OtherSA;

    @FindBy(xpath = ".//*[@id='txtApplicantName']")
    WebElement ApplicationNM;

    @FindBy(xpath = ".//*[@id='txtApplicantAddress']")
    WebElement ApplicantAdd;

    @FindBy(xpath = ".//*[@id='txtApplicantContact']")
    WebElement ApplicantCtNo;

    @FindBy(xpath = ".//*[@id='txtCompanyName']")
    WebElement CompanyNM;

    @FindBy(xpath = ".//*[@id='txtCompanyAddress']")
    WebElement CompanyAdd;

    @FindBy(xpath = ".//*[@id='txtApplicantEmail']")
    WebElement AppEmailid;

    @FindBy(xpath = ".//*[@id='btnSave']")
    WebElement Submit;

    public SelectProposal (WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!ArchiteNM.isDisplayed())
            throw new IllegalStateException("This Not Architect Login");

    }

    public WebElement getArchiteNM()
    {
        return ArchiteNM;
    }



    public void ClickSelectPro()
    {
        SelectPro.click();
    }

    public void setProposaltitle(String proposaltitle)
    {
        Proposaltitle.sendKeys(proposaltitle);
    }

    public void setProposalType(String proposalType)
    {
        Select combo=new Select(ProposalType);
        combo.selectByValue(proposalType);
    }

    public  void setProposalUse(String proposalUse1)
    {
        Select combo=new Select(proposalUse);
        combo.selectByValue(proposalUse1);
    }

    public void setCompanyActivity(String companyActivity)
    {
        Select combo=new Select(CompanyActivity);
        combo.selectByValue(companyActivity);
    }

    public void setReadRR(String readRR)
    {
        ReadRR.sendKeys(readRR);
    }

    public void setIndustrialArea(String industrialArea1)

    {
        Select combo=new Select(industrialArea);
        combo.selectByValue(industrialArea1);
    }

    public void setBulidingHeigh(String bulidingHeigh1)
    {
        BulidingHeigh.sendKeys(bulidingHeigh1);
    }

    public  void setPlotNo(String plotNo)
    {
        PlotNo.sendKeys(plotNo);
    }

    public void setMPCBConsent(String mpcbConsent)
    {
        Select combo=new Select(MPCBConsent);
        combo.selectByValue(mpcbConsent);
    }
    public void ClickCheckConversion()
    {
        CheckConversionY.click();
    }

    public void ClickCheckConversionN()
    {
        CheckConversionN.click();
    }


    public void ClickExtraFloorH()
    {
        extraFloorHY.click();
    }

    public void ClickExtraFloorHN()
    {
        extraFloorHN.click();
    }
    public void setAdditionalFSI(String additionalFSI)
    {
        AdditionalFSI.sendKeys(additionalFSI);
    }

    public void setConcerSPA(String concerSPA)
    {
        Select combo=new Select(ConcerSPA);
        combo.selectByValue(concerSPA);
    }

    public void setPlotarea(String plotarea1)
    {
        plotarea.sendKeys(plotarea1);
    }

    public void setBasementArea(String basementArea)
    {
        BasementArea.sendKeys(basementArea);
    }

    public void setGrossBuiltupArea(String grossBuiltupArea)
    {
        GrossBuiltupArea.sendKeys(grossBuiltupArea);
    }

    public void setRCCArea(String rccArea)
    {
        RCCArea.sendKeys(rccArea);
    }

    public void setShedArea(String shedArea)
    {
        ShedArea.sendKeys(shedArea);
    }

    public void setOtherSA(String otherSA)
    {
        OtherSA.sendKeys(otherSA);
    }

    public void setApplicationNM(String applicationNM1)
    {
        ApplicationNM.sendKeys(applicationNM1);
    }

    public void setApplicantAdd(String applicantAdd)
    {
        ApplicantAdd.sendKeys(applicantAdd);
    }

    public void setApplicantCtNo(String applicantCtNo)
    {
        ApplicantCtNo.sendKeys(applicantCtNo);
    }

    public void setCompanyNM(String companyNM)
    {
        CompanyNM.sendKeys(companyNM);
    }

    public void setCompanyAdd(String companyAdd)
    {
        CompanyAdd.sendKeys(companyAdd);
    }

    public void setAppEmailid(String appEmailid)
    {
        AppEmailid.sendKeys(appEmailid);
    }

    public void ClickSubmit()
    {
        Submit.click();
    }
}
