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

    public String getPrivacyByText(String post_text) {
        String privacy;
        try {
            privacy = startScript("return jQuery('.b-editentry:contains(\"" + post_text + "\") img:eq(1)').attr('src')")
                    .toString();
            privacy = privacy.substring(privacy.indexOf('_') + 1, privacy.indexOf('?') - 4);
        } catch (Exception ex) {
            privacy = "Public";
        }
        return privacy.replaceAll("protected", "friends")
                .replaceAll("groups", "custom");
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

    public FinishPostForm editSheduledEntryByText(String content, String text, String post_text) {
        startScript("jQuery('.b-editentry:contains(\"" + post_text + "\") a')[0].click()");
        onOpened(EditJournalbml.class)
                .editPostContent(content, text);
        return onDisplayed(FinishPostForm.class);
    }

    public Integer getNumberOfEntryes() {
        String size = startScript("return jQuery('.b-editentry').size()").toString();
        return Integer.valueOf(size);
    }

}
