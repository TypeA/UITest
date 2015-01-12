package com.livejournal.uitests.registration.comfortable.links_on_the_account_creation_page;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

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
    @When("user click link $link")
    public void user_click_TOS_Link(String link) {
        clickOnLink(link);
    }

    //Scenario: TOS link(3/3)
    //Scenario: Privacy link(3/3)
    @Then("user in correct page $page")
    public void user_in_correct_Page(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();
    }

    private void clickOnLink(String link) {

        switch (RegistrationLinks.valueOf(link.toUpperCase())) {
            case TOS:
                onOpened(CreateAccountPage.class)
                        .clickOnTOSLink();
            case PRIVACY:
                onOpened(CreateAccountPage.class)
                        .clickOnPrivacyLink();
            default:
                Assert.fail("Unknown link " + link + "!");
        }

    }
}
