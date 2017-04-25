package com.livejournal.uitests.pages.journal_pages.journal;

import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.journal_pages.JournalPageLogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/")
public class MyJournalPageLogged extends JournalPageLogged {

    @FindBy(css = ".flaticon--arrow-bottom-bold")
    private UIBlock cutArrow;

    public EntryPageLogged openPostByText(String text) {
        startScript("jQuery('.entryunit:contains(\"" + text + "\") .entryunit__head .entryunit__title a')[0].click()");
        return onOpened(EntryPageLogged.class);
    }

    @StepGroup
    public String getTextFromLJCut(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                ArrayList<WebElement> entries = new ArrayList<WebElement>();
                entries = (ArrayList<WebElement>) getDriver().findElements(By.cssSelector(".entryunit"));
                return !entries.isEmpty();
            }
        });
        startScript("jQuery('.entryunit__text:contains(\"" + text + "\") b a').click()");
        WebElement expandedCut = null;
        int i = 0;
        while ((i < 30) && (expandedCut == null)) try {
            Thread.sleep(100);
            expandedCut = (WebElement) getDriver().findElements(By.cssSelector(".entryunit"));
        } catch (Exception e) {
            i++;
        }
        return startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") div').text().trim()").toString();

    }

    @StepGroup
    public String getLJCutCustomText(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                ArrayList<WebElement> entries = new ArrayList<WebElement>();
                entries = (ArrayList<WebElement>) getDriver().findElements(By.cssSelector(".entryunit"));
                return !entries.isEmpty();
            }
        });
        return startScript("return jQuery('.entryunit__text:contains(\"" + text + "\") b a').attr('title')").toString();

    }

}
