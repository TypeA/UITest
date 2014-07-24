package com.livejournal.uitests.pages.service_pages.login_page;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-loginform-external"))
public class SocialNetworksBlock extends UIBlock {

    @FindBy(css = "[title='Facebook']")
    private Link facebookAuthorizationLink;

    @FindBy(css = "[title='Twitter']")
    private Link twitterAuthorizationLink;

    @FindBy(css = "[title='VK']")
    private Link vkAuthorizationLink;

    @FindBy(css = "[title='Google']")
    private Link googleAuthorizationLink;

    @FindBy(css = "[title='Mail.ru']")
    private Link mailAuthorizationLink;

    @FindBy(css = "[title='OpenID']")
    private Link openidAuthorizationLink;

    public Link getFacebookAuthorizationLink() {
        return facebookAuthorizationLink;
    }

    public Link getTwitterAuthorizationLink() {
        return twitterAuthorizationLink;
    }

    public Link getVkAuthorizationLink() {
        return vkAuthorizationLink;
    }

    public Link getGoogleAuthorizationLink() {
        return googleAuthorizationLink;
    }

    public Link getMailAuthorizationLink() {
        return mailAuthorizationLink;
    }

    public Link getOpenidAuthorizationLink() {
        return openidAuthorizationLink;
    }

}
