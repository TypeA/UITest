package com.livejournal.uitests.pages.journal_pages;

import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class MyJournalPage extends JournalPage {

    public EntryPage openPostByText(String text) {
        System.out.println("!!!!!!!!! "+"jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        startScript("jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        return onOpened(EntryPage.class);
    }

}
