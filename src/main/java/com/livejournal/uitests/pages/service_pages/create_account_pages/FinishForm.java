/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-panel-step2"))
public class FinishForm extends UIBlock{
    
    // тут надо вставить все ссылочки, которые есть 
    // на форме удачного создания аккаунта
    
    @FindBy(id = "createpage_post")
    public Button createFirstPostButton;
    
    @FindBy(css = ".b-createpage-welcome")
    public WebElement finishText;
    
    // тут надо вставить все ссылочки, которые есть 
    // на форме неудачного создания аккаунта (меньше 13) 
    
    
    
}
