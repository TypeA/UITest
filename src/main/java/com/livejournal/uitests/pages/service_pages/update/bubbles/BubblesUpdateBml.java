package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Block(
        @FindBy(css = ".p-openpopup"))
public class BubblesUpdateBml extends UIBlock {

    @StepGroup
    public ColorBubble openColorBubble() {
        return new ColorBubble();
    }

    @StepGroup
    public LinkBubble openLinkBubble() {
        return new LinkBubble();
    }

    @StepGroup
    public LJUserBubble openLJUserBubble() {
        return new LJUserBubble();
    }

    @StepGroup
    public LJCutBubble openLJCutBubble() {
        return new LJCutBubble();
    }

    @StepGroup
    public SpolierBubble openSpoilerBubble() {
        return new SpolierBubble();
    }

    @StepGroup
    public FontBubble openFontBubble() {
        return new FontBubble();
    }

    @StepGroup
    public PhotoBubble openPhotoBubble() {
        return new PhotoBubble();
    }

}
