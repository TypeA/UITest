package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
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

    @FindBy(css = ".b-updateform-bubble-insert-button .b-flatbutton-simple")
    private Button save;

    public void useSpoiler(String spoilerText) {
        if (spoilerText.toUpperCase().equals("DEFAULT")) {
            save.click();
        } else {
            spoiler.enter(spoilerText);
            save.click();
        }

    }

}
