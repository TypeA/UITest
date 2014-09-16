package com.livejournal.uitests.feed.personal.settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSelectType;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSettings;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBubbleColorBlock;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.TextParametrs;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.utility.HexToRGB;
import com.livejournal.uitests.utility.RandomeValue;
import com.livejournal.uitests.utility.VerifyText;
import net.thucydides.core.annotations.StepGroup;
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
    //Scenario: Set new color(1/3)
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
        on(SettingsBubbleColorBlock.class).setCurrentColor();
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
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + on(SettingsBubbleColorBlock.class).getNewColor())
                .finish();
        on(SettingsBubbleColorBlock.class)
                .clickChooseButton()
                .cancelSettings();
    }

    //Scenario: Text settings (2/3)
    @When("user change text size $size and font $font in Settings and save it")
    public void user_change_text_size_and_font_in_Settings_and_save_it(String size, String font) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setTextSettings(size, font)
                .saveSettings();
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
                .ifElse(VerifyText.errorTextForMessage(correct_title, on(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
    }

    //Scenario: Set new color(3/3)
    @Then("color $color is changed by parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY")
    public void color_is_changed_by_parametrs(String color, String type, String code, String barY, String colorX, String colorY) {
        on(FriendsFeedLogged.class).openSettings().getColor(ColorSettings.valueOf(color));
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

    //Scenario: Cansel new color (3/3)
    @Then("users color $color is restore by code $code")
    public void users_color_is_restore_by_code(String color, String code) {
        on(FriendsFeedLogged.class).openSettings().getColor(ColorSettings.valueOf(color));
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

    //Scenario: Text settings (3/3)
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

    //////////////////////////////////////////////////////////////////////////
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
}
