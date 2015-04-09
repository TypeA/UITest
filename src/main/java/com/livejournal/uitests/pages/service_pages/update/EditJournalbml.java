package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
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
public class EditJournalbml extends ServicePageLogged {

    public PostContentBlock postContentBlock;

    @FindBy(name = "action:update")
    private Button saveButton;

    @FindBy(name = "action:delete")
    private Button deleteButton;

    @StepGroup
    public EditJournalbml createPost(String subject, String editorType, String text) {
        postContentBlock.createPost(subject, editorType, text);
        return this;
    }

    @StepGroup
    public EditJournalbml setPrivacy(String privacy, ArrayList<String> group) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return postContentBlock.isDisplayed();
            }
        });
        postContentBlock.setPrivacy(privacy, group);
        return this;
    }

    public ArrayList<String> getAllPrivacy() {
        return postContentBlock.getAllPrivacy();
    }

    @StepGroup
    public String getCurrentPrivacy() {
        return postContentBlock.getCurrentPrivacy();
    }

    @StepGroup
    public void saveEntry() {
        saveButton.click();
    }

    @StepGroup
    public MyJournalPage deleteEntry() {
        deleteButton.click();
        getDriver().switchTo().alert().accept();
        return onOpened(MyJournalPage.class);
    }

    @StepGroup
    public EntryPage editPostContent(String content, String text) throws InterruptedException {
        switch (PostElement.valueOf(content.toUpperCase())) {
            case SUBJECT:
                postContentBlock.setSubject(text);
                break;
            case TEXT:
                postContentBlock.setText(text, "html");
                break;
            case PRIVACY:
                ArrayList<String> group = null;
                postContentBlock.setPrivacy(text, group);
                break;
            case TAGS:
                postContentBlock.setTags(text);
                break;
            default:
                Assert.fail("Unknown post element " + content + "!");
        }
        saveButton.click();
        return onOpened(EntryPage.class);
    }

    @StepGroup
    public String getPostSubject() {
        return postContentBlock.getPostSubject();
    }

}
