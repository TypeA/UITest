package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import java.io.IOException;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class EntryPage extends JournalPage {

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

    @StepGroup
    public String getIdPost(String user) throws IOException {
        return getDriver().getCurrentUrl().replace("http://" + user.replace("_", "-") + "." + getSystemConfiguration().getBaseUrl() + "/", "");
    }

    @StepGroup
    public String getTagsTextInSubject(String tag) {
        return startScript("return jQuery('.b-singlepost-title.entry-title.p-name " + tag + "').text()").toString();
    }
}
