package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
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

    @FindBy(id = "username")
    public TextField userNameField;

    @FindBy(id = "email")
    public TextField emailField;
    
    public FieldPassword fieldPassword;
    
    public BirthDateForm birthDateForm;
    
    @FindBy(id = "gender")
    public Select genderDropDownMenu;
    
    @FindBy(id = "createpage_create")
    public Button createAccountButton;
    
    // тут надо вставить две ссылочки, которые есть на форме
    
    public FinishForm finishForm;
    
    @StepGroup
    public void createAccountData(String name, String email, String password, String day, String month, String year, String gender) {
        userNameField.enter(name);
        emailField.enter(email);
        fieldPassword.passwordField.enter(password);
        birthDateForm.dayDropDownMenu.selectByValue(day);
        birthDateForm.monthDropDownMenu.selectByValue(month);
        birthDateForm.yearDropDownMenu.selectByValue(year);
        genderDropDownMenu.selectByValue(gender);   
    }
}
