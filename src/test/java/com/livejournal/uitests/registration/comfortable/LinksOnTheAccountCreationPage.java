package com.livejournal.uitests.registration.comfortable;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.PrivacyRusPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.TosRusPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author m.prytkova
 */
public class LinksOnTheAccountCreationPage extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        getCurrentBrowser().clearCache();
        on(CreateAccountPage.class);
    }

    @When("user click TOS Link")
    public void user_click_TOS_Link() {
        on(CreateAccountPage.class).getCreateAccountForm().getTosRusLink().click();
    }

    @Then("user in TOS Page")
    public void user_in_TOS_Page() {
        verify().expectedResult("You in TOS Page.\n URL contains: /tos-russian-translation.bml", getCurrentBrowser().getDriver().getCurrentUrl().contains("/tos-russian-translation.bml"))
                .showMessageIfVerificationFailed("You not in TOS Page!\n Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /tos-russian-translation.bml").finish();
    }

    @When("user click Privacy Link")
    public void user_click_Privacy_Link() {
        on(CreateAccountPage.class).getCreateAccountForm().getPrivacyRusLink();
    }

    @Then("user in Privacy Page")
    public void user_in_Privacy_Page() {
               verify().expectedResult("You in Privacy Page.\n URL contains: /privacy-russian-translation.bml", getCurrentBrowser().getDriver().getCurrentUrl().contains("/privacy-russian-translation.bml"))
                .showMessageIfVerificationFailed("You not in TOS Page!\n Current URL: " + getCurrentBrowser().getDriver().getCurrentUrl() + "\nCorrect URL contains: /privacy-russian-translation.bml").finish();
    }

}
