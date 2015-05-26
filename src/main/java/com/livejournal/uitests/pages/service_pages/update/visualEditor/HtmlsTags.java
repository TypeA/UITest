package com.livejournal.uitests.pages.service_pages.update.visualEditor;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.bubbles.ColorBubble;
import com.livejournal.uitests.pages.service_pages.update.bubbles.FontBubble;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LinkBubble;
import com.livejournal.uitests.pages.service_pages.update.forms_and_blocks.PostContentBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private Button button;

    @StepGroup
    public PostContentBlock setTextStyle(String style_text) {

        switch (style_text) {
            case "b":
                button = boldText;
                break;
            case "i":
                button = italicText;
                break;
            case "u":
                button = underlineText;
                break;
        }
        button.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return button.getWrappedElement().getAttribute("aria-pressed").equals("true");
            }
        });

        return onDisplayed(PostContentBlock.class);
    }

    public void setTextFont(String font_text) {
        fontText.click();
        onDisplayed(FontBubble.class).setTextFont(font_text);

    }

    public void setTextColor(String color_text) {
        color.click();
        onDisplayed(ColorBubble.class)
                .setTextColor(color_text);
    }

    public void addLink(String link_text, Boolean new_window) {
        link.click();
        onDisplayed(LinkBubble.class).addLink(link_text, new_window);
    }
}
