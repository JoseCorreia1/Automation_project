package Actions;

import Steps.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetails {
    //private static WebDriver driver;
    SharedDriver sharedDriver;

    public AccountDetails(SharedDriver sharedDriver){
        //this.driver = driver;
        this.sharedDriver = sharedDriver;
        PageFactory.initElements(sharedDriver.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(), ' Account info ')]")
    WebElement accountinfo;


    public void OnAccountIfoPage(){
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(accountinfo));
    }
}
