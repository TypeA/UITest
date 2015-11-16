package com.livejournal.uitests.pages.service_pages.login_page;

import com.livejournal.uitests.pages.LJPage;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import java.util.Set;
import junit.framework.Assert;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Cookie;
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
        verifyAutorize();
        return onOpened(LJPage.class);
    }

    @StepGroup
    public LJPage authorizeBy(String login, String password, boolean verify) {
        loginForm.authorizeBy(login, password);

        if (verify) {
            verifyAutorize();
        }
        return onOpened(LJPage.class);
    }

    @StepGroup
    public void clickOnLostInfoLink() {
        loginForm.clickOnLostInfoLink();
    }

    public TextBlock getErrorText() {
        return errorText;
    }

    private void verifyAutorize() {
        Set<Cookie> allCookies = getDriver().manage().getCookies();
        boolean flag = false;
        for (Cookie loadedCookie : allCookies) {
            if (loadedCookie.getName().equals("ljmastersession")) {
                flag = true;
            }
        }
        Assert.assertTrue("User cannot autorize", flag);
    }
}
