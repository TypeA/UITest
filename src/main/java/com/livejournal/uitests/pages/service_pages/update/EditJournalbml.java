package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public EditJournalbml setPrivacy(String privacy, ArrayList<String> group) throws InterruptedException {
        Thread.sleep(2500);
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

}
