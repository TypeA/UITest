package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.filters.FiltersBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBlock;
import java.util.List;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/feed")
public class FriendsFeedLogged extends ServicePageLogged {

    @FindBy(css = ".b-lenta-preview")
    public UIElement lentaPreview;

    @FindBy(css = ".l-flatslide-menu-items")
    private UIElement filtersBlock;

    private SidebarBlock sidebarBlock;

    //////////SUPPORT BUTTONS
    @FindBy(css = "button[ng-class*='filters']")
    private Button filtersButton;

    @FindBy(css = ".l-flatslide-settingslink-open")
    public Button settingsButton;

    @FindBy(css = "a .l-flatslide-settingslink-close svg")
    public Button closeSettingsButton;

    ////////////FEED
    @FindBy(css = ".l-flatslide-intro-heads .b-lenta-head-title")
    private TextBlock feedTitle;

    @FindBy(css = ".l-flatslide-intro-heads .i-ljuser-type-P a:not([href*='profile'])")
    private Link userName;

    @FindBy(css = ".b-lenta-emptiness")
    private TextBlock feedEmpty;

    @FindBy(css = ".b-pager-prev")
    private Button previousButton;

    @FindBy(css = ".b-pager-next")
    private Button nextButton;

    /////////////////////////////////////
    @StepGroup
    public SettingsBlock openSettings() {
        settingsButton.click();
        return onDisplayed(SettingsBlock.class);
    }

    @StepGroup
    public FriendsFeedLogged closeSettings() {
        closeSettingsButton.moveMouseOver();
        return onDisplayed(SettingsBlock.class).waitThatSettingsBlockClose();
    }

    @StepGroup
    public String getFeedTitle() {
        return feedTitle.getText();
    }

    @StepGroup
    public Link getUserName() {
        return userName;
    }

    @StepGroup
    public boolean displaySwitchPagesButtons() {
        try {
            return previousButton.isDisplayed() && nextButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @StepGroup
    public String getGroups() {
        List<WebElement> list = getDriver()
                .findElements(By.xpath("//ul[@class='l-flatslide-menu-items l-flatslide-menu-items-active']//li//a"));
        StringBuilder filresFeed = new StringBuilder();
        for (WebElement list1 : list) {
            String filter = list1.getAttribute("text");
            filresFeed.append(filter);
        }
        return filresFeed.toString();
    }

    @StepGroup
    public FiltersBlock openFilters() {
        filtersButton.click();
        return onDisplayed(FiltersBlock.class);
    }

    @StepGroup
    public FriendsFeedLogged clickFilter() {
        filtersButton.click();
        return this;
    }

    @StepGroup
    public boolean filtersDisplaying() {
        return filtersBlock.isDisplayed();
    }

    @StepGroup
    public boolean feedIsEmpty() {
        return feedEmpty.isDisplayed();
    }

    @StepGroup
    public FriendsFeedLogged addWidget(String widget) {
        sidebarBlock.addWidget(widget);
        return this;
    }

    @StepGroup
    public boolean displayingWidget(String widget) {
        return sidebarBlock.displayingWidget(widget);
    }

    @StepGroup
    public FriendsFeedLogged closeWidget(String widget) {
        sidebarBlock.closeWidget(widget);
        return this;
    }

    @StepGroup
    public void moveMouseOnWidget(String widget_switch) {
        sidebarBlock.moveMouseOnWidget(widget_switch);
    }

    @StepGroup
    public FriendsFeedLogged upWidget(String widget) {
        sidebarBlock.upWidget(widget);
        return this;

    }

    @StepGroup
    public FriendsFeedLogged downWidget(String widget) {
        sidebarBlock.downWidget(widget);
        return this;

    }

    @StepGroup
    public boolean buttonUpDisplaying(String widget) {
        return sidebarBlock.buttonUpDisplaying(widget);
    }

    @StepGroup
    public boolean buttonDownDisplaying(String widget) {
        return sidebarBlock.buttonDownDisplaying(widget);
    }

    public FriendsFeedLogged addAllWidgets() {
        sidebarBlock.addAllWidgets();
        return this;
    }

    public FriendsFeedLogged deleteAllWidgets() {
        sidebarBlock.deleteAllWidgets();
        return this;
    }

}
