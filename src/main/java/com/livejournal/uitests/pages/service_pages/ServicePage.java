package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeader;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.feedbackMenu.FeedbackMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.searchMenu.SearchMenu;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author ASolyankin
 */
@Root
public abstract class ServicePage extends LJPage {

    public abstract FullscreenHeader getFullscreenHeader();

    @StepGroup
    public HelpMenu moveMouseOverHelpMenuItem() {
        return getFullscreenHeader().moveMouseOverHelpMenuItem();
    }

    @StepGroup
    public FeedbackMenu moveMouseOverFeedbackMenuItem() {
        return getFullscreenHeader().moveMouseOverFeedbackMenuItem();
    }

    @StepGroup
    public SearchMenu clickOnSearchMenuItem() {
        return getFullscreenHeader().clickOnSearchMenuItem();

    }
}
