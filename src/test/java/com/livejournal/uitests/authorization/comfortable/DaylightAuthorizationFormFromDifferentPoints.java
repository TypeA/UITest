package com.livejournal.uitests.authorization.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
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
        String ok_text = "Autorization Form is displayed";
        String error_text = "Autorization Form is not displayed!!!";
        verify().expectedResult(ok_text, on(LoginForm.class).isDisplayed())
                .showMessageIfVerificationFailed(error_text).finish();
    }

    @Then("user in correct page <page> with URL <URL>")
    public void user_in_Autorization_Page(String page, String URL) {
        verify().expectedResult(VerifyText.okTextForURL(page, URL), getCurrentUrl().contains(URL))
                .showMessageIfVerificationFailed(VerifyText.errorTextForURL(page, URL, getCurrentUrl())).finish();
}

}
