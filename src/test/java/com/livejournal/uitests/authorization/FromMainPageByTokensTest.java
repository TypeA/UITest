package com.livejournal.uitests.authorization;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import com.livejournal.uitests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FromMainPageByTokensTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        on(MainPageForUnsignedInUser.class);
    }

    @When("user clicks on the Tokens in the Header")
    public void user_clicks_on_Tokens_in_Header() {
        on(MainPageForUnsignedInUser.class).getFullscreenHeaderUnlogged().getShopMenuItem().getShopGeneralLink().moveMouseOver();
        //допиши! пока не работает метод moveMouseOver
    }
    
    @Then ("user in Autorization Page")
    public void user_in_Autorization_Page(){
    
    }

}
