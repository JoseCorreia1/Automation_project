package Actions;

import Steps.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountDetails {
    //private static WebDriver driver;
    SharedDriver sharedDriver;

    public AccountDetails(SharedDriver sharedDriver){
        //this.driver = driver;
        this.sharedDriver = sharedDriver;
        PageFactory.initElements(sharedDriver.getDriver(), this);
    }



}
