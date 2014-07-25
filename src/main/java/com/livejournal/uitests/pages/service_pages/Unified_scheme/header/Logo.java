package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = "body"))
public class Logo extends UIBlock {

    @FindBy(xpath = ".//div[@class='s-logo']/a")
    private Link LogoPic;

    @FindBy(xpath = ".//div[@class='s-logo']/sup/a")
    private Link TestPic;

    public Link getLogoPic() {
        return LogoPic;
    }

    public Link getTestPic() {
        return TestPic;
    }

}
