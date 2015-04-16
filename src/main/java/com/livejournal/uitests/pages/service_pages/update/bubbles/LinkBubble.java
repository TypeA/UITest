package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.forms_and_blocks.PostContentBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".b-bubble-link"))
public class LinkBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-input")
    private TextField inputUrl;

    @FindBy(css = ".b-updateform-bubble-checkbox")
    private Button checkboxNewWindow;

    @FindBy(xpath = "//button[@class='b-flatbutton b-flatbutton-simple  ng-binding' and @lj-disabled[contains(.,'link')]]")
    private Button addButtonLink;

    @StepGroup
    public PostContentBlock addLink(String url, Boolean newWindow) {
        inputUrl.enter(url);
        if (newWindow) {
            checkboxNewWindow.click();
        }
        addButtonLink.click();
        return onDisplayed(PostContentBlock.class);
    }
}
