package com.livejournal.uisteps.thucydides;

import com.livejournal.uisteps.core.TestActions;
import com.livejournal.uisteps.core.UIContainer;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsElement;

/**
 *
 * @author ASolyankin
 */
public class UIActions {

    private TestActions testActions;

    public void setTestActions(TestActions actions) {
        this.testActions = actions;
    }

    public <T extends UIContainer> T on(Class<T> UIContainerClass) {
        return testActions.on(UIContainerClass);
    }

    public <T extends UIContainer> T on(T uiContainer) {
        return testActions.on(uiContainer);
    }

    public <T extends UIContainer> T on(Class<T> rootClass, String uiContainerClassName) {
        return testActions.on(rootClass, uiContainerClassName);
    }

    @Step
    public void click(WrapsElement element) {
        element.getWrappedElement().click();
    }

    @Step
    public void moveMouseOver(WrapsElement element) {
        Actions actions = new Actions(testActions.getCurrentBrowser().getDriver());
        actions.moveToElement(element.getWrappedElement()).build().perform();
    }

    @Step
    public void typeInto(WrapsElement input, CharSequence... keys) {
        input.getWrappedElement().sendKeys(keys);
    }

    @Step
    public void clear(WrapsElement input) {
        input.getWrappedElement().clear();
    }

    @Step
    public void enterInto(WrapsElement input, CharSequence... text) {
        input.getWrappedElement().clear();
        input.getWrappedElement().sendKeys(text);
    }

    public String getTextFrom(WrapsElement input) {
        return input.getWrappedElement().getText();
    }
}
