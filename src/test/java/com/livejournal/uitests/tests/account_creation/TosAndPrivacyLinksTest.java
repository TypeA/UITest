/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.account_creation;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PrivacyRusPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.TosRusPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class TosAndPrivacyLinksTest extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user click TOS Link")
    public void user_click_TOS_Link() {
        on(CreateAccountPage.class);
        verify.verifyText("Initialized Create Account Page!!!   " + getCurrentBrowser().getDriver().getCurrentUrl(), "", "");
        on(CreateAccountPage.class).getCreateAccountForm().getTosRusLink().click();
        verify.verifyText("Click on TOS Link!!!   " + getCurrentBrowser().getDriver().getCurrentUrl(), "", "");
    }

    @Then("user in TOS Page")
    public void user_in_TOS_Page() {
        on(TosRusPage.class);
        verify.verifyText("Initialized TOS Page!!!   " + getCurrentBrowser().getDriver().getCurrentUrl(), "", "");
    }

    @When("user click Privacy Link")
    public void user_click_Privacy_Link() {
        on(CreateAccountPage.class);
        verify.verifyText("Initialized Create Account Page!!!   " + getCurrentBrowser().getDriver().getCurrentUrl(), "", "");
        on(CreateAccountPage.class).getCreateAccountForm().getPrivacyRusLink();
        verify.verifyText("Click on Privacy Link!!!   " + getCurrentBrowser().getDriver().getCurrentUrl(), "", "");
    }

    @Then("user in Privacy Page")
    public void user_in_Privacy_Page() {
        on(PrivacyRusPage.class);
        verify.verifyText("Initialized Privacy Page!!!   " + getCurrentBrowser().getDriver().getCurrentUrl(), "", "");
    }

}
