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

    @StepGroup
    public String getPostTime() {
        return startScript("return jQuery('.b-singlepost-author-date.published.dt-published')[0].textContent")
                .toString();
    }

    @StepGroup
    public Boolean containsLjUser(String ljuser) {
        Boolean fl1 = false;
        Boolean fl2 = false;
        String res = startScript("return jQuery(\".e-content span\").is(\"[lj\\\\:user='" + ljuser + "']\")").toString();
        switch (res.toUpperCase()) {
            case "TRUE":
                fl1 = true;
                break;
            case "FALSE":
                fl1 = false;
                break;
        }
        if (startScript("return jQuery(\".e-content span\")[0].textContent").toString().equals(ljuser)) {
            fl2 = true;
        }
        return fl1 && fl2;
    }

}
