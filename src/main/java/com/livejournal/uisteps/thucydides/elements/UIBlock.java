package com.livejournal.uisteps.thucydides.elements;

import com.livejournal.uisteps.thucydides.UIActions;
import com.livejournal.uisteps.core.BaseUIBlock;
import com.livejournal.uisteps.core.UIContainer;
import com.livejournal.uisteps.thucydides.UIContainerInitializer;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 *
 * @author ASolyankin
 */
public class UIBlock extends HtmlElement implements BaseUIBlock {

    private final UIContainerInitializer initializer;
    private final UIActions actions;

    public UIBlock() {
        initializer = new UIContainerInitializer();
        actions = new UIActions();
    }

    @Override
    public void initElements(WebDriver driver) {
        initializer.initializeUIContainer(this, driver);
    }

    @Override
    public void callMethodsWhenOpens() {
        initializer.callMethodsWhenOpens(this);
    }

    protected <T extends UIContainer> T on(Class<T> UIContainerClass) {
        return actions.on(UIContainerClass);
    }

    protected <T extends UIContainer> T on(T uiContainer) {
        return actions.on(uiContainer);
    }

    @Override
    public void click() {
        actions.click(this);
    }

    public void moveMouseOver() {
        actions.moveMouseOver(this);
    }
}
