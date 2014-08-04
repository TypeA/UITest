package com.livejournal.uitests.authorization.useful.log_in_with_correct_data;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeader;
import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeaderLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class SuccessfullyAutorizationTest extends WebTest {
    
    @Steps
    Verificate verify;
    
    @Given("unlogged user on Login Form")
    public void unlogged_user_on_Login_Form() {
        on(LoginPage.class);
        
    }
    
    @When("user enter correct data: name $name, password $password and clicks LogIn")
    public void user_login(String name, String password) {
        on(LoginPage.class).getLoginForm().authorizeBy(name, password);
    }
    
    @Then ("user logged in")
    public void user_logged_in (){
        on(FullscreenHeader.class).getLogo().getLogoPic().click();
        verify.verifyStatus("The user is not logged!!!", on(FullscreenHeaderLogged.class).myJournalMenuItem.myJournal.isDisplayed());
    }
    
}
