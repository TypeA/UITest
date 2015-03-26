package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.PostContentBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".b-bubble-user .b-popup-outer"))
public class LJUserBubble extends UIBlock {

    @FindBy(css = ".b-updateform-bubble-input-username .b-updateform-bubble-input")
    private TextField username;

    @FindBy(name = ".b-updateform-bubble-user-button .b-flatbutton")
    private Button submitButton;

    @StepGroup
    public LJUserBubble enterUsername(String ljuser) {
        username.enter(ljuser);
        return onDisplayed(LJUserBubble.class);
    }

    @StepGroup
    public PostContentBlock clickSubmitButton() throws InterruptedException {
        startScript("jQuery('.b-updateform-bubble-user-button .b-flatbutton-simple').click()");
        Thread.sleep(500);
        return onDisplayed(PostContentBlock.class);
    }
}
