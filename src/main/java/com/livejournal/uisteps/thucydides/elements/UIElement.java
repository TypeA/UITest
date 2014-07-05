package com.livejournal.uisteps.thucydides.elements;

import com.livejournal.uisteps.thucydides.UIActions;
import com.livejournal.uisteps.core.UIContainer;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 *
 * @author ASolyankin
 */
public class UIElement extends TypifiedElement {

    private final UIActions actions;

    public UIElement(WebElement wrappedElement) {
        super(wrappedElement);
        actions = new UIActions();
    }

    protected <T extends UIContainer> T on(Class<T> UIContainerClass) {
        return actions.on(UIContainerClass);
    }

    protected <T extends UIContainer> T on(T uiContainer) {
        return actions.on(uiContainer);
    }

    public void click() {
        actions.click(this);
    }

    public void moveMouseOver() {
        actions.moveMouseOver(this);
    }
    
    protected UIActions getActions() {
        return actions;
    }
}
