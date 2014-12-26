package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.searchMenu.SearchMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.feedbackMenu.FeedbackMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenu;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = FullscreenHeader.CSS))
public class FullscreenHeader extends UIBlock {

    final static String CSS = ".s-header";

    @FindBy(css = ".s-logo")
    protected Link logo;

    @FindBy(css = ".s-nav-rootlink-discovery")
    protected Link ljMagazineMenuItem;
    
    @FindBy(css = ".s-nav-rootlink-browse")
    protected Link browseMenuItem;

    @FindBy(css = ".s-nav-item-shop")
    protected Link shopMenuItem;

    @FindBy(css = ".s-nav-rootlink.s-nav-rootlink-support")
    protected Link helpMenuItem;

    @FindBy(css = ".s-nav-rootlink.s-nav-rootlink-support")
    private Link feedbackMenuItem;

    @StepGroup
    public FeedbackMenu clickOnFeedbackMenuItem() {
        feedbackMenuItem.click();
        return onDisplayed(FeedbackMenu.class);
    }

}
