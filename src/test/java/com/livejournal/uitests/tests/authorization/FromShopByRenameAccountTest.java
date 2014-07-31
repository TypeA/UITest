/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class FromShopByRenameAccountTest extends WebTest{
    
    
    @Steps
    Verificate verify;

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
    verify.verifyText("You are not on Autorization Page!!!", getCurrentBrowser().getDriver().getCurrentUrl(), "/login.bml");
    }
    
}
