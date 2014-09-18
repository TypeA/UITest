package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks.MyJournalMenu;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-item-user"))
public class MyJournalMenuItem extends UIBlock {

    @FindBy(css = "label[for='s-nav-body-user'] .s-userpic")
    public Link userPic;

    @FindBy(css = ".s-nav-rootlink-blog")
    public Link myJournal;

    @StepGroup
    public MyJournalMenu moveMouseOverUserPic() {
        userPic.moveMouseOver();
        return on(MyJournalMenu.class);
    }

    @StepGroup
    public MyJournalMenu moveMouseMyJournal() {
        myJournal.moveMouseOver();
        return on(MyJournalMenu.class);
    }
}
