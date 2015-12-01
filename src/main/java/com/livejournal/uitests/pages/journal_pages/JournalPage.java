package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uitests.pages.service_pages.error_strip.ErrorStrip;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeader;

/**
 *
 * @author ASolyankin
 */
@Root
public abstract class JournalPage extends LJPage {

    public abstract FullscreenHeader getFullscreenHeader();

    public abstract ErrorStrip getErrorStrip();

}
