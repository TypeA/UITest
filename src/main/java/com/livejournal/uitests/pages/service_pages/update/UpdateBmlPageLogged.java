package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.AdditionalContent;
import com.livejournal.uitests.pages.service_pages.update.content.PostContentBlock;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @FindBy(css = ".b-updatepage-date-current a")
    private Button changeDate;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-date input")
    private TextField dateField;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-time input")
    private TextField timeField;

    @StepGroup
    public UpdateBmlPageLogged setDateAndTime(String date, String time) {
        changeDate.click();
        dateField.enter(date);
        timeField.enter(time);
        return this;
    }

    @FindBy(name = "community")
    private Select communitySelect;

    @FindBy(css = "label[for=\"community\"]")
    private UIElement postToCommunity;

    @StepGroup
    public UpdateBmlPageLogged selectCommunity(String community) {
        postToCommunity.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return communitySelect.isDisplayed();
            }
        });
        communitySelect.selectByValue(community);
        System.out.println("+++++++++++++ " + communitySelect.getOptions());
        return this;
    }

    @FindBy(name = "action:update")
    private Button addPostButton;

    @StepGroup
    public EntryPageLogged postEntry() {
        addPostButton.click();
        return onOpened(EntryPageLogged.class);
    }

    public PostContentBlock usePostContent() {
        return onDisplayed(PostContentBlock.class);
    }

    public AdditionalContent useAdditionalContent() {
        return onDisplayed(AdditionalContent.class);
    }
}
