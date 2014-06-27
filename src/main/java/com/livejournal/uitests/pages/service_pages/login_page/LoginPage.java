package com.livejournal.uitests.pages.service_pages.login_page;

import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.ServicePage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author ASolyankin
 */
@DefaultUrl("/login.bml")
public class LoginPage extends ServicePage {
    public LoginForm loginForm;

    @StepGroup
    public void authorizeBy(String login, String password) {
        loginForm.authorizeBy(login, password);
    }
}
