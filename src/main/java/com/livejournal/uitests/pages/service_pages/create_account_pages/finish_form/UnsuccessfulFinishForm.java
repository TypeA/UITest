package com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.UnderageAccountPageUnlogged;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
public class UnsuccessfulFinishForm extends FinishForm {

    @FindBy(css = "a[href*='/support/faq/244']")
    private Link underageAccount;

    @FindBy(css = ".b-createpage-nextsteps a:not([href*='/faq'])")
    private Link ljAnonymously;

    public UnderageAccountPageUnlogged clickOnUnderageAccountLink() {
        underageAccount.click();
        return on(UnderageAccountPageUnlogged.class);
    }

    public MainPageUnlogged clickOnLjAnonymouslyLink() {
        ljAnonymously.click();
        return on(MainPageUnlogged.class);
    }

}
