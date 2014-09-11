package com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.UnderageAccountPage;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
public class UnsuccessfulFinishForm extends FinishForm {

    @FindBy(css = "a[href*='/faq/224.html']")
    private Link underageAccount;

    @FindBy(css = ".b-createpage-nextsteps a:not([href*='/faq'])")
    private Link ljAnonymously;

    public UnderageAccountPage clickOnUnderageAccountLink() {
        underageAccount.click();
        return on(UnderageAccountPage.class);
    }

    public MainPageUnlogged clickOnLjAnonymouslyLink() {
        ljAnonymously.click();
        return on(MainPageUnlogged.class);
    }

}
