package com.livejournal.uitests.feed.personal.settings;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSelectType;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.ColorSettings;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.utility.VerifyText;
import java.util.Enumeration;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class Settings extends WebTest {

    public String feed_title;

    @Given("logged user (name $name, password $password) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name, String password) {
        getCurrentBrowser().getDriver().manage().deleteAllCookies();
        on(LoginPage.class)
                .authorizeBy(name, password);
        on(FriendsFeedLogged.class, new Url().setPrefix(name + "."));
    }

    @When("user add new Title $title in Settings and save it")
    public void user_add_new_Title_in_Settings_and_save_it(String title) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .enterTitle(title)
                .saveSettings();
    }

    @When("user change Title $title in Settings and save it")
    public void user_change_Title_in_Settings_and_save_it(String title) {
        ThucydidesUtils.putToSession("feed_title", on(FriendsFeedLogged.class).getFeedTitle());
        on(FriendsFeedLogged.class)
                .openSettings()
                .typeToTitle(title)
                .saveSettings();
    }

    @When("user change color $color by type $type (parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY) and save it")
    public void user_change_color_by_type_and_save_it(String color, String type, String code, String barY, String colorX, String colorY) {
        on(FriendsFeedLogged.class)
                .openSettings()
                .setColor(ColorSettings.valueOf(color), ColorSelectType.valueOf(type), code, 1, 1, 1)
                .saveSettings();
    }

    @Then("the Title is changed on correct title $correct_title")
    public void title_is_changed_on_correct_title(String correct_title) {
        verifyThatTitleIsCorrect(correct_title);
    }

    @Then("color $color is changed by parametrs: code $code, barY $barY, colorX $colorX, colorY $colorY")
    public void color_is_changed_by_parametrs(ColorSettings color, String code, int barY, int colorX, int colorY) {
        String current_color = on(FriendsFeedLogged.class).openSettings().getColor(color).getCurrentColor();
        verify().that(true).ifResultIsExpected(current_color).ifElse(current_color);
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
}
