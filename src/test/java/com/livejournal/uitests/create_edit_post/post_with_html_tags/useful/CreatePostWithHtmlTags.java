/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.create_edit_post.post_with_html_tags.useful;

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
    @When("user create new post with style $style_text and save post")
    public void user_create_new_post_with_bold_text_and_save_post(String style_text) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setStyleText(style_text.toUpperCase())
                .goToVisualRedactor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
    }

    //Scenario: Create post with style(3/3)
    @Then("post with style $style_text is displayed correctly")
    public void post_is_displayed_correctly(String style_text) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        verify().that(onOpened(EntryPage.class).postWithStyleIsDisplayed(post_text, style_text.toUpperCase()))
                .ifResultIsExpected("Post is displayed with bold text")
                .ifElse("Post is not displayed with bold text")
                .finish();
    }

    //Scenario: Create post with font(2/3)
    @When("user create new post with font $font_text and save post")
    public void user_create_new_post_with_font_and_save_post(String font_text) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setFontText(font_text.toUpperCase())
                .goToVisualRedactor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
    }

    //Scenario: Create post with font(3/3)
    @Then("post with font $font_text is displayed correctly")
    public void pos_with_font_is_displayed_correctly(String font_text) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        verify().that(onOpened(EntryPage.class).postWithFontIsDisplayed(post_text, font_text.toUpperCase()))
                .ifResultIsExpected("Post is displayed with font " + font_text)
                .ifElse("Post is not displayed with font " + font_text)
                .finish();
    }

    //Scenario: Create post with color(2/3)
    @When("user create new post with color $color_text and save post")
    public void user_create_new_post_with_color_and_save_post(String color_text) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setColorText(color_text)
                .goToVisualRedactor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
    }

    //Scenario: Create post with color(3/3)
    @Then("post with color $color_text is displayed correctly")
    public void post_with_font_is_displayed_correctly(String color_text) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        verify().that(onOpened(EntryPage.class).postWithColorIsDisplayed(post_text, color_text))
                .ifResultIsExpected("Post is displayed with color " + color_text)
                .ifElse("Post is not displayed with color " + color_text)
                .finish();
    }

    //Scenario: Create post with custom text(2/3)
    @When("user create new post with color $color_text style_1 $style_text_1 style_2 $style_text_2 and save post")
    public void user_create_new_post_with_color_style_1_style_2_and_save_post(String color_text, String style_text_1, String style_text_2) {
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setStyleText(style_text_1.toUpperCase())
                .setStyleText(style_text_2.toUpperCase())
                .setColorText(color_text)
                .goToVisualRedactor(post_text)
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
    }

    //Scenario: Create post with custom text(3/3)
    @Then("post with color $color_text and styles $style_text_1 $style_text_2 is displayed correctly")
    public void post_with_color_and_styles_is_displayed_correctly(String color_text, String style_text_1, String style_text_2) {
        String post_text = ThucydidesUtils.getFromSession("post_text").toString();
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        verify().that(onOpened(EntryPage.class).postWithColorIsDisplayed(post_text, color_text))
                .ifResultIsExpected("Post is displayed with color " + color_text)
                .ifElse("Post is not displayed with color " + color_text)
                .and()
                .that(onOpened(EntryPage.class).postWithStyleIsDisplayed(post_text, style_text_1.toUpperCase()))
                .ifResultIsExpected("Post is displayed with style  " + style_text_1)
                .ifElse("Post is not displayed with style " + style_text_1)
                .and()
                .that(onOpened(EntryPage.class).postWithStyleIsDisplayed(post_text, style_text_2.toUpperCase()))
                .ifResultIsExpected("Post is displayed with style  " + style_text_2)
                .ifElse("Post is not displayed with style " + style_text_2)
                .finish();
    }

    //Scenario: Create post with link(2/3)
    @When("user create new post with link $link and add property open in new window $newWindow")
    public void user_create_new_post_with_link(String link, String newWindow) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .addLink(link, Boolean.valueOf(newWindow))
                .postEntry();
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
    }

    //Scenario: Create post with link(3/3)
    @Then("post with link $link is displayed and open in newWindow $newWindow")
    public void post_with_link_is_displayed_and_open_in_newWindow(String link, String newWindow) {
        open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        verify().that(onOpened(EntryPage.class).postWithLinkIsDisplayed(link, Boolean.valueOf(newWindow)))
                .ifResultIsExpected("Post is displayed with link " + link)
                .ifElse("Post is not displayed with link " + link)
                .finish();
    }

    //Scenario: Create post with custom link(2/3)
    @When("user create new post with link $link and style $style_text")
    public void user_create_new_post_with_link_link_and_style(String link, String style_text) {
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .setVisualEditor()
                .setStyleText(style_text.toUpperCase())
                .addLink(link, Boolean.FALSE)
                .postEntry();
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
    }

    //Scenario: Create post with custom link(3/3)
    @Then("post with link $link and with style $style_text is displayed")
    public void post_with_link_and_with_style_is_displayed(String link, String style_text) {
        String url = open(EntryPage.class, new Url()
                .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()))
                .getUrl().toString();
        verify().that(onOpened(EntryPage.class).linkWithStyleIsDisplayed(link, style_text.toUpperCase()))
                .ifResultIsExpected("Post is displayed with link " + link + " and with style " + style_text)
                .ifElse("Post is not displayed with link " + link + " and with style " + style_text)
                .finish();
    }
    
}
