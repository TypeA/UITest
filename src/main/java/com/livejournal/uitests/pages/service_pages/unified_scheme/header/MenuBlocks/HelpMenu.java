package com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.search.SearchPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.AboutMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.DMCAPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.FaqMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.PrivacyRusPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.SupportMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.TosRusPageUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
@FindBy(css = ".s-nav-item-help .s-drop")
public class HelpMenu extends UIBlock {

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-support")
    private Link help;

    @FindBy(css = ".s-nav-item-about")
    private Link about;

    @FindBy(css = ".s-nav-item-faq")
    private Link faq;

    @FindBy(css = ".s-nav-item-legal")
    private Link tos;

    @FindBy(css = ".s-nav-item-privacy")
    private Link privacy;

    @FindBy(css = ".s-nav-item-dmca")
    private Link dmca;

    @FindBy(css = ".s-nav-item-search #SearchText")
    private TextField searchLine;

    @StepGroup
    public SupportMainPageUnlogged clickOnHelp() {
        help.click();
        return on(SupportMainPageUnlogged.class);
    }

    @StepGroup
    public AboutMainPageUnlogged clickOnAbout() {
        about.click();
        return on(AboutMainPageUnlogged.class);
    }

    @StepGroup
    public FaqMainPageUnlogged clickOnFaq() {
        faq.click();
        return on(FaqMainPageUnlogged.class);
    }

    @StepGroup
    public TosRusPageUnlogged clickOnTos() {
        tos.click();
        return on(TosRusPageUnlogged.class);
    }

    @StepGroup
    public PrivacyRusPageUnlogged clickOnPrivacy() {
        privacy.click();
        return on(PrivacyRusPageUnlogged.class);
    }

    @StepGroup
    public DMCAPageUnlogged clickOnDmca() {
        dmca.click();
        return on(DMCAPageUnlogged.class);
    }

    @StepGroup
    public SearchPageUnlogged search(String text) {
        searchLine.enter(text);
        Actions actions = new Actions(this.getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        return on(SearchPageUnlogged.class);
    }
}
