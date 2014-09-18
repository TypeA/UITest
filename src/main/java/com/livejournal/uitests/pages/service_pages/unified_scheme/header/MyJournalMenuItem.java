package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = ".s-nav-item-user"))
public class MyJournalMenuItem {

    @FindBy(css = "label[for='s-nav-body-user'] .s-userpic")
    public Link userPic;

    @FindBy(css = ".s-nav-rootlink-blog")
    public Link myJournal;

}
