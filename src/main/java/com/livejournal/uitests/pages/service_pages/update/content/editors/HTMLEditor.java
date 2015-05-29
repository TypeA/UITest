package com.livejournal.uitests.pages.service_pages.update.content.editors;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.BubblesUpdateBml;
import com.livejournal.uitests.pages.service_pages.update.content.PostContentBlock;
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
public class HTMLEditor extends UIBlock {

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

    public PostContentBlock usePostContent() {
        return onDisplayed(PostContentBlock.class);
    }

    public UpdateBmlPageLogged usePage() {
        return onOpened(UpdateBmlPageLogged.class);
    }

    public EditJournalBml useEditingPage() {
        return onOpened(EditJournalBml.class);
    }

    @WhenPageOpens
    public void switchToHTMLEditor() {
        htmlEditButton.click();
    }

}
