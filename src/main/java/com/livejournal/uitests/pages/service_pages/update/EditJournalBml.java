package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uitests.pages.service_pages.update.content.PostContentBlock;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.journal_pages.EntryPageLogged;
import com.livejournal.uitests.pages.journal_pages.MyJournalPageLogged;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.AdditionalContent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/editjournal.bml")
public class EditJournalBml extends ServicePageLogged {

    public PostContentBlock postContentBlock;

    @FindBy(name = "action:update")
    private Button saveButton;

    @FindBy(name = "action:delete")
    private Button deleteButton;

    @StepGroup
    public void editPostContent(String content, String text) {
        switch (content.toUpperCase()) {
            case "SUBJECT":
                usePostContent()
                        .setSubject(text);
                break;
            case "TEXT":
                usePostContent()
                        .setPostText(text, "html");
                break;
            case "PRIVACY":
                String[] stringArray = text.split("/");
                ArrayList<String> groups = new ArrayList<>();
                groups.addAll(Arrays.asList(stringArray));
                String privacy = groups.get(0);
                groups.remove(0);
                usePostContent()
                        .setPrivacy(privacy, groups);
                break;
            case "TAGS":
                usePostContent()
                        .setTags(text);
                break;
            default:
                Assert.fail("Unknown content " + content + "!");
        }
        saveButton.click();
    }

    @StepGroup
    public EntryPageLogged saveEntry() {
        saveButton.click();
        return onOpened(EntryPageLogged.class);
    }

    @StepGroup
    public MyJournalPageLogged deleteEntry() {   
        deleteButton.click();
        getDriver().switchTo().alert().accept();
        return onOpened(MyJournalPageLogged.class);
    }

    @WhenPageOpens
    public void waitPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return postContentBlock.isDisplayed();
            }
        });
    }

    public PostContentBlock usePostContent() {
        return postContentBlock;
    }

    public AdditionalContent useAdditionalContent() {
        return onDisplayed(AdditionalContent.class);
    }

}
