package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css=".s-header"))
public class FullscreenHeader extends UIBlock {

    private Logo logo;

    @FindBy(css = ".s-nav-rootlink-discovery")
    private Link ljMagazine;

    private HelpMenuItem helpMenuItem;

    private FeedbackMenuItem feedback;

    private SearchMenuItem searchMenuItem;

    public Logo getLogo() {
        return logo;
    }

    public Link getLjMagazine() {
        return ljMagazine;
    }

    public HelpMenuItem getHelpMenuItem() {
        return helpMenuItem;
    }

    public FeedbackMenuItem getFeedback() {
        return feedback;
    }

    public SearchMenuItem getSearchMenuItem() {
        return searchMenuItem;
    }

}
