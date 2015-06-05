package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.AdditionalContent;
import com.livejournal.uitests.pages.service_pages.update.content.PostContentBlock;
import com.livejournal.uitests.pages.service_pages.update.content.editors.HTMLEditor;
import com.livejournal.uitests.pages.service_pages.update.content.editors.VisualEditor;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/update.bml")
public class UpdateBmlPageLogged extends ServicePageLogged {

    private PostContentBlock postContentBlock;

    @FindBy(name = "community")
    private Select communitySelect;

    @FindBy(css = "label[for=\"community\"]")
    private UIElement postToCommunity;

    @FindBy(name = "action:update")
    private Button addPostButton;

    @FindBy(css = ".b-updatepage-date-current a")
    private Button changeDate;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-date input")
    private TextField dateField;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-time input")
    private TextField timeField;

    @FindBy(name = "dialog-cancel")
    private UIElement closeDraftButton;

    @FindBy(name = "dialog-ok")
    private Button restoreDraft;

    @StepGroup
    public UpdateBmlPageLogged closeDraft() {
        try {
            closeDraftButton.click();
        } catch (Exception ex) {
        }
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged restoreFromDraft() {
        restoreDraft.click();
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setDateAndTime(String date, String time) {
        changeDate.click();
        dateField.enter(date);
        timeField.enter(time);
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged selectCommunity(String community) {
        postToCommunity.click();
        communitySelect.selectByValue(community);
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return communitySelect.isDisplayed();
                }
            });
        }
        return this;
    }

    @StepGroup
    public EntryPage postEntry() {
        addPostButton.click();
        return onOpened(EntryPage.class);
    }

    public PostContentBlock usePostContent() {
        return postContentBlock;
    }

    public AdditionalContent useAdditionalContent() {
        return onDisplayed(AdditionalContent.class);
    }
}
