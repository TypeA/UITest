package com.livejournal.uitests.pages.journal_pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class EntryPage extends MyJournalPage {

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
