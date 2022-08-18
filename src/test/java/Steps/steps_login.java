package Steps;

import Actions.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class steps_login {

    WebDriver driver;
    Login login;
    SharedDriver sharedDriver;

    public steps_login(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        driver = sharedDriver.getDriver();
        PageFactory.initElements(driver, this);
        login = new Login(driver, sharedDriver);
    }

    @And("^i want to login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_want_to_login_with_and(String user, String pass) {
        login.fillIn(user, pass);
    }

    @Given("^i am in the login page$")
    public void i_am_in_login_page() throws Throwable {
        login.openBrowser();
    }

    @Then("^i press the Submit button$")
    public void i_press_the_Submit_button() throws Throwable {
        login.pressSubmit();
    }

    @And("^user is on dashboard$")
    public void user_is_on_dashboard() throws Throwable {
        login.succesfulLogin();
    }

}