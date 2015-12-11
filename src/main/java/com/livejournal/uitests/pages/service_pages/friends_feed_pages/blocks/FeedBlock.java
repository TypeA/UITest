package com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".l-flatslide-wrapper"))
public class FeedBlock extends UIBlock {

    @FindBy(css = ".b-lenta-preview")
    public UIElement lentaPreview;

    @FindBy(css = ".l-flatslide-intro-heads .b-lenta-head-title")
    private TextBlock feedTitle;

    @FindBy(css = ".l-flatslide-intro-heads .i-ljuser-type-P a:not([href*='profile'])")
    private Link userName;

    @FindBy(css = ".b-lenta-emptiness")
    private TextBlock feedEmpty;

    @FindBy(css = ".b-pager-prev")
    private Button previousButton;

    @FindBy(css = ".b-pager-next")
    private Button nextButton;

    @StepGroup
    public String getFeedTitle() {
        return feedTitle.getText();
    }

    @StepGroup
    public Link getUserName() {
        return userName;
    }

    @StepGroup
    public boolean displaySwitchPagesButtons() {
        try {
            return previousButton.isDisplayed() && nextButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @StepGroup
    public boolean feedIsEmpty() {
        return feedEmpty.isDisplayed();
    }

    @StepGroup
    public Integer getNumberOfPosts() {
        return Integer.valueOf(startScript("return jQuery('.entryunit__text').size()").toString());
    }

    @StepGroup
    public ArrayList<String> getAutors() {
        ArrayList<String> ans = new ArrayList<String>();
        int num = getNumberOfPosts();
        for (int i = 0; i < num; i++) {
            ans.add(startScript("return jQuery('.author-entryunit').eq("
                    + i + ").find('.ljuser').eq(jQuery('.author-entryunit').eq("
                    + i + ").find('.ljuser').size()-1).text()").toString());
        }
        return ans;
    }

    @StepGroup
    public boolean postInFeedBySubject(String subject) {
        int size = getNumberOfPosts();
        boolean ans = false;
        for (int i = 0; i < size; i++) {
            String subj = startScript("return jQuery('.entryunit__title .js-link-color').eq("
                    + i + ").text()").toString();
            if (subject.equals(subj)) {
                ans = true;
                i = getNumberOfPosts();
            }
        }
        return ans;
    }

    @StepGroup
    public String getTextSpoiler(String text) {
        startScript("jQuery('.lj-spoiler:contains(\"" + text + "\") .lj-spoiler-head a').click()");
        return startScript("return jQuery('.lj-spoiler:contains(\"" + text + "\") .lj-spoiler-body').text().trim()").toString();

    }

    @StepGroup
    public String getSpoilerCustomText(String text) {
        return startScript("return jQuery('.lj-spoiler:contains(\"" + text + "\") .lj-spoiler-head a').text()").toString();

    }

    @StepGroup
    public String getTextFromLJCut(String text) {
        startScript("jQuery('.entryunit__text:contains(\"" + text + "\") .ljcut-decor a').click()");
        return startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") div').text().trim()").toString();

    }

    @StepGroup
    public String getLJCutCustomText(String text) {
        return startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") .ljcut-link-expand').attr('title')").toString();

    }

}
