package com.livejournal.uitests.authorization.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import com.livejournal.uitests.pages.service_pages.shop_pages.ShopPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author Maxa
 */
public class DaylightAuthorizationFormFromDifferentPoints extends WebTest {

    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        on(MainPageForUnsignedInUser.class);
    }

    @Given("unlogged user in Shop")
    public void unlogged_user_on_Shop_Page() {

        on(ShopPage.class);
    }

    @When("user clicks on the Login Button in the Header")
    public void user_clicks_Login_Button_in_Header() {
        on(MainPageForUnsignedInUser.class).getFullscreenHeaderUnlogged().getLoginMenuItem().click();
    }

    @When("user clicks on the Tokens in the Header")
    public void user_clicks_on_Tokens_in_Header() throws InterruptedException {
        on(MainPageForUnsignedInUser.class).getFullscreenHeaderUnlogged().getShopMenuItem().getShopGeneralLink().moveMouseOver();
        on(MainPageForUnsignedInUser.class).getFullscreenHeaderUnlogged().getShopMenuItem().getTokens().click();
    }

    @When("user clicks on the Rename Account Link")
    public void user_clicks_on_Rename_Account_Link() {
        on(ShopPage.class).getRenameAccount().click();
    }

    @When("user clicks on the Tokens Link")
    public void user_clicks_on_Tokens_Link() {
        on(ShopPage.class).getTokens().click();
    }

    @Then("user see Autorization Form")
    public void user_see_Autorization_Form() {
        verify().expectedResult("Autorization Form is displayed", on(LoginForm.class).isDisplayed())
                .showMessageIfVerificationFailed("Autorization Form is not displayed!!!").finish();
    }

    @Then("user in Autorization Page")
    public void user_in_Autorization_Page() {
        verify().expectedResult("You are on Autorization Page.\nURL contains: /login.bml", getCurrentUrl().contains("/login.bml"))
                .showMessageIfVerificationFailed("You are not on Autorization Page!\nCurrent URL: " + getCurrentUrl() + "\nCorrect URL contains: /login.bml").finish();

    }

}
