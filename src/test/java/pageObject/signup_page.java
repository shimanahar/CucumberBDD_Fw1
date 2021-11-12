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
    // rule for PageObject is -- You should  create a PageFactory for every single page that you are going to create
    // how?
    public signup_page (WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }
    // locators
    //<input type="text" name="firstName" value="" class="form-control input-lg" placeholder="First Name">
    @FindBy(how= How.NAME, using = "firstName")
    public WebElement firstName;
    //<input type="text" name="lastName" value="" class="form-control input-lg" placeholder="Last Name">
    @FindBy (how= How.NAME, using = "lastName")
    public WebElement lastName;
    //<input type="text" name="email" value="" class="form-control input-lg" placeholder="Your Email">
    @FindBy(how= How.NAME, using = "email")
    public WebElement email;
    //<input type="password" name="password" value="" class="form-control input-lg" placeholder="Password">
    @FindBy(how = How.NAME, using = "password")
    public WebElement passWord;
    //<input type="password" name="confirmPassword" value="" class="form-control input-lg" placeholder="Confirm Password">
    @FindBy(how = How.NAME, using = "confirmPassword")
    public WebElement confirmPassword;

    // <select name="month" class="form-control input-lg">
    @FindBy (how = How.NAME, using = "month")
    public WebElement month;
    // <select name="day" class="form-control input-lg">
    @FindBy(how = How.NAME, using = "day")
    public WebElement day;
    // <select name="year" class="form-control input-lg">
    @FindBy(how = How.NAME, using = "year")
    public WebElement year;
    //<input type="radio" name="gender" value="male" id="male">
    @FindBy(how = How.ID, using = "male")
    public WebElement male;
    // <input type="radio" name="gender" value="female" id="female">
    @FindBy(how = How.ID, using = "female")
    public WebElement female;

    //***********Dynamic Select*****************
    @FindBy(how= How.NAME, using = "gender")
    public WebElement radioGender;
    //****************************

    // <input class="form-check-input" type="checkbox" value="1" name="agree" id="defaultCheck1">
    @FindBy(how = How.NAME, using = "agree")
    public WebElement agree;

    // <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">Create my account</button>
    // String Button_CreateMyAccount = driver.findElement(By.xpath("//button[@type='submit']")).click();
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement createMyAccountBtn;

    // Thank you for sign up, here your id - verifying with id-TTCPf3KQ
    // driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
    @FindBy(how= How.XPATH, using = "//div[@class='alert alert-success']")
    public WebElement thankYouMessage;

    // Functions
    public void enterFirstName(String firstNameValue){
        firstName.clear();
        firstName.sendKeys(firstNameValue);
    }
    public void enterLastName(String lastNameValue){
        lastName.clear();
        lastName.sendKeys(lastNameValue);
    }
    public void enterEmail(String emailValue){
        email.clear();
        email.sendKeys(emailValue);
    }
    public void enterPassword(String passwordValue){
        passWord.clear();
        passWord.sendKeys(passwordValue);
    }
    public void enterConfirmPassword(String confirmPasswordValue){
        confirmPassword.clear();
        confirmPassword.sendKeys(confirmPasswordValue);
    }
    // Single element from dropdown: Birth Date
    // WebElement month = driver.findElement(By.name("month"));
    // Select ddlMonth = new Select(month);
    // ddlMonth.selectByVisibleText("Dec"); // Select month Name by VisibleText / by Index / by Value
    public void enterBirthMonth(String birthMothValue){
        Select ddlMonth = new Select(month);
        ddlMonth.selectByVisibleText(birthMothValue);
    }
    public void enterBirthDay(int birthDayValue){
        Select ddlDay = new Select(day);
        ddlDay.selectByIndex(birthDayValue);
    }
    public void enterBirthYear(String birthYearValue){
        Select ddlYear = new Select(year);
        ddlYear.selectByValue(birthYearValue);
    }
    // select the first radio> 'Male' by using label
    // Male click
    //  public void genderMale(){
    //     male.click();
    //  }

    // select the Second radio> 'Female' by using label
    //  public void genderFemale(){
    //      female.click();
    //  }

    //***************** HW: Gender Radio btn******************************
    // Find out the list of radio button and select the 2nd radio button (Female)
    //To find the all radio button > //input[@type = 'radio']
    public void genderChoice(){
        List<WebElement> gender = radioGender.findElements(By.xpath("//input[@type = 'radio']"));
        System.out.println("Size of gender: "+gender.size());
        for(int i=0; i<gender.size(); i++){
            WebElement genderChoice = gender.get(i);
            String genderValue = genderChoice.getAttribute("value");
            if (genderValue.equalsIgnoreCase("Female")){
                genderChoice.click();
                System.out.println(genderChoice.isSelected());  // boolean value return print
            }
        }

    }

    public void agreeClickBox(){
        agree.click();
    }
    public void clickCreateMyAccountBtn(){
        createMyAccountBtn.click();
    }

    public void getThankYouMessage(){
        String actualMessage = thankYouMessage.getText().substring(0,21);
        String expectedMessage = "Thank you for sign up";
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage );
    }
}