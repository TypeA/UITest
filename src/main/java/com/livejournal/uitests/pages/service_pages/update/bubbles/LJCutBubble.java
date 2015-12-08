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
        @FindBy(css = ".b-bubble-cut"))
public class LJCutBubble extends UIBlock {

    @FindBy(css = ".b-bubble-cut .b-updateform-bubble-input")
    private TextField ljcutText;

    public void useLJCut(String ljcut) {
        if (ljcut.toUpperCase().equals("DEFAULT")) {
            startScript("jQuery('.b-bubble-cut .b-flatbutton').click()");
        } else {
            ljcutText.enter(ljcut);
            startScript("jQuery('.b-bubble-cut .b-flatbutton').click()");
        }
    }

}
