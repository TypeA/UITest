package com.livejournal.uitests.pages.service_pages.error_strip;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".b-msgsystem-type-error"))
public class ErrorStrip extends UIBlock {

    @StepGroup
    public String getErrorText() {
        return startScript("return jQuery('.b-msgsystem-body')[0].textContent").toString();
    }

}
