package com.livejournal.uitests.authorization.comfortable.daylight_authorization_form_from_different_points;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.unlogged.ShopPageUnlogged;
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
        open(MainPageUnlogged.class);
    }
    
    //Scenario: From Shop by Tokens(1/3)
    //Scenario: From Shop by Rename Account(1/3)
    @Given("unlogged user in Shop")
    public void unlogged_user_in_Shop() {
        open(ShopPageUnlogged.class);
    }

    //Scenario: From Main Page by Login Button(2/3)
    @When("user click on the Login Button in the Header")
    public void user_click_on_the_Login_Button_in_the_Header() {
        onOpened(MainPageUnlogged.class).
                clickOnLoginMenuItem();
    }

    //Scenario: From Main Page by Tokens(2/3)
    @When("user click on the Tokens in the Header")
    public void user_click_on_the_Tokens_in_Header() throws InterruptedException {
        onOpened(MainPageUnlogged.class)
                .moveMouseOverShopMenuItem()
                .clickOnTokensLink();
    }

    //Scenario: From Shop by Rename Account(2/3)
    @When("user click on the Rename Account Link")
    public void user_click_on_the_Rename_Account_Link() {
        onOpened(ShopPageUnlogged.class)
                .clickOnRenameAccountLink();
    }

    //Scenario: From Shop by Tokens(2/3)
    @When("user click on the Tokens Link")
    public void user_click_on_the_Tokens_Link() {
        onOpened(ShopPageUnlogged.class)
                .clickOnTokensLink();
    }

    //Scenario: From Main Page by Login Button(3/3)
    @Then("user see Autorization Form")
    public void user_see_Autorization_Form() {
        verify().that(onDisplayed(LoginForm.class).isDisplayed())
                .ifResultIsExpected("Autorization Form is displayed")
                .ifElse("Autorization Form is not displayed!")
                .finish();
    }

    //Scenario: From Main Page by Tokens(3/3)
    //Scenario: From Shop by Tokens(3/3)
    //Scenario: From Shop by Rename Account(3/3)
    @Then("user in correct page $page")
    public void user_in_correct_page(String page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(page))
                .finish();
    }

}
