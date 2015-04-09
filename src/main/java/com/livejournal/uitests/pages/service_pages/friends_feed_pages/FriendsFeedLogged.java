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
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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

    //////////SUPPORT BUTTONS
    @FindBy(css = "button[ng-class*='filters']")
    private Button filtersButton;

    @FindBy(css = ".l-flatslide-settingslink-open")
    public Button settingsButton;

    @FindBy(css = "a .l-flatslide-settingslink-close svg")
    public Button closeSettingsButton;

    @FindBy(css = ".b-pager-prev")
    private Button previousButton;

    @FindBy(css = ".b-pager-next")
    private Button nextButton;

    ////////////FEED
    @FindBy(css = ".l-flatslide-intro-heads .b-lenta-head-title")
    private TextBlock feedTitle;

    @FindBy(css = ".l-flatslide-intro-heads .i-ljuser-type-P a:not([href*='profile'])")
    private Link userName;

    @FindBy(css = ".b-lenta-emptiness")
    private TextBlock feedEmpty;

    //////////////SIDEBAR
    @FindBy(css = ".b-feedwidgets .b-selectus")
    private Button addWidgetButton;

    @FindBy(css = "div[ng-switch-when*='instagram']")
    private UIElement widgetInstagram;

    @FindBy(css = "div[ng-switch-when*='tumblr']")
    private UIElement widgetTumblr;

    @FindBy(css = "div[ng-switch-when*='twitter']")
    private UIElement widgetTwitter;

    @FindBy(css = "div[ng-switch-when*='entries']")
    private UIElement widgetEntries;

    @FindBy(css = "div[ng-switch-when*='events']")
    private UIElement widgetEvents;

    @FindBy(css = "div[ng-switch-when*='comments']")
    private UIElement widgetComments;

    @FindBy(css = "div[ng-switch-when*='discoveryToday']")
    private UIElement widgetLJMagazine;

    @FindBy(css = "div[ng-switch-when*='ljToday']")
    private UIElement widgetTOP;

    @FindBy(css = "div[ng-switch-when*='facebook']")
    private UIElement widgetFacebook;

    @FindBy(css = "div[ng-switch-when*='links']")
    private UIElement widgetLinks;

    @FindBy(css = "div[ng-switch-when*='calendar']")
    private UIElement widgetCalendar;

    @FindBy(css = "div[ng-switch-when*='guests']")
    private UIElement widgetGuests;

    @FindBy(css = ".b-feedwidgets-move-down")
    private Button widgetDownButton;

    @FindBy(css = ".b-feedwidgets-move-down")
    private Button widgetUpButton;

    @FindBy(css = ".b-feedwidgets-item .b-feedwidgets-close")
    private Button widgetCloseButton;

    ////////////////BLOCKS
    @FindBy(css = ".l-flatslide-menu-items")
    private UIElement filtersBlock;

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
        String script = "return jQuery('ul.l-flatslide-menu-items.l-flatslide-menu-items-active li a').text()";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "return jQuery('ul.l-flatslide-menu-items.l-flatslide-menu-items-active li a').text()";
        }
        return startScript(script).toString().trim();
    }

    @StepGroup
    public FriendsFeedLogged addWidget(String widget) {
        addWidgetButton.click();
        String script = "jQuery('.b-feedwidgets .b-selectus-items ul li').each(function(index){"
                + "             if(jQuery(this).text() == '" + widget + "'){"
                + "                jQuery(this).click();"
                + "                 return false"
                + "      }})";
        startScript(script);
        return this;
    }

    @StepGroup
    public boolean displayingWidget(String widget) {
        switch (stringToEnum(widget)) {
            case TWITTER_FEED:
                return widgetTwitter.isDisplayed();
            case FACEBOOK_FEED:
                return widgetFacebook.isDisplayed();
            case INSTAGRAM_FEED:
                return widgetInstagram.isDisplayed();
            case TUMBLR_FEED:
                return widgetTumblr.isDisplayed();
            case CALENDAR:
                return widgetCalendar.isDisplayed();
            case DISCOVERY_TODAY:
                return widgetLJMagazine.isDisplayed();
            case LIVEJOURNAL_TODAY:
                return widgetTOP.isDisplayed();
            case INTERESTING_LINKS:
                return widgetLinks.isDisplayed();
            case EVENTS:
                return widgetEvents.isDisplayed();
            case COMMENTS:
                return widgetComments.isDisplayed();
            case GUESTS:
                return widgetGuests.isDisplayed();
            case ENTRIES:
                return widgetEntries.isDisplayed();

            default:
                Assert.fail("Unknown widget " + widget + "!");
                return false;
        }
    }

    @StepGroup
    public FriendsFeedLogged closeWidget(String widget) {
        String script = "jQuery('div[ng-switch-when]').each(function(index){"
                + "              if(jQuery(this).text().contains('" + widget + "')){"
                + "                jQuery('.b-feedwidgets-close')[index].click();"
                + "                return false;"
                + "                }});";

        moveMouseOnWidget(widget);
        if (widgetCloseButton.isEnabled()) {
            startScript(script);
        } else {
            Assert.fail("Close button is not displayed for widget " + widget + "!");
        }
        return this;
    }

    @StepGroup
    public void moveMouseOnWidget(String widget_switch) {
        switch (stringToEnum(widget_switch)) {
            case TWITTER_FEED:
                widgetTwitter.moveMouseOver();
                break;
            case FACEBOOK_FEED:
                widgetFacebook.moveMouseOver();
                break;
            case INSTAGRAM_FEED:
                widgetInstagram.moveMouseOver();
                break;
            case TUMBLR_FEED:
                widgetTumblr.moveMouseOver();
                break;
            case CALENDAR:
                widgetCalendar.moveMouseOver();
                break;
            case DISCOVERY_TODAY:
                widgetLJMagazine.moveMouseOver();
                break;
            case LIVEJOURNAL_TODAY:
                widgetTOP.moveMouseOver();
                break;
            case INTERESTING_LINKS:
                widgetLinks.moveMouseOver();
                break;
            case EVENTS:
                widgetEvents.moveMouseOver();
                break;
            case COMMENTS:
                widgetComments.moveMouseOver();
                break;
            case GUESTS:
                widgetGuests.moveMouseOver();
                break;
            case ENTRIES:
                widgetEntries.moveMouseOver();
                break;
            default:
                Assert.fail("Unknown widget " + widget_switch + "!");
        }
    }

    @StepGroup
    public FriendsFeedLogged upWidget(String widget) {
        String script = "jQuery('div[ng-switch-when]').each(function(index){"
                + "              if(jQuery(this).text().contains('" + widget + "')){"
                + "                jQuery('.b-feedwidgets-move-up')[index].click();"
                + "                return false;"
                + "                }});";

        moveMouseOnWidget(widget);
        if (widgetUpButton.isEnabled()) {
            startScript(script);
        } else {
            Assert.fail("Up button is not displayed for widget " + widget + "!");
        }
        return this;

    }

    @StepGroup
    public FriendsFeedLogged downWidget(String widget) {
        String script = "jQuery('div[ng-switch-when]').each( function(index){"
                + "           if(jQuery(this).text().contains('" + widget + "')){"
                + "                jQuery('.b-feedwidgets-move-down')[index].click();"
                + "                return false;"
                + "               }});";

        moveMouseOnWidget(widget);
        if (widgetDownButton.isEnabled()) {
            startScript(script);
        } else {
            Assert.fail("Down button is not displayed for widget " + widget + "!");
        }
        return this;

    }

    @StepGroup
    public boolean buttonUpDisplaying(String widget) {
        String script = "var i;"
                + "jQuery('.b-feedwidgets-item').each(function(index) {"
                + "      if(jQuery(this).text().contains('" + widget + "')) {"
                + "        i = index;"
                + "        return false;"
                + " }});"
                + "return jQuery('.b-feedwidgets-move-up').slice(i,i+1).css('visibility')=='visible';";
        return Boolean.valueOf(startScript(script).toString());
    }

    @StepGroup
    public boolean buttonDownDisplaying(String widget) {
        String script = "var i;"
                + "jQuery('.b-feedwidgets-item').each(function(index) {"
                + "     if(jQuery(this).text().contains('" + widget + "')) {"
                + "        i = index;"
                + "        return false;"
                + " }});"
                + "return jQuery('.b-feedwidgets-move-down').slice(i,i+1).css('visibility')=='visible'";
        return Boolean.valueOf(startScript(script).toString());
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

    public void addAllWidgets() {
        Object widgetsSize = startScript("return jQuery('.b-feedwidgets .b-selectus-items ul li').size()");
        if (Integer.valueOf(widgetsSize.toString()) > 0) {
            for (int i = 1; i < Integer.valueOf(widgetsSize.toString()); i++) {
                addWidgetButton.click();
                startScript("jQuery('.b-feedwidgets .b-selectus-items ul li')[1].click();");
            }
        }
    }

    public void deleteAllWidgets() {
        startScript("jQuery('.b-feedwidgets-close').each(function(i){jQuery(this).click()})");
    }

    private SidebarWidgets stringToEnum(String widget) {
        return SidebarWidgets.valueOf(widget.replace("Календарь", "CALENDAR")
                .replace(" ", "_")
                .toUpperCase());
    }
}
