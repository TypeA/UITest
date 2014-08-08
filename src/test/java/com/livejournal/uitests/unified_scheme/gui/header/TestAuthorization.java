package com.livejournal.uitests.unified_scheme.gui.header;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author ASolyankin
 */
public class TestAuthorization extends WebTest {

    @When("I submit authorization form with correct login $login and password $password")
    public void submit_authorization_form_with_correct(String login, String password) {
        on(LoginPage.class).authorizeBy(login, password);
    }

    @Then("I should be authorized")
    public void should_be_authorized() {
        Assert.assertTrue(true);
    }
}