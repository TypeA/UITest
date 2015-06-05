package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.content.editors.HTMLEditor;
import com.livejournal.uitests.pages.service_pages.update.content.editors.VisualEditor;

/**
 *
 * @author m.prytkova
 */
public class UpdateBmlBlockes extends UIBlock {

    public UpdateBmlPageLogged usePage() {
        return onOpened(UpdateBmlPageLogged.class);
    }

    public EditJournalBml useEditingPage() {
        return onOpened(EditJournalBml.class);
    }

    public PostContentBlock usePostContent() {
        return onDisplayed(PostContentBlock.class);
    }

    public AdditionalContent useAdditionalContent() {
        return onDisplayed(AdditionalContent.class);
    }

    public VisualEditor useVisualEditor() {
        return onDisplayed(VisualEditor.class);
    }

    public HTMLEditor useHTMLEditor() {
        return onDisplayed(HTMLEditor.class);
    }

}
