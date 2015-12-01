package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.journal_pages.blocks.EntryPageBlock;
import java.io.IOException;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author s.savinykh
 */
public class EntryPageUnlogged extends JournalPageUnlogged {

    @StepGroup
    public EntryPageBlock Entry() {
        return onDisplayed(EntryPageBlock.class);
    }

    @StepGroup
    public String getIdPost(String user) throws IOException {
        return getDriver().getCurrentUrl().replace("http://" + user.replace("_", "-") + "." + getSystemConfiguration().getBaseUrl() + "/", "");
    }

}
