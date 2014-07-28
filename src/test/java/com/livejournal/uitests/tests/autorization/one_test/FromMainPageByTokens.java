package com.livejournal.uitests.tests.autorization.one_test;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FromMainPageByTokens extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        on(MainPageUnlogged.class);
    }

    @When("user clicks on the Tokens in the Header")
    public void user_clicks_on_Tokens_in_Header() {
        on(MainPageUnlogged.class).getFullscreenHeaderUnlogged().getShopMenuItem().getShopGeneralLink().click();
        
    }
    
    @Then ("user in Autorization Page")
    public void user_in_Autorization_Page(){
    
    }

}
