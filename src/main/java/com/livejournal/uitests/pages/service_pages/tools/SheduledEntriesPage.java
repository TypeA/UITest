package com.livejournal.uitests.pages.service_pages.tools;

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

    public void deleteAllSheduledEntries() {
        String size = startScript("return jQuery('.b-editentry a').size()").toString();
        while (Integer.valueOf(size) > 6) {
            startScript("jQuery('.b-editentry a')[0].click()");
            onOpened(EditJournalbml.class)
                    .deleteEntry();
            open(SheduledEntriesPage.class);
            size = startScript("return jQuery('.b-editentry a').size()").toString();
        }

    }
}
