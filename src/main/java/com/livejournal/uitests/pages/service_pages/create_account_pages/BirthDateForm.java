/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.create_account_pages;


import com.livejournal.uitests.pages.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".js-select-date"))
public class BirthDateForm extends UIBlock{
    @FindBy(id = "day")
    private Select dayDropDownMenu;
    
    @FindBy(id = "month")
    private Select monthDropDownMenu;
    
    @FindBy(id = "year")
    private Select yearDropDownMenu;

    /**
     * @return the dayDropDownMenu
     */
    public Select getDayDropDownMenu() {
        return elem(dayDropDownMenu);
    }

    /**
     * @return the monthDropDownMenu
     */
    public Select getMonthDropDownMenu() {
        return elem(monthDropDownMenu);
    }

    /**
     * @return the yearDropDownMenu
     */
    public Select getYearDropDownMenu() {
        return elem(yearDropDownMenu);
    }
    
}
