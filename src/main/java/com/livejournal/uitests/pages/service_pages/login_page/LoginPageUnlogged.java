package com.livejournal.uitests.pages.service_pages.login_page;

import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author ASolyankin
 */
@DefaultUrl("/login.bml")
public class LoginPageUnlogged extends ServicePageUnlogged {

    @FindBy(css = ".b-bubble-noarrow")
    private TextBlock errorText;

    @FindBy(css = ".s-body .b-loginform")
    public LoginForm loginForm;

    @StepGroup
    public LJPage authorizeBy(String login, String password) {
        loginForm.authorizeBy(login, password);
        return onOpened(LJPage.class);
    }

    @StepGroup
    public void clickOnLostInfoLink() {
        loginForm.clickOnLostInfoLink();
    }


    public TextBlock getErrorText() {
        return errorText;
    }
}
