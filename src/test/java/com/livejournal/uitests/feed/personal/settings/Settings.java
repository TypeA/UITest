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
import java.util.ArrayList;
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

    //Scenario: New Title(1/3)
    //Scenario: Change Title(1/3)
    //Scenario: Set new color(1/3)
    //Scenario: Cancel changing Title (1/3)
    //Scenario: Cansel new color (1/3)
    //Scenario: Return the current color (1/3)
    //Scenario: Set text settings (1/3)
    //Scenario: Set paging type (1/3)
    //Scenario: Cancel paging type (1/3)
    //Scenario: Cancel text settings (1/3)
    @Given("logged user (name $name) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name))
                .defoultLanguage(name);
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
    }

    //Scenario: Restore default settings (1/3)
    //Scenario: Scenario: Save settings after user logged out (1/3)
    @Given("logged user (name $name) with own settings on Friends Feed")
    public void logged_user_with_own_settings_on_Friends_Feed(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name))
                .defoultLanguage(name);
        open(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
        setRandomSettings();
    }

    //Scenario: New Title(2/3)
    @When("user add new Title $title in Settings and save it")
    public void user_add_new_Title_in_Settings_and_save_it(String title) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .enterTitle(title)
                .saveSettings();
    }

    //Scenario: Change Title(2/3)
    @When("user change Title $title in Settings and save it")
    public void user_change_Title_in_Settings_and_save_it(String title) {
        ThucydidesUtils.putToSession("feed_title", onOpened(FriendsFeedLogged.class).getFeedTitle());
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .typeToTitle(title)
                .saveSettings();
    }

    //Scenario: Cancel changing Title(2/3)
    @When("user change Title $title in Settings and cancel it")
    public void user_change_Title_in_Settings_and_cansel_it(String title) {
        ThucydidesUtils.putToSession("feed_title", onOpened(FriendsFeedLogged.class).getFeedTitle());
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .typeToTitle(title);
        verify().that(onOpened(FriendsFeedLogged.class).getFeedTitle().equals((String) ThucydidesUtils.getFromSession("feed_title") + title))
                .ifResultIsExpected(VerifyText.okTextForMessage((String) ThucydidesUtils.getFromSession("feed_title") + title))
                .ifElse(VerifyText.errorTextForMessage(onOpened(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
        onDisplayed(SettingsBlock.class)
                .cancelSettings();
    }

    //Scenario: Set new color(2/3)
    @When("user change color $color by type $type (parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY) and save it")
    public void user_change_color_by_type_and_save_it(String color, String type, String code, String barY, String colorX, String colorY) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.valueOf(type), code, Integer.parseInt(barY), Integer.parseInt(colorX), Integer.parseInt(colorY))
                .saveSettings();
    }

    //Scenario: Return the current color(2/3)
    @When("user change color $color (old code $code) and return current color")
    public void user_change_color_and_return_current_color(String color, String code) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.BY_CODE, code, 0, 0, 0)
                .saveSettings()
                .openSettings()
                .getColor(ColorSettings.valueOf(color))
                .setColorBarByPoint(new RandomeValue(250).get())
                .setColorByPoint(new RandomeValue(250).get(), new RandomeValue(250).get());
        verify().that(!verifyColor(code, onDisplayed(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getNewColor())
                .finish();
        onDisplayed(SettingsBubbleColorBlock.class)
                .setCurrentColor();
    }

    //Scenario: Cansel new color (2/3)
    @When("user change color $color (old code $code) and cansel it")
    public void user_change_color_and_cansel_it(String color, String code) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.BY_CODE, code, 0, 0, 0)
                .saveSettings()
                .openSettings()
                .getColor(ColorSettings.valueOf(color))
                .setColorBarByPoint(new RandomeValue(250).get())
                .setColorByPoint(new RandomeValue(250).get(), new RandomeValue(250).get());
        verify().that(!verifyColor(code, onDisplayed(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color :\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getNewColor())
                .finish();
        onDisplayed(SettingsBubbleColorBlock.class)
                .clickChooseButton()
                .cancelSettings();
    }

    //Scenario: Set text settings (2/3)
    @When("user change text size $size and font $font in Settings and save it")
    public void user_change_text_size_and_font_in_Settings_and_save_it(String size, String font) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setTextSettings(size, font)
                .saveSettings();
    }

    //Scenario: Cancel text settings (2/3)
    @When("user change text size $new_size and font $new_font in Settings and cancel it (old size $size, old font $font)")
    public void user_change_text_size_and_font_in_Settings_and_cancel_it(String new_size, String new_font, String size, String font) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setTextSettings(size, font)
                .saveSettings();
        refreshCurrentPage();
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setTextSettings(new_size, new_font)
                .cancelSettings();
    }

    //Scenario: Set paging type (2/3)
    @When("user set Paging type $type (number $number)  in Settings and save it")
    public void user_set_Paging_type_in_Settings_and_save_it(String type, String number) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setPaging(type)
                .setSize(number)
                .saveSettings();
        refreshCurrentPage();
    }

    //Scenario: Cancel paging type (2/3)
    @When("user set Paging type $new_type (old type $type, number $number) in Settings and cancel it")
    public void user_set_Paging_type_in_Settings_and_cansel_it(String new_type, String type, String number) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setPaging(type)
                .setSize(number)
                .saveSettings()
                .openSettings()
                .setPaging(new_type)
                .setSize(number)
                .cancelSettings();

    }

    //Scenario: Restore default settings (2/3)
    @When("user click Restore default settings Button and save it")
    public void user_click_Restore_default_settings_Button_and_save_it() throws InterruptedException {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .restoreDefaultSettings();
    }

    //Scenario: Save settings after user logged out (2/3)
    @When("user logged out and logged in again (name $name)")
    public void user_logged_out_and_logged_in_again(String name) {
        ThucydidesUtils.putToSession("all_settings", rememberSettings());
        onOpened(FriendsFeedLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut()
                .clickOnLoginMenuItem()
                .authorizeBy(name, workWithDB().getUserPassword(name));
    }

    //Scenario: New Title(3/3)
    //Scenario: Change Title(3/3)
    @Then("the Title is changed on correct title $correct_title")
    public void title_is_changed_on_correct_title(String correct_title) {
        refreshCurrentPage();
        String title = (String) ThucydidesUtils.getFromSession("feed_title");
        if (title != null) {
            correct_title = title + correct_title;
        }
        verify().that(onOpened(FriendsFeedLogged.class).getFeedTitle().equals(correct_title))
                .ifResultIsExpected(VerifyText.okTextForMessage(correct_title))
                .ifElse(VerifyText.errorTextForMessage(onOpened(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
    }

    //Scenario: Cancel changing Title (3/3)
    @Then("the Title is not changed")
    public void the_Title_is_not_changed() {
        verify().that(onOpened(FriendsFeedLogged.class).getFeedTitle().equals((String) ThucydidesUtils.getFromSession("feed_title")))
                .ifResultIsExpected(VerifyText.okTextForMessage((String) ThucydidesUtils.getFromSession("feed_title")))
                .ifElse(VerifyText.errorTextForMessage(onOpened(FriendsFeedLogged.class).getFeedTitle()))
                .finish();
    }

    //Scenario: Set new color(3/3)
    //Scenario: Cansel new color (3/3)
    @Then("the color $color corresponds to correct code $code")
    public void the_color_corresponds_to_correct_code(String color, String code) {
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .getColor(ColorSettings.valueOf(color));
        verify().that(verifyColor(code, onDisplayed(SettingsBubbleColorBlock.class).getCurrentColor()))
                .ifResultIsExpected("Correct current color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("Current color is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getCurrentColor())
                .and()
                .that(verifyColor(code, onDisplayed(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getNewColor())
                .and()
                .that(verifyColor(code, "(" + HexToRGB.hexToRGB(onDisplayed(SettingsBubbleColorBlock.class).getCode()) + ")"))
                .ifResultIsExpected("Correct color code:\n" + code)
                .ifElse("Color code is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getCode())
                .and()
                .that(verifyColor(code, getElementColor(ColorSettings.valueOf(color))))
                .ifResultIsExpected("Correct element color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("Element color is incorrect:\n" + getElementColor(ColorSettings.valueOf(color)))
                .finish();
    }

    //Scenario: Return the current color(3/3)
    @Then("the color changed to the current code $code")
    public void the_color_changed_to_the_current(String code) {
        verify().that(verifyColor(code, onDisplayed(SettingsBubbleColorBlock.class).getNewColor()))
                .ifResultIsExpected("Correct new color:\n" + HexToRGB.hexToRGB(code))
                .ifElse("New color is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getNewColor())
                .and()
                .that(verifyColor(code, "(" + HexToRGB.hexToRGB(onDisplayed(SettingsBubbleColorBlock.class).getCode()) + ")"))
                .ifResultIsExpected("Correct color code:\n" + code)
                .ifElse("Color code is incorrect:\n" + onDisplayed(SettingsBubbleColorBlock.class).getCode())
                .finish();
    }

    //Scenario: Set text settings (3/3)
    //Scenario: Cancel text settings (3/3)
    @Then("text settings is changed by size $size and font $font")
    public void text_settings_is_changed_by_size_and_font(String size, String font) throws InterruptedException {
        Thread.sleep(100);
        verify().that(getTextParametrs(TextParametrs.FONT).contains(font))
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
        refreshCurrentPage();
        Thread.sleep(10000);
        String strNumber = number;
        if (type.equals("ENDLESS")) {
            strNumber = "more then 20";
        }
        verify().that(verifyPagingType(PagingType.valueOf(type), number))
                .ifResultIsExpected("Correct paging type:" + type + "\nMust be " + strNumber + " posts in the feed")
                .ifElse("Incorrect paging type:" + type + "\nThere are " + ThucydidesUtils.getFromSession("feed_size") + " posts in the feed")
                .finish();

    }

    //Scenario: Restore default settings (3/3)
    @Then("default settings are set")
    public void default_settings_are_set() {
        verify().that(rememberColors().containsAll(defaultSettings()))
                .ifResultIsExpected("Default settings are set")
                .ifElse("Default settings are not set!")
                .finish();

    }

    //Scenario: Save settings after user logged out (3/3)
    @Then("user's settings are applied")
    public void users_settings_are_applied() {
        ArrayList<String> old_settings = (ArrayList<String>) ThucydidesUtils.getFromSession("all_settings");
        verify().that(rememberSettings().containsAll(old_settings))
                .ifResultIsExpected("User's settings are applied")
                .ifElse("User's settings are not applied!")
                .finish();
    }

    //////////////////////////////////////////////////////////////////////////
    private ArrayList<String> getElementColor(ColorSettings button) {
        ArrayList<String> ans = new ArrayList<String>();
        switch (button) {
            case BACKGROUND_COLOR:
                ans.add(startScript("return jQuery('.p-lenta').css('backgroundColor')").toString());
                return ans;
            case FOREGROUND_COLOR:
                ans.add(startScript("return jQuery('.p-lenta .l-flatslide-content').css('backgroundColor')").toString());
                return ans;
            case SIDEBAR_BACKGROUND:
                ans.add(startScript("return jQuery('.p-lenta .l-flatslide-aside').css('backgroundColor')").toString());
                return ans;
            case ELEMENTS_BACKGROUND:
                ans.add(startScript("return jQuery('.js-elem-bgcolor').css('backgroundColor')").toString());
                ans.add(startScript("return jQuery('.b-lenta-calendar TABLE TH').css('backgroundColor')").toString());
                ans.add(startScript("return jQuery('.b-feedwidgets-options .b-selectus').css('backgroundColor')").toString());
                return ans;
            case ELEMENTS_COLOR:
                ans.add(startScript("return jQuery('.js-elem-color--svgicon .svgicon').css('color')").toString());
                ans.add(startScript("return jQuery('.b-selectus .label').css('color')").toString());
                ans.add(startScript("return jQuery('.svgpreloader-background').css('color')").toString());
                ans.add(startScript("return jQuery('.js-elem-color').css('color')").toString());
                ans.add(startScript("return jQuery('.b-lenta-sidebar-title').css('color')").toString());
                return ans;
            case BORDERS_COLOR:
                ans.add(startScript("return jQuery('.js-elem-bordercolor').css('borderTopColor')").toString());
                ans.add(startScript("return jQuery('.js-elem-bordercolor--table TD').css('borderTopColor')").toString());
                ans.add(startScript("return jQuery('.js-elem-bordercolor--table TH').css('borderTopColor')").toString());
                ans.add(startScript("return jQuery('.b-feedwidgets-options').css('borderTopColor')").toString());
                ans.add(startScript("return jQuery('.b-feedwidgets-options .b-selectus').css('borderTopColor')").toString());
                return ans;
            case MAIN_TEXT_COLOR:
                ans.add(startScript("return jQuery('.js-font-color').css('color')").toString());
                return ans;
            case SIDEBAR_TEXT_COLOR:
                ans.add(startScript("return jQuery('.js-sidebar-color').css('color')").toString());
                ans.add(startScript("return jQuery('.js-sidebar-color TH').css('color')").toString());
                ans.add(startScript("return jQuery('.js-sidebar-color TD').css('color')").toString());
                ans.add(startScript("return jQuery('.sbar-cal-month').css('color')").toString());
                ans.add(startScript("return jQuery('.sbar-cal-year').css('color')").toString());
                return ans;
            case LINK_COLOR:
                ans.add(startScript("return jQuery('.js-link-color').css('color')").toString());
                ans.add(startScript("return jQuery('.js-link-color:link').css('color')").toString());
                ans.add(startScript("return jQuery('.js-link-color--a A:link').css('color')").toString());
                ans.add(startScript("return jQuery('.js-link-color--a-novisited A:link').css('color')").toString());
                ans.add(startScript("return jQuery('.b-translation-pseudo:link').css('color')").toString());
                return ans;
            case ON_HOVER_COLOR:
                onOpened(FriendsFeedLogged.class).getUserName().moveMouseOver();
                ans.add(getNecessaryValue(".p-lenta .l-flatslide-intro-heads A:hover", "color"));
                return ans;
            case VISITED_LINK:
                onOpened(FriendsFeedLogged.class).getUserName().click();
                ans.add("ERROR!!!");
                return ans;
            default:
                Assert.fail("Unknown button " + button + "!");
                ans.add("ERROR!!!");
                return ans;
        }
    }
    
    
    private String getNecessaryValue(String selector, String value) {
        return getCurrentBrowser()
                .getDriver()
                .findElement(By.cssSelector(selector))
                .getCssValue(value);
    }

    private String getTextParametrs(TextParametrs parametr) {
        switch (parametr) {
            case SIZE:
                return startScript("return jQuery('.p-lenta .entryunit__text').css('font-size')").toString();
            case FONT:
                return startScript("return jQuery('.p-lenta .entryunit__text').css('font-family')").toString();

            default:
                Assert.fail("Unknown parametr " + parametr + "!");
        }
        return "ERROR!!!";
    }

    @StepGroup
    public boolean verifyColor(String hex, ArrayList<String> rgbArray) {
        boolean result = true;
        for (int i = 0; i < rgbArray.size(); i++) {
            result = result & verifyColor(hex, rgbArray.get(i));
        }
        return result;
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
        Integer intSize = Integer.valueOf(size);
        String script = "return jQuery('.entryunit__text').size()";

        switch (type) {
            case PAGES:
                Object feedSize = ((JavascriptExecutor) getCurrentBrowser().getDriver()).executeScript(script);
                Integer intFeedSize = Integer.valueOf(feedSize.toString());
                ThucydidesUtils.putToSession("feed_size", feedSize);
                Integer correctSize;
                if (intSize < 1 || intSize > 20) {
                    correctSize = 20;
                } else {
                    correctSize = intSize;
                }
                return onOpened(FriendsFeedLogged.class).displaySwitchPagesButtons() && Objects.equals(intFeedSize, correctSize);

            case ENDLESS:
                ((JavascriptExecutor) getCurrentBrowser().getDriver())
                        .executeScript("window.scrollBy(0,10000000)");
                Thread.sleep(5000);
                feedSize = ((JavascriptExecutor) getCurrentBrowser().getDriver()).executeScript(script);
                intFeedSize = Integer.valueOf(feedSize.toString());
                ThucydidesUtils.putToSession("feed_size", feedSize);
                return !onOpened(FriendsFeedLogged.class).displaySwitchPagesButtons() && intFeedSize > 20;

            default:
                Assert.fail("Unknown type " + type + "!");
        }
        return false;
    }

    private String getColorCode(ColorSettings button) {
        return onDisplayed(SettingsBlock.class)
                .getCurrentColorCode(button);
    }

    private ArrayList<String> rememberColors() {
        onOpened(FriendsFeedLogged.class)
                .openSettings();
        ArrayList<String> colors = new ArrayList<>();
        for (ColorSettings colorSetting : ColorSettings.values()) {
            String a = getColorCode(colorSetting);
            colors.add(a);
        }
        return colors;
    }

    private ArrayList<String> rememberSettings() {
        ArrayList<String> settings = rememberColors();
        settings.add(getTextParametrs(TextParametrs.FONT) + ", " + getTextParametrs(TextParametrs.SIZE));
        return settings;
    }

    private ArrayList<String> defaultSettings() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("ffffff");
        colors.add("ffffff");
        colors.add("ffffff");
        colors.add("f8f9fb");
        colors.add("7a9199");
        colors.add("dae3e6");
        colors.add("242f33");
        colors.add("242f33");
        colors.add("00a3d9");
        colors.add("0086b3");
        colors.add("007399");
        return colors;
    }

    private void setRandomSettings() {
        Integer text_size = new RandomeValue(26).get() + 10;
        String paging_type;
        String text_font;
        if (new RandomeValue(20).get() > 1) {
            paging_type = "PAGES";
            text_font = "Arial";
        } else {
            paging_type = "ENDLESS";
            text_font = "ProximaNovaRegular";
        }
        onOpened(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.BACKGROUND_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.BORDERS_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.ELEMENTS_BACKGROUND, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.ELEMENTS_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.FOREGROUND_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.LINK_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.MAIN_TEXT_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.ON_HOVER_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.SIDEBAR_BACKGROUND, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.SIDEBAR_TEXT_COLOR, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setColor(ColorSettings.VISITED_LINK, ColorSelectType.BY_POINT, "", new RandomeValue(250).get(), new RandomeValue(250).get(), new RandomeValue(250).get())
                .setTextSettings(text_size.toString(), text_font)
                .setPaging(paging_type)
                .setSize(new RandomeValue(20).get().toString())
                .saveSettings();
    }
}
