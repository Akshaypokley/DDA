package l;

import Pages.Login;
import Pages.Proposal.NewApplication;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static Utilites.AlertFunction.AlerFun;

/**
 * Created by akshay.pokley on 5/31/2017.
 */
public class ee {
    WebDriver driver;
    public ee(WebDriver driver){
        this.driver = driver;
    }
    public void perform(String operation, String objectName, String value) throws Exception{
        System.out.println("");

        switch (operation.toUpperCase()) {
            case "CLICK":
                switch (objectName)
                {
                    case "Submit":
                        Login login=new Login(driver);
                        login.ClickLoginBtn();
                        AlerFun( driver);
                }

                break;
            case "SETTEXT":
                NewApplication newApplication = new NewApplication(driver); //Set text on control
              switch (objectName)
              {

                  case "UserName":

                      newApplication.setCaseType(value);

                  case "password":
                     // NewApplication newApplication1 = new NewApplication(driver);
                      newApplication.setLocation(value);
                      System.out.println(value);
              }
                break;

           /* case "GOTOURL":
                //Get url of application
                driver.get(p.getProperty(value));
                break;
            case "GETTEXT":
                //Get text of an element
                driver.findElement(this.getObject(p,objectName,objectType)).getText();
                break;
            case "SELECT":
                //Get text of an element
                driver.findElement(this.getObject(p,objectName,objectType)).getText();
                break;*/
            default:
                break;
        }
    }
}
