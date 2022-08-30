package Actions;

import Steps.SharedDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
   SharedDriver sharedDriver;

   public Dashboard(SharedDriver sharedDriver){
       this.sharedDriver = sharedDriver;
       PageFactory.initElements(sharedDriver.getDriver(), this);
   }



}
