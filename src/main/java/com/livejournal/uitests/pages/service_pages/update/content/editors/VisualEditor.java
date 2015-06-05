package com.livejournal.uitests.pages.service_pages.update.content.editors;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.pages.service_pages.update.bubbles.BubblesUpdateBml;
import com.livejournal.uitests.pages.service_pages.update.content.AdditionalContent;
import com.livejournal.uitests.pages.service_pages.update.content.PostContentBlock;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
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
        @FindBy(css = ".b-updatepage-event"))
public class VisualEditor extends UIBlock {

    @FindBy(css = ".b-updatepage-tab-visual")
    public Button visualEditButton;

    @FindBy(css = "body[class=lj-main-body]")
    public TextField postVisualField;

    @FindBy(css = ".cke_button_LJColor")
    private OpenBubbleButton color;

    @FindBy(css = ".cke_button_LJFont")
    private OpenBubbleButton fontText;

    @FindBy(css = ".cke_button_bold")
    private Button boldText;

    @FindBy(css = ".cke_button_italic")
    private Button italicText;

    @FindBy(css = ".cke_button_underline")
    private Button underlineText;

    @FindBy(css = ".cke_button_LJLink2")
    private OpenBubbleButton link;

    private Button button;

    @StepGroup
    public VisualEditor setPostText(String text) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title[contains(.,'Rich text editor')]]")));
        getDriver().findElement(By.xpath("//body[@class='lj-main-body']")).sendKeys(text);;
        getDriver().switchTo().defaultContent();
        return this;
    }

    @WhenPageOpens
    public void switchToVisualEditor() {
        visualEditButton.click();
    }

    @StepGroup
    public VisualEditor setTextStyle(String style_text) {
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
        return this;
    }

    public VisualEditor setTextFont(String font_text) {
        fontText.click().openFontBubble().setTextFont(font_text);
        return this;
    }

    public VisualEditor setTextColor(String color_text) {
        color.click().openColorBubble().setTextColor(color_text);
        return this;
    }

    public VisualEditor addLink(String link_text, Boolean new_window) {
        link.click().openLinkBubble().addLink(link_text, new_window);
        return this;
    }

    public PostContentBlock usePostContent() {
        return onDisplayed(PostContentBlock.class);
    }

    public AdditionalContent useAdditionalContent() {
        return onDisplayed(AdditionalContent.class);
    }

    public UpdateBmlPageLogged usePage() {
        return onOpened(UpdateBmlPageLogged.class);
    }

    public EditJournalBml useEditingPage() {
        return onOpened(EditJournalBml.class);
    }

    public static class OpenBubbleButton extends Button {

        public OpenBubbleButton(WebElement wrappedElement) {
            super(wrappedElement);
        }

        @Override
        public BubblesUpdateBml click() {
            super.click();
            return onDisplayed(BubblesUpdateBml.class);
        }

    }

}
