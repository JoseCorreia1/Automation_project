package Steps;

import Actions.AccountDetails;
import Actions.Dashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class steps_account_details {
    SharedDriver sharedDriver;
    Dashboard dashboard;
    AccountDetails accountDetails;

    public steps_account_details (SharedDriver sharedDriver){
        this.sharedDriver = sharedDriver;
        PageFactory.initElements(sharedDriver.getDriver(), this);
        dashboard = new Dashboard(sharedDriver);
        accountDetails = new AccountDetails(sharedDriver);

    }
    @Then("^user selects one account$")
    public void user_selects_one_account() throws Throwable {
        dashboard.ClickOnAccount();
    }

    @And("^user is on account details of that account$")
    public void user_is_on_account_details_of_that_account() throws Throwable {
        accountDetails.OnAccountIfoPage();
    }

}
