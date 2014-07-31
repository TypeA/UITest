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
        @FindBy(id = "tab-facebook"))
public class FacebookAuthorizationBlock extends UIBlock {

    @FindBy(css = ".b-facebookbtn")
    private Button facebookButton;

    @FindBy(css = "a[href*='/support/faq']")
    private Link faqLink;

    public Button getFacebookButton() {
        return facebookButton;
    }

    public Link getFaqLink() {
        return faqLink;
    }
}
