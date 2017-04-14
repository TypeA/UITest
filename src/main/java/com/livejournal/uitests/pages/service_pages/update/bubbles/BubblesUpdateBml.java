package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Block(
        @FindBy(css = ".p-openpopup"))
public class BubblesUpdateBml extends UIBlock {

    @StepGroup
    public ColorBubble colorBubble() {
        return onDisplayed(ColorBubble.class);
    }

    @StepGroup
    public LinkBubble linkBubble() {
        return onDisplayed(LinkBubble.class);
    }

    @StepGroup
    public UserBubble userBubble() {
        return onDisplayed(UserBubble.class);
    }

    @StepGroup
    public CutBubble cutBubble() {
        return onDisplayed(CutBubble.class);
    }

    @StepGroup
    public SpolierBubble spoilerBubble() {
        return onDisplayed(SpolierBubble.class);
    }

    @StepGroup
    public FontBubble fontBubble() {
        return onDisplayed(FontBubble.class);
    }

    @StepGroup
    public PhotoBubble photoBubble() {
        return onDisplayed(PhotoBubble.class);
    }

    @StepGroup
    public VideoBubble videoBubble() {
        return onDisplayed(VideoBubble.class);
    }

    @StepGroup
    public LikeBubble likeBubble() {
        return onDisplayed(LikeBubble.class);
    }

}
