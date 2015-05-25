/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.update.htmlEditor;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LJUserBubble;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".b-updateform-bar"))
public class LJTags extends UIBlock {

    @FindBy(css = ".b-updateform-button.b-updateform-button-user")
    private Link ljUserButton;

    private LJUserBubble ljUserBubble;

    @StepGroup
    public UpdateBmlPageLogged enterUsername(String ljuser, Boolean isCorrectUser) {
        ljUserButton.click();
        return ljUserBubble.enterUsername(ljuser, isCorrectUser);
    }

}
