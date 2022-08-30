package Actions;

import Steps.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard {
   SharedDriver sharedDriver;

   public Dashboard(SharedDriver sharedDriver){
       this.sharedDriver = sharedDriver;
       PageFactory.initElements(sharedDriver.getDriver(), this);
   }


@FindBy(className = "bb-account__account-name")
    WebElement account;


   public void ClickOnAccount(){
       sharedDriver.getWait().until(ExpectedConditions.visibilityOf(account)).click();
   }
}
