package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-feedsettings-inner"))
public class SettingsBlock extends UIBlock {

    //////////////////// FEED SETTINGS
    @FindBy(css = ".b-input-simple")
    private TextField titleField;

    @FindBy(css = ".b-feedsettings-action-bg-color")
    private ColorPickerButton backgroundColor;

    @FindBy(css = ".b-feedsettings-action-bg-image")
    private SelectImageButton backgroundImage;

    @FindBy(css = ".b-feedsettings-action-fg-color")
    private ColorPickerButton foregroundColor;

    @FindBy(css = ".b-feedsettings-action-bg-sidebar")
    private ColorPickerButton sidebarBackground;

    @FindBy(css = ".b-feedsettings-action-head-color")
    private ColorPickerButton elementsBackground;

    @FindBy(css = "a[ng-style*='element_color']")
    private ColorPickerButton elementsColor;

    @FindBy(css = "a[ng-style*='element_background_color']")
    private ColorPickerButton bordersColor;

    //////////////////// TEXT SETTINGS
    @FindBy(css = "select[ng-model*='font_size']")
    private Select textSize;

    @FindBy(css = "select[ng-model*='font_family']")
    private Select textFont;

    @FindBy(css = "a[ng-style*='font_color']:not([ng-style*='sidebar'])")
    private ColorPickerButton mainTextColor;

    @FindBy(css = "a[ng-style*='sidebar_font_color']")
    private ColorPickerButton sidebarTextColor;

    /////////////////////////// COLOR SETTINGS
    @FindBy(css = "a[ng-style*='url_color']")
    private ColorPickerButton linkColor;

    @FindBy(css = "a[ng-style*='url_hover_color']")
    private ColorPickerButton onHoverColor;

    @FindBy(css = "a[ng-style*='url_visited_color']")
    private ColorPickerButton visitedLinkColor;

    //////////////////////  UPLOAD RECORDINGS
    @FindBy(css = "select[ng-model*='paging_type']")
    private Select pageType;

    @FindBy(css = "input[ng-model*='paging_size']")
    private TextField pageSize;

    ////////////////////// BUTTONS
    @FindBy(css = ".b-feedsettings-save")
    private Button saveButton;

    @FindBy(css = ".b-feedsettings-cancel")
    private Button cancelButton;

    @FindBy(css = ".b-feedsettings-restore")
    private Button restoreButton;

    ////////////////////////////////////////
    public SettingsBlock enterTitle(String title) {
        titleField.enter(title);
        return on(SettingsBlock.class);
    }

    public SettingsBlock typeToTitle(String title) {
        titleField.type(title);
        return on(SettingsBlock.class);
    }

    public SettingsBlock setTextSettings(String size, String font) {
        textSize.selectByValue(size);
        textFont.deselectByValue(font);
        return on(SettingsBlock.class);
    }

    public PageSize setPaging(String type) {
        pageType.selectByValue(type);
        return new PageSize(type);
    }

    public void saveSettings() {
        saveButton.click();
    }

    public void cancelSettings() {
        cancelButton.click();
    }

    public SettingsBlock restoreDefaultSettings() {
        restoreButton.click();
        return on(SettingsBlock.class);
    }

    public ColorPickerButton getColorButton(ColorSettings button) {
        switch (button) {
            case BACKGROUND_COLOR:
                return backgroundColor;
            case FOREGROUND_COLOR:
                return foregroundColor;
            case SIDEBAR_BACKGROUND:
                return sidebarBackground;
            case ELEMENTS_BACKGROUND:
                return elementsBackground;
            case ELEMENTS_COLOR:
                return elementsColor;
            case BORDERS_COLOR:
                return bordersColor;
            case MAIN_TEXT_COLOR:
                return mainTextColor;
            case SIDEBAR_TEXT_COLOR:
                return sidebarTextColor;
            case LINK_COLOR:
                return linkColor;
            case ON_HOVER_COLOR:
                return onHoverColor;
            case VISITED_LINK:
                return visitedLinkColor;
            default:
                Assert.fail("Unknown button " + button + "!");
        }
        return null;
    }

    public SettingsBlock setColor(ColorSettings button, ColorSelectType type, String code, int barY, int colorX, int colorY) {
        getColorButton(button).click()
                .setColor(type, code, barY, colorX, colorY);
        return this;
//  return on(SettingsBlock.class);
    }

    public SettingsBubbleColorBlock getColor(ColorSettings button) {
        return getColorButton(button).click();
    //    return on(SettingsBubbleColorBlock.class);
    }

    ////////////////////////////////////////////////
    public static class ColorPickerButton extends Button {

        public ColorPickerButton(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public SettingsBubbleColorBlock click() {
            super.click();
            return on(SettingsBubbleColorBlock.class);
        }

    }

    public static class SelectImageButton extends Button {

        public SelectImageButton(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public SettingsBubbleBackgroundBlock click() {
            super.click();
            return on(SettingsBubbleBackgroundBlock.class);
        }

    }

    public class PageSize {

        private final String type;

        public PageSize(String type) {
            this.type = type;
        }

        public void setSize(String size) {
            switch (type) {
                case "pages":
                    if (pageSize.isDisplayed()) {
                        pageSize.enter(size);
                    
                    break;}
                case "endless":
                    if (pageSize.isDisplayed()) {
                        Assert.fail("Page size input field is displayed!");
                        
                    
                    break;}
                default:
                    Assert.fail("Incorrect page type!");
            }
        }
    }

}
