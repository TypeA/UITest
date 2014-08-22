package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

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

}
