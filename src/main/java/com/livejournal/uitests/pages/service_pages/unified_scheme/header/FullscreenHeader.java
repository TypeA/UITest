package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = HeaderLocator.CSS))
public class FullscreenHeader extends UIBlock {

    @FindBy(css = ".s-logo")
    protected Link logo;

    @FindBy(css = ".s-nav-rootlink-discovery")
    protected Link ljMagazineMenuItem;

    @FindBy(css = ".s-nav-item-shop")
    protected Link shopMenuItem;

    @FindBy(css = ".s-nav-rootlink.s-nav-rootlink-support")
    private Link helpMenuItem;

    @FindBy(css = ".s-nav-rootlink.s-nav-rootlink-support")
    private Link feedbackMenuItem;

    @FindBy(css = ".s-do-item-search")
    private Link searchMenuItem;

    public HelpMenu moveMouseOverHelpMenuItem() {
        helpMenuItem.moveMouseOver();
        return on(HelpMenu.class);
    }

    public FeedbackMenu moveMouseOverFeedbackMenuItem() {
        feedbackMenuItem.moveMouseOver();
        return on(FeedbackMenu.class);
    }

    public SearchMenu clickOnSearchMenuItem() {
        searchMenuItem.click();
        return on(SearchMenu.class);
    }
}
