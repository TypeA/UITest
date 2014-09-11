package com.livejournal.uitests.authorization.comfortable.daylight_authorization_form_from_different_points;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.ShopPage;
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
        on(ShopPage.class);
    }

    //Scenario: From Main Page by Login Button(2/3)
    @When("user click on the Login Button in the Header")
    public void user_click_on_the_Login_Button_in_the_Header() {
        on(MainPageUnlogged.class).getFullscreenHeaderUnlogged().getLoginMenuItem().click();
    }

    //Scenario: From Main Page by Tokens(2/3)
    @When("user click on the Tokens in the Header")
    public void user_click_on_the_Tokens_in_Header() throws InterruptedException {
        on(MainPageUnlogged.class).getFullscreenHeaderUnlogged().getShopMenuItem().getShopGeneralLink().moveMouseOver();
        on(MainPageUnlogged.class).getFullscreenHeaderUnlogged().getShopMenuItem().getTokens().click();
    }

    //Scenario: From Shop by Rename Account(2/3)
    @When("user click on the Rename Account Link")
    public void user_click_on_the_Rename_Account_Link() {
        on(ShopPage.class).getRenameAccount().click();
    }

    //Scenario: From Shop by Tokens(2/3)
    @When("user click on the Tokens Link")
    public void user_click_on_the_Tokens_Link() {
        on(ShopPage.class).getTokens().click();
    }

    //Scenario: From Main Page by Login Button(3/3)
    @Then("user see Autorization Form")
    public void user_see_Autorization_Form() {
        String ok_text = "Autorization Form is displayed";
        String error_text = "Autorization Form is not displayed!!!";
        verify().that(on(LoginForm.class).isDisplayed())
                .ifResultIsExpected(ok_text)
                .ifElse(error_text)
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
