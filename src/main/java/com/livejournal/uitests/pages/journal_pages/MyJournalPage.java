package com.livejournal.uitests.pages.journal_pages;

import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class MyJournalPage extends JournalPage {

    public EntryPage openPostByText(String text) {
        startScript("jQuery('.entryunit:contains(\"" + text + "\") .entryunit__title a')[0].click()");
        return onOpened(EntryPage.class);
    }

}
