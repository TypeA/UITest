package com.livejournal.uitests.pages.service_pages.update.content.editors;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.update.bubbles.BubblesUpdateBml;
import com.livejournal.uitests.pages.service_pages.update.content.UpdateBmlBlockes;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".b-updatepage-event"))
public class HTMLEditor extends UpdateBmlBlockes {

    @FindBy(css = ".b-updatepage-tab-html")
    public Button htmlEditButton;

    @FindBy(css = ".b-updateform-textarea")
    public TextField postHtmlField;

    @FindBy(css = ".b-updateform-button.b-updateform-button-user")
    private Link ljUserButton;

    @StepGroup
    public HTMLEditor setPostText(String text) {
        postHtmlField.enter(text);
        return this;
    }

    @StepGroup
    public HTMLEditor setUsername(String ljuser, Boolean isCorrectUser) {
        ljUserButton.click();
        onDisplayed(BubblesUpdateBml.class).openLJUserBubble().enterUsername(ljuser, isCorrectUser);
        return this;
    }

    @StepGroup
    public HTMLEditor setUserNameByAutocomplete(String ljuser) {
        ljUserButton.click();
        onDisplayed(BubblesUpdateBml.class).openLJUserBubble().enterUsernameUsingAutocomplete(ljuser);
        return this;
    }

    @WhenPageOpens
    public void switchToHTMLEditor() {
        htmlEditButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HTMLEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
