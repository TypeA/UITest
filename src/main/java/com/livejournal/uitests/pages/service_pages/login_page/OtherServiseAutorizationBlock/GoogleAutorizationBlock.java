package com.livejournal.uitests.pages.service_pages.login_page.OtherServiseAutorizationBlock;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(id = "tab-google"))
public class GoogleAutorizationBlock extends UIBlock {

    @FindBy(css = "button")
    private Button googleButton;

    @FindBy(css = "a[href*='/support/faq']")
    private Link faqLink;

    public Button getGoogleButton() {
        return googleButton;
    }

    public Link getFaqLink() {
        return faqLink;
    }

}
