package com.livejournal.uitests.authorization.comfortable.daylight_authorization_form_from_different_points;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.shop_pages.ShopPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FromShopByRenameAccountTest extends WebTest {

    @Given("unlogged user in Shop")
    public void unlogged_user_on_Shop_Page() {
        on(ShopPage.class);
    }

    @When("user clicks on the Rename Account Link")
    public void user_clicks_on_Rename_Account_Link() {
        on(ShopPage.class).getRenameAccount().click();
    }

    @Then("user in Autorization Page")
    public void user_in_Autorization_Page() {
        verify().expectedResult("Autorization Page", getCurrentBrowser().getDriver().getCurrentUrl().contains("/login.bml"))
                .showMessageIfVerificationFailed("You are not on Autorization Page! Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + " Correct URL contains: /login.bml").finish();
    }

}
