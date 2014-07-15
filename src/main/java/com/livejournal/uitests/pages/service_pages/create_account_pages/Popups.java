
package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(xpath = ".//*[@class='b-popup bubble-node b-createpage-bubble b-popup-noclosecontrol']"))
public class Popups extends UIBlock{
    
    @FindBy(xpath = ".//div[@style='display: block;']")
    public TextField popupText;
    
    @FindBy(xpath = ".//*[@href[contains(.,'/support/faqbrowse.bml')]]")
    public Link learnMoreLink;
}
