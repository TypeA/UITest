package com.livejournal.uitests.pages.journal_pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class MyJournalPage extends JournalPage {

    public EntryPage openPostByText(String text) {
        System.out.println("!!!!!!!!! " + "jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        startScript("jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        return onOpened(EntryPage.class);
    }

    public Boolean checkWorkLJCut(String text) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
//        wait.until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                return false;
//            }
//        });
        Boolean beforeClick = startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") div').attr('style')").equals("display: none;");
        startScript("jQuery('.entryunit__text:contains(\"" + text + "\") a').click()");
        Boolean afterClick = startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") div').attr('style')").equals("display: block;");
        return beforeClick && afterClick;
    }

}
