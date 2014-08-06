package com.livejournal.uitests.registration.comfortable.links_on_the_account_creation_page;

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
public class TosAndPrivacyLinksTest extends WebTest {

    @Given("unlogged user on Registration Form")
    public void unlogged_user_on_Registration_Form() {
        on(CreateAccountPage.class);
    }

    @When("user click TOS Link")
    public void user_click_TOS_Link() {
        on(CreateAccountPage.class);
        verify().expectedResult("Initialized Create Account Page. URL: " + getUrl(), true).showMessageIfVerificationFailed(null).finish();
        on(CreateAccountPage.class).getCreateAccountForm().getTosRusLink().click();
        verify().expectedResult("Click on TOS Link. URL: " + getUrl(), true).showMessageIfVerificationFailed(null).finish();
    }

    @Then("user in TOS Page")
    public void user_in_TOS_Page() {
        on(TosRusPage.class);
      //  verify.verifyText("Initialized TOS Page!!!   " + getUrl(), "", "");
    }

    @When("user click Privacy Link")
    public void user_click_Privacy_Link() {
        on(CreateAccountPage.class);
      //  verify.verifyText("Initialized Create Account Page!!!   " + getUrl(), "", "");
        on(CreateAccountPage.class).getCreateAccountForm().getPrivacyRusLink();
      //  verify.verifyText("Click on Privacy Link!!!   " + getUrl(), "", "");
    }

    @Then("user in Privacy Page")
    public void user_in_Privacy_Page() {
        on(PrivacyRusPage.class);
      //  verify.verifyText("Initialized Privacy Page!!!   " + getUrl(), "", "");
    }

    private String getUrl() {
        WebDriver driver = getCurrentBrowser().getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.mpPageReloaded;");
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return js.executeScript("return window.bind('DOMContentReady', function(){});").equals("complete");
            }
        });
        return driver.getCurrentUrl();
    }

}
