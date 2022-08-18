package Actions;

import Steps.SharedDriver;
import Config.ReadPropFile;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.Date;

public class Login {
    private static WebDriver driver;
    private SharedDriver sharedDriver;

    public Login(WebDriver driver, SharedDriver sharedDriver) {
        this.driver = driver;
        this.sharedDriver = sharedDriver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.ID, using = "username")
    WebElement txtBoxUsername;

    @FindBy(how = How.ID, using = "password")
    WebElement txtBoxPassword;

    @FindBy(how = How.ID, using = "kc-login")
    WebElement login;

    @FindBy(linkText = "I've forgotten my password")
    WebElement forgotPasswordLink;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Forgot Password')]")
    WebElement forgotpassswordscreen;

    @FindBy(how = How.ID, using = "reset-password-username")
    WebElement resetpasswordemail;

    @FindBy(how = How.ID, using = "reset-password-submit-button")
    WebElement confirmemailbutton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'You should receive an email shortly with further instructions.' )]")
    WebElement succesmessage;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(), ' Accounts ' )]")
    WebElement accounts;


    public void openBrowser() throws IOException, InterruptedException {
        String url = null;
        String domain = null;
        url = ReadPropFile.ReadConfig("url.mainPortal");
        domain = ReadPropFile.ReadConfig("url.identityDomain");
        driver.get(url);
    }

    //in this way we can set opening browsers in other realms (Bank Employee, Identity, etc.)
    public void openBrowser_BEP() throws IOException, InterruptedException {
        String url = null;
        String domain = null;
        domain = ReadPropFile.ReadConfig("url.identityDomain");
        url = ReadPropFile.ReadConfig("url.employeePortal");
        driver.get(url);
    }

    public void fillIn(String user, String pass) {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(txtBoxUsername)).sendKeys(user);
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(txtBoxPassword)).sendKeys(pass);
    }

    public void pressSubmit() throws InterruptedException {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(login));
        login.click();
        Thread.sleep(600);
    }

    public void succesfulLogin() {
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(accounts));

    }

    public void ClickForgotPassword(){
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(forgotPasswordLink)).click();
    }

    public void ImOnForgotPasswordScreen(){
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(forgotpassswordscreen));
    }

    public void insertEmail(String email){
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(resetpasswordemail)).sendKeys(email);
    }

    public void ClickOnConfirmEmail(){
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(confirmemailbutton)).click();
    }

    public void CheckSuccessMessage(){
        sharedDriver.getWait().until(ExpectedConditions.visibilityOf(succesmessage));

    }
}
