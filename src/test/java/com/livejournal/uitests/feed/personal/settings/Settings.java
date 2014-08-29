package com.livejournal.uitests.feed.personal.settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSelectType;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSettings;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBubbleColorBlock;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 *
 * @author m.prytkova
 */
public class Settings extends WebTest {

    public String feed_title;

    //Scenario: New Title(1/3)
    //Scenario: Change Title(1/3)
    //Scenario: Set color(1/3)
    @Given("logged user (name $name, password $password) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name, String password) {
        on(LoginPage.class)
                .authorizeBy(name, password);
        on(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
    }

    //Scenario: New Title(2/3)
    @When("user add new Title $title in Settings and save it")
    public void user_add_new_Title_in_Settings_and_save_it(String title) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .enterTitle(title)
                .saveSettings();
    }

    //Scenario: Change Title(2/3)
    @When("user change Title $title in Settings and save it")
    public void user_change_Title_in_Settings_and_save_it(String title) {
        ThucydidesUtils.putToSession("feed_title", on(FriendsFeedLogged.class).getFeedTitle());
        on(FriendsFeedLogged.class)
                .openSettings()
                .typeToTitle(title)
                .saveSettings();
    }

    //Scenario: Set color(2/3)
    @When("user change color $color by type $type (parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY) and save it")
    public void user_change_color_by_type_and_save_it(String color, String type, String code, String barY, String colorX, String colorY) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.valueOf(type), code, Integer.parseInt(barY), Integer.parseInt(colorX), Integer.parseInt(colorY))
                .saveSettings();
    }

    //Scenario: New Title(3/3)
    //Scenario: Change Title(3/3)
    @Then("the Title is changed on correct title $correct_title")
    public void title_is_changed_on_correct_title(String correct_title) {
        verifyThatTitleIsCorrect(correct_title);
    }

    //Scenario: Set color(3/3)
    @Then("color $color is changed by parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY")
    public void color_is_changed_by_parametrs(String color, String type, String code, String barY, String colorX, String colorY) {
        on(FriendsFeedLogged.class).openSettings().getColor(ColorSettings.valueOf(color));
        verify().that(on(SettingsBubbleColorBlock.class).getCurrentColor().contains(hexToRGB(code)))
                .ifResultIsExpected("Correct current color:\n" + hexToRGB(code))
                .ifElse("Current color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getCurrentColor())
                .and()
                .that(on(SettingsBubbleColorBlock.class).getNewColor().contains(hexToRGB(code)))
                .ifResultIsExpected("Correct new color:\n" + hexToRGB(code))
                .ifElse("New color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getNewColor())
                .and()
                .that(on(SettingsBubbleColorBlock.class).getCode().equals(code))
                .ifResultIsExpected("Correct color code:\n" + code)
                .ifElse("Color code is incorrect:\n" + on(SettingsBubbleColorBlock.class).getCode())
                .and()
                .that(getElementColor(ColorSettings.valueOf(color)).contains(hexToRGB(code)))
                .ifResultIsExpected("Correct element color:\n" + hexToRGB(code))
                .ifElse("Element color is incorrect:\n" + getElementColor(ColorSettings.valueOf(color)))
                .finish();
    }

    private void verifyThatTitleIsCorrect(String correct_title) {
        refreshCurrentPage();
        String title = (String) ThucydidesUtils.getFromSession("feed_title");
        if (title != null) {
            correct_title = title + correct_title;
        }
        verify().that(on(FriendsFeedLogged.class).getFeedTitle().equals(correct_title))
                .ifResultIsExpected(VerifyText.okTextForMessage(correct_title))
                .ifElse(VerifyText.errorTextForMessage(correct_title, on(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
    }

    private String hexToRGB(String hex) {
        return Integer.parseInt(hex.substring(0, 2), 16) + ", " + Integer.parseInt(hex.substring(2, 4), 16) + ", " + Integer.parseInt(hex.substring(4, 6), 16);
    }

    private String getElementColor(ColorSettings button) {
        switch (button) {
            case BACKGROUND_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".s-schemius")).getCssValue("background-color");
            case FOREGROUND_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".l-flatslide-content")).getCssValue("background-color");
            case SIDEBAR_BACKGROUND:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".l-flatslide-aside")).getCssValue("background-color");
            case ELEMENTS_BACKGROUND:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".l-flatslide-menu-button")).getCssValue("background-color");
            case ELEMENTS_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector("svg[class*='svgicon']")).getCssValue("color");
            case BORDERS_COLOR:
                return "ERROR!!!";
            case MAIN_TEXT_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".b-lenta-item-title a")).getCssValue("color");
            case SIDEBAR_TEXT_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".b-todaylj-caption a")).getCssValue("color");
            case LINK_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".b-lenta-body A:link")).getCssValue("color");
            case ON_HOVER_COLOR:
                return "ERROR!!!";
            case VISITED_LINK:
                return "ERROR!!!";
            default:
                Assert.fail("Unknown button " + button + "!");
        }
        return "ERROR!!!";
    }
}//.b-contextualhover
