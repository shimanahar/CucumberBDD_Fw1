package stepDef;

import base.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.signup_page;

public class signup_steps extends Setup {
    signup_page sp = new signup_page(driver);
    Faker faker = new Faker();

    @And("I enter a Student information")
    public void iEnterAStudentInformation() {
        sp.enterFirstName(faker.name().firstName());
        sp.enterLastName(faker.name().lastName());
        sp.enterEmail(faker.internet().safeEmailAddress());
        sp.enterPassword("Test12345");
        sp.enterConfirmPassword("Test12345");
        sp.enterMonth("Feb");
        sp.enterDate("29");
        sp.enterYear("1975");
        sp.selectGender();
        sp.agreeChkBox();



        // HW - COMPLETE THE Signup FORM AND SIGN UP FOR AN USER AND ASSERT "Thank you for sign up" message
        // Find out the list of radio button and select the 2nd radio button
        // select the first radio by using label
    }

    @When("I click on Create my new account button")
    public void iClickOnCreateMyNewAccountButton() {
        sp.clickCreateMyAcct();
    }

    @Then("I should see Thank You for sign up message")
    public void iShouldSeeThankYouForSignUpMessage() {
        sp.getThankYouMsg();
    }


    @And("I click Create New Account Button in Login Page")
    public void iClickCreateNewAccountButtonInLoginPage() {

    }

    @And("I enter valid student information")
    public void iEnterValidStudentInformation() {


    }


    @When("I click on Create my account button")
    public void iClickOnCreateMyAccountButton() {
    }
}











