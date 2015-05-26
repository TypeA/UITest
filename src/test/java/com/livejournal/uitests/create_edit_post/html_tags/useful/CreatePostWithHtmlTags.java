package com.livejournal.uitests.create_edit_post.html_tags.useful;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.panferova
 */
public class CreatePostWithHtmlTags extends WebTest {

    //Scenario: Create post with style(1/3)
    //Scenario: Create post with font(1/3)
    //Scenario: Create post with color(1/3)
    //Scenario: Create post with custom text(1/3)
    //Scenario: Create post with link(1/3)
    //Scenario: Create post with custom link(1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        open(UpdateBmlPageLogged.class);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Create post with style(2/3)
    @When("user create new post with style $tag and save post")
    public void user_create_new_post_with_bold_text_and_save_post(String tag) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setTextStyle(tag)
                .enterTextToVisualEditor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    //Scenario: Create post with font(2/3)
    @When("user create new post with font $font_text and save post")
    public void user_create_new_post_with_font_and_save_post(String font_text) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setTextFont(font_text.toUpperCase())
                .enterTextToVisualEditor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    //Scenario: Create post with color(2/3)
    @When("user create new post with color $color_text and save post")
    public void user_create_new_post_with_color_and_save_post(String color_text) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setTextColor(color_text)
                .enterTextToVisualEditor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    //Scenario: Create post with custom text(2/3)
    @When("user create new post with color $color_text style_1 $tag_1 style_2 $tag_2 and save post")
    public void user_create_new_post_with_color_style_1_style_2_and_save_post(String color_text, String tag_1, String tag_2) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setTextStyle(tag_1)
                .setTextStyle(tag_2)
                .setTextColor(color_text)
                .enterTextToVisualEditor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    //Scenario: Create post with link(2/3)
    @When("user create new post with link $link and add property open in new window $newWindow")
    public void user_create_new_post_with_link(String link, String newWindow) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .addLink(link, Boolean.valueOf(newWindow))
                .postEntry();
    }

    //Scenario: Create post with custom link(2/3)
    @When("user create new post with link $link and style $tag")
    public void user_create_new_post_with_link_link_and_style(String link, String tag) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setTextStyle(tag)
                .addLink(link, Boolean.FALSE)
                .postEntry();
    }

    //Scenario: Create post with style(3/3)
    @Then("post with style $tag is displayed correctly")
    public void post_is_displayed_correctly(String tag) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(onOpened(EntryPage.class).postWithStyleIsDisplayed(post_text, tag))
                .ifResultIsExpected("Post is displayed with bold text")
                .ifElse("Post is not displayed with bold text")
                .finish();
    }

    //Scenario: Create post with font(3/3)
    @Then("post with font $font_text is displayed correctly")
    public void pos_with_font_is_displayed_correctly(String font_text) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(onOpened(EntryPage.class).postWithFontIsDisplayed(post_text, font_text.toUpperCase()))
                .ifResultIsExpected("Post is displayed with font " + font_text + "and post_text " + post_text)
                .ifElse("Post is not displayed with font " + font_text + "and post_text " + post_text)
                .finish();
    }

    //Scenario: Create post with color(3/3)
    @Then("post with color $color_text is displayed correctly")
    public void post_with_font_is_displayed_correctly(String color_text) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(onOpened(EntryPage.class).postWithColorIsDisplayed(post_text, color_text))
                .ifResultIsExpected("Post is displayed with color " + color_text)
                .ifElse("Post is not displayed with color " + color_text)
                .finish();
    }

    //Scenario: Create post with custom text(3/3)
    @Then("post with color $color_text and styles $tag_1 $tag_2 is displayed correctly")
    public void post_with_color_and_styles_is_displayed_correctly(String color_text, String tag_1, String tag_2) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(onOpened(EntryPage.class).postWithColorIsDisplayed(post_text, color_text))
                .ifResultIsExpected("Post is displayed with color " + color_text)
                .ifElse("Post is not displayed with color " + color_text)
                .and()
                .that(onOpened(EntryPage.class).postWithStyleIsDisplayed(post_text, tag_1))
                .ifResultIsExpected("Post is displayed with style  " + tag_1)
                .ifElse("Post is not displayed with style " + tag_1)
                .and()
                .that(onOpened(EntryPage.class).postWithStyleIsDisplayed(post_text, tag_2))
                .ifResultIsExpected("Post is displayed with style  " + tag_2)
                .ifElse("Post is not displayed with style " + tag_2)
                .finish();
    }

    //Scenario: Create post with link(3/3)
    @Then("post with link $link is displayed and open in newWindow $newWindow")
    public void post_with_link_is_displayed_and_open_in_newWindow(String link, String newWindow) {
        verify().that(onOpened(EntryPage.class).postWithLinkIsDisplayed(link, Boolean.valueOf(newWindow)))
                .ifResultIsExpected("Post is displayed with link " + link)
                .ifElse("Post is not displayed with link " + link)
                .finish();
    }

    //Scenario: Create post with custom link(3/3)
    @Then("post with link $link and with style $tag is displayed")
    public void post_with_link_and_with_style_is_displayed(String link, String tag) {
        verify().that(onOpened(EntryPage.class).linkWithStyleIsDisplayed(link, tag.toUpperCase()))
                .ifResultIsExpected("Post is displayed with link " + link + " and with style " + tag)
                .ifElse("Post is not displayed with link " + link + " and with style " + tag)
                .finish();
    }

}
