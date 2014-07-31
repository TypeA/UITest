package com.livejournal.uitests.tests.authorization;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.shop_pages.ShopPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FromShopByTokensTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user in Shop")
    public void unlogged_user_on_Shop_Page() {
        on(ShopPage.class);
    }

    @When("user clicks on the Tokens Link")
    public void user_clicks_on_Tokens_Link() {
        on(ShopPage.class).getTokens().click();
    }

    @Then("user in Autorization Page")
    public void user_in_Autorization_Page() {
    verify.verifyText("You are not on Autorization Page!!!", getCurrentBrowser().getDriver().getCurrentUrl(), "/login.bml");
    }

}
