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
    public LJUserBubble userBubble() {
        return onDisplayed(LJUserBubble.class);
    }

    @StepGroup
    public LJCutBubble cutBubble() {
        return onDisplayed(LJCutBubble.class);
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

}
