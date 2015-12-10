package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-bubble-spoiler"))
public class SpolierBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-input")
    private TextField spoiler;

    public void useSpoiler(String spoilerText) {
        if (spoilerText.toUpperCase().equals("DEFAULT")) {
            startScript("jQuery('.b-bubble-spoiler .b-flatbutton').click()");
        } else {
            spoiler.enter(spoilerText);
            startScript("jQuery('.b-bubble-spoiler .b-flatbutton').click()");
        }

    }

}
