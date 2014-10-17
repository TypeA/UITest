package com.livejournal.uitests.pages.common_elements;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.login_page.SocialNetworksBlock;
import com.livejournal.uitests.pages.service_pages.lost_info.LostInfoPage;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author ASolyankin
 */
@Block(
        @FindBy(css = ".b-loginform-body"))
public class LoginForm extends UIBlock {

    private SocialNetworksBlock socialNetworksBlock;

    @FindBy(id = "user")
    private TextField loginField;

    @FindBy(css = "#lj_loginwidget_password")
    private TextField passwordField;

    @FindBy(css = "[name='action:login']")
    private Button submitButton;

    @FindBy(css = "a[href*='/lostinfo']")
    private Link lostInfo;

    @FindBy(css = "a[href*='/create']")
    private Link createAccountLink;

    @StepGroup
    public void authorizeBy(String login, String password) {
        loginField.enter(login);
        passwordField.enter(password);
        submitButton.click();
    }



    public CreateAccountPage clickOnCreateAccountLink() {
        createAccountLink.click();
        return onOpened(CreateAccountPage.class);
    }

    public LostInfoPage clickOnLostInfoLink() {
        lostInfo.click();
        return onOpened(LostInfoPage.class);
    }

}
