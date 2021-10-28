package stepDef;

import base.Setup;
import io.cucumber.java.en.Then;
import pageObject.profile_page;

public class myProfile_step extends Setup {

    profile_page pf = new profile_page(driver);

    @Then("I should be able to successfully log in")
    public void iShouldBeAbleToSuccessfullyLogIn() {

        pf.getActualwelcomeMessage();
    }
}
