package com.livejournal.uitests.pages.journal_pages.entry;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".hentry"))
public class EntryPageBlock extends UIBlock {

    @FindBy(css = ".b-msgsystem-error.b-msgsystem-error-banned ")
    private TextBlock errorTextBanned;

    @FindBy(css = ".entry-title")
    private TextBlock postSubject;

    public boolean errorTextBannedIsPresent() {
        return errorTextBanned.isDisplayed();
    }

    @StepGroup
    public EditJournalBml clickOnEditButton() {
        String script = "jQuery('.b-linkbar-item a[href*=\"editjournal\"]')[0].click()";
        try {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        } catch (Exception ex) {
            script = "jQuery('.j-e-buttons-item-edit_entry')[0].click()";
            ((JavascriptExecutor) getDriver()).executeScript(script);
        }
        return onOpened(EditJournalBml.class);
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
    public Boolean containsLjUser(String ljuser) {
        ljuser = ljuser.toLowerCase();
        String script = "return jQuery('.e-content span').is(\"[lj\\\\:user='" + ljuser + "']\")";
        Boolean fl = false;
        if (Boolean.valueOf(startScript(script).toString())) {
            fl = startScript("return jQuery('.e-content span')[0].textContent").toString().equals(ljuser);
        }
        return fl;
    }

    @StepGroup
    public String getPostSubject() {
        String subject;
        try {
            subject = postSubject.getText();
        } catch (Exception ex) {
            subject = "No subject";
        }
        return subject;
    }

    public boolean postWithStyleIsDisplayed(String text, String tag) {
        return Boolean.valueOf(startScript("return jQuery(\"" + tag + "\").is(\":contains('" + text + "')\")").toString());
    }

    @StepGroup
    public Boolean postWithFontIsDisplayed(String text, String font_style) {
        String jQuery = "";
        switch (font_style) {
            case "TINY":
                jQuery = "span[style='font-size:0.7em;']";
                break;
            case "SMALL":
                jQuery = "span[style='font-size:0.9em;']";
                break;
            case "NORMAL":
                jQuery = "article.e-content";
                break;
            case "LARGE":
                jQuery = "span[style='font-size:1.4em;']";
                break;
            case "HUGE":
                jQuery = "span[style='font-size:1.8em;']";

        }
        String script = "return jQuery(\"" + jQuery + "\").is(\":contains('" + text + "')\")";
        return Boolean.valueOf(startScript(script).toString());
    }

    @StepGroup
    public Boolean postWithColorIsDisplayed(String text, String color) {
        String script = "return jQuery(\"span[style='color:#" + color + ";']\").is(\":contains('" + text + "')\")";
        return Boolean.valueOf(startScript(script).toString());
    }

    public Boolean postWithLinkIsDisplayed(String link, Boolean newWindow) {
        String target = "";
        if (newWindow) {
            target = "[target='_blank']";
        }
        String script = "return jQuery(\"a[href*='" + link + "']" + target + "\").is(\":contains('" + link + "')\")";
        return Boolean.valueOf(startScript(script).toString());
    }

    @StepGroup
    public Boolean linkWithStyleIsDisplayed(String link, String style_text) {
        String htmlLink = "a[href*='" + link + "']\").is(\":contains('" + link + "')\")";
        String script = "return jQuery(\"" + style_text.toLowerCase() + " " + htmlLink;
        return Boolean.valueOf(startScript(script).toString());
    }

    @StepGroup
    public String getTagsTextInSubject(String tag) {
        return startScript("return jQuery('.b-singlepost-title.entry-title.p-name " + tag + "').text()").toString();
    }

    @StepGroup
    public String getSpoilerCustomText(String text) {
        return startScript("return jQuery('.lj-spoiler:contains(\"" + text + "\") .lj-spoiler-head a').text()").toString();

    }

    @StepGroup
    public String getTextSpoiler(String text) {
        startScript("jQuery('.lj-spoiler:contains(\"" + text + "\") .lj-spoiler-head a').click()");
        return startScript("return jQuery('.lj-spoiler:contains(\"" + text + "\") .lj-spoiler-body').text().trim()").toString();

    }

    @StepGroup
    public ArrayList<String> getLJLikeButtons() {
        ArrayList<WebElement> likes = (ArrayList<WebElement>) findElements(By.cssSelector(".lj-like-item"));
        ArrayList<String> likeClass = new ArrayList<String>();
        for (int i = 0; i < likes.size(); i++) {
            likeClass.add(likes.get(i).getAttribute("class"));
        }
        return likeClass;
    }
}
