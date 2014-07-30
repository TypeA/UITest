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
        @FindBy(id = "tab-mailru"))
public class MailAutorizationBlock extends UIBlock {

    @FindBy(css = ".b-mailrubtn")
    private Button mailButton;

    @FindBy(css = "a[href*='/support/faq']")
    private Link faqLink;

    public Button getMailButton() {
        return mailButton;
    }

    public Link getFaqLink() {
        return faqLink;
    }
}
