/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.update.visualEditor;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.PostContentBlock;
import com.livejournal.uitests.pages.service_pages.update.bubbles.ColorBubble;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LinkBubble;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".cke_toolbar"))
public class HtmlsTags extends UIBlock {

    @FindBy(css = ".cke_button_LJColor")
    private Button color;

    @FindBy(css = ".cke_button_LJFont")
    private Button fontText;
    
    @FindBy(css = ".cke_button_bold")
    private Button boldText;

    @FindBy(css = ".cke_button_italic")
    private Button italicText;

    @FindBy(css = ".cke_button_underline")
    private Button underlineText;
    
    @FindBy(css = ".cke_button_LJLink2")
    private Button link;
    

    @StepGroup
    public PostContentBlock setTextStyle(String style_text) {
        switch (style_text) {
            case "BOLD":
                boldText.click();
                break;
            case "ITALIC":
                italicText.click();
                break;
            case "UNDERLINED":
                underlineText.click();
                break;
        }
        return onDisplayed(PostContentBlock.class);
    }

    public HtmlsTags clickFont() {
        fontText.click();
        return onDisplayed(HtmlsTags.class);
    }

    public ColorBubble clickColor() {
        color.click();
        return onDisplayed(ColorBubble.class);
    }
    
    public LinkBubble clickLink() {
        link.click();
        return onDisplayed(LinkBubble.class);
    }
}
