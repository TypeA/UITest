package com.livejournal.uitests.pages.service_pages.login_page.OtherServiseAutorizationBlock;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(id = ".b-auth-input-wrapper-openid"))
public class OpenIdAutorizationBlock extends UIBlock {

    @FindBy(id = "openid_url")
    private TextField yourOpenID;

    @FindBy(id = ".b-flatbutton")
    private Button openIdButton;

    @FindBy(css = "a[href*='/support/faq']")
    private Link faqLink;

    public TextField getYourOpenID() {
        return yourOpenID;
    }

    public Button getOpenIdButton() {
        return openIdButton;
    }

    public Link getFaqLink() {
        return faqLink;
    }

}
