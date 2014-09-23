package com.livejournal.uitests.feed.personal.settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSelectType;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSettings;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.PagingType;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBubbleColorBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.TextParametrs;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.utility.HexToRGB;
import com.livejournal.uitests.utility.RandomeValue;
import com.livejournal.uitests.utility.VerifyText;
import java.util.Objects;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author m.prytkova
 */
public class Settings extends WebTest {

    public String feed_title;

    //Scenario: New Title(1/3)
    //Scenario: Change Title(1/3)
    //Scenario: Set new color(1/3)
    //Scenario: Cancel changing Title (1/3)
    //Scenario: Cansel new color (1/3)
    //Scenario: Return the current color (1/3)
    //Scenario: Set text settings (1/3)
    //Scenario: Set paging type (1/3)
    //Scenario: Cancel paging type (1/3)
    @Given("logged user (name $name, password $password) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name, String password) {
        on(LoginPageUnlogged.class)
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

    //Scenario: Cancel changing Title(2/3)
    @When("user change Title $title in Settings and cansel it")
    public void user_change_Title_in_Settings_and_cansel_it(String title) {
        ThucydidesUtils.putToSession("feed_title", on(FriendsFeedLogged.class).getFeedTitle());
        on(FriendsFeedLogged.class)
                .openSettings()
                .typeToTitle(title);
        verify().that(on(FriendsFeedLogged.class).getFeedTitle().equals((String) ThucydidesUtils.getFromSession("feed_title") + title))
                .ifResultIsExpected(VerifyText.okTextForMessage((String) ThucydidesUtils.getFromSession("feed_title") + title))
                .ifElse(VerifyText.errorTextForMessage(on(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
        on(SettingsBlock.class)
                .cancelSettings();
    }

    //Scenario: Set new color(2/3)
    @When("user change color $color by type $type (parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY) and save it")
    public void user_change_color_by_type_and_save_it(String color, String type, String code, String barY, String colorX, String colorY) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.valueOf(type), code, Integer.parseInt(barY), Integer.parseInt(colorX), Integer.parseInt(colorY))
                .saveSettings();
    }

    //Scenario: Return the current color(2/3)
    @When("user change color $color (old code $code) and return current color")
    public void user_change_color_and_return_current_color(String color, String code) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.BY_CODE, code, 0, 0, 0)
                .saveSettings();
        on(FriendsFeedLogged.class)
                .openSettings()
                .getColor(ColorSettings.valueOf(color))
                .setColorBarByPoint(new RandomeValue(250).get())
                .setColorByPoint(new RandomeValue(250).get(), new RandomeValue(250).get());
        verify().that(!verifyColor(code, on(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getNewColor())
                .finish();
        on(SettingsBubbleColorBlock.class)
                .setCurrentColor();
    }

    //Scenario: Cansel new color (2/3)
    @When("user change color $color (old code $code) and cansel it")
    public void user_change_color_and_cansel_it(String color, String code) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.BY_CODE, code, 0, 0, 0)
                .saveSettings();
        on(FriendsFeedLogged.class)
                .openSettings()
                .getColor(ColorSettings.valueOf(color))
                .setColorBarByPoint(new RandomeValue(250).get())
                .setColorByPoint(new RandomeValue(250).get(), new RandomeValue(250).get());
        verify().that(!verifyColor(code, on(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color :\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getNewColor())
                .finish();
        on(SettingsBubbleColorBlock.class)
                .clickChooseButton()
                .cancelSettings();
    }

    //Scenario: Set text settings (2/3)
    @When("user change text size $size and font $font in Settings and save it")
    public void user_change_text_size_and_font_in_Settings_and_save_it(String size, String font) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setTextSettings(size, font)
                .saveSettings();
    }

    //Scenario: Set paging type (2/3)
    @When("user set Paging type $type (number $number)  in Settings and save it")
    public void user_set_Paging_type_in_Settings_and_save_it(String type, String number) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setPaging(type)
                .setSize(number)
                .saveSettings();
        getCurrentBrowser().getDriver().navigate().refresh();
    }

