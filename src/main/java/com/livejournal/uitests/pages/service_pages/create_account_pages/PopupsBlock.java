package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@Block(
@FindBy(css = "body"))
public class PopupsBlock extends UIBlock {

    @FindBy(css = ".b-popup-noclosecontrol:not([style*='display: none'])")
    private Link popupBlock;
    
    @FindBy(css = ".b-popup-noclosecontrol:not([style*='display: none']) [style*='display: block;']")
    private TextBlock popupText;

    @FindBy(css = ".b-popup-outer a[href*='/support/faqbrowse.bml']")
    private Link learnMoreLink;

    public TextBlock getPopupText() {
        return elem(popupText);
    }

    public Link getLearnMoreLink() {
        return elem(learnMoreLink);
    }

    public Link getPopupBlock() {
        return elem(popupBlock);
    }
}
