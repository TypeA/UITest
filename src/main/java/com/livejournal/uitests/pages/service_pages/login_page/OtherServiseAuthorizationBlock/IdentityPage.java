package com.livejournal.uitests.pages.service_pages.login_page.OtherServiseAuthorizationBlock;

import com.livejournal.uitests.pages.service_pages.ServicePage;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/identity/login.bml")
public class IdentityPage extends ServicePage {

    private FacebookAuthorizationBlock facebookAutorizationBlock;
    private GoogleAuthorizationBlock googleAutorizationBlock;
    private MailAuthorizationBlock mailAutorizationBlock;
    private OpenIdAuthorizationBlock openIdAutorizationBlock;
    private TwitterAuthorizationBlock twitterAutorizationBlock;
    private VkAuthorizationBlock vkAutorizationBlock;

    public FacebookAuthorizationBlock getFacebookAutorizationBlock() {
        return facebookAutorizationBlock;
    }

    public GoogleAuthorizationBlock getGoogleAutorizationBlock() {
        return googleAutorizationBlock;
    }

    public MailAuthorizationBlock getMailAutorizationBlock() {
        return mailAutorizationBlock;
    }

    public OpenIdAuthorizationBlock getOpenIdAutorizationBlock() {
        return openIdAutorizationBlock;
    }

    public TwitterAuthorizationBlock getTwitterAutorizationBlock() {
        return twitterAutorizationBlock;
    }

    public VkAuthorizationBlock getVkAutorizationBlock() {
        return vkAutorizationBlock;
    }

}
