package pageObject;

import base.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class signup_page extends Setup {

    public signup_page (WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }

    //locators
    @FindBy(how= How.NAME, using = "firstName")
    public WebElement firstName;
    @FindBy(how= How.NAME, using = "lastName")
    public WebElement lastName;
    @FindBy(how= How.NAME, using = "email")
    public WebElement email;
    @FindBy(how= How.NAME, using = "password")
    public WebElement password;
    @FindBy(how= How.NAME, using = "confirmPassword")
    public WebElement confirmPassword;
    @FindBy (how = How.NAME, using = "month")
    public WebElement month;
    @FindBy(how = How.NAME, using = "day")
    public WebElement day;
    @FindBy(how = How.NAME, using = "year")
    public WebElement year;
    @FindBy(how= How.NAME, using = "gender")
    public WebElement gender;
    @FindBy(how = How.NAME, using = "agree")
    public WebElement agree;
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement CreateMyAccount;
    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-success']")
    public WebElement thankYouMsg;
    // functions
    public void enterFirstName(String firstNameValue){
        firstName.sendKeys(firstNameValue);
    }
    public void enterLastName(String lastNameValue){
        lastName.sendKeys(lastNameValue);
    }
    public void enterEmail(String emailValue){
        email.sendKeys(emailValue);
    }
    public void enterPassword(String passwordValue){
        password.sendKeys(passwordValue);
    }
    public void enterConfirmPassword(String confirmPasswordValue){
        confirmPassword.sendKeys(confirmPasswordValue);
    }

    public void enterMonth(String monthValue){
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText(monthValue);
    }

    public void enterDate(String dateValue){
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText(dateValue);

    }

    public void enterYear(String yearValue){
        Select selectYear = new Select (year);
        selectYear.selectByVisibleText(yearValue);
    }
    public void selectGender(){
        List<WebElement> radioButtons = gender.findElements(By.xpath("//input[@type = 'radio']"));
        int size = radioButtons.size();
        for(int i=0; i<size; i++){
            WebElement genderChoice = radioButtons.get(i);
            String selectedValue = genderChoice.getAttribute("value");
            if (selectedValue.equalsIgnoreCase("Female")) {
                genderChoice.click();
            }
        }
    }
    public void agreeChkBox(){
        agree.click();
    }
    public void clickCreateMyAcct(){
        CreateMyAccount.click();
    }
    public void getThankYouMsg(){
        String exp = thankYouMsg.getText();
        String act = "Thank you for sign up";
        Assert.assertEquals(exp, act);

    }


}