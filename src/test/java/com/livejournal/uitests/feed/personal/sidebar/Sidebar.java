package com.livejournal.uitests.feed.personal.sidebar;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.utility.RandomeValue;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class Sidebar extends LJTest {

    //Scenario: Add widget (1/3)
    @Given("logged user (name $name) without widgets in sidebar on Friends Feed")
    public void logged_user_without_widgets_in_sidebar_on_Friends_Feed(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."))
                .deleteAllWidgets();

    }

    //Scenario: Delete widget(1/3)
    //Scenario: Up Button on widget (1/3)
    //Scenario: Down Button (1/3)
    //Scenario: Up and Down Buttons (1/3)
    //Scenario: Saving a layout of widgets (1/3)
    @Given("logged user (name $name) with complete set of widgets in sidebar on Friends Feed")
    public void logged_user_with_complete_set_of_widgets_in_sidebar_on_Friends_Feed(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .regionSwitchLogged(name, "CYR");
        
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."))
                .addAllWidgets();
    }

    //Scenario: Add widget (2/3)
    @When("user click Add widget and select widget $widget")
    public void user_click_Add_widget_and_select_widget(String widget) {
        onOpened(FriendsFeedLogged.class)
                .addWidget(widget);
    }

    //Scenario: Delete widget(2/3)
    @When("user click Delete widget $widget")
    public void user_click_Delete_widget(String widget) {
        onOpened(FriendsFeedLogged.class)
                .closeWidget(widget);
    }

    //Scenario: Up Button on widget (2/3)
    @When("user click Up Button many time on lower widget")
    public void user_click_Up_Button_many_time_on_lower_widget() {
        String widget = selectWidget("LOWER");
        ThucydidesUtils.putToSession("widget", widget);
        onOpened(FriendsFeedLogged.class)
                .moveMouseOnWidget(widget);
        String script = "return jQuery('.b-feedwidgets-move-down')"
                + ".slice((jQuery('.b-feedwidgets-move-down').size()-1),(jQuery('.b-feedwidgets-move-down').size()))"
                + ".hasClass('ng-hide')";
        verify().that(Boolean.valueOf(startScript(script).toString()))
                .ifResultIsExpected("There is no Down button on lower widget")
                .ifElse("There is Down buttonon lower widget")
                .finish();
        Integer steps = Integer.valueOf(startScript("return jQuery('div[ng-switch-when]').size()").toString());
        for (int i = 0; i < steps - 1; i++) {
            onOpened(FriendsFeedLogged.class)
                    .upWidget(widget);
        }
    }

    //Scenario: Down Button on widget(2/3)
    @When("user click Down Button many time on top widget")
    public void user_click_Down_Button_on_top_widget() {
        String widget = selectWidget("UPPER");
        ThucydidesUtils.putToSession("widget", widget);
        onOpened(FriendsFeedLogged.class)
                .moveMouseOnWidget(widget);
        String script = "return jQuery('.b-feedwidgets-move-up')"
                + ".slice(0,1)"
                + ".hasClass('ng-hide')";
        verify().that(Boolean.valueOf(startScript(script).toString()))
                .ifResultIsExpected("There is no Up button on top widget")
                .ifElse("There is Up button on top widget")
                .finish();
        Integer steps = Integer.valueOf(startScript("return jQuery('div[ng-switch-when]').size()").toString());
        for (int i = 0; i < steps - 1; i++) {
            onOpened(FriendsFeedLogged.class)
                    .downWidget(widget);
        }

    }

    //Scenario: Up and Down Buttons(2/3)
    @When("user move mouse on middle widget")
    public void user_move_mouse_on_middle_widget() {
        String widget = selectWidget("MIDDLE");
        ThucydidesUtils.putToSession("widget", widget);
        onOpened(FriendsFeedLogged.class)
                .moveMouseOnWidget(widget);
    }

    //Scenario: Saving a layout of widgets (2/3)
    @When("user logged out and logged in again (name $name)")
    public void user_logged_out_and_logged_in_again(String name) {
        ThucydidesUtils.putToSession("all_widgets", compositionOfWidgets());
        onOpened(FriendsFeedLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut()
                .clickOnLoginMenuItem()
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
    }

    //Scenario: Add widget (3/3)
    @Then("widget $widget added in sidebar")
    public void widget_added_in_sidebar(String widget) {
        verify().that(onOpened(FriendsFeedLogged.class).displayingWidget(widget))
                .ifResultIsExpected("Necessary widget '" + widget + "' is displayed")
                .ifElse("Necessary widget '" + widget + "' is not displayed!")
                .finish();

    }

    //Scenario: Delete widget(3/3)
    @Then("widget $widget deleted in sidebar")
    public void widget_deleted_in_sidebar(String widget) {
        verify().that(!widgetInTheSidebar(widget))
                .ifResultIsExpected("Widget" + widget + " is deleted in sidebar")
                .ifElse("Widget" + widget + " is not deleted in sidebar")
                .finish();
    }

    //Scenario: Up Button on widget (3/3)
    @Then("this widget is upper")
    public void lower_widget_move_up() {
        String widget = ThucydidesUtils.getFromSession("widget").toString();
        String script = "return jQuery('div[ng-switch-when]')[0]"
                + ".textContent"
                + ".contains('" + widget + "')";
        verify().that(Boolean.valueOf(startScript(script).toString()))
                .ifResultIsExpected("Widget " + widget + " is raised")
                .ifElse("Widget " + widget + " is lower")
                .finish();
    }

    //Scenario: Down Button on widget (3/3)
    @Then("this widget is lower")
    public void top_widget_move_down() {
        String widget = ThucydidesUtils.getFromSession("widget").toString();
        String script = "return jQuery('div[ng-switch-when]')[jQuery('div[ng-switch-when]').size()-1]"
                + ".textContent"
                + ".contains('" + widget + "')";
        verify().that(Boolean.valueOf(startScript(script).toString()))
                .ifResultIsExpected("Widget " + widget + " is put down")
                .ifElse("Widget " + widget + " is top")
                .finish();
    }

    //Scenario: Up and Down Buttons on widget (3/3)
    @Then("Up and Down Buttons are displayed")
    public void Up_and_Down_Buttons_are_displayed() {
        String widget = ThucydidesUtils.getFromSession("widget").toString();
        verify().that(onOpened(FriendsFeedLogged.class).buttonUpDisplaying(widget))
                .ifResultIsExpected("Up button is displayed")
                .ifElse("Up button is not displayed")
                .and()
                .that(onOpened(FriendsFeedLogged.class).buttonDownDisplaying(widget))
                .ifResultIsExpected("Down button is displayed")
                .ifElse("Down button is not displayed")
                .finish();
    }

    //Scenario: Saving a layout of widgets (3/3)
    @Then("user's layout of widgets is applied")
    public void user_layout_of_widgets_is_applied() {
        ArrayList<String> old_widgets = (ArrayList<String>) ThucydidesUtils.getFromSession("all_widgets");
        verify().that(compositionOfWidgets().containsAll(old_widgets))
                .ifResultIsExpected("User's layout of widgets is applied")
                .ifElse("User's layout of widgets is not applied!")
                .finish();
    }

    /////////////////////////////
    @StepGroup
    public boolean widgetInTheSidebar(String widget) {
        Object sidebarSize = startScript("return jQuery('div[ng-switch-when]').size()");
        Integer intSidebarSize = Integer.valueOf(sidebarSize.toString());
        Object widgetInSidebar;
        boolean flag = false;
        for (int i = 0; i < intSidebarSize; i++) {
            widgetInSidebar = startScript("return jQuery('div[ng-switch-when]')[" + i + "].textContent.contains('" + widget + "')");
            if (widgetInSidebar.toString().equals("true")) {
                flag = true;
            }
        }
        return flag;
    }

    private String selectWidget(String type) {
        String widget = "";
        Object widgetsSize = startScript("return jQuery('div[ng-switch-when]').size()");
        Integer intSize = Integer.valueOf(widgetsSize.toString());
        Object ok_widget = null;
        if (intSize > 1) {
            switch (type.toUpperCase()) {
                case "UPPER":
                    ok_widget = startScript("return jQuery('div[ng-switch-when]')[0].textContent");
                    widget = correctWidget(ok_widget.toString());
                    break;
                case "LOWER":
                    ok_widget = startScript("return jQuery('div[ng-switch-when]')[jQuery('div[ng-switch-when]').size()-1].textContent");
                    widget = correctWidget(ok_widget.toString());
                    break;
                case "MIDDLE":
                    ok_widget = startScript("return jQuery('div[ng-switch-when]')[" + new RandomeValue(intSize - 1).get() + "].textContent");
                    widget = correctWidget(ok_widget.toString());
                    break;
            }
        }
        return widget;
    }

    private ArrayList<String> allWidgets() {
        ArrayList<String> widgets = new ArrayList<>();
        widgets.add("Twitter Feed");
        widgets.add("Instagram Feed");
        widgets.add("Tumblr Feed");
        widgets.add("Calendar");
        widgets.add("Discovery Today");
        widgets.add("LiveJournal Today");
        widgets.add("Interesting links");
        widgets.add("Events");
        widgets.add("Comments");
        widgets.add("Guests");
        widgets.add("Entries");
        return widgets;
    }

    private String correctWidget(String text) {
        ArrayList<String> widgets = allWidgets();
        String widget = "error";
        for (String value : widgets) {
            if (text.contains(value)) {
                widget = value;
            }
        }
        return widget;
    }

    private ArrayList<String> compositionOfWidgets() {
        ArrayList<String> widgets = allWidgets();
        ArrayList<String> correct_widgets = new ArrayList<>();
        Integer size = Integer.valueOf(startScript("return jQuery('div[ng-switch-when]').size()").toString());
        for (int i = 0; i < size; i++) {
            for (String value : widgets) {
                String text = startScript("return jQuery('div[ng-switch-when]')[" + i + "].textContent").toString();
                if (text.contains(value)) {
                    correct_widgets.add(value);
                }
            }
        }
        return correct_widgets;
    }

}
