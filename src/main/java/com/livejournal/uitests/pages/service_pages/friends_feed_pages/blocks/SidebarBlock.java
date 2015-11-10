package com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.enums.SidebarWidgets;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".l-flatslide-body"))
public class SidebarBlock extends UIBlock {

    @FindBy(css = ".b-feedwidgets .b-selectus")
    private Button addWidgetButton;

    @FindBy(css = "div[ng-switch-when*='instagram']")
    private Widgets widgetInstagram;

    @FindBy(css = "div[ng-switch-when*='tumblr']")
    private Widgets widgetTumblr;

    @FindBy(css = "div[ng-switch-when*='twitter']")
    private Widgets widgetTwitter;

    @FindBy(css = "div[ng-switch-when*='entries']")
    private Widgets widgetEntries;

    @FindBy(css = "div[ng-switch-when*='events']")
    private Widgets widgetEvents;

    @FindBy(css = "div[ng-switch-when*='comments']")
    private Widgets widgetComments;

    @FindBy(css = "div[ng-switch-when*='discoveryToday']")
    private Widgets widgetLJMagazine;

    @FindBy(css = "div[ng-switch-when*='ljToday']")
    private Widgets widgetTOP;

    @FindBy(css = "div[ng-switch-when*='facebook']")
    private Widgets widgetFacebook;

    @FindBy(css = "div[ng-switch-when*='links']")
    private Widgets widgetLinks;

    @FindBy(css = "div[ng-switch-when*='calendar']")
    private Widgets widgetCalendar;

    @FindBy(css = "div[ng-switch-when*='guests']")
    private Widgets widgetGuests;

    @FindBy(css = ".b-feedwidgets-move-down")
    private Button widgetDownButton;

    @FindBy(css = ".b-feedwidgets-move-down")
    private Button widgetUpButton;

    @FindBy(css = ".b-feedwidgets-item .b-feedwidgets-close")
    private Button widgetCloseButton;

    @StepGroup
    public void addWidget(String widget) {
        addWidgetButton.click();
        String script = "jQuery('.b-feedwidgets .b-selectus-items ul li').each(function(index){"
                + "             if(jQuery(this).text() == '" + widget + "'){"
                + "                jQuery(this).click();"
                + "                 return false"
                + "      }})";
        startScript(script);
    }

    @StepGroup
    public boolean displayingWidget(String widget) {
        return getWidget(widget).isDisplayed();
    }

    @StepGroup
    public void closeWidget(String widget) {
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
    }

    @StepGroup
    public void moveMouseOnWidget(String widget_switch) {
        getWidget(widget_switch).moveMouseOver();
    }

    @StepGroup
    public void upWidget(String widget) {
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
    }

    @StepGroup
    public void downWidget(String widget) {
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

    private Widgets getWidget(String widget) {
        switch (stringToEnum(widget)) {
            case TWITTER_FEED:
                return widgetTwitter;
            case FACEBOOK_FEED:
                return widgetFacebook;
            case INSTAGRAM_FEED:
                return widgetInstagram;
            case TUMBLR_FEED:
                return widgetTumblr;
            case CALENDAR:
                return widgetCalendar;
            case DISCOVERY_TODAY:
                return widgetLJMagazine;
            case LIVEJOURNAL_TODAY:
                return widgetTOP;
            case INTERESTING_LINKS:
                return widgetLinks;
            case EVENTS:
                return widgetEvents;
            case COMMENTS:
                return widgetComments;
            case GUESTS:
                return widgetGuests;
            case ENTRIES:
                return widgetEntries;
            default:
                Assert.fail("Unknown widget " + widget + "!");
                return null;
        }
    }

    /////////////////////////////////////////
    public static class Widgets extends UIElement {

        public Widgets(WebElement wrappedElement) {
            super(wrappedElement);
        }

    }

}
