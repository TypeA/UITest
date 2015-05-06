package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.ColorBubble;
import com.livejournal.uitests.pages.service_pages.update.bubbles.FontBubble;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LinkBubble;
import com.livejournal.uitests.pages.service_pages.update.forms_and_blocks.LJUserBubble;
import com.livejournal.uitests.pages.service_pages.update.forms_and_blocks.PostContentBlock;
import com.livejournal.uitests.pages.service_pages.update.visualEditor.HtmlsTags;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private HtmlsTags htmlTags;

    private FontBubble fontBubble;

    private ColorBubble colorBubble;

    private LinkBubble linkBubble;

    @FindBy(name = "community")
    private Select communitySelect;

    @FindBy(css = "label[for=\"community\"]")
    private UIElement postToCommunity;

    @FindBy(name = "action:update")
    private Button addPostButton;

    /////////////////////////// date
    @FindBy(css = ".b-updatepage-date-current a")
    private Button changeDate;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-date input")
    private TextField dateField;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-time input")
    private TextField timeField;

    /////////////////////////// draft
    @FindBy(name = "dialog-cancel")
    private UIElement closeDraftButton;

    @FindBy(name = "dialog-ok")
    private Button restoreDraft;

    @FindBy(css = ".b-updatepage-tab-visual")
    private Button visualEditor;

    @StepGroup
    public UpdateBmlPageLogged closeDraft() {
        try {
            closeDraftButton.click();
            return this;
        } catch (Exception ex) {
            return this;
        }
    }

    @StepGroup
    public UpdateBmlPageLogged restoreFromDraft() {
        restoreDraft.click();
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged createPost(String subject, String editorType, String text) {
        postContentBlock.createPost(subject, editorType, text);
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged addText(String text) {
        postContentBlock.postHtmlField.type(text);
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setTextStyle(String style_text) {
        htmlTags.setTextStyle(style_text);
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setTextFont(String font_text) {
        htmlTags.clickFont();
        fontBubble.setTextFont(font_text);
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setTextColor(String color_text) {
        htmlTags.clickColor();
        colorBubble.setTextColor(color_text);
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged addLink(String url, Boolean newWindow) {
        htmlTags.clickLink();
        linkBubble.addLink(url, newWindow);
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
    public UpdateBmlPageLogged setPrivacy(String privacy, ArrayList<String> group) {
        postContentBlock.setPrivacy(privacy, group);
        return this;
    }

    public UpdateBmlPageLogged selectCommunity(String community) {
        communitySelect.selectByValue(community);
        /*   try {
         Thread.sleep(300);
         } catch (InterruptedException ex) {
         // Logger.getLogger(UpdateBmlPageLogged.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return communitySelect.isDisplayed();
            }
        });
        return this;
    }

    @StepGroup
    public EntryPage postEntry() {
        addPostButton.click();
        return onOpened(EntryPage.class);
    }

    @StepGroup
    public UpdateBmlPageLogged postInCommunity() {
        postToCommunity.click();
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
    public LJUserBubble openLJUserBubble() {
        postContentBlock.openLJUserBubble();
        return onDisplayed(LJUserBubble.class);
    }

    @StepGroup
    public String getPostSubject() {
        return postContentBlock.getPostSubject();
    }

    @StepGroup
    public UpdateBmlPageLogged setVisualEditor() {
        visualEditor.click();
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged enterTextToVisualEditor(String text) {
        switchToVisualEditot().sendKeys(text);
        getDriver().switchTo().defaultContent();
        return this;
    }

    @StepGroup
    public WebElement switchToVisualEditot() {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title[contains(.,'Rich text editor')]]")));
        WebElement bodyOfMessage = getDriver().findElement(By.xpath("//body[@class='lj-main-body']"));
        return bodyOfMessage;
    }

}