    //Scenario: Cancel paging type (2/3)
    @When("user set Paging type $new_type (old type $type, number $number) in Settings and cansel it")
    public void user_set_Paging_type_in_Settings_and_cansel_it(String new_type, String type, String number) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setPaging(type)
                .setSize(number)
                .saveSettings()
                .openSettings()
                .setPaging(new_type)
                .setSize(number)
                .cancelSettings();
        getCurrentBrowser().getDriver().navigate().refresh();
    }

    //Scenario: New Title(3/3)
    //Scenario: Change Title(3/3)
    @Then("the Title is changed on correct title $correct_title")
    public void title_is_changed_on_correct_title(String correct_title) throws InterruptedException {
        refreshCurrentPage();
        String title = (String) ThucydidesUtils.getFromSession("feed_title");
        if (title != null) {
            correct_title = title + correct_title;
        }
        verify().that(on(FriendsFeedLogged.class).getFeedTitle().equals(correct_title))
                .ifResultIsExpected(VerifyText.okTextForMessage(correct_title))
                .ifElse(VerifyText.errorTextForMessage(on(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
    }

    //Scenario: Cancel changing Title (3/3)
    @Then("the Title is not changed")
    public void the_Title_is_not_changed() {
        verify().that(on(FriendsFeedLogged.class).getFeedTitle().equals((String) ThucydidesUtils.getFromSession("feed_title")))
                .ifResultIsExpected(VerifyText.okTextForMessage((String) ThucydidesUtils.getFromSession("feed_title")))
                .ifElse(VerifyText.errorTextForMessage(on(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
    }

    //Scenario: Set new color(3/3)
    //Scenario: Cansel new color (3/3)
    @Then("the color $color corresponds to correct code $code")
    public void the_color_corresponds_to_correct_code(String color, String code) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .getColor(ColorSettings.valueOf(color));
        verify().that(verifyColor(code, on(SettingsBubbleColorBlock.class).getCurrentColor()))
                .ifResultIsExpected("Correct current color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("Current color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getCurrentColor())
                .and()
                .that(verifyColor(code, on(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getNewColor())
                .and()
                .that(verifyColor(code, "(" + HexToRGB.hexToRGB(on(SettingsBubbleColorBlock.class).getCode()) + ")"))
                .ifResultIsExpected("Correct color code:\n" + code)
                .ifElse("Color code is incorrect:\n" + on(SettingsBubbleColorBlock.class).getCode())
                .and()
                .that(verifyColor(code, getElementColor(ColorSettings.valueOf(color))))
                .ifResultIsExpected("Correct element color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("Element color is incorrect:\n" + getElementColor(ColorSettings.valueOf(color)))
                .finish();
    }

    //Scenario: Return the current color(3/3)
    @Then("the color changed to the current code $code")
    public void the_color_changed_to_the_current(String code) {
        verify().that(verifyColor(code, on(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getNewColor())
                .and()
                .that(verifyColor(code, "(" + HexToRGB.hexToRGB(on(SettingsBubbleColorBlock.class).getCode()) + ")"))
                .ifResultIsExpected("Correct color code:\n" + code)
                .ifElse("Color code is incorrect:\n" + on(SettingsBubbleColorBlock.class).getCode())
                .finish();
    }

    //Scenario: Set text settings (3/3)
    @Then("text settings is changed by size $size and font $font")
    public void text_settings_is_changed_by_size_and_font(String size, String font) {
        verify().that(getTextParametrs(TextParametrs.FONT).equals(font))
                .ifResultIsExpected("Correct text font:\n" + font)
                .ifElse("New text font is incorrect:\n" + getTextParametrs(TextParametrs.FONT))
                .and()
                .that(getTextParametrs(TextParametrs.SIZE).contains(size))
                .ifResultIsExpected("Correct text size:\n" + size)
                .ifElse("New text size is incorrect:\n" + getTextParametrs(TextParametrs.SIZE))
                .finish();
    }

    //Scenario: Set paging type (3/3)
    //Scenario: Cancel paging type (3/3)
    @Then("Paging type is changed by type $type (number $number)")
    public void paging_type_is_changed_by_type(String type, String number) throws InterruptedException {
        verify().that(verifyPagingType(PagingType.valueOf(type), number))
                .ifResultIsExpected("Correct paging type:" + type + "\nThere are " + number + " posts in the feed")
                .ifElse("Incorrect paging type:" + type + "\nThere are " +  ((JavascriptExecutor) getCurrentBrowser().getDriver()).executeScript("return jQuery('article.b-lenta-item').size()") + " posts in the feed")
                .finish();

    }

    //////////////////////////////////////////////////////////////////////////
    private String getElementColor(ColorSettings button) {
        switch (button) {
            case BACKGROUND_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".p-lenta")).getCssValue("background-color");
            case FOREGROUND_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".p-lenta .l-flatslide-content, .ljcut-link:after, .ljcut-pseudolink:after")).getCssValue("background-color");
            case SIDEBAR_BACKGROUND:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".p-lenta .l-flatslide-container:after, .p-lenta .l-flatslide-aside, .p-lenta .b-feedwidgets-item")).getCssValue("background-color");
            case ELEMENTS_BACKGROUND:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".j-e-actions, .b-lenta-calendar TABLE TH, .l-flatslide-settingslink, .l-flatslide-menu-button, .l-flatslide-menu-button:link, .b-lenta-up DIV, .b-lenta-new DIV, .b-feedwidgets-options .b-selectus, .b-mysocial-dummy-content, .b-mysocial-dummy-content:after, .b-myupdates-dummy-content, .b-myupdates-dummy-content:after, .b-todaylj-dummy-content, .b-todaylj-dummy-content:after, .b-mylinks-dummy-content, .b-mylinks-dummy-content:after")).getCssValue("background-color");
            case ELEMENTS_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".l-flatslide-menu-button, .l-flatslide-menu-button:link, .l-flatslide-menu-button:visited, .l-flatslide-menu-button:active, .l-flatslide-menu-button:hover, .l-flatslide-settingslink, .l-flatslide-settingslink:link, .l-flatslide-settingslink:visited, .l-flatslide-settingslink:active, .l-flatslide-settingslink:hover, .b-lenta-uparr, .j-e-actions-icon, .b-feedwidgets-move, .b-feedwidgets-close, .b-item-type-security-icon, .b-item-type-repost-icon, .j-e-nav-item-comments-icon, .j-e-nav-item-reply-icon, .b-mysocial-item-icon, .b-mysocial-item-dorepost .b-mysocial-item-icon, .b-mysocial-refresh, .b-mysocial-footer-logout-icon, .b-myupdates-item-remove, .b-todaylj-comments-icon, .ljcut-link-icon, .sbar-cal-nav-arr, .b-lenta-item-date, .b-lenta-item-journal, .b-selectus .label, .svgpreloader-background")).getCssValue("color");
            case BORDERS_COLOR:
                return "ERROR!!!";
            case MAIN_TEXT_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".b-lenta-body .b-lenta-item-title A:link")).getCssValue("color");
            case SIDEBAR_TEXT_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".p-lenta .l-flatslide-aside, .b-lenta-calendar TABLE TD, .b-lenta-calendar TABLE TH, .p-lenta .b-myupdates-emptiness, .p-lenta .b-feedwidgets .b-todaylj-caption A, .p-lenta .b-feedwidgets .b-todaylj-caption A:link, .p-lenta .b-feedwidgets .b-myupdates-item-content A:link, .sbar-cal-month, .sbar-cal-year, .p-lenta .b-mysocial-item-retweet .b-mysocial-item-rt")).getCssValue("color");
            case LINK_COLOR:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".b-lenta-body A:link, .b-lenta .b-mysocial-footer-logout-text, .b-lenta .b-mysocial-footer-refresh, .p-lenta .b-feedwidgets A:link, .p-lenta .l-flatslide-intro-heads A:link, .p-lenta .b-feedwidgets .b-myupdates-item-content .i-ljuser A:link, .b-translation-pseudo:link, .b-translation-pseudo:visited")).getCssValue("color");
            case ON_HOVER_COLOR:
                on(FriendsFeedLogged.class).getUserName().moveMouseOver();
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".b-lenta-body A:hover, .p-lenta .b-feedwidgets A:hover, .p-lenta .b-feedwidgets .b-todaylj-caption A:hover, .p-lenta .b-feedwidgets .b-myupdates-item-content A:hover, .p-lenta .b-feedwidgets .b-myupdates-item-content .i-ljuser A:hover, .b-translation-pseudo:hover, .p-lenta .l-flatslide-intro-heads A:hover")).getCssValue("color");
            case VISITED_LINK:
                on(FriendsFeedLogged.class).getUserName().click();
                return "ERROR!!!";
            default:
                Assert.fail("Unknown button " + button + "!");
        }
        return "ERROR!!!";
    }

    private String getTextParametrs(TextParametrs parametr) {
        switch (parametr) {
            case SIZE:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".p-lenta .l-flatslide-content, .p-lenta .l-flatslide-aside")).getCssValue("font-size");
            case FONT:
                return getCurrentBrowser().getDriver().findElement(By.cssSelector(".p-lenta .b-lenta-item-content")).getCssValue("font-family");

            default:
                Assert.fail("Unknown parametr " + parametr + "!");
        }
        return "ERROR!!!";
    }

    @StepGroup
    public boolean verifyColor(String hex, String rgb) {
        rgb = rgb.substring(rgb.indexOf('(') + 1, rgb.indexOf(')'));
        String[] mas = rgb.split(", ");
        boolean resultR = true;
        boolean resultG = true;
        boolean resultB = true;
        if ((Integer.parseInt(mas[0]) < Integer.parseInt(hex.substring(0, 2), 16) - 5) || (Integer.parseInt(mas[0]) > Integer.parseInt(hex.substring(0, 2), 16) + 5)) {
            resultR = !resultR;
        }

        if (Integer.parseInt(mas[1]) < Integer.parseInt(hex.substring(2, 4), 16) - 5 || Integer.parseInt(mas[1]) > Integer.parseInt(hex.substring(2, 4), 16) + 5) {
            resultG = !resultG;
        }

        if (Integer.parseInt(mas[2]) < Integer.parseInt(hex.substring(4, 6), 16) - 5 || Integer.parseInt(mas[2]) > Integer.parseInt(hex.substring(4, 6), 16) + 5) {
            resultB = !resultB;
        }
        return resultR & resultG & resultB;
    }

    @StepGroup
    public boolean verifyPagingType(PagingType type, String size) throws InterruptedException {
        String script = "jQuery('article.b-lenta-item').size()";
       // String script = "document.getElementsByTagName('article').length";
        Object feedSize = ((JavascriptExecutor) getCurrentBrowser().getDriver()).executeScript(script);
        System.out.println("+++++++++++++" + feedSize);
        switch (type) {
            case PAGES:
                System.out.println("+++++++++++++========" + feedSize);
                return on(FriendsFeedLogged.class).displaySwitchPagesButtons() && (Objects.equals(Integer.valueOf(feedSize.toString()), Integer.valueOf(size)));

            case ENDLESS:
               // ((JavascriptExecutor) getCurrentBrowser().getDriver()).executeScript(window.scrollBy(0,1000000));
                return !on(FriendsFeedLogged.class).displaySwitchPagesButtons(); //&& feedSize>20;

            default:
                Assert.fail("Unknown type " + type + "!");
        }
        return false;
    }
}
