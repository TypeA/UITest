package com.livejournal.uitests.authorization.comfortable.daylight_authorization_form_from_different_points;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FromMainPageByTokensTest extends WebTest {

    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        on(MainPageForUnsignedInUser.class);
    }

    @When("user clicks on the Tokens in the Header")
    public void user_clicks_on_Tokens_in_Header() throws InterruptedException {
        on(MainPageForUnsignedInUser.class).getFullscreenHeaderUnlogged().getShopMenuItem().getShopGeneralLink().moveMouseOver();
        on(MainPageForUnsignedInUser.class).getFullscreenHeaderUnlogged().getShopMenuItem().getTokens().click();
    }

    @Then("user in Autorization Page")
    public void user_in_Autorization_Page() {
        verify().expectedResult("Autorization Page", getCurrentBrowser().getDriver().getCurrentUrl().contains("/login.bml"))
                .showMessageIfVerificationFailed("You are not on Autorization Page! Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + " Correct URL contains: /login.bml").finish();

    }

}
