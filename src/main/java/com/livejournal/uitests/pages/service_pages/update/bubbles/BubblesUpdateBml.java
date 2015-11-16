package com.livejournal.uitests.pages.service_pages.update.bubbles;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.panferova
 */
@Block(
        @FindBy(css = ".p-openpopup"))
public class BubblesUpdateBml extends UIBlock {
    
    @StepGroup
    public ColorBubble openColorBubble() {
        return new ColorBubble();
    }
    
    @StepGroup
    public LinkBubble openLinkBubble() {
        return new LinkBubble();
    }
    
    @StepGroup
    public LJUserBubble openLJUserBubble() {
        return new LJUserBubble();
    }
    
    @StepGroup
    public FontBubble openFontBubble() {
        return new FontBubble();
    }
    
    @FindBy(css = ".b-colorpicker-controls-hex")
    private TextField codeColor;
    
    @FindBy(css = "button.b-flatbutton[ng-click='submitColor()']")
    private Button chooseColorButton;
    
    @Block(
            @FindBy(css = ".b-bubble-color"))
    public class ColorBubble extends UIBlock {
        
        public void setTextColor(String color) {
            codeColor.enter(color);
            chooseColorButton.click();
        }
    }
    
    @FindBy(css = ".b-updateform-bubble-input")
    private TextField inputUrl;
    
    @FindBy(css = ".b-updateform-bubble-checkbox")
    private Button checkboxNewWindow;
    
    @FindBy(xpath = "//button[@class='b-flatbutton b-flatbutton-simple  ng-binding' and @lj-disabled[contains(.,'link')]]")
    private Button addButtonLink;
    
    @Block(
            @FindBy(css = ".b-bubble-link"))
    public class LinkBubble extends UIBlock {
        
        @StepGroup
        public void addLink(String url, Boolean newWindow) {
            inputUrl.enter(url);
            if (newWindow) {
                checkboxNewWindow.click();
            }
            addButtonLink.click();
        }
    }
    
    @FindBy(css = ".b-updateform-bubble-input-wrapper.b-updateform-bubble-input-username input")
    private TextField username;
    
    @Block(
            @FindBy(css = ".b-bubble-user"))
    public class LJUserBubble extends UIBlock {
        
        @StepGroup
        public void enterUsername(String ljuser, Boolean isCorrectUser) {
            username.enter(ljuser);
            startScript("jQuery('.b-updateform-bubble-user-button .b-flatbutton-simple').click()");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BubblesUpdateBml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @StepGroup
        public void enterUsernameUsingAutocomplete(String ljuser) {
            String ljuserCutted = ljuser.substring(0, 3);
            username.enter(ljuserCutted);
            boolean flag = true;
            int i = 0;
            while (flag) {
                if (i < 10) {
                    username.sendKeys(Keys.ARROW_DOWN);
                    i++;
                    if (startScript("return jQuery('.ui-autocomplete .ui-state-hover').text()").equals(ljuser)) {
                        username.sendKeys(Keys.ENTER);
                        flag = false;
                    } else {
                        ljuserCutted = ljuser.substring(0, ljuserCutted.length() + 1);
                        username.enter(ljuserCutted);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BubblesUpdateBml.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
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
    
    @Block(
            @FindBy(css = ".b-bubble-font"))
    public class FontBubble extends UIBlock {
        
        public void setTextFont(String font_text) {
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
                default:
                    Assert.fail("Incorrect text font " + font_text);
            }
        }
    }
}
