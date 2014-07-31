package com.livejournal.uitests.pages.service_pages.login_page.ThirdSideServiceAuthorizationBlock;

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
        @FindBy(id = "tab-twitter"))
public class TwitterAuthorizationBlock extends UIBlock {

    @FindBy(css = ".b-twitterbtn")
    private Button twitterButton;

    @FindBy(css = "a[href*='/support/faq']")
    private Link faqLink;

    public Button getTwitterButton() {
        return twitterButton;
    }

    public Link getFaqLink() {
        return faqLink;
    }

}
