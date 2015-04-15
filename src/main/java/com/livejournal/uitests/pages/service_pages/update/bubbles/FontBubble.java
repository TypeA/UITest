/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.PostContentBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".b-bubble-font"))
public class FontBubble extends UIBlock {
    @FindBy(css = ".b-fontsize-select-item-tiny")
    private Button tinyFontText;

    @FindBy(css = ".b-fontsize-select-item-small")
    private Button smallFontText;

    @FindBy(css = ".b-fontsize-select-item-normal")
    private Button normalFontText;

    @FindBy(css = ".b-fontsize-select-item-large")
    private Button largeFontText;
    
    @FindBy(css = ".b-fontsize-select-item-huge")
    private Button hugeFontText;
    
    
    public PostContentBlock setTextFont(String font_text) {
        
        switch (font_text) {
            case "TINY":
                tinyFontText.click();
                break;
            case "SMALL":
                smallFontText.click();
                break;
            case "NORMAL":
                normalFontText.click();
                break;
            case "LARGE":
                largeFontText.click();
                break;
            case "HUGE":
                hugeFontText.click();
                break;
        }
        return onDisplayed(PostContentBlock.class);
    }
    
}
