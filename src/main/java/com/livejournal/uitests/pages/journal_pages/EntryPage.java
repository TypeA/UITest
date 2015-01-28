package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class EntryPage extends JournalPage {

    @StepGroup
    public EditJournalbml clickOnEditButton() {
        String script = "jQuery('.b-linkbar-item a[href*=\"editjournal\"]')[0].click()";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "jQuery('.j-e-buttons-item-edit_entry')[0].click()";
            ((JavascriptExecutor) getDriver()).executeScript(script);
        }
        return onOpened(EditJournalbml.class);
    }

    @StepGroup
    public String getPostText() {
        String script = "return jQuery('.b-singlepost-body.entry-content.e-content')[0].textContent";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "return jQuery('.j-e-text')[0].textContent";
        }
        return startScript(script).toString().trim();
    }
}
