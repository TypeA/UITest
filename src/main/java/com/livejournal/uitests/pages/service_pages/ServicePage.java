package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uisteps.thucydides.Root;
import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeader;

/**
 *
 * @author ASolyankin
 */
@Root
public abstract class ServicePage extends LJPage {

    private FullscreenHeader fullscreenHeader;

    public FullscreenHeader getFullscreenHeader() {
        return elem(fullscreenHeader);
    }

}
