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
        @FindBy(css = ".b-bubble-color"))
public class ColorBubble extends UIBlock {

    @FindBy(css = ".b-colorpicker-controls-hex")
    private TextField codeColor;

    @FindBy(css = "button.b-flatbutton[ng-click='submitColor()']")
    private Button chooseColorButton;

    public void setTextColor(String color) {
        codeColor.enter(color);
        chooseColorButton.click();
    }

}
