package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author s.savinykh
 */
public class EntryPage extends JournalPage{
    
    
       public EditJournalbml EditScriptForStyle() {
        String script = "return jQuery('.b-controls-edit .b-controls-bg').click()";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "return jQuery('.j-e-buttons-item-edit_entry')[0].click()";
            ((JavascriptExecutor) getDriver()).executeScript(script);
        }
        return onOpened(EditJournalbml.class);
    } 
}
