package com.livejournal.uitests.pages.journal_pages.entry;

import com.livejournal.uitests.pages.journal_pages.JournalPageLogged;
import java.io.IOException;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class EntryPageLogged extends JournalPageLogged {

    @StepGroup
    public EntryPageBlock Entry() {
        return onDisplayed(EntryPageBlock.class);
    }

    @StepGroup
    public String getIdPost(String user) throws IOException {
        return getDriver().getCurrentUrl().replace("http://" + user.replace("_", "-") + "." + getSystemConfiguration().getBaseUrl() + "/", "");
    }

    public Boolean postWithImageIsDisplayed(String photoUrl, String link, String size) {
        String xpath = "//article[@class[contains(.,'entry-content')]]";
        if (link.length() > 0) {
            xpath = xpath + "/a[@href[contains(.,'" + link + "')]]";
        }
        xpath = xpath + "/img[@src[contains(.,'" + photoUrl + "')]";
        if (size.length() > 0 && !size.equals("Original")) {
            xpath = xpath + " and @width[contains(.,'" + size + "')]]";
        } else {
            xpath = xpath + "]";
        }
        return getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

}
