package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.feedbackMenu;

import com.livejournal.uitests.pages.service_pages.support_faq.feedbackBlock.FeedbackBlockUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = FeedbackMenu.CSS))
public class FeedbackMenuUnlogged extends FeedbackMenu {

    @StepGroup
    public FeedbackBlockUnlogged clickSendFeedback() {
        sendFeedback.click();
        return on(FeedbackBlockUnlogged.class);
    }

}
