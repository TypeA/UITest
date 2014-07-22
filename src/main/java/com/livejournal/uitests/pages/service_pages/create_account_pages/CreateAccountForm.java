package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.UIBlock;
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
    private TextField userNameField;

    @FindBy(id = "email")
    private TextField emailField;
    
    private FieldPassword passwordBlock;
    
    private BirthDateForm birthDateForm;
    
    @FindBy(id = "gender")
    private Select genderDropDownMenu;
    
    @FindBy(id = "createpage_create")
    private Button createAccountButton;
    
    // тут надо вставить две ссылочки, которые есть на форме
    
    //public Popups popups;
    
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

    /**
     * @return the userNameField
     */
    public TextField getUserNameField() {
        return elem(userNameField);
    }

    /**
     * @return the emailField
     */
    public TextField getEmailField() {
        return elem(emailField);
    }

    /**
     * @return the passwordBlock
     */
    public FieldPassword getPasswordBlock() {
        return elem(passwordBlock);
    }

    /**
     * @return the birthDateForm
     */
    public BirthDateForm getBirthDateForm() {
        return elem(birthDateForm);
    }

    /**
     * @return the genderDropDownMenu
     */
    public Select getGenderDropDownMenu() {
        return elem(genderDropDownMenu);
    }

    /**
     * @return the createAccountButton
     */
    public Button getCreateAccountButton() {
        return elem(createAccountButton);
    }
}
