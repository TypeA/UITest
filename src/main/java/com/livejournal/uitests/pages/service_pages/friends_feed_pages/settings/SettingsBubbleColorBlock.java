package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-bubble-color"))
public class SettingsBubbleColorBlock extends UIBlock {

    @FindBy(css = "div .b-color-selector")
    private UIElement colorSelector;

    @FindBy(css = "div .b-color-selector-bar")
    private UIElement colorSelectorBar;

    @FindBy(css = "dd[ng-style*='newColor']")
    private UIElement newColor;

    @FindBy(css = "div .b-colorpicker-controls-current")
    private UIElement currentColor;

    @FindBy(css = ".b-colorpicker-controls-hex")
    private TextField colorHex;

    @FindBy(css = ".b-flatbutton-simple[lj-ml*='choose']")
    private Button chooseButton;

    public synchronized SettingsBubbleColorBlock enterCode(CharSequence... text) {
        colorHex.enter(text);
        return this;
     //   return on(SettingsBubbleColorBlock.class);
    }

    public synchronized String getCode() {
        return colorHex.getWrappedElement().getAttribute("value");
    }

    public synchronized SettingsBlock clickChooseButton() {
        chooseButton.click();
        return on(SettingsBlock.class);
    }

    public synchronized SettingsBubbleColorBlock setColorBarByPoint(int barY) {
        colorSelectorBar.clickOnPoint(1, barY);
        return this;
    //    return on(SettingsBubbleColorBlock.class);
    }

    public synchronized SettingsBubbleColorBlock setColorByPoint(int colorX, int colorY) {
        colorSelector.clickOnPoint(colorX, colorY);
        return this;
   //     return on(SettingsBubbleColorBlock.class);
    }

    public synchronized SettingsBubbleColorBlock setCurrentColor() {
        currentColor.click();
        return this;
  //      return on(SettingsBubbleColorBlock.class);
    }

    public synchronized String getCurrentColor() {
        return currentColor.getWrappedElement().getAttribute("style");
    }

    public synchronized String getNewColor() {
        return newColor.getWrappedElement().getAttribute("style");
    }

    public synchronized void setColor(ColorSelectType type, String code, int barY, int colorX, int colorY) {
        switch (type) {
            case BY_POINT:
                setColorBarByPoint(barY)
                        .setColorByPoint(colorX, colorY)
                        .clickChooseButton();
                break;
            case BY_CODE:
                enterCode(code)
                        .clickChooseButton();
                break;
            default:
                Assert.fail("Incorrect color selector type " + type + "!");
        }
    }

}
