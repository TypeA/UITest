package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.editors.HTMLEditor;
import com.livejournal.uitests.pages.service_pages.update.content.editors.VisualEditor;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-updatepage"))
public class AdditionalContent extends UIBlock {

    @FindBy(id = ".b-updatepage-checkbox-sticky")
    public Button subjectField;

    public AdditionalContent setStickyPost() {
        subjectField.click();
        return this;
    }

    public UpdateBmlPageLogged usePage() {
        return onOpened(UpdateBmlPageLogged.class);
    }

    public EditJournalBml useEditingPage() {
        return onOpened(EditJournalBml.class);
    }

    public PostContentBlock usePostContent() {
        return onDisplayed(PostContentBlock.class);
    }

    public VisualEditor useVisualEditor() {
        return onDisplayed(VisualEditor.class);
    }

    public HTMLEditor useHTMLEditor() {
        return onDisplayed(HTMLEditor.class);
    }

}
