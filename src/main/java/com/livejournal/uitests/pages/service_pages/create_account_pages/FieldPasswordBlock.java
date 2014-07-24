/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-passview"))
public class FieldPasswordBlock extends UIBlock {

    @FindBy(id = "password")
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
