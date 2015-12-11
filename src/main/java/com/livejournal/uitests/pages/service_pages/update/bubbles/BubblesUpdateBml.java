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
        return new ColorBubble();
    }

    @StepGroup
    public LinkBubble linkBubble() {
        return new LinkBubble();
    }

    @StepGroup
    public LJUserBubble userBubble() {
        return onDisplayed(LJUserBubble.class);
    }

    @StepGroup
    public LJCutBubble cutBubble() {
        return new LJCutBubble();
    }

    @StepGroup
    public SpolierBubble spoilerBubble() {
        return new SpolierBubble();
    }

    @StepGroup
    public FontBubble fontBubble() {
        return new FontBubble();
    }

    @StepGroup
    public PhotoBubble photoBubble() {
        return new PhotoBubble();
    }

}
