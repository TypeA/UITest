package com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks;

import com.livejournal.uitests.pages.service_pages.support_faq.feedbackBlock.FeedbackBlockLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = FeedbackMenu.CSS))
public class FeedbackMenuLogged extends FeedbackMenu {

    @StepGroup
    public FeedbackBlockLogged clickSendFeedback() {
        sendFeedback.click();
        return on(FeedbackBlockLogged.class);
    }
}
