package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uitests.pages.service_pages.error_strip.ErrorStrip;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeader;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.feedbackMenu.FeedbackMenu;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author ASolyankin
 */
@Root
public abstract class ServicePage extends LJPage {

    public abstract FullscreenHeader getFullscreenHeader();

    public abstract ErrorStrip getErrorStrip();
    
    @StepGroup
    public FeedbackMenu moveMouseOverFeedbackMenuItem() {
        return getFullscreenHeader().clickOnFeedbackMenuItem();
    }

}
