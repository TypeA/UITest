package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePage;
import com.livejournal.uitests.pages.service_pages.support_faq.PrivacyRusPage;
import com.livejournal.uitests.pages.service_pages.support_faq.TosRusPage;
import com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form.FinishForm;
import junit.framework.Assert;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/create")
public class CreateAccountPage extends ServicePage {

    @FindBy(css = "#username")
    private TextField userNameField;

    @FindBy(css = "#email")
    private TextField emailField;

    @FindBy(css = "#password")
    private TextField passwordField;

    @FindBy(css = ".b-passview-icon-show")
    private Link passwordMappingLinkShow;

    @FindBy(css = ".b-passview-icon-hide")
    private Link passwordMappingLinkHide;

    @FindBy(id = "day")
    private Select dayDropDownMenu;

    @FindBy(id = "month")
    private Select monthDropDownMenu;

    @FindBy(id = "year")
    private Select yearDropDownMenu;

    @FindBy(css = "#gender")
    private Select genderDropDownMenu;

    @FindBy(css = "#createpage_create")
    private Button createAccountButton;

    @FindBy(css = "a[href*='legal/tos-russian-translation.bml']")
    private Link tosRusLink;

    @FindBy(css = "a[href*='/legal/privacy-russian-translation.bml']")
    private Link privacyRusLink;

    @StepGroup
    public CreateAccountPage createAccountData(String name, String email, String password, String day, String month, String year, String gender) {
        userNameField.enter(name);
        emailField.enter(email);
        passwordField.enter(password);
        dayDropDownMenu.selectByValue(day);
        monthDropDownMenu.selectByValue(month);
        yearDropDownMenu.selectByValue(year);
        genderDropDownMenu.selectByValue(gender);
        return this;
    }

    @StepGroup
    public PopupsBlock clickOnUserNameField() {
        userNameField.type("");
        return on(PopupsBlock.class);
    }

    @StepGroup
    public PopupsBlock clickOnEmailField() {
        emailField.type("");
        return on(PopupsBlock.class);
    }

    @StepGroup
    public PopupsBlock clickOnPasswordField() {
        passwordField.type("");
        return on(PopupsBlock.class);
    }

    @StepGroup
    public CreateAccountPage enterPassword(String password) {
        passwordField.enter(password);
        return this;
    }

    @StepGroup
    public CreateAccountPage clickOnPasswordMappingLink(MappingLink icon) {
        switch (icon) {
            case HIDE:
                passwordMappingLinkHide.click();
                return this;
            case SHOW:
                passwordMappingLinkShow.click();
                return this;
            default:
                org.junit.Assert.fail("Unknown icon " + icon + "!");
        }
        return null;
    }

    @StepGroup
    public boolean displayedPasswordMappingLink(MappingLink icon) {
        switch (icon) {
            case HIDE:
                return passwordMappingLinkHide.isDisplayed();
            case SHOW:
                return passwordMappingLinkShow.isDisplayed();
            default:
                org.junit.Assert.fail("Unknown icon " + icon + "!");
        }
        return false;
    }

    @StepGroup
    public PopupsBlock clickOnAgeField() {
        yearDropDownMenu.getWrappedElement().click();
        return on(PopupsBlock.class);
    }

    @StepGroup
    public FinishForm clickOnCreateAccountButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return createAccountButton.isEnabled();
                }
            });
        } catch (Exception ex) {
            Assert.fail("Create account button is disabled\n" + ex);
        }
        createAccountButton.click();
        return on(FinishForm.class);
    }

    @StepGroup
    public boolean createAccountButtonState() {
        return createAccountButton.isEnabled();
    }

    @StepGroup
    public TosRusPage clickOnTOSLink() {
        tosRusLink.click();
        return on(TosRusPage.class);
    }

    @StepGroup
    public PrivacyRusPage clickOnPrivacyLink() {
        privacyRusLink.click();
        return on(PrivacyRusPage.class);
    }

}
