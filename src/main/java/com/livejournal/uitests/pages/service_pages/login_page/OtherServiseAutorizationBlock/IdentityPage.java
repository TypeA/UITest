package com.livejournal.uitests.pages.service_pages.login_page.OtherServiseAutorizationBlock;

import com.livejournal.uitests.pages.service_pages.ServicePage;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/identity/login.bml")
public class IdentityPage extends ServicePage {

    private FacebookAutorizationBlock facebookAutorizationBlock;
    private GoogleAutorizationBlock googleAutorizationBlock;
    private MailAutorizationBlock mailAutorizationBlock;
    private OpenIdAutorizationBlock openIdAutorizationBlock;
    private TwitterAutorizationBlock twitterAutorizationBlock;
    private VkAutorizationBlock vkAutorizationBlock;

    public FacebookAutorizationBlock getFacebookAutorizationBlock() {
        return facebookAutorizationBlock;
    }

    public GoogleAutorizationBlock getGoogleAutorizationBlock() {
        return googleAutorizationBlock;
    }

    public MailAutorizationBlock getMailAutorizationBlock() {
        return mailAutorizationBlock;
    }

    public OpenIdAutorizationBlock getOpenIdAutorizationBlock() {
        return openIdAutorizationBlock;
    }

    public TwitterAutorizationBlock getTwitterAutorizationBlock() {
        return twitterAutorizationBlock;
    }

    public VkAutorizationBlock getVkAutorizationBlock() {
        return vkAutorizationBlock;
    }

}
