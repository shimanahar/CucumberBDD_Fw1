package pageObject;

import base.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class login_page extends Setup {

    public login_page (WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }

    // locators
    @FindBy(how= How.NAME, using = "email")
    public WebElement emailLocator;
    @FindBy(how= How.NAME, using = "password")
    public WebElement passwordLocator;
    @FindBy(how= How.CLASS_NAME, using = "my-login")
    public WebElement loginButton;
    @FindBy(how= How.CLASS_NAME, using = "new-account")
    public WebElement createNewAccount;

    // Function
    public void enterEmailAddress(String email){
        emailLocator.sendKeys(email);
    }
    public void enterPassword(String pass){
        passwordLocator.sendKeys(pass);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickCreateNewAccountBtn(){
        createNewAccount.click();
    }
}