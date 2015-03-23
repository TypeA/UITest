package com.livejournal.uitests.pages.service_pages.tools;

import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
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

  /*  public MyJournalPage editFirstSheduledEntry() {
        startScript("jQuery('.b-editentry a')[0].click()");
        onOpened(EditJournalbml.class);
                
                
                
              
        return onOpened(MyJournalPage.class);
    }*/

    public Integer getNumberOfEntryes() {
        String size = startScript("return jQuery('.b-editentry a').size()").toString();
        return Integer.valueOf(size);
    }
}
