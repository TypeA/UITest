package com.livejournal.uitests.pages.common_elements;

import com.livejournal.uitests.pages.service_pages.login_page.SocialNetworksBlock;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author ASolyankin
 */
@Block(
        @FindBy(css = ".s-body .b-loginform"))
public class LoginForm extends UIBlock {

    private SocialNetworksBlock socialNetworksBlock;

    @FindBy(css = "#user")
    private TextField loginField;
    @FindBy(css = "#lj_loginwidget_password")
    private TextField passwordField;
    @FindBy(css = "[name='action:login']")
    private Button submitButton;
    @FindBy(xpath = ".//*[@href[contains(.,'/create')]]")
    private Link createAccountLink;

    @StepGroup
    public void authorizeBy(String login, String password) {
        getLoginField().enter(login);
        getPasswordField().enter(password);
        getSubmitButton().click();
    }

    public TextField getLoginField() {
        return elem(loginField);
    }

    public TextField getPasswordField() {
        return elem(passwordField);
    }

    public Button getSubmitButton() {
        return elem(submitButton);
    }

    public Link getCreateAccountLink() {
        return elem(createAccountLink);
    }

    public SocialNetworksBlock getSocialNetworksBlock() {
        return elem(socialNetworksBlock);
    }

}
