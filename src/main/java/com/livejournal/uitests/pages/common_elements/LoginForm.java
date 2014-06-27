package com.livejournal.uitests.pages.common_elements;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
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

    @FindBy(css = ".b-loginform-close")
    public Button cross;
    @FindBy(css = "#user")
    public TextField loginField;
    @FindBy(css = "#lj_loginwidget_password")
    public TextField passwordField;
    @FindBy(css = "[name='action:login']")
    public Button submitButton;

    @StepGroup
    public void authorizeBy(String login, String password) {
        loginField.enter(login);
        passwordField.enter(password);
        submitButton.click();
    }
     
    public void close() {
        cross.click();
    }
}
