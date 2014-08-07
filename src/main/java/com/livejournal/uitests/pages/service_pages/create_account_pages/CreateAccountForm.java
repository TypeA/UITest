package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = "form.b-ljform"))
public class CreateAccountForm extends UIBlock {

    @FindBy(css = "#username")
    private TextField userNameField;

    @FindBy(css = "#email")
    private TextField emailField;

    private PasswordBlock passwordBlock;

    private BirthDateForm birthDateForm;

    @FindBy(css = "#gender")
    private Select genderDropDownMenu;

    @FindBy(css = "#createpage_create")
    private Button createAccountButton;

    @FindBy(css = "a[href*='legal/tos-russian-translation.bml']")
    private Link tosRusLink;

    @FindBy(css = "a[href*='/legal/privacy-russian-translation.bml']")
    private Link privacyRusLink;

    @StepGroup
    public void createAccountData(String name, String email, String password, String day, String month, String year, String gender) {
        getUserNameField().enter(name);
        getEmailField().enter(email);
        getPasswordBlock().getPasswordField().enter(password);
        getBirthDateForm().getDayDropDownMenu().selectByValue(day);
        getBirthDateForm().getMonthDropDownMenu().selectByValue(month);
        getBirthDateForm().getYearDropDownMenu().selectByValue(year);
        getGenderDropDownMenu().selectByValue(gender);
    }

    public TextField getUserNameField() {
        return elem(userNameField);
    }

    public TextField getEmailField() {
        return elem(emailField);
    }

    public PasswordBlock getPasswordBlock() {
        return elem(passwordBlock);
    }

    public BirthDateForm getBirthDateForm() {
        return elem(birthDateForm);
    }

    public Select getGenderDropDownMenu() {
        return elem(genderDropDownMenu);
    }

    public Button getCreateAccountButton() {
        return elem(createAccountButton);
    }

    public Link getTosRusLink() {
        return elem(tosRusLink);
    }

    public Link getPrivacyRusLink() {
        return elem(privacyRusLink);
    }

}
