package com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks.settings;

import com.livejournal.uitests.pages.service_pages.friends_feed_pages.enums.ColorSettings;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(css = "a[ng-style*='element_border_color']")
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

    @FindBy(css = "a.b-feedsettings-restore")
    private Button restoreButton;

    ////////////////////////////////////////
    @StepGroup
    public SettingsBlock enterTitle(String title) {
        titleField.enter(title);
        return this;
    }

    @StepGroup
    public SettingsBlock typeToTitle(String title) {
        titleField.type(title);
        return this;
    }

    @StepGroup
    public SettingsBlock setTextSettings(String size, String font) {
        textSize.selectByValue(size);
        textFont.selectByValue(font);
        return this;
    }

    @StepGroup
    public PageSize setPaging(String type) {
        pageType.selectByValue(type.toLowerCase());
        return new PageSize(type);
    }

    @StepGroup
    public FriendsFeedLogged saveSettings() {
        saveButton.click();
        return waitThatSettingsBlockClose();
    }

    @StepGroup
    public FriendsFeedLogged cancelSettings() {
        cancelButton.click();
        return waitThatSettingsBlockClose();
    }

    @StepGroup
    public FriendsFeedLogged restoreDefaultSettings() {
        restoreButton.click();
        return waitThatSettingsBlockClose();
    }

    @StepGroup
    public FriendsFeedLogged waitThatSettingsBlockClose() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return onOpened(FriendsFeedLogged.class).settingsButton.isDisplayed();
            }
        });
        return onOpened(FriendsFeedLogged.class);
    }

    @StepGroup
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

    @StepGroup
    public SettingsBlock setColor(ColorSettings button, String type, String code, int barY, int colorX, int colorY) {
        getColorButton(button).click()
                .setColor(type, code, barY, colorX, colorY);
        return this;
    }

    @StepGroup
    public SettingsBubbleColorBlock getColor(ColorSettings button) {
        return getColorButton(button).click();

    }

    @StepGroup
    public SettingsBlock getCurrentColor(ColorSettings button) {
        getColor(button)
                .getCurrentColor();
        return this;
    }

    @StepGroup
    public String getCurrentColorCode(ColorSettings button) {
        return getColor(button).getCode();

    }

    ////////////////////////////////////////////////
    public static class ColorPickerButton extends Button {

        public ColorPickerButton(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public SettingsBubbleColorBlock click() {
            super.click();
            return onDisplayed(SettingsBubbleColorBlock.class);
        }

    }

    public static class SelectImageButton extends Button {

        public SelectImageButton(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public SettingsBubbleBackgroundBlock click() {
            super.click();
            return onDisplayed(SettingsBubbleBackgroundBlock.class);
        }

    }

    public class PageSize {

        private final String type;

        public PageSize(String type) {
            this.type = type;
        }

        @StepGroup
        public SettingsBlock setSize(String size) {
            switch (type) {
                case "PAGES":
                    try {
                        pageSize.enter(size);
                    } catch (Exception ex) {
                        Assert.fail("Page size input field is not displayed!" + ex);
                    }
                    break;

                case "ENDLESS":
                    try {
                        Assert.assertFalse("Page size input field is displayed!", pageSize.isDisplayed());
                    } catch (NoSuchElementException ex) {
                        Assert.fail("Page size input field is not displayed! " + ex);
                    }
                    break;
                default:
                    Assert.fail("Incorrect page type!");
            }
            return onDisplayed(SettingsBlock.class);
        }
    }

    @WhenPageOpens
    private void waitBlock() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return titleField.isDisplayed();
            }
        });
    }

}
