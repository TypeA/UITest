package com.livejournal.uitests.pages.service_pages.tools;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.content.FinishPostForm;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/manage/scheduled_posts.bml")
public class SheduledEntriesPage extends ServicePageLogged {

    @FindBy(css = ".b-editentries-form")
    private TextField communityInput;

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
            privacy = "public";
        }
        return privacy.replaceAll("protected", "friends")
                .replaceAll("groups", "custom");
    }

    public SheduledEntriesPage deleteAllSheduledEntries() {
        while (getNumberOfEntryes() > 6) {
            startScript("jQuery('.b-editentry a')[0].click()");
            onOpened(EditJournalBml.class)
                    .deleteEntry();
            open(SheduledEntriesPage.class);
        }
        return this;
    }

    public MyJournalPage deleteFirstSheduledEntry() {
        startScript("jQuery('.b-editentry a')[0].click()");
        onOpened(EditJournalBml.class)
                .deleteEntry();
        return onOpened(MyJournalPage.class);
    }

    public EditJournalBml editSheduledEntryByText(String post_text) {
        startScript("jQuery('.b-editentry:contains(\"" + post_text + "\") a')[0].click()");
        return onOpened(EditJournalBml.class);
    }

    public FinishPostForm editSheduledEntryByText(String content, String text, String post_text) {
        startScript("jQuery('.b-editentry:contains(\"" + post_text + "\") a')[0].click()");
        onOpened(EditJournalBml.class)
                .editPostContent(content, text);
        return onDisplayed(FinishPostForm.class);
    }

    public Integer getNumberOfEntryes() {
        String size = startScript("return jQuery('.b-editentry').size()").toString();
        return Integer.valueOf(size);
    }

    @WhenPageOpens
    private void waitPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return communityInput.isDisplayed();
            }
        });
    }

}
