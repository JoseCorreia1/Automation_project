package Steps;

import Actions.Login;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class steps_login_forgot_username {
    WebDriver driver;
    Login login;
    SharedDriver sharedDriver;

    public steps_login_forgot_username(SharedDriver sharedDriver){
        this.sharedDriver = sharedDriver;
        driver = sharedDriver.getDriver();
        PageFactory.initElements(driver, this);
        login = new Login(driver, sharedDriver);

    }

    @And("^i click on forgot username$")
    public void i_click_on_forgot_username() throws Throwable {
        login.ClickOnForgotUsername();
    }

    @Then("^im redirected to forgot username screen$")
    public void im_redirected_to_forgot_username_screen() throws Throwable {
       login.ImOnForgotUsernameScreen();
    }

    @Then("^i write my \"([^\"]*)\" address on the field$")
    public void i_write_my_address_on_the_field(String arg1) throws Throwable {
        login.InsertEmailForgotUsername(arg1);
    }

    @Then("^i click on the confirm e-mail address$")
    public void i_click_on_the_confirm_e_mail_address() throws Throwable {
        login.ClickOnSubmitForgotUsername();
    }

    @Then("^im redirected to the login screen with a success message showing the email that was sent$")
    public void im_redirected_to_the_login_screen_with_a_success_message_showing_the_email_that_was_sent() throws Throwable {
        login.CheckSuccessMessageForgotUsername();
    }
}
