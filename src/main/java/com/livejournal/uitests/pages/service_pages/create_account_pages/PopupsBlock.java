package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.LearnMorePageUnlogged;
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
    private UIElement popupBlock;

    @FindBy(css = ".b-popup-noclosecontrol:not([style*='display: none']) [style*='display: block;']")
    private TextBlock popupText;

    @FindBy(css = ".b-popup-outer a")
    private Link learnMoreLink;

    public boolean displayingPopupBlock() {
        return popupBlock.isDisplayed();
    }

    public String getPopupText() {
        return popupText.getText();
    }

    public LearnMorePageUnlogged clickOnLearnMoreLink() {
        learnMoreLink.click();
        return onOpened(LearnMorePageUnlogged.class);
    }

}
