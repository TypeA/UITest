package com.livejournal.uitests.pages.service_pages.tools;

import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import com.livejournal.uitests.pages.service_pages.update.FinishPostForm;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/manage/scheduled_posts.bml")
public class SheduledEntriesPage extends ServicePageLogged {

    public String getPostByText(String post_text) {
        return startScript("return jQuery('.b-editentry:contains(\"" + post_text + "\")').text()")
                .toString();
    }

    public String getFirstPostText() {
        return startScript("return jQuery('.b-editentry')[0].textContent")
                .toString();
    }

    public SheduledEntriesPage deleteAllSheduledEntries() {
        while (getNumberOfEntryes() > 6) {
            startScript("jQuery('.b-editentry a')[0].click()");
            onOpened(EditJournalbml.class)
                    .deleteEntry();
            open(SheduledEntriesPage.class);
        }
        return this;
    }

    public MyJournalPage deleteFirstSheduledEntry() {
        startScript("jQuery('.b-editentry a')[0].click()");
        onOpened(EditJournalbml.class)
                .deleteEntry();
        return onOpened(MyJournalPage.class);
    }

    public FinishPostForm editFirstSheduledEntry(String content, String text) throws InterruptedException {
        startScript("jQuery('.b-editentry a')[0].click()");
        onOpened(EditJournalbml.class)
                .editPostContent(content, text);
        return onDisplayed(FinishPostForm.class);
    }

    public Integer getNumberOfEntryes() {
        String size = startScript("return jQuery('.b-editentry').size()").toString();
        return Integer.valueOf(size);
    }

}
