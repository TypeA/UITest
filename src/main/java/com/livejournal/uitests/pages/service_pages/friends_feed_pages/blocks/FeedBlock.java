package com.livejournal.uitests.pages.service_pages.friends_feed_pages.blocks;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
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
        @FindBy(css = ".l-flatslide-container"))
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

}
