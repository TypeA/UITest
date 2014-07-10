/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.jetty.html.Select;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".js-select-date"))
public class BirthDateForm extends UIBlock{
    @FindBy(id = "day")
    public Select dayDropDownMenu;
    
    @FindBy(id = "month")
    public Select monthDropDownMenu;
    
    @FindBy(id = "year")
    public Select yearDropDownMenu;
    
}
