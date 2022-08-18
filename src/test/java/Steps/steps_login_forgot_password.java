package Steps;

import Actions.Login;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class steps_login_forgot_password {
    WebDriver driver;
    Login login;
    SharedDriver sharedDriver;

    public steps_login_forgot_password(SharedDriver sharedDriver) {
        this.sharedDriver = sharedDriver;
        driver = sharedDriver.getDriver();
        PageFactory.initElements(driver, this);
        login = new Login(driver, sharedDriver);
    }

    @And("^i click on forgot password$")
    public void i_click_on_forgot_password() throws Throwable {
        login.ClickForgotPassword();
    }

    @Then("^im redirected to forgot password screen$")
    public void im_redirected_to_forgot_password_screen() throws Throwable {
        login.ImOnForgotPasswordScreen();
    }

    @Then("^i write my \"([^\"]*)\" address$")
    public void i_write_my_address(String arg1) throws Throwable {
       login.insertEmail(arg1);

    }

    @Then("^i click on confirm e-mail address$")
    public void i_click_on_confirm_e_mail_address() throws Throwable {
        login.ClickOnConfirmEmail();
    }

    @Then("^im redirected to the login screen with a success message$")
    public void im_redirected_to_the_login_screen_with_a_success_message() throws Throwable {
        login.CheckSuccessMessage();
    }
}