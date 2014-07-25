package com.livejournal.uitests.tests.autorization.one_test;

import com.livejournal.uisteps.thucydides.tests.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeaderUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPage;
import com.livejournal.uitests.tests.utility.Verificate;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class FromTheMainPageByLoginButton extends WebTest {

    @Steps
    Verificate verify;

    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        on(MainPage.class);
    }
    
    @When ("user clicks on the Login Button in the Header")
    public void user_clicks_Login_Button_in_Header (){
        on(FullscreenHeaderUnlogged.class).getLoginMenuItem().click();
    }
    
    @Then ("user see Autorization Form")
    public void user_see_Autorization_Form (){
    verify.verifyStatus("Autorization Form is not displayed!!!", on(LoginForm.class).isDisplayed());
    }

}
