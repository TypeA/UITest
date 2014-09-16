package com.livejournal.uitests.authorization.comfortable.daylight_authorization_form_from_different_points;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.ShopPageUnlogged;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author Maxa
 */
public class DaylightAuthorizationFormFromDifferentPoints extends WebTest {

    //Scenario: From Main Page by Login Button(1/3)
    //Scenario: From Main Page by Tokens(1/3)
    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        on(MainPageUnlogged.class);
    }
    
    //Scenario: From Shop by Tokens(1/3)
    //Scenario: From Shop by Rename Account(1/3)
    @Given("unlogged user in Shop")
    public void unlogged_user_in_Shop() {
        on(ShopPageUnlogged.class);
    }

    //Scenario: From Main Page by Login Button(2/3)
    @When("user click on the Login Button in the Header")
    public void user_click_on_the_Login_Button_in_the_Header() {
        on(MainPageUnlogged.class)
                .getFullscreenHeaderUnlogged()
                .clickOnLoginMenuItem();
    }

    //Scenario: From Main Page by Tokens(2/3)
    @When("user click on the Tokens in the Header")
    public void user_click_on_the_Tokens_in_Header() throws InterruptedException {
        on(MainPageUnlogged.class)
                .getFullscreenHeaderUnlogged()
                .moveMouseOverShopMenuItem()
                .clickOnTokensLink();
    }

    //Scenario: From Shop by Rename Account(2/3)
    @When("user click on the Rename Account Link")
    public void user_click_on_the_Rename_Account_Link() {
        on(ShopPageUnlogged.class)
                .clickOnRenameAccountLink();
    }

    //Scenario: From Shop by Tokens(2/3)
    @When("user click on the Tokens Link")
    public void user_click_on_the_Tokens_Link() {
        on(ShopPageUnlogged.class)
                .clickOnTokensLink();
    }

    //Scenario: From Main Page by Login Button(3/3)
    @Then("user see Autorization Form")
    public void user_see_Autorization_Form() {
        verify().that(on(LoginForm.class).isDisplayed())
                .ifResultIsExpected("Autorization Form is displayed")
                .ifElse("Autorization Form is not displayed!")
                .finish();
    }

    //Scenario: From Main Page by Tokens(3/3)
    //Scenario: From Shop by Tokens(3/3)
    //Scenario: From Shop by Rename Account(3/3)
    @Then("user in correct page $page with URL $URL")
    public void user_in_correct_page_with_URL(String page, String URL) {
        verify().that(getCurrentUrl().contains(URL))
                .ifResultIsExpected(VerifyText.okTextForURL(page, URL))
                .ifElse(VerifyText.errorTextForURL(page, URL, getCurrentUrl()))
                .finish();
    }

}
