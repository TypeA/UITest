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
        @FindBy(css = ".b-bubble-cut"))
public class CutBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-input")
    private TextField ljcutText;

    @FindBy(css = ".b-updateform-bubble-insert-button .b-flatbutton-simple")
    private Button save;

    public void useLJCut(String ljcut) {
        if (!ljcut.toUpperCase().equals("DEFAULT")) {
            ljcutText.enter(ljcut);
        }
        save.click();
    }

}
