package stepDef;
import base.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.signup_page;

public class signup_steps extends Setup {

    signup_page sgnUp = new signup_page(driver);
    Faker faker = new Faker();

    // Calling all methods from pageObject>signupPage
    @And("I enter valid student information")
    public void iEnterValidStudentInformation() {
        sgnUp.enterFirstName(faker.name().firstName());
        sgnUp.enterLastName(faker.name().lastName());
        sgnUp.enterEmail(faker.internet().safeEmailAddress());
        // Password
        sgnUp.enterPassword("test@12345");
        sgnUp.enterConfirmPassword("test@12345");
        // Birth Date
        sgnUp.enterBirthMonth("Dec");
        sgnUp.enterBirthDay(15);
        sgnUp.enterBirthYear("1984");
        // when Gender is male
        // sgnUp.genderMale();
        sgnUp.genderChoice();   // Conditional male click
    }


    @When("I click on Create my account button")
    public void iClickOnCreateMyAccountButton() {
        sgnUp.clickCreateMyAccountBtn();
    }

    @Then("I should see Thank you for sign up message")
    public void iShouldSeeThankYouForSignUpMessage() {
        sgnUp.getThankYouMessage();

    }
}

