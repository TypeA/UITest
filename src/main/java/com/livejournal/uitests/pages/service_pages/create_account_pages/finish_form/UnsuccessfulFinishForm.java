package com.livejournal.uitests.pages.service_pages.create_account_pages.finish_form;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.UnderageAccountPageUnlogged;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-panel-step2"))
public class UnsuccessfulFinishForm extends FinishForm {

    @FindBy(css = "a[href*='/support/faq/244']")
    private Link underageAccount;

    @FindBy(css = ".b-createpage-nextsteps a:not([href*='/faq'])")
    private Link ljAnonymously;

    public UnderageAccountPageUnlogged clickOnUnderageAccountLink() {
        underageAccount.click();
        return onOpened(UnderageAccountPageUnlogged.class);
    }

    public MainPageUnlogged clickOnLjAnonymouslyLink() {
        ljAnonymously.click();
        return onOpened(MainPageUnlogged.class);
    }

    @WhenPageOpens
    public void waitBlock() throws InterruptedException {
        Thread.sleep(1500);
    }

}
