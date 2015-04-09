package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class EntryPage extends JournalPage {

    @StepGroup
    public EditJournalbml clickOnEditButton() {
        String script = "jQuery('.b-linkbar-item a[href*=\"editjournal\"]')[0].click()";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "jQuery('.j-e-buttons-item-edit_entry')[0].click()";
            ((JavascriptExecutor) getDriver()).executeScript(script);
        }
        return onOpened(EditJournalbml.class);
    }

    @StepGroup
    public String getPostText() {
        String script = "return jQuery('.b-singlepost-body.entry-content.e-content')[0].textContent";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "return jQuery('.j-e-text')[0].textContent";
        }
        return startScript(script).toString().trim();
    }

    @StepGroup
    public String getPostTime() {
        return startScript("return jQuery('.b-singlepost-author-date.published.dt-published')[0].textContent")
                .toString();
    }

    @StepGroup
    public boolean postWithStyleIsDisplayed(String text, String style_text) {
        String script = "";
        switch (style_text) {
            case "BOLD":
                script = "return jQuery(\"b\").is(\":contains('" + text + "')\")";
                break;
            case "ITALIC":
                script = "return jQuery(\"i\").is(\":contains('" + text + "')\")";
                break;
            case "UNDERLINED":
                script = "return jQuery(\"u\").is(\":contains('" + text + "')\")";
                break;
        }
        return Boolean.valueOf(startScript(script).toString());
    }

    @StepGroup
    public Boolean postWithFontIsDisplayed(String text, String font_style) {
        String script = "";
        switch (font_style) {
            case "TINY":
                script = "return jQuery(\"span[style='font-size:0.7em;']\").is(\":contains('" + text + "')\")";
                break;
            case "SMALL":
                script = "return jQuery(\"span[style='font-size:0.9em;']\").is(\":contains('" + text + "')\")";
                break;
            case "NORMAL":
                script = "return jQuery(\"article.e-content\").is(\":contains('" + text + "')\")";
                break;
            case "LARGE":
                script = "return jQuery(\"span[style='font-size:1.4em;']\").is(\":contains('" + text + "')\")";
                break;
            case "HUGE":
                script = "return jQuery(\"span[style='font-size:1.8em;']\").is(\":contains('" + text + "')\")";

        }
        return Boolean.valueOf(startScript(script).toString());
    }

    @StepGroup
    public Boolean postWithColorIsDisplayed(String text, String color) {
        String script = "return jQuery(\"span[style='color:#" + color + ";']\").is(\":contains('" + text + "')\")";
        return Boolean.valueOf(startScript(script).toString());
    }

    public Boolean postWithLinkIsDisplayed(String link, Boolean newWindow) {
        String target="";
        if (newWindow) {
            target = "[target='_blank']";
        } 
        String script = "return jQuery(\"a[href*='"+link+"']"+target+"\").is(\":contains('"+link+"')\")";
        return Boolean.valueOf(startScript(script).toString());
    }
     @StepGroup
    public Boolean linkWithStyleIsDisplayed(String link, String style_text) {
        String htmlLink = "a[href*='" + link + "']\").is(\":contains('" + link + "')\")";
        String script = "";
        switch (style_text) {
            case "BOLD":
                script = "return jQuery(\"b " + htmlLink;
                break;
            case "ITALIC":
                script = "return jQuery(\"i " + htmlLink;
                break;
            case "UNDERLINED":
                script = "return jQuery(\"u " + htmlLink;
                break;
        }
        return Boolean.valueOf(startScript(script).toString());
    }

}
