package com.livejournal.uitests.adaptive.comfortable.adaptive_settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.JournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

/**
 *
 * @author s.savinykh
 */
public class AdaptiveSettings extends WebTest {

    //Scenario: Unlogged user see correct style (1/2)
    @Given("unlogged user on journal $journal page")
    public void unlogged_user_on_journal_page(String journal) {
        open(JournalPage.class, new Url().setPrefix(journal + "."));
    }

    //Scenario: Logged user see correct style(1/2)
    @Given("logged user $user on journal $journal page")
    public void logged_user_on_journal_page(String user, String journal) {
        open(LoginPageUnlogged.class).authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(JournalPage.class, new Url().setPrefix(journal + "."));
    }

    //Scenario: Unlogged user see correct style (2/2)
    //Scenario: Logged user see correct style(2/2)
    @Then("user see correct style $style in journal $journal page")
    public void user_see_correct_style(String style, String journal) {
        verify().that(isCorrectStyle(style))
                .ifResultIsExpected("Unlogged see correct style ( " + style + " ) in " + journal + " journal")
                .ifElse("Unlogged see incorrect style in " + journal + " journal")
                .finish();

    }

    private Boolean isCorrectStyle(String style) {
        Boolean correct = false;
        switch (style.toUpperCase()) {
            case "AIR":
                correct = !startScript("return jQuery('.entryunit__title a')[0].href").toString().isEmpty();
                break;
            case "LIBRARIAN":
                correct = !startScript("return jQuery('.j-e-title a')[0].href").toString().isEmpty();
                break;
            case "LIGHT_CLOUDS":
                correct = !startScript("return jQuery('.asset-name.page-header2 a')[0].href").toString().isEmpty();
                break;
        }
        return correct;
    }
}
