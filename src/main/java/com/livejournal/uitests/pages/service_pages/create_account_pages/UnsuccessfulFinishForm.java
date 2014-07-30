package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
public class UnsuccessfulFinishForm extends FinishForm {

    @FindBy(css = "a[href*='/faq/']")
    private Link reference;

    @FindBy(css = ".b-createpage-nextsteps a:not([href*='/faq'])")
    private Link ljAnonymously;

    public Link getReference() {
        return elem(reference);
    }

    public Link getLjAnonymously() {
        return elem(ljAnonymously);
    }

}
