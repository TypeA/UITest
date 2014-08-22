package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-createpage-input-password"))
public class PasswordBlock extends UIBlock {

    @FindBy(css = "#password")
    private TextField passwordField;

    @FindBy(css = ".b-passview-icon-show")
    private Link passwordMappingLinkShow;

    @FindBy(css = ".b-passview-icon-hide")
    private Link passwordMappingLinkHide;

    public TextField getPasswordField() {
        return elem(passwordField);
    }

    public Link getPasswordMappingLinkShow() {
        return elem(passwordMappingLinkShow);
    }

    public Link getPasswordMappingLinkHide() {
        return elem(passwordMappingLinkHide);
    }

}
