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
        @FindBy(css = HeaderLocator.CSS))
public class FullscreenHeader extends UIBlock 
{
    private Logo logo;

    @FindBy(css = ".s-nav-rootlink-discovery")
    private Link ljMagazine;

    private HelpMenuItem helpMenuItem;
    
    @FindBy(css = ".s-nav-rootlink.s-nav-rootlink-support")
    private FeedbackMenuItem feedbackMenuItem;

    private SearchMenuItem searchMenuItem;

    public Logo getLogo() {
        return elem(logo);
    }

    public Link getLjMagazine() {
        return elem(ljMagazine);
    }

    public HelpMenuItem getHelpMenuItem() {
        return elem(helpMenuItem);
    }

    public FeedbackMenuItem getFeedback() {
        return elem(feedbackMenuItem);
    }

    public SearchMenuItem getSearchMenuItem() {
        return elem(searchMenuItem);
    }

}
