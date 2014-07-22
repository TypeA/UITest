
package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(xpath = ".//*[@class='b-popup bubble-node b-createpage-bubble b-popup-noclosecontrol' and @style[not(contains(.,'display: none'))]]"))
public class Popups extends UIBlock{
    
    @FindBy(xpath = ".//div[@style='display: block;']")
    private TextBlock popupText;
    
    @FindBy(xpath = ".//*[@class[contains(.,'b-popup-outer')]] //a[@target='_blank' and @href[contains(.,'/support/faqbrowse.bml')]]")
    private Link learnMoreLink;

    /**
     * @return the popupText
     */
    public TextBlock getPopupText() {
        return elem(popupText);
    }

    /**
     * @return the learnMoreLink
     */
    public Link getLearnMoreLink() {
        return elem(learnMoreLink);
    }
}
