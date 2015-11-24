package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class MyJournalPage extends JournalPage {

    @FindBy(css = ".flaticon--arrow-bottom-bold")
    private UIBlock cutArrow;

    public EntryPage openPostByText(String text) {
        System.out.println("!!!!!!!!! " + "jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        startScript("jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        return onOpened(EntryPage.class);
    }

    @StepGroup
    public String getTextFromLJCut(String text) {
        startScript("jQuery('.entryunit__text:contains(\"" + text + "\") .ljcut-decor a').click()");
        return startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") div').text().trim()").toString();

    }

    @StepGroup
    public String getLJCutCustomText(String text) {
        return startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") .ljcut-link-expand').attr('title')").toString();

    }

}
