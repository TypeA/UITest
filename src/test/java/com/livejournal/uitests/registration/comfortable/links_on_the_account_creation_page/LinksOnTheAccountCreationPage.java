package com.livejournal.uitests.registration.comfortable.links_on_the_account_creation_page;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LinksOnTheAccountCreationPage extends WebTest {

    //Scenario: TOS link(1/3)
    //Scenario: Privacy link(1/3)
    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        open(CreateAccountPage.class);
    }

    //Scenario: TOS link(2/3)
    @When("user click TOS Link")
    public void user_click_TOS_Link() {
        onOpened(CreateAccountPage.class).clickOnTOSLink();
    }

    //Scenario: Privacy link(2/3)
    @When("user click Privacy Link")
    public void user_click_Privacy_Link() {
        onOpened(CreateAccountPage.class).clickOnPrivacyLink();
    }

    //Scenario: TOS link(3/3)
    //Scenario: Privacy link(3/3)
    @Then("user in correct page $page")
    public void user_in_correct_Page(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();
    }

}
