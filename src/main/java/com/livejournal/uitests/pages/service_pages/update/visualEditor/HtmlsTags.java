package com.livejournal.uitests.pages.service_pages.update.visualEditor;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.ColorBubble;
import com.livejournal.uitests.pages.service_pages.update.bubbles.FontBubble;
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
    public UpdateBmlPageLogged setTextStyle(String style_text) {
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
        return onOpened(UpdateBmlPageLogged.class);
    }

    public UpdateBmlPageLogged setTextFont(String font_text) {
        fontText.click();
        return onDisplayed(FontBubble.class).setTextFont(font_text);

    }

    public UpdateBmlPageLogged setTextColor(String color_text) {
        color.click();
        return onDisplayed(ColorBubble.class)
                .setTextColor(color_text);
    }

    public UpdateBmlPageLogged addLink(String link_text, Boolean new_window) {
        link.click();
        return onDisplayed(LinkBubble.class).addLink(link_text, new_window);
    }
}
