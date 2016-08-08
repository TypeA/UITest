package com.livejournal.uitests.pages.service_pages.error_strip;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".b-msgsystem-type-error"))
public class ErrorStrip extends UIBlock {

    @FindBy(css = ".b-msgsystem-wrap")
    private UIBlock errorStrip;

    @FindBy(css = ".b-msgsystem-close span")
    private Button closeErrorButton;
    
    @StepGroup
    public String getErrorText(){
       WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return errorStrip.isDisplayed();
            }
        });
        return startScript("return jQuery('.b-msgsystem-body')[0].textContent").toString();
    }

    public void doClose() {
        closeErrorButton.click();
    }

}
