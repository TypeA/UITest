package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LJUserBubble;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    /////////////////////////// date
    @FindBy(css = ".b-updatepage-date-current a")
    private Button changeDate;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-date input")
    private TextField dateField;

    @FindBy(css = ".b-updatepage-date-new .b-updatepage-date-new-time input")
    private TextField timeField;

    /////////////////////////// draft
    @FindBy(css = ".b-popup.b-popupus.b-popupus-blue.b-popupus-confirm[style*='position'] .i-popup-close")
    private UIElement closeDraftButton;

    @FindBy(name = "dialog-ok")
    private Button restoreDraft;

    @FindBy(css = ".b-updatepage-tab-visual")
    private Button visualEditor;

    ////////html_tags in visual editor
    @FindBy(css = ".cke_button_bold")
    private Button boldText;

    @FindBy(css = ".cke_button_italic")
    private Button italicText;

    @FindBy(css = ".cke_button_underline")
    private Button underlineText;

    @FindBy(css = ".cke_button_LJFont")
    private Button fontText;

    @FindBy(css = ".b-fontsize-select-item-tiny")
    private Button tinyFontText;

    @FindBy(css = ".b-fontsize-select-item-small")
    private Button smallFontText;

    @FindBy(css = ".b-fontsize-select-item-normal")
    private Button normalFontText;

    @FindBy(css = ".b-fontsize-select-item-large")
    private Button largeFontText;

    @FindBy(css = ".b-fontsize-select-item-huge")
    private Button hugeFontText;

    @FindBy(css = ".cke_button_LJColor")
    private Button colorText;

    @FindBy(css = ".b-colorpicker-controls-hex")
    private TextField codeColor;

    @FindBy(css = "button.b-flatbutton[ng-click='submitColor()']")
    private Button chooseColorButton;

    @FindBy(css = ".cke_button_LJLink2")
    private Button buttonToolLink;

    @FindBy(css = ".b-updateform-bubble-input")
    private TextField inputUrl;

    @FindBy(css = ".b-updateform-bubble-checkbox")
    private Button checkboxNewWindow;

    @FindBy(xpath = "//button[@class='b-flatbutton b-flatbutton-simple  ng-binding' and @lj-disabled[contains(.,'link')]]")
    private Button addButtonLink;

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
    public UpdateBmlPageLogged setStyleText(String style_text) {
        switch (style_text) {
            case "BOLD":
                boldText.click();
                break;
            case "ITALIC":
                italicText.click();
                break;
            case "UNDERLINED":
                underlineText.click();
                break;
        }
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setFontText(String font_text) {
        fontText.click();
        switch (font_text) {
            case "TINY":
                tinyFontText.click();
                break;
            case "SMALL":
                smallFontText.click();
                break;
            case "NORMAL":
                normalFontText.click();
                break;
            case "LARGE":
                largeFontText.click();
                break;
            case "HUGE":
                hugeFontText.click();
                break;
        }
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setColorText(String color) {
        colorText.click();
        codeColor.enter(color);
        chooseColorButton.click();
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged setVisualEditor() {
        visualEditor.click();
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged addLink(String url, Boolean newWindow) {
        buttonToolLink.click();
        inputUrl.enter(url);
        if (newWindow) {
            checkboxNewWindow.click();
        }
        addButtonLink.click();
        return this;
    }

    @StepGroup
    public UpdateBmlPageLogged goToVisualRedactor(String text) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title[contains(.,'Rich text editor')]]")));
        WebElement bodyOfMessage = getDriver().findElement(By.xpath("//body[@class='lj-main-body']"));
        bodyOfMessage.sendKeys(text);
        getDriver().switchTo().defaultContent();
        return this;
    }

}
